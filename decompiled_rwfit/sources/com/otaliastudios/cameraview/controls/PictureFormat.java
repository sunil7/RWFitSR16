package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum PictureFormat implements a {
    JPEG(0),
    DNG(1);

    private int value;
    static final PictureFormat DEFAULT = JPEG;

    PictureFormat(int i3) {
        this.value = i3;
    }

    public static PictureFormat fromValue(int i3) {
        for (PictureFormat pictureFormat : values()) {
            if (pictureFormat.value() == i3) {
                return pictureFormat;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
