package t2;

import android.content.Context;
import de.o;
import java.util.ArrayList;
import java.util.Collection;
import o2.m;
import u2.d;
import v2.f;
import v2.g;
import v2.h;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final String f18490d = m.i("WorkConstraintsTracker");

    /* renamed from: a, reason: collision with root package name */
    public final b f18491a;

    /* renamed from: b, reason: collision with root package name */
    public final u2.b[] f18492b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f18493c;

    public c(Context context, o oVar, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f18491a = bVar;
        this.f18492b = new u2.b[]{new u2.a((v2.a) h.j(applicationContext, oVar).f19146a, 0), new u2.a((v2.b) h.j(applicationContext, oVar).f19147b, 1), new u2.a((g) h.j(applicationContext, oVar).f19149d, 4), new u2.a((f) h.j(applicationContext, oVar).f19148c, 2), new u2.a((f) h.j(applicationContext, oVar).f19148c, 3), new d((f) h.j(applicationContext, oVar).f19148c), new u2.c((f) h.j(applicationContext, oVar).f19148c)};
        this.f18493c = new Object();
    }

    public final boolean a(String str) {
        synchronized (this.f18493c) {
            try {
                for (u2.b bVar : this.f18492b) {
                    Object obj = bVar.f18872b;
                    if (obj != null && bVar.b(obj) && bVar.f18871a.contains(str)) {
                        m.g().d(f18490d, "Work " + str + " constrained by " + bVar.getClass().getSimpleName(), new Throwable[0]);
                        return false;
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b(Collection collection) {
        synchronized (this.f18493c) {
            try {
                for (u2.b bVar : this.f18492b) {
                    if (bVar.f18874d != null) {
                        bVar.f18874d = null;
                        bVar.d(null, bVar.f18872b);
                    }
                }
                for (u2.b bVar2 : this.f18492b) {
                    bVar2.c(collection);
                }
                for (u2.b bVar3 : this.f18492b) {
                    if (bVar3.f18874d != this) {
                        bVar3.f18874d = this;
                        bVar3.d(this, bVar3.f18872b);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        synchronized (this.f18493c) {
            try {
                for (u2.b bVar : this.f18492b) {
                    ArrayList arrayList = bVar.f18871a;
                    if (!arrayList.isEmpty()) {
                        arrayList.clear();
                        bVar.f18873c.b(bVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
