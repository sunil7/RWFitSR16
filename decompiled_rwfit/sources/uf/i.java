package uf;

import android.hardware.Camera;

/* loaded from: classes2.dex */
public final class i extends p {
    public ff.e e;

    /* renamed from: f, reason: collision with root package name */
    public Camera f19081f;

    /* renamed from: g, reason: collision with root package name */
    public wf.a f19082g;

    /* renamed from: h, reason: collision with root package name */
    public int f19083h;

    @Override // ab.n
    public final void n() {
        this.e = null;
        this.f19081f = null;
        this.f19082g = null;
        this.f19083h = 0;
        super.n();
    }

    @Override // ab.n
    public final void u() {
        this.f19081f.setOneShotPreviewCallback(new h(this));
    }
}
