package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.EncodingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class n0 implements sb.a {

    /* renamed from: d, reason: collision with root package name */
    public static final k0 f9440d = new k0(1);

    /* renamed from: a, reason: collision with root package name */
    public Object f9441a;

    /* renamed from: b, reason: collision with root package name */
    public Serializable f9442b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9443c;

    @Override // sb.a
    public /* bridge */ /* synthetic */ sb.a a(Class cls, rb.c cVar) {
        ((HashMap) this.f9441a).put(cls, cVar);
        ((HashMap) this.f9442b).remove(cls);
        return this;
    }

    public byte[] b(sb sbVar) {
        m0 m0Var;
        rb.c cVar;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HashMap hashMap = (HashMap) this.f9441a;
            m0Var = new m0(byteArrayOutputStream, hashMap, (HashMap) this.f9442b, (k0) this.f9443c);
            cVar = (rb.c) hashMap.get(sb.class);
        } catch (IOException unused) {
        }
        if (cVar == null) {
            throw new EncodingException("No encoder for ".concat(String.valueOf(sb.class)));
        }
        cVar.a(sbVar, m0Var);
        return byteArrayOutputStream.toByteArray();
    }
}
