package com.autonavi.base.ae.gmap;

/* loaded from: classes.dex */
public class GLEngineIDController {
    private static final String TAG = "GLEngineIDController";
    private static GLEngineIDController sController = new GLEngineIDController();
    private int engineIDIndex = 10000;

    private GLEngineIDController() {
    }

    public static GLEngineIDController getController() {
        return sController;
    }

    public synchronized int generate() {
        int i3;
        i3 = this.engineIDIndex + 1;
        this.engineIDIndex = i3;
        return i3;
    }
}
