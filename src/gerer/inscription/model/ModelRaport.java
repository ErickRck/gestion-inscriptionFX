package gerer.inscription.model;

import javafx.beans.property.SimpleStringProperty;

public class ModelRaport {

    public SimpleStringProperty id;
    public SimpleStringProperty faculte;
    public SimpleStringProperty option;
    public SimpleStringProperty promotion;
    public SimpleStringProperty nom;
    public SimpleStringProperty postnom;
    public SimpleStringProperty prenom;
    public SimpleStringProperty lieuxdatedenaissance;
    public SimpleStringProperty sexe;
    public SimpleStringProperty telephon;
    public SimpleStringProperty email;
    public SimpleStringProperty adresse;
    public SimpleStringProperty tuteur;
    public SimpleStringProperty teltuteur;

    public  ModelRaport(String id, String faculte, String option, String promotion, String nom, String postnom, String prenom, String lieuxdatedenaissance, String sexe, String telephon, String email, String adresse, String tuteur, String teltuteur) {

        this.id = new SimpleStringProperty(id);
        this.faculte = new SimpleStringProperty(faculte);
        this.option = new SimpleStringProperty(option);
        this.promotion = new SimpleStringProperty(promotion);
        this.nom = new SimpleStringProperty(nom);
        this.postnom = new SimpleStringProperty(postnom);
        this.prenom = new SimpleStringProperty(prenom);
        this.lieuxdatedenaissance = new SimpleStringProperty(lieuxdatedenaissance);
        this.sexe = new SimpleStringProperty(sexe);
        this.telephon = new SimpleStringProperty(telephon);
        this.email = new SimpleStringProperty(email);
        this.adresse = new SimpleStringProperty(adresse);
        this.tuteur = new SimpleStringProperty(tuteur);
        this.teltuteur = new SimpleStringProperty(teltuteur);
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public SimpleStringProperty faculteProperty() {
        return faculte;
    }

    public SimpleStringProperty optionProperty() {
        return option;
    }

    public SimpleStringProperty promotionProperty() {
        return promotion;
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public SimpleStringProperty postnomProperty() {
        return postnom;
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public SimpleStringProperty lieuxdatedenaissanceProperty() {
        return lieuxdatedenaissance;
    }

    public SimpleStringProperty sexeProperty() {
        return sexe;
    }

    public SimpleStringProperty telephonProperty() {
        return telephon;
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public SimpleStringProperty adresseProperty() {
        return adresse;
    }

    public SimpleStringProperty tuteurProperty() {
        return tuteur;
    }

    public SimpleStringProperty teltuteurProperty() {
        return teltuteur;
    }


}
