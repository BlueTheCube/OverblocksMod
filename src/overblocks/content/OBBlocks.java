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
import overblocks.world.blocks.*;

import static mindustry.type.ItemStack.*;

public class OBBlocks {
    public static Block hotCarbonStone, magmaCarbonStone, graphiticFloor, shallowSlag, carbonPebbles, plastaniumCrusher, directDeflectWall;

    public static void load(){
        hotCarbonStone = new Floor("hotcarbon-stone"){{
            hasColor = true;
            mapColor = Color.valueOf("5f433d");
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

        magmaCarbonStone = new Floor("magmacarbon-stone"){{
            hasColor = true;
            mapColor = Color.valueOf("855443");
            attributes.set(Attribute.heat, 0.75f);
            attributes.set(Attribute.water, -0.75f);
            wall = Blocks.carbonWall;
            blendGroup = Blocks.carbonStone;
            decoration = Blocks.carbonBoulder;
            variants = 3;
            emitLight = true;
            lightRadius = 50f;
            lightColor = Color.orange.cpy().a(0.3f);
        }};

        graphiticFloor = new Floor("graphitic-floor"){{
            mapColor = Color.valueOf("444c67");
            itemDrop = Items.graphite;
            playerUnmineable = true;
            attributes.set(Attribute.water, -0.1f);
            wall = Blocks.carbonWall;
            blendGroup = Blocks.carbonStone;
            decoration = Blocks.carbonBoulder;
            variants = 3;
        }};
        Blocks.carbonStone.asFloor().attributes.set(Attribute.water, -0.1f);

        shallowSlag = new Floor("shallow-slag"){{
            hasColor = true;
            mapColor = Color.valueOf("cc5035");
            status = StatusEffects.melting;
            statusDuration = 240f;
            speedMultiplier = 0.19f;
            variants = 0;
            liquidDrop = Liquids.slag;
            isLiquid = true;
            cacheLayer = CacheLayer.slag;
            liquidMultiplier = 0.5f;
            attributes.set(Attribute.heat, 0.8f);

            emitLight = true;
            lightRadius = 30f;
            lightColor = Color.orange.cpy().a(0.38f);
        }};

        carbonPebbles = new OverlayFloor("carbon-pebbles");

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

        directDeflectWall = new ReflectionWall("direct-deflect-wall"){{
            requirements(Category.defense, ItemStack.with(Items.phaseFabric, 24, Items.plastanium, 16, Items.metaglass, 8));
            health = 200 * 4 * 4;
            size = 2;
            insulated = true;
            absorbLasers = true;
            envDisabled |= Env.scorching;
        }};
    }
}
