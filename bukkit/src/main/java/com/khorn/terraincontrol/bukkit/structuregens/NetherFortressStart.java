package com.khorn.terraincontrol.bukkit.structuregens;

import net.minecraft.server.StructurePiece;
import net.minecraft.server.StructureStart;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenNetherPiece15;

import java.util.ArrayList;
import java.util.Random;

class NetherFortressStart extends StructureStart
{

    @SuppressWarnings({"unchecked", "rawtypes"})
    public NetherFortressStart(World world, Random random, int i, int j)
    {
        WorldGenNetherPiece15 worldgennetherpiece15 = new WorldGenNetherPiece15(random, (i << 4) + 2, (j << 4) + 2);

        this.a.add(worldgennetherpiece15);
        worldgennetherpiece15.a(worldgennetherpiece15, this.a, random);
        ArrayList arraylist = worldgennetherpiece15.d;

        while (!arraylist.isEmpty())
        {
            int k = random.nextInt(arraylist.size());
            StructurePiece structurepiece = (StructurePiece) arraylist.remove(k);

            structurepiece.a(worldgennetherpiece15, this.a, random);
        }

        this.c();
        this.a(world, random, 48, 70);
    }
}
