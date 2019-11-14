package structural.decorator;

import java.util.function.Supplier;

interface ShapeB {
    String info();
}

class CircleB implements ShapeB {

    private float radius;

    public CircleB() {
    }

    public CircleB(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class SquareB implements ShapeB
{
    private float side;

    public SquareB()
    {
    }

    public SquareB(float side)
    {
        this.side = side;
    }

    @Override
    public String info()
    {
        return "A square with side " + side;
    }
}

class TransparentShapeB<T extends ShapeB> implements ShapeB
{
    private ShapeB shape;
    private int transparency;

    public TransparentShapeB(Supplier<? extends T> ctor, int transparency)
    {
        shape = ctor.get();
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape + " has " + transparency + "% transparency";
    }
}

class ColoredShapeB<T extends ShapeB> implements ShapeB {

    private ShapeB shape;
    private String color;

    public ColoredShapeB(Supplier<? extends T> ctor, String color) {
        this.shape = ctor.get();
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info();
    }
}

class StaticDecoratorDemo {
    public static void main(String[] args) {
        CircleB circle = new CircleB(10);
        System.out.println(circle.info());

        ColoredShapeB<SquareB> blueSquare = new ColoredShapeB<SquareB>(() -> new SquareB(20), "blue");
        System.out.println(blueSquare.info());

        // ugly!
        TransparentShapeB<ColoredShapeB<CircleB>> myCircle =
                new TransparentShapeB<>(() ->
                        new ColoredShapeB<>(() -> new CircleB(5), "green"), 50
                );
        System.out.println(myCircle.info());
        // cannot call myCircle.resize()
    }
}