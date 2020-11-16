package sample;

import javafx.scene.image.Image;

/* Container Class that models a Chicken Sandwich Object.
 *Chicken extends Sandwich and implements abstract methods price(),sandwichImage(), and basicIngredients.
 *@author Mohamed Moussa, Sophia Cho
 */
public class Chicken extends Sandwich {

    /* Default Constructor for Chicken Class.
     * Calls Sandwich Constructor to instantiate the Extras Container object.
     */
    public Chicken() {
        super();
    }

    /* Copy Constructor copies sandwich object values into new Chicken instance.
     *Calls Sandwich Constructor to add the Extras to the new Chicken sandwich created.
     * @param sandwich Sandwich instance used to copy into a new instance
     */
    public Chicken(Sandwich sandwich) {
        super(sandwich);
    }

    /* Abstract Method implemented from Sandwich Class. Returns Price of the sandwich.
     *@return sandwich price as a double
     */
    @Override
    public double price() {
        return SandwichConstants.CHICKEN_PRICE;
    }

    /* String representation of Chicken Sandwich.
     *@return String representation of type of Sandwich
     */
    @Override
    public String toString() {
        return "Chicken";
    }

    /* Creates a new Image object that represents a Chicken Sandwich.
     * .png files are placed in pictures directory.
     *@return Image Image object that contains a png of a Chicken Sandwich
     */
    @Override
    public Image sandwichImage() {
        return new Image("sample/pictures/chicken.png");
    }

    /* Returns Basic Ingredients in Chicken Sandwich.
     *@return String that contains Basic Ingredients present in Sandwich.
     */
    @Override
    public String basicIngredients() {
        return "Fried Chicken, Spicy Sauce, Pickles";
    }
}
