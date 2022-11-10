package structural_design_pattern.demo.adapter;

public class RectangleAdapter implements Shape {
    private Rectangle adaptor;

    public RectangleAdapter(Rectangle rectangle) {
        adaptor = rectangle;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        adaptor.draw(x, y, width, height);
    }
}
