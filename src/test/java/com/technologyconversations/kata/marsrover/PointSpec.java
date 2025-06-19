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

    private final int location = 5;
    private final int maxLocation = 9;


    @Test
    public void newInstanceShouldSetLocationAndMaxLocationParams() {
        Point point = new Point(5, 9);
        assertThat(point.getLocation()).isEqualTo(location);
        assertThat(point.getMaxLocation()).isEqualTo(maxLocation);
    }

    @Test
    public void getForwardLocationShouldIncreasePointValueByOne() {
        Point point = new Point(5, 9);

        int expected = point.getLocation() + 1;
        assertThat(point.getForwardLocation()).isEqualTo(expected);
    }

    @Test
    public void getBackwardLocationShouldDecreasePointValueByOne() {
        Point point = new Point(5, 9);

        int expected = point.getLocation() - 1;
        assertThat(point.getBackwardLocation()).isEqualTo(expected);
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
        assertThat(point.getBackwardLocation()).isEqualTo(point.getMaxLocation());
    }

}