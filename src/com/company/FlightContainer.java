package com.company;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class FlightContainer {
    public GridPane gp;
    public Flight flight;

    public FlightContainer(Flight flight) {
        this.flight = flight;
        //this.gp.add(new Label(""));

    }

    public GridPane getGp() {
        return gp;
    }

    public Flight getFlight() {
        return flight;
    }
}
