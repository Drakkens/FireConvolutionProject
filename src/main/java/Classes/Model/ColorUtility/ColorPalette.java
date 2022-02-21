/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Model.ColorUtility;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ColorPalette {
    //Map Temperature Array with Colors
    private final HashMap<Integer, Integer> tempMap = new HashMap<>();
    private ArrayList<TargetColor> targetColorArrayList;

    public HashMap<Integer, Integer> getTempMap() {
        return tempMap;
    }

    public ColorPalette(ArrayList<TargetColor> targetColorArrayList) {
        this.targetColorArrayList = targetColorArrayList;
        for (int i = 0; i < targetColorArrayList.size() - 1; i++) {
            TargetColor currentColor = targetColorArrayList.get(i);
            TargetColor nextColor = targetColorArrayList.get(i+1);

            for (int j = currentColor.temperature(); j >= nextColor.temperature(); j--) {
                tempMap.put(j, createColorFromInterpolation(currentColor.color(), nextColor.color(), currentColor.temperature() - nextColor.temperature(), currentColor.temperature() - j));

            }
        }
    }

    private int createColorFromInterpolation(Color startColor, Color endColor, int totalIterations, int currentIteration) {
        int redDif = (Math.abs(endColor.getRed() - startColor.getRed()) / totalIterations) * currentIteration;
        int greenDif = (Math.abs(endColor.getGreen() - startColor.getGreen()) / totalIterations) * currentIteration;
        int blueDif = (Math.abs(endColor.getBlue() - startColor.getBlue()) / totalIterations) * currentIteration;
        int alphaDif = (Math.abs(endColor.getAlpha() - startColor.getAlpha()) / totalIterations) * currentIteration;
        return createColor(startColor.getRed() - redDif, startColor.getGreen() - greenDif, startColor.getBlue() - blueDif, startColor.getAlpha() - alphaDif);

    }

    private int createColor(int red, int green, int blue, int alpha) {
        return alpha << 24 | red << 16 | green << 8 | blue;

    }

//    public ArrayList<TargetColor> getTargetColorArrayList() {
//        return this.targetColorArrayList;
//    }
}
