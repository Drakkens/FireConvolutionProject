package Classes.Controller;

import Classes.Model.Convolution.ConvolutedImage;
import Classes.View.ControlPanel.ControlPanelHolder;
import Classes.View.ImageViewer.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static javax.swing.JFileChooser.APPROVE_OPTION;

public record ControlPanelController(ControlPanelHolder controlPanelHolder) {

    private File selectFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Documents", "jpg", "png", "jpeg"));

        //Reads Document
        if (fileChooser.showOpenDialog(null) == APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    public void setDefaultImage() {
        try {
            View defaultView = controlPanelHolder.getMain().getImageViewHolder().getDefaultImageView();
            View onFireView = controlPanelHolder.getMain().getImageViewHolder().getOnFireView();

            BufferedImage bufferedImage = ImageIO.read(Objects.requireNonNull(this.selectFile()));
            //Read Image from File Selector, Resize it and Set it on DefaultView
            defaultView.setImage(this.resize(bufferedImage, defaultView.getWidth(), defaultView.getHeight()));
            onFireView.setImage(this.resize(bufferedImage, onFireView.getWidth(), onFireView.getHeight()));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedImage resize(BufferedImage image, int width, int height) {
        Image tempImage = image.getScaledInstance(width, height, Image.SCALE_FAST);

        BufferedImage bImage = new BufferedImage(width, height, image.getType());

        Graphics2D g2d = bImage.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();

        return bImage;
    }


    public void setConvolutedImage() {
        BufferedImage image = controlPanelHolder.getMain().getImageViewHolder().getDefaultImageView().getImage();
        View convolutedView = controlPanelHolder.getMain().getImageViewHolder().getConvolutedImageView();

        convolutedView.setImage(new ConvolutedImage(image));
    }
}
