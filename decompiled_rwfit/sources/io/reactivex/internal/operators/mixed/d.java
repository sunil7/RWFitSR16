package io.reactivex.internal.operators.mixed;

import com.google.android.gms.internal.mlkit_vision_barcode.bd;
import rg.l;
import vg.o;

/* loaded from: classes2.dex */
public final class d extends rg.a {

    /* renamed from: a, reason: collision with root package name */
    public final l f14502a;

    /* renamed from: b, reason: collision with root package name */
    public final o f14503b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14504c;

    public d(l lVar, o oVar, boolean z5) {
        this.f14502a = lVar;
        this.f14503b = oVar;
        this.f14504c = z5;
    }

    @Override // rg.a
    public final void c(rg.b bVar) {
        l lVar = this.f14502a;
        o oVar = this.f14503b;
        if (bd.a(lVar, oVar, bVar)) {
            return;
        }
        lVar.subscribe(new c(bVar, oVar, this.f14504c));
    }
}
