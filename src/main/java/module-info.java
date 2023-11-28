module by.me.fm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens by.me.fm to javafx.fxml;
    exports by.me.fm;
    exports by.me.fm.controllers;
    opens by.me.fm.controllers to javafx.fxml;
}