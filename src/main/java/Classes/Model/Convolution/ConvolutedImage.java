package Classes.Model.Convolution;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ConvolutedImage extends BufferedImage {
    private final int[][] kernel = {{-1, 0, 1}, {-1, 0, 1}, {-1, 0, 1}};
    private int kernelSum;
    private final BufferedImage image;


    public ConvolutedImage(BufferedImage image) {
        super(image.getWidth(), image.getHeight(), TYPE_INT_ARGB);
        this.image = image;

        calculateKernel();

        for (int i = 1; i < image.getWidth() - 1; i++) {
            for (int j = 1; j < image.getHeight() - 1; j++) {
                this.setRGB(i, j, applyKernel(this.getPixels(i, j)));

            }
        }
    }

    private void calculateKernel() {
        for (int[] ints : kernel) {
            for (int anInt : ints) {
                kernelSum += anInt;
            }
        }

        if (kernelSum <= 0) {
            kernelSum = 1;

        }
    }

    private int[][][] getPixels(int currentPixelPositionX, int currentPixelPositionY) {
        int[][][] pixelArray = new int[3][3][3];

        for (int i = 0; i < pixelArray.length; i++) {
            for (int j = 0; j < pixelArray[i].length; j++) {
                pixelArray[i][j] = extractColorsFromPixel(image.getRGB(currentPixelPositionX + (i - 1), currentPixelPositionY + (j - 1)));

            }
        }

        return pixelArray;
    }

    private int[] extractColorsFromPixel(int color) {
        return new int[] {color >> 16 & 0xFF, color >> 8 & 0xFF, color & 0xFF};
    }

    private int applyKernel(int[][][] colorArray) {
        int[] color = new int[3];

        for (int i = 0; i < colorArray.length; i++) {
            for (int j = 0; j < colorArray.length; j++) {
                for (int k = 0; k < colorArray.length; k++) {
                    color[k] += colorArray[i][j][k] * kernel[i][j];
                }
            }
        }

        for (int i = 0; i < color.length ; i++) {
            color[i] /= kernelSum;
            if (color[i] > 255) color[i] = 255;
            else if (color[i] < 0) color[i] = 0;

        }

        return new Color(color[0], color[1], color[2]).getRGB();
    }


}
