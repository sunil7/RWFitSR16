package com.dh.imagepick.preview.core;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.d0;
import androidx.lifecycle.n;
import androidx.lifecycle.r;
import kotlin.jvm.internal.e;
import ug.b;

/* loaded from: classes.dex */
public final class LifecycleDisposable implements r {

    /* renamed from: a, reason: collision with root package name */
    public final n f7138a;

    /* renamed from: b, reason: collision with root package name */
    public final b f7139b;

    public LifecycleDisposable(n lifecycle, b bVar) {
        e.f(lifecycle, "lifecycle");
        this.f7138a = lifecycle;
        this.f7139b = bVar;
    }

    @d0(Lifecycle$Event.ON_DESTROY)
    public final void onDestroy() {
        this.f7139b.dispose();
        this.f7138a.b(this);
    }
}
