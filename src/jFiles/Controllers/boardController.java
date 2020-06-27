package jFiles.Controllers;

import jFiles.Logic;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.Arrays;

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
                bpawn5, bpawn6, bpawn7, bpawn8
        };

        StackPane[] pane_list = {
                sa1, sa2, sa3, sa4, sa5, sa6, sa7, sa8,
                sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8,
                sc1, sc2, sc3, sc4, sc5, sc6, sc7, sc8,
                sd1, sd2, sd3, sd4, sd5, sd6, sd7, sd8,
                se1, se2, se3, se4, se5, se6, se7, se8,
                sf1, sf2, sf3, sf4, sf5, sf6, sf7, sf8,
                sg1, sg2, sg3, sg4, sg5, sg6, sg7, sg8,
                sh1, sh2, sh3, sh4, sh5, sh6, sh7, sh8,
        };

        for (int i = 0; i < loc_list.length; i++) {
            loc_list[i].getStylesheets().add("resources/views/css/stylesheet.css");
        }

        logic.pieces.addAll(Arrays.asList(loc_list));
        logic.stack_panes.addAll(Arrays.asList(pane_list));

        // Add the matching graphics to the pieces (toggle buttons)

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
    }

    // Methods for when the pieces are clicked

    public void brook1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(brook1);
        logic.create_destinations(brook1);
    }

    public void bknight1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bknight1);
        logic.create_destinations(bknight1);
    }

    public void bbishop1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bbisop1);
        logic.create_destinations(bbisop1);
    }

    public void bqueen_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bqueen);
    }

    public void bking_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bking);
    }

    public void bbishop2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bbishop2);
        logic.create_destinations(bbishop2);
    }

    public void bknight2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bknight2);
        logic.create_destinations(bknight2);
    }

    public void brook2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(brook2);
        logic.create_destinations(brook2);
    }

    public void wpawn1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn1);
        logic.create_destinations(wpawn1);
    }

    public void wrook1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wrook1);
        logic.create_destinations(wrook1);
    }

    public void wpawn2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn2);
        logic.create_destinations(wpawn2);
    }

    public void wknight1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wknight1);
        logic.create_destinations(wknight1);
    }

    public void wpawn3_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn3);
        logic.create_destinations(wpawn3);
    }

    public void wbishop1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wbishop1);
        logic.create_destinations(wbishop1);
    }

    public void wpawn4_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn4);
        logic.create_destinations(wpawn4);
    }

    public void wqueen_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wqueen);
    }

    public void wpawn5_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn5);
        logic.create_destinations(wpawn5);
    }

    public void wking_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wking);
    }

    public void wpawn6_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn6);
        logic.create_destinations(wpawn6);
    }

    public void wbishop2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wbishop2);
        logic.create_destinations(wbishop2);
    }

    public void wpawn7_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn7);
        logic.create_destinations(wpawn7);
    }

    public void wknight2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wknight2);
        logic.create_destinations(wknight2);
    }

    public void wpawn8_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wpawn8);
        logic.create_destinations(wpawn8);
    }

    public void wrook2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(wrook2);
        logic.create_destinations(wrook2);
    }


    public void bpawn1_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn1);
        logic.create_destinations(bpawn1);
    }

    public void bpawn2_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn2);
        logic.create_destinations(bpawn2);
    }

    public void bpawn3_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn3);
        logic.create_destinations(bpawn3);
    }

    public void bpawn4_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn4);
        logic.create_destinations(bpawn4);
    }

    public void bpawn5_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn5);
        logic.create_destinations(bpawn5);
    }

    public void bpawn6_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn6);
        logic.create_destinations(bpawn6);
    }

    public void bpawn7_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn7);
        logic.create_destinations(bpawn7);
    }

    public void bpawn8_clicked(MouseEvent mouseEvent) {
        logic.untoggleOthers(bpawn8);
        logic.create_destinations(bpawn8);
    }

    // Methods for when the pieces are clicked

    public void sa8_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sa8);
    }

    public void sb8_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sb8);
    }

    public void sc8_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sc8);
    }

    public void sd8_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sd8);
    }

    public void se8_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(se8);
    }

    public void sf8_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sf8);
    }

    public void sg8_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sg8);
    }

    public void sh8_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sh8);
    }

    public void sa7_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sa7);
    }

    public void sa6_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sa6);
    }

    public void sa5_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sa5);
    }

    public void sa4_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sa4);
    }

    public void sa3_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sa3);
    }

    public void sa2_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sa2);
    }

    public void sa1_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sa1);
    }

    public void sb7_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sb7);
    }

    public void sb6_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sb6);
    }

    public void sb5_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sb5);
    }

    public void sb4_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sb4);
    }

    public void sb3_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sb3);
    }

    public void sb2_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sb2);
    }

    public void sb1_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sb1);
    }

    public void sc7_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sc7);
    }

    public void sc6_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sc6);
    }

    public void sc5_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sc5);
    }

    public void sc4_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sc4);
    }

    public void sc3_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sc3);
    }

    public void sc2_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sc2);
    }

    public void sc1_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sc1);
    }

    public void sd7_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sd7);
    }

    public void sd6_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sd6);
    }

    public void sd5_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sd5);
    }

    public void sd4_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sd4);
    }

    public void sd3_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sd3);
    }

    public void sd2_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sd2);
    }

    public void sd1_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sd1);
    }

    public void se7_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(se7);
    }

    public void se6_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(se6);
    }

    public void se5_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(se5);
    }

    public void se4_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(se4);
    }

    public void se3_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(se3);
    }

    public void se2_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(se2);
    }

    public void se1_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(se1);
    }

    public void sf7_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sf7);
    }

    public void sf6_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sf6);
    }

    public void sf5_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sf5);
    }

    public void sf4_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sf4);
    }

    public void sf3_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sf3);
    }

    public void sf2_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sf2);
    }

    public void sf1_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sf1);
    }

    public void sg7_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sg7);
    }

    public void sg6_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sg6);
    }

    public void sg5_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sg5);
    }

    public void sg4_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sg4);
    }

    public void sg3_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sg3);
    }

    public void sg2_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sg2);
    }

    public void sg1_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sg1);
    }

    public void sh7_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sh7);
    }

    public void sh6_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sh6);
    }

    public void sh5_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sh5);
    }

    public void sh4_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sh4);
    }

    public void sh3_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sh3);
    }

    public void sh2_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sh2);
    }

    public void sh1_clicked(MouseEvent mouseEvent) {
        logic.check_for_toggled_piece(sh1);
    }
}
