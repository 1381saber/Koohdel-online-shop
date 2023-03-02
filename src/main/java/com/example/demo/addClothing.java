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

public class addClothing implements Initializable {
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
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField sellerName;

    @FXML
    private TextField toz;

    @FXML
    void backid(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void dress(MouseEvent event) throws IOException {
        String nameP = name.getText();
        String desc1 = des1.getText();
        String desc2 = des2.getText();
        int idP = Integer.parseInt(id.getText());
        String cond = condition.getText();
        String co = company.getText();
        double priceP = Double.parseDouble(price.getText());
        double rate = Double.parseDouble(Rate.getText());
        String tozih = toz.getText();
        String sellerN = sellerName.getText();
        Dress added1 = new Dress(nameP,idP, co, priceP, cond, tozih, rate, sellerN, Integer.parseInt(desc1), Dress.Model.valueOf(desc2));
        Requests.adddress.add(added1);
        Parent parent = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void shoes(MouseEvent event) throws IOException {
        String nameP = name.getText();
        String desc1 = des1.getText();
        String desc2 = des2.getText();
        int idP = Integer.parseInt(id.getText());
        String cond = condition.getText();
        String co = company.getText();
        double priceP = Double.parseDouble(price.getText());
        double rate = Double.parseDouble(Rate.getText());
        String tozih = toz.getText();
        String sellerN = sellerName.getText();
        Shoes added2 = new Shoes(nameP,idP, co, priceP, cond, tozih, rate, sellerN, Integer.parseInt(desc1), Shoes.Type.valueOf(desc2));
        Requests.addshoes.add(added2);
        Parent parent = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

}
