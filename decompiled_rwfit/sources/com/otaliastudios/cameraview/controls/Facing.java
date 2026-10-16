package com.otaliastudios.cameraview.controls;

import android.content.Context;
import ef.d;

/* loaded from: classes2.dex */
public enum Facing implements a {
    BACK(0),
    FRONT(1);

    private int value;

    Facing(int i3) {
        this.value = i3;
    }

    public static Facing DEFAULT(Context context) {
        if (context == null) {
            return BACK;
        }
        Facing facing = BACK;
        if (!d.a(facing)) {
            Facing facing2 = FRONT;
            if (d.a(facing2)) {
                return facing2;
            }
        }
        return facing;
    }

    public static Facing fromValue(int i3) {
        for (Facing facing : values()) {
            if (facing.value() == i3) {
                return facing;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
