package it.polito.shop;

public class Product {
    private String name;
    private double price;
    int stock;

    public Product (String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName (){
        return name;
    }

    public double getPrice (){
        return price;
    }

    public int getStock (){
        return stock;
    }

    void removeStock (int qty){
        this.stock -= qty;
    }
}
