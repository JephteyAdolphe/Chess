package jFiles;

import javafx.scene.control.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;

public class Logic {

    public ArrayList<ToggleButton> pieces = new ArrayList<>();

    public void untoggleOthers(ToggleButton picked) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i) != picked) {
                pieces.get(i).setSelected(false);
            }
        }
        System.out.println("untoggled");
    }
}
