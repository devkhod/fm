package by.me.fm;

import javafx.application.Application;
import javafx.beans.DefaultProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FMApplication extends Application {
    static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FMApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(FMApplication.class.getResource("fm-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), stage.getWidth(), stage.getHeight());
        stage.setTitle("Менеджер файлов");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}