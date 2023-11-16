package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface rollable {
    static String rollToy(ArrayList<Toy> toyList) {
        int percents = 0;
        Random random = new Random();
        List<String> rollingToys = new ArrayList<>();
        for (Toy toy : toyList) {
            int toyPersents = toy.getPercentage();
            for (int i = 0; i < toyPersents; i++) {
                rollingToys.add(toy.getName());
            }
            percents += toyPersents;
        }
        System.out.println("Игрушка разыграна ");
        return rollingToys.get(random.nextInt(0,percents+1));
    }
}
