package dev.ssouza;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    private static final int INITIAL_CAPACITY = 100;
    private static final Random random = new Random();

    public static void main(String[] args) {
        final List<Animal> simulation = new ArrayList<>();
        initializeSimuationValues(simulation);

        for (Animal animal : simulation) {
            if (animal != null) {
                System.out.println("Instance type: " + animal.getClass().getName());
            }
        }

    }

    private static void initializeSimuationValues(final List<Animal> simulation) {
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            simulation.add(i, randomAnimal());
        }
    }

    private static Animal randomAnimal() {
        var value = random.nextInt(3);

        return switch (value) {
            case 0 -> new Bear();
            case 1 -> new Fish();
            case 2 -> null;
            default -> null;
        };
    }
}
