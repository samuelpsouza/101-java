package dev.ssouza;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount && currency().equals(money.currency());
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }
    
    String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    Expression plus(Money added) {
        return new Money(amount + added.amount, currency);
    }

    
}
