package yb;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b extends com.google.gson.k {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20042d = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20043a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f20044b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f20045c;

    public b(com.google.gson.e eVar, com.google.gson.k kVar, Class cls) {
        this.f20043a = 0;
        this.f20044b = new l(eVar, kVar, cls);
        this.f20045c = cls;
    }

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        switch (this.f20043a) {
            case 0:
                if (aVar.b0() == JsonToken.NULL) {
                    aVar.X();
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                aVar.b();
                while (aVar.j()) {
                    arrayList.add(((l) this.f20044b).f20077b.a(aVar));
                }
                aVar.g();
                int size = arrayList.size();
                Object newInstance = Array.newInstance((Class<?>) this.f20045c, size);
                for (int i3 = 0; i3 < size; i3++) {
                    Array.set(newInstance, i3, arrayList.get(i3));
                }
                return newInstance;
            case 1:
                if (aVar.b0() == JsonToken.NULL) {
                    aVar.X();
                    return null;
                }
                Collection collection = (Collection) ((com.google.gson.internal.i) this.f20045c).t();
                aVar.b();
                while (aVar.j()) {
                    collection.add(((l) this.f20044b).f20077b.a(aVar));
                }
                aVar.g();
                return collection;
            case 2:
                Object a3 = ((m) this.f20044b).f20081c.a(aVar);
                if (a3 != null) {
                    Class cls = (Class) this.f20045c;
                    if (!cls.isInstance(a3)) {
                        throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + a3.getClass().getName());
                    }
                }
                return a3;
            default:
                if (aVar.b0() != JsonToken.NULL) {
                    return (Enum) ((HashMap) this.f20045c).get(aVar.Z());
                }
                aVar.X();
                return null;
        }
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        switch (this.f20043a) {
            case 0:
                if (obj == null) {
                    bVar.k();
                    break;
                } else {
                    bVar.c();
                    int length = Array.getLength(obj);
                    for (int i3 = 0; i3 < length; i3++) {
                        ((l) this.f20044b).b(bVar, Array.get(obj, i3));
                    }
                    bVar.g();
                    break;
                }
            case 1:
                Collection collection = (Collection) obj;
                if (collection == null) {
                    bVar.k();
                    break;
                } else {
                    bVar.c();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((l) this.f20044b).b(bVar, it.next());
                    }
                    bVar.g();
                    break;
                }
            case 2:
                ((m) this.f20044b).f20081c.b(bVar, obj);
                break;
            default:
                Enum r62 = (Enum) obj;
                bVar.I(r62 == null ? null : (String) ((HashMap) this.f20044b).get(r62));
                break;
        }
    }

    public b(com.google.gson.e eVar, Type type, com.google.gson.k kVar, com.google.gson.internal.i iVar) {
        this.f20043a = 1;
        this.f20044b = new l(eVar, kVar, type);
        this.f20045c = iVar;
    }

    public b(Class cls) {
        this.f20043a = 3;
        this.f20045c = new HashMap();
        this.f20044b = new HashMap();
        try {
            for (Enum r42 : (Enum[]) cls.getEnumConstants()) {
                String name = r42.name();
                xb.b bVar = (xb.b) cls.getField(name).getAnnotation(xb.b.class);
                if (bVar != null) {
                    name = bVar.value();
                    for (String str : bVar.alternate()) {
                        ((HashMap) this.f20045c).put(str, r42);
                    }
                }
                ((HashMap) this.f20045c).put(name, r42);
                ((HashMap) this.f20044b).put(r42, name);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    public b(m mVar, Class cls) {
        this.f20043a = 2;
        this.f20044b = mVar;
        this.f20045c = cls;
    }
}
