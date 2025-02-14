package overblocks.entities;

import arc.math.*;
import arc.util.*;
import ent.anno.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.type.*;
import overblocks.type.*;

import static ent.anno.Annotations.*;

@EntityComponent
abstract class DodgeComp implements Shieldc{
    @Import float armor, healthMultiplier, hitTime;
    @Import static float hitDuration;
    @Import UnitType type;

    float damageDodge(float amount){
        return type instanceof OBUnitType ob && Mathf.chance(ob.dodge) ? 0 : amount;
    }

    @Override
    @Replace(100)
    public void damage(float amount){
        rawDamage(damageDodge(Damage.applyArmor(amount, armor) / healthMultiplier / Vars.state.rules.unitHealthMultiplier));
    }

    @Override
    @Replace(100)
    public void damagePierce(float amount, boolean withEffect){
        float pre = hitTime;

        rawDamage(damageDodge(amount / healthMultiplier / Vars.state.rules.unitHealthMultiplier));

        if(!withEffect){
            hitTime = pre;
        }
    }

    @Override
    @Replace(100)
    public void damageContinuous(float amount){
        damage(damageDodge(amount) * Time.delta, hitTime <= -10 + hitDuration);
    }

    @Override
    @Replace(100)
    public void damageContinuousPierce(float amount) {
        damagePierce(damageDodge(amount) * Time.delta, hitTime <= -10 + hitDuration);
    }
}
