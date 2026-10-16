package com.google.zxing;

/* loaded from: classes.dex */
public final class NotFoundException extends ReaderException {

    /* renamed from: a, reason: collision with root package name */
    public static final NotFoundException f11214a;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f11214a = notFoundException;
        notFoundException.setStackTrace(ReaderException.NO_TRACE);
    }

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return ReaderException.isStackTrace ? new NotFoundException() : f11214a;
    }
}
