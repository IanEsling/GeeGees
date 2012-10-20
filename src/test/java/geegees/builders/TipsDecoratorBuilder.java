package geegees.builders;

import geegees.model.Horse;
import geegees.model.TipsDecorator;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

public class TipsDecoratorBuilder {

    private Collection<Horse> horses = newArrayList();

    private TipsDecoratorBuilder() {}

    public static TipsDecoratorBuilder tipsDecoratorBuilder() {
        return new TipsDecoratorBuilder();
    }

    public TipsDecorator build() {
        TipsDecorator tipsDecorator = new TipsDecorator();
        tipsDecorator.setHorses(horses);
        return tipsDecorator;
    }

    public TipsDecoratorBuilder horses(Collection<Horse> horses) {
        this.horses = horses;
        return this;
    }
}
