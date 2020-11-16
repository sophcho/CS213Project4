package sample;

import javafx.scene.image.Image;

/* Container Class that models a Fish Sandwich Object.
 *Chicken extends Sandwich and implements abstract methods price(),sandwichImage(), and basicIngredients.
 *@author Mohamed Moussa, Sophia Cho
 */
public class Fish extends Sandwich {
    /* Default Constructor for Fish Class.
     * Calls Sandwich Constructor to instantiate the Extras Container object.
     */
    public Fish() {
        super();
    }

    /* Copy Constructor copies sandwich object values into new Fish instance.
     *Calls Sandwich Constructor to add the Extras to the new Fish sandwich created.
     * @param sandwich Sandwich instance used to copy into a new instance
     */
    public Fish(Sandwich sandwich) {
        super(sandwich);
    }

    /* Abstract Method implemented from Sandwich Class. Returns Price of the sandwich.
     *@return sandwich price as a double
     */
    @Override
    public double price() {
        return SandwichConstants.FISH_PRICE;
    }

    /* String representation of Fish Sandwich.
     *@return String representation of type of Sandwich
     */
    @Override
    public String toString() {
        return "Fish";
    }

    /* Creates a new Image object that represents a Fish Sandwich.
     * .png files are placed in pictures directory.
     *@return Image Image object that contains a png of a Fish Sandwich
     */
    @Override
    public Image sandwichImage() {
        return new Image("sample/pictures/fish.png");
    }

    /* Returns Basic Ingredients in Fish Sandwich.
     *@return String that contains Basic Ingredients present in Sandwich.
     */
    public String basicIngredients() {
        return "Grilled Snapper, Cilantro, Lime";
    }
}
