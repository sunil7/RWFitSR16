package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl, reason: invalid class name */
/* loaded from: classes.dex */
final class C$Gson$Types$WildcardTypeImpl implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type lowerBound;
    private final Type upperBound;

    public C$Gson$Types$WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
        a.c(typeArr2.length <= 1);
        a.c(typeArr.length == 1);
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            a.d(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = a.b(typeArr[0]);
            return;
        }
        typeArr2[0].getClass();
        a.d(typeArr2[0]);
        a.c(typeArr[0] == Object.class);
        this.lowerBound = a.b(typeArr2[0]);
        this.upperBound = Object.class;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && a.e(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.lowerBound;
        return type != null ? new Type[]{type} : a.f11170a;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        return new Type[]{this.upperBound};
    }

    public int hashCode() {
        Type type = this.lowerBound;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
    }

    public String toString() {
        if (this.lowerBound != null) {
            return "? super " + a.j(this.lowerBound);
        }
        if (this.upperBound == Object.class) {
            return "?";
        }
        return "? extends " + a.j(this.upperBound);
    }
}
