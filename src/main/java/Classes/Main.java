package Classes;

import Classes.Utils.ConstraintsUtils;
import Classes.View.ControlPanel.ControlPanelHolder;
import Classes.View.ImageViewer.ImageViewerHolder;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private final ImageViewerHolder imageViewHolder;

    public Main() {
        super("Fire");
        this.setSize(new Dimension(getToolkit().getScreenSize()));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        this.setLayout(new GridBagLayout());
        ConstraintsUtils constraints = new ConstraintsUtils();

        constraints.resetConstraints().changeConstraintsPosition(0, 0).changeConstraintsWeight(1, 1);
        this.add(new ControlPanelHolder(this, new Dimension(this.getWidth() / 2, this.getHeight())), constraints);

        constraints.changeConstraintsPosition(1, 0).changeConstraintsWeight(1, 1);
        imageViewHolder = new ImageViewerHolder(this, new Dimension(this.getWidth() / 2, this.getHeight()));
        this.add(imageViewHolder, constraints);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    public ImageViewerHolder getImageViewHolder() {
        return this.imageViewHolder;
    }


}
