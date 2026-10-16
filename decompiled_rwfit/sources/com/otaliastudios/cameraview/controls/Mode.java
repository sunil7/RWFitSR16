package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Mode implements a {
    PICTURE(0),
    VIDEO(1);

    private int value;
    static final Mode DEFAULT = PICTURE;

    Mode(int i3) {
        this.value = i3;
    }

    public static Mode fromValue(int i3) {
        for (Mode mode : values()) {
            if (mode.value() == i3) {
                return mode;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
