package alexskxy.personapp;

import alexskxy.personapp.entity.Person;
import alexskxy.personapp.entity.ValueInvalidException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final List<Person> people;
    private Integer currentPerson;

    @FXML
    public Button first;
    @FXML
    public Button previous;
    @FXML
    public Button next;
    @FXML
    public Button last;

    @FXML
    public TextField current;
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

    public MainController() {
        this.people = new ArrayList<>();
    }

    public void initialize() {
        people.addAll(List.of(new Person(), new Person(), new Person()));
        setViewObject(0);
    }

    private void setViewObject(Integer index) {
        currentPerson = index;
        current.setText(String.valueOf(currentPerson + 1));

        Person person = people.get(index);

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
        Integer index = 0;
        if (indexIsValid(index)) {
            setViewObject(0);
        }
    }

    public void handleGetPrevious(ActionEvent actionEvent) {
        Integer index = currentPerson - 1;
        if (indexIsValid(index)) {
            setViewObject(index);
        }
    }

    public void handleGetNext(ActionEvent actionEvent) {
        Integer index = currentPerson + 1;
        if (indexIsValid(index)) {
            setViewObject(index);
        }
    }

    public void handleGetLast(ActionEvent actionEvent) {
        Integer index = people.size() - 1;
        if (indexIsValid(index)) {
            setViewObject(index);
        }
    }

    public void handleAdd(ActionEvent actionEvent) {
        people.add(new Person());
        handleGetLast(new ActionEvent());
    }

    public void handleRemove(ActionEvent actionEvent) {
        people.remove((int) currentPerson);
        handleGetPrevious(new ActionEvent());
    }

    public void handleCancel(ActionEvent actionEvent) {
        setViewObject(currentPerson);
    }

    public void handleSave(ActionEvent actionEvent) {
        Person person = people.get(currentPerson);

        person.setAnrede(anrede.getText());
        person.setName(name.getText());
        person.setVorname(vorname.getText());
        person.setPlz(plz.getText());
        person.setOrt(ort.getText());
        try {
            person.setEintrittsJahr(Integer.parseInt(eintrittsJahr.getText()));
            person.setSalaer(Double.parseDouble(salaer.getText()));
            person.setPensum(Double.parseDouble(pensum.getText()));
        } catch (ValueInvalidException e) {
            // TODO: handle exception
        }
    }

    private boolean indexIsValid(Integer index) {
        if (people.isEmpty()) {
            return false;
        } else if (index == -1) {
            return false;
        } else return index != people.size();
    }
}