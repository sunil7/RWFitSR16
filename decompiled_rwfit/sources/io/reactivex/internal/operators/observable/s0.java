package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.internal.util.NotificationLite;

/* loaded from: classes2.dex */
public final class s0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14868a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14869b;

    /* renamed from: c, reason: collision with root package name */
    public ug.b f14870c;

    public /* synthetic */ s0() {
        this.f14868a = 0;
    }

    private final void a(Object obj) {
    }

    private final void b(Object obj) {
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14868a) {
            case 0:
                ug.b bVar = this.f14870c;
                this.f14870c = EmptyComponent.INSTANCE;
                this.f14869b = EmptyComponent.asObserver();
                bVar.dispose();
                break;
            case 1:
                this.f14870c.dispose();
                break;
            case 2:
                this.f14870c.dispose();
                break;
            case 3:
                this.f14870c.dispose();
                break;
            default:
                this.f14870c.dispose();
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14868a) {
        }
        return this.f14870c.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14868a) {
            case 0:
                rg.s sVar = (rg.s) this.f14869b;
                this.f14870c = EmptyComponent.INSTANCE;
                this.f14869b = EmptyComponent.asObserver();
                sVar.onComplete();
                break;
            case 1:
                ((rg.s) this.f14869b).onComplete();
                break;
            case 2:
                ((rg.s) this.f14869b).onComplete();
                break;
            case 3:
                rg.j jVar = rg.j.f18126b;
                rg.s sVar2 = (rg.s) this.f14869b;
                sVar2.onNext(jVar);
                sVar2.onComplete();
                break;
            default:
                ((rg.b) this.f14869b).onComplete();
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14868a) {
            case 0:
                rg.s sVar = (rg.s) this.f14869b;
                this.f14870c = EmptyComponent.INSTANCE;
                this.f14869b = EmptyComponent.asObserver();
                sVar.onError(th2);
                break;
            case 1:
                ((rg.s) this.f14869b).onError(th2);
                break;
            case 2:
                ((rg.s) this.f14869b).onError(th2);
                break;
            case 3:
                xg.c.b(th2, "error is null");
                rg.j jVar = new rg.j(NotificationLite.error(th2));
                rg.s sVar2 = (rg.s) this.f14869b;
                sVar2.onNext(jVar);
                sVar2.onComplete();
                break;
            default:
                ((rg.b) this.f14869b).onError(th2);
                break;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14868a) {
            case 0:
                ((rg.s) this.f14869b).onNext(obj);
                break;
            case 1:
                ((rg.s) this.f14869b).onNext(obj);
                break;
            case 3:
                xg.c.b(obj, "value is null");
                ((rg.s) this.f14869b).onNext(new rg.j(obj));
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14868a) {
            case 0:
                if (DisposableHelper.validate(this.f14870c, bVar)) {
                    this.f14870c = bVar;
                    ((rg.s) this.f14869b).onSubscribe(this);
                    break;
                }
                break;
            case 1:
                if (DisposableHelper.validate(this.f14870c, bVar)) {
                    this.f14870c = bVar;
                    ((rg.s) this.f14869b).onSubscribe(this);
                    break;
                }
                break;
            case 2:
                this.f14870c = bVar;
                ((rg.s) this.f14869b).onSubscribe(this);
                break;
            case 3:
                if (DisposableHelper.validate(this.f14870c, bVar)) {
                    this.f14870c = bVar;
                    ((rg.s) this.f14869b).onSubscribe(this);
                    break;
                }
                break;
            default:
                this.f14870c = bVar;
                ((rg.b) this.f14869b).onSubscribe(this);
                break;
        }
    }

    public /* synthetic */ s0(Object obj, int i3) {
        this.f14868a = i3;
        this.f14869b = obj;
    }
}
