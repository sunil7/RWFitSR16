package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.EncodingException;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements rb.c {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ f f9904b = new f(0);

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ f f9905c = new f(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9906a;

    public /* synthetic */ f(int i3) {
        this.f9906a = i3;
    }

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        switch (this.f9906a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                rb.d dVar = (rb.d) obj2;
                Charset charset = g.f9917f;
                dVar.a(g.f9918g, entry.getKey());
                dVar.a(g.f9919h, entry.getValue());
                return;
            default:
                throw new EncodingException("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    }
}
