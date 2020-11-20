package alexskxy.personapp;

import alexskxy.personapp.entity.Person;
import alexskxy.personapp.entity.ValueInvalidException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPersonController {
    public Person person;

    public TextField eintrittsJahr;
    public TextField vorname;
    public TextField name;

    public void register(ActionEvent actionEvent) {
        var w = name.getScene().getWindow();

        person = new Person();
        person.setVorname(vorname.getText());
        person.setName(name.getText());

        try {
            person.setEintrittsJahr(Integer.parseInt(eintrittsJahr.getText()));
        } catch (NumberFormatException e) {
            ModalHelper.showAlert(Alert.AlertType.ERROR, w, "Error!",
                    "Buchstaben sind in Felder Eintritts Jahr, Salär und Pensum nicht erlaubt!");
        } catch (ValueInvalidException e) {
            ModalHelper.showAlert(Alert.AlertType.ERROR, w, "Error!",
                    "Jahr muss zwischen 1975 und heute sein!");
        }
        ((Stage) w).close();
    }

    public void cancel(ActionEvent actionEvent) {
        person = null;
        ((Stage) name.getScene().getWindow()).close();
    }
}