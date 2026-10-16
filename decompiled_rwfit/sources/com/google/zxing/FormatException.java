package com.google.zxing;

/* loaded from: classes.dex */
public final class FormatException extends ReaderException {

    /* renamed from: a, reason: collision with root package name */
    public static final FormatException f11213a;

    static {
        FormatException formatException = new FormatException();
        f11213a = formatException;
        formatException.setStackTrace(ReaderException.NO_TRACE);
    }

    private FormatException() {
    }

    public static FormatException getFormatInstance() {
        return ReaderException.isStackTrace ? new FormatException() : f11213a;
    }

    public static FormatException getFormatInstance(Throwable th2) {
        return ReaderException.isStackTrace ? new FormatException(th2) : f11213a;
    }
}
