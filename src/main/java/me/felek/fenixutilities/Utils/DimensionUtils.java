package me.felek.fenixutilities.Utils;

import org.bukkit.World;
import org.bukkit.World.Environment;
import java.util.HashMap;

public class DimensionUtils {
    private static final HashMap<Environment, Integer> DIMENSION_MAP = new HashMap<>();

    static {
        DIMENSION_MAP.put(Environment.NORMAL, 0);    // Overworld
        DIMENSION_MAP.put(Environment.NETHER, 1);   // Nether
        DIMENSION_MAP.put(Environment.THE_END, 2);   // End
    }

    public static int getDimensionNumber(World world) {
        return DIMENSION_MAP.getOrDefault(world.getEnvironment(), 0);
    }
}