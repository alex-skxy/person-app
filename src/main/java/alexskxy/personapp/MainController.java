package alexskxy.personapp;

import alexskxy.personapp.entity.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class MainController {
    private List<Person> people;
    private List<TextField> toValidate;
    @FXML
    public TextField personalNummer;
    @FXML
    public TextField anrede;
    @FXML
    public TextField name;
    @FXML
    public TextField vorname;
    @FXML
    public TextField plz;
    @FXML
    public TextField ort;
    @FXML
    public TextField eintrittsJahr;
    @FXML
    public TextField salaer;
    @FXML
    public TextField pensum;

    public Button button;
    @FXML
    private Label label;

    public void initialize() {
        // TODO
    }

    private void setViewObject(Person person) {
        personalNummer.setText(person.getPersonalNummer().toString());
        anrede.setText(person.getAnrede());
        name.setText(person.getName());
        vorname.setText(person.getVorname());
        plz.setText(person.getPlz());
        ort.setText(person.getOrt());
        eintrittsJahr.setText(person.getEintrittsJahr().toString());
        salaer.setText(person.getSalaer().toString());
        pensum.setText(person.getPensum().toString());
    }

    public void handleGetFirst(ActionEvent actionEvent) {
    }

    public void handleGetPrevious(ActionEvent actionEvent) {
    }

    public void handleGetNext(ActionEvent actionEvent) {
    }

    public void handleGetLast(ActionEvent actionEvent) {
    }

    public void handleAdd(ActionEvent actionEvent) {
    }

    public void handleRemove(ActionEvent actionEvent) {
    }

    public void handleCancel(ActionEvent actionEvent) {
    }

    public void handleSave(ActionEvent actionEvent) {
    }
}