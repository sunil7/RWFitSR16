package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Preview implements a {
    SURFACE(0),
    TEXTURE(1),
    GL_SURFACE(2);

    private int value;
    static final Preview DEFAULT = GL_SURFACE;

    Preview(int i3) {
        this.value = i3;
    }

    public static Preview fromValue(int i3) {
        for (Preview preview : values()) {
            if (preview.value() == i3) {
                return preview;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
