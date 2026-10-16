package n;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageWriter;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Size;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.w1;
import androidx.camera.core.impl.y1;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class h implements androidx.camera.core.impl.t {

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.camera2.internal.compat.f f16179b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.camera.core.impl.utils.executor.b f16180c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f16181d = new Object();
    public final androidx.camera.camera2.internal.compat.n e;

    /* renamed from: f, reason: collision with root package name */
    public final com.example.test.ui.device.activity.f0 f16182f;

    /* renamed from: g, reason: collision with root package name */
    public final n1 f16183g;

    /* renamed from: h, reason: collision with root package name */
    public final d0 f16184h;

    /* renamed from: i, reason: collision with root package name */
    public final v0 f16185i;

    /* renamed from: j, reason: collision with root package name */
    public final s0 f16186j;

    /* renamed from: k, reason: collision with root package name */
    public final com.example.test.utils.s0 f16187k;

    /* renamed from: l, reason: collision with root package name */
    public final z0 f16188l;

    /* renamed from: m, reason: collision with root package name */
    public final s.c f16189m;

    /* renamed from: n, reason: collision with root package name */
    public final com.google.android.gms.internal.mlkit_common.o f16190n;

    /* renamed from: o, reason: collision with root package name */
    public final mc.g f16191o;

    /* renamed from: p, reason: collision with root package name */
    public int f16192p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f16193q;
    public volatile int r;

    /* renamed from: s, reason: collision with root package name */
    public final mc.g f16194s;

    /* renamed from: t, reason: collision with root package name */
    public final q.a f16195t;

    /* renamed from: u, reason: collision with root package name */
    public final AtomicLong f16196u;

    /* renamed from: v, reason: collision with root package name */
    public int f16197v;

    /* renamed from: w, reason: collision with root package name */
    public long f16198w;

    /* renamed from: x, reason: collision with root package name */
    public final h0.c f16199x;

    public h(androidx.camera.camera2.internal.compat.n nVar, w.c cVar, androidx.camera.core.impl.utils.executor.b bVar, com.example.test.ui.device.activity.f0 f0Var, i1 i1Var) {
        n1 n1Var = new n1();
        this.f16183g = n1Var;
        this.f16192p = 0;
        this.f16193q = false;
        this.r = 2;
        this.f16196u = new AtomicLong(0L);
        this.f16197v = 1;
        this.f16198w = 0L;
        h0.c cVar2 = new h0.c();
        cVar2.f14217b = new HashSet();
        cVar2.f14218c = new ArrayMap();
        this.f16199x = cVar2;
        this.e = nVar;
        this.f16182f = f0Var;
        this.f16180c = bVar;
        this.f16191o = new mc.g(bVar);
        androidx.camera.camera2.internal.compat.f fVar = new androidx.camera.camera2.internal.compat.f(bVar);
        this.f16179b = fVar;
        n1Var.f1442b.f1356c = this.f16197v;
        n1Var.f1442b.b(new x(fVar));
        n1Var.f1442b.b(cVar2);
        com.example.test.utils.s0 s0Var = new com.example.test.utils.s0();
        s0Var.f8756a = false;
        s0Var.f8757b = new m8.a(1);
        this.f16187k = s0Var;
        this.f16184h = new d0(this, cVar, bVar, i1Var);
        this.f16185i = new v0(this, nVar, bVar);
        this.f16186j = new s0(this, nVar, bVar);
        this.f16188l = new z0(nVar);
        this.f16194s = new mc.g(i1Var);
        this.f16195t = new q.a(i1Var, 0);
        this.f16189m = new s.c(this, bVar);
        this.f16190n = new com.google.android.gms.internal.mlkit_common.o(this, nVar, i1Var, bVar, cVar);
    }

    public static int o(androidx.camera.camera2.internal.compat.n nVar, int i3) {
        int[] iArr = (int[]) nVar.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return r(i3, iArr) ? i3 : r(1, iArr) ? 1 : 0;
    }

    public static boolean r(int i3, int[] iArr) {
        for (int i10 : iArr) {
            if (i3 == i10) {
                return true;
            }
        }
        return false;
    }

    public static boolean s(TotalCaptureResult totalCaptureResult, long j4) {
        Long l3;
        if (totalCaptureResult.getRequest() == null) {
            return false;
        }
        Object tag = totalCaptureResult.getRequest().getTag();
        return (tag instanceof w1) && (l3 = (Long) ((w1) tag).f1514a.get("CameraControlSessionUpdateId")) != null && l3.longValue() >= j4;
    }

    @Override // androidx.camera.core.impl.t
    public final androidx.camera.core.impl.e0 a() {
        m.b bVar;
        s.c cVar = this.f16189m;
        synchronized (cVar.e) {
            m.a aVar = cVar.f18154f;
            aVar.getClass();
            bVar = new m.b(d1.a(aVar.f15876b), 12);
        }
        return bVar;
    }

    @Override // androidx.camera.core.impl.t
    public final ob.a b(t.v vVar) {
        if (!q()) {
            return new x.k(new CameraControl$OperationCanceledException("Camera is not active."), 1);
        }
        d0 d0Var = this.f16184h;
        d0Var.getClass();
        return x.i.d(ve.a(new c0.b(13, d0Var, vVar)));
    }

    @Override // androidx.camera.core.impl.t
    public final void c(t.k0 k0Var) {
    }

    @Override // androidx.camera.core.impl.t
    public final void d() {
        s.c cVar = this.f16189m;
        synchronized (cVar.e) {
            cVar.f18154f = new m.a(0);
        }
        x.i.d(ve.a(new s.b(cVar, 1))).a(new com.example.blesdk.service.z(6), a6.a());
    }

    @Override // androidx.camera.core.impl.t
    public final void e(androidx.camera.core.impl.e0 e0Var) {
        s.c cVar = this.f16189m;
        n6.a c9 = g0.d.d(e0Var).c();
        synchronized (cVar.e) {
            m.a aVar = cVar.f18154f;
            aVar.getClass();
            Config$OptionPriority config$OptionPriority = Config$OptionPriority.OPTIONAL;
            for (androidx.camera.core.impl.c cVar2 : c9.g()) {
                aVar.f15876b.l(cVar2, config$OptionPriority, c9.e(cVar2));
            }
        }
        x.i.d(ve.a(new s.b(cVar, 0))).a(new com.example.blesdk.service.z(6), a6.a());
    }

    @Override // androidx.camera.core.impl.t
    public final ob.a f(float f2) {
        ob.a kVar;
        y.b e;
        if (!q()) {
            return new x.k(new CameraControl$OperationCanceledException("Camera is not active."), 1);
        }
        v0 v0Var = this.f16185i;
        synchronized (((w0) v0Var.f16309d)) {
            try {
                ((w0) v0Var.f16309d).e(f2);
                e = y.b.e((w0) v0Var.f16309d);
            } catch (IllegalArgumentException e10) {
                kVar = new x.k(e10, 1);
            }
        }
        v0Var.d(e);
        kVar = ve.a(new c0.b(15, v0Var, e));
        return x.i.d(kVar);
    }

    @Override // androidx.camera.core.impl.t
    public final Rect g() {
        Rect rect = (Rect) this.e.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if ("robolectric".equals(Build.FINGERPRINT) && rect == null) {
            return new Rect(0, 0, 4000, 3000);
        }
        rect.getClass();
        return rect;
    }

    @Override // androidx.camera.core.impl.t
    public final void h(int i3) {
        if (!q()) {
            com.google.android.gms.internal.mlkit_vision_common.a0.e("Camera2CameraControlImp", "Camera is not active.");
            return;
        }
        this.r = i3;
        com.google.android.gms.internal.mlkit_vision_common.a0.a("Camera2CameraControlImp", "setFlashMode: mFlashMode = " + this.r);
        z0 z0Var = this.f16188l;
        if (this.r != 1) {
            int i10 = this.r;
        }
        z0Var.getClass();
        x.i.d(ve.a(new af.a(this, 18)));
    }

    @Override // androidx.camera.core.impl.t
    public final void i(n1 n1Var) {
        boolean isEmpty;
        HashMap hashMap;
        StreamConfigurationMap streamConfigurationMap;
        int[] validOutputFormatsForInput;
        z0 z0Var = this.f16188l;
        de.o oVar = z0Var.f16329b;
        while (true) {
            synchronized (oVar.f12378c) {
                isEmpty = ((ArrayDeque) oVar.f12377b).isEmpty();
            }
            if (isEmpty) {
                break;
            } else {
                ((t.p0) oVar.l()).close();
            }
        }
        androidx.camera.core.impl.s0 s0Var = z0Var.f16334h;
        StreamConfigurationMap streamConfigurationMap2 = null;
        if (s0Var != null) {
            t.z0 z0Var2 = z0Var.f16332f;
            if (z0Var2 != null) {
                x.i.d(s0Var.e).a(new y0(z0Var2, 0), a6.d());
                z0Var.f16332f = null;
            }
            s0Var.a();
            z0Var.f16334h = null;
        }
        ImageWriter imageWriter = z0Var.f16335i;
        if (imageWriter != null) {
            imageWriter.close();
            z0Var.f16335i = null;
        }
        if (z0Var.f16330c) {
            n1Var.f1442b.f1356c = 1;
            return;
        }
        if (z0Var.e) {
            n1Var.f1442b.f1356c = 1;
            return;
        }
        try {
            streamConfigurationMap2 = (StreamConfigurationMap) z0Var.f16328a.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        } catch (AssertionError e) {
            com.google.android.gms.internal.mlkit_vision_common.a0.b("ZslControlImpl", "Failed to retrieve StreamConfigurationMap, error = " + e.getMessage());
        }
        if (streamConfigurationMap2 == null || streamConfigurationMap2.getInputFormats() == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap();
            for (int i3 : streamConfigurationMap2.getInputFormats()) {
                Size[] inputSizes = streamConfigurationMap2.getInputSizes(i3);
                if (inputSizes != null) {
                    Arrays.sort(inputSizes, new ff.i(true, 1));
                    hashMap.put(Integer.valueOf(i3), inputSizes[0]);
                }
            }
        }
        if (z0Var.f16331d && !hashMap.isEmpty() && hashMap.containsKey(34) && (streamConfigurationMap = (StreamConfigurationMap) z0Var.f16328a.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)) != null && (validOutputFormatsForInput = streamConfigurationMap.getValidOutputFormatsForInput(34)) != null) {
            for (int i10 : validOutputFormatsForInput) {
                if (i10 == 256) {
                    Size size = (Size) hashMap.get(34);
                    t.s0 s0Var2 = new t.s0(size.getWidth(), size.getHeight(), 34, 9);
                    z0Var.f16333g = s0Var2.f18394b;
                    z0Var.f16332f = new t.z0(s0Var2);
                    s0Var2.t(new af.a(z0Var, 22), a6.c());
                    androidx.camera.core.impl.s0 s0Var3 = new androidx.camera.core.impl.s0(z0Var.f16332f.e(), new Size(z0Var.f16332f.getWidth(), z0Var.f16332f.getHeight()), 34);
                    z0Var.f16334h = s0Var3;
                    t.z0 z0Var3 = z0Var.f16332f;
                    ob.a d5 = x.i.d(s0Var3.e);
                    Objects.requireNonNull(z0Var3);
                    d5.a(new y0(z0Var3, 0), a6.d());
                    n1Var.b(z0Var.f16334h, t.t.f18406d, -1);
                    g0.g gVar = z0Var.f16333g;
                    n1Var.f1442b.b(gVar);
                    ArrayList arrayList = n1Var.e;
                    if (!arrayList.contains(gVar)) {
                        arrayList.add(gVar);
                    }
                    t tVar = new t(z0Var, 2);
                    ArrayList arrayList2 = n1Var.f1444d;
                    if (!arrayList2.contains(tVar)) {
                        arrayList2.add(tVar);
                    }
                    n1Var.f1446g = new InputConfiguration(z0Var.f16332f.getWidth(), z0Var.f16332f.getHeight(), z0Var.f16332f.m());
                    return;
                }
            }
        }
        n1Var.f1442b.f1356c = 1;
    }

    @Override // androidx.camera.core.impl.t
    public final ob.a j(boolean z5) {
        ob.a a3;
        if (!q()) {
            return new x.k(new CameraControl$OperationCanceledException("Camera is not active."), 1);
        }
        s0 s0Var = this.f16186j;
        if (s0Var.f16299c) {
            s0.a(s0Var.f16298b, Integer.valueOf(z5 ? 1 : 0));
            a3 = ve.a(new de.p(s0Var, z5));
        } else {
            com.google.android.gms.internal.mlkit_vision_common.a0.a("TorchControl", "Unable to enableTorch due to there is no flash unit.");
            a3 = new x.k(new IllegalStateException("No flash unit"), 1);
        }
        return x.i.d(a3);
    }

    public final void k(g gVar) {
        ((HashSet) this.f16179b.f1165c).add(gVar);
    }

    public final void l() {
        synchronized (this.f16181d) {
            try {
                int i3 = this.f16192p;
                if (i3 == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                this.f16192p = i3 - 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void m(boolean z5) {
        this.f16193q = z5;
        if (!z5) {
            androidx.camera.core.impl.c0 c0Var = new androidx.camera.core.impl.c0();
            c0Var.f1356c = this.f16197v;
            c0Var.e = true;
            androidx.camera.core.impl.x0 f2 = androidx.camera.core.impl.x0.f();
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
            f2.m(m.b.Y(key), Integer.valueOf(o(this.e, 1)));
            f2.m(m.b.Y(CaptureRequest.FLASH_MODE), 0);
            c0Var.c(new m.b(d1.a(f2), 12));
            u(Collections.singletonList(c0Var.d()));
        }
        v();
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x008b, code lost:
    
        if (r4 != 2) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.camera.core.impl.s1 n() {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.h.n():androidx.camera.core.impl.s1");
    }

    public final int p(int i3) {
        int[] iArr = (int[]) this.e.a(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (r(i3, iArr)) {
            return i3;
        }
        if (r(4, iArr)) {
            return 4;
        }
        return r(1, iArr) ? 1 : 0;
    }

    public final boolean q() {
        int i3;
        synchronized (this.f16181d) {
            i3 = this.f16192p;
        }
        return i3 > 0;
    }

    public final void t(boolean z5) {
        y.b e;
        com.google.android.gms.internal.mlkit_vision_common.a0.a("Camera2CameraControlImp", "setActive: isActive = " + z5);
        d0 d0Var = this.f16184h;
        if (z5 != d0Var.f16154d) {
            d0Var.f16154d = z5;
            if (!d0Var.f16154d) {
                d0Var.a();
            }
        }
        v0 v0Var = this.f16185i;
        if (v0Var.f16306a != z5) {
            v0Var.f16306a = z5;
            if (!z5) {
                synchronized (((w0) v0Var.f16309d)) {
                    ((w0) v0Var.f16309d).e(1.0f);
                    e = y.b.e((w0) v0Var.f16309d);
                }
                v0Var.d(e);
                ((u0) v0Var.f16310f).g();
                ((h) v0Var.f16307b).v();
            }
        }
        s0 s0Var = this.f16186j;
        if (s0Var.e != z5) {
            s0Var.e = z5;
            if (!z5) {
                if (s0Var.f16302g) {
                    s0Var.f16302g = false;
                    s0Var.f16297a.m(false);
                    s0.a(s0Var.f16298b, 0);
                }
                androidx.concurrent.futures.b bVar = s0Var.f16301f;
                if (bVar != null) {
                    bVar.b(new CameraControl$OperationCanceledException("Camera is not active."));
                    s0Var.f16301f = null;
                }
            }
        }
        com.example.test.utils.s0 s0Var2 = this.f16187k;
        if (z5 != s0Var2.f8756a) {
            s0Var2.f8756a = z5;
            if (!z5) {
                synchronized (((m8.a) s0Var2.f8757b).f15991a) {
                }
            }
        }
        s.c cVar = this.f16189m;
        cVar.getClass();
        cVar.f18153d.execute(new o6.e(cVar, z5, 2));
        if (z5) {
            return;
        }
        ((AtomicInteger) this.f16191o.f16022b).set(0);
        com.google.android.gms.internal.mlkit_vision_common.a0.a("VideoUsageControl", "resetDirectly: mVideoUsage reset!");
    }

    public final void u(List list) {
        int b3;
        int a3;
        androidx.camera.core.impl.n nVar;
        com.example.test.ui.device.activity.f0 f0Var = this.f16182f;
        f0Var.getClass();
        list.getClass();
        androidx.camera.camera2.internal.i iVar = (androidx.camera.camera2.internal.i) f0Var.f7859b;
        iVar.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) it.next();
            HashSet hashSet = new HashSet();
            androidx.camera.core.impl.x0.f();
            ArrayList arrayList2 = new ArrayList();
            androidx.camera.core.impl.z0.a();
            hashSet.addAll(d0Var.f1366a);
            androidx.camera.core.impl.x0 i3 = androidx.camera.core.impl.x0.i(d0Var.f1367b);
            arrayList2.addAll(d0Var.f1369d);
            ArrayMap arrayMap = new ArrayMap();
            w1 w1Var = d0Var.f1370f;
            for (String str : w1Var.f1514a.keySet()) {
                arrayMap.put(str, w1Var.f1514a.get(str));
            }
            androidx.camera.core.impl.z0 z0Var = new androidx.camera.core.impl.z0(arrayMap);
            androidx.camera.core.impl.n nVar2 = (d0Var.f1368c != 5 || (nVar = d0Var.f1371g) == null) ? null : nVar;
            if (Collections.unmodifiableList(d0Var.f1366a).isEmpty() && d0Var.e) {
                if (hashSet.isEmpty()) {
                    com.example.test.utils.y yVar = iVar.f1238a;
                    yVar.getClass();
                    ArrayList arrayList3 = new ArrayList();
                    for (Map.Entry entry : ((LinkedHashMap) yVar.f8774c).entrySet()) {
                        y1 y1Var = (y1) entry.getValue();
                        if (y1Var.f1533f && y1Var.e) {
                            arrayList3.add(((y1) entry.getValue()).f1529a);
                        }
                    }
                    Iterator it2 = Collections.unmodifiableCollection(arrayList3).iterator();
                    while (it2.hasNext()) {
                        androidx.camera.core.impl.d0 d0Var2 = ((s1) it2.next()).f1490g;
                        List unmodifiableList = Collections.unmodifiableList(d0Var2.f1366a);
                        if (!unmodifiableList.isEmpty()) {
                            if (d0Var2.a() != 0 && (a3 = d0Var2.a()) != 0) {
                                i3.m(a2.L0, Integer.valueOf(a3));
                            }
                            if (d0Var2.b() != 0 && (b3 = d0Var2.b()) != 0) {
                                i3.m(a2.M0, Integer.valueOf(b3));
                            }
                            Iterator it3 = unmodifiableList.iterator();
                            while (it3.hasNext()) {
                                hashSet.add((androidx.camera.core.impl.g0) it3.next());
                            }
                        }
                    }
                    if (hashSet.isEmpty()) {
                        com.google.android.gms.internal.mlkit_vision_common.a0.e("Camera2CameraImpl", "Unable to find a repeating surface to attach to CaptureConfig");
                    }
                } else {
                    com.google.android.gms.internal.mlkit_vision_common.a0.e("Camera2CameraImpl", "The capture config builder already has surface inside.");
                }
            }
            ArrayList arrayList4 = new ArrayList(hashSet);
            d1 a10 = d1.a(i3);
            ArrayList arrayList5 = new ArrayList(arrayList2);
            w1 w1Var2 = w1.f1513b;
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayMap arrayMap3 = z0Var.f1514a;
            for (String str2 : arrayMap3.keySet()) {
                arrayMap2.put(str2, arrayMap3.get(str2));
            }
            arrayList.add(new androidx.camera.core.impl.d0(arrayList4, a10, d0Var.f1368c, arrayList5, d0Var.e, new w1(arrayMap2), nVar2));
        }
        iVar.s("Issue capture request", null);
        iVar.f1249m.i(arrayList);
    }

    public final long v() {
        this.f16198w = this.f16196u.getAndIncrement();
        ((androidx.camera.camera2.internal.i) this.f16182f.f7859b).J();
        return this.f16198w;
    }
}
