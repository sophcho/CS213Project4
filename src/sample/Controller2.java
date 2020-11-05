package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {

    @FXML
    private ListView<String> listView;

    @FXML
    private GridPane Stage2;

    final ObservableList<String> listItems = FXCollections.observableArrayList(
            "Add Items here");

    @Override
    public void initialize(URL url, ResourceBundle rb){
        String a = "a";
        String  b = "b";

        listItems.addAll(a, b);
        listView.setItems(listItems);
    }


}
