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

    public Orderline(Orderline orderline){
        this.sandwich = orderline.sandwich;
        this.price = orderline.price;
        this.lineNumber = Order.lineNumber;
    }

    public String toString(){
        return String.format("%d: %s Sandwich with: %s, %f", lineNumber,
                sandwich, sandwich.extras.toString()
                , price);
    }

    public void changeLineNumber(int i){
        this.lineNumber = i;
    }
}
