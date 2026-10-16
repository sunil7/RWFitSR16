package com.google.android.gms.internal.mlkit_vision_common;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class e6 {
    public static final wh.w a(wh.a0 buffer) {
        kotlin.jvm.internal.e.f(buffer, "$this$buffer");
        return new wh.w(buffer);
    }

    public static final wh.x b(wh.c0 buffer) {
        kotlin.jvm.internal.e.f(buffer, "$this$buffer");
        return new wh.x(buffer);
    }

    public static final boolean c(AssertionError assertionError) {
        Logger logger = wh.t.f19667a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? kotlin.text.m.c(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static final wh.a0 d(Socket sink) {
        Logger logger = wh.t.f19667a;
        kotlin.jvm.internal.e.f(sink, "$this$sink");
        wh.b0 b0Var = new wh.b0(sink);
        OutputStream outputStream = sink.getOutputStream();
        kotlin.jvm.internal.e.e(outputStream, "getOutputStream()");
        return b0Var.sink(new wh.c(1, outputStream, b0Var));
    }

    public static final wh.c0 e(Socket source) {
        Logger logger = wh.t.f19667a;
        kotlin.jvm.internal.e.f(source, "$this$source");
        wh.b0 b0Var = new wh.b0(source);
        InputStream inputStream = source.getInputStream();
        kotlin.jvm.internal.e.e(inputStream, "getInputStream()");
        return b0Var.source(new wh.d(1, inputStream, b0Var));
    }
}
