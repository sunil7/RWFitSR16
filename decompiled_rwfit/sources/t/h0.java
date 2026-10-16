package t;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class h0 extends x {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f18341d = 1;
    public final Object e;

    public h0(p0 p0Var) {
        super(p0Var);
        this.e = new AtomicBoolean(false);
    }

    @Override // t.x, java.lang.AutoCloseable
    public void close() {
        switch (this.f18341d) {
            case 1:
                if (!((AtomicBoolean) this.e).getAndSet(true)) {
                    super.close();
                    break;
                }
                break;
            default:
                super.close();
                break;
        }
    }

    public h0(p0 p0Var, i0 i0Var) {
        super(p0Var);
        this.e = new WeakReference(i0Var);
        addOnImageCloseListener(new g0(this, 0));
    }
}
