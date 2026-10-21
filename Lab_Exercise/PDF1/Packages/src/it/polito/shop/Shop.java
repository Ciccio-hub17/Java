package it.polito.shop;


public class Shop {
    private Product[] products;
    private int occupied=0;

    public Shop (int cp){
        products = new Product[cp];
    }

    public boolean addProduct(String name, double price, int stock){
        Product prod = find (name);
        if (occupied == products.length || prod != null){
            return false;
        }

        products[occupied++] = new Product(name, price, stock);
        return true;
    }

    public Product find (String name){
        for (int i = 0; i < occupied; i++){
            if (name.equals(products[i].getName())){
                return products[i];
            }
        }
        return null;
    }

    public double sell (String name, int qty){
        Product prod = find (name);
        if (prod == null || qty <= 0 || prod.stock < qty){
            return -1;
        }
        
        return Discounts.apply(prod.getPrice(), qty);
    }

    public int stockOf (String name){
        Product prod = find (name);

        if (prod == null){
            return 0;
        }

        return prod.stock;
    }
}
