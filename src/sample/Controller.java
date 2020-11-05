package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView<String> listView;

    final ObservableList<String> listItems = FXCollections.observableArrayList(
            "Add Items here");

    @Override
    public void initialize(URL url, ResourceBundle rb){
        String a = "a";
        String  b = "b";

        listItems.addAll(a, b);
        listView.setItems(listItems);
    }

    public void newStage() throws Exception{
        Parent part = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

}
