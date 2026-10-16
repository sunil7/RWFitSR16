package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.EncodingException;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class k0 implements rb.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9373a;

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        switch (this.f9373a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                rb.d dVar = (rb.d) obj2;
                dVar.a(m0.f9414g, entry.getKey());
                dVar.a(m0.f9415h, entry.getValue());
                return;
            default:
                throw new EncodingException("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    }
}
