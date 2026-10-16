package io.reactivex.internal.operators.mixed;

import com.google.android.gms.internal.mlkit_vision_barcode.bd;
import io.reactivex.internal.util.ErrorMode;
import rg.l;
import vg.o;

/* loaded from: classes2.dex */
public final class a extends rg.a {

    /* renamed from: a, reason: collision with root package name */
    public final l f14487a;

    /* renamed from: b, reason: collision with root package name */
    public final o f14488b;

    /* renamed from: c, reason: collision with root package name */
    public final ErrorMode f14489c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14490d;

    public a(l lVar, o oVar, ErrorMode errorMode, int i3) {
        this.f14487a = lVar;
        this.f14488b = oVar;
        this.f14489c = errorMode;
        this.f14490d = i3;
    }

    @Override // rg.a
    public final void c(rg.b bVar) {
        l lVar = this.f14487a;
        o oVar = this.f14488b;
        if (bd.a(lVar, oVar, bVar)) {
            return;
        }
        lVar.subscribe(new ObservableConcatMapCompletable$ConcatMapCompletableObserver(bVar, oVar, this.f14489c, this.f14490d));
    }
}
