package me.felek.fenixutilities.Utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerUtils {

    public static List<Integer> RandomTeleportationPlayer(Player player, World world, int minX, int maxX, int minZ, int maxZ) {
        int x = MathUtils.random(minX, maxX);
        int z = MathUtils.random(minZ, maxZ);
        int y = world.getHighestBlockYAt(x, z) + 1;
        Location currentLocation = new Location(world, x, y, z);
        player.teleport(currentLocation);
        ArrayList<Integer> cords = new ArrayList<Integer>();
        cords.add(x);
        cords.add(y);
        cords.add(z);
        return cords;
    }
}
