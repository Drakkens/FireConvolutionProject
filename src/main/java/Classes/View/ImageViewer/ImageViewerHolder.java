package Classes.View.ImageViewer;

import Classes.Main;
import Classes.Utils.ConstraintsUtils;
import Classes.Utils.UICreationUtils;

import javax.swing.*;
import java.awt.*;

public class ImageViewerHolder extends JPanel {
    private final View defaultImageView;
    private final View convolutedImageView;
    private final View fireView;
    private final View onFireImageView;

    public ImageViewerHolder(Main main, Dimension dimension) {
        super(new GridBagLayout());
        this.setSize(dimension);
        this.setBackground(Color.RED);

        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);

        defaultImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        constraints.resetConstraints().changeConstraintsPosition(0, 0).changeConstraintsWeight(1, 1);
        this.add(defaultImageView, constraints);

        convolutedImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        constraints.changeConstraintsPosition(1, 0);
        this.add(convolutedImageView, constraints);

        fireView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        constraints.changeConstraintsPosition(2, 0);
        this.add(fireView, constraints);

        onFireImageView = new View(new Dimension(this.getWidth(), this.getHeight() - fireView.getHeight()));
        constraints.changeConstraintsPosition(0, 1).changeConstraintsDimensions(3, 1).changeConstraintsWeight(1, 3);
        this.add(onFireImageView, constraints);

        this.setVisible(true);


    }

    public View getDefaultImageView() {
        return this.defaultImageView;
    }

    public View getConvolutedImageView() {
        return this.convolutedImageView;
    }
    public View getFireView() {
        return this.fireView;
    }
    public View getOnFireView () {
        return this.onFireImageView;
    }

}
