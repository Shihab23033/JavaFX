package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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




        CarView car = new CarView();
        car.setBodyColor(Color.GRAY);
        car.setScaleFactor(1.0);

        // Place the car on a free Pane so scaling is obvious
        Pane canvas = new Pane(car);
        canvas.setPrefSize(700, 400);
        car.setLayoutX(180);
        car.setLayoutY(100);

        // Controls
//        ColorPicker colorPicker = new ColorPicker(car.getBodyColor());
//        colorPicker.valueProperty().addListener((obs, old, val) -> car.setBodyColor(val));

        Slider scale = new Slider(0.3, 3.0, car.getScaleFactor());
        scale.setShowTickMarks(true);
        scale.setShowTickLabels(true);
        scale.valueProperty().addListener((obs, old, val) -> car.setScaleFactor(val.doubleValue()));

        HBox controls = new HBox(12,
                //new Label("Color:"), colorPicker,
                new Label("Scale:"), scale
        );
        controls.setPadding(new Insets(10));

        BorderPane root2 = new BorderPane(canvas, null, null, controls, null);
        stage.setScene(new Scene(root2, 800, 500));
        stage.setTitle("CarView demo");
        stage.show();







        // root.getChildren().add(l);
        //stage.show();
    }
}
