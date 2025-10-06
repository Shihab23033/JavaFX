package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class SceneDrawings extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("my learnings");
        Group root =new Group();
        Scene scene = new Scene(root,500,700, Color.GREEN);
        stage.setScene(scene);

        Line l=new Line();
        l.setStartX(100);
        l.setStartY(100);
        l.setEndX(200);
        l.setEndY(100);
        l.setFill(Color.RED);

        root.getChildren().add(l);

        stage.show();
    }
}
