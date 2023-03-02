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

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class signupController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField cash;

    @FXML
    private TextField email;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField num;

    @FXML
    private TextField username;

    @FXML
    void menuid(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("firstMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField company;

    @FXML
    void customer(MouseEvent event) throws IOException {
        String nameC = name.getText();
        String usernameC = username.getText();
        String emailC = email.getText();
        String passwordC = id.getText();
        String cashC = cash.getText();
        String numberC = num.getText();
        Customer person = new Customer(nameC, usernameC, passwordC, emailC, numberC, Double.parseDouble(cashC));
        Customer.information.add(person);
//        File User = new File("SavedData//Users//Customers//customerfolder");
//        if ( !User.mkdirs()){
//            System.out.print("!!! FILE CAN NOT CREATE !!!");
//
//        }
//        User = new File(User.getPath() + "//customer.txt");
//        FileOutputStream fileCustomer = new FileOutputStream(User);
//        ObjectOutputStream objCustomer = new ObjectOutputStream(fileCustomer);
//        objCustomer.writeObject(person);
//        objCustomer.close();
//        fileCustomer.close();

        Parent parent = FXMLLoader.load(getClass().getResource("firstMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void seller(MouseEvent event) throws IOException {
        String nameC = name.getText();
        String usernameC = username.getText();
        String emailC = email.getText();
        String passwordC = id.getText();
        String cashC = cash.getText();
        String numberC = num.getText();
        String companyS = company.getText();
        Seller person = new Seller(nameC, usernameC, passwordC, emailC, numberC, Double.parseDouble(cashC) , companyS);
        Seller.sellerInformation.add(person);
//        File User = new File("SavedData//Users//Customers//customerfolder");
//        if ( !User.mkdirs()){
//            System.out.print("!!! FILE CAN NOT CREATE !!!");
//
//        }
//        User = new File(User.getPath() + "//customer.txt");
//        FileOutputStream fileCustomer = new FileOutputStream(User);
//        ObjectOutputStream objCustomer = new ObjectOutputStream(fileCustomer);
//        objCustomer.writeObject(person);
//        objCustomer.close();
//        fileCustomer.close();

        Parent parent = FXMLLoader.load(getClass().getResource("firstMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();


    }
}
