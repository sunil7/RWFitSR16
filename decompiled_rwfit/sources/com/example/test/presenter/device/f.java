package com.example.test.presenter.device;

/* loaded from: classes.dex */
public final class f extends pe.p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f7426b;

    public f(g gVar) {
        this.f7426b = gVar;
    }

    @Override // pe.p
    public final void a(pe.b bVar) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseFilePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("下载完成 ", bVar != null ? bVar.b() : null));
        this.f7426b.q(bVar != null ? bVar.b() : null);
    }

    @Override // pe.p
    public final void b(pe.b bVar, Throwable th2) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseFilePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.p("下载失败：", bVar != null ? bVar.f17547d : null, " ", th2 != null ? th2.getMessage() : null));
        this.f7426b.o();
    }

    @Override // pe.p
    public final void c(pe.b bVar) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseFilePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("下载等待中：", bVar != null ? bVar.f17547d : null));
    }

    @Override // pe.p
    public final void d(int i3, int i10) {
        float f2 = (i3 / i10) * 100.0f;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseFilePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("下载中：", f2));
        this.f7426b.p(f2);
    }

    @Override // pe.p
    public final void e(pe.b bVar) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseFilePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.o("下载提示：", bVar != null ? bVar.f17547d : null, " "));
    }
}
