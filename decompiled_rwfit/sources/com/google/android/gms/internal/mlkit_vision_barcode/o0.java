package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.EncodingException;

/* loaded from: classes.dex */
public final class o0 implements rb.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9453a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9454b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9455c = false;

    /* renamed from: d, reason: collision with root package name */
    public rb.b f9456d;
    public final rb.d e;

    public /* synthetic */ o0(rb.d dVar, int i3) {
        this.f9453a = i3;
        this.e = dVar;
    }

    @Override // rb.f
    public final rb.f b(String str) {
        switch (this.f9453a) {
            case 0:
                if (this.f9454b) {
                    throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
                }
                this.f9454b = true;
                ((m0) this.e).b(this.f9456d, str, this.f9455c);
                return this;
            default:
                if (this.f9454b) {
                    throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
                }
                this.f9454b = true;
                ((com.google.android.gms.internal.mlkit_vision_common.g) this.e).b(this.f9456d, str, this.f9455c);
                return this;
        }
    }

    @Override // rb.f
    public final rb.f c(boolean z5) {
        switch (this.f9453a) {
            case 0:
                if (this.f9454b) {
                    throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
                }
                this.f9454b = true;
                ((m0) this.e).c(this.f9456d, z5 ? 1 : 0, this.f9455c);
                return this;
            default:
                if (this.f9454b) {
                    throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
                }
                this.f9454b = true;
                ((com.google.android.gms.internal.mlkit_vision_common.g) this.e).c(this.f9456d, z5 ? 1 : 0, this.f9455c);
                return this;
        }
    }
}
