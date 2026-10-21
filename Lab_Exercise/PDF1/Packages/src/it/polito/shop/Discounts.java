package it.polito.shop;

class Discounts {
    static double apply (double price, int qty){
        if (qty >= 10){
            return price*qty*90/100;
        }
        return price*qty;
    }
}
