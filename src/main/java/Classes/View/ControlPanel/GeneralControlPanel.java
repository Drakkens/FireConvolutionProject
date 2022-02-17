package Classes.View.ControlPanel;

import Classes.Utils.ConstraintsUtils;
import Classes.Utils.UICreationUtils;

import javax.swing.*;
import java.awt.*;

public class GeneralControlPanel extends JPanel {

    public GeneralControlPanel(ControlPanelHolder controlPanelHolder) {
        super(new GridBagLayout());

        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);

        constraints.resetConstraints().changeConstraintsPosition(0, 0);
        creationUtils.createButton("Load Image", e -> controlPanelHolder.getController().setDefaultImage());

        this.setVisible(true);

    }




}
