package pattern.factory.abs;

import pattern.factory.BMW;
import pattern.factory.Car;

public class BMWFactory extends AbstractFactory {

    @Override
    protected Car getCar() {
        return new BMW();
    }
}
