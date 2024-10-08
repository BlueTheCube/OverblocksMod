package overblocks.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import mindustry.entities.*;
import mindustry.graphics.*;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;

public class OBFx {
    public static final Rand rand = new Rand();
    public static final Vec2 temp = new Vec2();
    public static Effect
    orangeLaserCharge = new Effect(80f, e -> {
        color(Color.valueOf("ec7458aa"));
        stroke(e.fin() * 2f);
        Lines.circle(e.x, e.y, 4f + e.fout() * 100f);

        Fill.circle(e.x, e.y, e.fin() * 20);

        randLenVectors(e.id, 20, 40f * e.fout(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fin() * 5f);
            Drawf.light(e.x + x, e.y + y, e.fin() * 15f, Color.valueOf("ec7458aa"), 0.7f);
        });

        color();

        Fill.circle(e.x, e.y, e.fin() * 10);
        Drawf.light(e.x, e.y, e.fin() * 20f, Color.valueOf("ec7458aa"), 0.7f);
    }).followParent(true).rotWithParent(true),

    unluckyBurn = new Effect(35f, e -> {
        color(Color.valueOf("8f85ff"), Color.valueOf("210794"), e.fin());

        randLenVectors(e.id, 3, 2f + e.fin() * 7f, (x, y) -> {
            Fill.circle(e.x + x, e.y + y, 0.1f + e.fout() * 1.4f);
        });
    });
}
