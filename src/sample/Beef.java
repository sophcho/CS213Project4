package sample;

import javafx.scene.image.Image;

public class Beef extends Sandwich {
    @Override
    public double price() {
        return 10.99;
    }

    @Override
    public String toString(){
        return "Beef";
    }
    @Override
    public Image sandwichImage(){
        return new Image("https://media.discordapp.net/attachments/753703688316518465/774075378854527036/unknown.png");
    }
}
