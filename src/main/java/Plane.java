public class Plane {


    private int capacity;
    private int totalWeight;
    private PlaneTypes plane;

    public Plane(PlaneTypes planeType) {
        this.plane = planeType;
        this.totalWeight = planeType.getTotalWeight();
        this.capacity = planeType.getCapacity();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public PlaneTypes getPlane() {
        return plane;
    }
}
