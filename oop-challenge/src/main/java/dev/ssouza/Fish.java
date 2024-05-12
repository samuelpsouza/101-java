package dev.ssouza;

import static dev.ssouza.Util.randomMove;

public class Fish extends Animal {

    @Override
    MoveOption move() {
        return randomMove();
    }

}
