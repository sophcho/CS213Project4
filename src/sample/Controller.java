package sample;

//Fix how we set up the sandwiches to add.
//Buttons on the 2nd stage  

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private ListView<Extra> selectedToppingsList;
    private Stage thisStage;

    private Order order;

    @FXML
    private TextField priceLabel;
    private Scene thisScene;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Sandwich> sandwichChoices = FXCollections.observableArrayList(new Chicken(), new Beef(), new Fish());
        ObservableList<Extra> extraToppings = FXCollections.observableArrayList(new Extra("Tomato"), new Extra("Onions"), new Extra("Extra meat"), new Extra("Lettuce"), new Extra("Extra Cheese"), new Extra("Mushrooms"), new Extra("Bacon"), new Extra("Mustard"), new Extra("Ketchup"), new Extra("Red Peppers"));

        LabelOptions.setItems(sandwichChoices);
        LabelOptions.setValue(sandwichChoices.get(0));
        toppingsList.setItems(extraToppings);
        toppingsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ImageBox.setImage(sandwichChoices.get(0).sandwichImage());
        updatePrice(sandwichChoices.get(0));
        order = new Order();
    }

    public void setThisStage(Stage stage){
        this.thisStage = stage;
    }

    public void setThisScene(Scene scene){
        this.thisScene = scene;
    }

    public Stage getThisStage(){
        return thisStage;
    }

    public Scene getThisScene(){
        return thisScene;
    }

    @FXML
    public void newStage() throws Exception {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("sample2" + ".fxml"));
        Parent part = loader2.load();
        Scene scene = new Scene(part);

        //Passing over the controller instance
        Controller2 controller2 = loader2.getController();
        controller2.receiveController(this);

        thisStage.setScene(scene);
        thisStage.show();


    }


    @FXML
    void selectSandwich(ActionEvent event) {
        Sandwich sandwich = LabelOptions.getSelectionModel().getSelectedItem();
        ImageBox.setImage(sandwich.sandwichImage());
        sandwich.extras.clear();
        ObservableList<Extra> selectedToppings = selectedToppingsList.getItems();
        sandwich.extras.addAll(selectedToppings);
        updatePrice(sandwich);


    }

    @FXML
    void remove(ActionEvent event) {
        Sandwich selected = currentOrder();
        ObservableList<Extra> selectedToppings = selectedToppingsList.getSelectionModel().getSelectedItems();
        if (selectedToppings.size() == 0) {
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
        ObservableList<Extra> selectedToppings = toppingsList.getSelectionModel().getSelectedItems();
        if (selected.extras.size() == selected.MAX_EXTRAS || selected.extras.size() + selectedToppings.size() > selected.MAX_EXTRAS) {
            alertWarning("Max Toppings", "You cannot add more than 6 " +
                    "toppings!");
            return;
        }
        selected.extras.addAll(selectedToppings);
        selectedToppingsList.getItems().addAll(selectedToppings);
        toppingsList.getItems().removeAll(selectedToppings);
        updatePrice(selected);
    }

    private Sandwich currentOrder() {
        return LabelOptions.getSelectionModel().getSelectedItem();
    }

    private void updatePrice(Sandwich sandwich) {
        double price = sandwich.price() + (sandwich.extras.size() * sandwich.PER_EXTRA);
        priceLabel.setText(String.format("%.2f", price));
    }

    @FXML
    void submit(ActionEvent event) throws Exception {
        Sandwich selected = currentOrder(), newSandwich;

        if (selected instanceof Chicken){
            newSandwich = new Chicken(selected);
        }
        else if (selected instanceof Beef){
            newSandwich = new Beef(selected);
        }
        else{
            newSandwich = new Fish(selected);
        }

        double price = Double.parseDouble(priceLabel.getText());
        Orderline orderLine = new Orderline(newSandwich, price);
        if (order.add(orderLine)) {
            System.out.println("hello");
        }
    }

    public Order passOrder() {
        return order;
    }

    public void clearOrder(){
        order = new Order();
    }

    private void alertWarning(String Header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(Header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}