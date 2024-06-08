package dev.ssouza;

public class Franc extends Money {
    Franc(int amount) {
        this.amount = amount;
    }

    public Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }
}
