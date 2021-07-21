package model.bean;

public class TypeCustomer {
private int idTypeCustomer;
private String typeCustomerName;

    public TypeCustomer() {
    }

    public TypeCustomer(int idTypeCustomer, String typeCustomerName) {
        this.idTypeCustomer = idTypeCustomer;
        this.typeCustomerName = typeCustomerName;
    }

    public int getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(int idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getTypeCustomerName() {
        return typeCustomerName;
    }

    public void setTypeCustomerName(String typeCustomerName) {
        this.typeCustomerName = typeCustomerName;
    }
}
