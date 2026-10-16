package com.king.logx.initialize;

import android.content.Context;
import com.king.logx.LogX;
import com.king.logx.logger.ILogger;
import h2.b;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class LogXInitializer implements b {
    private final boolean isDebuggable(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    @Override // h2.b
    public List<Class<? extends b>> dependencies() {
        return EmptyList.INSTANCE;
    }

    @Override // h2.b
    public ILogger create(Context context) {
        e.f(context, "context");
        LogX.Companion companion = LogX.Companion;
        companion.setDebug$logx_release(isDebuggable(context));
        return companion;
    }
}
