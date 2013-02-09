package com.khorn.terraincontrol.bukkit.structuregens;

import com.khorn.terraincontrol.LocalWorld;
import com.khorn.terraincontrol.bukkit.util.WorldHelper;
import net.minecraft.server.StructureGenerator;
import net.minecraft.server.StructureStart;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenMineshaftStart;

import java.util.Random;

public class MineshaftGen extends StructureGenerator
{
    // canSpawnStructureAtCoords
    protected boolean a(int chunkX, int chunkZ)
    {
        Random rand = b;
        World worldMC = c;
        if (rand.nextInt(80) < Math.max(Math.abs(chunkX), Math.abs(chunkZ)))
        {
            LocalWorld world = WorldHelper.toLocalWorld(worldMC);
            int biomeId = world.getCalculatedBiomeId(chunkX * 16 + 8, chunkZ * 16 + 8);
            if (rand.nextDouble() * 100.0 < world.getSettings().biomeConfigs[biomeId].mineshaftsRarity)
            {
                return true;
            }
        }

        return false;
    }

    protected StructureStart b(int i, int j)
    {
        return new WorldGenMineshaftStart(this.c, this.b, i, j);
    }
}
