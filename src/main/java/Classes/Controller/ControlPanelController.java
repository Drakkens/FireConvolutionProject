package Classes.Controller;

import Classes.Model.ColorUtility.ColorPalette;
import Classes.Model.ColorUtility.ColorPaletteHandler;
import Classes.Model.Convolution.ConvolutedImage;
import Classes.Model.Flame.Flame;
import Classes.View.ControlPanel.ControlPanelHolder;
import Classes.View.ImageViewer.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static Classes.Utils.ImageUtils.resize;
import static Classes.Utils.ImageUtils.selectFile;

public final class ControlPanelController {

    private final ColorPaletteHandler colorPaletteHandler = new ColorPaletteHandler();
    private final ControlPanelHolder controlPanelHolder;
    private View defaultView;
    private View convolutedView;
    private View fireView;
    private View onFireView;

    public ControlPanelController(ControlPanelHolder controlPanelHolder) {
        this.controlPanelHolder = controlPanelHolder;

    }

    public void setDefaultImage() {
        try {
            BufferedImage bufferedImage = ImageIO.read(Objects.requireNonNull(selectFile()));

            defaultView.setImage(resize(bufferedImage, defaultView.getWidth(), defaultView.getHeight()));
            onFireView.setImage(resize(bufferedImage, onFireView.getWidth(), onFireView.getHeight()));

            defaultView.drawImage();
            onFireView.drawImage();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int[][] createKernel(JSpinner[][] spinners) {
        int[][] kernel = new int[3][3];

        for (int i = 0; i < spinners.length; i++) {
            for (int j = 0; j < spinners[1].length; j++) {
                kernel[i][j] = (int) spinners[i][j].getValue();
            }
        }

        return kernel;
    }

    public void startFire(int[][] smallSparkablePixels, int[][] bigSparkablePixels ) {
        fireView.setFlame(new Flame(fireView.getWidth(), fireView.getHeight(), new ColorPalette(colorPaletteHandler.getColorArray()), smallSparkablePixels));
        onFireView.setFlame(new Flame(onFireView.getWidth(), onFireView.getHeight(), new ColorPalette(colorPaletteHandler.getColorArray()), bigSparkablePixels));

    }

    public void changeColors() {
        fireView.getFlame().setColorPalette(new ColorPalette(colorPaletteHandler.getColorArray()));
        onFireView.getFlame().setColorPalette(new ColorPalette(colorPaletteHandler.getColorArray()));

    }


    public void toggleFire() {
        fireView.getFlame().setRunning(onFireView.getFlame().isRunning());
        onFireView.getFlame().setRunning(onFireView.getFlame().isRunning());

    }

    public void changeSparkChance(int chance) {
        fireView.getFlame().setSparkChance(chance);
        onFireView.getFlame().setSparkChance(chance);

    }

    public void changeCoolingChance(int chance) {
        fireView.getFlame().setCoolingChance(chance);
        onFireView.getFlame().setCoolingChance(chance);

    }


    public void setConvolutedImage(JSpinner[][] spinners) {
        BufferedImage image = controlPanelHolder.getMain().getImageViewHolder().getDefaultImageView().getImage();
        ConvolutedImage convolutedImage = new ConvolutedImage(image, createKernel(spinners));

        convolutedView.setImage(convolutedImage);
        convolutedView.drawImage();

        BufferedImage resizedImage = resize(controlPanelHolder.getMain().getImageViewHolder().getDefaultImageView().getImage(), onFireView.getWidth(), onFireView.getHeight());
        ConvolutedImage resizedConvolutedImage = new ConvolutedImage(resizedImage, createKernel(spinners));

        startFire(convolutedImage.getPixelValues(), resizedConvolutedImage.getPixelValues());
    }

    public ColorPaletteHandler getColorHandler() {
        return colorPaletteHandler;

    }

    public Color chooseColor() {
        return JColorChooser.showDialog(null, "Select Color", null);
    }

    public ControlPanelHolder controlPanelHolder() {
        return controlPanelHolder;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ControlPanelController) obj;
        return Objects.equals(this.controlPanelHolder, that.controlPanelHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controlPanelHolder);
    }

    @Override
    public String toString() {
        return "ControlPanelController[" +
                       "controlPanelHolder=" + controlPanelHolder + ']';
    }


    public void setDefaultView(View defaultView) {
        this.defaultView = defaultView;
    }

    public void setConvolutedView(View convolutedView) {
        this.convolutedView = convolutedView;
    }

    public void setFireView(View fireView) {
        this.fireView = fireView;
    }

    public void setOnFireView(View onFireView) {
        this.onFireView = onFireView;
    }
}
