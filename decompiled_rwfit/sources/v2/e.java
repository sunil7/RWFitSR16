package v2;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import o2.m;

/* loaded from: classes.dex */
public final class e extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f19139a;

    public e(f fVar) {
        this.f19139a = fVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        m.g().d(f.f19140i, "Network capabilities changed: " + networkCapabilities, new Throwable[0]);
        f fVar = this.f19139a;
        fVar.c(fVar.f());
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        m.g().d(f.f19140i, "Network connection lost", new Throwable[0]);
        f fVar = this.f19139a;
        fVar.c(fVar.f());
    }
}
