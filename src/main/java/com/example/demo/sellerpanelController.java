package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class sellerpanelController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void click(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("editproductSearch.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void editinfo(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("editSeller.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menuid(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("firstMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void prolist(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("listProduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void delete(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("deleteProduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void addpro(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void delacc(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("delSeller.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }


}
