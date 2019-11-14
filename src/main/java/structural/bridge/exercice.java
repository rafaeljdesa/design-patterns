package structural.bridge;

interface RendererB {
    String whatToRenderAs();
}

class VectorRendererB implements RendererB {

    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRendererB implements RendererB {

    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

abstract class ShapeB
{

    protected RendererB renderer;

    public ShapeB(RendererB renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();
}

class Triangle extends ShapeB
{
    public Triangle(RendererB renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Triangle";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

class Square extends ShapeB
{
    public Square(RendererB renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

