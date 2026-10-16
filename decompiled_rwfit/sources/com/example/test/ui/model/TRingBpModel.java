package com.example.test.ui.model;

/* loaded from: classes.dex */
public class TRingBpModel extends TRingHealthItemModel {
    private int dp;
    private int sp;

    public TRingBpModel(int i3, int i10, long j4) {
        super(i3, i10, j4);
    }

    public int getDp() {
        return this.dp;
    }

    public int getSp() {
        return this.sp;
    }

    public void setDp(int i3) {
        this.dp = i3;
    }

    public void setSp(int i3) {
        this.sp = i3;
    }

    public TRingBpModel(int i3, int i10, int i11, long j4) {
        super(0, i11, j4);
        this.sp = i3;
        this.dp = i10;
    }
}
