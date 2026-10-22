package Ex2_7;

public class Money {
    private final long cents;

    private Money (long cents){
        this.cents = cents;
    }

    public static final Money ZERO = new Money (0);

    public static final Money ofCents (long cents){
        if (cents < 0){
            throw new IllegalArgumentException("Value can't be negative "+ cents);
        }
        else if (cents == 0){
            return ZERO;
        }

        return new Money (cents);
    }

    public static Money of (double euros){
        return Money.ofCents((long)(euros*100));
    }

    public Money plus (Money other){
        return ofCents(cents + other.cents);
    }

    public Money times (int qty){
        return ofCents(qty*cents);
    }

    public long cents (){
        return cents;
    }

    public String toString (){
        return String.format("%.2f EUR", ((float)cents/100));
    }
}
