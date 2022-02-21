package Classes.View.ImageViewer;

import Classes.Main;
import Classes.Utils.ConstraintsUtils;

import javax.swing.*;
import java.awt.*;

public class ImageViewerHolder extends JPanel {
    private final View defaultImageView;

    public ImageViewerHolder(Main main, Dimension dimension) {
        super(new GridBagLayout());
        this.setSize(dimension);
        this.setBackground(Color.BLACK);

        ConstraintsUtils constraints = new ConstraintsUtils();

        defaultImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        constraints.resetConstraints().changeConstraintsPosition(0, 0).changeConstraintsWeight(1, 1);
        this.add(defaultImageView, constraints);

        View convolutedImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        constraints.changeConstraintsPosition(1, 0);
        this.add(convolutedImageView, constraints);

        View fireImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        constraints.changeConstraintsPosition(2, 0);
        this.add(fireImageView, constraints);

        View onFireImageView = new View(new Dimension(this.getWidth(), this.getHeight() - fireImageView.getHeight()));
        constraints.changeConstraintsPosition(0, 1).changeConstraintsDimensions(3, 1).changeConstraintsWeight(1, 3);
        this.add(onFireImageView, constraints);

        this.setVisible(true);

        main.getControlPanelHolder().getController().setDefaultView(defaultImageView);
        main.getControlPanelHolder().getController().setConvolutedView(convolutedImageView);
        main.getControlPanelHolder().getController().setFireView(fireImageView);
        main.getControlPanelHolder().getController().setOnFireView(onFireImageView);

        Thread fireView = new Thread(fireImageView);
        fireView.start();

        Thread onFireView = new Thread(onFireImageView);
        onFireView.start();

    }

    public View getDefaultImageView() {
        return this.defaultImageView;
    }

}
