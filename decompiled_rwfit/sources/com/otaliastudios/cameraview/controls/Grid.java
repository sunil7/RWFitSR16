package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Grid implements a {
    OFF(0),
    DRAW_3X3(1),
    DRAW_4X4(2),
    DRAW_PHI(3);

    private int value;
    static final Grid DEFAULT = OFF;

    Grid(int i3) {
        this.value = i3;
    }

    public static Grid fromValue(int i3) {
        for (Grid grid : values()) {
            if (grid.value() == i3) {
                return grid;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
