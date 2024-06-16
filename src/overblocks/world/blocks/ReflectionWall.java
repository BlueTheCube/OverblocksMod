package overblocks.world.blocks;

import arc.math.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.world.blocks.defense.*;

public class ReflectionWall extends Wall {
    public float damageMultiplier = 1f;
    public float damageChance = 0.9f;
    public ReflectionWall(String name) {
        super(name);
    }

    @Override
    public void setStats(){
        //TODO stats?
        super.setStats();
    }

    public class ReflectionWallBuild extends WallBuild {
        @Override
        public boolean collision(Bullet bullet) {
            if(damageChance > 0){
                if(!Mathf.chance(damageChance / bullet.damage())) return super.collision(bullet);
                if(super.collision(bullet) && damageMultiplier > 0f && bullet.owner instanceof Healthc) {
                    if(bullet.owner() instanceof Unitc uc) {
                        uc.damage(bullet.damage * damageMultiplier);
                    }
                }
            }
            return super.collision(bullet);
        }
    }
}
