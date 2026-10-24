package ex6_1;

import java.util.Objects;

public class Couple<A, B> {
    private final A first;
    private final B second;

    public Couple (A first, B second){
        this.first = first;
        this.second = second;
    }

    public A first (){
        return first;
    }

    public B second (){
        return second;
    }

    public Couple<B,A> swap(){
        return new Couple<B,A> (second, first);
    }

    public <C> Couple <A, C> withSecond (C value){
        return new Couple <> (this.first, value);
    }

    @Override
    public boolean equals (Object o){
        if (!(o instanceof Couple <?, ?> other)){
            return false;
        }

        return Objects.equals (first, other.first) && Objects.equals (second, other.second);
    }

    public String toString (){
        return "<"+first+", "+second+">";
    }

    @Override
    public int hashCode (){
        return Objects.hash (first, second);
    }

}
