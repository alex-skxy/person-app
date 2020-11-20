package alexskxy.personapp.entity;

import java.time.LocalDate;

public class Person {
    private static final Integer MAX_YEAR = LocalDate.now().getYear();
    private static final Integer MIN_YEAR = 1975;
    private static final Double MAX_SALAER = 99999.95;

    public static Integer anzahlPersonen = 1;

    private Integer personalNummer;
    private String anrede;
    private String name;
    private String vorname;
    private String plz;
    private String ort;
    private Integer eintrittsJahr;
    private Double salaer;
    private Double pensum;

    public Person() {
        this.personalNummer = anzahlPersonen;
        anrede = "Frau";
        name = "Neue Person";
        vorname = "";
        plz = "6000";
        ort = "Luzern";
        eintrittsJahr = MAX_YEAR;
        salaer = 5000.00;
        pensum = 100.00;
        anzahlPersonen++;
    }

    public Person(String anrede, String name, String vorname) {
        this.personalNummer = anzahlPersonen;
        this.anrede = anrede;
        this.name = name;
        this.vorname = vorname;
        anzahlPersonen++;
    }

    public Person(String name, String vorname, Integer eintrittsJahr) {
        this.personalNummer = anzahlPersonen;
        this.name = name;
        this.vorname = vorname;
        this.eintrittsJahr = eintrittsJahr;
        anzahlPersonen++;
    }

    public static Double calculateLohn(double salaer, double pensum) {
        return salaer * pensum / 100.00;
    }

    public Double calculateLohn() {
        return this.salaer * this.pensum / 100.00;
    }

    public Integer getPersonalNummer() {
        return personalNummer;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Integer getEintrittsJahr() {
        return eintrittsJahr;
    }

    public void setEintrittsJahr(Integer eintrittsJahr) throws ValueInvalidException {
        if (eintrittsJahr > MAX_YEAR) {
            this.eintrittsJahr = MAX_YEAR;
            throw new ValueInvalidException();
        } else if (eintrittsJahr < MIN_YEAR) {
            this.eintrittsJahr = MIN_YEAR;
            throw new ValueInvalidException();
        } else {
            this.eintrittsJahr = eintrittsJahr;
        }
    }

    public Double getSalaer() {
        return salaer;
    }

    public void setSalaer(Double salaer) throws ValueInvalidException {
        if (salaer >= MAX_SALAER) {
            this.salaer = MAX_SALAER;
            throw new ValueInvalidException();
        } else if (salaer <= 0.00) {
            this.salaer = 0.00;
            throw new ValueInvalidException();
        } else {
            this.salaer = salaer;
        }
    }

    public Double getPensum() {
        return pensum;
    }

    public void setPensum(Double pensum) {
        this.pensum = pensum;
    }
}
