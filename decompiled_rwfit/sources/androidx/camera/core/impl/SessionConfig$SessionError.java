package androidx.camera.core.impl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class SessionConfig$SessionError {
    public static final SessionConfig$SessionError SESSION_ERROR_SURFACE_NEEDS_RESET;
    public static final SessionConfig$SessionError SESSION_ERROR_UNKNOWN;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SessionConfig$SessionError[] f1338a;

    static {
        SessionConfig$SessionError sessionConfig$SessionError = new SessionConfig$SessionError("SESSION_ERROR_SURFACE_NEEDS_RESET", 0);
        SESSION_ERROR_SURFACE_NEEDS_RESET = sessionConfig$SessionError;
        SessionConfig$SessionError sessionConfig$SessionError2 = new SessionConfig$SessionError("SESSION_ERROR_UNKNOWN", 1);
        SESSION_ERROR_UNKNOWN = sessionConfig$SessionError2;
        f1338a = new SessionConfig$SessionError[]{sessionConfig$SessionError, sessionConfig$SessionError2};
    }

    public static SessionConfig$SessionError valueOf(String str) {
        return (SessionConfig$SessionError) Enum.valueOf(SessionConfig$SessionError.class, str);
    }

    public static SessionConfig$SessionError[] values() {
        return (SessionConfig$SessionError[]) f1338a.clone();
    }
}
