package Classes.View.ControlPanel;

import Classes.Controller.ControlPanelController;
import Classes.Utils.ConstraintsUtils;
import Classes.Utils.UICreationUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static javax.swing.JFileChooser.APPROVE_OPTION;

public class FireControlPanel extends JPanel {

    public FireControlPanel(ControlPanelHolder controlPanelHolder) {
        super(new GridBagLayout());
        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);


        this.setVisible(true);
    }
}
