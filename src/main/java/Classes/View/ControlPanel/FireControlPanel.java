package Classes.View.ControlPanel;

import Classes.Model.ColorUtility.ColorPaletteHandler;
import Classes.Model.ColorUtility.TargetColor;
import Classes.Utils.ConstraintsUtils;
import Classes.Utils.UICreationUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FireControlPanel extends JPanel {

    public FireControlPanel(Dimension dimension, ControlPanelHolder controlPanelHolder) {
        super(new GridBagLayout());
        this.setSize(dimension);
        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);
        final ColorPaletteHandler colorHandler = controlPanelHolder.getController().getColorHandler();


        constraints.resetConstraints().changeConstraintsPosition(0, 0).changeConstraintsWeight(1, 0).changeConstraintsDimensions(2, 1);
        constraints.insets = new Insets(10, 10, 10, 10);

        JComboBox<?> comboBox = creationUtils.createComboBox(colorHandler.getColorArray(), null);

        //JButton Delete
        constraints.changeConstraintsPosition(2, 0).changeConstraintsDimensions(3, 1);
        creationUtils.createButton("Delete Color", e -> colorHandler.removeSelectedColor(comboBox));

        //Show Selected Color near button
        constraints.changeConstraintsPosition(0, 1).changeConstraintsDimensions(1, 1);
        creationUtils.createLabel("Temperature Value");

        constraints.changeConstraintsPosition(1, 1);
        JSpinner spinner = creationUtils.createSpinner(new SpinnerNumberModel(1, 0, 256, 1), null);

        constraints.changeConstraintsPosition(2, 1);
        creationUtils.createButton("Add Color", e -> colorHandler.addColor((JComboBox<TargetColor>) comboBox, new TargetColor((Integer) spinner.getValue(), controlPanelHolder.getController().chooseColor())));

        constraints.changeConstraintsPosition(3, 1);
        creationUtils.createButton("Randomize Colors", e -> colorHandler.randomizeColors((JComboBox<TargetColor>) comboBox));

        constraints.changeConstraintsPosition(4, 1);
        creationUtils.createButton("Apply Colors", e -> controlPanelHolder.getController().changeColors());

//        constraints.changeConstraintsPosition(0, 2);
//        creationUtils.createButton("Start Flame", e -> controlPanelHolder.getController().startFire());

        constraints.changeConstraintsPosition(0,2);
        creationUtils.createButton("Toggle Running", e -> controlPanelHolder.getController().toggleFire());

        constraints.changeConstraintsPosition(1, 2);
        creationUtils.createLabel("Spark Chance");

        constraints.changeConstraintsPosition(2, 2);
        creationUtils.createSlider(0, 100, e -> controlPanelHolder.getController().changeSparkChance(((JSlider) e.getSource()).getValue()));

        constraints.changeConstraintsPosition(3, 2);
        creationUtils.createLabel("Cooling Chance");

        constraints.changeConstraintsPosition(4, 2);
        creationUtils.createSlider(0, 100, e -> controlPanelHolder.getController().changeCoolingChance(((JSlider) e.getSource()).getValue()));

        this.setVisible(true);
    }
}
