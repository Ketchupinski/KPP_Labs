package com.university.kpp.util;

import com.university.kpp.entities.Toy;

import java.util.List;

public final class ToysManager {

    private ToysManager() {
    }

    private static Toy getCheapestToy(List<Toy> toys) {
        Toy cheapestToy = toys.get(0);
        for (Toy toy : toys) {
            if (toy.getCost() < cheapestToy.getCost()) {
                cheapestToy = toy;
            }
        }
        return cheapestToy;
    }

    /**
     * Difference can be only 10 percent from the cheapest toy
     *
     * @param cheapestToy cheapest toy
     */
    private static int getMinDifferenceBetweenCheapestToys(Toy cheapestToy) {
        return (cheapestToy.getCost() * 10) / 100;
    }

    public static List<Toy> getCheapestToys(List<Toy> toys) {
        Toy cheapestToy = getCheapestToy(toys);
        int minDifference = getMinDifferenceBetweenCheapestToys(cheapestToy);
        toys.removeIf(toy -> toy.getCost() > cheapestToy.getCost() + minDifference);
        return toys;
    }
}
