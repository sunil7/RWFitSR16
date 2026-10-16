package h1;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14248a;

    /* renamed from: b, reason: collision with root package name */
    public c f14249b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14250c;

    public void setOnCancelListener(c cVar) {
        synchronized (this) {
            while (this.f14250c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.f14249b == cVar) {
                return;
            }
            this.f14249b = cVar;
            if (this.f14248a && cVar != null) {
                cVar.onCancel();
            }
        }
    }
}
