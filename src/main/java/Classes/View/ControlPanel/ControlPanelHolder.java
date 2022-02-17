package Classes.View.ControlPanel;

import Classes.Controller.ControlPanelController;
import Classes.Main;
import Classes.Utils.ConstraintsUtils;
import Classes.Utils.UICreationUtils;

import javax.swing.*;
import java.awt.*;

public class ControlPanelHolder extends JPanel {
    private final Main main;
    private final ControlPanelController controller;

    public ControlPanelHolder(Main main, Dimension dimension) {

        super(new GridBagLayout());
        this.setSize(dimension);
        this.setBackground(Color.BLACK);

        this.main = main;

        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);

        controller = new ControlPanelController(this);

        constraints.resetConstraints().changeConstraintsPosition(0, 0);
        this.add(new FireControlPanel(this), constraints);

        constraints.changeConstraintsPosition(0, 1);
        this.add(new ConvolutionControlPanel(this), constraints);

        constraints.changeConstraintsPosition(0, 2);
        this.add(new GeneralControlPanel(this), constraints);

        creationUtils.createLabel("Control Panel");

        this.setVisible(true);

    }

    public Main getMain() {
        return this.main;
    }

    public ControlPanelController getController() {
        return this.controller;
    }

}


