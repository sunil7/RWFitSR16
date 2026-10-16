package com.dh.imagepick.exception;

import com.dh.imagepick.DevUtil;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public class BaseException extends IllegalStateException {
    private final String message;

    public BaseException(String message) {
        e.f(message, "message");
        this.message = message;
        DevUtil.INSTANCE.d("ImagePick", getMessage());
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
