package sample;

import javafx.scene.image.Image;

public class Fish  extends Sandwich{
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
        return new Image("https://cdn.discordapp.com/attachments/753703688316518465/774073531838496798/ArbyE28099s-Introduces-New-Beer-Battered-Fish-Sandwich-678x381.png");
    }
}
