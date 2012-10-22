package geegees.model;

public class Horse {
    String name;
    private String odds;
    private Integer tips = 0;
    private double difference;

    public Horse(String name, String odds) {
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
        return tips == null ? 0 : tips;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    @Override
    public String toString() {
        return name + " : " + odds;
    }

    @SuppressWarnings("RedundantIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Horse horse = (Horse) o;

        if (name != null ? !name.equals(horse.name) : horse.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
