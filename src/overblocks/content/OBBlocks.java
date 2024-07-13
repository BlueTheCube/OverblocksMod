package overblocks.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import overblocks.world.blocks.*;

import static mindustry.type.ItemStack.*;

public class OBBlocks {
    public static Block
            //enviroment
            hotCarbonStone, magmaCarbonStone, graphiticFloor, ceriseStone, shallowSlag, carbonPebbles, beryllicVent, ceriseVent, ceriseStoneWall, ceriseBoulder,
            //other
            plastaniumCrusher, plastaniumDeflectWall, devastation;

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
        ceriseStone = new Floor("cerise-stone");
        Blocks.redStone.asFloor().attributes.set(Attribute.water, -0.1f);
        Blocks.denseRedStone.asFloor().attributes.set(Attribute.water, -0.1f);
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

        beryllicVent = new SteamVent("beryllic-vent"){{
            parent = blendGroup = Blocks.beryllicStone;
            attributes.set(Attribute.steam, 1f);
        }};

        ceriseVent = new SteamVent("cerise-vent"){{
            parent = blendGroup = ceriseStone;
            attributes.set(Attribute.steam, 1f);
        }};

        ceriseStoneWall = new StaticWall("cerise-stone-wall"){{
            ceriseStone.asFloor().wall = this;
            attributes.set(Attribute.sand, 1.1f);
        }};
        Blocks.crystallineStoneWall.attributes.set(Attribute.sand, 0.7f);
        Blocks.arkyicWall.attributes.set(Attribute.sand, 1.1f);

        ceriseBoulder = new Prop("cerise-boulder"){{
            variants = 2;
            ceriseStone.asFloor().decoration = this;
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

        plastaniumDeflectWall = new ReflectionWall("plastanium-deflect-wall"){{
            requirements(Category.defense, ItemStack.with(Items.phaseFabric, 24, Items.plastanium, 16, Items.metaglass, 8));
            health = 200 * 4 * 4;
            size = 2;
            insulated = true;
            absorbLasers = true;
            envDisabled |= Env.scorching;
        }};

        devastation = new PowerTurret("devastation"){{
            requirements(Category.turret, with(Items.titanium, 750, Items.lead, 350, Items.metaglass, 250, Items.surgeAlloy, 325, Items.silicon, 275));
            range = 360f;
            shootSound = Sounds.laserblast;
            chargeSound = Sounds.lasercharge;
            shoot.firstShotDelay = OBFx.orangeLaserCharge.lifetime;
            recoil = 3.5f;
            size = 4;
            reload = 300f;
            shake = 2f;
            moveWhileCharging = false;
            smokeEffect = Fx.none;
            shootType = new LaserBulletType(450){{
                length = 360f;
                width = 45f;

                lifetime = 65f;

                largeHit = true;
                hitSize = 4;
                chargeEffect = OBFx.orangeLaserCharge;

                sideAngle = 15f;
                sideWidth = 0f;
                sideLength = 0f;
                colors = new Color[]{Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                incendChance = 0.7f;
                incendSpread = 5f;
                incendAmount = 1;
                pierceArmor = true;
                status = StatusEffects.burning;
            }};
            scaledHealth = 200;
            coolant = consumeCoolant(0.5f);
            consumePower(13f);
        }};
    }
}
