package overblocks.content;

import ent.anno.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.gen.MechUnit;
import mindustry.type.*;
import overblocks.gen.*;
import overblocks.type.*;

import static ent.anno.Annotations.EntityDef;

public class OBUnitTypes {

    public static @EntityDef({Unitc.class, Mechc.class, Dodgec.class}) UnitType relayer;

    public static void load(){
    }
}
