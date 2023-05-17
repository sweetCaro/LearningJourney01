package entity;

public class Portfolios {
    /**
     * "projectName": "Design a Database for a manage system",
     *       "projectIntroduction": "this is a database design",
     *       "fileLink": "inputFile/ERdiagram.png"
     */
    private String projectName;
    private String projectIntroduction;
    private String fileLink;

    public Portfolios(String projectName, String projectIntroduction, String fileLink) {
        this.projectName = projectName;
        this.projectIntroduction = projectIntroduction;
        this.fileLink = fileLink;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIntroduction() {
        return projectIntroduction;
    }

    public void setProjectIntroduction(String projectIntroduction) {
        this.projectIntroduction = projectIntroduction;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
}
