package j2;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class t extends g0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f15293a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f15294b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15295c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f15296d;
    public final /* synthetic */ Object e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f15297f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ v f15298g;

    public t(v vVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f15298g = vVar;
        this.f15293a = obj;
        this.f15294b = arrayList;
        this.f15295c = obj2;
        this.f15296d = arrayList2;
        this.e = obj3;
        this.f15297f = arrayList3;
    }

    @Override // j2.g0, j2.e0
    public final void a(f0 f0Var) {
        v vVar = this.f15298g;
        Object obj = this.f15293a;
        if (obj != null) {
            vVar.s(obj, this.f15294b, null);
        }
        Object obj2 = this.f15295c;
        if (obj2 != null) {
            vVar.s(obj2, this.f15296d, null);
        }
        Object obj3 = this.e;
        if (obj3 != null) {
            vVar.s(obj3, this.f15297f, null);
        }
    }

    @Override // j2.e0
    public final void e(f0 f0Var) {
        f0Var.w(this);
    }
}
