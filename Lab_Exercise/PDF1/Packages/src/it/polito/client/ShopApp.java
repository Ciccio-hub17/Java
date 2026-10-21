package it.polito.client;

import it.polito.shop.*;

public class ShopApp {
    public static void main (){
        Shop shop = new Shop(10);
        shop.addProduct("pen", 1.5, 20);
        shop.addProduct("notebook", 4.0, 3);
        IO.println(shop.sell("pen", 2));
        IO.println(shop.sell("pen", 10));
        IO.println(shop.sell("notebook", 5));
        IO.println(shop.sell("eraser", 1));
        IO.println(shop.stockOf("pen") + " " + shop.stockOf("notebook"));
        Product p = shop.find("pen");
        IO.println(p.getName() + " " + p.getPrice() + " " + p.getStock());
    }
}
