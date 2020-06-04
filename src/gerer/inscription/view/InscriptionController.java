package gerer.inscription.view;

import gerer.inscription.model.ModelRaport;
import gerer.rapport.model.DBconnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.LoginManager;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InscriptionController implements Initializable {

    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;

    @FXML private TextField ch_id;
    @FXML private TextField ch_faculte;
    @FXML private TextField ch_option;
    @FXML private TextField ch_promotion;
    @FXML private TextField ch_nom;
    @FXML private TextField ch_postnom;
    @FXML private TextField ch_prenom;
    @FXML private TextField ch_lieuxdatedenaissance;
    @FXML private TextField ch_sexe;
    @FXML private TextField ch_telephone;
    @FXML private TextField ch_email;
    @FXML private TextField ch_adresse;
    @FXML private TextField ch_tuteur;
    @FXML private TextField ch_teltuteur;

    @FXML private Button insert;
    @FXML private Button update;
    @FXML private Button Deconnecter;
    @FXML private Label labelSession;

    @FXML
    private TableView<ModelRaport> inscription;
    @FXML
    private TableColumn<ModelRaport, String> col_id;
    @FXML
    private TableColumn<ModelRaport, String> col_faculte;
    @FXML
    private TableColumn<ModelRaport, String> col_option;
    @FXML
    private TableColumn<ModelRaport, String> col_promotion;
    @FXML
    private TableColumn<ModelRaport, String> col_nom;
    @FXML
    private TableColumn<ModelRaport, String> col_postnom;
    @FXML
    private TableColumn<ModelRaport, String> col_prenom;
    @FXML
    private TableColumn<ModelRaport, String> col_lieuxdatedenaissance;
    @FXML
    private TableColumn<ModelRaport, String> col_sexe;
    @FXML
    private TableColumn<ModelRaport, String> col_telephone;
    @FXML
    private TableColumn<ModelRaport, String> col_email;
    @FXML
    private TableColumn<ModelRaport, String> col_adresse;
    @FXML
    private TableColumn<ModelRaport, String> col_tuteur;
    @FXML
    private TableColumn<ModelRaport, String> col_teltuteur;

    ObservableList<ModelRaport> oblist = FXCollections.observableArrayList();

    @FXML
    private String rowClicked;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
            //Connection con = DBconnector.getConnection();
            //ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `rapport`");
            pst=conn.prepareStatement("SELECT * FROM rapport");
            rs=pst.executeQuery();

            while (rs.next()){
                oblist.add(new ModelRaport(rs.getString("id"), rs.getString("faculte"),
                        rs.getString("option"), rs.getString("promotion"),
                        rs.getString("nom"), rs.getString("postnom"),
                        rs.getString("prenom"), rs.getString("lieuxdatedenaissance"),
                        rs.getString("sexe"), rs.getString("telephon"),
                        rs.getString("email"), rs.getString("adresse"),
                        rs.getString("tuteur"), rs.getString("teltuteur")));
            }
            update.setDisable(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    public void clearTextFields(){
        ch_id.setText("");
        ch_faculte.setText("");
        ch_option.setText("");
        ch_promotion.setText("");
        ch_nom.setText("");
        ch_postnom.setText("");
        ch_prenom.setText("");
        ch_lieuxdatedenaissance.setText("");
        ch_sexe.setText("");
        ch_telephone.setText("");
        ch_email.setText("");
        ch_adresse.setText("");
        ch_tuteur.setText("");
        ch_teltuteur.setText("");
    }
    public void insert(ActionEvent e){

        try {
            pst.execute("INSERT INTO `rapport`(`id`,`faculte`,`option`,`promotion`,`nom`,`postnom`,`prenom`,`lieuxdatedenaissance`,`sexe`,`telephon`,`email`,`adresse`,`tuteur`,`teltuteur`) VALUES (NULL, '"+ch_faculte.getText()+"','"+ch_option.getText()+"','"+ch_promotion.getText()+"','"+ch_nom.getText()+"','"+ch_postnom.getText()+"','"+ch_prenom.getText()+"','"+ch_lieuxdatedenaissance.getText()+"','"+ch_sexe.getText()+"','"+ch_telephone.getText()+"','"+ch_email.getText()+"','"+ch_adresse.getText()+"','"+ch_tuteur.getText()+"','"+ch_teltuteur.getText()+"');");

            getAll();
            update.setDisable(true);
            insert.setDisable(false);
            clearTextFields();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


    }

    public  void update(){
        if (Integer.parseInt(rowClicked)>0){
            try {
                pst.execute("UPDATE `rapport`  SET `faculte`='"+ch_faculte.getText()+"',`option`='"+ch_option.getText()+"',`promotion`='"+ch_promotion.getText()+"',`nom`='"+ch_postnom.getText()+"',`prenom`='"+ch_prenom.getText()+"',`lieuxdatedenaissance`='"+ch_lieuxdatedenaissance.getText()+"',`sexe`='"+ch_sexe.getText()+"',`telephon`='"+ch_telephone.getText()+"',`email`='"+ch_email.getText()+"',`adresse`='"+ch_adresse.getText()+"',`tuteur`='"+ch_tuteur.getText()+"',`teltuteur`='"+ch_teltuteur.getText()+"' WHERE `id` ='"+ch_id.getText()+"'");

                update.setDisable(false);
                insert.setDisable(false);
                clearTextFields();
                getAll();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {

        }

    }

    public void tableClickEvent(MouseEvent mouseEvent) {

        try {

            rowClicked =inscription.getSelectionModel().getSelectedItems().get(0).idProperty().get();

            ch_id.setText(rowClicked);
            ch_faculte.setText(inscription.getSelectionModel().getSelectedItems().get(0).faculteProperty().get());
            ch_option.setText(inscription.getSelectionModel().getSelectedItems().get(0).optionProperty().get());
            ch_promotion.setText(inscription.getSelectionModel().getSelectedItems().get(0).promotionProperty().get());
            ch_nom.setText(inscription.getSelectionModel().getSelectedItems().get(0).nomProperty().get());
            ch_postnom.setText(inscription.getSelectionModel().getSelectedItems().get(0).postnomProperty().get());
            ch_prenom.setText(inscription.getSelectionModel().getSelectedItems().get(0).prenomProperty().get());
            ch_lieuxdatedenaissance.setText(inscription.getSelectionModel().getSelectedItems().get(0).lieuxdatedenaissanceProperty().get());
            ch_sexe.setText(inscription.getSelectionModel().getSelectedItems().get(0).sexeProperty().get());
            ch_telephone.setText(inscription.getSelectionModel().getSelectedItems().get(0).telephonProperty().get());
            ch_email.setText(inscription.getSelectionModel().getSelectedItems().get(0).emailProperty().get());
            ch_adresse.setText(inscription.getSelectionModel().getSelectedItems().get(0).adresseProperty().get());
            ch_tuteur.setText(inscription.getSelectionModel().getSelectedItems().get(0).tuteurProperty().get());
            ch_teltuteur.setText(inscription.getSelectionModel().getSelectedItems().get(0).teltuteurProperty().get());

            insert.setDisable(true);
            update.setDisable(false);
        }catch (Exception e){
            System.out.println("Table is empty!");
        }

    }

    public void reDisableDelBtn(MouseEvent mouseEvent) {

        insert.setDisable(false);
        update.setDisable(true);
    }

    public void initSessionID(final LoginManager loginManager, String sessionID) {
        labelSession.setText(sessionID);
        Deconnecter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginManager.logout();
            }
        });
    }
}
