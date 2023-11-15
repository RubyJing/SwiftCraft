module com.zj.sc {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires easyexcel.core;
    requires lombok;
    requires cn.hutool;
//    requires com.google.common;
    requires fastjson;
    requires java.sql;
//    requires xmlbeans;

    opens com.zj.sc.huarun;
    opens com.zj.sc to javafx.fxml,cn.hutool,fastjson;

    exports com.zj.sc;
}
