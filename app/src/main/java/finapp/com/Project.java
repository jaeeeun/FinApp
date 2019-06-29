package finapp.com;

public class Project {
    private String projectname;
    private int startmonth;

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public int getStartmonth() {
        return startmonth;
    }

    public void setStartmonth(int startmonth) {
        this.startmonth = startmonth;
    }

    public int getEndmonth() {
        return endmonth;
    }

    public void setEndmonth(int endmonth) {
        this.endmonth = endmonth;
    }

    public int getStartday() {
        return startday;
    }

    public void setStartday(int startday) {
        this.startday = startday;
    }

    public int getEndday() {
        return endday;
    }

    public void setEndday(int endday) {
        this.endday = endday;
    }

    private int endmonth;
    private int startday;
    private int endday;

    public Project(String projectname, int startday, int endday) {
        this.projectname = projectname;
        this.startday = startday;
        this.endday = endday;
    }




}
