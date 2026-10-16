package bc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Class f3203a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f3204b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3205c;

    public a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        Type b3 = com.google.gson.internal.a.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        this.f3204b = b3;
        this.f3203a = com.google.gson.internal.a.g(b3);
        this.f3205c = b3.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return com.google.gson.internal.a.e(this.f3204b, ((a) obj).f3204b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3205c;
    }

    public final String toString() {
        return com.google.gson.internal.a.j(this.f3204b);
    }

    public a(Type type) {
        type.getClass();
        Type b3 = com.google.gson.internal.a.b(type);
        this.f3204b = b3;
        this.f3203a = com.google.gson.internal.a.g(b3);
        this.f3205c = b3.hashCode();
    }
}
