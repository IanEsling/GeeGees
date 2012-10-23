package geegees.model;

public class Horse {
    String name;
    private String odds;
    private Integer tips = 0;
    private double magicNumber;
    private double decimalOdds;

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

    public double getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(double magicNumber) {
        this.magicNumber = magicNumber;
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

    public double getDecimalOdds() {
        return decimalOdds;
    }

    public void setDecimalOdds(double decimalOdds) {
        this.decimalOdds = decimalOdds;
    }
}
