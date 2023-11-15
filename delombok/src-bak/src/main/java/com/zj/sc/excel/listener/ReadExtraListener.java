package com.zj.sc.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.List;
import java.util.function.Consumer;

/**
 * 监测设备读取额外信息监听器
 *
 * @author zhoujing
 * @version 1.0
 * @since 2023/8/16 10:08
 */
@Slf4j
public class ReadExtraListener<T> extends PageReadListener<T> implements ReadListener<T> {


    public ReadExtraListener(Consumer<List<T>> consumer) {
        super(consumer);
    }

    public ReadExtraListener(Consumer<List<T>> consumer, int batchCount) {
        super(consumer, batchCount);
    }

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {

    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        log.info("读取到了一条额外信息:{}", JSON.toJSONString(extra));
        switch (extra.getType()) {
            case COMMENT:
                log.info("额外信息是批注,在rowIndex:{},columnIndex;{},内容是:{}", extra.getRowIndex(), extra.getColumnIndex(),
                        extra.getText());
                break;
            case HYPERLINK:
                if ("Sheet1!A1".equals(extra.getText())) {
                    log.info("额外信息是超链接,在rowIndex:{},columnIndex;{},内容是:{}", extra.getRowIndex(),
                            extra.getColumnIndex(), extra.getText());
                } else if ("Sheet2!A1".equals(extra.getText())) {
                    log.info(
                            "额外信息是超链接,而且覆盖了一个区间,在firstRowIndex:{},firstColumnIndex;{},lastRowIndex:{},lastColumnIndex:{},"
                                    + "内容是:{}",
                            extra.getFirstRowIndex(), extra.getFirstColumnIndex(), extra.getLastRowIndex(),
                            extra.getLastColumnIndex(), extra.getText());
                } else {
                    Assert.fail("Unknown hyperlink!");
                }
                break;
            case MERGE:
                log.info(
                        "额外信息是合并单元格,而且覆盖了一个区间,在firstRowIndex:{},firstColumnIndex;{},lastRowIndex:{},lastColumnIndex:{}",
                        extra.getFirstRowIndex(), extra.getFirstColumnIndex(), extra.getLastRowIndex(),
                        extra.getLastColumnIndex());
                break;
            default:
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
