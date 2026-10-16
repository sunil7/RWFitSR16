package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;

/* loaded from: classes.dex */
public enum NetworkConnectionInfo$NetworkType {
    MOBILE(0),
    WIFI(1),
    MOBILE_MMS(2),
    MOBILE_SUPL(3),
    MOBILE_DUN(4),
    MOBILE_HIPRI(5),
    WIMAX(6),
    BLUETOOTH(7),
    DUMMY(8),
    ETHERNET(9),
    MOBILE_FOTA(10),
    MOBILE_IMS(11),
    MOBILE_CBS(12),
    WIFI_P2P(13),
    MOBILE_IA(14),
    MOBILE_EMERGENCY(15),
    PROXY(16),
    VPN(17),
    NONE(-1);


    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f8835a;
    private final int value;

    static {
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType = MOBILE;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType2 = WIFI;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType3 = MOBILE_MMS;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType4 = MOBILE_SUPL;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType5 = MOBILE_DUN;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType6 = MOBILE_HIPRI;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType7 = WIMAX;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType8 = BLUETOOTH;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType9 = DUMMY;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType10 = ETHERNET;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType11 = MOBILE_FOTA;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType12 = MOBILE_IMS;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType13 = MOBILE_CBS;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType14 = WIFI_P2P;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType15 = MOBILE_IA;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType16 = MOBILE_EMERGENCY;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType17 = PROXY;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType18 = VPN;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType19 = NONE;
        SparseArray sparseArray = new SparseArray();
        f8835a = sparseArray;
        sparseArray.put(0, networkConnectionInfo$NetworkType);
        sparseArray.put(1, networkConnectionInfo$NetworkType2);
        sparseArray.put(2, networkConnectionInfo$NetworkType3);
        sparseArray.put(3, networkConnectionInfo$NetworkType4);
        sparseArray.put(4, networkConnectionInfo$NetworkType5);
        sparseArray.put(5, networkConnectionInfo$NetworkType6);
        sparseArray.put(6, networkConnectionInfo$NetworkType7);
        sparseArray.put(7, networkConnectionInfo$NetworkType8);
        sparseArray.put(8, networkConnectionInfo$NetworkType9);
        sparseArray.put(9, networkConnectionInfo$NetworkType10);
        sparseArray.put(10, networkConnectionInfo$NetworkType11);
        sparseArray.put(11, networkConnectionInfo$NetworkType12);
        sparseArray.put(12, networkConnectionInfo$NetworkType13);
        sparseArray.put(13, networkConnectionInfo$NetworkType14);
        sparseArray.put(14, networkConnectionInfo$NetworkType15);
        sparseArray.put(15, networkConnectionInfo$NetworkType16);
        sparseArray.put(16, networkConnectionInfo$NetworkType17);
        sparseArray.put(17, networkConnectionInfo$NetworkType18);
        sparseArray.put(-1, networkConnectionInfo$NetworkType19);
    }

    NetworkConnectionInfo$NetworkType(int i3) {
        this.value = i3;
    }

    public static NetworkConnectionInfo$NetworkType forNumber(int i3) {
        return (NetworkConnectionInfo$NetworkType) f8835a.get(i3);
    }

    public int getValue() {
        return this.value;
    }
}
