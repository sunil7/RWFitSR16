package com.example.baselibrary.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f7272a;

    public e(o5.a aVar) {
        super(Looper.getMainLooper());
        this.f7272a = new WeakReference(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        WeakReference weakReference = this.f7272a;
        if (weakReference.get() != null) {
            ((o5.a) weakReference.get()).r0(message);
        }
    }
}
