package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    List<Flight> flights = new ArrayList<Flight>();

    Button addFlightViewButton = new Button("Add flight");
    ScrollPane flightsScrollPane = new ScrollPane();
    StackPane flightsStackPane = new StackPane();
    Image mapImage;

    TextField flightNumberField = new TextField();


    {
        try {
            mapImage = new Image(getClass().getResource("worldmap.png").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    ImageView worldMap = new ImageView(mapImage);


    public static void main(String[] args) {
        DBController.connect();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane addFlight = new GridPane();
        GridPane viewFlight = new GridPane();
        Scene addFlightView = new Scene(addFlight, 1920, 1000);
        Scene viewFlightView = new Scene(viewFlight, 1920, 1000);
        System.out.println("starting app =w=");

        viewFlight.add(addFlightViewButton, 0, 0);
        viewFlight.add(flightsScrollPane, 0, 1);
        flightsScrollPane.setContent(flightsStackPane);
        viewFlight.add(worldMap, 1, 0, 1, 2);
        worldMap.setPreserveRatio(true);
        worldMap.setFitWidth(1700);

        addFlight.add(flightNumberField, 1, 1);

        primaryStage.setScene(viewFlightView);
        primaryStage.show();


    }
}
