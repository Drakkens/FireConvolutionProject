package Classes.View.ControlPanel;

import Classes.Utils.ConstraintsUtils;
import Classes.Utils.UICreationUtils;

import javax.swing.*;

public class ConvolutionControlPanel extends JPanel {

    public ConvolutionControlPanel(ControlPanelHolder controlPanelHolder) {
        super();

        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);

        constraints.resetConstraints().changeConstraintsPosition(0,0);
        creationUtils.createButton("Convolute", e -> controlPanelHolder.getController().setConvolutedImage());

        this.setVisible(true);
    }
}
