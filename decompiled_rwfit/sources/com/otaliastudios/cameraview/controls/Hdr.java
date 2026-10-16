package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Hdr implements a {
    OFF(0),
    ON(1);

    private int value;
    static final Hdr DEFAULT = OFF;

    Hdr(int i3) {
        this.value = i3;
    }

    public static Hdr fromValue(int i3) {
        for (Hdr hdr : values()) {
            if (hdr.value() == i3) {
                return hdr;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
