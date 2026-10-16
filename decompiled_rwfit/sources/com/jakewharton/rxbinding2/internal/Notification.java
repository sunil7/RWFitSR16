package com.jakewharton.rxbinding2.internal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Notification {
    public static final Notification INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Notification[] f11379a;

    static {
        Notification notification = new Notification("INSTANCE", 0);
        INSTANCE = notification;
        f11379a = new Notification[]{notification};
    }

    public static Notification valueOf(String str) {
        return (Notification) Enum.valueOf(Notification.class, str);
    }

    public static Notification[] values() {
        return (Notification[]) f11379a.clone();
    }
}
