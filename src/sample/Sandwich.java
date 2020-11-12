package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;

    public Sandwich(){
        extras = new ArrayList<Extra>();
    }

    public Sandwich(Sandwich sandwich){
        this.extras = new ArrayList<Extra>();
        this.extras.addAll(sandwich.extras);
    }

    public abstract double price();
    @Override
    public boolean add(Object obj) {
        return false;
    }

    public abstract Image sandwichImage();

    @Override
    public boolean remove(Object obj) {
        return false;
    }


    public String toString(){
        return null;
    };

}
