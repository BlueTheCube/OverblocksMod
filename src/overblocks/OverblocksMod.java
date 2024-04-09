package overblocks;

import arc.*;
import mindustry.content.*;
import mindustry.mod.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;
import overblocks.content.*;
import overblocks.gen.*;

public class OverblocksMod extends Mod{

    public OverblocksMod(){
    }
    @Override
    public void loadContent(){
        EntityRegistry.register();
        OBBlocks.load();
    }
}
