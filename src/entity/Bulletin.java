package entity;

public class Bulletin {
    private String notice;
    private String updateTime;

    @Override
    public String toString() {
        return "Bulletin{" +
                "notice='" + notice + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public Bulletin(String notice, String updateTime) {
        this.notice = notice;
        this.updateTime = updateTime;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
