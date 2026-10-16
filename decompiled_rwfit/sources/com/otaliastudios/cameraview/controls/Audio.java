package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Audio implements a {
    OFF(0),
    ON(1),
    MONO(2),
    STEREO(3);

    private int value;
    static final Audio DEFAULT = ON;

    Audio(int i3) {
        this.value = i3;
    }

    public static Audio fromValue(int i3) {
        for (Audio audio : values()) {
            if (audio.value() == i3) {
                return audio;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
