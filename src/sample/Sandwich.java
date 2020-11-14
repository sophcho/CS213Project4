package sample;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.ArrayList;

/*Abstract class used to represent a Sandwich with Extra ingredients Container.
 *Implements Interface Customizable which includes add,remove methods.
 * Maximum Extras per Sandwich is 6 and price per extra is $1.99.
 */
public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras; //Container for Extra Objects

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

    //Abstract Method to be implemented by Subclasses
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

    public abstract Image sandwichImage();

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


    public String toString() {
        return this.extras.toString();
    }


}
