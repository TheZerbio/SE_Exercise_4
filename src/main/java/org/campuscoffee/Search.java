package org.campuscoffee;

import java.util.ArrayList;
import java.util.List;


public class Search {
   private List<CoffeStore> stores = new ArrayList<>();

   public Search() {
       stores.add(new CoffeStore("Crazy Sheep",Location.UNI,true));
       stores.add(new CoffeStore("Cafeteria",Location.UNI,true));
       stores.get(0).setPrice("Cappuccino", 3);
       stores.get(1).setPrice("Cappuccino", 4);
       stores.get(0).setPrice("Latte macchiato", 6);
       stores.get(1).setPrice("Latte macchiato", 5);
   }
   /// Returns a List of all Stores that are registerd
   public List<CoffeStore> getAllStores() {
       return stores;
   }
   /// Deletes all registered stores
   public void clearStores() {
       stores.clear();
   }
   /// Returns a List of all Stores with Location l
   public List<CoffeStore> getStoresClose(Location l){
       return stores.stream().filter(x -> x.getLocation().equals(l)).toList();
   }
   /// Returns a List of all Stores that have a Cup Return Point
   public List<CoffeStore> getStoresReusable(){
       return stores.stream().filter(CoffeStore::getReturnPoint).toList();
   }
   ///Adds a Store to the List of Registered Stores
   public void addStore(CoffeStore store){
       stores.add(store);
   }

   ///Retrieves Stores by their name and compares their prices for a specific Coffee
   /// Input Names need to be Stores in the List and both Stores need to sell coffeeType
   /// Returns the CoffeeStore Object with the Lower Price
   public CoffeStore compareByPrice(String Coffee1, String Coffee2, String coffeeType){
       CoffeStore store1 = stores.stream().filter(x -> x.getName().equals(Coffee1)).findFirst().get();
       CoffeStore store2 = stores.stream().filter(x -> x.getName().equals(Coffee2)).findFirst().get();
       if(Coffee1.equals(Coffee2)){
           return store1;
       }
       return store1.getPrice(coffeeType) < store2.getPrice(coffeeType) ? store1 : store2;
   }
}
