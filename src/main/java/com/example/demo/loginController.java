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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
        @FXML
        void menuid(MouseEvent event) throws IOException {

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("firstMenu.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();

        }


    @FXML
    private TextField pass;

    @FXML
    private TextField username;

    @FXML
    void loginid(MouseEvent event) throws Exception {
        String user = username.getText();
        String password = pass.getText();

        for (int i = 0; i < Customer.information.size(); i++) {
            if (user.equals(Customer.information.get(i).getLoginName()) && password.equals(Customer.information.get(i).getPassword())) {

                i = Customer.customerindex;

                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customerpanel.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();

            }
        }
        for (int i = 0; i < Seller.sellerInformation.size(); i++) {
            if (user.equals(Seller.sellerInformation.get(i).getLoginName()) && password.equals(Seller.sellerInformation.get(i).getPassword())) {

                i = Seller.sellerindex;

                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sellerpanel.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();

            }
        }

//
//            File file = new File("SavedData//Users//Customers//customerfolder//customer.txt");
//        FileInputStream fileCustomer = new FileInputStream(file);
//        ObjectInputStream objCustomer = new ObjectInputStream(fileCustomer);
//
//
//        while(true)
//        {
//            Customer customer;
//            try{
//                customer = (Customer) objCustomer.readObject();
//            }
//            catch(Exception except){
//
//                break;
//            }
//
//            if(username.equals(customer.getLoginName()) && password.equals(customer.getPassword())) {
//                Customer customerLoggedin = customer;
//                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customerpanel.fxml")));
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                Scene scene = new Scene(parent);
//                stage.setScene(scene);
//                stage.show();
//            }
//
//            else {
//                System.out.println("YOUR PASSWORD AND USER NAME IS WRONG");
//            }
//        }

//        File file1 = new File("SavedData//Users//Sellers//Sellerfolder//seller.txt");
//        FileInputStream fileSeller = new FileInputStream(file1);
//        ObjectInputStream objSeller = new ObjectInputStream(fileSeller);
//
//
//        while(true)
//        {
//            Seller seller;
//            try{
//
//                seller = (Seller) objSeller.readObject();
//
//            }
//            catch(Exception except){
//
//                break;
//            }
//
//            if(username.equals(seller.getLoginName()) && password.equals(seller.getPassword())) {
//                Seller sellerLoggedin = seller;
//                SellerCont.sellerPanel();
//            }
//
//            else {
//                System.out.println("YOUR PASSWORD AND USER NAME IS WRONG");
//
//            }
//        }


        if (user.equals(AdminCont.koohdel.getLoginName()) && password.equals(AdminCont.koohdel.getPassword())) {

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminpanel.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }

        else {

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("firstMenu.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }


    }
}
