package renderer.light;

import java.awt.Color;

public class Luminance {
    public static Color illuminate(Color color, double intensity) {
        int[] luminance = new int[3];
        luminance[0] = (int)(Math.round(Math.pow(intensity, 50) * color.getRed()));
        luminance[1] = (int)(Math.round(Math.pow(intensity, 50) * color.getGreen()));
        luminance[2] = (int)(Math.round(Math.pow(intensity, 50) * color.getBlue()));
        return new Color(luminance[0], luminance[1], luminance[2]);
    }

    public static double intensity(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        if (r == g && r == b) return r;   // to avoid floating-point issues
        return 0.299*r + 0.587*g + 0.114*b;
    }
}
