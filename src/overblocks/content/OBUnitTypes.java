package overblocks.content;

import arc.graphics.*;
import ent.anno.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.gen.MechUnit;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import overblocks.gen.*;
import overblocks.type.*;

import static ent.anno.Annotations.EntityDef;

public class OBUnitTypes{
    //vanilla entities units

    //dodger unit
    public static @EntityDef({Unitc.class, Mechc.class, Dodgec.class}) UnitType relayer;

    //mr. boomerang unit?

    //radial damage unit?

    //steam-based unit?

    public static void load(){

        relayer = new OBUnitType("relayer", DodgeMechUnit.class){{
            dodge = 0.75f;
            speed = 0.5f;
            hitSize = 8f;
            health = 100;
            ammoType = new PowerAmmoType(1000);

            weapons.add(new Weapon("overblocks-relayer-weapon"){{
                top = false;
                shootY = 2f;
                reload = 36f;
                x = 4.5f;
                alternate = false;
                ejectEffect = Fx.none;
                recoil = 2f;
                shootSound = Sounds.lasershoot;

                bullet = new LaserBoltBulletType(2.5f, 12){{
                    smokeEffect = Fx.hitLaser;
                    hitEffect = Fx.hitLaser;
                    despawnEffect = Fx.hitLaser;

                    lifetime = 90f;
                    backColor = lightColor = Pal.lancerLaser;
                    frontColor = Color.white;
                }};
            }});
        }};
    }
}
