package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ImageView ImageBox;
    @FXML
    private ListView<Extra> toppingsList;
    @FXML
    private ComboBox<Sandwich> LabelOptions;
    @FXML
    private Button addButton;
    @FXML
    private ListView<Extra> selectedToppingsList;
    @FXML
    private Button removeTopping;
    @FXML
    private Button submitButton;

    @FXML
    private TextField priceLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Sandwich> sandwichChoices = FXCollections.observableArrayList(new Chicken(), new Beef(), new Fish());
        ObservableList<Extra>  extraToppings = FXCollections.observableArrayList(new Extra("Tomato"), new Extra("Onions"), new Extra("Extra meat"), new Extra("Lettuce"),
                                                                                    new Extra("Extra Cheese"), new Extra("Mushrooms"), new Extra("Bacon"),
                                                                                            new Extra("Mustard"), new Extra("Ketchup"), new Extra("Red Peppers"));

        LabelOptions.setItems(sandwichChoices);
        LabelOptions.setValue(sandwichChoices.get(0));
        toppingsList.setItems(extraToppings);
        toppingsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ImageBox.setImage(sandwichChoices.get(0).sandwichImage());
        updatePrice(sandwichChoices.get(0));
    }
    @FXML
    public void newStage() throws Exception {
        Parent part = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void selectSandwich(ActionEvent event) {
        Sandwich sandwich = LabelOptions.getSelectionModel().getSelectedItem();
        ImageBox.setImage(sandwich.sandwichImage());
        sandwich.extras.clear();
        ObservableList<Extra> selectedToppings =  selectedToppingsList.getItems();
        sandwich.extras.addAll(selectedToppings);
        updatePrice(sandwich);


    }

    @FXML
    void remove(ActionEvent event) {
        Sandwich selected = currentOrder();
        ObservableList<Extra> selectedToppings =  selectedToppingsList.getSelectionModel().getSelectedItems();
        if( selectedToppings.size() ==0) {
            //show alert
            return;
        }
        selected.extras.removeAll(selectedToppings);
        toppingsList.getItems().addAll(selectedToppings);
        selectedToppingsList.getItems().removeAll(selectedToppings);
        updatePrice(selected);
    }

    @FXML
    void add(ActionEvent event) {
        Sandwich selected = currentOrder();
        ObservableList<Extra> selectedToppings =  toppingsList.getSelectionModel().getSelectedItems();
        if(selected.extras.size() == selected.MAX_EXTRAS || selected.extras.size() + selectedToppings.size() > selected.MAX_EXTRAS) {
            //show alert
            return;
        }
        selected.extras.addAll(selectedToppings);
        selectedToppingsList.getItems().addAll(selectedToppings);
        toppingsList.getItems().removeAll(selectedToppings);
        updatePrice(selected);

    }

    private Sandwich currentOrder(){
        return LabelOptions.getSelectionModel().getSelectedItem();

    }
    private void  updatePrice(Sandwich sandwich){
        double price = sandwich.price() +(sandwich.extras.size() * sandwich.PER_EXTRA);
        priceLabel.setText(String.valueOf(price));
    }
    @FXML
    void submit(ActionEvent event) {

    }

}
