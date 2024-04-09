package overblocks;

import mindustry.content.*;
import mindustry.mod.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import overblocks.content.*;
import overblocks.gen.*;

public class OverblocksMod extends Mod{
    Block cb = Blocks.carbonStone;
    public OverblocksMod(){
        cb.attributes.set(Attribute.water, 0f);
    }
    @Override
    public void loadContent(){
        EntityRegistry.register();
        OBBlocks.load();
    }
}
