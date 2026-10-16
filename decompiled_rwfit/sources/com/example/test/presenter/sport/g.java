package com.example.test.presenter.sport;

import com.example.test.service.r0;
import com.example.test.service.s0;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class g extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7604a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f7605b;

    public g(l lVar) {
        this.f7605b = new WeakReference(lVar);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        e6.c cVar;
        e6.c cVar2;
        e6.c cVar3;
        switch (this.f7604a) {
            case 0:
                WeakReference weakReference = this.f7605b;
                if (weakReference != null && (cVar = (e6.c) weakReference.get()) != null) {
                    cVar.b();
                    break;
                }
                break;
            case 1:
                WeakReference weakReference2 = this.f7605b;
                if (weakReference2 != null && (cVar2 = (e6.c) weakReference2.get()) != null) {
                    cVar2.b();
                    break;
                }
                break;
            default:
                WeakReference weakReference3 = this.f7605b;
                if (weakReference3 != null && (cVar3 = (e6.c) weakReference3.get()) != null) {
                    cVar3.b();
                    break;
                }
                break;
        }
    }

    public g(r0 r0Var) {
        this.f7605b = new WeakReference(r0Var);
    }

    public g(s0 s0Var) {
        this.f7605b = new WeakReference(s0Var);
    }
}
