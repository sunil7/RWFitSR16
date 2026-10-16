package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import com.example.test.utils.y;
import ia.k;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import m4.m;
import t4.l;

/* loaded from: classes.dex */
public final class j implements ComponentCallbacks2, m4.g {

    /* renamed from: k, reason: collision with root package name */
    public static final p4.e f6944k;

    /* renamed from: a, reason: collision with root package name */
    public final b f6945a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f6946b;

    /* renamed from: c, reason: collision with root package name */
    public final m4.f f6947c;

    /* renamed from: d, reason: collision with root package name */
    public final k f6948d;
    public final m4.k e;

    /* renamed from: f, reason: collision with root package name */
    public final m f6949f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.activity.e f6950g;

    /* renamed from: h, reason: collision with root package name */
    public final m4.b f6951h;

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f6952i;

    /* renamed from: j, reason: collision with root package name */
    public final p4.e f6953j;

    static {
        p4.e eVar = (p4.e) new p4.e().c(Bitmap.class);
        eVar.f17463n = true;
        f6944k = eVar;
        ((p4.e) new p4.e().c(k4.c.class)).f17463n = true;
    }

    public j(b bVar, m4.f fVar, m4.k kVar, Context context) {
        p4.e eVar;
        int i3 = 9;
        k kVar2 = new k(1);
        hc.a aVar = bVar.f6913g;
        this.f6949f = new m();
        androidx.activity.e eVar2 = new androidx.activity.e(this, i3);
        this.f6950g = eVar2;
        this.f6945a = bVar;
        this.f6947c = fVar;
        this.e = kVar;
        this.f6948d = kVar2;
        this.f6946b = context;
        Context applicationContext = context.getApplicationContext();
        y yVar = new y(i3, this, kVar2);
        aVar.getClass();
        boolean z5 = a1.g.a(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z5 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        m4.b cVar = z5 ? new m4.c(applicationContext, yVar) : new m4.h();
        this.f6951h = cVar;
        char[] cArr = l.f18523a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            fVar.g(this);
        } else {
            l.e().post(eVar2);
        }
        fVar.g(cVar);
        this.f6952i = new CopyOnWriteArrayList(bVar.f6910c.e);
        f fVar2 = bVar.f6910c;
        synchronized (fVar2) {
            try {
                if (fVar2.f6924j == null) {
                    fVar2.f6919d.getClass();
                    p4.e eVar3 = new p4.e();
                    eVar3.f17463n = true;
                    fVar2.f6924j = eVar3;
                }
                eVar = fVar2.f6924j;
            } finally {
            }
        }
        synchronized (this) {
            p4.e eVar4 = (p4.e) eVar.clone();
            if (eVar4.f17463n && !eVar4.f17464o) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
            eVar4.f17464o = true;
            eVar4.f17463n = true;
            this.f6953j = eVar4;
        }
        synchronized (bVar.f6914h) {
            try {
                if (bVar.f6914h.contains(this)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                bVar.f6914h.add(this);
            } finally {
            }
        }
    }

    @Override // m4.g
    public final synchronized void i() {
        p();
        this.f6949f.i();
    }

    public final i j(Class cls) {
        return new i(this.f6945a, this, cls, this.f6946b);
    }

    public final void k(q4.g gVar) {
        if (gVar == null) {
            return;
        }
        boolean q5 = q(gVar);
        p4.c f2 = gVar.f();
        if (q5) {
            return;
        }
        b bVar = this.f6945a;
        synchronized (bVar.f6914h) {
            try {
                ArrayList arrayList = bVar.f6914h;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    if (((j) obj).q(gVar)) {
                        return;
                    }
                }
                if (f2 != null) {
                    gVar.d(null);
                    f2.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final i l(Bitmap bitmap) {
        return j(Drawable.class).z(bitmap).a((p4.e) new p4.e().d(z3.h.f20239b));
    }

    public final i m(Integer num) {
        PackageInfo packageInfo;
        i j4 = j(Drawable.class);
        i z5 = j4.z(num);
        ConcurrentHashMap concurrentHashMap = s4.b.f18207a;
        Context context = j4.r;
        String packageName = context.getPackageName();
        ConcurrentHashMap concurrentHashMap2 = s4.b.f18207a;
        x3.c cVar = (x3.c) concurrentHashMap2.get(packageName);
        if (cVar == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
                packageInfo = null;
            }
            s4.d dVar = new s4.d(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
            x3.c cVar2 = (x3.c) concurrentHashMap2.putIfAbsent(packageName, dVar);
            cVar = cVar2 == null ? dVar : cVar2;
        }
        return z5.a((p4.e) new p4.e().n(new s4.a(context.getResources().getConfiguration().uiMode & 48, cVar)));
    }

    public final i n(String str) {
        return j(Drawable.class).z(str);
    }

    public final synchronized void o() {
        k kVar = this.f6948d;
        kVar.f14393b = true;
        ArrayList d5 = l.d((Set) kVar.f14394c);
        int size = d5.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            p4.c cVar = (p4.c) obj;
            if (cVar.isRunning()) {
                cVar.f();
                ((ArrayList) kVar.f14395d).add(cVar);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // m4.g
    public final synchronized void onDestroy() {
        try {
            this.f6949f.onDestroy();
            ArrayList d5 = l.d(this.f6949f.f15967a);
            int size = d5.size();
            int i3 = 0;
            int i10 = 0;
            while (i10 < size) {
                Object obj = d5.get(i10);
                i10++;
                k((q4.g) obj);
            }
            this.f6949f.f15967a.clear();
            k kVar = this.f6948d;
            ArrayList d8 = l.d((Set) kVar.f14394c);
            int size2 = d8.size();
            while (i3 < size2) {
                Object obj2 = d8.get(i3);
                i3++;
                kVar.c((p4.c) obj2);
            }
            ((ArrayList) kVar.f14395d).clear();
            this.f6947c.b(this);
            this.f6947c.b(this.f6951h);
            l.e().removeCallbacks(this.f6950g);
            b bVar = this.f6945a;
            synchronized (bVar.f6914h) {
                if (!bVar.f6914h.contains(this)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                bVar.f6914h.remove(this);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // m4.g
    public final synchronized void onStop() {
        o();
        this.f6949f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
    }

    public final synchronized void p() {
        k kVar = this.f6948d;
        int i3 = 0;
        kVar.f14393b = false;
        ArrayList d5 = l.d((Set) kVar.f14394c);
        int size = d5.size();
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            p4.c cVar = (p4.c) obj;
            if (!cVar.i() && !cVar.isRunning()) {
                cVar.g();
            }
        }
        ((ArrayList) kVar.f14395d).clear();
    }

    public final synchronized boolean q(q4.g gVar) {
        p4.c f2 = gVar.f();
        if (f2 == null) {
            return true;
        }
        if (!this.f6948d.c(f2)) {
            return false;
        }
        this.f6949f.f15967a.remove(gVar);
        gVar.d(null);
        return true;
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f6948d + ", treeNode=" + this.e + "}";
    }
}
