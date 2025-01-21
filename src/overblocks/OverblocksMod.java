package overblocks;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.meta.*;
import overblocks.content.*;
import overblocks.gen.*;

@SuppressWarnings("unused")
public class OverblocksMod extends Mod{

    public OverblocksMod(){
        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                assignColor(OBBlocks.hotCarbonStone, Color.valueOf("5f433d"));
                assignColor(OBBlocks.magmaCarbonStone, Color.valueOf("855443"));
                assignColor(OBBlocks.shallowSlag, Color.valueOf("cc5035"));
                assignColor(OBBlocks.ceriseStoneWall, Color.valueOf("DB959F"));
            });
        });

    }
    @Override
    public void loadContent(){
        EntityRegistry.register();
        OBStatusEffects.load();
        OBItems.load();
        OBUnitTypes.load();
        OBBlocks.load();
        loadOther();
    }

    public void loadOther(){
        Blocks.sporeMoss.asFloor().blendGroup = Blocks.moss;
    }

    public void assignColor(Block block, Color color){
        if(block != null && color != null){
            block.mapColor = color;
        }
    }
}
