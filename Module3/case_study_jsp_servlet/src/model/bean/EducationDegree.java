package model.bean;

public class EducationDegree {
    private int idEducationDegree;
    private String educationDegreeName;

    public EducationDegree() {
    }

    public EducationDegree(int idEducationDegree, String educationDegreeName) {
        this.idEducationDegree = idEducationDegree;
        this.educationDegreeName = educationDegreeName;
    }

    public int getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(int idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
