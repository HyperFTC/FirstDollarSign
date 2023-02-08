package net.hypernite.projects.pathfinder.entity;

import net.hypernite.projects.pathfinder.coordinates.*;
import net.hypernite.projects.pathfinder.interfaces.*;

public class StaticHitBox
    extends HitBox<StaticCoordinate>
    implements IGetter<StaticCoordinate>
{
    private final StaticCoordinate center;
    public <C extends Coordinate> StaticHitBox(int length, int width, C center) {
        super(length, width, center);
        this.center = new StaticCoordinate(center);
    }

    @Override
    public StaticCoordinate get() { return this.center; }
}
