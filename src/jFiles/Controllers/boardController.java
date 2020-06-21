package jFiles.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

public class boardController {
    public GridPane board_grid;
    public ToggleButton d0;
    public ToggleButton d1;
    public ToggleButton d2;
    public ToggleButton d3;
    public ToggleButton d4;
    public ToggleButton d5;
    public ToggleButton d6;
    public ToggleButton d7;
    public ToggleButton c0;
    public ToggleButton b0;
    public ToggleButton a0;
    public ToggleButton c1;
    public ToggleButton b1;
    public ToggleButton a1;
    public ToggleButton c2;
    public ToggleButton b2;
    public ToggleButton a2;
    public ToggleButton c3;
    public ToggleButton b3;
    public ToggleButton a3;
    public ToggleButton c4;
    public ToggleButton b4;
    public ToggleButton a4;
    public ToggleButton c5;
    public ToggleButton b5;
    public ToggleButton a5;
    public ToggleButton c6;
    public ToggleButton b6;
    public ToggleButton a6;
    public ToggleButton c7;
    public ToggleButton b7;
    public ToggleButton a7;

    @FXML
    public void initialize() {
        a0.getStylesheets().add("resources/views/css/stylesheet.css");
        a0.getStyleClass().add("wrook");

        a1.getStylesheets().add("resources/views/css/stylesheet.css");
        a1.getStyleClass().add("wknight");

        a2.getStylesheets().add("resources/views/css/stylesheet.css");
        a2.getStyleClass().add("wbishop");

        a3.getStylesheets().add("resources/views/css/stylesheet.css");
        a3.getStyleClass().add("wqueen");

        a4.getStylesheets().add("resources/views/css/stylesheet.css");
        a4.getStyleClass().add("wking");

        a5.getStylesheets().add("resources/views/css/stylesheet.css");
        a5.getStyleClass().add("wbishop");

        a6.getStylesheets().add("resources/views/css/stylesheet.css");
        a6.getStyleClass().add("wknight");

        a7.getStylesheets().add("resources/views/css/stylesheet.css");
        a7.getStyleClass().add("wrook");

        b0.getStylesheets().add("resources/views/css/stylesheet.css");
        b0.getStyleClass().add("wpawn");

        b1.getStylesheets().add("resources/views/css/stylesheet.css");
        b1.getStyleClass().add("wpawn");

        b2.getStylesheets().add("resources/views/css/stylesheet.css");
        b2.getStyleClass().add("wpawn");

        b3.getStylesheets().add("resources/views/css/stylesheet.css");
        b3.getStyleClass().add("wpawn");

        b4.getStylesheets().add("resources/views/css/stylesheet.css");
        b4.getStyleClass().add("wpawn");

        b5.getStylesheets().add("resources/views/css/stylesheet.css");
        b5.getStyleClass().add("wpawn");

        b6.getStylesheets().add("resources/views/css/stylesheet.css");
        b6.getStyleClass().add("wpawn");

        b7.getStylesheets().add("resources/views/css/stylesheet.css");
        b7.getStyleClass().add("wpawn");

        c0.getStylesheets().add("resources/views/css/stylesheet.css");
        c0.getStyleClass().add("bpawn");

        c1.getStylesheets().add("resources/views/css/stylesheet.css");
        c1.getStyleClass().add("bpawn");

        c2.getStylesheets().add("resources/views/css/stylesheet.css");
        c2.getStyleClass().add("bpawn");

        c3.getStylesheets().add("resources/views/css/stylesheet.css");
        c3.getStyleClass().add("bpawn");

        c4.getStylesheets().add("resources/views/css/stylesheet.css");
        c4.getStyleClass().add("bpawn");

        c5.getStylesheets().add("resources/views/css/stylesheet.css");
        c5.getStyleClass().add("bpawn");

        c6.getStylesheets().add("resources/views/css/stylesheet.css");
        c6.getStyleClass().add("bpawn");

        c7.getStylesheets().add("resources/views/css/stylesheet.css");
        c7.getStyleClass().add("bpawn");

        d0.getStylesheets().add("resources/views/css/stylesheet.css");
        d0.getStyleClass().add("brook");

        d1.getStylesheets().add("resources/views/css/stylesheet.css");
        d1.getStyleClass().add("bknight");

        d2.getStylesheets().add("resources/views/css/stylesheet.css");
        d2.getStyleClass().add("bbishop");

        d3.getStylesheets().add("resources/views/css/stylesheet.css");
        d3.getStyleClass().add("bqueen");

        d4.getStylesheets().add("resources/views/css/stylesheet.css");
        d4.getStyleClass().add("bking");

        d5.getStylesheets().add("resources/views/css/stylesheet.css");
        d5.getStyleClass().add("bbishop");

        d6.getStylesheets().add("resources/views/css/stylesheet.css");
        d6.getStyleClass().add("bknight");

        d7.getStylesheets().add("resources/views/css/stylesheet.css");
        d7.getStyleClass().add("brook");
    }
}
