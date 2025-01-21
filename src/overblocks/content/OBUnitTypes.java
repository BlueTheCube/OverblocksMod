package overblocks.content;

import ent.anno.*;
import mindustry.gen.*;
import mindustry.type.*;
import overblocks.type.*;

import static ent.anno.Annotations.EntityDef;

public class OBUnitTypes {

    public static @EntityDef({Unitc.class, Mechc.class}) UnitType relayer;

    public static void load(){
    }
}
