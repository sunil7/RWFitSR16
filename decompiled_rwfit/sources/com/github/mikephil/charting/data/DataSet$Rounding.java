package com.github.mikephil.charting.data;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class DataSet$Rounding {
    public static final DataSet$Rounding CLOSEST;
    public static final DataSet$Rounding DOWN;
    public static final DataSet$Rounding UP;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataSet$Rounding[] f8828a;

    static {
        DataSet$Rounding dataSet$Rounding = new DataSet$Rounding("UP", 0);
        UP = dataSet$Rounding;
        DataSet$Rounding dataSet$Rounding2 = new DataSet$Rounding("DOWN", 1);
        DOWN = dataSet$Rounding2;
        DataSet$Rounding dataSet$Rounding3 = new DataSet$Rounding("CLOSEST", 2);
        CLOSEST = dataSet$Rounding3;
        f8828a = new DataSet$Rounding[]{dataSet$Rounding, dataSet$Rounding2, dataSet$Rounding3};
    }

    public static DataSet$Rounding valueOf(String str) {
        return (DataSet$Rounding) Enum.valueOf(DataSet$Rounding.class, str);
    }

    public static DataSet$Rounding[] values() {
        return (DataSet$Rounding[]) f8828a.clone();
    }
}
