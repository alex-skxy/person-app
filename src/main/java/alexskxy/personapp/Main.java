package alexskxy.personapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        URL url = Paths.get("./src/main/resources/fxml/basic.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
