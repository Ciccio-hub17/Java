package ex6_1;

import java.util.Objects;

public class Pair<T> {
    private T a;
    private T b;

    public Pair (T a, T b){
        this.a = a;
        this.b = b;
    }

    public T first (){
        return a;
    }

    public T second (){
        return b;
    }

    public void set1st (T a){
        this.a = a;
    }

    public void set2nd (T b){
        this.b = b;
    }

    public static <T> Pair<T> of (T a, T b){
        //In this way, when I want to create an object of pairs, I only have to call
        //this method without indicate type between <>
        return new Pair<T> (a, b);
    }

    public boolean contains (T x){
        return (Objects.equals (x, a) || Objects.equals (x, b));
    }

    public Pair<T> swapped (){
        return new Pair<T> (b, a);
    }

    public String toString (){
        return "(" + a + ", " + b + ")";
    }
}
