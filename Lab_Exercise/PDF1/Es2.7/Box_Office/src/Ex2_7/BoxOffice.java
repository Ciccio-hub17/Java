package Ex2_7;

import static Ex2_7.Codes.*;

public class BoxOffice {
    public static final int MAX_SEATS = 500;
    public static final int MAX_EVENTS = 100;

    public static int officesCreated = 0;

    private final String[] names = new String[MAX_EVENTS];
    private final int[] seats = new int[MAX_EVENTS];
    private final Money[] prices = new Money[MAX_EVENTS];
    private int nEvents = 0;

    public BoxOffice(){
        officesCreated++;
    }

    private final boolean duplicate (String name){
        for (int i = 0; i < nEvents+1; i++){
            if (name.equals(names[i])){
                return true;
            }
        }
        return false;
    }

    public String addEvent (String name, int seats, Money price){

        if ((seats < 1 && seats > MAX_SEATS)){
            throw new IllegalArgumentException();
        }
        if (duplicate(name)){
            throw new IllegalArgumentException("duplicate event "+ name);
        }
        names[nEvents] = name;
        this.seats[nEvents] = seats;
        prices[nEvents] = price;
        nEvents++;

        return code('E', nEvents);
    }

    public Money sell (String code, int qty){
        if (code.charAt(0) != 'E'){
            throw new IllegalArgumentException("invalid code "+ code);
        }
        if (!isValid(code)){
            throw new IllegalArgumentException("invalid code "+ code);

        }
        if (number(code) > nEvents+1){
            throw new IllegalArgumentException ("unknown code "+code);
        }
        if (qty < 1){
            throw new IllegalArgumentException("invalid number of seats (<1)");
        }
        if (qty > seats[number(code)-1]){
            throw new IllegalArgumentException ("not enough seats");
        }

        seats[number(code)-1] -= qty;

        AuditLog.getInstance().record ("sold "+ qty + " x "+ code);

        return prices[number(code)-1].times(qty);
    }

    int available (String code){
        if (code.charAt(0) != 'E'){
            throw new IllegalArgumentException("invalid code "+ code);
        }
        if (!isValid(code)){
            throw new IllegalArgumentException("invalid code "+ code);

        }
        if (number(code) > nEvents+1){
            throw new IllegalArgumentException ("unknown code "+code);
        }

        return seats[number(code)-1];
    }

    static int officesCreated (){
        return officesCreated;
    }

}
