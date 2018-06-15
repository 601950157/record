package pattern.factory.abs;

import pattern.factory.Audi;
import pattern.factory.Car;

public class AudiFactory extends AbstractFactory {

    @Override
    protected Car getCar() {
        return new Audi();
    }
}
