package v2;

import android.content.Context;
import de.o;
import ia.j;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import o2.m;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: f, reason: collision with root package name */
    public static final String f19134f = m.i("ConstraintTracker");

    /* renamed from: a, reason: collision with root package name */
    public final o f19135a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f19136b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f19137c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f19138d = new LinkedHashSet();
    public Object e;

    public d(Context context, o oVar) {
        this.f19136b = context.getApplicationContext();
        this.f19135a = oVar;
    }

    public abstract Object a();

    public final void b(u2.b bVar) {
        synchronized (this.f19137c) {
            try {
                if (this.f19138d.remove(bVar) && this.f19138d.isEmpty()) {
                    e();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c(Object obj) {
        synchronized (this.f19137c) {
            try {
                Object obj2 = this.e;
                if (obj2 != obj && (obj2 == null || !obj2.equals(obj))) {
                    this.e = obj;
                    ((w.d) this.f19135a.f12379d).execute(new j(19, this, new ArrayList(this.f19138d)));
                }
            } finally {
            }
        }
    }

    public abstract void d();

    public abstract void e();
}
