package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum VideoCodec implements a {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);

    private int value;
    static final VideoCodec DEFAULT = DEVICE_DEFAULT;

    VideoCodec(int i3) {
        this.value = i3;
    }

    public static VideoCodec fromValue(int i3) {
        for (VideoCodec videoCodec : values()) {
            if (videoCodec.value() == i3) {
                return videoCodec;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
