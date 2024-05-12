package dev.ssouza;

import static dev.ssouza.Util.randomMove;

public class Bear extends Animal {

    @Override
    MoveOption move() {
        return randomMove();
    }

}
