package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class x3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15003a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15004b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15005c;

    public /* synthetic */ x3(int i3, Object obj, Object obj2) {
        this.f15003a = i3;
        this.f15005c = obj;
        this.f15004b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15003a) {
            case 0:
                ((y3) this.f15005c).f14546a.subscribe((ObservableSubscribeOn$SubscribeOnObserver) this.f15004b);
                return;
            case 1:
                p0 p0Var = (p0) this.f15005c;
                try {
                    p0Var.f14816a.onError((Throwable) this.f15004b);
                    return;
                } finally {
                    p0Var.f14819d.dispose();
                }
            case 2:
                ((p0) this.f15005c).f14816a.onNext(this.f15004b);
                return;
            case 3:
                ((y2) this.f15005c).e.lock();
                try {
                    if (((y2) this.f15005c).f15022c == ((ug.a) this.f15004b) && ((y2) this.f15005c).f15023d.decrementAndGet() == 0) {
                        Object obj = ((y2) this.f15005c).f15021b;
                        if (obj instanceof ug.b) {
                            ((ug.b) obj).dispose();
                        }
                        ((y2) this.f15005c).f15022c.dispose();
                        ((y2) this.f15005c).f15022c = new ug.a();
                    }
                    ((y2) this.f15005c).e.unlock();
                    return;
                } catch (Throwable th2) {
                    ((y2) this.f15005c).e.unlock();
                    throw th2;
                }
            default:
                v4 v4Var = (v4) this.f15005c;
                v4Var.getClass();
                v4Var.f14471c.offer(new u4((io.reactivex.subjects.d) this.f15004b, false));
                if (v4Var.b()) {
                    v4Var.f();
                    return;
                }
                return;
        }
    }
}
