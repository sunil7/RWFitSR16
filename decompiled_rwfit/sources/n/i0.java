package n;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.v1;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: i, reason: collision with root package name */
    public final String f16218i;

    /* renamed from: j, reason: collision with root package name */
    public final d f16219j;

    /* renamed from: k, reason: collision with root package name */
    public final androidx.camera.camera2.internal.compat.n f16220k;

    /* renamed from: l, reason: collision with root package name */
    public final mc.g f16221l;

    /* renamed from: m, reason: collision with root package name */
    public final int f16222m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f16223n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f16224o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f16225p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f16226q;
    public final boolean r;

    /* renamed from: s, reason: collision with root package name */
    public androidx.camera.core.impl.j f16227s;

    /* renamed from: u, reason: collision with root package name */
    public final y f16229u;

    /* renamed from: x, reason: collision with root package name */
    public final ia.k f16232x;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16211a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f16212b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f16213c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f16214d = new ArrayList();
    public final HashMap e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f16215f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f16216g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f16217h = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f16228t = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    public final ec.a f16230v = new ec.a(18);

    /* renamed from: w, reason: collision with root package name */
    public final n6.a f16231w = new n6.a((byte) 0, 8);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:96:0x07f3  */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i0(android.content.Context r17, java.lang.String r18, androidx.camera.camera2.internal.compat.u r19, n.d r20) {
        /*
            Method dump skipped, instructions count: 2259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.i0.<init>(android.content.Context, java.lang.String, androidx.camera.camera2.internal.compat.u, n.d):void");
    }

    public static Size c(StreamConfigurationMap streamConfigurationMap, int i3, boolean z5) {
        Size[] highResolutionOutputSizes;
        Size[] outputSizes = i3 == 34 ? streamConfigurationMap.getOutputSizes(SurfaceTexture.class) : streamConfigurationMap.getOutputSizes(i3);
        if (outputSizes == null || outputSizes.length == 0) {
            return null;
        }
        ff.i iVar = new ff.i(false, 1);
        Size size = (Size) Collections.max(Arrays.asList(outputSizes), iVar);
        Size size2 = b0.a.f3041a;
        if (z5 && (highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(i3)) != null && highResolutionOutputSizes.length > 0) {
            size2 = (Size) Collections.max(Arrays.asList(highResolutionOutputSizes), iVar);
        }
        return (Size) Collections.max(Arrays.asList(size, size2), iVar);
    }

    public static int e(Range range, Range range2) {
        pd.f("Ranges must not intersect", (range.contains((Range) range2.getUpper()) || range.contains((Range) range2.getLower())) ? false : true);
        return ((Integer) range.getLower()).intValue() > ((Integer) range2.getUpper()).intValue() ? ((Integer) range.getLower()).intValue() - ((Integer) range2.getUpper()).intValue() : ((Integer) range2.getLower()).intValue() - ((Integer) range.getUpper()).intValue();
    }

    public static int f(Range range) {
        return (((Integer) range.getUpper()).intValue() - ((Integer) range.getLower()).intValue()) + 1;
    }

    public final boolean a(c cVar, List list) {
        List list2;
        HashMap hashMap = this.e;
        if (hashMap.containsKey(cVar)) {
            list2 = (List) hashMap.get(cVar);
        } else {
            ArrayList arrayList = new ArrayList();
            boolean z5 = cVar.f16149d;
            int i3 = cVar.f16146a;
            if (!z5) {
                int i10 = cVar.f16147b;
                if (i10 == 8) {
                    if (i3 != 1) {
                        ArrayList arrayList2 = this.f16211a;
                        if (i3 != 2) {
                            if (cVar.f16148c) {
                                arrayList2 = this.f16214d;
                            }
                            arrayList.addAll(arrayList2);
                        } else {
                            arrayList.addAll(this.f16212b);
                            arrayList.addAll(arrayList2);
                        }
                    } else {
                        arrayList = this.f16213c;
                    }
                } else if (i10 == 10 && i3 == 0) {
                    arrayList.addAll(this.f16215f);
                }
            } else if (i3 == 0) {
                arrayList.addAll(this.f16216g);
            }
            hashMap.put(cVar, arrayList);
            list2 = arrayList;
        }
        Iterator it = list2.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            z6 = ((v1) it.next()).c(list) != null;
            if (z6) {
                break;
            }
        }
        return z6;
    }

    public final void b() {
        Size size;
        Size size2;
        Size size3;
        int parseInt;
        d dVar;
        CamcorderProfile camcorderProfile;
        CamcorderProfile c9;
        Size e = this.f16229u.e();
        try {
            parseInt = Integer.parseInt(this.f16218i);
            dVar = this.f16219j;
            camcorderProfile = null;
            c9 = dVar.d(parseInt, 1) ? dVar.c(parseInt, 1) : null;
        } catch (NumberFormatException unused) {
            Size[] outputSizes = ((StreamConfigurationMap) ((a2.d) this.f16220k.b().f12377b).f23b).getOutputSizes(MediaRecorder.class);
            if (outputSizes == null) {
                size = b0.a.f3043c;
            } else {
                Arrays.sort(outputSizes, new ff.i(true, 1));
                for (Size size4 : outputSizes) {
                    int width = size4.getWidth();
                    Size size5 = b0.a.e;
                    if (width <= size5.getWidth() && size4.getHeight() <= size5.getHeight()) {
                        size2 = size4;
                        break;
                    }
                }
                size = b0.a.f3043c;
            }
            size2 = size;
        }
        if (c9 != null) {
            size2 = new Size(c9.videoFrameWidth, c9.videoFrameHeight);
        } else {
            Size size6 = b0.a.f3043c;
            if (dVar.d(parseInt, 10)) {
                camcorderProfile = dVar.c(parseInt, 10);
            } else if (dVar.d(parseInt, 8)) {
                camcorderProfile = dVar.c(parseInt, 8);
            } else if (dVar.d(parseInt, 12)) {
                camcorderProfile = dVar.c(parseInt, 12);
            } else if (dVar.d(parseInt, 6)) {
                camcorderProfile = dVar.c(parseInt, 6);
            } else if (dVar.d(parseInt, 5)) {
                camcorderProfile = dVar.c(parseInt, 5);
            } else if (dVar.d(parseInt, 4)) {
                camcorderProfile = dVar.c(parseInt, 4);
            }
            if (camcorderProfile == null) {
                size3 = size6;
                this.f16227s = new androidx.camera.core.impl.j(b0.a.f3042b, new HashMap(), e, new HashMap(), size3, new HashMap(), new HashMap());
            }
            size2 = new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        }
        size3 = size2;
        this.f16227s = new androidx.camera.core.impl.j(b0.a.f3042b, new HashMap(), e, new HashMap(), size3, new HashMap(), new HashMap());
    }

    public final List d(c cVar, List list) {
        androidx.camera.core.impl.c cVar2 = h0.f16200a;
        if (cVar.f16146a != 0 || cVar.f16147b != 8) {
            return null;
        }
        ArrayList arrayList = this.f16217h;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            List c9 = ((v1) obj).c(list);
            if (c9 != null) {
                return c9;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x0373, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0764, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:646:0x0bbd, code lost:
    
        if (f(r9) < f(r15)) goto L435;
     */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0591 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair g(int r38, java.util.ArrayList r39, java.util.HashMap r40, boolean r41, boolean r42) {
        /*
            Method dump skipped, instructions count: 4035
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.i0.g(int, java.util.ArrayList, java.util.HashMap, boolean, boolean):android.util.Pair");
    }

    public final Pair h(int i3, ArrayList arrayList, List list, ArrayList arrayList2, ArrayList arrayList3, int i10, HashMap hashMap, HashMap hashMap2) {
        int i11;
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            androidx.camera.core.impl.a aVar = (androidx.camera.core.impl.a) obj;
            arrayList4.add(aVar.f1342a);
            if (hashMap != null) {
                hashMap.put(Integer.valueOf(arrayList4.size() - 1), aVar);
            }
        }
        for (int i13 = 0; i13 < list.size(); i13++) {
            Size size2 = (Size) list.get(i13);
            a2 a2Var = (a2) arrayList2.get(((Integer) arrayList3.get(i13)).intValue());
            int A = a2Var.A();
            arrayList4.add(androidx.camera.core.impl.i.c(i3, A, size2, i(A)));
            if (hashMap2 != null) {
                hashMap2.put(Integer.valueOf(arrayList4.size() - 1), a2Var);
            }
            try {
                i11 = (int) (1.0E9d / ((StreamConfigurationMap) this.f16220k.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(a2Var.A(), size2));
            } catch (Exception unused) {
                i11 = 0;
            }
            i10 = Math.min(i10, i11);
        }
        return new Pair(arrayList4, Integer.valueOf(i10));
    }

    public final androidx.camera.core.impl.j i(int i3) {
        CameraCharacteristics.Key key;
        ArrayList arrayList = this.f16228t;
        if (!arrayList.contains(Integer.valueOf(i3))) {
            j(this.f16227s.f1423b, b0.a.f3044d, i3);
            j(this.f16227s.f1425d, b0.a.f3045f, i3);
            HashMap hashMap = this.f16227s.f1426f;
            androidx.camera.camera2.internal.compat.n nVar = this.f16220k;
            Size c9 = c((StreamConfigurationMap) ((a2.d) nVar.b().f12377b).f23b, i3, true);
            if (c9 != null) {
                hashMap.put(Integer.valueOf(i3), c9);
            }
            HashMap hashMap2 = this.f16227s.f1427g;
            if (Build.VERSION.SDK_INT >= 31 && this.r) {
                key = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION;
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) nVar.a(key);
                if (streamConfigurationMap != null) {
                    hashMap2.put(Integer.valueOf(i3), c(streamConfigurationMap, i3, true));
                }
            }
            arrayList.add(Integer.valueOf(i3));
        }
        return this.f16227s;
    }

    public final void j(HashMap hashMap, Size size, int i3) {
        if (this.f16225p) {
            Size c9 = c((StreamConfigurationMap) ((a2.d) this.f16220k.b().f12377b).f23b, i3, false);
            Integer valueOf = Integer.valueOf(i3);
            if (c9 != null) {
                size = (Size) Collections.min(Arrays.asList(size, c9), new ff.i(false, 1));
            }
            hashMap.put(valueOf, size);
        }
    }
}
