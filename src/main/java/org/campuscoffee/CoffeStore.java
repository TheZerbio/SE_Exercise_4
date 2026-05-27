package org.campuscoffee;

import java.util.HashMap;
///  CoffeeStore class stores data for each Store
public class CoffeStore {
    private String Name;
    private Location Location;
    private boolean ReturnPoint;
    private HashMap<String,Integer> prices = new HashMap<>();

    public CoffeStore(String name, Location location, boolean returnPoint) {
        Name = name;
        Location = location;
        ReturnPoint = returnPoint;
    }

    public String getName() {
        return Name;
    }
    public Location getLocation() {
        return Location;
    }
    public boolean getReturnPoint() {
        return ReturnPoint;
    }
    public HashMap<String,Integer> getPrices() {
        return prices;
    }
    public void setPrice( String coffee, int price) {
        if(price > 0)
            prices.put(coffee,price);
    }

    public int getPrice( String coffee) {
       return prices.get(coffee);
    }

}
