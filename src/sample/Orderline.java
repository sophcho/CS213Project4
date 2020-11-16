package sample;

/*Container Class used the represent Current OrderLines to be placed in total Order.
 *@author Mohamed Moussa, Sophia Cho
 */
public class Orderline {
    private int lineNumber;
    private Sandwich sandwich;
    private double price;

    /* Parameterized Constructor for Orderline Class. Takes Sandwich and its price and creates Orderline instance.
     * Uses Static Order.lineNumber in order to provide an identification Number for each Orderline.
     * @param sandwich Sandwich being ordered
     * @price price total price of Sandwich being ordered.
     */
    public Orderline(Sandwich sandwich, double price) {
        this.sandwich = sandwich;
        this.price = price;
        this.lineNumber = Order.lineNumber;
    }

    /* Copy Constructor takes Orderline Instance and copies content into a new Orderline.
     * Uses Static Order.lineNumber in order to provide an identification Number for each Orderline.
     * @param sandwich Sandwich being ordered
     * @price price total price of Sandwich being ordered.
     */
    public Orderline(Orderline orderline) {
        this.sandwich = orderline.sandwich;
        this.price = orderline.price;
        this.lineNumber = Order.lineNumber;
    }

    /* String Representation of Orderline uses sandwich to string to display sandwich ingredients content
     *@return String representation of Orderline.
     */
    @Override
    public String toString() {
        return String.format("Order %d: %s Sandwich with %s and %s, $%.2f",
                lineNumber,
                sandwich, sandwich.basicIngredients(), sandwich.extras, price);
    }

    /* Setter Method which Changes LineNumber of OrderLine instance
     * Used during process of removing Orders and re-assigning identification numbers to Orderlines.
     * @param i value to change lineNumber to.
     */
    public void changeLineNumber(int i) {
        this.lineNumber = i;
    }
}
