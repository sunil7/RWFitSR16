package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BrightVibrationBean {
    private int level = 1;
    private int count = 1;

    public int getCount() {
        return this.count;
    }

    public int getLevel() {
        return this.level;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setLevel(int i3) {
        this.level = i3;
    }

    public String toString() {
        return e.m(new StringBuilder("BrightVibrationBean{level="), this.level, '}');
    }
}
