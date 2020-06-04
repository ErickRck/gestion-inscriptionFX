package sample.view;

import gerer.rapport.model.DBconnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.LoginManager;
import sample.model.AuthModel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AuthController  {

    @FXML private TextField inputIdentifiant;
    @FXML private  TextField inputPassword;
    @FXML private Text actiontarget;
    @FXML private Button Connecter;

    private String getIdentifiant;
    private String getPassword;
    private String getRole;

    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;

    ObservableList<AuthModel> oblist = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        try {
            conn = DBconnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void initManager(final LoginManager loginManager){
        Connecter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String sessionID = authorize();
                if ("open".equals(inputIdentifiant.getText()) && "sesame".equals(inputPassword.getText())){
                    loginManager.authenticated(sessionID);
                }else if ("rck".equals(inputIdentifiant.getText()) && "rck".equals(inputPassword.getText())){
                    loginManager.authenticated1(sessionID);
                }
            }
        });
    }

    private void verification(){
        try {
            pst=conn.prepareStatement("SELECT * FROM users");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new AuthModel(rs.getString("id"),
                        rs.getString("identifiant"),
                        rs.getString("password"),
                        rs.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String authorize(){

                return
                        "open".equals(inputIdentifiant.getText()) && "sesame".equals(inputPassword.getText())
                                ? generateSessionID()
                                : null;


    }
    private static int sessionID = 0;

    private String generateSessionID(){
        sessionID++;
        return "xyzzy = session " +sessionID;
    }
}
