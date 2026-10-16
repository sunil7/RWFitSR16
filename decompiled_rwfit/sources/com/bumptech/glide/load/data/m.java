package com.bumptech.glide.load.data;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class m implements f {

    /* renamed from: a, reason: collision with root package name */
    public final a4.g f6979a;

    public m(a4.g gVar) {
        this.f6979a = gVar;
    }

    @Override // com.bumptech.glide.load.data.f
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.f
    public final g b(Object obj) {
        return new i((InputStream) obj, this.f6979a);
    }
}
