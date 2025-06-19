package com.technologyconversations.kata.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CoordinatesSpec {

    @Test
    public void newInstanceShouldSetXLocation() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        assertThat(coordinates.getX().getLocation()).isEqualTo(1);
    }

    @Test
    public void newInstanceShouldSetXMaxLocation() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        assertThat(coordinates.getX().getMaxLocation()).isEqualTo(99);
    }

    @Test
    public void newInstanceShouldSetYLocation() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        assertThat(coordinates.getY().getLocation()).isEqualTo(2);
    }

    @Test
    public void newInstanceShouldSetYMaxLocation() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        assertThat(coordinates.getY().getMaxLocation()).isEqualTo(99);
    }

    @Test
    public void newInstanceShouldSetDirection() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        assertThat(coordinates.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void newInstanceShouldSetObstacles() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        assertThat(coordinates.getObstacles()).hasSameElementsAs(obstacles);
    }

    @Test
    public void moveForwardShouldIncreaseYWhenDirectionIsNorth() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        coordinates.setDirection(Direction.NORTH);
        coordinates.moveForward();
        assertThat(coordinates.getY().getLocation()).isEqualTo(3);
    }

    @Test
    public void moveForwardShouldIncreaseXWhenDirectionIsEast() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        coordinates.setDirection(Direction.EAST);
        coordinates.moveForward();
        assertThat(coordinates.getX().getLocation()).isEqualTo(2);
    }

    @Test
    public void moveForwardShouldDecreaseYWhenDirectionIsSouth() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        coordinates.setDirection(Direction.SOUTH);
        coordinates.moveForward();
        assertThat(coordinates.getY().getLocation()).isEqualTo(1);
    }

    @Test
    public void moveForwardShouldDecreaseXWhenDirectionIsWest() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        coordinates.setDirection(Direction.WEST);
        coordinates.moveForward();
        assertThat(coordinates.getX().getLocation()).isEqualTo(0);
    }

    @Test
    public void moveForwardShouldNotChangeLocationsWhenObstacleIsFound() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        int expected = x.getLocation();
        coordinates.setDirection(Direction.EAST);
        coordinates.setObstacles(Arrays.asList(new Obstacle(x.getLocation() + 1, y.getLocation())));
        coordinates.move(coordinates.getDirection());
        assertThat(coordinates.getX().getLocation()).isEqualTo(expected);
    }

    @Test
    public void moveBackwardShouldDecreaseYWhenDirectionIsNorth() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        coordinates.setDirection(Direction.NORTH);
        coordinates.moveBackward();
        assertThat(coordinates.getY().getLocation()).isEqualTo(1);
    }

    @Test
    public void moveBackwardShouldDecreaseXWhenDirectionIsEast() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        Point expected = new Point(x.getLocation() - 1, x.getMaxLocation());
        coordinates.setDirection(Direction.EAST);
        coordinates.moveBackward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveBackwardShouldIncreaseYWhenDirectionIsSouth() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        Point expected = new Point(y.getLocation() + 1, y.getMaxLocation());
        coordinates.setDirection(Direction.SOUTH);
        coordinates.moveBackward();
        assertThat(coordinates.getY().getLocation()).isEqualTo(3);
    }

    @Test
    public void moveBackwardShouldIncreaseXWhenDirectionIsWest() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        Point expected = new Point(x.getLocation() + 1, x.getMaxLocation());
        coordinates.setDirection(Direction.WEST);
        coordinates.moveBackward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void toStringShouldReturnXAndY() {
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        final Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);
        String expected = x.getLocation() + " X " + y.getLocation() + " " + direction.getShortName();
        assertThat(coordinates.toString()).isEqualTo("1 X 2 N");
    }

}