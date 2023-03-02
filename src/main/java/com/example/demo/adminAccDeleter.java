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

public class adminAccDeleter implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    private TextField pass;

    @FXML
    void delete(MouseEvent event) throws IOException {
        int acc = Integer.parseInt(pass.getText());
        for( int i = 0; i < Requests.req.size() ; i++){
            if(Requests.req.get(i).getLoginName().equals(acc)){
                Requests.req.remove(i);

            }
        }
        for( int i = 0; i <Customer.information.size() ; i++) {
            if (Customer.information.get(i).getLoginName().equals(acc)) {
                Customer.information.remove(i);

            }
        }

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminpanel.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void menuid(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminpanel.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }
}
