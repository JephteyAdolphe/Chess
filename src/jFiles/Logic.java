package jFiles;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Logic {

    public ArrayList<ToggleButton> pieces = new ArrayList<>();
    public ArrayList<StackPane> stack_panes = new ArrayList<>();
    private ArrayList<StackPane> possible_destinations = new ArrayList<>();

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
    }

        private void rook_pressed (int row, int col){
            // Row by row check for open spots and rook cannot jump over pieces so we break when we hit the first tile
            // with a piece on it

            for (int r = row + 1; r <= 7; r++) {
                int rowLimit = 0;

                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getColumnIndex(stack_panes.get(i)) == col && GridPane.getRowIndex(stack_panes.get(i)) == r && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                        break;
                    } else if (GridPane.getColumnIndex(stack_panes.get(i)) == col && GridPane.getRowIndex(stack_panes.get(i)) == r && !stack_panes.get(i).getChildren().isEmpty()) {
                        rowLimit = 1;
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
                        break;
                    }
                }
                if (colLimit == 1) break;
            }
        }

        private void knight_pressed(int row, int col) {

            // Checks all possible spots for the knight (regardless of its color) to land

            for (int i = 0; i < stack_panes.size(); i++) {
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 2) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 2) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 2) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 2) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 2 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1) {
                    possible_destinations.add(stack_panes.get(i));
                }
            }
        }

        private void bishop_pressed(int row, int col) {
            int r = row;
            int c = col;

            // bottom right check
            while(true) {
                int limit = 0;
                for (int i = 0; i < stack_panes.size(); i++) {
                    if (GridPane.getRowIndex(stack_panes.get(i)) == r + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                        possible_destinations.add(stack_panes.get(i));
                    } else if (GridPane.getRowIndex(stack_panes.get(i)) == r + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == c + 1 && !stack_panes.get(i).getChildren().isEmpty()) {
                        limit = 1;
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

            rook_pressed(row, col);
            bishop_pressed(row, col);
        }

        private void king_pressed(int row, int col) {
            for (int i = 0; i < stack_panes.size(); i++) {
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col + 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row + 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                }
                if (GridPane.getRowIndex(stack_panes.get(i)) == row - 1 && GridPane.getColumnIndex(stack_panes.get(i)) == col - 1 && stack_panes.get(i).getChildren().isEmpty()) {
                    possible_destinations.add(stack_panes.get(i));
                }
            }
        }
    }

