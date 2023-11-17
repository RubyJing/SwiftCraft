package com.zj.sc.huarun;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class IoConfigUtils {

//    private static String BASE_PATH = "D:\\data\\润英441881P01_点表映射模板";
//
//    private static final String INPUT_PATH = BASE_PATH + ".xlsx";
//    private static final String OUTPUT_TEMPLATE_PATH = BASE_PATH + "_输出.xlsx";


    private static final String[] headers = new String[]{"group", "name", "address", "attribute", "type", "description", "precision", "decimal", "value"};
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(IoConfigUtils.class);

    public static String execute(String basePath) throws Exception {
        if (basePath.endsWith(".xlsx")) {
            basePath = basePath.substring(0, basePath.lastIndexOf(".xlsx"));
        }
        String BASE_PATH = basePath;
        String INPUT_PATH = BASE_PATH + ".xlsx";
        String OUTPUT_TEMPLATE_PATH = BASE_PATH + "_输出.xlsx";

        //先删除过去生成的数据
        FileUtil.del(OUTPUT_TEMPLATE_PATH);
        FileUtil.del(BASE_PATH);

        // 创建输出文件.xlsx，并写入表头
        createOutTemplateFile(OUTPUT_TEMPLATE_PATH);


        //先读input_path，从第一个sheet开始读起判定有几个端口，拷贝几个模板，并追加重命名
        ExcelReader reader = ExcelUtil.getReader(INPUT_PATH, 0);
        //读取数据
        List<List<Object>> datas = reader.read(1, reader.getRowCount());
        if (isEmpty(datas)) {
            return BASE_PATH;
        }
        List<IoConfigEntity> entities = datas.stream().map(IoConfigEntity::new).collect(Collectors.toList());

        //读场站编码
        String stationCode = entities.get(0).getStation_code().toString();
        // 按端口分组: key为端口号, value为该端口的所有点
        Map<Integer, List<IoConfigEntity>> portMap = new HashMap<>();
        for (IoConfigEntity entity : entities) {
            if (!portMap.containsKey(entity.getPort())) {
                portMap.put(entity.getPort(), new ArrayList<>());
            }
            portMap.get(entity.getPort()).add(entity);
        }

        // 标准io点map：key为model，value为该型号的所有点
        Map<String, List<StandardIoDTO>> standardIoMap = new HashMap<>();
        // 得到 点表映射模板 - 输出 - {场站编码} - {port}.xlsx
        Map<Integer, String> fileMap = new HashMap<>();

        // 遍历端口
        for (Map.Entry<Integer, List<IoConfigEntity>> entry : portMap.entrySet()) {
            Integer port = entry.getKey();

            //先创建文件
            String filePath = fileMap.get(port);
            if (StrUtil.isEmpty(filePath)) {
                filePath = BASE_PATH + File.separator + "点表映射模板 - 输出 - " + stationCode + " - " + port + ".xlsx";
                if (!FileUtil.exist(filePath)) {
                    FileUtil.copyFile(OUTPUT_TEMPLATE_PATH, filePath);
                    fileMap.put(port, filePath);
                }
            }

            //然后开始读取
            List<IoConfigEntity> entities1 = entry.getValue();
            for (IoConfigEntity entity : entities1) {
                //读取型号sheet
                String model = entity.getModel();
                List<StandardIoDTO> standardIos = standardIoMap.get(model);
                if (CollUtil.isEmpty(standardIos)) {
                    standardIos = new ArrayList<>();
                    // 读取模型model去除 ``符号
                    model = model.replace("`", "");
                    reader = ExcelUtil.getReader(INPUT_PATH, "point_" + model);
                    datas = reader.read();
                    if (CollUtil.isNotEmpty(datas)) {
                        for (int i = 1; i < datas.size(); i++) {
                            standardIos.add(new StandardIoDTO(datas.get(i)));
                        }
                        standardIoMap.put(model, standardIos);
                    }
                }

                //按设备开始复制
                List<IoOutputEntity> outputEntities = new ArrayList<>();
                for (StandardIoDTO standardIo : standardIos) {
                    outputEntities.add(new IoOutputEntity(standardIo, entity));
                }
                //还要再写几个点
                outputEntities.add(new IoOutputEntity(entity.getDevice_code(), "device_type", "Static", "STRING", entity.getDevice_type()));
                outputEntities.add(new IoOutputEntity(entity.getDevice_code(), "TimeUNIT", "Static", "STRING", entity.getTime_unit()));
                outputEntities.add(new IoOutputEntity(entity.getDevice_code(), "region_com_id", "Static", "STRING", getSingleQuotesString(entity.getRegion_com_id())));
                outputEntities.add(new IoOutputEntity(entity.getDevice_code(), "project_com_id", "Static", "STRING", getSingleQuotesString(entity.getProject_com_id())));
                outputEntities.add(new IoOutputEntity(entity.getDevice_code(), "maintenance_com_id", "Static", "STRING", getSingleQuotesString(entity.getMaintenance_com_id())));
                outputEntities.add(new IoOutputEntity(entity.getDevice_code(), "manufacturer", "Static", "STRING", entity.getManufacturer()));
                outputEntities.add(new IoOutputEntity(entity.getDevice_code(), "model", "Static", "STRING", getSingleQuotesString(entity.getModel())));
                outputEntities.add(new IoOutputEntity(entity.getDevice_code(), "line", "Static", "STRING", getSingleQuotesString(entity.getLine())));
                outputEntities.add(new IoOutputEntity(entity.getDevice_code(), "period", "Static", "STRING", getSingleQuotesString(entity.getPeriod())));

                ExcelWriter writer = ExcelUtil.getWriter(filePath);

                // 写入固定表头
                for (int i = 0; i < headers.length; i++) {
                    writer.writeCellValue(i, 0, headers[i]);
                }

                int rowCount = writer.getRowCount();
                List<EmqxJsonOutPut> emqxJsonOutPuts = new ArrayList<>();
                for (IoOutputEntity outputEntity : outputEntities) {
                    int colIndex = 0;
                    writer.writeCellValue(colIndex, rowCount, outputEntity.getGroup());
                    writer.writeCellValue(++colIndex, rowCount, outputEntity.getName());
                    writer.writeCellValue(++colIndex, rowCount, outputEntity.getAddress());
                    writer.writeCellValue(++colIndex, rowCount, outputEntity.getAttribute());
                    writer.writeCellValue(++colIndex, rowCount, outputEntity.getType());
                    writer.writeCellValue(++colIndex, rowCount, outputEntity.getDescription());
                    writer.writeCellValue(++colIndex, rowCount, outputEntity.getPrecision());
                    writer.writeCellValue(++colIndex, rowCount, outputEntity.getDecimal());
                    writer.writeCellValue(++colIndex, rowCount, outputEntity.getValue());
                    rowCount++;

                    // emqx json
                    String type = outputEntity.getType();
                    switch (type) {
                        case "BIT":
                        case "INT8":
                            type = "BOOLEAN";
                            break;
                        case "STRING":
                            type = "TEXT";
                            break;
                    }
                    emqxJsonOutPuts.add(new EmqxJsonOutPut(outputEntity.getName(), type));
                }
                writer.flush();
                writer.close();

                // 写入emqx json文件
                String emqxJsonPath = BASE_PATH + File.separator + "emqx-输出-" + stationCode + "-" + model + "-" + port + ".json";
                File emqxJsonFile = FileUtil.touch(emqxJsonPath);
                FileUtil.writeUtf8String(JSON.toJSONString(emqxJsonOutPuts), emqxJsonFile);
                log.info("====> {}写入完成", entity.getDevice_code());
            }
        }
        return BASE_PATH;
    }

    private static void createOutTemplateFile(String OUTPUT_TEMPLATE_PATH) {
        // 创建输出文件.xlsx，并写入表头
        FileUtil.touch(OUTPUT_TEMPLATE_PATH);
        // 创建一个新的 Excel 工作簿
        // 创建一个新的 Excel 工作簿
        Workbook workbook = new XSSFWorkbook();
        try {
            // 创建一个新的工作表
            workbook.createSheet("sheet1");

            // 将工作簿写入文件
            try (FileOutputStream fileOut = new FileOutputStream(OUTPUT_TEMPLATE_PATH)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createOutputFile(String content, String path) throws Exception {
        try {
            // 使用 Files.write 创建文件并写入内容
            Path outputPath = Paths.get(path);
            Files.write(outputPath, content.getBytes());

            System.out.println("输出文件创建成功：" + path);
        } catch (Exception e) {
            // 文件创建失败，抛出异常
            throw new Exception("无法创建输出文件：" + path, e);
        }
    }

    private static boolean isFileEmpty(String filePath) {
        long fileSize = Paths.get(filePath).toFile().length();
        return fileSize == 0;
    }

    /**
     * 获取单引号字符串
     *
     * @param value 值
     * @return 单引号字符串
     */
    private static String getSingleQuotesString(String value) {
        if (!value.startsWith("`") && !value.endsWith("`")) {
            value = "`" + value + "`";
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        execute("D:\\data\\朝阳421321W04-2404-WT_输入.xlsx");
    }

    public static final Map<String, String> attributeMap = new HashMap<String, String>() {{
        put("遥信", "Read");
        put("遥脉", "Read");
        put("遥测", "Read");
        put("遥调", "Write");
        put("遥控", "Write");
    }};


    public static final Map<String, String> typeMap = new HashMap<String, String>() {{
        put("遥信", "INT8");
        put("遥脉", "FLOAT");
        put("遥测", "FLOAT");
        put("遥调", "FLOAT");
        put("遥控", "INT8");
    }};

    public static final Map<String, String> startIndexMap = new HashMap<String, String>() {{
        put("遥信", "yxStart");
        put("遥测", "ycStart");
        put("遥脉", "ymStart");
        put("遥调", "ytStart");
        put("遥控", "ykStart");
    }};


    /**
     * 集合是否为空
     *
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
