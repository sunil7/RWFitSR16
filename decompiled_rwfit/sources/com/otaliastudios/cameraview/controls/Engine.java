package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Engine implements a {
    CAMERA1(0),
    CAMERA2(1);

    private int value;
    static final Engine DEFAULT = CAMERA1;

    Engine(int i3) {
        this.value = i3;
    }

    public static Engine fromValue(int i3) {
        for (Engine engine : values()) {
            if (engine.value() == i3) {
                return engine;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
