package com.github.mikephil.charting.data;

/* loaded from: classes.dex */
public class EntryDate extends Entry {
    private Long currentTime;

    public EntryDate(float f2, float f10, long j4) {
        super(f2, f10);
        this.currentTime = Long.valueOf(j4);
    }

    public final Long l() {
        return this.currentTime;
    }
}
