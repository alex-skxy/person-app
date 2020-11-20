package alexskxy.personapp;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

public class ModalHelper {
    private static FileChooser fileChooser;

    static {
        fileChooser = new FileChooser();
        var extensionFilter = new FileChooser.ExtensionFilter("JSON Dateien", "*.json");
        fileChooser.getExtensionFilters().addAll(extensionFilter);
        fileChooser.setSelectedExtensionFilter(extensionFilter);
        var currentDir = System.getProperty("user.home");
        fileChooser.setInitialDirectory(new File(currentDir));
    }

    public static boolean showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.showAndWait();
        return alert.getResult() == ButtonType.OK;
    }

    public static File showOpenFileDialog(Stage stage, String title) {
        fileChooser.setTitle(title);
        return fileChooser.showOpenDialog(stage);
    }

    public static File showSaveFileDialog(Stage stage, String title) {
        fileChooser.setTitle(title);
        var file =  fileChooser.showSaveDialog(stage);
        var filePath = file.getAbsolutePath();
        return filePath.toLowerCase().endsWith(".json") ? file : new File(filePath + ".json");
    }
}