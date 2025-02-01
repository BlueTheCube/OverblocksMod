package overblocks.type;

import arc.graphics.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import overblocks.graphics.*;
import overblocks.world.meta.*;

public class OBStatusEffect extends StatusEffect {
    public Color outlineColor = Pal.gray;
    public int outlineThickness = 3;
    public float damagePercentage;
    public OBStatusEffect(String name) {
        super(name);
    }

    @Override
    public void setStats(){
        if(damagePercentage > 0) stats.addPercent(OBStats.damagePercent, damagePercentage * 100);
    }

    @Override
    public void update(Unit unit, float time){
        if (damagePercentage > 0) {
            unit.damageContinuousPierce(damagePercentage * unit.maxHealth());
        }
    }

    @Override
    public void createIcons(MultiPacker packer) {
        Outliner.outlineRegion(packer, fullIcon, outlineColor, name, outlineThickness);

        super.createIcons(packer);
    }
}
