package x1;

import androidx.lifecycle.m0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import m0.l;

/* loaded from: classes.dex */
public class b extends m0 {

    /* renamed from: b, reason: collision with root package name */
    public static final gc.b f19733b = new gc.b(22);

    /* renamed from: a, reason: collision with root package name */
    public final l f19734a = new l();

    @Override // androidx.lifecycle.m0
    public final void onCleared() {
        super.onCleared();
        l lVar = this.f19734a;
        int i3 = lVar.f15923c;
        if (i3 > 0) {
            throw l0.f(lVar.f15922b[0]);
        }
        Object[] objArr = lVar.f15922b;
        for (int i10 = 0; i10 < i3; i10++) {
            objArr[i10] = null;
        }
        lVar.f15923c = 0;
    }
}
