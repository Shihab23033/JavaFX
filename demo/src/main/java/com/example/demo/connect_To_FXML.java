package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

public class connect_To_FXML extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            var url = getClass().getResource("testXML.fxml");
            //Parent root = FXMLLoader.load(url);
            Parent root = FXMLLoader.load(getClass().getResource("testXML.fxml"));
//            FXMLLoader fxml=new FXMLLoader(connect_To_FXML.class.getResource("testXML.fxml"));
//            Scene scene = new Scene(fxml.load());
            Scene scene = new Scene(root);
            stage.setScene(scene);
//

            stage.show();
//            System.out.println(getClass().getResource("testXML.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
