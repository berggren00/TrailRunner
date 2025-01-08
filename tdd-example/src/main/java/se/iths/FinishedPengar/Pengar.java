package se.iths.FinishedPengar;

public class Pengar {
    protected int amount;
    protected String currency;

    public Pengar(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Pengar kronor(int amount) {
        return new Pengar(amount, "SEK");
    }

    static Pengar euro(int amount) {
        return new Pengar(amount, "EUR");
    }

    Pengar times(int multiplier) {
        return new Pengar(amount * multiplier, currency);
    }

    Pengar plus(Pengar addend) {
        return new Pengar(amount += addend.amount, currency);
    }
    
    String currency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        Pengar pengar = (Pengar) obj;
        return amount == pengar.amount
            && currency().equals(pengar.currency());
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
