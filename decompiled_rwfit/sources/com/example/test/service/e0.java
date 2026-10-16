package com.example.test.service;

import android.media.session.MediaSessionManager;
import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public final class e0 implements MediaSessionManager.OnActiveSessionsChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f7697a;

    public e0(h0 h0Var) {
        this.f7697a = h0Var;
    }

    @Override // android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
    public final void onActiveSessionsChanged(List list) {
        Log.e("qob", "onActiveSessionsChanged " + list.size());
        synchronized (this) {
            try {
                h0 h0Var = this.f7697a;
                h0Var.f7711a = list;
                h0Var.c();
                String str = this.f7697a.f7713c;
                if (str != null) {
                    if (str.isEmpty()) {
                    }
                }
                this.f7697a.a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
