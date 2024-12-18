package overblocks.type;

import arc.graphics.*;
import mindustry.graphics.*;
import mindustry.type.*;
import overblocks.graphics.*;

public class OBStatusEffect extends StatusEffect {
    public Color outlineColor = Pal.darkerMetal;
    public int outlineThickness = 3;
    public OBStatusEffect(String name) {
        super(name);
    }

    @Override
    public void createIcons(MultiPacker packer) {
        Outliner.outlineRegion(packer, fullIcon, outlineColor, name, outlineThickness);

        super.createIcons(packer);
    }
}
