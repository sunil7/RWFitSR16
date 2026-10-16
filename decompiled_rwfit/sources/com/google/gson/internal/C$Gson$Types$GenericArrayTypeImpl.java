package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl, reason: invalid class name */
/* loaded from: classes.dex */
final class C$Gson$Types$GenericArrayTypeImpl implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type componentType;

    public C$Gson$Types$GenericArrayTypeImpl(Type type) {
        this.componentType = a.b(type);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && a.e(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.componentType;
    }

    public int hashCode() {
        return this.componentType.hashCode();
    }

    public String toString() {
        return a.j(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }
}
