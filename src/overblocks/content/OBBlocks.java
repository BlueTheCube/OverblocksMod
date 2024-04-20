package overblocks.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.*;

public class OBBlocks {
    public static Block hotCarbonStone, shallowSlag, plastaniumCrusher;

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

        shallowSlag = new Floor("shallow-slag"){{
            status = StatusEffects.melting;
            statusDuration = 240f;
            speedMultiplier = 0.19f;
            variants = 0;
            liquidDrop = Liquids.slag;
            isLiquid = true;
            cacheLayer = CacheLayer.slag;
            attributes.set(Attribute.heat, 0.8f);

            emitLight = true;
            lightRadius = 30f;
            lightColor = Color.orange.cpy().a(0.38f);
        }};

        plastaniumCrusher = new GenericCrafter("plastanium-crusher"){{
            requirements(Category.crafting, with(Items.silicon, 120, Items.metaglass, 150, Items.graphite, 100, Items.titanium, 100, Items.plastanium, 30));
            hasItems = true;
            liquidCapacity = 60f;
            craftTime = 60f * 1.5f;
            outputItem = new ItemStack(Items.plastanium, 4);
            size = 3;
            health = 400;
            hasPower = hasLiquids = true;
            craftEffect = Fx.formsmoke;
            updateEffect = Fx.plasticburn;
            drawer = new DrawMulti(new DrawDefault(), new DrawFade());

            consumeLiquid(Liquids.oil, 0.5f);
            consumePower(4f);
            consumeItem(Items.titanium, 6);
            consumeItem(Items.coal, 2);
        }};
    }
}
