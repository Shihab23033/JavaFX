package com.example.demo;


import javafx.beans.property.*;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class CarView extends Group {

    // Base (unscaled) car size
    private static final double W = 120;
    private static final double H = 250;

    private final ObjectProperty<Color> bodyColor = new SimpleObjectProperty<>(Color.web("#ffcc00"));
    private final DoubleProperty scaleFactor = new SimpleDoubleProperty(1.0);

    // Shapes
    private final Rectangle body;
    private final Rectangle line;
    private final Rectangle roofl;
    private final Rectangle roofr;
    private final Rectangle frontGlass;
    private final Rectangle rearGlass;
    private final Rectangle leftSideAccent;
    private final Rectangle rightSideAccent;
    private final Rectangle frontBumper;
    private final Rectangle rearBumper;
    private final Ellipse hlLeft, hlRight, tlLeft, tlRight;
    private final Rectangle mirrorLeft, mirrorRight;

    public CarView() {
        // Body
        body = new Rectangle(0, 0, W, H);
        body.setArcWidth(70);
        body.setArcHeight(50);
        body.fillProperty().bind(bodyColor);
        line =new Rectangle(1, H/2-2 ,W-2,5);
        line.fillProperty().bind(bodyColor);
        //line.setFill(Color.BLACK);
//        line.setStartX(5);
//        line.setStartY(W);
//        line.setEndX(H/2.1);
//        line.setEndY(W);


        // Subtle shadow for depth
        DropShadow ds = new DropShadow(12, Color.rgb(0, 0, 0, 0.35));
        body.setEffect(ds);

        // Front / rear bumpers (dark band near edges)
        double bumperH = H * 0.08;
        frontBumper = new Rectangle(W * 0.15, H * 0.16, W * 0.69, bumperH);
        rearBumper  = new Rectangle(W * 0.15, H - bumperH - H * 0.16, W * 0.69, bumperH);
        styleDark(frontBumper, 15);
        styleDark(rearBumper, 15);

        // Side accents (vertical, not bars across the car)
        double accentW = W * 0.10;
        double accentH = H * 0.55;
        leftSideAccent  = new Rectangle(W * 0.08, (H - accentH) / 2, accentW, accentH);
        rightSideAccent = new Rectangle(W - accentW - W * 0.08, (H - accentH) / 2, accentW, accentH);
        styleDark(leftSideAccent, 20);
        styleDark(rightSideAccent, 20);

        // Roof capsule
        double roofW = W * 0.13;
        double roofH = H * 1;
        roofl = new Rectangle(15+ (W - roofW) /4 +1, (H - roofH) / 2, roofW, roofH);
        roofr = new Rectangle(10+ (W - roofW) / 2, (H - roofH) / 2, roofW, roofH);
        //roof.setArcWidth(40);
        //roof.setArcHeight(40);
        roofl.setFill(Color.web("#ffffff"));
        roofl.setOpacity(0.80);
        roofr.setFill(Color.web("#ffffff"));
        roofr.setOpacity(0.80);

        // Front and rear glass (smaller "pills")
        double glassW = W * 0.64;
        double glassH = H * 0.10;
        frontGlass = new Rectangle((W - glassW) / 2, H * 0.20, glassW, glassH);
        rearGlass  = new Rectangle((W - glassW) / 2, H - glassH - H * 0.20, glassW, glassH);
        frontGlass.setArcWidth(20);
        frontGlass.setArcHeight(26);
        rearGlass.setArcWidth(26);
        rearGlass.setArcHeight(26);
        Color glass = Color.rgb(0, 0, 0, 0.85);
        frontGlass.setFill(glass);
        rearGlass.setFill(glass);

        // Mirrors
        mirrorLeft  = new Rectangle(W * 0.01-10, H * 0.22, W * 0.12, H * 0.07);
        mirrorRight = new Rectangle(W - W * 0.01+8 - W * 0.10, H * 0.22, W * 0.12, H * 0.07);
        styleDark(mirrorLeft, 15);
        styleDark(mirrorRight, 15);

        // Lights
        hlLeft  = new Ellipse(W * 0.20, H * 0.08, 15, 10);
        hlRight = new Ellipse(W * 0.80, H * 0.08, 15, 10);
        hlLeft.setFill(Color.rgb(255, 255, 210));
        hlRight.setFill(Color.rgb(255, 255, 210));

        tlLeft  = new Ellipse(W * 0.20, H * 0.89, 16, 11);
        tlRight = new Ellipse(W * 0.80, H * 0.89, 16, 11);
        tlLeft.setFill(Color.RED);
        tlRight.setFill(Color.RED);

        // Layering: body -> bumpers/accents -> roof -> glass -> mirrors -> lights
        getChildren().addAll(
                body,

                leftSideAccent, rightSideAccent,
                line,roofl,roofr,frontBumper, rearBumper,
                frontGlass, rearGlass,
                mirrorLeft, mirrorRight,
                hlLeft, hlRight, tlLeft, tlRight
        );

        // Uniform scaling
        scaleXProperty().bind(scaleFactor);
        scaleYProperty().bind(scaleFactor);
    }

    private static void styleDark(Rectangle r, double arc) {
        r.setArcWidth(arc);
        r.setArcHeight(arc);
        r.setFill(Color.web("#2a2a2a"));
    }

    // Properties
    public ObjectProperty<Color> bodyColorProperty() { return bodyColor; }
    public Color getBodyColor() { return bodyColor.get(); }
    public void setBodyColor(Color color) { bodyColor.set(color); }

    public DoubleProperty scaleFactorProperty() { return scaleFactor; }
    public double getScaleFactor() { return scaleFactor.get(); }
    public void setScaleFactor(double s) { scaleFactor.set(s); }

    // Base size if you need it for layout
    public double getBaseWidth() { return W; }
    public double getBaseHeight() { return H; }
}