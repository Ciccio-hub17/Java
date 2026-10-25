package ex6_2;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        String[] tags = {"office", "school", "art", "school"};
        Integer[] sold = {13, 8, 21, 5}; // pieces sold, Monday to Thursday
        IO.println(ArrayUtils.indexOf(tags, "school") + " " + ArrayUtils.indexOf(sold, 99) + " "
        + ArrayUtils.max(tags) + " " + ArrayUtils.max(sold));
        String removed = ArrayUtils.remove(tags, "school"); // no cast
        IO.println(removed + " " + Arrays.toString(tags));
        ArrayUtils.swap(sold, 0, 3); // Monday and Thursday were swapped
        IO.println(Arrays.toString(ArrayUtils.append(sold, 34)) + " "
        + ArrayUtils.count(sold, n -> n > 10));
        Product[] ps = {
        new Product("pen", 1.5), new Product("bag", 25.0), new Product("ink", 4.0)
        };
        IO.println(ArrayUtils.max(ps) + " "
        + ArrayUtils.max(ps, Comparator.comparing(Product::name)));
        Product[] cheap = ArrayUtils.filter(ps, p -> p.price() < 5);
        IO.println(Arrays.toString(cheap) + " " + cheap.getClass().getSimpleName());
        Comparator<Object> byText = Comparator.comparing(Object::toString);
        Integer m = ArrayUtils.max(sold, byText); // T = Integer: see the notes
        IO.println(m);
        Object[] objects = tags; // arrays are covariant...
        try {
        objects[0] = 42; // ...so this compiles
        } catch (ArrayStoreException e) {
        IO.println("ArrayStoreException: " + e.getMessage());
        }
    }
}
