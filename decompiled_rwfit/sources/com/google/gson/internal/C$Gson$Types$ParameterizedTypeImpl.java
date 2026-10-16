package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl, reason: invalid class name */
/* loaded from: classes.dex */
final class C$Gson$Types$ParameterizedTypeImpl implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;

    public C$Gson$Types$ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z5 = true;
            boolean z6 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
            if (type == null && !z6) {
                z5 = false;
            }
            a.c(z5);
        }
        this.ownerType = type == null ? null : a.b(type);
        this.rawType = a.b(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.typeArguments = typeArr2;
        int length = typeArr2.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.typeArguments[i3].getClass();
            a.d(this.typeArguments[i3]);
            Type[] typeArr3 = this.typeArguments;
            typeArr3[i3] = a.b(typeArr3[i3]);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && a.e(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return (Type[]) this.typeArguments.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
        Type type = this.ownerType;
        return hashCode ^ (type != null ? type.hashCode() : 0);
    }

    public String toString() {
        int length = this.typeArguments.length;
        if (length == 0) {
            return a.j(this.rawType);
        }
        StringBuilder sb2 = new StringBuilder((length + 1) * 30);
        sb2.append(a.j(this.rawType));
        sb2.append("<");
        sb2.append(a.j(this.typeArguments[0]));
        for (int i3 = 1; i3 < length; i3++) {
            sb2.append(", ");
            sb2.append(a.j(this.typeArguments[i3]));
        }
        sb2.append(">");
        return sb2.toString();
    }
}
