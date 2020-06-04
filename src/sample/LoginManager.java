package sample;

import gerer.inscription.view.InscriptionController;
import gerer.rapport.view.AcceuilRapportController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.view.AuthController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginManager {
    private Scene scene;

    public LoginManager(Scene scene) {
        this.scene = scene;
    }

    public void authenticated(String sessionID) {
        showMainView(sessionID);
    }
    public void authenticated1(String sessionID){
        showMainInscription(sessionID);
    }

    public void logout() {
        showLoginScreen();
    }

    public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("view/Auth.fxml")
            );
            scene.setRoot((Parent) loader.load());
            AuthController controller =
                    loader.<AuthController>getController();
            controller.initManager(this);
        } catch (IOException e) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void showMainView(String sessionID) {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("../gerer/rapport/view/AcceuilRapport.fxml")
            );
            scene.setRoot((Parent) loader.load());
            AcceuilRapportController controller = loader.<AcceuilRapportController>getController();
            controller.initSessionID(this, sessionID);
        }
        catch(IOException e) {
        Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    private void showMainInscription(String sessionID){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("../gerer/inscription/view/Inscription.fxml")
            );
            scene.setRoot((Parent) loader.load());
            InscriptionController controller = loader.<InscriptionController>getController();
            controller.initSessionID(this, sessionID);
        }catch (IOException e){
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
