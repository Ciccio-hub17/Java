package es5_8;

import java.util.Comparator;
import java.util.function.*;

public class Stats {


    private Stats (){ }

    public static int count (Order[] v, Predicate<Order> cond){
        int count = 0;
        for (Order el : v){
            if (cond.test(el)){
                count++;
            }
        }
        return count;
    }

    public static double sum (Order[] v, ToDoubleFunction<Order> value){
        double sum = 0;
        for (Order el : v){
            sum += value.applyAsDouble(el);
        }
        return sum;
    }

    public static Order max (Order[] v, Comparator<Order> order){
        Order max = null;
        for (Order el : v){
            if (max == null || order.compare(el, max) > 0){
                max = el;
            }
        }
        return max;
    }

    public static void forEachIf (Order[] v, Predicate<Order> cond, Consumer<Order> action){
        for (Order el : v){
            if (cond.test(el)){
                action.accept(el);
            }
        }
    }

    public static String[] map (Order[] v, Function<Order, String> f){
        String[] result = new String[v.length];
        for (int i = 0; i < v.length; i++){
            result[i] = f.apply(v[i]);
        }
        return result;
    }

    public static Order[] generate (int n, IntFunction<Order> maker){
        Order[] v = new Order[n];
        for (int i = 0; i < n; i++){
            v[i] = maker.apply(i);
        }
        return v;
    }


}
