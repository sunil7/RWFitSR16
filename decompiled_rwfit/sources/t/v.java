package t;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final long f18417a;

    /* renamed from: b, reason: collision with root package name */
    public final List f18418b;

    /* renamed from: c, reason: collision with root package name */
    public final List f18419c;

    /* renamed from: d, reason: collision with root package name */
    public final List f18420d;

    public v(v vVar) {
        this.f18418b = Collections.unmodifiableList((ArrayList) vVar.f18418b);
        this.f18419c = Collections.unmodifiableList((ArrayList) vVar.f18419c);
        this.f18420d = Collections.unmodifiableList((ArrayList) vVar.f18420d);
        this.f18417a = vVar.f18417a;
    }

    public v(t0 t0Var) {
        ArrayList arrayList = new ArrayList();
        this.f18418b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f18419c = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.f18420d = arrayList3;
        this.f18417a = 5000L;
        arrayList.add(t0Var);
        arrayList2.add(t0Var);
        arrayList3.add(t0Var);
    }
}
