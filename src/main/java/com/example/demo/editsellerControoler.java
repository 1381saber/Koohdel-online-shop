package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class editsellerControoler implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    private TextField pass;

    @FXML
    private TextField user;

    @FXML
    private TextField username3;

    @FXML
    private TextField username32;



    @FXML
    void backid(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sellerpanel.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void submit(MouseEvent event) throws IOException {
        for (int i = 0; i < Customer.information.size() ; i++) {
            String newpassword = pass.getText();
            String newusername = user.getText();
            Customer.information.get(i).setLoginName(newusername);
            Customer.information.get(i).setPassword(newpassword);
        }
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminpanel.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
