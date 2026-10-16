package yb;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
public final class a implements com.google.gson.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20041a;

    public /* synthetic */ a(int i3) {
        this.f20041a = i3;
    }

    @Override // com.google.gson.l
    public final com.google.gson.k a(com.google.gson.e eVar, bc.a aVar) {
        switch (this.f20041a) {
            case 0:
                Type type = aVar.f3204b;
                boolean z5 = type instanceof GenericArrayType;
                if (!z5 && (!(type instanceof Class) || !((Class) type).isArray())) {
                    return null;
                }
                Type genericComponentType = z5 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
                return new b(eVar, eVar.c(new bc.a(genericComponentType)), com.google.gson.internal.a.g(genericComponentType));
            case 1:
                if (aVar.f3203a == Date.class) {
                    return new d();
                }
                return null;
            case 2:
                if (aVar.f3203a == Object.class) {
                    return new g(eVar);
                }
                return null;
            case 3:
                if (aVar.f3203a == java.sql.Date.class) {
                    return new k(0);
                }
                return null;
            case 4:
                if (aVar.f3203a == Time.class) {
                    return new k(1);
                }
                return null;
            case 5:
                if (aVar.f3203a != Timestamp.class) {
                    return null;
                }
                eVar.getClass();
                return new d(eVar.c(new bc.a(Date.class)));
            default:
                Class cls = aVar.f3203a;
                if (!Enum.class.isAssignableFrom(cls) || cls == Enum.class) {
                    return null;
                }
                if (!cls.isEnum()) {
                    cls = cls.getSuperclass();
                }
                return new b(cls);
        }
    }
}
