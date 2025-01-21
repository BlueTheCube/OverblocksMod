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
        relayer = new OBUnitType("relayer", DodgeMechUnit.class){{
            speed = 0.5f;
            hitSize = 8f;
            health = 150;
            weapons.add(new Weapon("large-weapon"){{
                reload = 13f;
                x = 4f;
                y = 2f;
                top = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2.5f, 9){{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                }};
            }});
        }};
    }
}
