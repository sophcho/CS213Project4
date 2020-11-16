package sample;

import java.util.ArrayList;

/*Container Class that models Sandwich Orders, OrderLines are stored which contain information about each order
placed by customer. Each Order has an increasing lineNumber that is used to number OrderLines in Container
Array.
 *@author Mohamed Moussa, Sophia Cho
 */
public class Order implements Customizable {
    public static int lineNumber;
    private ArrayList<Orderline> orderlines;

    /* Default Constructor for Order Class, sets Line number to 1 and instantiates orderlines array.
     *
     */
    public Order() {
        lineNumber = 1;
        orderlines = new ArrayList<Orderline>();
    }

    /* Add Method implemented from Customizable, Adds orderline to array of orderLines.
     *If the object passed is not an instance of Orderline, object isn't added and false is returned.
     *@param obj Object to be added to the array of orderlines.
     * @return True if the object is added, false if object wasn't added.
     */
    @Override
    public boolean add(Object obj) {
        if (!(obj instanceof Orderline)) {
            return false;
        }
        Orderline newOrderline = (Orderline) obj;
        orderlines.add(newOrderline);
        lineNumber++;
        return true;
    }

    /* Remove Method implemented form Customizable, Removes orderline from array of orderLines
     *If the object passes is not an instance of OrderLine, object isn't removed and false is returned.
     * @param obj Object to remove from the array of orderlines.
     * @return True if the object is removed, false is object wasn't removed.
     */
    @Override
    public boolean remove(Object obj) {
        if (!(obj instanceof Orderline)) {
            return false;
        }
        return orderlines.remove(obj);
    }

    /* Getter Method which returns a clone of the current Orderlines.
     *Used by Controller2 during the process of Removing Orders and reordering remaining Orders.
     * @return ArrayList<Orderline> container Orderlines in current Order.
     */
    public ArrayList<Orderline> passOrderlines() {
        ArrayList<Orderline> orderLines = new ArrayList<Orderline>();
        orderLines.addAll(this.orderlines);
        return orderLines;
    }
}
