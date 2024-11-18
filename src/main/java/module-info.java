module com.exemple.platformeeducatif {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires java.sql;
    requires java.management;

    opens com.exemple.platformeeducatif to javafx.fxml;
    exports com.exemple.platformeeducatif;
    exports com.exemple.platformeeducatif.Causes;
    opens com.exemple.platformeeducatif.Causes to javafx.fxml;
    opens com.exemple.platformeeducatif.Solution to javafx.fxml;
    exports com.exemple.platformeeducatif.Admin;
    opens com.exemple.platformeeducatif.Admin to javafx.fxml;
    exports com.exemple.platformeeducatif.BaseDeDonnes;
    opens com.exemple.platformeeducatif.BaseDeDonnes to javafx.fxml;
    exports com.exemple.platformeeducatif.Quiz;
    opens com.exemple.platformeeducatif.Quiz to javafx.fxml;

}