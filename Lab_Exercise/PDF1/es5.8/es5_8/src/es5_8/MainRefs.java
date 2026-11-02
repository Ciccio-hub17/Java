package es5_8;

import java.util.Arrays;

public class MainRefs {
    public static void main (){
        Order[] orders = {
        new Order(1, "Rossi", 29.5, true),
        new Order(2, "Bianchi", 12.0, false),
        new Order(3, "Rossi", 8.0, true),
        new Order(4, "Verdi", 41.25, true)
        };
        IO.println(Stats.count(orders, Order::delivered) + " " // ->
        + Stats.count(orders, o -> o.total() > 20));
        IO.println(Stats.sum(orders, Order::total)); // ->
        IO.println(Stats.max(orders, (a, b) -> Double.compare(a.total(), b.total())).id());
        Stats.forEachIf(orders, o -> o.customer().equals("Rossi"),
        IO::println); // ->
        IO.println(Arrays.toString(Stats.map(orders, Order::customer))); // ->
        IO.println(Arrays.toString(Stats.map(orders, o -> String.valueOf(o.id()))));
        Order[] gen = Stats.generate(3, i -> new Order(i + 1, "C" + i, 10 * (i + 1), false));
        IO.println(gen[2]);
    }
}
