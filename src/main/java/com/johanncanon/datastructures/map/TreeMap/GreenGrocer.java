package com.johanncanon.datastructures.map.TreeMap;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.SortedMap;
import java.util.TreeMap;

@Getter
@Setter
@Log4j2
public class GreenGrocer {

    private String crop;
    private TreeMap<Fruit, Integer> fruits;

    public GreenGrocer(String crop, TreeMap<Fruit, Integer> fruits) {
        this.crop = crop;
        this.fruits = fruits;
    }


    /**
     * All of these results are sorted ordered by default Ascending.
     *
     */
    public String getFirstFruitName() {
        return this.fruits.firstKey().name();
    }

    public String getFirstFruitColor() {
        return this.fruits.firstKey().color();
    }

    public String getLastFruitName() {
        return this.fruits.lastKey().name();
    }

    public String getLastFruitColor() {
        return this.fruits.lastKey().color();
    }

    /**
     *  TreeMap let you manipulate easily this kind of Rages, is one of the Main usages.
     */
    public SortedMap<Fruit, Integer> getAllFruitsLessThan(Fruit fruit) {
        log.debug("Getting all fruits less than {}" , fruit);
        return this.fruits.headMap( fruit );
    }

    /**
     *  .tailMap() return to you all fruits greater than or equals fruits ordered by default from TreeMap class.
     */
    public SortedMap<Fruit, Integer> getAllFruitsGreaterThan(Fruit fruit) {
        log.debug("Getting all fruits greater than {}" , fruit);
        return this.fruits.tailMap( fruit );
    }

    /**
     *  .get() return to as the value (Integer in this case) from the Structure.
     */
    public Integer getAllFruitsValuesEqualThan(Fruit fruit) {
        log.debug("Getting the value from fruit equal {}" , fruit);
        return this.fruits.get( fruit );
    }

    public String removeFruit(Fruit fruit) {
        log.debug("Removing next fruit: {}" , fruit);
        this.fruits.remove( fruit );
        return "Fuit '"+ fruit.name() +"' removed";
    }


}
