package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class u extends ah.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14913b;

    /* renamed from: c, reason: collision with root package name */
    public final io.reactivex.internal.observers.h f14914c;

    public /* synthetic */ u(io.reactivex.internal.observers.h hVar, int i3) {
        this.f14913b = i3;
        this.f14914c = hVar;
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14913b) {
            case 0:
                ((t) this.f14914c).onComplete();
                break;
            default:
                ((o4) this.f14914c).onComplete();
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14913b) {
            case 0:
                ((t) this.f14914c).onError(th2);
                break;
            default:
                o4 o4Var = (o4) this.f14914c;
                o4Var.f14807k.dispose();
                o4Var.f14806j.dispose();
                o4Var.onError(th2);
                break;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14913b) {
            case 0:
                t tVar = (t) this.f14914c;
                tVar.getClass();
                try {
                    Object call = tVar.f14891h.call();
                    xg.c.b(call, "The buffer supplied is null");
                    Collection collection = (Collection) call;
                    synchronized (tVar) {
                        try {
                            Object obj2 = tVar.f14893j;
                            if (obj2 != null) {
                                tVar.f14893j = collection;
                                tVar.d(obj2, tVar);
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    ad.a(th2);
                    tVar.dispose();
                    tVar.f14470b.onError(th2);
                    return;
                }
            default:
                o4 o4Var = (o4) this.f14914c;
                o4Var.getClass();
                o4Var.f14471c.offer(new p4(null, obj));
                if (o4Var.b()) {
                    o4Var.f();
                    return;
                }
                return;
        }
    }
}
