package structural.proxy;

interface Drivable {
    void drive();
}

class Car implements Drivable {

    Driver driver;

    @Override
    public void drive() {
        System.out.println("Car being driven");
    }
}

class Driver {

    public int age;

    public Driver(int age) {
        this.age = age;
    }
}

class CarProxy extends Car {

    Driver driver;

    public CarProxy(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {
        if (driver.age >= 17)
            super.drive();
        else
            System.out.println("Driver too young");
    }
}

class ProtectionProxyDemo
{
    public static void main(String[] args)
    {
        Drivable car = new CarProxy(new Driver(12));
        car.drive();
    }
}
