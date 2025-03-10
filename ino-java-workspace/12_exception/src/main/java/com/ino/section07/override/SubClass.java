package com.ino.section07.override;

import java.io.IOException;

public class SubClass extends SuperClass {
    @Override
    public void method() throws IOException {
        super.method();
    }
}
