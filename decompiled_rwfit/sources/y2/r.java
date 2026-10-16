package y2;

/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final s f19979a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19980b;

    public r(s sVar, String str) {
        this.f19979a = sVar;
        this.f19980b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f19979a.f19984d) {
            try {
                if (((r) this.f19979a.f19982b.remove(this.f19980b)) != null) {
                    q qVar = (q) this.f19979a.f19983c.remove(this.f19980b);
                    if (qVar != null) {
                        String str = this.f19980b;
                        o2.m.g().d(r2.e.f18029j, "Exceeded time limits on execution for " + str, new Throwable[0]);
                        ((r2.e) qVar).f();
                    }
                } else {
                    o2.m.g().d("WrkTimerRunnable", "Timer with " + this.f19980b + " is already marked as complete.", new Throwable[0]);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
