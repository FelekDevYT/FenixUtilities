package me.felek.fenixutilities.Utils;

public class MathUtils {
    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
