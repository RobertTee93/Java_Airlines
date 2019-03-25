public enum Airports {

    GLA("Glasgow"),
    EDI("Edinburgh"),
    MAH("Mahon"),
    LDN("London");

    private final String name;

    Airports(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
