package com.zj.sc;

import com.zj.sc.huarun.IoConfigUtils;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;



public class SwiftCraftApplication extends Application {

    public static void main(String[] args) {
//        IoConfigUtils.execute(args[0]);
//        SpringApplication.run(SwiftCraftApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Execution");

        // 创建文本输入框
        TextField filePathTextField = new TextField();
        filePathTextField.setPromptText("请输入文件路径...");

        // 创建文件选择器
        FileChooser fileChooser = new FileChooser();

        // 创建选择文件按钮
        Button chooseFileButton = new Button("选择文件");
        chooseFileButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                filePathTextField.setText(selectedFile.getAbsolutePath());
            }
        });

        // 创建执行按钮
        Button executeButton = new Button("执行");

        // 创建进度条
        ProgressBar progressBar = new ProgressBar();
        progressBar.setVisible(false);

        executeButton.setOnAction(e -> {
            String filePath = filePathTextField.getText();
            if (!filePath.isEmpty()) {
                executeTask(filePath, progressBar);
            } else {
                System.out.println("请先输入文件路径！");
            }
        });

        // 创建水平布局
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(chooseFileButton, executeButton);

        // 创建垂直布局
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(filePathTextField, buttonBox, progressBar);

        // 创建场景
        Scene scene = new Scene(layout, 400, 200);

        // 设置舞台的场景
        primaryStage.setScene(scene);

        // 显示舞台
        primaryStage.show();
    }

    private void executeTask(String filePath, ProgressBar progressBar) {


        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                updateProgress(30, 100);

                // 执行耗时任务
                String outputPath = IoConfigUtils.execute(filePath);
                // 模拟耗时操作
                updateProgress(100, 100);

                // 打开生成的文件夹路径
                openFileExplorer(outputPath);
                return null;
            }
        };

        // 绑定进度条的属性
        progressBar.progressProperty().bind(task.progressProperty());

        // 在任务完成后的操作
        task.setOnSucceeded(e -> {
            // 在这里添加执行后的逻辑，比如显示文件已生成的提示框
            displayFileGeneratedAlert();

        });

        // 在任务开始前的操作
        task.setOnRunning(e -> {
            // 隐藏进度条，显示反馈信息
            progressBar.setVisible(true);
            System.out.println("任务开始执行...");
        });

        // 在任务结束后的操作
        task.setOnFailed(e -> {
            // 隐藏进度条，显示反馈信息
            task.getException().printStackTrace();
            progressBar.setVisible(false);
            System.out.println("任务执行失败！");
        });

        new Thread(task).start();
    }

    // 模拟弹出文件已生成的提示框
    private static void displayFileGeneratedAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        alert.setHeaderText(null);
        alert.setContentText("文件已生成！");
        alert.showAndWait();
    }

    // 打开文件
    private static void openFileExplorer(String filePath) {
        String os = System.getProperty("os.name").toLowerCase();

        // 判断操作系统类型
        if (os.contains("win")) {
            // 如果是Windows系统，使用 explorer 命令打开资源管理器
            try {
                Runtime.getRuntime().exec("explorer.exe " + filePath);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("当前操作系统不支持打开资源管理器。");
            // 在这里添加在非Windows系统下的备用操作
        }
    }
}
