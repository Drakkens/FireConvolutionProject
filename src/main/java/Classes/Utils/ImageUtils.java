package Classes.Utils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static javax.swing.JFileChooser.APPROVE_OPTION;

public class ImageUtils {

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        Image tempImage = image.getScaledInstance(width, height, Image.SCALE_FAST);

        BufferedImage bImage = new BufferedImage(width, height, image.getType());

        Graphics2D g2d = bImage.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();

        return bImage;
    }

    public static File selectFile() {

        JFileChooser fileChooser = new JFileChooser("C:/Users/joanf/Downloads");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Documents", "jpg", "png", "jpeg"));

        //Reads Document
        if (fileChooser.showOpenDialog(null) == APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }
}
