/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Model.Flame;

import Classes.Model.ColorUtility.ColorPalette;

import java.awt.image.BufferedImage;


public class Flame extends BufferedImage implements Runnable {
    private final int dimX;
    private final int dimY;
    private boolean running = true;
    private int sparkChance = 7;
    private int coolingChance = 33;

    private ColorPalette colorPalette;

    private final int[][] temperatureArray;
    private final int[][] flameArray;

    private final int[][] sparkablePixels;

    public Flame(int dimX, int dimY, ColorPalette colorPalette, int[][] sparkablePixels) {
        super(dimX, dimY, TYPE_INT_ARGB);

        this.dimX = dimX;
        this.dimY = dimY;

        this.colorPalette = colorPalette;

        this.temperatureArray = new int[dimX][dimY];
        this.flameArray = new int[dimX][dimY];

        this.sparkablePixels = sparkablePixels;

        Thread thread = new Thread(this);
        thread.start();

    }

    public boolean isRunning() {
        return !running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public void setSparkChance(int chance) {
        this.sparkChance = chance;
    }

    public void setCoolingChance(int chance) {
        this.coolingChance = chance;
    }

    public void setColorPalette(ColorPalette colorPalette) {
        this.colorPalette = colorPalette;
    }

    /**
     * Sets RGB to pixel given its temperature, grabbing the Colors from the ColorPalette
     */

    private void setRGBFromArray() {
        for (int y = dimY - 1; y >= 0; y--) {
            for (int x = 0; x < dimX; x++) {
                flameArray[x][y] = temperatureArray[x][y];
                this.setRGB(x, y, colorPalette.getTempMap().get(flameArray[x][y]));
            }
        }
    }


    /**
     * Populates temperatureArray with newly calculated temperature values
     */
    public void modifyArrays() {
        setCoolSpots(this.getHeight(), coolingChance);
        setSparks(sparkChance);

        for (int y = dimY - 2; y > 0; y--) {
            for (int x = 1; x < dimX - 1; x++) {
                temperatureArray[x][y] = calculateTemperature(x, y);

            }
        }


    }


    private int calculateTemperature(int width, int height) {
        int currentPixelTemp = temperatureArray[width][height];
        int bLPixelTemp = temperatureArray[width - 1][height + 1];
        int bPixelTemp = temperatureArray[width][height + 1];
        int bRPixelTemp = temperatureArray[width + 1][height + 1];

        return (int) (((currentPixelTemp + bRPixelTemp + bPixelTemp + bLPixelTemp) * 0.25));
    }


    /**
     * This method populates the lowest possible height with random sparks.
     *
     * @param chance Defines the chance of generating a spark (1-100). 1 = Never, 100 = Always
     */
    private void setSparks(int chance) {
        for (int i = 0; i < sparkablePixels.length; i++) {
            for (int j = 0; j < sparkablePixels[0].length; j++) {
                if (sparkablePixels[i][j] == 1) {
                    if (chance / (Math.random() * 100) > 1) {
                        temperatureArray[i][j] = 255;

                    }
                }
            }
        }
    }

    /**
     *
     */
    private void setCoolSpots(int height, int chance) {
        for (int y = dimY - 1; y > dimY - height; y--) {
            for (int x = 0; x < dimX - 1; x++) {
                if (chance / (Math.random() * 100) > 1) {
                    temperatureArray[x][y] = (int) (temperatureArray[x][y] * 0.85);
                }
            }
        }
    }


    @Override
    public void run() {
        while (true) {
            while (running) {
                modifyArrays();
                setRGBFromArray();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

