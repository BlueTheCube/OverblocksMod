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
                OBBlocks.hotCarbonStone.asFloor().mapColor = Color.valueOf("5f433d");
                OBBlocks.magmaCarbonStone.asFloor().mapColor = Color.valueOf("855443");
                OBBlocks.shallowSlag.asFloor().mapColor = Color.valueOf("cc5035");
                OBBlocks.ceriseStoneWall.mapColor = Color.valueOf("DB959F");
            });
        });

    }
    @Override
    public void loadContent(){
        EntityRegistry.register();
        OBStatusEffects.load();
        OBItems.load();
        OBBlocks.load();
        loadOther();
    }

    public void loadOther(){
        Blocks.sporeMoss.asFloor().blendGroup = Blocks.moss;
    }
}
