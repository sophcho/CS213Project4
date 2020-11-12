package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("sample" +
                ".fxml"));
        Parent part = loader1.load();
        Controller controller1 = loader1.getController();
        controller1.setThisStage(primaryStage);
        primaryStage.setTitle("Sandwich Shop");
        Scene scene = new Scene(part, 500, 800);
        controller1.setThisScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
