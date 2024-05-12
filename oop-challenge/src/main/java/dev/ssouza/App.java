package dev.ssouza;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static dev.ssouza.Util.randomAnimal;

public class App {
    private static final int INITIAL_CAPACITY = 100;
    private static final Random random = new Random();

    public static void main(String[] args) {
        final List<Animal> river = new ArrayList<>();
        initializeSimuationValues(river);

        while (hasFish(river)) {
            int index = 0;
            for (Animal animal : river) {
                if (animal != null) {
                    var move = animal.move();

                    if (MoveOption.STAY == move) {
                        continue;
                    }

                    if (MoveOption.LEFT == move) {
                        if (index == 0) {
                            System.out.println(animal.getClass().getName() + " cannot move to the left.");
                            continue;
                        }
                        var prev = river.get(index - 1);

                        if (prev != null) {
                            if (prev.getClass() != animal.getClass()) {
                                if (prev instanceof Fish) {
                                    river.set(index, null);
                                } else {
                                    river.set(index - 1, animal);
                                    river.set(index, null);
                                }
                            } else {
                                createNewAnimalRandomly(river, animal.getClass());
                            }
                        }
                    }
                    if (MoveOption.RIGHT == move) {
                        if (index == river.size() - 1) {
                            System.out.println(animal.getClass().getName() + " cannot move to the right.");
                            continue;
                        }

                        var next = river.get(index + 1);

                        if (next != null) {
                            if (next.getClass() != animal.getClass()) {
                                if (next instanceof Bear) {
                                    river.set(index, null);
                                } else {
                                    river.set(index + 1, animal);
                                    river.set(index, null);
                                }
                            } else {
                                createNewAnimalRandomly(river, animal.getClass());
                            }
                        }
                    }

                }
                index++;
            }
        }

        System.out.println("End of simulation. No more fishes.");

    }

    private static void createNewAnimalRandomly(final List<Animal> river, Class<? extends Animal> clazz) {
        if(isFull(river)) {
            river.add(createAnimalBasedOnClass(clazz));
        }
        var wasInserted = false;

        while (!wasInserted) {
            var index = random.nextInt(river.size());

            if (river.get(index) == null) {
                river.set(index, createAnimalBasedOnClass(clazz));
            }
        }
    }

    private static Animal createAnimalBasedOnClass(Class<? extends Animal> clazz) {
        final Animal animal;
        if (clazz.getName() == Fish.class.getName()) {
            animal = new Fish();
        } else {
            animal = new Bear();
        }

        return animal;
    }

    private static void initializeSimuationValues(final List<Animal> river) {
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            river.add(i, randomAnimal());
        }
    }

    private static boolean hasFish(final List<Animal> river) {
        return river
                .stream()
                .filter(it -> it instanceof Fish)
                .findFirst()
                .isPresent();
    }

    private static boolean isFull(final List<Animal> river) {
        return !river
                .stream()
                .filter(it -> it == null)
                .findFirst()
                .isPresent();
    }
}
