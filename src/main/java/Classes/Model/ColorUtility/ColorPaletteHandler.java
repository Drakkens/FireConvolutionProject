package Classes.Model.ColorUtility;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ColorPaletteHandler {

    private final ArrayList<TargetColor> targetColorArrayList = new ArrayList<>(Arrays.asList(
            new TargetColor(255, new Color(255, 255, 0, 255)),
            new TargetColor(170, new Color(255, 128, 0, 255)),
            new TargetColor(64, new Color(255, 0, 0, 128)),
            new TargetColor(0, new Color(0, 0, 0, 0))));


    public void removeSelectedColor(JComboBox<?> comboBox) {
        if (comboBox.getItemCount() > 0 && targetColorArrayList.size() > 0) {
            final int selectedIndex = comboBox.getSelectedIndex();
            comboBox.removeItemAt(selectedIndex);
            targetColorArrayList.remove(selectedIndex);
        }

    }

    public void addColor(JComboBox<TargetColor> comboBox, TargetColor color) {
        comboBox.addItem(color);
        targetColorArrayList.add(color);
    }

    public void randomizeColors(JComboBox<TargetColor> comboBox) {
        targetColorArrayList.removeAll(targetColorArrayList);
        comboBox.removeAllItems();

        for (int i = 0; i < 4; i++) {
            TargetColor color = new TargetColor(256 - (64 * i), new Color((int) Math.floor(Math.random() * 255), (int) Math.floor(Math.random() * 255), (int) Math.floor(Math.random() * 255), 128));
            targetColorArrayList.add(color);
            comboBox.addItem(color);
        }

        TargetColor black = new TargetColor(0, new Color(0, 0, 0, 0));
        comboBox.addItem(black);
        targetColorArrayList.add(black);
    }

    public ArrayList<TargetColor> getColorArray() {
        return this.targetColorArrayList;
    }
}
