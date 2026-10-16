package n;

import android.content.Context;
import android.util.ArrayMap;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.c2;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.w1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class s implements c2 {

    /* renamed from: b, reason: collision with root package name */
    public final y f16296b;

    public s(Context context) {
        this.f16296b = y.b(context);
    }

    @Override // androidx.camera.core.impl.c2
    public final androidx.camera.core.impl.e0 a(UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType, int i3) {
        int i10;
        androidx.camera.core.impl.x0 f2 = androidx.camera.core.impl.x0.f();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashSet hashSet = new HashSet();
        androidx.camera.core.impl.x0 f10 = androidx.camera.core.impl.x0.f();
        ArrayList arrayList = new ArrayList();
        androidx.camera.core.impl.z0 a3 = androidx.camera.core.impl.z0.a();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int[] iArr = p0.f16289a;
        int i11 = iArr[useCaseConfigFactory$CaptureType.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                i10 = 3;
            }
            i10 = 1;
        } else {
            if (i3 == 2) {
                i10 = 5;
            }
            i10 = 1;
        }
        androidx.camera.core.impl.c cVar = a2.C0;
        ArrayList arrayList5 = new ArrayList(linkedHashSet);
        ArrayList arrayList6 = new ArrayList(arrayList2);
        ArrayList arrayList7 = new ArrayList(arrayList3);
        ArrayList arrayList8 = new ArrayList(arrayList4);
        ArrayList arrayList9 = new ArrayList(hashSet);
        d1 a10 = d1.a(f10);
        ArrayList arrayList10 = new ArrayList(arrayList);
        w1 w1Var = w1.f1513b;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = a3.f1514a;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        f2.m(cVar, new s1(arrayList5, arrayList6, arrayList7, arrayList8, new androidx.camera.core.impl.d0(arrayList9, a10, i10, arrayList10, false, new w1(arrayMap), null), null, null, null));
        f2.m(a2.E0, r.f16292a);
        HashSet hashSet2 = new HashSet();
        androidx.camera.core.impl.x0 f11 = androidx.camera.core.impl.x0.f();
        ArrayList arrayList11 = new ArrayList();
        androidx.camera.core.impl.z0 a11 = androidx.camera.core.impl.z0.a();
        int i12 = iArr[useCaseConfigFactory$CaptureType.ordinal()];
        int i13 = i12 != 1 ? i12 != 2 ? 1 : 3 : i3 == 2 ? 5 : 2;
        androidx.camera.core.impl.c cVar2 = a2.D0;
        ArrayList arrayList12 = new ArrayList(hashSet2);
        d1 a12 = d1.a(f11);
        ArrayList arrayList13 = new ArrayList(arrayList11);
        w1 w1Var2 = w1.f1513b;
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = a11.f1514a;
        for (String str2 : arrayMap4.keySet()) {
            arrayMap3.put(str2, arrayMap4.get(str2));
        }
        f2.m(cVar2, new androidx.camera.core.impl.d0(arrayList12, a12, i13, arrayList13, false, new w1(arrayMap3), null));
        f2.m(a2.F0, useCaseConfigFactory$CaptureType == UseCaseConfigFactory$CaptureType.IMAGE_CAPTURE ? e0.f16170b : q.f16290a);
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType2 = UseCaseConfigFactory$CaptureType.PREVIEW;
        y yVar = this.f16296b;
        if (useCaseConfigFactory$CaptureType == useCaseConfigFactory$CaptureType2) {
            f2.m(androidx.camera.core.impl.p0.f1472y0, yVar.e());
        }
        f2.m(androidx.camera.core.impl.p0.f1467t0, Integer.valueOf(yVar.c(true).getRotation()));
        if (useCaseConfigFactory$CaptureType == UseCaseConfigFactory$CaptureType.VIDEO_CAPTURE || useCaseConfigFactory$CaptureType == UseCaseConfigFactory$CaptureType.STREAM_SHARING) {
            f2.m(a2.I0, Boolean.TRUE);
        }
        return d1.a(f2);
    }
}
