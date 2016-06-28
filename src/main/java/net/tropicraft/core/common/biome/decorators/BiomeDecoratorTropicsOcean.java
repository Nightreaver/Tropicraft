package net.tropicraft.core.common.biome.decorators;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.tropicraft.core.common.worldgen.WorldGenCoral;

public class BiomeDecoratorTropicsOcean extends BiomeDecoratorTropicraft {

	public BiomeDecoratorTropicsOcean() {
		
	}
	
    public void decorate(World worldIn, Random random, Biome biome, BlockPos pos)
    {
        if (this.decorating)
        {
            throw new RuntimeException("Already decorating");
        }
        else
        {
            this.chunkProviderSettings = ChunkProviderSettings.Factory.jsonToFactory(worldIn.getWorldInfo().getGeneratorOptions()).build();
            this.chunkPos = pos;
            this.genDecorations(biome, worldIn, random);
            this.decorating = false;
        }
    }
    
    public void genDecorations(Biome biome, World world, Random rand) {
		if(rand.nextInt(5) == 0) {
            int j = rand.nextInt(16) + 8;
            int k = rand.nextInt(16) + 8;
            BlockPos pos = chunkPos.add(j, 0, k);
			new WorldGenCoral().generate(world, rand, pos);
		}
    }

}