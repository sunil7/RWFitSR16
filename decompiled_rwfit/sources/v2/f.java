package v2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import de.o;
import o2.m;

/* loaded from: classes.dex */
public final class f extends d {

    /* renamed from: i, reason: collision with root package name */
    public static final String f19140i = m.i("NetworkStateTracker");

    /* renamed from: g, reason: collision with root package name */
    public final ConnectivityManager f19141g;

    /* renamed from: h, reason: collision with root package name */
    public final e f19142h;

    public f(Context context, o oVar) {
        super(context, oVar);
        this.f19141g = (ConnectivityManager) this.f19136b.getSystemService("connectivity");
        this.f19142h = new e(this);
    }

    @Override // v2.d
    public final Object a() {
        return f();
    }

    @Override // v2.d
    public final void d() {
        String str = f19140i;
        try {
            m.g().d(str, "Registering network callback", new Throwable[0]);
            this.f19141g.registerDefaultNetworkCallback(this.f19142h);
        } catch (IllegalArgumentException | SecurityException e) {
            m.g().f(str, "Received exception while registering network callback", e);
        }
    }

    @Override // v2.d
    public final void e() {
        String str = f19140i;
        try {
            m.g().d(str, "Unregistering network callback", new Throwable[0]);
            this.f19141g.unregisterNetworkCallback(this.f19142h);
        } catch (IllegalArgumentException | SecurityException e) {
            m.g().f(str, "Received exception while unregistering network callback", e);
        }
    }

    public final t2.a f() {
        boolean z5;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.f19141g;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z6 = false;
        boolean z8 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        } catch (SecurityException e) {
            m.g().f(f19140i, "Unable to validate active network", e);
        }
        if (networkCapabilities != null) {
            if (networkCapabilities.hasCapability(16)) {
                z5 = true;
                boolean a3 = g1.a.a(connectivityManager);
                if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
                    z6 = true;
                }
                t2.a aVar = new t2.a();
                aVar.f18486a = z8;
                aVar.f18487b = z5;
                aVar.f18488c = a3;
                aVar.f18489d = z6;
                return aVar;
            }
        }
        z5 = false;
        boolean a32 = g1.a.a(connectivityManager);
        if (activeNetworkInfo != null) {
            z6 = true;
        }
        t2.a aVar2 = new t2.a();
        aVar2.f18486a = z8;
        aVar2.f18487b = z5;
        aVar2.f18488c = a32;
        aVar2.f18489d = z6;
        return aVar2;
    }
}
