package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.EncodingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class h implements sb.a {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f9930a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f9931b;

    /* renamed from: c, reason: collision with root package name */
    public final f f9932c;

    public h(HashMap hashMap, HashMap hashMap2, f fVar) {
        this.f9930a = hashMap;
        this.f9931b = hashMap2;
        this.f9932c = fVar;
    }

    @Override // sb.a
    public /* bridge */ /* synthetic */ sb.a a(Class cls, rb.c cVar) {
        this.f9930a.put(cls, cVar);
        this.f9931b.remove(cls);
        return this;
    }

    public byte[] b(j7 j7Var) {
        g gVar;
        rb.c cVar;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HashMap hashMap = this.f9930a;
            gVar = new g(byteArrayOutputStream, hashMap, this.f9931b, this.f9932c);
            cVar = (rb.c) hashMap.get(j7.class);
        } catch (IOException unused) {
        }
        if (cVar == null) {
            throw new EncodingException("No encoder for ".concat(String.valueOf(j7.class)));
        }
        cVar.a(j7Var, gVar);
        return byteArrayOutputStream.toByteArray();
    }

    public h() {
        this.f9930a = new HashMap();
        this.f9931b = new HashMap();
        this.f9932c = f.f9905c;
    }
}
