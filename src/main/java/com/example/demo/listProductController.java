package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class listProductController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        javafx.scene.image.Image img = new javafx.scene.image.Image(getClass().getResource("/Users/shahinsabzi/Desktop/demo/src/main/resources/com/example/demo/i.jpg").toExternalForm());
//        shekl.setFill(new ImagePattern(img));


    }

    @FXML
    private Button menuid;

//    @FXML
//    private Rectangle shekl;
    @FXML
    void menuid(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("firstMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
