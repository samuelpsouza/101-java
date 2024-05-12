package dev.ssouza;

import java.util.Random;

public final class Util {
    private static final Random random = new Random();

    static MoveOption randomMove() {
        var value = random.nextInt(3);

        return switch (value) {
            case 0 -> MoveOption.STAY;
            case 1 -> MoveOption.LEFT;
            case 2 -> MoveOption.RIGHT;
            default -> MoveOption.STAY;
        };
    }

    static Animal randomAnimal() {
        var value = random.nextInt(3);

        return switch (value) {
            case 0 -> new Bear();
            case 1 -> new Fish();
            case 2 -> null;
            default -> null;
        };
    }
}
