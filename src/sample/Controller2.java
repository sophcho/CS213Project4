package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller2 implements Initializable{

    @FXML
    private ListView<Orderline> listView;

    private Controller controller1;
    private Stage primaryStage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void receiveController (Controller controller){
        this.controller1 = controller;
       updateOrderlines();
    }
    public void setStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    @FXML
    void ExitStage2(ActionEvent event) {
        this.primaryStage.hide();
    }
    public void showStage(){
        this.primaryStage.show();
    }
    public boolean visible(){
        return primaryStage.isShowing();
    }
    public void updateOrderlines(){
        ObservableList<Orderline> listItems = FXCollections.observableArrayList(controller1.passOrder().passOrderlines());
        listView.setItems(listItems);
    }

    @FXML
    void ClearOrder(ActionEvent event) {
        controller1.clearOrder();
        listView.getItems().clear();

    }


    @FXML
    void AddSameOrder(ActionEvent event) {
        ObservableList<Orderline> selectedLines =
                listView.getSelectionModel().getSelectedItems();
        if(selectedLines.size() ==0){
            alertWarning("Sandwich not selected","Select a Sandwich");
            return;
        }
        Order order = controller1.passOrder();
        for (Orderline selectedLine : selectedLines) {
            order.add(new Orderline(selectedLine));
        }
        listView.setItems(FXCollections.observableArrayList(order.passOrderlines()));
    }

    @FXML
    void RemoveSelectedOrderline(ActionEvent event) {
        ObservableList<Orderline> selectedLines =
                listView.getSelectionModel().getSelectedItems();
        if(selectedLines.size() ==0){
            alertWarning("Sandwich not selected","Select a Sandwich");
            return;
        }
        Order order = controller1.passOrder();
        for (Orderline selectedLine : selectedLines) {
            order.remove(selectedLine);
        }
        ArrayList<Orderline> newOrderlines = order.passOrderlines();
        for (int i = 0; i < newOrderlines.size();i++){
            newOrderlines.get(i).changeLineNumber(i+1);
        }
        order.lineNumber = newOrderlines.size() +1;

        listView.setItems(FXCollections.observableArrayList(order.passOrderlines()));
    }

    @FXML
    void exportFile(ActionEvent event) throws IOException {
        Order order = controller1.passOrder();
        if (order.passOrderlines().size() == 0) {
            alertWarning("No Current Orders", "Add Orders before exporting");
            return;
        }
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Export order lines");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage);
        if(targetFile == null){
            alertWarning("File not selected","Please Select a file");
            return;
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(targetFile))) {
            ArrayList<Orderline> orderlines = order.passOrderlines();
            for (Orderline orderline : orderlines) {
                fileWriter.write(String.valueOf(orderline)+"\n");
            }
        }
    }
    private void alertWarning(String Header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(Header);
        alert.setContentText(content);
        alert.showAndWait();
    }


}
