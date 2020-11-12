package sample;
import java.util.ArrayList;
public class Order implements Customizable{
    public static int lineNumber;
    private ArrayList<Orderline> orderlines;

    public Order(){
        lineNumber = 1;
        orderlines = new ArrayList<Orderline>();
    }

    @Override
    public boolean add(Object obj) {
        if (!(obj instanceof Orderline)){
            return false;
        }
        Orderline newOrderline = (Orderline)obj;
        orderlines.add(newOrderline);
        lineNumber++;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (!(obj instanceof Orderline)){
            return false;
        }
        orderlines.remove(obj);
        return true;
    }

    public ArrayList<Orderline> passOrderlines(){
        return orderlines;
    }


}
