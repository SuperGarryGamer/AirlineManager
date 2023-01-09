package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    List<Flight> flights = new ArrayList<Flight>();

    Button addFlightViewButton = new Button("Add flight");
    ScrollPane flightsScrollPane = new ScrollPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane addFlight = new GridPane();
        GridPane viewFlight = new GridPane();
        Scene addFlightView = new Scene(addFlight);
        Scene viewFlightView = new Scene(viewFlight);
        System.out.println("starting app =w=");


        viewFlight.add(addFlightViewButton, 0, 0);

        primaryStage.setScene(viewFlightView);
        primaryStage.show();
    }
}
