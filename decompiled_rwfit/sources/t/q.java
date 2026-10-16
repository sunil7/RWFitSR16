package t;

import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: b, reason: collision with root package name */
    public static final q f18374b;

    /* renamed from: c, reason: collision with root package name */
    public static final q f18375c;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f18376a;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new androidx.camera.core.impl.t0(0));
        f18374b = new q(linkedHashSet);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(new androidx.camera.core.impl.t0(1));
        f18375c = new q(linkedHashSet2);
    }

    public q(LinkedHashSet linkedHashSet) {
        this.f18376a = linkedHashSet;
    }

    public final ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        Iterator it = this.f18376a.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            List<androidx.camera.core.impl.u> unmodifiableList = Collections.unmodifiableList(arrayList2);
            androidx.camera.core.impl.t0 t0Var = (androidx.camera.core.impl.t0) pVar;
            t0Var.getClass();
            ArrayList arrayList3 = new ArrayList();
            for (androidx.camera.core.impl.u uVar : unmodifiableList) {
                pd.a("The camera info doesn't contain internal implementation.", uVar instanceof androidx.camera.core.impl.u);
                if (uVar.b() == t0Var.f1493b) {
                    arrayList3.add(uVar);
                }
            }
            arrayList2 = arrayList3;
        }
        arrayList2.retainAll(arrayList);
        return arrayList2;
    }

    public final Integer b() {
        Iterator it = this.f18376a.iterator();
        Integer num = null;
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (pVar instanceof androidx.camera.core.impl.t0) {
                Integer valueOf = Integer.valueOf(((androidx.camera.core.impl.t0) pVar).f1493b);
                if (num == null) {
                    num = valueOf;
                } else if (!num.equals(valueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    public final androidx.camera.core.impl.v c(LinkedHashSet linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((androidx.camera.core.impl.v) it.next()).h());
        }
        ArrayList a3 = a(arrayList);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            androidx.camera.core.impl.v vVar = (androidx.camera.core.impl.v) it2.next();
            if (a3.contains(vVar.h())) {
                linkedHashSet2.add(vVar);
            }
        }
        Iterator it3 = linkedHashSet2.iterator();
        if (it3.hasNext()) {
            return (androidx.camera.core.impl.v) it3.next();
        }
        throw new IllegalArgumentException("No available camera can be found");
    }
}
