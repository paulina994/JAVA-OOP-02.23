package robots;

import org.junit.Assert;
import org.junit.Test;


public class ServiceTests {

    Robot firstRobot = new Robot("Katy");
    Robot secondRobot = new Robot("Betty");
    Robot thirdRobot = new Robot("Lori");

    @Test(expected = IllegalArgumentException.class)
    public void testCreateServiceWithInvalidCapacity() {
        Service service = new Service("Service", -5);
    }

    @Test
    public void testGetCapacity() {
        Service service = new Service("Service", 5);
        Assert.assertEquals(5, service.getCapacity());
    }

    @Test
    public void testGetName() {
        Service service = new Service("House", 5);
        Assert.assertEquals("House", service.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetInvalidNullName() {
        Service service = new Service(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetInvalidEmptyName() {
        Service service = new Service("   ", 5);
    }

    @Test
    public void testCreateService() {
        Service service = new Service("Polly", 9);
        Assert.assertEquals("Polly", service.getName());
        Assert.assertEquals(9, service.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotIfServiceIsFull() {
        Service service = new Service("Polly", 1);
        service.add(firstRobot);
        service.add(secondRobot);

    }

    @Test
    public void testAddRobotSuccessfully() {
        Service  service = new Service("Polly", 10);
        service.add(firstRobot);
        Assert.assertEquals(1, service.getCount());
        service.add(secondRobot);
        Assert.assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNotExistingRobot() {
        Service service = new Service("Polly", 9);
        service.add(firstRobot);
        service.add(secondRobot);
        service.remove("Laura");

    }

    @Test
    public void testRemoveRobotSuccessfully() {
        Service service = new Service("Polly", 9);
        service.add(firstRobot);
        Assert.assertEquals(1, service.getCount());
        service.remove("Katy");
        Assert.assertEquals(0, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSallingNotExistingRobot() {
        Service service = new Service("Polly", 9);
        service.forSale("Maria");


    }

    @Test
    public void testRobotForSale() {
        Service service = new Service("Polly",9);
        service.add(secondRobot);

        Robot returnedCat = service.forSale("Betty");
        Assert.assertFalse(returnedCat.isReadyForSale());
    }

    @Test
    public void testReport() {
        Service service = new Service("Polly", 9);
        service.add(firstRobot);
        service.add(secondRobot);
        service.add(thirdRobot);

        Assert.assertEquals(String.format("The robot Katy, Betty, Lori is in the service Polly!",service.report()), service.report());
    }

}
