package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum WhiteBalance implements a {
    AUTO(0),
    INCANDESCENT(1),
    FLUORESCENT(2),
    DAYLIGHT(3),
    CLOUDY(4);

    private int value;
    static final WhiteBalance DEFAULT = AUTO;

    WhiteBalance(int i3) {
        this.value = i3;
    }

    public static WhiteBalance fromValue(int i3) {
        for (WhiteBalance whiteBalance : values()) {
            if (whiteBalance.value() == i3) {
                return whiteBalance;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
