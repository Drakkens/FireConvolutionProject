package Classes.Model.ColorUtility;

import java.awt.*;

public record TargetColor(int temperature, Color color) {

    @Override
    public String toString() {
        return "Temp:" + this.temperature + " Red: " + this.color.getRed() + " Green: " + this.color.getGreen() + " Blue: " + this.color.getBlue();
    }
}