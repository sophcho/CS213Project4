package sample;

/* Container Class that represents Extras to be added to a Sandwich.
 * Extras are identified by a unique name they are given.
 *@author Mohamed Moussa, Sophia Cho
 */
public class Extra {
    private String name; //Name of Extra Ingredient

    /*Main Constructor for Extra class.
     *Sets String passed to Extra's name
     *@param name String name of Extra Ingrident.
     */
    public Extra(String name) {
        this.name = name;
    }

    /* String Representation of Extra Object, identified by name.
     *@return name of Extra instance,
     */
    @Override
    public String toString() {
        return this.name;
    }
}
