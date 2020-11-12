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
        return new Image("https://media.discordapp.net/attachments/753703688316518465/774073825092304936/chicken.png?width=588&height=378");
    }
}
