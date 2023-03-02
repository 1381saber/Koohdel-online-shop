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

public class editproController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField Rate;

    @FXML
    private TextField company;

    @FXML
    private TextField condition;

    @FXML
    private TextField des1;

    @FXML
    private TextField des2;

    @FXML
    private TextField des3;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField sellerName;

    @FXML
    private TextField tozih;

    @FXML
    void backid(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sellerpanelController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void submit(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sellerpanelController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }
}
