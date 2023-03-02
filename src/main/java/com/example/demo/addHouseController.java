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
import java.util.EventObject;
import java.util.ResourceBundle;

public class addHouseController implements Initializable {
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


    public void submit(MouseEvent event) throws IOException {

        String nameP = name.getText();
        String desc1 = des1.getText();
        String desc2 = des2.getText();
        String desc3 = des3.getText();
        int idP = Integer.parseInt(id.getText());
        String cond = condition.getText();
        String co = company.getText();
        double priceP = Double.parseDouble(price.getText());
        double rate = Double.parseDouble(Rate.getText());
        String toz = tozih.getText();
        String sellerN = sellerName.getText();

        Tv added5  = new Tv(nameP, idP, co, priceP, cond,toz, rate ,sellerN, desc1, Integer.parseInt(desc2));
        Requests.addtv.add(added5);
        Parent parent = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void oven(MouseEvent event) throws IOException {
        String nameP = name.getText();
        String desc1 = des1.getText();
        String desc2 = des2.getText();
        String desc3 = des3.getText();
        int idP = Integer.parseInt(id.getText());
        String cond = condition.getText();
        String co = company.getText();
        double priceP = Double.parseDouble(price.getText());
        double rate = Double.parseDouble(Rate.getText());
        String toz = tozih.getText();
        String sellerN = sellerName.getText();
        Oven added4  = new Oven(nameP, idP, co, priceP, cond, toz, rate , sellerN, Integer.parseInt(desc1), desc2, Boolean.getBoolean(desc3));
        Requests.addoven.add(added4);

        Parent parent = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ref(MouseEvent event) throws IOException {
        String nameP = name.getText();
        String desc1 = des1.getText();
        String desc2 = des2.getText();
        String desc3 = des3.getText();
        int idP = Integer.parseInt(id.getText());
        String cond = condition.getText();
        String co = company.getText();
        double priceP = Double.parseDouble(price.getText());
        double rate = Double.parseDouble(Rate.getText());
        String toz = tozih.getText();
        String sellerN = sellerName.getText();

        Refrigerator added3 = new Refrigerator(nameP,idP, co, priceP, cond, toz, rate, sellerN, Integer.parseInt(desc1), desc2, Boolean.parseBoolean(desc3));
        Requests.addproref.add(added3);

        Parent parent = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void backid(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}