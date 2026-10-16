package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Flash implements a {
    OFF(0),
    ON(1),
    AUTO(2),
    TORCH(3);

    private int value;
    static final Flash DEFAULT = OFF;

    Flash(int i3) {
        this.value = i3;
    }

    public static Flash fromValue(int i3) {
        for (Flash flash : values()) {
            if (flash.value() == i3) {
                return flash;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
