package kotlin.jvm.internal;

import com.google.android.gms.internal.mlkit_vision_barcode.ff;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import oh.j;
import oh.k;
import oh.l;
import oh.m;
import oh.n;
import oh.o;
import oh.p;
import oh.q;
import oh.r;
import oh.s;
import oh.t;
import oh.u;
import oh.v;
import oh.w;

/* loaded from: classes2.dex */
public final class b implements uh.c, a {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f15647b;

    /* renamed from: a, reason: collision with root package name */
    public final Class f15648a;

    static {
        List d5 = kotlin.collections.i.d(oh.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, oh.b.class, oh.c.class, oh.d.class, oh.e.class, oh.f.class, oh.g.class, oh.h.class, oh.i.class, j.class, k.class, m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.j.g(d5));
        int i3 = 0;
        for (Object obj : d5) {
            int i10 = i3 + 1;
            if (i3 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            arrayList.add(new Pair((Class) obj, Integer.valueOf(i3)));
            i3 = i10;
        }
        f15647b = kotlin.collections.p.c(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        e.e(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb2 = new StringBuilder("kotlin.jvm.internal.");
            e.e(kotlinName, "kotlinName");
            sb2.append(kotlin.text.m.z(kotlinName));
            sb2.append("CompanionObject");
            Pair pair = new Pair(sb2.toString(), kotlinName.concat(".Companion"));
            hashMap3.put(pair.getFirst(), pair.getSecond());
        }
        for (Map.Entry entry : f15647b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int intValue = ((Number) entry.getValue()).intValue();
            hashMap3.put(cls.getName(), "kotlin.Function" + intValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.p.b(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), kotlin.text.m.z((String) entry2.getValue()));
        }
    }

    public b(Class jClass) {
        e.f(jClass, "jClass");
        this.f15648a = jClass;
    }

    @Override // kotlin.jvm.internal.a
    public final Class a() {
        return this.f15648a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ff.a(this).equals(ff.a((uh.c) obj));
    }

    public final int hashCode() {
        return ff.a(this).hashCode();
    }

    public final String toString() {
        return this.f15648a.toString() + " (Kotlin reflection is not available)";
    }
}
