package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: classes.dex */
public final class j extends g {

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f11198a;

    public j(Boolean bool) {
        bool.getClass();
        this.f11198a = bool;
    }

    public static boolean d(j jVar) {
        Serializable serializable = jVar.f11198a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final Number a() {
        Serializable serializable = this.f11198a;
        return serializable instanceof String ? new LazilyParsedNumber((String) serializable) : (Number) serializable;
    }

    public final String c() {
        Serializable serializable = this.f11198a;
        return serializable instanceof Number ? a().toString() : serializable instanceof Boolean ? ((Boolean) serializable).toString() : (String) serializable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        Serializable serializable = this.f11198a;
        Serializable serializable2 = jVar.f11198a;
        if (serializable == null) {
            return serializable2 == null;
        }
        if (d(this) && d(jVar)) {
            return a().longValue() == jVar.a().longValue();
        }
        if (!(serializable instanceof Number) || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        double doubleValue = a().doubleValue();
        double doubleValue2 = jVar.a().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public final int hashCode() {
        long doubleToLongBits;
        Serializable serializable = this.f11198a;
        if (serializable == null) {
            return 31;
        }
        if (d(this)) {
            doubleToLongBits = a().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
        }
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public j(Number number) {
        number.getClass();
        this.f11198a = number;
    }

    public j(String str) {
        str.getClass();
        this.f11198a = str;
    }
}
