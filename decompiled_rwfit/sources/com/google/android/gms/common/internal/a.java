package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import b2.j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import n.g0;
import n.m0;
import q9.b;
import q9.e;
import q9.i;
import q9.k;
import q9.m;
import q9.n;
import q9.p;
import q9.q;
import q9.r;
import q9.s;
import q9.t;
import q9.u;
import q9.x;

/* loaded from: classes.dex */
public abstract class a implements c {

    /* renamed from: x, reason: collision with root package name */
    public static final Feature[] f9112x = new Feature[0];

    /* renamed from: a, reason: collision with root package name */
    public volatile String f9113a;

    /* renamed from: b, reason: collision with root package name */
    public j f9114b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f9115c;

    /* renamed from: d, reason: collision with root package name */
    public final x f9116d;
    public final p e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f9117f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f9118g;

    /* renamed from: h, reason: collision with root package name */
    public m f9119h;

    /* renamed from: i, reason: collision with root package name */
    public b f9120i;

    /* renamed from: j, reason: collision with root package name */
    public IInterface f9121j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f9122k;

    /* renamed from: l, reason: collision with root package name */
    public r f9123l;

    /* renamed from: m, reason: collision with root package name */
    public int f9124m;

    /* renamed from: n, reason: collision with root package name */
    public final e f9125n;

    /* renamed from: o, reason: collision with root package name */
    public final i f9126o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9127p;

    /* renamed from: q, reason: collision with root package name */
    public final String f9128q;
    public volatile String r;

    /* renamed from: s, reason: collision with root package name */
    public ConnectionResult f9129s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f9130t;

    /* renamed from: u, reason: collision with root package name */
    public volatile zzk f9131u;

    /* renamed from: v, reason: collision with root package name */
    public final AtomicInteger f9132v;

    /* renamed from: w, reason: collision with root package name */
    public final Set f9133w;

    public a(Context context, Looper looper, int i3, g0 g0Var, g gVar, h hVar) {
        synchronized (x.f17852g) {
            try {
                if (x.f17853h == null) {
                    x.f17853h = new x(context.getMainLooper(), context.getApplicationContext());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        x xVar = x.f17853h;
        Object obj = n9.b.f16437c;
        n.e(gVar);
        n.e(hVar);
        e eVar = new e(gVar);
        i iVar = new i(hVar);
        String str = (String) g0Var.f16177d;
        this.f9113a = null;
        this.f9117f = new Object();
        this.f9118g = new Object();
        this.f9122k = new ArrayList();
        this.f9124m = 1;
        this.f9129s = null;
        this.f9130t = false;
        this.f9131u = null;
        this.f9132v = new AtomicInteger(0);
        n.f(context, "Context must not be null");
        this.f9115c = context;
        n.f(looper, "Looper must not be null");
        n.f(xVar, "Supervisor must not be null");
        this.f9116d = xVar;
        this.e = new p(this, looper);
        this.f9127p = i3;
        this.f9125n = eVar;
        this.f9126o = iVar;
        this.f9128q = str;
        Set set = (Set) g0Var.f16175b;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f9133w = set;
    }

    public static /* bridge */ /* synthetic */ boolean u(a aVar, int i3, int i10, IInterface iInterface) {
        synchronized (aVar.f9117f) {
            try {
                if (aVar.f9124m != i3) {
                    return false;
                }
                aVar.v(i10, iInterface);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract IInterface a(IBinder iBinder);

    @Override // com.google.android.gms.common.api.c
    public final boolean b() {
        boolean z5;
        synchronized (this.f9117f) {
            z5 = this.f9124m == 4;
        }
        return z5;
    }

    @Override // com.google.android.gms.common.api.c
    public final Set c() {
        return n() ? this.f9133w : Collections.EMPTY_SET;
    }

    @Override // com.google.android.gms.common.api.c
    public final void d(b bVar) {
        this.f9120i = bVar;
        v(2, null);
    }

    @Override // com.google.android.gms.common.api.c
    public final void e(String str) {
        this.f9113a = str;
        m();
    }

    @Override // com.google.android.gms.common.api.c
    public final void f(m0 m0Var) {
        ((o9.n) m0Var.f16254b).f16880m.f16862m.post(new androidx.activity.e(m0Var, 25));
    }

    @Override // com.google.android.gms.common.api.c
    public final boolean h() {
        boolean z5;
        synchronized (this.f9117f) {
            int i3 = this.f9124m;
            z5 = true;
            if (i3 != 2 && i3 != 3) {
                z5 = false;
            }
        }
        return z5;
    }

    @Override // com.google.android.gms.common.api.c
    public final Feature[] i() {
        zzk zzkVar = this.f9131u;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.f9140b;
    }

    @Override // com.google.android.gms.common.api.c
    public final void j() {
        if (!b() || this.f9114b == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final String k() {
        return this.f9113a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.c
    public final void l(q9.c cVar, Set set) {
        Bundle p8 = p();
        String str = this.r;
        int i3 = n9.c.f16439a;
        Scope[] scopeArr = GetServiceRequest.f9098n;
        Bundle bundle = new Bundle();
        int i10 = this.f9127p;
        Feature[] featureArr = GetServiceRequest.f9099o;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i10, i3, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f9103d = this.f9115c.getPackageName();
        getServiceRequest.f9105g = p8;
        if (set != null) {
            getServiceRequest.f9104f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (n()) {
            getServiceRequest.f9106h = new Account("<<default account>>", "com.google");
            if (cVar != 0) {
                getServiceRequest.e = ((com.google.android.gms.internal.mlkit_vision_barcode.a) cVar).f9200b;
            }
        }
        getServiceRequest.f9107i = f9112x;
        getServiceRequest.f9108j = o();
        if (this instanceof u9.g) {
            getServiceRequest.f9111m = true;
        }
        try {
            synchronized (this.f9118g) {
                try {
                    m mVar = this.f9119h;
                    if (mVar != null) {
                        mVar.g(new q(this, this.f9132v.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i11 = this.f9132v.get();
            p pVar = this.e;
            pVar.sendMessage(pVar.obtainMessage(6, i11, 3));
        } catch (RemoteException e10) {
            e = e10;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i12 = this.f9132v.get();
            s sVar = new s(this, 8, null, null);
            p pVar2 = this.e;
            pVar2.sendMessage(pVar2.obtainMessage(1, i12, -1, sVar));
        } catch (SecurityException e11) {
            throw e11;
        } catch (RuntimeException e12) {
            e = e12;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i122 = this.f9132v.get();
            s sVar2 = new s(this, 8, null, null);
            p pVar22 = this.e;
            pVar22.sendMessage(pVar22.obtainMessage(1, i122, -1, sVar2));
        }
    }

    @Override // com.google.android.gms.common.api.c
    public final void m() {
        this.f9132v.incrementAndGet();
        synchronized (this.f9122k) {
            try {
                int size = this.f9122k.size();
                for (int i3 = 0; i3 < size; i3++) {
                    k kVar = (k) this.f9122k.get(i3);
                    synchronized (kVar) {
                        kVar.f17823a = null;
                    }
                }
                this.f9122k.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (this.f9118g) {
            this.f9119h = null;
        }
        v(1, null);
    }

    @Override // com.google.android.gms.common.api.c
    public boolean n() {
        return false;
    }

    public Feature[] o() {
        return f9112x;
    }

    public Bundle p() {
        return new Bundle();
    }

    public final IInterface q() {
        IInterface iInterface;
        synchronized (this.f9117f) {
            try {
                if (this.f9124m == 5) {
                    throw new DeadObjectException();
                }
                if (!b()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.f9121j;
                n.f(iInterface, "Client is connected but service is null");
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iInterface;
    }

    public abstract String r();

    public abstract String s();

    public boolean t() {
        return g() >= 211700000;
    }

    public final void v(int i3, IInterface iInterface) {
        j jVar;
        if ((i3 == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f9117f) {
            try {
                this.f9124m = i3;
                this.f9121j = iInterface;
                if (i3 == 1) {
                    r rVar = this.f9123l;
                    if (rVar != null) {
                        x xVar = this.f9116d;
                        String str = this.f9114b.f3129a;
                        n.e(str);
                        this.f9114b.getClass();
                        if (this.f9128q == null) {
                            this.f9115c.getClass();
                        }
                        xVar.a(str, rVar, this.f9114b.f3130b);
                        this.f9123l = null;
                    }
                } else if (i3 == 2 || i3 == 3) {
                    r rVar2 = this.f9123l;
                    if (rVar2 != null && (jVar = this.f9114b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + jVar.f3129a + " on com.google.android.gms");
                        x xVar2 = this.f9116d;
                        String str2 = this.f9114b.f3129a;
                        n.e(str2);
                        this.f9114b.getClass();
                        if (this.f9128q == null) {
                            this.f9115c.getClass();
                        }
                        xVar2.a(str2, rVar2, this.f9114b.f3130b);
                        this.f9132v.incrementAndGet();
                    }
                    r rVar3 = new r(this, this.f9132v.get());
                    this.f9123l = rVar3;
                    String s7 = s();
                    boolean t8 = t();
                    this.f9114b = new j(s7, t8);
                    if (t8 && g() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f9114b.f3129a)));
                    }
                    x xVar3 = this.f9116d;
                    String str3 = this.f9114b.f3129a;
                    n.e(str3);
                    this.f9114b.getClass();
                    String str4 = this.f9128q;
                    if (str4 == null) {
                        str4 = this.f9115c.getClass().getName();
                    }
                    if (!xVar3.b(new u(str3, this.f9114b.f3130b), rVar3, str4)) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f9114b.f3129a + " on com.google.android.gms");
                        int i10 = this.f9132v.get();
                        t tVar = new t(this, 16);
                        p pVar = this.e;
                        pVar.sendMessage(pVar.obtainMessage(7, i10, -1, tVar));
                    }
                } else if (i3 == 4) {
                    n.e(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }
}
