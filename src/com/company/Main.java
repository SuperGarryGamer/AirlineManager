package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    List<Flight> flights = new ArrayList<Flight>();

    Button addFlightViewButton = new Button("Add flight");
    ScrollPane flightsScrollPane = new ScrollPane();
    StackPane flightsStackPane = new StackPane();
    Image mapImage;

    TextField addArrivalAP = new TextField("Arrival airport");
    TextField addDepartureAP = new TextField("Departure airport");
    DatePicker addArrivalTime = new DatePicker();
    DatePicker addDepartureTime = new DatePicker();
    TextField flightNumberField = new TextField("Flight numba");
    Button addFlightInfo = new Button("Add flight");


    {
        try {
            mapImage = new Image(getClass().getResource("worldmap.png").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    ImageView worldMap = new ImageView(mapImage);


    public static void main(String[] args) {
        System.out.println(DBController.getAllFlights().toString());
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane addFlight = new GridPane();
        GridPane viewFlight = new GridPane();
        Scene addFlightView = new Scene(addFlight, 1920, 1000);
        Scene viewFlightView = new Scene(viewFlight, 1920, 1000);
        System.out.println("starting app =w=");
        viewFlight.setHgap(10);
        viewFlight.setVgap(10);
        addFlight.setHgap(10);
        addFlight.setVgap(10);


        viewFlight.add(addFlightViewButton, 0, 0);
        viewFlight.add(flightsScrollPane, 0, 1);
        flightsScrollPane.setContent(flightsStackPane);
        viewFlight.add(worldMap, 1, 0, 1, 2);
        worldMap.setPreserveRatio(true);
        worldMap.setFitWidth(1700);



        addFlightViewButton.setOnAction(e -> {
            primaryStage.setScene(addFlightView);
        });

        addFlight.add(flightNumberField, 1, 1);
        addFlight.add(addArrivalAP, 1, 2);
        addFlight.add(addDepartureAP, 2, 2);
        addFlight.add(addArrivalTime, 1, 3);
        addFlight.add(addDepartureTime, 2, 3);
        addFlight.add(addFlightInfo,1,4);

        addFlightInfo.setOnAction(event -> {
            ZoneId zoneid = ZoneId.systemDefault();
            String number = flightNumberField.getText();
            String arrivalAP = addArrivalAP.getText();
            String departureAP = addDepartureAP.getText();
            String arrivalTime = addArrivalTime.getValue().toString();
            String departureTime = addDepartureTime.getValue().toString();

            try {
                DBController.request(String.format("insert into flights values (%s, %s, %s, %s, %s, %s", zoneid, number, arrivalAP, departureAP, arrivalTime, departureTime));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        primaryStage.setScene(viewFlightView);
        primaryStage.show();
    }
}
