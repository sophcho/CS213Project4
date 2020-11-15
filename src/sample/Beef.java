package sample;
import javafx.scene.image.Image;

public class Beef extends Sandwich {

    public Beef (Sandwich sandwich){
        super(sandwich);
    }

    public Beef (){
        super();
    }

    @Override
    public double price() {
        return 10.99;
    }

    @Override
    public String toString(){
        return "Beef";
    }

    public String basicIngredients(){
        return "Roast Beef, Provolone Cheese, Mustard";
    }

    @Override
    public Image sandwichImage(){
        return new Image("sample/pictures/Beef.png");
    }
}
