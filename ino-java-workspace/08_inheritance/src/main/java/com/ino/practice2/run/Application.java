package com.ino.practice2.run;

import com.ino.practice2.dto.Circle;
import com.ino.practice2.dto.Rectangle;

public class Application {
    public static void main(String[] args) {
        Circle[] circles = { new Circle(1, 2, 3)
                , new Circle(3, 3, 4)};
        Rectangle[] rectangles = { new Rectangle(-1, -2, 5, 2)
                , new Rectangle(-2, 5, 2, 8)};
        for(Circle c : circles) {
            c.draw();
        }
        
        for(Rectangle c : rectangles) {
            c.draw();
        }
    }
}
