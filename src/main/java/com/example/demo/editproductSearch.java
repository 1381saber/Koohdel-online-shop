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
import java.util.ResourceBundle;

public class editproductSearch implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private TextField pass;

    @FXML
    void menuid(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sellerpanelController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void search(MouseEvent event) throws IOException {
//        String find = pass.getText();
//        for (int i = 0; i < Seller.saddprolap.size(); i++)
//        {
//            if(find.equals(pass.getText())){
//                Parent parent = FXMLLoader.load(getClass().getResource("editPro.fxml"));
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                Scene scene = new Scene(parent);
//                stage.setScene(scene);
//                stage.show();
//            }
//        }
//

                Parent parent = FXMLLoader.load(getClass().getResource("editPro.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
    }
}
