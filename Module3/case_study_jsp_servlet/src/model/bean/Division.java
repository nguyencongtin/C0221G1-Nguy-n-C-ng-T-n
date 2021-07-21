package model.bean;

public class Division {
    private int idDivision;
    private String divisionName;

    public Division() {
    }

    public Division(int idDivision, String divisionName) {
        this.idDivision = idDivision;
        this.divisionName = divisionName;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
