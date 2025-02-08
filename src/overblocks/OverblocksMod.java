package overblocks;

import arc.*;
import arc.graphics.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.meta.*;
import overblocks.content.*;
import overblocks.gen.*;
import overblocks.graphics.*;

@SuppressWarnings("unused")
public class OverblocksMod extends Mod{

    public OverblocksMod(){
        Events.on(ClientLoadEvent.class, e -> Time.runTask(10f, () -> {
            assignColor(OBBlocks.hotCarbonStone, Color.valueOf("5f433d"));
            assignColor(OBBlocks.magmaCarbonStone, Color.valueOf("855443"));
            assignColor(OBBlocks.shallowSlag, Color.valueOf("cc5035"));
            assignColor(OBBlocks.ceriseStoneWall, Color.valueOf("DB959F"));
        }));

    }
    @Override
    public void loadContent(){
        EntityRegistry.register();
        OBStatusEffects.load();
        OBItems.load();
        OBUnitTypes.load();
        OBBlocks.load();
        OBTechTree.load();
        loadOther();
    }

    public void loadOther(){
        Blocks.sporeMoss.asFloor().blendGroup = Blocks.moss;
        Blocks.crystallineStoneWall.attributes.set(Attribute.sand, 0.7f);
        Blocks.arkyicWall.attributes.set(Attribute.sand, 1.1f);
        Blocks.redStone.asFloor().attributes.set(Attribute.water, -0.1f);
        Blocks.denseRedStone.asFloor().attributes.set(Attribute.water, -0.1f);
        Blocks.carbonStone.asFloor().attributes.set(Attribute.water, -0.1f);

        BulletType diseaseSpectreBullet = new BasicBulletType(7f, 60){{
            hitSize = 5;
            width = 15f;
            height = 21f;
            frontColor = OBPal.dreadRust;
            backColor = OBPal.darkDreadRust;
            status = OBStatusEffects.dreadRust;
            shootEffect = Fx.shootBig;
            statusDuration = 60;
            pierceCap = 2;
            pierceBuilding = true;
            knockback = 0.6f;
            ammoMultiplier = 3;
        }};

        BulletType diseaseFuseBullet = new ShrapnelBulletType(){{
            length = 100;
            damage = 70f;
            ammoMultiplier = 4f;
            width = 17f;
            toColor = OBPal.dreadRust;
            shootEffect = smokeEffect = OBFx.dreadShoot;
            status = OBStatusEffects.dreadRust;
            statusDuration = 60;
        }};

        ItemTurret spectre = (ItemTurret) Blocks.spectre;
        spectre.ammoTypes.put(OBItems.diseaseVector, diseaseSpectreBullet);

        ItemTurret fuse = (ItemTurret) Blocks.fuse;
        fuse.ammoTypes.put(OBItems.diseaseVector, diseaseFuseBullet);
    }

    public void assignColor(Block block, Color color){
        if(block != null && color != null){
            block.mapColor = color;
        }
    }
}
