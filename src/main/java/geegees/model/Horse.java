package geegees.model;

public class Horse {
    String name;
    private String odds;
    private Integer tips;

    Horse(String name, String odds) {
        this.name = name;
        this.odds = odds;
    }

    public String getName() {
        return name;
    }

    public String getOdds() {
        return odds;
    }

    public void setTips(Integer tips) {
        this.tips = tips;
    }

    public Integer getTips() {
        return tips;
    }

    @Override
    public String toString() {
        return name + " : " + odds;
    }
}
