package y2;

import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;

/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public static final String f19960d = o2.m.i("StopWorkRunnable");

    /* renamed from: a, reason: collision with root package name */
    public final p2.l f19961a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19962b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19963c;

    public j(p2.l lVar, String str, boolean z5) {
        this.f19961a = lVar;
        this.f19962b = str;
        this.f19963c = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean containsKey;
        boolean j4;
        p2.l lVar = this.f19961a;
        WorkDatabase workDatabase = lVar.f17427c;
        p2.b bVar = lVar.f17429f;
        p0.f n4 = workDatabase.n();
        workDatabase.c();
        try {
            String str = this.f19962b;
            synchronized (bVar.f17400k) {
                containsKey = bVar.f17395f.containsKey(str);
            }
            if (this.f19963c) {
                j4 = this.f19961a.f17429f.i(this.f19962b);
            } else {
                if (!containsKey && n4.f(this.f19962b) == WorkInfo$State.RUNNING) {
                    n4.m(WorkInfo$State.ENQUEUED, this.f19962b);
                }
                j4 = this.f19961a.f17429f.j(this.f19962b);
            }
            o2.m.g().d(f19960d, "StopWorkRunnable for " + this.f19962b + "; Processor.stopWork = " + j4, new Throwable[0]);
            workDatabase.h();
            workDatabase.f();
        } catch (Throwable th2) {
            workDatabase.f();
            throw th2;
        }
    }
}
