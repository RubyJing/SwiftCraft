module com.zj.sc {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires org.slf4j;
    requires easyexcel.core;
    requires lombok;
    requires cn.hutool;
    requires com.google.common;
    requires fastjson;
    requires spring.context;
    requires java.sql;
    requires xmlbeans;
    requires junit;

    opens com.zj.sc.huarun;
    opens com.zj.sc to javafx.fxml,cn.hutool,fastjson;

    exports com.zj.sc;
}
