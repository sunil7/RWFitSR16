package com.dh.keeplive.exception;

import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class KeepLiveException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeepLiveException(String msg) {
        super(msg);
        e.f(msg, "msg");
    }
}
