package sample;
import java.util.ArrayList;
public class Order implements Customizable{
    public static int lineNumber;
    private ArrayList<Orderline> orderlines;

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
