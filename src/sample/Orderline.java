package sample;

public class Orderline {
    private int lineNumber;
    private Sandwich sandwich;
    private double price;

    public Orderline(Sandwich sandwich, double price){
        this.sandwich = sandwich;
        this.price = price;
        this.lineNumber = Order.lineNumber;
    }
    //copy constructor
    public Orderline(Orderline orderline){
        this.sandwich = orderline.sandwich;
        this.price = orderline.price;
        this.lineNumber = Order.lineNumber;
    }

    public String toString(){
        return String.format("Order %d: %s Sandwich with %s and %s, $%.2f",
                lineNumber,
                sandwich, sandwich.basicIngredients(), sandwich.extras, price);
    }

    public void changeLineNumber(int i){
        this.lineNumber = i;
    }
}
