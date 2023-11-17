module com.zj.sc {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
//    requires easyexcel.core;
    requires lombok;
    requires cn.hutool.core;
    requires cn.hutool.poi;
//    requires com.google.common;
    requires fastjson;
    requires java.sql;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
//    requires xmlbeans;

    opens com.zj.sc.huarun;
    opens com.zj.sc to javafx.fxml,fastjson;

    exports com.zj.sc;
}
