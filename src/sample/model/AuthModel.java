package sample.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 */
public class AuthModel {


    public SimpleStringProperty id;
    public SimpleStringProperty identifiant;
    public SimpleStringProperty password;
    public SimpleStringProperty role;

    public AuthModel (String id, String identifiant, String password, String role){

        this.id = new SimpleStringProperty(id);
        this.identifiant = new SimpleStringProperty(identifiant);
        this.password = new SimpleStringProperty(password);
        this.role = new SimpleStringProperty(role);
    }

    public  SimpleStringProperty idProperty() {
        return id;
    }

    public SimpleStringProperty identifiantProperty() {
        return identifiant;
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public SimpleStringProperty roleProperty() {
        return role;
    }
}
