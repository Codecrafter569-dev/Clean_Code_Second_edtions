abstract class Feature {
    double score(Building building) {
        double value = 0;
        for (Floor floor : building.floors) {
            for (Space space : floor.spaces) {
                value = scoreSpace(value, floor, space);
            }
        }
        return value;
    }
    abstract double scoreSpace(double value, Floor floor, Space space);
}

class SpaceFeature extends Feature {
    double scoreSpace(double value, Floor floor, Space space) {
        return value + 1;
    }
}

class AreaFeature extends Feature {
    double scoreSpace(double value, Floor floor, Space space) {
        return value + (space.width * space.length);
    }
}

public class GoodDuplicateclearnence_1{
    public static void main(String[] args) {
        Building building = new Building();
        Floor floor = new Floor();
        floor.spaces.add(new Space(10, 20));
        floor.spaces.add(new Space(5, 5));
        building.floors.add(floor);

        Feature spaceFeature = new SpaceFeature();
        Feature areaFeature = new AreaFeature();

        System.out.println("Total Spaces: " + spaceFeature.score(building));
        System.out.println("Total Area: " + areaFeature.score(building));
    }
}
