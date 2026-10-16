package io.reactivex.internal.util;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ErrorMode {
    public static final ErrorMode BOUNDARY;
    public static final ErrorMode END;
    public static final ErrorMode IMMEDIATE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorMode[] f15117a;

    static {
        ErrorMode errorMode = new ErrorMode("IMMEDIATE", 0);
        IMMEDIATE = errorMode;
        ErrorMode errorMode2 = new ErrorMode("BOUNDARY", 1);
        BOUNDARY = errorMode2;
        ErrorMode errorMode3 = new ErrorMode("END", 2);
        END = errorMode3;
        f15117a = new ErrorMode[]{errorMode, errorMode2, errorMode3};
    }

    public static ErrorMode valueOf(String str) {
        return (ErrorMode) Enum.valueOf(ErrorMode.class, str);
    }

    public static ErrorMode[] values() {
        return (ErrorMode[]) f15117a.clone();
    }
}
