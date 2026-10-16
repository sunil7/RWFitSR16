package d4;

import com.bumptech.glide.Registry$NoModelLoaderAvailableException;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class x {
    public static final c0 e = new c0(10);

    /* renamed from: f, reason: collision with root package name */
    public static final d0 f12296f = new d0(2);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f12297a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f12298b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f12299c;

    /* renamed from: d, reason: collision with root package name */
    public final n.l f12300d;

    public x(n.l lVar) {
        c0 c0Var = e;
        this.f12297a = new ArrayList();
        this.f12299c = new HashSet();
        this.f12300d = lVar;
        this.f12298b = c0Var;
    }

    public final synchronized q a(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f12297a;
            int size = arrayList2.size();
            boolean z5 = false;
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                w wVar = (w) obj;
                if (this.f12299c.contains(wVar)) {
                    z5 = true;
                } else if (wVar.f12293a.isAssignableFrom(cls) && wVar.f12294b.isAssignableFrom(cls2)) {
                    this.f12299c.add(wVar);
                    arrayList.add(wVar.f12295c.c(this));
                    this.f12299c.remove(wVar);
                }
            }
            if (arrayList.size() > 1) {
                c0 c0Var = this.f12298b;
                n.l lVar = this.f12300d;
                c0Var.getClass();
                return new b(1, arrayList, lVar);
            }
            if (arrayList.size() == 1) {
                return (q) arrayList.get(0);
            }
            if (!z5) {
                throw new Registry$NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
            return f12296f;
        } catch (Throwable th2) {
            this.f12299c.clear();
            throw th2;
        }
    }

    public final synchronized ArrayList b(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            ArrayList arrayList2 = this.f12297a;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                w wVar = (w) obj;
                if (!this.f12299c.contains(wVar) && wVar.f12293a.isAssignableFrom(cls)) {
                    this.f12299c.add(wVar);
                    arrayList.add(wVar.f12295c.c(this));
                    this.f12299c.remove(wVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public final synchronized ArrayList c(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = this.f12297a;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            w wVar = (w) obj;
            if (!arrayList.contains(wVar.f12294b) && wVar.f12293a.isAssignableFrom(cls)) {
                arrayList.add(wVar.f12294b);
            }
        }
        return arrayList;
    }
}
