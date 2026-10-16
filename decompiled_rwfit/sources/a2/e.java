package a2;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f24a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f25b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f26c;

    public /* synthetic */ e(f fVar, int i3, Object obj, int i10) {
        this.f24a = i10;
        this.f26c = fVar;
        this.f25b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f24a) {
            case 0:
                f fVar = this.f26c;
                if (fVar.f59i.get()) {
                    return;
                }
                h5.b bVar = fVar.f27l;
                if (((AtomicBoolean) bVar.f36a).get()) {
                    fVar.f59i.set(true);
                    return;
                }
                fVar.f54c.getClass();
                bVar.getClass();
                if (this.f25b != null) {
                    throw new ClassCastException();
                }
                kotlin.jvm.internal.e.f(null, "item");
                throw null;
            default:
                f fVar2 = this.f26c;
                if (fVar2.f59i.get()) {
                    return;
                }
                h5.b bVar2 = fVar2.f27l;
                if (((AtomicBoolean) bVar2.f36a).get()) {
                    fVar2.f59i.set(true);
                    return;
                }
                fVar2.f54c.getClass();
                bVar2.getClass();
                if (this.f25b != null) {
                    throw new ClassCastException();
                }
                kotlin.jvm.internal.e.f(null, "item");
                throw null;
        }
    }
}
