package Ex2_7;
public class App {
    public static void main(String[] args) throws Exception {
        IO.println(Money.of(12.5) + " | " + Money.ofCents(199).times(3) + " | "
        + Money.of(0.1).plus(Money.of(0.2)));
        IO.println((Money.of(0) == Money.ZERO) + " " + (Money.of(1) == Money.of(1)));
        IO.println(Codes.code('E', 7) + " " + Codes.isValid("E0007") + " " + Codes.isValid("e0007")
        + " " + Codes.number("E0042"));
        IO.println("start");
        BoxOffice turin = new BoxOffice();
        BoxOffice milan = new BoxOffice();
        String c1 = turin.addEvent("Concert", 100, Money.of(25));
        String c2 = turin.addEvent("Opera", 50, Money.of(40.5));
        String m1 = milan.addEvent("Concert", 80, Money.of(30));
        IO.println(c1 + " " + c2 + " " + m1 + " offices=" + BoxOffice.officesCreated());
        IO.println(turin.sell(c1, 3) + " left=" + turin.available(c1));
        IO.println(milan.sell(m1, 2) + " left=" + milan.available(m1));
        try {
        turin.sell("E0099", 1);
        } catch (IllegalArgumentException e) {
        IO.println("error: " + e.getMessage());
        }
        try {
        turin.addEvent("Opera", 10, Money.ZERO);
        } catch (IllegalArgumentException e) {
        IO.println("error: " + e.getMessage());
        }
        IO.println(AuditLog.getInstance().count() + " " + AuditLog.getInstance().last());
            }
}
