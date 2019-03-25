public enum PlaneTypes {

    BOEING747(2, 100),
    BOEING767(4, 200),
    BOEING777(6, 300),
    BOEING787(4, 200),
    AIRBUSA330(10, 500);

    private final int capacity;
    private final int totalWeight;

    PlaneTypes(int capacity, int totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}
