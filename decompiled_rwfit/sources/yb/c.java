package yb;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes.dex */
public final class c implements com.google.gson.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20046a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f20047b;

    public /* synthetic */ c(Object obj, int i3) {
        this.f20046a = i3;
        this.f20047b = obj;
    }

    public static com.google.gson.k b(ef.i iVar, com.google.gson.e eVar, bc.a aVar, xb.a aVar2) {
        com.google.gson.k a3;
        Object t8 = iVar.s(new bc.a(aVar2.value())).t();
        if (t8 instanceof com.google.gson.k) {
            a3 = (com.google.gson.k) t8;
        } else {
            if (!(t8 instanceof com.google.gson.l)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + t8.getClass().getName() + " as a @JsonAdapter for " + com.google.gson.internal.a.j(aVar.f3204b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            a3 = ((com.google.gson.l) t8).a(eVar, aVar);
        }
        return (a3 == null || !aVar2.nullSafe()) ? a3 : new com.google.gson.c(a3, 2);
    }

    @Override // com.google.gson.l
    public final com.google.gson.k a(com.google.gson.e eVar, bc.a aVar) {
        Class cls;
        Type[] actualTypeArguments;
        cls = Object.class;
        Object obj = this.f20047b;
        switch (this.f20046a) {
            case 0:
                Class cls2 = aVar.f3203a;
                if (!Collection.class.isAssignableFrom(cls2)) {
                    return null;
                }
                Type type = aVar.f3204b;
                if (type instanceof WildcardType) {
                    type = ((WildcardType) type).getUpperBounds()[0];
                }
                com.google.gson.internal.a.c(Collection.class.isAssignableFrom(cls2));
                Type i3 = com.google.gson.internal.a.i(type, cls2, com.google.gson.internal.a.f(type, cls2, Collection.class), new HashSet());
                if (i3 instanceof WildcardType) {
                    i3 = ((WildcardType) i3).getUpperBounds()[0];
                }
                cls = i3 instanceof ParameterizedType ? ((ParameterizedType) i3).getActualTypeArguments()[0] : Object.class;
                return new b(eVar, cls, eVar.c(new bc.a(cls)), ((ef.i) obj).s(aVar));
            case 1:
                xb.a aVar2 = (xb.a) aVar.f3203a.getAnnotation(xb.a.class);
                if (aVar2 == null) {
                    return null;
                }
                return b((ef.i) obj, eVar, aVar, aVar2);
            case 2:
                if (!Map.class.isAssignableFrom(aVar.f3203a)) {
                    return null;
                }
                Type type2 = aVar.f3204b;
                Class g10 = com.google.gson.internal.a.g(type2);
                if (type2 == Properties.class) {
                    actualTypeArguments = new Type[]{String.class, String.class};
                } else {
                    if (type2 instanceof WildcardType) {
                        type2 = ((WildcardType) type2).getUpperBounds()[0];
                    }
                    com.google.gson.internal.a.c(Map.class.isAssignableFrom(g10));
                    Type i10 = com.google.gson.internal.a.i(type2, g10, com.google.gson.internal.a.f(type2, g10, Map.class), new HashSet());
                    actualTypeArguments = i10 instanceof ParameterizedType ? ((ParameterizedType) i10).getActualTypeArguments() : new Type[]{cls, cls};
                }
                Type type3 = actualTypeArguments[0];
                return new e(this, eVar, actualTypeArguments[0], (type3 == Boolean.TYPE || type3 == Boolean.class) ? p.f20088c : eVar.c(new bc.a(type3)), actualTypeArguments[1], eVar.c(new bc.a(actualTypeArguments[1])), ((ef.i) obj).s(aVar));
            default:
                Class cls3 = aVar.f3203a;
                if (cls3 == Calendar.class || cls3 == GregorianCalendar.class) {
                    return (com.google.gson.b) obj;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f20046a) {
            case 3:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((com.google.gson.b) this.f20047b) + "]";
            default:
                return super.toString();
        }
    }
}
