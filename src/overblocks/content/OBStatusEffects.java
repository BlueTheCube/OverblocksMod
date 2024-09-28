package overblocks.content;

import arc.graphics.*;
import arc.math.*;
import mindustry.content.*;
import mindustry.type.*;

public class OBStatusEffects {
    public static StatusEffect unluckyBurn;
    public static void load(){
        unluckyBurn = new StatusEffect("unlucky-burn"){{
            color = Color.valueOf("8f85ff");
            hideDetails = false;
            damage = 0.21f;
            damageMultiplier = 0.9f;
            effect = OBFx.unluckyBurn;
            transitionDamage = 8f;

            init(() -> {
                affinity(StatusEffects.tarred, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                    OBFx.unluckyBurn.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                    result.set(unluckyBurn, Math.min(time + result.time, 300f));
                });
                affinity(StatusEffects.wet, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                    OBFx.unluckyBurn.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                    result.set(unluckyBurn, Math.min(time + result.time, 300f));
                });
            });
        }};
    }
}
