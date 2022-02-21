package Classes.View.ControlPanel;

import Classes.Utils.ConstraintsUtils;
import Classes.Utils.UICreationUtils;

import javax.swing.*;
import java.awt.*;

public class ConvolutionControlPanel extends JPanel {

    public ConvolutionControlPanel(Dimension dimension, ControlPanelHolder controlPanelHolder) {
        super(new GridBagLayout());
        this.setSize(dimension);

        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);

        constraints.resetConstraints().changeConstraintsPosition(1, 0).changeInsets(0, 0, 10, 0);
        creationUtils.createLabel("Convolution Kernel");
        constraints.changeInsets(0, 0, 0, 0);

        JSpinner[][] spinners = new JSpinner[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                constraints.changeConstraintsPosition(i, j);
                spinners[i][j - 1] = creationUtils.createSpinner(new SpinnerNumberModel(), null);
                spinners[i][j - 1].setPreferredSize(new Dimension(100, 20));

            }
        }


        constraints.changeConstraintsPosition(1, 4).changeInsets(10, 0, 0, 0);
        creationUtils.createButton("Convolute", e -> controlPanelHolder.getController().setConvolutedImage(spinners));

        this.setVisible(true);
    }
}
