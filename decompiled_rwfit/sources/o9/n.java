package o9;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import n.g0;
import n.m0;
import n.v0;

/* loaded from: classes.dex */
public final class n implements com.google.android.gms.common.api.g, com.google.android.gms.common.api.h {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.api.c f16870b;

    /* renamed from: c, reason: collision with root package name */
    public final a f16871c;

    /* renamed from: d, reason: collision with root package name */
    public final o4.c f16872d;

    /* renamed from: g, reason: collision with root package name */
    public final int f16874g;

    /* renamed from: h, reason: collision with root package name */
    public final v f16875h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16876i;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f16880m;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f16869a = new LinkedList();
    public final HashSet e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f16873f = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f16877j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public ConnectionResult f16878k = null;

    /* renamed from: l, reason: collision with root package name */
    public int f16879l = 0;

    public n(c cVar, com.google.android.gms.common.api.f fVar) {
        this.f16880m = cVar;
        Looper looper = cVar.f16862m.getLooper();
        n.l a3 = fVar.a();
        g0 g0Var = new g0((m0.c) a3.f16245b, (String) a3.f16246c, (String) a3.f16247d);
        ga.b bVar = (ga.b) fVar.f9082c.f8773b;
        q9.n.e(bVar);
        com.google.android.gms.common.api.c a10 = bVar.a(fVar.f9080a, looper, g0Var, fVar.f9083d, this, this);
        String str = fVar.f9081b;
        if (str != null && (a10 instanceof com.google.android.gms.common.internal.a)) {
            ((com.google.android.gms.common.internal.a) a10).r = str;
        }
        if (str != null && (a10 instanceof g)) {
            r5.a.i(a10);
            throw null;
        }
        this.f16870b = a10;
        this.f16871c = fVar.e;
        this.f16872d = new o4.c(2);
        this.f16874g = fVar.f9084f;
        if (!a10.n()) {
            this.f16875h = null;
            return;
        }
        Context context = cVar.e;
        c5.b bVar2 = cVar.f16862m;
        n.l a11 = fVar.a();
        this.f16875h = new v(context, bVar2, new g0((m0.c) a11.f16245b, (String) a11.f16246c, (String) a11.f16247d));
    }

    public final void a(ConnectionResult connectionResult) {
        HashSet hashSet = this.e;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (q9.n.h(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                this.f16870b.j();
            }
            throw null;
        }
    }

    public final void b(Status status) {
        q9.n.b(this.f16880m.f16862m);
        c(status, null, false);
    }

    public final void c(Status status, RuntimeException runtimeException, boolean z5) {
        q9.n.b(this.f16880m.f16862m);
        if ((status == null) == (runtimeException == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f16869a.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            if (!z5 || qVar.f16883a == 2) {
                if (status != null) {
                    qVar.c(status);
                } else {
                    qVar.d(runtimeException);
                }
                it.remove();
            }
        }
    }

    public final void d() {
        LinkedList linkedList = this.f16869a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            q qVar = (q) arrayList.get(i3);
            if (!this.f16870b.b()) {
                return;
            }
            if (i(qVar)) {
                linkedList.remove(qVar);
            }
        }
    }

    public final void e() {
        c cVar = this.f16880m;
        q9.n.b(cVar.f16862m);
        this.f16878k = null;
        a(ConnectionResult.RESULT_SUCCESS);
        if (this.f16876i) {
            c5.b bVar = cVar.f16862m;
            a aVar = this.f16871c;
            bVar.removeMessages(11, aVar);
            cVar.f16862m.removeMessages(9, aVar);
            this.f16876i = false;
        }
        Iterator it = this.f16873f.values().iterator();
        if (it.hasNext()) {
            throw null;
        }
        d();
        h();
    }

    public final void f(int i3) {
        c cVar = this.f16880m;
        q9.n.b(cVar.f16862m);
        this.f16878k = null;
        this.f16876i = true;
        String k10 = this.f16870b.k();
        o4.c cVar2 = this.f16872d;
        cVar2.getClass();
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i3 == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i3 == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (k10 != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(k10);
        }
        cVar2.q(true, new Status(20, sb2.toString(), null, null));
        c5.b bVar = cVar.f16862m;
        a aVar = this.f16871c;
        bVar.sendMessageDelayed(Message.obtain(bVar, 9, aVar), 5000L);
        c5.b bVar2 = cVar.f16862m;
        bVar2.sendMessageDelayed(Message.obtain(bVar2, 11, aVar), 120000L);
        ((SparseIntArray) cVar.f16856g.f16732a).clear();
        Iterator it = this.f16873f.values().iterator();
        while (it.hasNext()) {
            ((u) it.next()).getClass();
        }
    }

    @Override // com.google.android.gms.common.api.g
    public final void g(int i3) {
        Looper myLooper = Looper.myLooper();
        c cVar = this.f16880m;
        if (myLooper == cVar.f16862m.getLooper()) {
            f(i3);
        } else {
            cVar.f16862m.post(new androidx.emoji2.text.i(i3, 6, this));
        }
    }

    public final void h() {
        c cVar = this.f16880m;
        c5.b bVar = cVar.f16862m;
        a aVar = this.f16871c;
        bVar.removeMessages(12, aVar);
        c5.b bVar2 = cVar.f16862m;
        bVar2.sendMessageDelayed(bVar2.obtainMessage(12, aVar), cVar.f16851a);
    }

    public final boolean i(q qVar) {
        Feature feature;
        if (qVar == null) {
            com.google.android.gms.common.api.c cVar = this.f16870b;
            qVar.f(this.f16872d, cVar.n());
            try {
                qVar.e(this);
                return true;
            } catch (DeadObjectException unused) {
                g(1);
                cVar.e("DeadObjectException thrown while running ApiCallRunner.");
            }
        } else {
            Feature[] b3 = qVar.b(this);
            if (b3 != null && b3.length != 0) {
                Feature[] i3 = this.f16870b.i();
                if (i3 == null) {
                    i3 = new Feature[0];
                }
                m0.b bVar = new m0.b(i3.length);
                for (Feature feature2 : i3) {
                    bVar.put(feature2.b(), Long.valueOf(feature2.h()));
                }
                int length = b3.length;
                for (int i10 = 0; i10 < length; i10++) {
                    feature = b3[i10];
                    Long l3 = (Long) bVar.getOrDefault(feature.b(), null);
                    if (l3 == null || l3.longValue() < feature.h()) {
                        break;
                    }
                }
            }
            feature = null;
            if (feature != null) {
                Log.w("GoogleApiManager", this.f16870b.getClass().getName() + " could not execute call because it requires feature (" + feature.b() + ", " + feature.h() + ").");
                if (!this.f16880m.f16863n || !qVar.a(this)) {
                    qVar.d(new UnsupportedApiCallException(feature));
                    return true;
                }
                o oVar = new o(this.f16871c, feature);
                int indexOf = this.f16877j.indexOf(oVar);
                if (indexOf >= 0) {
                    o oVar2 = (o) this.f16877j.get(indexOf);
                    this.f16880m.f16862m.removeMessages(15, oVar2);
                    c5.b bVar2 = this.f16880m.f16862m;
                    bVar2.sendMessageDelayed(Message.obtain(bVar2, 15, oVar2), 5000L);
                } else {
                    this.f16877j.add(oVar);
                    c5.b bVar3 = this.f16880m.f16862m;
                    bVar3.sendMessageDelayed(Message.obtain(bVar3, 15, oVar), 5000L);
                    c5.b bVar4 = this.f16880m.f16862m;
                    bVar4.sendMessageDelayed(Message.obtain(bVar4, 16, oVar), 120000L);
                    ConnectionResult connectionResult = new ConnectionResult(2, null);
                    if (!j(connectionResult)) {
                        this.f16880m.b(connectionResult, this.f16874g);
                    }
                }
                return false;
            }
            com.google.android.gms.common.api.c cVar2 = this.f16870b;
            qVar.f(this.f16872d, cVar2.n());
            try {
                qVar.e(this);
                return true;
            } catch (DeadObjectException unused2) {
                g(1);
                cVar2.e("DeadObjectException thrown while running ApiCallRunner.");
            }
        }
        return true;
    }

    public final boolean j(ConnectionResult connectionResult) {
        synchronized (c.f16850q) {
            this.f16880m.getClass();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.g
    public final void k() {
        Looper myLooper = Looper.myLooper();
        c cVar = this.f16880m;
        if (myLooper == cVar.f16862m.getLooper()) {
            e();
        } else {
            cVar.f16862m.post(new androidx.activity.e(this, 24));
        }
    }

    public final void l() {
        c cVar = this.f16880m;
        q9.n.b(cVar.f16862m);
        com.google.android.gms.common.api.c cVar2 = this.f16870b;
        if (cVar2.b() || cVar2.h()) {
            return;
        }
        try {
            o4.c cVar3 = cVar.f16856g;
            Context context = cVar.e;
            cVar3.getClass();
            q9.n.e(context);
            int g10 = cVar2.g();
            SparseIntArray sparseIntArray = (SparseIntArray) cVar3.f16732a;
            int i3 = sparseIntArray.get(g10, -1);
            if (i3 == -1) {
                i3 = 0;
                int i10 = 0;
                while (true) {
                    if (i10 >= sparseIntArray.size()) {
                        i3 = -1;
                        break;
                    }
                    int keyAt = sparseIntArray.keyAt(i10);
                    if (keyAt > g10 && sparseIntArray.get(keyAt) == 0) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i3 == -1) {
                    i3 = ((n9.b) cVar3.f16733b).c(context, g10);
                }
                sparseIntArray.put(g10, i3);
            }
            if (i3 != 0) {
                ConnectionResult connectionResult = new ConnectionResult(i3, null);
                Log.w("GoogleApiManager", "The service for " + cVar2.getClass().getName() + " is not available: " + connectionResult.toString());
                o(connectionResult, null);
                return;
            }
            v0 v0Var = new v0(cVar, cVar2, this.f16871c);
            if (cVar2.n()) {
                v vVar = this.f16875h;
                q9.n.e(vVar);
                ha.a aVar = vVar.f16900g;
                if (aVar != null) {
                    aVar.m();
                }
                Integer valueOf = Integer.valueOf(System.identityHashCode(vVar));
                g0 g0Var = vVar.f16899f;
                g0Var.f16178f = valueOf;
                c5.b bVar = vVar.f16897c;
                vVar.f16900g = (ha.a) vVar.f16898d.a(vVar.f16896b, bVar.getLooper(), g0Var, (ga.a) g0Var.e, vVar, vVar);
                vVar.f16901h = v0Var;
                Set set = vVar.e;
                if (set == null || set.isEmpty()) {
                    bVar.post(new androidx.activity.e(vVar, 26));
                } else {
                    ha.a aVar2 = vVar.f16900g;
                    aVar2.getClass();
                    aVar2.d(new q9.e(aVar2));
                }
            }
            try {
                cVar2.d(v0Var);
            } catch (SecurityException e) {
                o(new ConnectionResult(10), e);
            }
        } catch (IllegalStateException e10) {
            o(new ConnectionResult(10), e10);
        }
    }

    @Override // o9.h
    public final void m(ConnectionResult connectionResult) {
        o(connectionResult, null);
    }

    public final void n(q qVar) {
        q9.n.b(this.f16880m.f16862m);
        boolean b3 = this.f16870b.b();
        LinkedList linkedList = this.f16869a;
        if (b3) {
            if (i(qVar)) {
                h();
                return;
            } else {
                linkedList.add(qVar);
                return;
            }
        }
        linkedList.add(qVar);
        ConnectionResult connectionResult = this.f16878k;
        if (connectionResult == null || !connectionResult.j()) {
            l();
        } else {
            o(this.f16878k, null);
        }
    }

    public final void o(ConnectionResult connectionResult, RuntimeException runtimeException) {
        ha.a aVar;
        q9.n.b(this.f16880m.f16862m);
        v vVar = this.f16875h;
        if (vVar != null && (aVar = vVar.f16900g) != null) {
            aVar.m();
        }
        q9.n.b(this.f16880m.f16862m);
        this.f16878k = null;
        ((SparseIntArray) this.f16880m.f16856g.f16732a).clear();
        a(connectionResult);
        if ((this.f16870b instanceof s9.c) && connectionResult.b() != 24) {
            c cVar = this.f16880m;
            cVar.f16852b = true;
            c5.b bVar = cVar.f16862m;
            bVar.sendMessageDelayed(bVar.obtainMessage(19), Const.L_GPS_REBOOT_INTERVAL);
        }
        if (connectionResult.b() == 4) {
            b(c.f16849p);
            return;
        }
        if (this.f16869a.isEmpty()) {
            this.f16878k = connectionResult;
            return;
        }
        if (runtimeException != null) {
            q9.n.b(this.f16880m.f16862m);
            c(null, runtimeException, false);
            return;
        }
        if (!this.f16880m.f16863n) {
            b(c.c(this.f16871c, connectionResult));
            return;
        }
        c(c.c(this.f16871c, connectionResult), null, true);
        if (this.f16869a.isEmpty() || j(connectionResult) || this.f16880m.b(connectionResult, this.f16874g)) {
            return;
        }
        if (connectionResult.b() == 18) {
            this.f16876i = true;
        }
        if (!this.f16876i) {
            b(c.c(this.f16871c, connectionResult));
            return;
        }
        c cVar2 = this.f16880m;
        a aVar2 = this.f16871c;
        c5.b bVar2 = cVar2.f16862m;
        bVar2.sendMessageDelayed(Message.obtain(bVar2, 9, aVar2), 5000L);
    }

    public final void p(ConnectionResult connectionResult) {
        q9.n.b(this.f16880m.f16862m);
        com.google.android.gms.common.api.c cVar = this.f16870b;
        cVar.e("onSignInFailed for " + cVar.getClass().getName() + " with " + String.valueOf(connectionResult));
        o(connectionResult, null);
    }

    public final void q() {
        q9.n.b(this.f16880m.f16862m);
        Status status = c.f16848o;
        b(status);
        this.f16872d.q(false, status);
        for (f fVar : (f[]) this.f16873f.keySet().toArray(new f[0])) {
            n(new x(fVar, new ia.g()));
        }
        a(new ConnectionResult(4));
        com.google.android.gms.common.api.c cVar = this.f16870b;
        if (cVar.b()) {
            cVar.f(new m0(this, 6));
        }
    }
}
