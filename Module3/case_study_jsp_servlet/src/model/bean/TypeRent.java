package model.bean;

public class TypeRent {
    private int idTypeRent;
    private String rentName;
    private int rentCost;

    public TypeRent() {
    }

    public TypeRent(int idTypeRent, String rentName, int rentCost) {
        this.idTypeRent = idTypeRent;
        this.rentName = rentName;
        this.rentCost = rentCost;
    }

    public int getIdTypeRent() {
        return idTypeRent;
    }

    public void setIdTypeRent(int idTypeRent) {
        this.idTypeRent = idTypeRent;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public int getRentCost() {
        return rentCost;
    }

    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }
}
