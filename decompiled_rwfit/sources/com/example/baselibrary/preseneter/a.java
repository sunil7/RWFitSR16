package com.example.baselibrary.preseneter;

import kotlin.jvm.internal.e;
import oh.l;
import rg.n;
import rg.o;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7252a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f7253b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7254c;

    public /* synthetic */ a(l lVar, Object obj, int i3) {
        this.f7252a = i3;
        this.f7253b = lVar;
        this.f7254c = obj;
    }

    @Override // rg.o
    public final void d(n nVar) {
        switch (this.f7252a) {
            case 0:
                l runBlock = this.f7253b;
                e.f(runBlock, "$runBlock");
                Object invoke = runBlock.invoke(this.f7254c);
                if (invoke != null) {
                    nVar.onNext(invoke);
                    break;
                }
                break;
            default:
                l runBlock2 = this.f7253b;
                e.f(runBlock2, "$runBlock");
                Object invoke2 = runBlock2.invoke(this.f7254c);
                if (invoke2 != null) {
                    nVar.onNext(invoke2);
                    break;
                }
                break;
        }
    }
}
