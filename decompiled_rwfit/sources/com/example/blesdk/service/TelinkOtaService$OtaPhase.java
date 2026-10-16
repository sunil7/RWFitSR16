package com.example.blesdk.service;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class TelinkOtaService$OtaPhase {
    public static final TelinkOtaService$OtaPhase IDLE;
    public static final TelinkOtaService$OtaPhase SENDING_DATA;
    public static final TelinkOtaService$OtaPhase SENDING_END;
    public static final TelinkOtaService$OtaPhase SENDING_START;
    public static final TelinkOtaService$OtaPhase SENDING_VERSION;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TelinkOtaService$OtaPhase[] f7278a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ih.a f7279b;

    static {
        TelinkOtaService$OtaPhase telinkOtaService$OtaPhase = new TelinkOtaService$OtaPhase("IDLE", 0);
        IDLE = telinkOtaService$OtaPhase;
        TelinkOtaService$OtaPhase telinkOtaService$OtaPhase2 = new TelinkOtaService$OtaPhase("SENDING_VERSION", 1);
        SENDING_VERSION = telinkOtaService$OtaPhase2;
        TelinkOtaService$OtaPhase telinkOtaService$OtaPhase3 = new TelinkOtaService$OtaPhase("SENDING_START", 2);
        SENDING_START = telinkOtaService$OtaPhase3;
        TelinkOtaService$OtaPhase telinkOtaService$OtaPhase4 = new TelinkOtaService$OtaPhase("SENDING_DATA", 3);
        SENDING_DATA = telinkOtaService$OtaPhase4;
        TelinkOtaService$OtaPhase telinkOtaService$OtaPhase5 = new TelinkOtaService$OtaPhase("SENDING_END", 4);
        SENDING_END = telinkOtaService$OtaPhase5;
        TelinkOtaService$OtaPhase[] telinkOtaService$OtaPhaseArr = {telinkOtaService$OtaPhase, telinkOtaService$OtaPhase2, telinkOtaService$OtaPhase3, telinkOtaService$OtaPhase4, telinkOtaService$OtaPhase5};
        f7278a = telinkOtaService$OtaPhaseArr;
        f7279b = kotlin.enums.a.a(telinkOtaService$OtaPhaseArr);
    }

    public static ih.a getEntries() {
        return f7279b;
    }

    public static TelinkOtaService$OtaPhase valueOf(String str) {
        return (TelinkOtaService$OtaPhase) Enum.valueOf(TelinkOtaService$OtaPhase.class, str);
    }

    public static TelinkOtaService$OtaPhase[] values() {
        return (TelinkOtaService$OtaPhase[]) f7278a.clone();
    }
}
