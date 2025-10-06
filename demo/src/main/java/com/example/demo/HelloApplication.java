package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("My Learnings");
//        stage.setScene(scene);
//        //Image icon= new Image("C:/Users/Shihab/Downloads/495072759_1199889244928727_4530868936643803510_n.jpg");
//       // stage.getIcons().add(icon);
//        stage.show();
//    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("my learnings");
        Group root =new Group();
        Scene scene = new Scene(root, Color.GREEN);
        stage.setScene(scene);
        Image icon= new Image("file:D:/Codes/javaFX/demo/src/main/java/com/example/demo/icon.png"); //making image object
        stage.getIcons().add(icon);
       // stage.setFullScreen(true); //opens application on fullscreen
        stage.setWidth(500);
        stage.setHeight(700);
        //stage.setResizable(false); //makes window fixed size
//        stage.setFullScreenExitHint("press 'f' to exit");
//        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("f")); //used to customize exit key


        stage.show();
    }
}
