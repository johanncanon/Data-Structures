package com.johanncanon.datastructures.map.TreeMap;

public record Fruit(
        String name,
        String color,
        String weather
) implements Comparable<Fruit> {

    /**
     * Allways implement Comparable< E > to provide the comparable action that is required for the TreeMap class.
     */
    @Override
    public int compareTo(Fruit other) {
        return this.name.compareTo( other.name );
    }
}
