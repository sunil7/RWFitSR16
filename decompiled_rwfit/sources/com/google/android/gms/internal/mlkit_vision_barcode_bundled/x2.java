package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public final class x2 extends h0 implements b1 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9847c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x2(int i3, l0 l0Var) {
        super(l0Var);
        this.f9847c = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.h0
    public /* bridge */ /* synthetic */ l0 c() {
        switch (this.f9847c) {
            case 0:
                return g();
            default:
                return super.c();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.h0
    public /* bridge */ /* synthetic */ a1 d() {
        switch (this.f9847c) {
            case 0:
                return g();
            default:
                return super.d();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.h0
    public void f() {
        switch (this.f9847c) {
            case 0:
                super.f();
                l0 l0Var = this.f9790b;
                if (((i0) l0Var).zzb != e0.f9773c) {
                    i0 i0Var = (i0) l0Var;
                    i0Var.zzb = i0Var.zzb.clone();
                    break;
                }
                break;
            default:
                super.f();
                break;
        }
    }

    public i0 g() {
        if (!((i0) this.f9790b).k()) {
            return (i0) this.f9790b;
        }
        ((i0) this.f9790b).zzb.d();
        return (i0) super.c();
    }
}
