package model.bean;

public class Position {
    private int idPosition;
    private String positionName;

    public Position() {
    }

    public Position(int idPosition, String positionName) {
        this.idPosition = idPosition;
        this.positionName = positionName;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
