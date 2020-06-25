package jFiles.Controllers;

import jFiles.Logic;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.HashMap;

public class boardController {
    public GridPane board_grid;
    public StackPane sa8;
    public StackPane sb8;
    public StackPane sc8;
    public StackPane sd8;
    public StackPane se8;
    public StackPane sf8;
    public StackPane sg8;
    public StackPane sh8;
    public StackPane sa7;
    public StackPane sa6;
    public StackPane sa5;
    public StackPane sa4;
    public StackPane sa3;
    public StackPane sa2;
    public StackPane sa1;
    public StackPane sb7;
    public StackPane sb6;
    public StackPane sb5;
    public StackPane sb4;
    public StackPane sb3;
    public StackPane sb2;
    public StackPane sb1;
    public StackPane sc7;
    public StackPane sc6;
    public StackPane sc5;
    public StackPane sc4;
    public StackPane sc3;
    public StackPane sc2;
    public StackPane sc1;
    public StackPane sd7;
    public StackPane sd6;
    public StackPane sd5;
    public StackPane sd4;
    public StackPane sd3;
    public StackPane sd2;
    public StackPane sd1;
    public StackPane se7;
    public StackPane se6;
    public StackPane se5;
    public StackPane se4;
    public StackPane se3;
    public StackPane se2;
    public StackPane se1;
    public StackPane sf7;
    public StackPane sf6;
    public StackPane sf5;
    public StackPane sf4;
    public StackPane sf2;
    public StackPane sf3;
    public StackPane sf1;
    public StackPane sg7;
    public StackPane sg6;
    public StackPane sg5;
    public StackPane sg4;
    public StackPane sg3;
    public StackPane sg2;
    public StackPane sg1;
    public StackPane sh7;
    public StackPane sh6;
    public StackPane sh5;
    public StackPane sh4;
    public StackPane sh3;
    public StackPane sh2;
    public StackPane sh1;
    public ToggleButton brook1;
    public ToggleButton bknight1;
    public ToggleButton bbisop1;
    public ToggleButton bqueen;
    public ToggleButton bking;
    public ToggleButton bbishop2;
    public ToggleButton bknight2;
    public ToggleButton brook2;
    public ToggleButton bpawn1;
    public ToggleButton wpawn1;
    public ToggleButton wrook1;
    public ToggleButton bpawn2;
    public ToggleButton wpawn2;
    public ToggleButton wknight1;
    public ToggleButton bpawn3;
    public ToggleButton wpawn3;
    public ToggleButton wbishop1;
    public ToggleButton bpawn4;
    public ToggleButton wpawn4;
    public ToggleButton wqueen;
    public ToggleButton bpawn5;
    public ToggleButton wpawn5;
    public ToggleButton wking;
    public ToggleButton bpawn6;
    public ToggleButton wpawn6;
    public ToggleButton wbishop2;
    public ToggleButton bpawn7;
    public ToggleButton wpawn7;
    public ToggleButton wknight2;
    public ToggleButton bpawn8;
    public ToggleButton wpawn8;
    public ToggleButton wrook2;

    private Logic logic = new Logic();

    private HashMap<String, ToggleButton> selected = new HashMap<>();
    private ArrayList<ToggleButton> buttons = new ArrayList<>();

    private void add_to_selected(String board_location, ToggleButton obj) {
        selected.put(board_location, obj);
    }

    private void test() {
        System.out.println(selected.get("a1").isSelected());
    }

    @FXML
    public void initialize() {

        // Board and piece setup

        ToggleButton[] loc_list = {
                wrook1, wknight1, wbishop1, wqueen,
                wking, wbishop2, wknight2, wrook2,
                wpawn1, wpawn2, wpawn3, wpawn4,
                wpawn5, wpawn6, wpawn7, wpawn8,
                brook1, bknight1, bbisop1, bqueen,
                bking, bbishop2, bknight2, brook2,
                bpawn1, bpawn2, bpawn3, bpawn4,
                bpawn5, bpawn6, bpawn7, bpawn8,
        };

        for (int i = 0; i < loc_list.length; i++) {
            loc_list[i].getStylesheets().add("resources/views/css/stylesheet.css");
            add_to_selected(String.valueOf(loc_list[i]), loc_list[i]);
            buttons.add(loc_list[i]);
            logic.pieces.add(loc_list[i]);
        }

        wpawn1.getStyleClass().add("wpawn");
        bpawn1.getStyleClass().add("bpawn");
        wpawn2.getStyleClass().add("wpawn");
        bpawn2.getStyleClass().add("bpawn");
        wpawn3.getStyleClass().add("wpawn");
        bpawn3.getStyleClass().add("bpawn");
        wpawn4.getStyleClass().add("wpawn");
        bpawn4.getStyleClass().add("bpawn");
        wpawn5.getStyleClass().add("wpawn");
        bpawn5.getStyleClass().add("bpawn");
        wpawn6.getStyleClass().add("wpawn");
        bpawn6.getStyleClass().add("bpawn");
        wpawn7.getStyleClass().add("wpawn");
        bpawn7.getStyleClass().add("bpawn");
        wpawn8.getStyleClass().add("wpawn");
        bpawn8.getStyleClass().add("bpawn");

        wrook1.getStyleClass().add("wrook");
        brook1.getStyleClass().add("brook");
        wrook2.getStyleClass().add("wrook");
        brook2.getStyleClass().add("brook");

        wknight1.getStyleClass().add("wknight");
        bknight1.getStyleClass().add("bknight");
        wknight2.getStyleClass().add("wknight");
        bknight2.getStyleClass().add("bknight");

        wbishop1.getStyleClass().add("wbishop");
        bbisop1.getStyleClass().add("bbishop");
        wbishop2.getStyleClass().add("wbishop");
        bbishop2.getStyleClass().add("bbishop");

        wking.getStyleClass().add("wking");
        bking.getStyleClass().add("bking");

        wqueen.getStyleClass().add("wqueen");
        bqueen.getStyleClass().add("bqueen");

        // Find a way to have a condition before allowing a toggle

        // See if that condition can be applied to all toggle buttons at once

        // Can't allow multiple buttons to be toggled at once

        // Make sure StackPane does not have a node before allowing piece to move to it
    }

    public void sg3_clicked(MouseEvent mouseEvent) {

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isSelected()) {
                System.out.println(buttons.get(i));
            }
        }
    }

    public void brook1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(brook1);
    }

    public void bknight1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bknight1);
    }

    public void bbishop1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bbisop1);
    }

    public void bqueen_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bqueen);
    }

    public void bking_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bking);
    }

    public void bbishop2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bbishop2);
    }

    public void bknight2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bknight2);
    }

    public void brook2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(brook2);
    }

    public void wpawn1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn1);
    }

    public void wrook1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wrook1);
    }

    public void wpawn2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn2);
    }

    public void wknight1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wknight1);
    }

    public void wpawn3_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn3);
    }

    public void wbishop1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wbishop1);
    }

    public void wpawn4_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn4);
    }

    public void wqueen_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wqueen);
    }

    public void wpawn5_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn5);
    }

    public void wking_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wking);
    }

    public void wpawn6_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn6);
    }

    public void wbishop2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wbishop2);
    }

    public void wpawn7_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn7);
    }

    public void wknight2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wknight2);
    }

    public void wpawn8_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn8);
    }

    public void wrook2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wrook2);
    }


    public void bpawn1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn1);
    }

    public void bpawn2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn2);
    }

    public void bpawn3_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn3);
    }

    public void bpawn4_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn4);
    }

    public void bpawn5_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn5);
    }

    public void bpawn6_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn6);
    }

    public void bpawn7_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn7);
    }

    public void bpawn8_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn8);
    }
}
