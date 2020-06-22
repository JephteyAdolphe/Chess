package jFiles.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

public class boardController {
    public GridPane board_grid;
    public ToggleButton d1;
    public ToggleButton d2;
    public ToggleButton d3;
    public ToggleButton d4;
    public ToggleButton d5;
    public ToggleButton d6;
    public ToggleButton d7;
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
    public StackPane sp_a3;
    public ToggleButton a8;
    public ToggleButton b8;
    public ToggleButton c8;
    public ToggleButton d8;
    public ToggleButton e8;
    public ToggleButton f8;
    public ToggleButton g8;
    public ToggleButton h8;
    public ToggleButton e7;
    public ToggleButton e6;
    public ToggleButton e5;
    public ToggleButton e4;
    public ToggleButton e3;
    public ToggleButton e2;
    public ToggleButton e1;
    public ToggleButton f7;
    public ToggleButton f6;
    public ToggleButton f5;
    public ToggleButton f4;
    public ToggleButton f3;
    public ToggleButton f2;
    public ToggleButton g7;
    public ToggleButton f1;
    public ToggleButton g6;
    public ToggleButton g5;
    public ToggleButton g4;
    public ToggleButton g3;
    public ToggleButton g2;
    public ToggleButton g1;
    public ToggleButton h7;
    public ToggleButton h6;
    public ToggleButton h5;
    public ToggleButton h4;
    public ToggleButton h3;
    public ToggleButton h2;
    public ToggleButton h1;

    private HashMap toggleStatus = new HashMap();

    private void test() {
        System.out.println(a6.isSelected());
    }

    @FXML
    public void initialize() {

        a1.getStylesheets().add("resources/views/css/stylesheet.css");
        a2.getStylesheets().add("resources/views/css/stylesheet.css");
        a7.getStylesheets().add("resources/views/css/stylesheet.css");
        a8.getStylesheets().add("resources/views/css/stylesheet.css");
        b1.getStylesheets().add("resources/views/css/stylesheet.css");
        b2.getStylesheets().add("resources/views/css/stylesheet.css");
        b7.getStylesheets().add("resources/views/css/stylesheet.css");
        b8.getStylesheets().add("resources/views/css/stylesheet.css");
        c1.getStylesheets().add("resources/views/css/stylesheet.css");
        c2.getStylesheets().add("resources/views/css/stylesheet.css");
        c7.getStylesheets().add("resources/views/css/stylesheet.css");
        c8.getStylesheets().add("resources/views/css/stylesheet.css");
        d1.getStylesheets().add("resources/views/css/stylesheet.css");
        d2.getStylesheets().add("resources/views/css/stylesheet.css");
        d7.getStylesheets().add("resources/views/css/stylesheet.css");
        d8.getStylesheets().add("resources/views/css/stylesheet.css");
        e1.getStylesheets().add("resources/views/css/stylesheet.css");
        e2.getStylesheets().add("resources/views/css/stylesheet.css");
        e7.getStylesheets().add("resources/views/css/stylesheet.css");
        e8.getStylesheets().add("resources/views/css/stylesheet.css");
        f1.getStylesheets().add("resources/views/css/stylesheet.css");
        f2.getStylesheets().add("resources/views/css/stylesheet.css");
        f7.getStylesheets().add("resources/views/css/stylesheet.css");
        f8.getStylesheets().add("resources/views/css/stylesheet.css");
        g1.getStylesheets().add("resources/views/css/stylesheet.css");
        g2.getStylesheets().add("resources/views/css/stylesheet.css");
        g7.getStylesheets().add("resources/views/css/stylesheet.css");
        g8.getStylesheets().add("resources/views/css/stylesheet.css");
        h1.getStylesheets().add("resources/views/css/stylesheet.css");
        h2.getStylesheets().add("resources/views/css/stylesheet.css");
        h7.getStylesheets().add("resources/views/css/stylesheet.css");
        h8.getStylesheets().add("resources/views/css/stylesheet.css");

        a2.getStyleClass().add("wpawn");
        a7.getStyleClass().add("bpawn");
        b2.getStyleClass().add("wpawn");
        b7.getStyleClass().add("bpawn");
        c2.getStyleClass().add("wpawn");
        c7.getStyleClass().add("bpawn");
        d2.getStyleClass().add("wpawn");
        d7.getStyleClass().add("bpawn");
        e2.getStyleClass().add("wpawn");
        e7.getStyleClass().add("bpawn");
        f2.getStyleClass().add("wpawn");
        f7.getStyleClass().add("bpawn");
        g2.getStyleClass().add("wpawn");
        g7.getStyleClass().add("bpawn");
        h2.getStyleClass().add("wpawn");
        h7.getStyleClass().add("bpawn");

        a1.getStyleClass().add("wrook");
        a8.getStyleClass().add("brook");
        h1.getStyleClass().add("wrook");
        h8.getStyleClass().add("brook");

        b1.getStyleClass().add("wknight");
        b8.getStyleClass().add("bknight");
        g1.getStyleClass().add("wknight");
        g8.getStyleClass().add("bknight");

        c1.getStyleClass().add("wbishop");
        c8.getStyleClass().add("bbishop");
        f1.getStyleClass().add("wbishop");
        f8.getStyleClass().add("bbishop");

        d1.getStyleClass().add("wking");
        d8.getStyleClass().add("bking");

        e1.getStyleClass().add("wqueen");
        e8.getStyleClass().add("bqueen");
    }

    public void was_clicked(MouseEvent mouseEvent) {
        ToggleButton test = new ToggleButton();

        sp_a3.getChildren().add(test);
    }
}
