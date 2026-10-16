package gc;

import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements com.google.android.gms.common.api.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14046a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Feature[] f14047b;

    public /* synthetic */ k(Feature[] featureArr, int i3) {
        this.f14046a = i3;
        this.f14047b = featureArr;
    }

    @Override // com.google.android.gms.common.api.j
    public final Feature[] b() {
        Feature[] featureArr = this.f14047b;
        switch (this.f14046a) {
            case 0:
                Feature[] featureArr2 = g.f14033a;
                break;
            default:
                Feature[] featureArr3 = g.f14033a;
                break;
        }
        return featureArr;
    }
}
