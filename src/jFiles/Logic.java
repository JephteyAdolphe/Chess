package jFiles;

import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Objects;

public class Logic {

    public ArrayList<ToggleButton> pieces = new ArrayList<>();
    public ArrayList<StackPane> stack_panes = new ArrayList<>();
    private ArrayList<StackPane> possible_destinations = new ArrayList<>();
    private ArrayList<ToggleButton> prey = new ArrayList<>();
    private  ArrayList<ToggleButton> predator = new ArrayList<>();
    private ArrayList<ToggleButton> queens_prey = new ArrayList<>();

    private int color_tracker = 1;

    // Checks if the most recently clicked button is being targeted

    public boolean check_if_targeted(ToggleButton button) {
        if (prey.contains(button)) {
            StackPane sp = (StackPane) button.getParent();
            pieces.remove(button);
            sp.getChildren().remove(button);
            predator.get(0).setSelected(false);
            sp.getChildren().add(predator.get(0));
            color_tracker++;
            return true;
        } return false;
    }

    private String color_of_toggled() {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).isSelected() && pieces.get(i).getId().startsWith("b")) {
                return "black";
            } else if (pieces.get(i).isSelected() && pieces.get(i).getId().startsWith("w")) {
                return "white";
            }
        } return null;
    }

    private String check_color_of(ToggleButton tb) {
        for (int i = 0; i < pieces.size(); i++) {
            if (tb.getId().startsWith("b")) {
                return "black";
            } else if (tb.getId().startsWith("w")) {
                return "white";
            }
        } return null;
    }

    public boolean is_it_my_turn(ToggleButton butt) {
        if (color_tracker % 2 == 0 && Objects.equals(check_color_of(butt), "white")) {
            butt.setSelected(false);
            return false;
        } else if (color_tracker % 2 != 0 && Objects.equals(check_color_of(butt), "black")) {
            butt.setSelected(false);
            return false;
        }
        return true;
    }

    private ToggleButton currently_toggled() {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).isSelected()) {
                return pieces.get(i);
            }
        } return null;
    }

    public void make_predator(ToggleButton pred) {
        predator.clear();
        predator.add(pred);
    }

    public void untoggleOthers(ToggleButton picked) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i) != picked) {
                pieces.get(i).setSelected(false);
            }
        }
    }

    // Checks to see what piece, if any, is toggled

    public void check_for_toggled_piece(StackPane sp) {

        ToggleButton toggled_piece = null;

        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).isSelected()) {
                toggled_piece = pieces.get(i);
                break;
            }
        }
        // Checks if the pressed StackPane is in the list of valid destination panes for the selected piece
        if (possible_destinations.contains(sp)) {
            sp.getChildren().add(toggled_piece);
            color_tracker++;
            assert toggled_piece != null;
            toggled_piece.setSelected(false);
        }
    }

    // Contains switch case for determining how to make the list of valid destinations

    public void create_destinations(ToggleButton pressed) {
        possible_destinations.clear();
        String currentPane = pressed.getParent().getId();

        int row = 0;
        int col = 0;

        for (int i = 0; i < stack_panes.size(); i++) {
            if (String.valueOf(stack_panes.get(i).getId()).equals(currentPane)) {
                row = GridPane.getRowIndex(stack_panes.get(i));
                col = GridPane.getColumnIndex(stack_panes.get(i));

                System.out.println(String.format("(%d, %d)", row, col));
                break;
            }
        }

        switch (String.valueOf(pressed.getId())) {
            case "bpawn1":
            case "bpawn2":
            case "bpawn3":
            case "bpawn4":
            case "bpawn5":
            case "bpawn6":
            case "bpawn7":
            case "bpawn8":
            case "wpawn1":
            case "wpawn2":
            case "wpawn3":
            case "wpawn4":
            case "wpawn5":
            case "wpawn6":
            case "wpawn7":
            case "wpawn8":
                pawn_pressed(pressed, row, col);
                break;

            case "brook1":
            case "brook2":
            case "wrook1":
            case "wrook2":
                rook_pressed(row, col);
                break;

            case "bknight1":
            case "bknight2":
            case "wknight1":
            case "wknight2":
                knight_pressed(row, col);
                break;

            case "bbishop1":
            case "bbishop2":
            case "wbishop1":
            case "wbishop2":
                bishop_pressed(row, col);
                break;

            case "bqueen":
            case "wqueen":
                queen_pressed(row, col);
                break;

            case "bking":
            case "wking":
                king_pressed(row, col);
                break;
        }
    }

    private void pawn_pressed(ToggleButton pressed, int row, int col) {
        for (int i = 0; i < stack_panes.size(); i++) {
            int tempCol = GridPane.getColumnIndex(stack_panes.get(i));
            int tempRow = GridPane.getRowIndex(stack_panes.get(i));

            // Generates a list depending on which color pawn is in play

            if (String.valueOf(pressed.getId()).contains("bpawn")) {

                if (tempCol == col && tempRow == row + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                    break;
                }
            }

            if (String.valueOf(pressed.getId()).contains("wpawn")) {

                if (tempCol == col && tempRow == row - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                    break;
                }
            }
        }
        // Generates an array list of valid targets

        prey.clear();
        for (int i = 0; i < pieces.size(); i++) {

            int tempCol = GridPane.getColumnIndex(pieces.get(i).getParent());
            int tempRow = GridPane.getRowIndex(pieces.get(i).getParent());

            if (String.valueOf(pressed.getId()).contains("bpawn")) {

                if (tempCol == col + 1 && tempRow == row + 1 && Objects.equals(check_color_of(pieces.get(i)), "white")) {
                    prey.add(pieces.get(i));
                }
                if (tempCol == col - 1 && tempRow == row + 1 && Objects.equals(check_color_of(pieces.get(i)), "white")) {
                    prey.add(pieces.get(i));
                }
            }

            if (String.valueOf(pressed.getId()).contains("wpawn")) {

                if (tempCol == col + 1 && tempRow == row - 1 && Objects.equals(check_color_of(pieces.get(i)), "black")) {
                    prey.add(pieces.get(i));
                }
                if (tempCol == col - 1 && tempRow == row - 1 && Objects.equals(check_color_of(pieces.get(i)), "black")) {
                    prey.add(pieces.get(i));
                }
            }
        }
    }

        private void rook_pressed (int row, int col){
            // Row by row check for open spots and rook cannot jump over pieces so we break when we hit the first tile
            // with a piece on it

            prey.clear();

            for (int r = row + 1; r <= 7; r++) {
                int rowLimit = 0;

                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getColumnIndex(stack_panes.get(i)) == col && GridPane.getRowIndex(stack_panes.get(i)) == r && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                        break;
                    } else if (GridPane.getColumnIndex(stack_panes.get(i)) == col && GridPane.getRowIndex(stack_panes.get(i)) == r && !stack_panes.get(i).getChildren().isEmpty()) {
                        rowLimit = 1;

                        // checks for valid enemies
                       for (int p = 0; p < pieces.size(); p++) {
                           StackPane sp = (StackPane) pieces.get(p).getParent();
                           if (GridPane.getColumnIndex(sp) == col && GridPane.getRowIndex(sp) == r) {
                               if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                   prey.add(pieces.get(p));
                                   queens_prey.add(pieces.get(p));
                               }
                           }
                       }
                        break;
                    }
                }
                if (rowLimit == 1) break;
            }

            // Col by col check for open spots and rook cannot jump over pieces so we break when we hit the first tile
            // with a piece on it

            for (int c = col + 1; c <= 7; c++) {
                int colLimit = 0;

                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == c && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                        break;
                    } else if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == c && !stack_panes.get(i).getChildren().isEmpty()) {
                        colLimit = 1;

                        // checks for valid enemies
                        for (int p = 0; p < pieces.size(); p++) {
                            StackPane sp = (StackPane) pieces.get(p).getParent();
                            if (GridPane.getColumnIndex(sp) == c && GridPane.getRowIndex(sp) == row) {
                                if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                    prey.add(pieces.get(p));
                                    queens_prey.add(pieces.get(p));
                                }
                            }
                        }
                        break;
                    }
                }
                if (colLimit == 1) break;
            }
            // Row by row in opposite direction
            for (int r = row - 1; r >= 0; r--) {
                int rowLimit = 0;

                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getColumnIndex(stack_panes.get(i)) == col && GridPane.getRowIndex(stack_panes.get(i)) == r && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                        break;
                    } else if (GridPane.getColumnIndex(stack_panes.get(i)) == col && GridPane.getRowIndex(stack_panes.get(i)) == r && !stack_panes.get(i).getChildren().isEmpty()) {
                        rowLimit = 1;

                        // checks for valid enemies
                        for (int p = 0; p < pieces.size(); p++) {
                            StackPane sp = (StackPane) pieces.get(p).getParent();
                            if (GridPane.getColumnIndex(sp) == col && GridPane.getRowIndex(sp) == r) {
                                if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                    prey.add(pieces.get(p));
                                    queens_prey.add(pieces.get(p));
                                }
                            }
                        }
                        break;
                    }
                }
                if (rowLimit == 1) break;
            }
            // Col by col in opposite direction
            for (int c = col - 1; c >= 0; c--) {
                int colLimit = 0;

                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == c && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                        break;
                    } else if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == c && !stack_panes.get(i).getChildren().isEmpty()) {
                        colLimit = 1;

                        // checks for valid enemies
                        for (int p = 0; p < pieces.size(); p++) {
                            StackPane sp = (StackPane) pieces.get(p).getParent();
                            if (GridPane.getColumnIndex(sp) == c && GridPane.getRowIndex(sp) == row) {
                                if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                    prey.add(pieces.get(p));
                                    queens_prey.add(pieces.get(p));
                                }
                            }
                        }
                        break;
                    }
                }
                if (colLimit == 1) break;
            }
        }

        private void knight_pressed(int row, int col) {
            prey.clear();

            // Checks all possible spots for the knight (regardless of its color) to land

            for (int i = 0; i < stack_panes.size(); i++) {
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 2 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 2 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col + 2 && GridPane.getRowIndex(sp) == row + 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 2 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 2 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col - 2 && GridPane.getRowIndex(sp) == row + 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 2 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 2 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col + 2 && GridPane.getRowIndex(sp) == row - 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 2 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 2 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col - 2 && GridPane.getRowIndex(sp) == row - 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row + 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col + 1 && GridPane.getRowIndex(sp) == row + 2) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row + 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col - 1 && GridPane.getRowIndex(sp) == row + 2) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row - 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col + 1 && GridPane.getRowIndex(sp) == row - 2) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row - 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col - 1 && GridPane.getRowIndex(sp) == row - 2) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
            }
        }

        private void bishop_pressed(int row, int col) {
            int r = row;
            int c = col;

            prey.clear();

            // bottom right check
            while(true) {
                int limit = 0;
                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getRowIndex(stack_panes.get(i)) == r + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                    } else if (GridPane.getRowIndex(stack_panes.get(i)) == r + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c + 1 && !stack_panes.get(i).getChildren().isEmpty()) {
                        limit = 1;

                        // checks for valid enemies
                        for (int p = 0; p < pieces.size(); p++) {
                            StackPane sp = (StackPane) pieces.get(p).getParent();
                            if (GridPane.getColumnIndex(sp) == c + 1 && GridPane.getRowIndex(sp) == r + 1) {
                                if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                    prey.add(pieces.get(p));
                                    queens_prey.add(pieces.get(p));
                                }
                            }
                        }
                    }
                }
                if (limit == 1) break;
                r++;
                c++;
                if (c == 9) break;
            }
            r = row;
            c = col;

            // bottom left check
            while(true) {
                int limit = 0;
                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getRowIndex(stack_panes.get(i)) == r + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                    } else if (GridPane.getRowIndex(stack_panes.get(i)) == r + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c - 1 && !stack_panes.get(i).getChildren().isEmpty()) {
                        limit = 1;

                        // checks for valid enemies
                        for (int p = 0; p < pieces.size(); p++) {
                            StackPane sp = (StackPane) pieces.get(p).getParent();
                            if (GridPane.getColumnIndex(sp) == c - 1 && GridPane.getRowIndex(sp) == r + 1) {
                                if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                    prey.add(pieces.get(p));
                                    queens_prey.add(pieces.get(p));
                                }
                            }
                        }
                    }
                }
                if (limit == 1) break;
                r++;
                c--;
                if (c == -1) break;
            }

            r = row;
            c = col;

            // top right check
            while(true) {
                int limit = 0;
                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getRowIndex(stack_panes.get(i)) == r - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                    } else if (GridPane.getRowIndex(stack_panes.get(i)) == r - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c + 1 && !stack_panes.get(i).getChildren().isEmpty()) {
                        limit = 1;

                        // checks for valid enemies
                        for (int p = 0; p < pieces.size(); p++) {
                            StackPane sp = (StackPane) pieces.get(p).getParent();
                            if (GridPane.getColumnIndex(sp) == c + 1 && GridPane.getRowIndex(sp) == r - 1) {
                                if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                    prey.add(pieces.get(p));
                                    queens_prey.add(pieces.get(p));
                                }
                            }
                        }
                    }
                }
                if (limit == 1) break;
                r--;
                c++;
                if (c == 9) break;
            }

            r = row;
            c = col;

            // top left check
            while(true) {
                int limit = 0;
                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getRowIndex(stack_panes.get(i)) == r - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                    } else if (GridPane.getRowIndex(stack_panes.get(i)) == r - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c - 1 && !stack_panes.get(i).getChildren().isEmpty()) {
                        limit = 1;

                        // checks for valid enemies
                        for (int p = 0; p < pieces.size(); p++) {
                            StackPane sp = (StackPane) pieces.get(p).getParent();
                            if (GridPane.getColumnIndex(sp) == c - 1 && GridPane.getRowIndex(sp) == r - 1) {
                                if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                    prey.add(pieces.get(p));
                                    queens_prey.add(pieces.get(p));
                                }
                            }
                        }
                    }
                }
                if (limit == 1) break;
                r--;
                c--;
                if (c == -1) break;
            }
        }

        private void queen_pressed(int row, int col) {

            // Queen has the abilities of both the rook and the bishop

            queens_prey.clear();    // removes old rook / bishop prey from the list so that the correct prey can be added
            rook_pressed(row, col);
            bishop_pressed(row, col);

            // prevents duplicates from being added to main prey list
            for (int i = 0; i < queens_prey.size(); i++) {
                if (!prey.contains(queens_prey.get(i))) {
                    prey.add(queens_prey.get(i));
                }
            }
        }

        private void king_pressed(int row, int col) {
            prey.clear();

            // Checks 1 cell away on all sides of the king

            for (int i = 0; i < stack_panes.size(); i++) {
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col && GridPane.getRowIndex(sp) == row - 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col + 1 && GridPane.getRowIndex(sp) == row - 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col + 1 && GridPane.getRowIndex(sp) == row) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col + 1 && GridPane.getRowIndex(sp) == row + 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col && GridPane.getRowIndex(sp) == row + 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col - 1 && GridPane.getRowIndex(sp) == row + 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col - 1 && GridPane.getRowIndex(sp) == row) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                } else if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && !stack_panes.get(i).getChildren().isEmpty()) {

                    // checks for valid enemies
                    for (int p = 0; p < pieces.size(); p++) {
                        StackPane sp = (StackPane) pieces.get(p).getParent();
                        if (GridPane.getColumnIndex(sp) == col - 1 && GridPane.getRowIndex(sp) == row - 1) {
                            if ((Objects.equals(color_of_toggled(), "black") && Objects.equals(check_color_of(pieces.get(p)), "white")) || (Objects.equals(color_of_toggled(), "white") && Objects.equals(check_color_of(pieces.get(p)), "black"))) {
                                prey.add(pieces.get(p));
                            }
                        }
                    }
                }
            }
        }
    }
