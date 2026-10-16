package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum AudioCodec implements a {
    DEVICE_DEFAULT(0),
    AAC(1),
    HE_AAC(2),
    AAC_ELD(3);

    private int value;
    static final AudioCodec DEFAULT = DEVICE_DEFAULT;

    AudioCodec(int i3) {
        this.value = i3;
    }

    public static AudioCodec fromValue(int i3) {
        for (AudioCodec audioCodec : values()) {
            if (audioCodec.value() == i3) {
                return audioCodec;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
