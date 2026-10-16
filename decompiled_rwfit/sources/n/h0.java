package n;

import android.os.Build;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.j1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f16200a = new androidx.camera.core.impl.c("camera2.streamSpec.streamUseCase", Long.TYPE, null);

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f16201b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f16202c;

    static {
        HashMap hashMap = new HashMap();
        f16201b = hashMap;
        HashMap hashMap2 = new HashMap();
        f16202c = hashMap2;
        if (Build.VERSION.SDK_INT >= 33) {
            HashSet hashSet = new HashSet();
            UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.PREVIEW;
            hashSet.add(useCaseConfigFactory$CaptureType);
            UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType2 = UseCaseConfigFactory$CaptureType.METERING_REPEATING;
            hashSet.add(useCaseConfigFactory$CaptureType2);
            hashMap.put(4L, hashSet);
            HashSet hashSet2 = new HashSet();
            hashSet2.add(useCaseConfigFactory$CaptureType);
            hashSet2.add(useCaseConfigFactory$CaptureType2);
            hashSet2.add(UseCaseConfigFactory$CaptureType.IMAGE_ANALYSIS);
            hashMap.put(1L, hashSet2);
            HashSet hashSet3 = new HashSet();
            UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType3 = UseCaseConfigFactory$CaptureType.IMAGE_CAPTURE;
            hashSet3.add(useCaseConfigFactory$CaptureType3);
            hashMap.put(2L, hashSet3);
            HashSet hashSet4 = new HashSet();
            UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType4 = UseCaseConfigFactory$CaptureType.VIDEO_CAPTURE;
            hashSet4.add(useCaseConfigFactory$CaptureType4);
            hashMap.put(3L, hashSet4);
            HashSet hashSet5 = new HashSet();
            hashSet5.add(useCaseConfigFactory$CaptureType);
            hashSet5.add(useCaseConfigFactory$CaptureType3);
            hashSet5.add(useCaseConfigFactory$CaptureType4);
            hashMap2.put(4L, hashSet5);
            HashSet hashSet6 = new HashSet();
            hashSet6.add(useCaseConfigFactory$CaptureType);
            hashSet6.add(useCaseConfigFactory$CaptureType4);
            hashMap2.put(3L, hashSet6);
        }
    }

    public static m.b a(m.b bVar, long j4) {
        androidx.camera.core.impl.c cVar = f16200a;
        if (bVar.b(cVar) && ((Long) bVar.e(cVar)).longValue() == j4) {
            return null;
        }
        androidx.camera.core.impl.x0 i3 = androidx.camera.core.impl.x0.i(bVar);
        i3.m(cVar, Long.valueOf(j4));
        return new m.b(i3, 12);
    }

    public static boolean b(UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType, long j4, List list) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (useCaseConfigFactory$CaptureType != UseCaseConfigFactory$CaptureType.STREAM_SHARING) {
            HashMap hashMap = f16201b;
            return hashMap.containsKey(Long.valueOf(j4)) && ((Set) hashMap.get(Long.valueOf(j4))).contains(useCaseConfigFactory$CaptureType);
        }
        HashMap hashMap2 = f16202c;
        if (!hashMap2.containsKey(Long.valueOf(j4))) {
            return false;
        }
        Set set = (Set) hashMap2.get(Long.valueOf(j4));
        if (list.size() != set.size()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!set.contains((UseCaseConfigFactory$CaptureType) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(j1 j1Var, UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType) {
        if (((Boolean) j1Var.k(a2.I0, Boolean.FALSE)).booleanValue()) {
            return false;
        }
        androidx.camera.core.impl.c cVar = androidx.camera.core.impl.n0.f1448b;
        if (j1Var.b(cVar)) {
            return p0.f16289a[useCaseConfigFactory$CaptureType.ordinal()] == 1 && ((Integer) j1Var.e(cVar)).intValue() == 2;
        }
        return false;
    }
}
