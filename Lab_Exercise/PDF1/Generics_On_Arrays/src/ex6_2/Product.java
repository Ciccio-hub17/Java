package ex6_2;

public record Product(String name, double price) implements Comparable<Product> {
    @Override
    public int compareTo (Product p){
        return Double.compare (this.price, p.price);
    }
}
