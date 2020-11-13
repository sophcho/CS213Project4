package sample;

import javafx.scene.image.Image;

public class Chicken extends Sandwich {

    public Chicken (Sandwich sandwich){
        super(sandwich);
    }

    public Chicken (){
        super();
    }

    @Override
    public double price() {
        return 8.99;
    }

    @Override
    public String toString(){
        return "Chicken";
    }
    @Override
    public Image sandwichImage(){
        return new Image("sample/pictures/chicken.png");
    }
}
