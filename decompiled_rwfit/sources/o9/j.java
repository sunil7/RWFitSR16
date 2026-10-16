package o9;

import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public Feature[] f16864a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16865b;

    /* renamed from: c, reason: collision with root package name */
    public int f16866c;

    /* renamed from: d, reason: collision with root package name */
    public Object f16867d;

    public j a() {
        q9.n.a("execute parameter required", ((i) this.f16867d) != null);
        Feature[] featureArr = this.f16864a;
        boolean z5 = this.f16865b;
        int i3 = this.f16866c;
        j jVar = new j();
        jVar.f16867d = this;
        jVar.f16864a = featureArr;
        boolean z6 = false;
        if (featureArr != null && z5) {
            z6 = true;
        }
        jVar.f16865b = z6;
        jVar.f16866c = i3;
        return jVar;
    }
}
