package com.liulishuo.filedownloader.exception;

import android.annotation.TargetApi;
import java.io.IOException;
import java.util.Locale;
import ye.e;

/* loaded from: classes2.dex */
public class FileDownloadOutOfSpaceException extends IOException {
    private long breakpointBytes;
    private long freeSpaceBytes;
    private long requiredSpaceBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(9)
    public FileDownloadOutOfSpaceException(long j4, long j10, long j11, Throwable th2) {
        super("The file is too large to store, breakpoint in bytes:  " + j11 + ", required space in bytes: " + j10 + ", but free space in bytes: " + j4, th2);
        int i3 = e.f20123a;
        Locale locale = Locale.ENGLISH;
        this.freeSpaceBytes = j4;
        this.requiredSpaceBytes = j10;
        this.breakpointBytes = j11;
    }

    public long getBreakpointBytes() {
        return this.breakpointBytes;
    }

    public long getFreeSpaceBytes() {
        return this.freeSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDownloadOutOfSpaceException(long j4, long j10, long j11) {
        super("The file is too large to store, breakpoint in bytes:  " + j11 + ", required space in bytes: " + j10 + ", but free space in bytes: " + j4);
        int i3 = e.f20123a;
        Locale locale = Locale.ENGLISH;
        this.freeSpaceBytes = j4;
        this.requiredSpaceBytes = j10;
        this.breakpointBytes = j11;
    }
}
