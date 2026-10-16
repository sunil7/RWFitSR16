package ia;

import android.app.Application;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.internal.mlkit_vision_barcode.fe;
import com.google.android.gms.internal.mlkit_vision_barcode.jf;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import io.reactivex.internal.schedulers.p;
import io.reactivex.internal.schedulers.q;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import l1.h0;
import l1.z0;
import n.v0;
import o9.v;
import q9.n;
import q9.y;

/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14389a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14390b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14391c;

    public /* synthetic */ j(int i3, Object obj, Object obj2) {
        this.f14389a = i3;
        this.f14391c = obj;
        this.f14390b = obj2;
    }

    private final void a() {
        pb.l lVar = (pb.l) this.f14390b;
        vb.a aVar = (vb.a) this.f14391c;
        synchronized (lVar) {
            try {
                if (lVar.f17524b == null) {
                    lVar.f17523a.add(aVar);
                } else {
                    lVar.f17524b.add(aVar.get());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x013b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0177, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b() {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.j.b():void");
    }

    private final void c() {
        t5.a aVar = (t5.a) this.f14391c;
        boolean z5 = aVar.e;
        if (z5) {
            return;
        }
        if (aVar.f18528c && !z5) {
            synchronized (aVar.f18526a) {
                aVar.f18532h.a(new ArrayList(aVar.f18534j));
                aVar.f18534j.clear();
                aVar.f18535k.clear();
            }
        }
        ((Handler) this.f14390b).postDelayed(this, ((t5.a) this.f14391c).f18531g.m());
    }

    @Override // java.lang.Runnable
    public final void run() {
        q9.c cVar;
        Set set;
        pb.m mVar;
        int i3 = 0;
        ob.a aVar = null;
        q9.c cVar2 = null;
        try {
            switch (this.f14389a) {
                case 0:
                    synchronized (((i) this.f14391c).f14387c) {
                        try {
                            b bVar = (b) ((i) this.f14391c).f14388d;
                            if (bVar != null) {
                                bVar.j((f) this.f14390b);
                            }
                        } finally {
                        }
                    }
                    return;
                case 1:
                    synchronized (((i) this.f14391c).f14387c) {
                        try {
                            c cVar3 = (c) ((i) this.f14391c).f14388d;
                            if (cVar3 != null) {
                                Exception c9 = ((f) this.f14390b).c();
                                n.e(c9);
                                cVar3.w(c9);
                            }
                        } finally {
                        }
                    }
                    return;
                case 2:
                    synchronized (((i) this.f14391c).f14387c) {
                        try {
                            d dVar = (d) ((i) this.f14391c).f14388d;
                            if (dVar != null) {
                                dVar.onSuccess(((f) this.f14390b).d());
                            }
                        } finally {
                        }
                    }
                    return;
                case 3:
                    i iVar = (i) this.f14391c;
                    try {
                        m u10 = ((e) iVar.f14387c).u(((f) this.f14390b).d());
                        w.a aVar2 = h.f14384b;
                        u10.b(aVar2, iVar);
                        u10.a(aVar2, iVar);
                        u10.f14399b.f(new i(aVar2, (a) iVar));
                        u10.k();
                        return;
                    } catch (RuntimeExecutionException e) {
                        if (e.getCause() instanceof Exception) {
                            iVar.w((Exception) e.getCause());
                            return;
                        } else {
                            iVar.w(e);
                            return;
                        }
                    } catch (CancellationException unused) {
                        iVar.e();
                        return;
                    } catch (Exception e10) {
                        iVar.w(e10);
                        return;
                    }
                case 4:
                    m mVar2 = (m) this.f14390b;
                    try {
                        ((ff.l) this.f14391c).call();
                        mVar2.h(null);
                        return;
                    } catch (Exception e11) {
                        mVar2.g(e11);
                        return;
                    } catch (Throwable th2) {
                        mVar2.g(new RuntimeException(th2));
                        return;
                    }
                case 5:
                    ((p) this.f14390b).f15108d = true;
                    ((q) this.f14391c).f15109a.remove((p) this.f14390b);
                    return;
                case 6:
                    ArrayList arrayList = ((l6.j) this.f14391c).f15792a;
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    fe feVar = (fe) this.f14390b;
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    int size = arrayList2.size();
                    while (i3 < size) {
                        Object obj = arrayList2.get(i3);
                        i3++;
                        m6.a aVar3 = (m6.a) obj;
                        if (aVar3 != null) {
                            feVar.a(aVar3);
                        }
                    }
                    return;
                case 7:
                    p1.d dVar2 = ((SwipeDismissBehavior) this.f14391c).f10228a;
                    if (dVar2 == null || !dVar2.g()) {
                        return;
                    }
                    WeakHashMap weakHashMap = z0.f15748a;
                    h0.m((View) this.f14390b, this);
                    return;
                case 8:
                    ((mc.g) this.f14391c).j((f) this.f14390b);
                    return;
                case 9:
                    o4.c cVar4 = (o4.c) this.f14391c;
                    if (((ArrayList) cVar4.f16732a).isEmpty()) {
                        return;
                    }
                    jf jfVar = (jf) this.f14390b;
                    ArrayList arrayList3 = new ArrayList((ArrayList) cVar4.f16732a);
                    int size2 = arrayList3.size();
                    while (i3 < size2) {
                        Object obj2 = arrayList3.get(i3);
                        i3++;
                        i6.e eVar = (i6.e) obj2;
                        if (eVar != null) {
                            jfVar.a(eVar);
                        }
                    }
                    return;
                case 10:
                    v0 v0Var = (v0) this.f14391c;
                    o9.n nVar = (o9.n) ((o9.c) v0Var.f16310f).f16859j.get((o9.a) v0Var.f16308c);
                    if (nVar == null) {
                        return;
                    }
                    ConnectionResult connectionResult = (ConnectionResult) this.f14390b;
                    if (!connectionResult.k()) {
                        nVar.o(connectionResult, null);
                        return;
                    }
                    v0Var.f16306a = true;
                    com.google.android.gms.common.api.c cVar5 = (com.google.android.gms.common.api.c) v0Var.f16307b;
                    if (cVar5.n()) {
                        if (!v0Var.f16306a || (cVar = (q9.c) v0Var.f16309d) == null) {
                            return;
                        }
                        cVar5.l(cVar, (Set) v0Var.e);
                        return;
                    }
                    try {
                        cVar5.l(null, cVar5.c());
                        return;
                    } catch (SecurityException e12) {
                        Log.e("GoogleApiManager", "Failed to get service from broker. ", e12);
                        cVar5.e("Failed to get service from broker.");
                        nVar.o(new ConnectionResult(10), null);
                        return;
                    }
                case 11:
                    zak zakVar = (zak) this.f14390b;
                    ConnectionResult b3 = zakVar.b();
                    boolean k10 = b3.k();
                    v vVar = (v) this.f14391c;
                    if (k10) {
                        zav h4 = zakVar.h();
                        n.e(h4);
                        ConnectionResult b10 = h4.b();
                        if (!b10.k()) {
                            Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(b10)), new Exception());
                            vVar.f16901h.e(b10);
                            vVar.f16900g.m();
                            return;
                        }
                        v0 v0Var2 = vVar.f16901h;
                        IBinder iBinder = h4.f9136b;
                        if (iBinder != null) {
                            int i10 = q9.a.f17807b;
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                            cVar2 = queryLocalInterface instanceof q9.c ? (q9.c) queryLocalInterface : new y(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 2);
                        }
                        v0Var2.getClass();
                        if (cVar2 == null || (set = vVar.e) == null) {
                            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                            v0Var2.e(new ConnectionResult(4));
                        } else {
                            v0Var2.f16309d = cVar2;
                            v0Var2.e = set;
                            if (v0Var2.f16306a) {
                                ((com.google.android.gms.common.api.c) v0Var2.f16307b).l(cVar2, set);
                            }
                        }
                    } else {
                        vVar.f16901h.e(b3);
                    }
                    vVar.f16900g.m();
                    return;
                case 12:
                    ((View) this.f14390b).setLayoutParams((ViewGroup.LayoutParams) this.f14391c);
                    return;
                case 13:
                    pb.n nVar2 = (pb.n) this.f14390b;
                    vb.a aVar4 = (vb.a) this.f14391c;
                    if (nVar2.f17527b != pb.e.f17505c) {
                        throw new IllegalStateException("provide() can be called only once.");
                    }
                    synchronized (nVar2) {
                        mVar = nVar2.f17526a;
                        nVar2.f17526a = null;
                        nVar2.f17527b = aVar4;
                    }
                    mVar.getClass();
                    return;
                case 14:
                    a();
                    return;
                case 15:
                    o2.m g10 = o2.m.g();
                    String str = q2.a.f17737d;
                    x2.h hVar = (x2.h) this.f14390b;
                    g10.d(str, l0.n("Scheduling work ", hVar.f19749a), new Throwable[0]);
                    ((q2.a) this.f14391c).f17738a.d(hVar);
                    return;
                case 16:
                    b();
                    return;
                case 17:
                    c();
                    return;
                case 18:
                    ue.f fVar = (ue.f) this.f14391c;
                    ue.d dVar3 = (ue.d) fVar.f19070c.f16738b;
                    MessageSnapshot messageSnapshot = (MessageSnapshot) this.f14390b;
                    dVar3.g(messageSnapshot);
                    fVar.f19068a.remove(Integer.valueOf(messageSnapshot.h()));
                    return;
                case 19:
                    ArrayList arrayList4 = (ArrayList) this.f14390b;
                    int size3 = arrayList4.size();
                    while (i3 < size3) {
                        Object obj3 = arrayList4.get(i3);
                        i3++;
                        u2.b bVar2 = (u2.b) obj3;
                        Object obj4 = ((v2.d) this.f14391c).e;
                        bVar2.f18872b = obj4;
                        bVar2.d(bVar2.f18874d, obj4);
                    }
                    return;
                case 20:
                    View f2 = ((vf.a) this.f14391c).f();
                    ViewParent parent = f2.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(f2);
                    }
                    ((g) this.f14390b).a(null);
                    return;
                case 21:
                    vf.f fVar2 = (vf.f) this.f14391c;
                    CopyOnWriteArraySet copyOnWriteArraySet = fVar2.f19251m;
                    uf.m mVar3 = (uf.m) this.f14390b;
                    copyOnWriteArraySet.add(mVar3);
                    qf.d dVar4 = fVar2.f19250l;
                    if (dVar4 != null) {
                        mVar3.b(dVar4.f17940a.f11633a);
                    }
                    mVar3.a(fVar2.f19255q);
                    return;
                case 22:
                    vf.f fVar3 = (vf.f) this.f14391c;
                    qf.d dVar5 = fVar3.f19250l;
                    of.a aVar5 = (of.a) this.f14390b;
                    if (dVar5 != null) {
                        dVar5.f17943d = aVar5;
                    }
                    Iterator it = fVar3.f19251m.iterator();
                    while (it.hasNext()) {
                        ((uf.m) it.next()).a(aVar5);
                    }
                    return;
                case 23:
                    try {
                        x.b bVar3 = (x.b) this.f14391c;
                        Object b11 = x.i.b((ob.a) this.f14390b);
                        androidx.concurrent.futures.b bVar4 = bVar3.f19695b;
                        if (bVar4 != null) {
                            bVar4.a(b11);
                        }
                    } catch (CancellationException unused2) {
                        ((x.b) this.f14391c).cancel(false);
                    } catch (ExecutionException e13) {
                        x.b bVar5 = (x.b) this.f14391c;
                        Throwable cause = e13.getCause();
                        androidx.concurrent.futures.b bVar6 = bVar5.f19695b;
                        if (bVar6 != null) {
                            bVar6.b(cause);
                        }
                    }
                    return;
                case 24:
                    ((m5.c) this.f14390b).f15978f = this.f14391c;
                    return;
                case 25:
                    ((Application) this.f14390b).unregisterActivityLifecycleCallbacks((m5.c) this.f14391c);
                    return;
                case 26:
                    try {
                        Method method = y0.e.f19866d;
                        Object obj5 = this.f14391c;
                        Object obj6 = this.f14390b;
                        if (method != null) {
                            method.invoke(obj6, obj5, Boolean.FALSE, "AppCompat recreation");
                        } else {
                            y0.e.e.invoke(obj6, obj5, Boolean.FALSE);
                        }
                        return;
                    } catch (RuntimeException e14) {
                        if (e14.getClass() == RuntimeException.class && e14.getMessage() != null && e14.getMessage().startsWith("Unable to stop")) {
                            throw e14;
                        }
                        return;
                    } catch (Throwable th3) {
                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th3);
                        return;
                    }
                case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                    y2.i iVar2 = (y2.i) this.f14390b;
                    try {
                        ((Runnable) this.f14391c).run();
                        return;
                    } finally {
                        iVar2.a();
                    }
                default:
                    yh.j k11 = ((o4.e) this.f14390b).k();
                    if (k11 == null) {
                        throw new IllegalStateException("No pending post available");
                    }
                    ((yh.d) this.f14391c).c(k11);
                    return;
            }
        } finally {
            ((x.b) this.f14391c).f19693g = null;
        }
        ((x.b) this.f14391c).f19693g = null;
    }

    public /* synthetic */ j(Object obj, int i3, Object obj2, boolean z5) {
        this.f14389a = i3;
        this.f14390b = obj;
        this.f14391c = obj2;
    }

    public j(yh.d dVar) {
        this.f14389a = 28;
        this.f14391c = dVar;
        this.f14390b = new o4.e();
    }

    public j(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z5) {
        this.f14389a = 7;
        this.f14391c = swipeDismissBehavior;
        this.f14390b = view;
    }
}
