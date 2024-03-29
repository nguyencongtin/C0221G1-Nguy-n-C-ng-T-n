package model.bean;

public class Customer {
    private int idCustomer;
    private int idTypeCustomer;
    private String name;
    private String dayOfBirth;
    private String sex;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int idCustomer, String name, String dayOfBirth, String phoneNumber) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public Customer(int idTypeCustomer, String name, String dayOfBirth, String sex, String idCard, String phoneNumber, String email, String address) {
        this.idTypeCustomer = idTypeCustomer;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.sex = sex;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Customer(int idCustomer, int idTypeCustomer, String name, String dayOfBirth, String sex, String idCard, String phoneNumber, String email, String address) {
        this.idCustomer = idCustomer;
        this.idTypeCustomer = idTypeCustomer;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.sex = sex;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(int idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
