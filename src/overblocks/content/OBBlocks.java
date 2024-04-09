package overblocks.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;

public class OBBlocks {
    public static Block hotCarbonStone;

    public static void load(){
        hotCarbonStone = new Floor("hotcarbon-stone"){{
            attributes.set(Attribute.heat, 0.5f);
            attributes.set(Attribute.water, -0.5f);
            wall = Blocks.carbonWall;
            blendGroup = Blocks.carbonStone;
            decoration = Blocks.carbonBoulder;
            variants = 3;
            emitLight = true;
            lightRadius = 30f;
            lightColor = Color.orange.cpy().a(0.15f);
        }};
        Blocks.carbonStone.asFloor().attributes.set(Attribute.water, 0f);
    }
}
