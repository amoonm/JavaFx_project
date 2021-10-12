package com.mycompany.javafxhouse;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

/**
 * Creating a House with a canvas and different shapes, colors, measurements
 * on JavaFX App using JavaFX.
 */
public class App extends Application {

    Group gc;
    GraphicsContext graphics;

    public void start(Stage stage) {
        //creating title for the stage
        stage.setTitle("A House");
        // creating the canvas
        Canvas canvas = new Canvas(600, 600);
        //GraphicsContext2D
        graphics = canvas.getGraphicsContext2D();
        //creating a group
        gc = new Group(canvas);
        structure();
        // creating a scene
        Scene scene = new Scene(gc, 600, 600);
     
        stage.setScene(scene);
        stage.show();
    }
    
    public void structure() {
        //sky color and requirements
        graphics.setFill(Color.LIGHTBLUE);
        graphics.fillRect(0, 0, 600, 350);

        //grass color and requirements
        graphics.setFill(Color.GREEN);
        graphics.fillRect(0, 200, 600, 600);

        //creating the triangle rooftop
        Polyline triangle = new Polyline();
        triangle.getPoints().addAll(new Double[]{
            300.0, 0.0, 550.0, 150.0, 60.0, 150.0, 300.0, 0.0,});
        triangle.setStroke(Color.BLACK);
        triangle.setFill(Color.WHITE);
        gc.getChildren().add(triangle);

        //reactuangle shape under the triangle roof
        Rectangle rec = new Rectangle(80, 150, 450, 30);
        rec.setFill(Color.WHITE);
        rec.setStroke(Color.BLACK);
        gc.getChildren().add(rec);

        //rectangle shape for the house wall, the color of the wall
        rec = new Rectangle(70, 180, 460, 350);
        rec.setFill(Color.BROWN);
        rec.setStroke(Color.BLACK);
        gc.getChildren().add(rec);

        //middle gray window requirements
        rec = new Rectangle(260, 210, 80, 40);
        rec.setFill(Color.LIGHTGRAY);
        rec.setStroke(Color.BLACK);
        gc.getChildren().add(rec);

        //first door requirements
        rec = new Rectangle(130, 300, 80, 170);
        rec.setFill(Color.WHITE);
        rec.setStroke(Color.BLACK);
        gc.getChildren().add(rec);
        blackGlass(140, 315);
        //pillar1
        pillar(80, 180);
        //second door requiremnts
        rec = new Rectangle(260, 275, 80, 190);
        rec.setFill(Color.WHITE);
        rec.setStroke(Color.BLACK);
        gc.getChildren().add(rec);
        blackGlass(270, 307);
        //pillar2
        pillar(215, 180);

        //third door requirements
        rec = new Rectangle(395, 295, 80, 165);
        rec.setFill(Color.WHITE);
        rec.setStroke(Color.BLACK);
        gc.getChildren().add(rec);
        blackGlass(410, 305);
        // pillar3
        pillar(350, 180);

        pillar(480, 180);

        //rectangle under pillars
        rec = new Rectangle(70, 460, 460, 5);
        rec.setFill(Color.LIGHTGRAY);
        rec.setStroke(Color.BLACK);
        gc.getChildren().add(rec);

        stairs(125, 465);

    }  
    // method for the glass windows
    public void blackGlass(int x, int y) {
        Rectangle rect;
        //array for the 30 glass windows on the door 
        for (int i = 0, a = 0; i < 5; i++, a += 30) {
            //left glass 
            rect = new Rectangle(x, y + a, 15, 23); 
            rect.setFill(Color.BLACK);
            rect.setStroke(Color.BLACK);
            gc.getChildren().add(rect);
            //right glass
            rect = new Rectangle(x + 30, y + a, 15, 23); 
            rect.setFill(Color.BLACK);
            rect.setStroke(Color.BLACK);
            gc.getChildren().add(rect);

        }
    }
    //method for pillar
    public void pillar(int x, int y) {
        Rectangle rec;
        int width = 35, height = 270;
        //pillar width,height,color
        rec = new Rectangle(x, y, width, height); 
        rec.setFill(Color.WHITE);
        rec.setStroke(Color.BLACK);
        gc.getChildren().add(rec);
        //base of the pillar
        rec = new Rectangle(x - 5, y + height, 40, 10); 
        rec.setFill(Color.WHITE);
        rec.setStroke(Color.BLACK);
        gc.getChildren().add(rec);

        //circlesfor the pillar top
        Circle circle = new Circle();
        //creating the circle requirements
        int radius = 11;
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setRadius(radius);
        circle.setCenterX(x);
        circle.setCenterY(y + radius);
        gc.getChildren().add(circle);

        Circle circle2 = new Circle();
        //creating the circle2 requirements  
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);
        circle2.setRadius(radius);
        circle2.setCenterX(x + width);
        circle2.setCenterY(y + radius);
        gc.getChildren().add(circle2);
    }
    // method for the stoars
    public void stairs(int x, int y) {
        Rectangle rect;
        int width = 360, height = 10;
        //array for the 11 stairs
        for (int i = 1; i <= 11; i++) {
            rect = new Rectangle(x, y, width, 12);
            rect.setFill(Color.LIGHTGRAY);
            rect.setStroke(Color.BLACK);
            gc.getChildren().add(rect);
            x = x - 12; 
            //increasing the height 
            y = y + height; 
            //increasing the width 
            width = width + 20; 
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
