package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    List<Flight> flights = new ArrayList<Flight>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane addFlight = new GridPane();
        GridPane viewFlight = new GridPane();
        Scene addFlightView = new Scene(addFlight);
        Scene viewFlightView = new Scene(viewFlight);

    }
}
