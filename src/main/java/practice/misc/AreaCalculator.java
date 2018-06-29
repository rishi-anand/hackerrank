package practice.misc;

import java.util.ArrayList;
import java.util.List;

public class AreaCalculator
{
    private List<Rectangle> rectangles = new ArrayList<Rectangle>();

    public void addRectangle(int x, int y, int width, int height, int price) {
        rectangles.add(new Rectangle(x, y, width, height, price));
    }

    public int calculate() {
        int area = 0;

        for (int rectangle = 0; rectangle < rectangles.size(); rectangle++)
            area += calculate(rectangles.get(rectangle), 1, rectangle + 1);

        return area;
    }

    //A depth-first search for overlaps.
    //Each consecutive overlap alternates inclusionExclusion.
    private int calculate(Rectangle currentRectangle, int inclusionExclusion, int nextRectangle) {
        int area = currentRectangle.area() * inclusionExclusion;

        for (; nextRectangle < rectangles.size(); nextRectangle++) {
            Rectangle overlap = currentRectangle.findOverlap(rectangles.get(nextRectangle));
            if (overlap != null)
                area += calculate(overlap, inclusionExclusion * -1, nextRectangle + 1);
        }

        return area;
    }
}

class Rectangle {
    public int price;
    public int x, y, width, height;

    public Rectangle(int x, int y, int width, int height, int price) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.price = price;
    }

    public int area() { return width * height; }

    public Rectangle findOverlap(Rectangle other) {
        int left = Math.max(this.x, other.x),
                right = Math.min(this.x + this.width, other.x + other.width),
                bottom = Math.max(this.y, other.y),
                top = Math.min(this.y + this.height, other.y + other.height),
                height = top - bottom,
                width = right - left;

        if (height > 0 && width > 0) //If both are positive, there is overlap.
            return new Rectangle(left, bottom, width, height, this.price);

        return null;
    }
}