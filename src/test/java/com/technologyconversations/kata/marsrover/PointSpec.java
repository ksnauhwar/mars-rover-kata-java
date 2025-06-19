package com.technologyconversations.kata.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/*
Point is a two-dimensional point on the grid.
New instance is created with initial location and maximum location that can be reached on that axis.
Methods forward/backward increase/decrease location.
If maximum location is reached, forward/backward methods wrap location.
*/
public class PointSpec {

    @Test
    public void newInstanceShouldSetLocationAndMaxLocationParams() {
        Point point = new Point(5, 9);
        assertThat(point.getLocation()).isEqualTo(5);
        assertThat(point.getMaxLocation()).isEqualTo(9);
    }

    @Test
    public void getForwardLocationShouldIncreasePointValueByOne() {
        Point point = new Point(5, 9);
        assertThat(point.getForwardLocation()).isEqualTo(6);
    }

    @Test
    public void getBackwardLocationShouldDecreasePointValueByOne() {
        Point point = new Point(5, 9);

        assertThat(point.getBackwardLocation()).isEqualTo(4);
    }

    @Test
    public void getForwardLocationShouldSetValueToZeroIfMaxLocationIsPassed() {
        Point point = new Point(5, 9);

        point.setLocation(point.getMaxLocation());
        assertThat(point.getForwardLocation()).isZero();
    }

    @Test
    public void getBackwardLocationShouldSetValueToMaxLocationIfZeroLocationIsPassed() {
        Point point = new Point(5, 9);
        point.setLocation(0);
        assertThat(point.getBackwardLocation()).isEqualTo(9);
    }

}