package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    //@Override
   // public void start(Stage stage) throws Exception {

      //  Parent root = FXMLLoader.load(getClass().getResource("view/Auth.fxml"));
        //stage.setTitle("UNILIBERTE");

        //stage.setScene(new Scene(root));
        //stage.show();
    //}

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new StackPane());

        LoginManager loginManager = new LoginManager(scene);
        loginManager.showLoginScreen();

        stage.setScene(scene);
        stage.show();
    }
}
