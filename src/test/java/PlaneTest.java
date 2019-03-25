import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    public Plane plane;

    @Before
    public void setUp() {
        plane = new Plane(PlaneTypes.BOEING767);
    }

    @Test
    public void hasPlane() {
        PlaneTypes planetype = plane.getPlane();
        assert(planetype instanceof PlaneTypes);
    }

    @Test
    public void hasCapacity() {
        assertEquals(4, plane.getCapacity());
    }

    @Test
    public void hasTotalWeight() {
        assertEquals(200, plane.getTotalWeight());
    }
}
