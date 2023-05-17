package entity;

public class Awards {
    /**
     * "awardName": "Second Place of Math Competition",
     *       "awardTime": "2021.10"
     */
    private String awardName;
    private String awardTime;

    public Awards(String awardName, String awardTime) {
        this.awardName = awardName;
        this.awardTime = awardTime;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(String awardTime) {
        this.awardTime = awardTime;
    }
}

