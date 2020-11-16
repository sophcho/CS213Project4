package sample;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.ArrayList;

/*Abstract class used to represent a Sandwich with Extra ingredients Container.
 *Implements Interface Customizable which includes add,remove methods.
 * Maximum Extras per Sandwich is 6 and price per extra is $1.99.
 * @author Mohamed Moussa, Sophia Cho
 */
public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;

    /*Default Constructor that instantiates Extra Container Array
     *Called from Classes that inherit Sandwich
     */
    public Sandwich() {
        extras = new ArrayList<Extra>();
    }

    /*Copy Constructor that creates a new Sandwich instance based on the Sandwich passed
     *@param sandwich Sandwich instance used to copy into a new instance
     */
    public Sandwich(Sandwich sandwich) {
        this.extras = new ArrayList<Extra>();
        this.extras.addAll(sandwich.extras);
    }

    //Abstract Method to be implemented by Subclasses returns price of sandwich
    public abstract double price();

    /* Method implemented from Customizable.
     *Adds Extras to the Sandwich Extras container Array.
     *returns false if nothing is added or if the limit on ingredients is reached.
     *@param Object to add into Extras Array
     *@return boolean based on if the object was added or not
     */
    @Override
    public boolean add(Object obj) {
        if (obj == null) {
            return false;
        }
        ObservableList<Extra> extra = (ObservableList<Extra>) obj;
        if (extra.size() > MAX_EXTRAS || extra.size() + this.extras.size() > MAX_EXTRAS) {
            return false;
        }
        this.extras.addAll(extra);
        return true;
    }

    //Abstract Method to return an Image of the Sandwich
    public abstract Image sandwichImage();

    /* Method implemented from Customaziable
     * Removes Extras from current Sandwich Extras Array
     * @param obj object that contains Extras to be added to the Sandwich Extras Array
     * False is returned if the object passed is null or doesn't contain any extras.
     * @return true if extras was added, false if extras weren't added
     */
    @Override
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        ObservableList<Extra> extra = (ObservableList<Extra>) obj;
        if (extra.size() == 0) {
            return false;
        }
        this.extras.removeAll(extra);
        return true;
    }

    /* String representation of Sandwich Extras. Overrides java toString method
     * Called by OrderLine toString() to return a String representation of Sandwich
     *@return String representation of Sandwich Extras
     */
    @Override
    public String toString() {
        return this.extras.toString();
    }

    //Abstract Method that returns Basic Ingredients per Sandwich
    public abstract String basicIngredients();
}
