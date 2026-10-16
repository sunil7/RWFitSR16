package com.google.zxing;

/* loaded from: classes.dex */
public final class ChecksumException extends ReaderException {

    /* renamed from: a, reason: collision with root package name */
    public static final ChecksumException f11210a;

    static {
        ChecksumException checksumException = new ChecksumException();
        f11210a = checksumException;
        checksumException.setStackTrace(ReaderException.NO_TRACE);
    }

    private ChecksumException() {
    }

    public static ChecksumException getChecksumInstance() {
        return ReaderException.isStackTrace ? new ChecksumException() : f11210a;
    }

    public static ChecksumException getChecksumInstance(Throwable th2) {
        return ReaderException.isStackTrace ? new ChecksumException(th2) : f11210a;
    }
}
