package entity;

public class Module {
    private String moduleName;
    private String moduleId;
    private String state;
    private int beginTime;
    private String weekday;
    private int endTime;
    private int score;
    private int credit;
    private String openYear;
    private String teacher;
    private String teacherEmail;
    private String intro;

    @Override
    public String toString() {
        return "Module{" +
                "moduleName='" + moduleName + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", state='" + state + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", weekday='" + weekday + '\'' +
                ", endTime='" + endTime + '\'' +
                ", score=" + score +
                ", credit=" + credit +
                ", year='" + openYear + '\'' +
                ", teacher='" + teacher + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                '}';
    }

    public Module(String moduleName, String moduleId, String state, int beginTime, String weekday, int endTime, int score, int credit, String year, String teacher, String teacherEmail, String intro) {
        this.moduleName = moduleName;
        this.moduleId = moduleId;
        this.state = state;
        this.beginTime = beginTime;
        this.weekday = weekday;
        this.endTime = endTime;
        this.score = score;
        this.credit = credit;
        this.openYear = year;
        this.teacher = teacher;
        this.teacherEmail = teacherEmail;
        this.intro = intro;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getOpenYear() {
        return openYear;
    }

    public void setOpenYear(String openYear) {
        this.openYear = openYear;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
