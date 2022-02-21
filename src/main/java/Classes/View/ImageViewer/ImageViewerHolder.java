package Classes.View.ImageViewer;

import Classes.Main;
import Classes.Utils.ConstraintsUtils;
import Classes.Utils.UICreationUtils;

import javax.swing.*;
import java.awt.*;

public class ImageViewerHolder extends JPanel {
    private View defaultImageView;
    private View convolutedImageView;
    private View fireImageView;
    private View onFireImageView;

    public ImageViewerHolder(Main main, Dimension dimension) {
        super(new GridBagLayout());
        this.setSize(dimension);
        this.setBackground(Color.BLACK);

        ConstraintsUtils constraints = new ConstraintsUtils();
        UICreationUtils creationUtils = new UICreationUtils(this, constraints);

        defaultImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        constraints.resetConstraints().changeConstraintsPosition(0, 0).changeConstraintsWeight(1, 1);
        this.add(defaultImageView, constraints);

        convolutedImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        constraints.changeConstraintsPosition(1, 0);
        this.add(convolutedImageView, constraints);

        fireImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        constraints.changeConstraintsPosition(2, 0);
        this.add(fireImageView, constraints);

        onFireImageView = new View(new Dimension(this.getWidth(), this.getHeight() - fireImageView.getHeight()));
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

    public View getConvolutedImageView() {
        return this.convolutedImageView;
    }

    public View getFireImageView() {
        return this.fireImageView;
    }

    public View getOnFireView() {
        return this.onFireImageView;
    }

    public void resetImageView() {
        convolutedImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        fireImageView = new View(new Dimension(this.getWidth() / 3, this.getHeight() / 4));
        onFireImageView = new View(new Dimension(this.getWidth(), this.getHeight() - fireImageView.getHeight()));
    }

}
