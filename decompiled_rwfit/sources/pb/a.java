package pb;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Set f17498a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f17499b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17500c;

    /* renamed from: d, reason: collision with root package name */
    public final b f17501d;
    public final Set e;

    public a(HashSet hashSet, HashSet hashSet2, int i3, b bVar, HashSet hashSet3) {
        this.f17498a = Collections.unmodifiableSet(hashSet);
        this.f17499b = Collections.unmodifiableSet(hashSet2);
        this.f17500c = i3;
        this.f17501d = bVar;
        this.e = Collections.unmodifiableSet(hashSet3);
    }

    public static f8.f a(Class cls) {
        return new f8.f(cls, new Class[0]);
    }

    public static a b(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            com.google.android.gms.internal.mlkit_vision_common.j.a(cls2, "Null interface");
        }
        Collections.addAll(hashSet, clsArr);
        return new a(new HashSet(hashSet), new HashSet(hashSet2), 0, new fb.d(obj), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f17498a.toArray()) + ">{0, type=" + this.f17500c + ", deps=" + Arrays.toString(this.f17499b.toArray()) + "}";
    }
}
