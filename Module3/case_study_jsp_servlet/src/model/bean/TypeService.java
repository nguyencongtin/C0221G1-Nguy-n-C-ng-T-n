package model.bean;

public class TypeService {
    private int idTypeService;
    private String typeServiceName;

    public TypeService() {
    }

    public TypeService(int idTypeService, String typeServiceName) {
        this.idTypeService = idTypeService;
        this.typeServiceName = typeServiceName;
    }

    public int getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(int idTypeService) {
        this.idTypeService = idTypeService;
    }

    public String getTypeServiceName() {
        return typeServiceName;
    }

    public void setTypeServiceName(String typeServiceName) {
        this.typeServiceName = typeServiceName;
    }
}
