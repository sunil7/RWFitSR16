package com.dh.imagepick.preview.utils;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7148a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ oh.a f7149b;

    public /* synthetic */ b(oh.a aVar, int i3) {
        this.f7148a = i3;
        this.f7149b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7148a) {
            case 0:
                oh.a tmp0 = this.f7149b;
                kotlin.jvm.internal.e.f(tmp0, "$tmp0");
                tmp0.invoke();
                break;
            default:
                oh.a tmp02 = this.f7149b;
                kotlin.jvm.internal.e.f(tmp02, "$tmp0");
                tmp02.invoke();
                break;
        }
    }
}
