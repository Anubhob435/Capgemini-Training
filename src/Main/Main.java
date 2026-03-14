package src.Main;

import java.util.List;

import java.util.*;

//--- Helper Classes ---

class Node {
 String fruit;
 int count;

 public Node(String fruit, int count) {
     this.fruit = fruit;
     this.count = count;
 }
}

class Grocery {
 String fruit;
 double price;
 double total;

 public Grocery(String fruit, double price, double total) {
     this.fruit = fruit;
     this.price = price;
     this.total = total;
 }
}

abstract class GroceryReceiptBase {
 private Map<String, Double> prices;
 private Map<String, Integer> discounts;

 public GroceryReceiptBase(Map<String, Double> prices, Map<String, Integer> discounts) {
     this.prices = prices;
     this.discounts = discounts;
 }

 public Map<String, Double> getPrices() {
     return prices;
 }

 public Map<String, Integer> getDiscounts() {
     return discounts;
 }
}

//--- Your Implementation ---

class GroceryReceipt extends GroceryReceiptBase {

 // 1. Create the constructor that calls the parent constructor
 public GroceryReceipt(Map<String, Double> prices, Map<String, Integer> discounts) {
     super(prices, discounts);
 }

 // 2. Implement the Calculate method
 public List<Grocery> Calculate(List<Node> shoppingLists) {
     // Map to aggregate the total quantity for each fruit
     Map<String, Integer> aggregatedItems = new HashMap<>();
     
     for (Node item : shoppingLists) {
         aggregatedItems.put(item.fruit, aggregatedItems.getOrDefault(item.fruit, 0) + item.count);
     }

     List<Grocery> finalReceipt = new ArrayList<>();
     Map<String, Double> pricesMap = getPrices();
     Map<String, Integer> discountsMap = getDiscounts();

     // Calculate totals for each aggregated item
     for (Map.Entry<String, Integer> entry : aggregatedItems.entrySet()) {
         String fruitName = entry.getKey();
         int totalQuantity = entry.getValue();
         
         // Get original unit price
         double unitPrice = pricesMap.get(fruitName);
         
         // Calculate gross total
         double totalPrice = unitPrice * totalQuantity;
         
         // Apply discount if it exists
         if (discountsMap.containsKey(fruitName)) {
             double discountPercentage = discountsMap.get(fruitName);
             totalPrice = totalPrice - (totalPrice * (discountPercentage / 100.0));
         }
         
         // Add to the final receipt list
         finalReceipt.add(new Grocery(fruitName, unitPrice, totalPrice));
     }

     // Sort the receipt alphabetically by fruit name
     Collections.sort(finalReceipt, new Comparator<Grocery>() {
         @Override
         public int compare(Grocery g1, Grocery g2) {
             return g1.fruit.compareTo(g2.fruit);
         }
     });
     
     return finalReceipt;
 }
}

//--- Main Execution Class ---

public class Main {
 public static void main(String[] args) {
     
     // 1. Set up the Prices Map
     Map<String, Double> prices = new HashMap<>();
     prices.put("Apple", 31.0);
     prices.put("Banana", 39.0);
     prices.put("Orange", 47.0);

     // 2. Set up the Discounts Map
     Map<String, Integer> discounts = new HashMap<>();
     discounts.put("Apple", 40);
     discounts.put("Banana", 40);
     discounts.put("Orange", 50);

     // 3. Set up the Shopping List (Input from Sample Case 1)
     List<Node> shoppingList = new ArrayList<>();
     shoppingList.add(new Node("Banana", 4));
     shoppingList.add(new Node("Apple", 3));

     // 4. Instantiate the GroceryReceipt class
     GroceryReceipt receipt = new GroceryReceipt(prices, discounts);

     // 5. Calculate the final receipt
     List<Grocery> result = receipt.Calculate(shoppingList);

     // 6. Print the output formatted to one decimal place
     System.out.println("--- Generated Invoice ---");
     for (Grocery g : result) {
         System.out.printf("%s %.1f %.1f\n", g.fruit, g.price, g.total);
     }
 }
}