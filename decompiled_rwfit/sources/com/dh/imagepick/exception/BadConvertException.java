package com.dh.imagepick.exception;

import g5.b;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class BadConvertException extends BaseException {
    private final b result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadConvertException(b result) {
        super("convert uri to path failed");
        e.f(result, "result");
        this.result = result;
    }

    public final b getResult() {
        return this.result;
    }
}
