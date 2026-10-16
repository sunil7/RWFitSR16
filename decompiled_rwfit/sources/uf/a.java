package uf;

import android.hardware.Camera;

/* loaded from: classes2.dex */
public final class a implements Camera.ShutterCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f19071a;

    public a(c cVar) {
        this.f19071a = cVar;
    }

    @Override // android.hardware.Camera.ShutterCallback
    public final void onShutter() {
        f.f19079d.b(1, "take(): got onShutter callback.");
        this.f19071a.m(true);
    }
}
