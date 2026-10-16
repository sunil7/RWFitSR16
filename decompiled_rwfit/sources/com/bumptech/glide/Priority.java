package com.bumptech.glide;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Priority {
    public static final Priority HIGH;
    public static final Priority IMMEDIATE;
    public static final Priority LOW;
    public static final Priority NORMAL;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Priority[] f6904a;

    static {
        Priority priority = new Priority("IMMEDIATE", 0);
        IMMEDIATE = priority;
        Priority priority2 = new Priority("HIGH", 1);
        HIGH = priority2;
        Priority priority3 = new Priority("NORMAL", 2);
        NORMAL = priority3;
        Priority priority4 = new Priority("LOW", 3);
        LOW = priority4;
        f6904a = new Priority[]{priority, priority2, priority3, priority4};
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) f6904a.clone();
    }
}
