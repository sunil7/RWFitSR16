package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.kb;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11043f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractMapBasedMultiset f11044g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(AbstractMapBasedMultiset abstractMapBasedMultiset, int i3) {
        super(abstractMapBasedMultiset);
        this.f11043f = i3;
        this.f11044g = abstractMapBasedMultiset;
    }

    @Override // com.google.common.collect.c
    public final Object b(int i3) {
        switch (this.f11043f) {
            case 0:
                w1 w1Var = this.f11044g.backingMap;
                kb.d(i3, w1Var.f11141c);
                return w1Var.f11139a[i3];
            default:
                w1 w1Var2 = this.f11044g.backingMap;
                kb.d(i3, w1Var2.f11141c);
                return new v1(w1Var2, i3);
        }
    }
}
