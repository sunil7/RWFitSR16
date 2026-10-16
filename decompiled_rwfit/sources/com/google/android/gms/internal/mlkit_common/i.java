package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ag;
import com.google.android.gms.internal.mlkit_vision_common.ja;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Callable, vg.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9174a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9175b;

    public /* synthetic */ i(Object obj, int i3) {
        this.f9174a = i3;
        this.f9175b = obj;
    }

    @Override // vg.o
    public Object apply(Object obj) {
        return this.f9175b;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f9174a) {
            case 0:
                k kVar = (k) this.f9175b;
                kVar.getClass();
                return q9.d.f17809c.a(kVar.f9179a);
            case 1:
                ag agVar = (ag) this.f9175b;
                agVar.getClass();
                return q9.d.f17809c.a(agVar.f9226g);
            case 2:
                ja jaVar = (ja) this.f9175b;
                jaVar.getClass();
                return q9.d.f17809c.a(jaVar.f10017g);
            case 3:
                synchronized (((v3.c) this.f9175b)) {
                    try {
                        v3.c cVar = (v3.c) this.f9175b;
                        if (cVar.f19163i == null) {
                            return null;
                        }
                        cVar.I();
                        if (((v3.c) this.f9175b).i()) {
                            ((v3.c) this.f9175b).A();
                            ((v3.c) this.f9175b).f19165k = 0;
                        }
                        return null;
                    } finally {
                    }
                }
            default:
                return this.f9175b;
        }
    }
}
