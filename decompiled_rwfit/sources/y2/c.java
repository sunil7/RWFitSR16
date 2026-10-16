package y2;

import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public abstract class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final o4.c f19944a = new o4.c(5);

    public static void a(p2.l lVar, String str) {
        WorkDatabase workDatabase = lVar.f17427c;
        p0.f n4 = workDatabase.n();
        o4.e i3 = workDatabase.i();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo$State f2 = n4.f(str2);
            if (f2 != WorkInfo$State.SUCCEEDED && f2 != WorkInfo$State.FAILED) {
                n4.m(WorkInfo$State.CANCELLED, str2);
            }
            linkedList.addAll(i3.b(str2));
        }
        p2.b bVar = lVar.f17429f;
        synchronized (bVar.f17400k) {
            try {
                o2.m.g().d(p2.b.f17390l, "Processor cancelling " + str, new Throwable[0]);
                bVar.f17398i.add(str);
                p2.m mVar = (p2.m) bVar.f17395f.remove(str);
                boolean z5 = mVar != null;
                if (mVar == null) {
                    mVar = (p2.m) bVar.f17396g.remove(str);
                }
                p2.b.c(str, mVar);
                if (z5) {
                    bVar.h();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it = lVar.e.iterator();
        while (it.hasNext()) {
            ((p2.c) it.next()).b(str);
        }
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        o4.c cVar = this.f19944a;
        try {
            b();
            cVar.n(o2.s.O0);
        } catch (Throwable th2) {
            cVar.n(new o2.p(th2));
        }
    }
}
