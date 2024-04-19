package overblocks.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.type.*;

public class OBItems {
    public static Item rosingAlloy;

    public static void load(){
        rosingAlloy = new Item("rosing-alloy", Color.valueOf("AF6356")){{
            cost = 1.2f;
        }};
    }
}
