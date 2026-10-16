package y2;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public static final String f19945c = o2.m.i("EnqueueRunnable");

    /* renamed from: a, reason: collision with root package name */
    public final p2.e f19946a;

    /* renamed from: b, reason: collision with root package name */
    public final o4.c f19947b = new o4.c(5);

    public d(p2.e eVar) {
        this.f19946a = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01af  */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [int] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(p2.e r21) {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.d.a(p2.e):boolean");
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z5;
        o4.c cVar = this.f19947b;
        p2.e eVar = this.f19946a;
        try {
            eVar.getClass();
            HashSet hashSet = new HashSet();
            hashSet.addAll(eVar.e);
            HashSet b3 = p2.e.b(eVar);
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hashSet.removeAll(eVar.e);
                    z5 = false;
                    break;
                } else if (b3.contains((String) it.next())) {
                    z5 = true;
                    break;
                }
            }
            if (z5) {
                throw new IllegalStateException("WorkContinuation has cycles (" + eVar + ")");
            }
            p2.l lVar = eVar.f17403a;
            WorkDatabase workDatabase = lVar.f17427c;
            workDatabase.c();
            try {
                boolean a3 = a(eVar);
                workDatabase.h();
                if (a3) {
                    g.a(lVar.f17425a, RescheduleReceiver.class, true);
                    p2.d.a(lVar.f17426b, lVar.f17427c, lVar.e);
                }
                cVar.n(o2.s.O0);
            } finally {
                workDatabase.f();
            }
        } catch (Throwable th2) {
            cVar.n(new o2.p(th2));
        }
    }
}
