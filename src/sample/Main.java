package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* Driver Class that creates GUI to display to User
 *FXML files are used through Scene Builder to Design GUI display, which is then loaded using FXMLLoader
 * @author Mohamed Moussa, Sophia Cho
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("sample" +
                ".fxml"));
        Parent part = loader1.load();
        primaryStage.setTitle("Sandwich Shop");
        Scene scene = new Scene(part, 807, 354);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
