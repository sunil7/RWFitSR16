package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;

/* loaded from: classes.dex */
public enum NetworkConnectionInfo$MobileSubtype {
    UNKNOWN_MOBILE_SUBTYPE(0),
    GPRS(1),
    EDGE(2),
    UMTS(3),
    CDMA(4),
    EVDO_0(5),
    EVDO_A(6),
    RTT(7),
    HSDPA(8),
    HSUPA(9),
    HSPA(10),
    IDEN(11),
    EVDO_B(12),
    LTE(13),
    EHRPD(14),
    HSPAP(15),
    GSM(16),
    TD_SCDMA(17),
    IWLAN(18),
    LTE_CA(19),
    COMBINED(100);


    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f8833a;
    private final int value;

    static {
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype = UNKNOWN_MOBILE_SUBTYPE;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype2 = GPRS;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype3 = EDGE;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype4 = UMTS;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype5 = CDMA;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype6 = EVDO_0;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype7 = EVDO_A;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype8 = RTT;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype9 = HSDPA;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype10 = HSUPA;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype11 = HSPA;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype12 = IDEN;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype13 = EVDO_B;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype14 = LTE;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype15 = EHRPD;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype16 = HSPAP;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype17 = GSM;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype18 = TD_SCDMA;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype19 = IWLAN;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype20 = LTE_CA;
        SparseArray sparseArray = new SparseArray();
        f8833a = sparseArray;
        sparseArray.put(0, networkConnectionInfo$MobileSubtype);
        sparseArray.put(1, networkConnectionInfo$MobileSubtype2);
        sparseArray.put(2, networkConnectionInfo$MobileSubtype3);
        sparseArray.put(3, networkConnectionInfo$MobileSubtype4);
        sparseArray.put(4, networkConnectionInfo$MobileSubtype5);
        sparseArray.put(5, networkConnectionInfo$MobileSubtype6);
        sparseArray.put(6, networkConnectionInfo$MobileSubtype7);
        sparseArray.put(7, networkConnectionInfo$MobileSubtype8);
        sparseArray.put(8, networkConnectionInfo$MobileSubtype9);
        sparseArray.put(9, networkConnectionInfo$MobileSubtype10);
        sparseArray.put(10, networkConnectionInfo$MobileSubtype11);
        sparseArray.put(11, networkConnectionInfo$MobileSubtype12);
        sparseArray.put(12, networkConnectionInfo$MobileSubtype13);
        sparseArray.put(13, networkConnectionInfo$MobileSubtype14);
        sparseArray.put(14, networkConnectionInfo$MobileSubtype15);
        sparseArray.put(15, networkConnectionInfo$MobileSubtype16);
        sparseArray.put(16, networkConnectionInfo$MobileSubtype17);
        sparseArray.put(17, networkConnectionInfo$MobileSubtype18);
        sparseArray.put(18, networkConnectionInfo$MobileSubtype19);
        sparseArray.put(19, networkConnectionInfo$MobileSubtype20);
    }

    NetworkConnectionInfo$MobileSubtype(int i3) {
        this.value = i3;
    }

    public static NetworkConnectionInfo$MobileSubtype forNumber(int i3) {
        return (NetworkConnectionInfo$MobileSubtype) f8833a.get(i3);
    }

    public int getValue() {
        return this.value;
    }
}
