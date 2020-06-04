package gerer.rapport.view;

import gerer.rapport.model.DBconnector;
import gerer.rapport.model.ModelTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.LoginManager;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AcceuilRapportController implements Initializable {

    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    @FXML
    private Button btn_refresh;
    @FXML
    private Label sessionLabel;
    @FXML
    private Button Deconnecter;
    @FXML
    private MenuButton  info;
    @FXML
    private MenuItem mi_isi;
    @FXML
    private MenuItem mi_ig;
    @FXML
    private MenuItem mi_rt;
    @FXML
    private MenuItem mi_lettre;
    @FXML
    private MenuItem mi_communication;
    @FXML
    private MenuItem mi_journalisme;
    @FXML
    private MenuItem mi_anglais;
    @FXML
    private MenuItem mi_theologie;
    @FXML
    private MenuItem mi_polytechnique;
    @FXML
    private MenuItem mi_droit;

    @FXML
    private MenuButton btn_sic;
    @FXML
    private MenuButton btn_droit;
    @FXML
    private MenuButton btn_theologie;
    @FXML
    private MenuButton btn_lettre;
    @FXML
    private MenuButton btn_polytechnique;
    @FXML
    private MenuButton btn_anglais;
    @FXML
    private Button btn_supprimer;
    @FXML private TextField ch_id;


    @FXML
    private TableView<ModelTable> inscription;
    @FXML
    private TableColumn<ModelTable, String> col_id;
    @FXML
    private TableColumn<ModelTable, String> col_faculte;
    @FXML
    private TableColumn<ModelTable, String> col_option;
    @FXML
    private TableColumn<ModelTable, String> col_promotion;
    @FXML
    private TableColumn<ModelTable, String> col_nom;
    @FXML
    private TableColumn<ModelTable, String> col_postnom;
    @FXML
    private TableColumn<ModelTable, String> col_prenom;
    @FXML
    private TableColumn<ModelTable, String> col_lieuxdatedenaissance;
    @FXML
    private TableColumn<ModelTable, String> col_sexe;
    @FXML
    private TableColumn<ModelTable, String> col_telephone;
    @FXML
    private TableColumn<ModelTable, String> col_email;
    @FXML
    private TableColumn<ModelTable, String> col_adresse;
    @FXML
    private TableColumn<ModelTable, String> col_tuteur;
    @FXML
    private TableColumn<ModelTable, String> col_teltuteur;
    @FXML
    private String rowClicked;


    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            conn = DBconnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        getAll();
        initTableColumn();


    }
    public void initSessionID(final LoginManager loginManager, String sessionID){

        sessionLabel.setText(sessionID);
        Deconnecter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginManager.logout();
            }
        });
    }
    public void initTableColumn(){
        col_id.setCellValueFactory(new PropertyValueFactory("id"));
        col_faculte.setCellValueFactory(new PropertyValueFactory("faculte"));
        col_option.setCellValueFactory(new PropertyValueFactory("option"));
        col_promotion.setCellValueFactory(new PropertyValueFactory("promotion"));
        col_nom.setCellValueFactory(new PropertyValueFactory("nom"));
        col_postnom.setCellValueFactory(new PropertyValueFactory("postnom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory("prenom"));
        col_lieuxdatedenaissance.setCellValueFactory(new PropertyValueFactory("lieuxdatedenaissance"));
        col_sexe.setCellValueFactory(new PropertyValueFactory("sexe"));
        col_telephone.setCellValueFactory(new PropertyValueFactory("telephon"));
        col_email.setCellValueFactory(new PropertyValueFactory("email"));
        col_adresse.setCellValueFactory(new PropertyValueFactory("adresse"));
        col_tuteur.setCellValueFactory(new PropertyValueFactory("tuteur"));
        col_teltuteur.setCellValueFactory(new PropertyValueFactory("teltuteur"));

        inscription.setItems(oblist);
    }
    public void  getAll(){
        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    public void btn_refresh(){
        getAll();
    }
    public void mi_isi(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='isi' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mi_ig(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='ig' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mi_rt(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='rt' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mi_lettre(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='lettre' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mi_droit(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='droit' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mi_polytechnique(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='polytechnique' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mi_communication(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='communication' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mi_journalisme(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='journalisme' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mi_theologie(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='theologie' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mi_anglais(){

        inscription.getItems().clear();
        try {

            pst=conn.prepareStatement("SELECT * FROM rapport WHERE `option`='anglais' ");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void btn_supprimer(){
        if(Integer.parseInt(rowClicked)>0) {

            try {
                pst.execute("DELETE FROM `rapport` WHERE `id` = "+rowClicked);
                getAll();

                btn_refresh.setDisable(false);
                btn_supprimer.setDisable(false);
                ch_id.clear();
            }catch(Exception E) { E.printStackTrace();}

        }else {

        }

    }
    public void tableClickedEvent(){

        try {
            rowClicked = inscription.getSelectionModel().getSelectedItems().get(0).idProperty().get();
            ch_id.setText(rowClicked);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
