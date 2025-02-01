package overblocks.content;

import arc.graphics.*;
import arc.math.*;
import mindustry.content.*;
import mindustry.type.*;
import overblocks.graphics.*;
import overblocks.type.*;

public class OBStatusEffects {

    public static StatusEffect redRust;

    public static void load(){
        redRust = new OBStatusEffect("red-rust"){{
            color = OBPal.redRust;
            hideDetails = false;
            damagePercentage = 0.06f;
            healthMultiplier = 0.85f;
            reloadMultiplier = 0.85f;
            speedMultiplier = 0.75f;
            effect = OBFx.redRusting;
            transitionDamage = 8f;
        }};
    }
}
