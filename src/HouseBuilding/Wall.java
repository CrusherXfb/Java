package HouseBuilding;

public class Wall implements IPart {
    private boolean isBuilt;

    @Override
    public boolean isBuilt() {
        return isBuilt;
    }

    @Override
    public void setBuilt(boolean built) {
        isBuilt = built;
    }

    @Override
    public void build() {
        isBuilt = true;
        System.out.println("Стена построена.");
    }
}
