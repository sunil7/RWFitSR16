package com.example.blesdk.service;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7280a;

    static {
        int[] iArr = new int[TelinkOtaService$OtaPhase.values().length];
        try {
            iArr[TelinkOtaService$OtaPhase.SENDING_VERSION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[TelinkOtaService$OtaPhase.SENDING_START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[TelinkOtaService$OtaPhase.SENDING_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[TelinkOtaService$OtaPhase.SENDING_END.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f7280a = iArr;
    }
}
