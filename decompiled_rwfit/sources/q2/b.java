package q2;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.work.WorkInfo$State;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import de.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import n.m0;
import o2.m;
import p2.c;
import p2.l;
import x2.h;
import y2.j;

/* loaded from: classes.dex */
public final class b implements c, t2.b, p2.a {

    /* renamed from: i, reason: collision with root package name */
    public static final String f17741i = m.i("GreedyScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f17742a;

    /* renamed from: b, reason: collision with root package name */
    public final l f17743b;

    /* renamed from: c, reason: collision with root package name */
    public final t2.c f17744c;
    public final a e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17746f;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f17748h;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f17745d = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public final Object f17747g = new Object();

    public b(Context context, o2.b bVar, o oVar, l lVar) {
        this.f17742a = context;
        this.f17743b = lVar;
        this.f17744c = new t2.c(context, oVar, this);
        this.e = new a(this, bVar.e);
    }

    @Override // p2.a
    public final void a(String str, boolean z5) {
        synchronized (this.f17747g) {
            try {
                Iterator it = this.f17745d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h hVar = (h) it.next();
                    if (hVar.f19749a.equals(str)) {
                        m.g().d(f17741i, "Stopping tracking for " + str, new Throwable[0]);
                        this.f17745d.remove(hVar);
                        this.f17744c.b(this.f17745d);
                        break;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p2.c
    public final void b(String str) {
        Runnable runnable;
        Boolean bool = this.f17748h;
        l lVar = this.f17743b;
        if (bool == null) {
            this.f17748h = Boolean.valueOf(y2.h.a(this.f17742a, lVar.f17426b));
        }
        boolean booleanValue = this.f17748h.booleanValue();
        String str2 = f17741i;
        if (!booleanValue) {
            m.g().h(str2, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.f17746f) {
            lVar.f17429f.b(this);
            this.f17746f = true;
        }
        m.g().d(str2, l0.n("Cancelling work ID ", str), new Throwable[0]);
        a aVar = this.e;
        if (aVar != null && (runnable = (Runnable) aVar.f17740c.remove(str)) != null) {
            ((Handler) aVar.f17739b.f16254b).removeCallbacks(runnable);
        }
        lVar.f17428d.p(new j(lVar, str, false));
    }

    @Override // t2.b
    public final void c(ArrayList arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str = (String) obj;
            m.g().d(f17741i, l0.n("Constraints not met: Cancelling work ID ", str), new Throwable[0]);
            l lVar = this.f17743b;
            lVar.f17428d.p(new j(lVar, str, false));
        }
    }

    @Override // p2.c
    public final void d(h... hVarArr) {
        if (this.f17748h == null) {
            this.f17748h = Boolean.valueOf(y2.h.a(this.f17742a, this.f17743b.f17426b));
        }
        if (!this.f17748h.booleanValue()) {
            m.g().h(f17741i, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.f17746f) {
            this.f17743b.f17429f.b(this);
            this.f17746f = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (h hVar : hVarArr) {
            long a3 = hVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (hVar.f19750b == WorkInfo$State.ENQUEUED) {
                if (currentTimeMillis < a3) {
                    a aVar = this.e;
                    if (aVar != null) {
                        HashMap hashMap = aVar.f17740c;
                        Runnable runnable = (Runnable) hashMap.remove(hVar.f19749a);
                        m0 m0Var = aVar.f17739b;
                        if (runnable != null) {
                            ((Handler) m0Var.f16254b).removeCallbacks(runnable);
                        }
                        ia.j jVar = new ia.j(15, aVar, hVar);
                        hashMap.put(hVar.f19749a, jVar);
                        ((Handler) m0Var.f16254b).postDelayed(jVar, hVar.a() - System.currentTimeMillis());
                    }
                } else if (hVar.b()) {
                    o2.c cVar = hVar.f19757j;
                    if (cVar.f16701c) {
                        m.g().d(f17741i, "Ignoring WorkSpec " + hVar + ", Requires device idle.", new Throwable[0]);
                    } else if (cVar.f16705h.f16708a.size() > 0) {
                        m.g().d(f17741i, "Ignoring WorkSpec " + hVar + ", Requires ContentUri triggers.", new Throwable[0]);
                    } else {
                        hashSet.add(hVar);
                        hashSet2.add(hVar.f19749a);
                    }
                } else {
                    m.g().d(f17741i, l0.n("Starting work for ", hVar.f19749a), new Throwable[0]);
                    this.f17743b.d(hVar.f19749a, null);
                }
            }
        }
        synchronized (this.f17747g) {
            try {
                if (!hashSet.isEmpty()) {
                    m.g().d(f17741i, "Starting tracking for [" + TextUtils.join(Const.STR_MART_COMMA, hashSet2) + "]", new Throwable[0]);
                    this.f17745d.addAll(hashSet);
                    this.f17744c.b(this.f17745d);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // t2.b
    public final void e(List list) {
        ArrayList arrayList = (ArrayList) list;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str = (String) obj;
            m.g().d(f17741i, l0.n("Constraints met: Scheduling work ID ", str), new Throwable[0]);
            this.f17743b.d(str, null);
        }
    }

    @Override // p2.c
    public final boolean f() {
        return false;
    }
}
