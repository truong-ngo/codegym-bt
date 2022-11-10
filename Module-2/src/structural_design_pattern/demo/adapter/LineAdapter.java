package structural_design_pattern.demo.adapter;

public class LineAdapter implements Shape {
    private Line adaptor;

    public LineAdapter(Line line) {
        adaptor = line;
    }
    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        adaptor.draw(x1, y1, x2, y2);
    }
}
