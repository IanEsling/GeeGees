package geegees.builders;

import geegees.model.BettingForecast;
import geegees.model.Horse;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

public class BettingForecastBuilder {

    private Collection<Horse> horses = newArrayList();

    private BettingForecastBuilder(){}

    public static BettingForecastBuilder bettingForecastBuilder(){
        return new BettingForecastBuilder();
    }

    public BettingForecast build(){
        BettingForecast bettingForecast = new BettingForecast();
        bettingForecast.setHorses(horses);
        return bettingForecast;
    }

    public BettingForecastBuilder horses(Collection<Horse> horses) {
        this.horses = horses;
        return this;
    }
}
