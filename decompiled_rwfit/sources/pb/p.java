package pb;

import com.google.android.gms.internal.mlkit_vision_barcode.dg;
import com.google.firebase.components.DependencyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class p extends dg {

    /* renamed from: b, reason: collision with root package name */
    public final Set f17528b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f17529c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f17530d;
    public final Set e;

    /* renamed from: f, reason: collision with root package name */
    public final dg f17531f;

    public p(a aVar, dg dgVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (i iVar : aVar.f17499b) {
            int i3 = iVar.f17518c;
            boolean z5 = i3 == 0;
            int i10 = iVar.f17517b;
            Class cls = iVar.f17516a;
            if (z5) {
                if (i10 == 2) {
                    hashSet4.add(cls);
                } else {
                    hashSet.add(cls);
                }
            } else if (i3 == 2) {
                hashSet3.add(cls);
            } else if (i10 == 2) {
                hashSet5.add(cls);
            } else {
                hashSet2.add(cls);
            }
        }
        if (!aVar.e.isEmpty()) {
            hashSet.add(ub.a.class);
        }
        this.f17528b = Collections.unmodifiableSet(hashSet);
        this.f17529c = Collections.unmodifiableSet(hashSet2);
        Collections.unmodifiableSet(hashSet3);
        this.f17530d = Collections.unmodifiableSet(hashSet4);
        this.e = Collections.unmodifiableSet(hashSet5);
        this.f17531f = dgVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.dg
    public final Object a(Class cls) {
        if (!this.f17528b.contains(cls)) {
            throw new DependencyException("Attempting to request an undeclared dependency " + cls + ".");
        }
        Object a3 = this.f17531f.a(cls);
        if (!cls.equals(ub.a.class)) {
            return a3;
        }
        return new o();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.dg
    public final vb.a b(Class cls) {
        if (this.f17529c.contains(cls)) {
            return this.f17531f.b(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<" + cls + ">.");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.dg
    public final Set c(Class cls) {
        if (this.f17530d.contains(cls)) {
            return this.f17531f.c(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Set<" + cls + ">.");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.dg
    public final vb.a d(Class cls) {
        if (this.e.contains(cls)) {
            return this.f17531f.d(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<Set<" + cls + ">>.");
    }
}
