package sample;

import javafx.scene.image.Image;

/* Container Class that models a Beef Sandwich Object.
 *Beef extends Sandwich and implements abstract methods price(),sandwichImage(), and basicIngredients.
 *@author Mohamed Moussa, Sophia Cho
 */
public class Beef extends Sandwich {
    /* Default Constructor for Beef Class.
     * Calls Sandwich Constructor to instantiate the Extras Container object.
     */
    public Beef() {
        super();
    }

    /* Copy Constructor copies sandwich object values into new Beef instance.
     *Calls Sandwich Constructor to add the Extras to the new Beef sandwich created.
     * @param sandwich Sandwich instance used to copy into a new instance
     */
    public Beef(Sandwich sandwich) {
        super(sandwich);
    }

    /* Abstract Method implemented from Sandwich Class. Returns Price of the sandwich.
     *@return sandwich price as a double
     */
    @Override
    public double price() {
        return SandwichConstants.BEEF_PRICE;
    }

    /* String representation of Beef Sandwich.
     *@return String representation of type of Sandwich
     */
    @Override
    public String toString() {
        return "Beef";
    }

    /* Returns Basic Ingredients in Beef Sandwich.
     *@return String that contains Basic Ingredients present in Sandwich.
     */
    public String basicIngredients() {
        return "Roast Beef, Provolone Cheese, Mustard";
    }

    /* Creates a new Image object that represents a Beef Sandwich.
     *@return Image Image object that contains a png of a Beef Sandwich
     */
    @Override
    public Image sandwichImage() {
        return new Image("sample/pictures/Beef.png");
    }
}
