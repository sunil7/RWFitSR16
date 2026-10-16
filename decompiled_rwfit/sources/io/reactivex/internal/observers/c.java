package io.reactivex.internal.observers;

import java.util.concurrent.CountDownLatch;
import rg.s;

/* loaded from: classes2.dex */
public final class c extends CountDownLatch implements s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public Object f14454a;

    /* renamed from: b, reason: collision with root package name */
    public Throwable f14455b;

    /* renamed from: c, reason: collision with root package name */
    public ug.b f14456c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f14457d;
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i3, int i10) {
        super(i3);
        this.e = i10;
    }

    public final Object a() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                dispose();
                throw io.reactivex.internal.util.b.b(e);
            }
        }
        Throwable th2 = this.f14455b;
        if (th2 == null) {
            return this.f14454a;
        }
        throw io.reactivex.internal.util.b.b(th2);
    }

    @Override // ug.b
    public final void dispose() {
        this.f14457d = true;
        ug.b bVar = this.f14456c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14457d;
    }

    @Override // rg.s
    public final void onComplete() {
        countDown();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.e) {
            case 0:
                if (this.f14454a == null) {
                    this.f14455b = th2;
                }
                countDown();
                break;
            default:
                this.f14454a = null;
                this.f14455b = th2;
                countDown();
                break;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.e) {
            case 0:
                if (this.f14454a == null) {
                    this.f14454a = obj;
                    this.f14456c.dispose();
                    countDown();
                    break;
                }
                break;
            default:
                this.f14454a = obj;
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        this.f14456c = bVar;
        if (this.f14457d) {
            bVar.dispose();
        }
    }
}
