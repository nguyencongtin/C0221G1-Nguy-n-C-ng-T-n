package model.bean;

public class Service {
    private int idService;
    private String serviceName;
    private int serviceArea;
    private int numberOfFloor;
    private int serviceMaxPeople;
    private double serviceCost;
    private int rentTypeId;
    private int serviceTypeId;
    private String standardRoom;
    private String descriptionOtherConverience;
    private double poolArea;

    public Service() {
    }

    public Service(int idService, String serviceName, int serviceArea, int numberOfFloor, int serviceMaxPeople, double serviceCost, int rentTypeId, int serviceTypeId, String standardRoom, String descriptionOtherConverience, double poolArea) {
        this.idService = idService;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.numberOfFloor = numberOfFloor;
        this.serviceMaxPeople = serviceMaxPeople;
        this.serviceCost = serviceCost;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConverience = descriptionOtherConverience;
        this.poolArea = poolArea;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConverience() {
        return descriptionOtherConverience;
    }

    public void setDescriptionOtherConverience(String descriptionOtherConverience) {
        this.descriptionOtherConverience = descriptionOtherConverience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }
}
