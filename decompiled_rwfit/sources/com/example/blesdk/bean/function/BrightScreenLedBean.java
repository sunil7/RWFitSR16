package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class BrightScreenLedBean extends BaseReminderBean {
    private int lcdLevel = 1;

    public int getLcdLevel() {
        return this.lcdLevel;
    }

    public void setLcdLevel(int i3) {
        this.lcdLevel = i3;
    }

    @Override // com.example.blesdk.bean.function.BaseReminderBean
    public String toString() {
        return e.m(new StringBuilder("BrightScreenLedBean{lcdLevel="), this.lcdLevel, '}');
    }
}
