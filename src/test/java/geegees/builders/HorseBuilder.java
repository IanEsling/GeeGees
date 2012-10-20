package geegees.builders;

import geegees.model.Horse;

public class HorseBuilder {

    String name;
    private String odds;
    private Integer tips;

    private HorseBuilder() {}

    public static HorseBuilder horseBuilder() {
        return new HorseBuilder();
    }

    public Horse build() {
        Horse horse = new Horse(name, odds);
        horse.setTips(tips);
        return horse;
    }

    public HorseBuilder name(String name) {
        this.name = name;
        return this;
    }

    public HorseBuilder odds(String odds) {
        this.odds = odds;
        return this;
    }

    public HorseBuilder tips(Integer tips) {
        this.tips = tips;
        return this;
    }
}
