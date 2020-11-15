package sample;
import javafx.scene.image.Image;

public class Fish  extends Sandwich{

    public Fish (Sandwich sandwich){
        super(sandwich);
    }

    public Fish (){
        super();
    }

    @Override
    public double price() {
        return 12.99;
    }

    @Override
    public String toString(){
        return "Fish";
    }

    @Override
    public Image sandwichImage(){
        return new Image("sample/pictures/fish.png");
    }

    public String basicIngredients(){
        return "Grilled Snapper, Cilantro, Lime";
    }
}
