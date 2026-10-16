package com.google.android.datatransport.runtime.backends;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class BackendResponse$Status {
    public static final BackendResponse$Status FATAL_ERROR;
    public static final BackendResponse$Status OK;
    public static final BackendResponse$Status TRANSIENT_ERROR;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackendResponse$Status[] f8838a;

    static {
        BackendResponse$Status backendResponse$Status = new BackendResponse$Status("OK", 0);
        OK = backendResponse$Status;
        BackendResponse$Status backendResponse$Status2 = new BackendResponse$Status("TRANSIENT_ERROR", 1);
        TRANSIENT_ERROR = backendResponse$Status2;
        BackendResponse$Status backendResponse$Status3 = new BackendResponse$Status("FATAL_ERROR", 2);
        FATAL_ERROR = backendResponse$Status3;
        f8838a = new BackendResponse$Status[]{backendResponse$Status, backendResponse$Status2, backendResponse$Status3};
    }

    public static BackendResponse$Status valueOf(String str) {
        return (BackendResponse$Status) Enum.valueOf(BackendResponse$Status.class, str);
    }

    public static BackendResponse$Status[] values() {
        return (BackendResponse$Status[]) f8838a.clone();
    }
}
