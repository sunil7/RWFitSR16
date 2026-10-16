package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.core.impl.c0;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.g0;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.utils.SurfaceUtil;
import com.example.test.utils.s0;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.me;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.te;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import n.m0;
import n.n0;
import t.t;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: d, reason: collision with root package name */
    public n0 f1270d;
    public n0 e;

    /* renamed from: f, reason: collision with root package name */
    public s1 f1271f;

    /* renamed from: i, reason: collision with root package name */
    public CaptureSession$State f1274i;

    /* renamed from: j, reason: collision with root package name */
    public n0.i f1275j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.concurrent.futures.b f1276k;

    /* renamed from: o, reason: collision with root package name */
    public final s0 f1280o;

    /* renamed from: p, reason: collision with root package name */
    public final m0 f1281p;

    /* renamed from: q, reason: collision with root package name */
    public final q.a f1282q;
    public final boolean r;

    /* renamed from: a, reason: collision with root package name */
    public final Object f1267a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1268b = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f1272g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public List f1273h = Collections.EMPTY_LIST;

    /* renamed from: l, reason: collision with root package name */
    public HashMap f1277l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    public final w0 f1278m = new w0(4);

    /* renamed from: n, reason: collision with root package name */
    public final w0 f1279n = new w0(5);

    /* renamed from: c, reason: collision with root package name */
    public final l f1269c = new l(this);

    public m(m0 m0Var, i1 i1Var, boolean z5) {
        this.f1274i = CaptureSession$State.UNINITIALIZED;
        this.f1274i = CaptureSession$State.INITIALIZED;
        this.f1281p = m0Var;
        this.f1280o = new s0(i1Var.d(CaptureNoResponseQuirk.class));
        this.f1282q = new q.a(i1Var, 1);
        this.r = z5;
    }

    public static com.example.test.ui.view.b b(List list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        CameraCaptureSession.CaptureCallback bVar;
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) it.next();
            if (kVar == null) {
                bVar = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                te.a(kVar, arrayList2);
                bVar = arrayList2.size() == 1 ? (CameraCaptureSession.CaptureCallback) arrayList2.get(0) : new com.example.test.ui.view.b(arrayList2);
            }
            arrayList.add(bVar);
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return new com.example.test.ui.view.b(arrayList);
    }

    public static HashMap c(HashMap hashMap, HashMap hashMap2) {
        HashMap hashMap3 = new HashMap();
        for (Integer num : hashMap.keySet()) {
            num.getClass();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) hashMap.get(num)).iterator();
            if (it.hasNext()) {
                SurfaceUtil.a((Surface) hashMap2.get(((androidx.camera.core.impl.f) it.next()).f1382a));
                je.c.k();
                throw null;
            }
            a0.b("CaptureSession", "Skips to create instances for multi-resolution output. imageFormat: 0, streamInfos size: " + arrayList.size());
        }
        return hashMap3;
    }

    public static HashMap f(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            androidx.camera.core.impl.f fVar = (androidx.camera.core.impl.f) obj;
            if (fVar.f1385d > 0 && fVar.f1383b.isEmpty()) {
                int i10 = fVar.f1385d;
                List list = (List) hashMap.get(Integer.valueOf(i10));
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(Integer.valueOf(i10), list);
                }
                list.add(fVar);
            }
        }
        HashMap hashMap2 = new HashMap();
        for (Integer num : hashMap.keySet()) {
            num.getClass();
            if (((List) hashMap.get(num)).size() >= 2) {
                hashMap2.put(num, (List) hashMap.get(num));
            }
        }
        return hashMap2;
    }

    public final void a() {
        synchronized (this.f1267a) {
            try {
                int ordinal = this.f1274i.ordinal();
                if (ordinal == 0) {
                    throw new IllegalStateException("close() should not be possible in state: " + this.f1274i);
                }
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        pd.e(this.f1270d, "The Opener shouldn't null in state:" + this.f1274i);
                        this.f1270d.q();
                    } else if (ordinal == 3 || ordinal == 4) {
                        pd.e(this.f1270d, "The Opener shouldn't null in state:" + this.f1274i);
                        this.f1270d.q();
                        this.f1274i = CaptureSession$State.CLOSED;
                        this.f1280o.h();
                        this.f1271f = null;
                    }
                }
                this.f1274i = CaptureSession$State.RELEASED;
            } finally {
            }
        }
    }

    public final void d() {
        CaptureSession$State captureSession$State = this.f1274i;
        CaptureSession$State captureSession$State2 = CaptureSession$State.RELEASED;
        if (captureSession$State == captureSession$State2) {
            a0.a("CaptureSession", "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.f1274i = captureSession$State2;
        this.e = null;
        androidx.concurrent.futures.b bVar = this.f1276k;
        if (bVar != null) {
            bVar.a(null);
            this.f1276k = null;
        }
    }

    public final o.h e(androidx.camera.core.impl.f fVar, HashMap hashMap, String str) {
        long j4;
        Surface surface = (Surface) hashMap.get(fVar.f1382a);
        pd.e(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        o.h hVar = new o.h(fVar.f1385d, surface);
        o.j jVar = hVar.f16623a;
        if (str != null) {
            jVar.f(str);
        } else {
            jVar.f(null);
        }
        int i3 = fVar.f1384c;
        if (i3 == 0) {
            jVar.e(1);
        } else if (i3 == 1) {
            jVar.e(2);
        }
        List list = fVar.f1383b;
        if (!list.isEmpty()) {
            ((OutputConfiguration) jVar.a()).enableSurfaceSharing();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Surface surface2 = (Surface) hashMap.get((g0) it.next());
                pd.e(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                ((OutputConfiguration) jVar.a()).addSurface(surface2);
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            m0 m0Var = this.f1281p;
            m0Var.getClass();
            pd.f("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.", i10 >= 33);
            DynamicRangeProfiles a3 = ((o.b) m0Var.f16254b).a();
            if (a3 != null) {
                t tVar = fVar.e;
                Long a10 = o.a.a(tVar, a3);
                if (a10 != null) {
                    j4 = a10.longValue();
                    jVar.d(j4);
                    return hVar;
                }
                a0.b("CaptureSession", "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + tVar);
            }
        }
        j4 = 1;
        jVar.d(j4);
        return hVar;
    }

    public final boolean g() {
        boolean z5;
        synchronized (this.f1267a) {
            try {
                CaptureSession$State captureSession$State = this.f1274i;
                z5 = captureSession$State == CaptureSession$State.OPENED || captureSession$State == CaptureSession$State.OPENING;
            } finally {
            }
        }
        return z5;
    }

    public final void h(ArrayList arrayList) {
        androidx.camera.camera2.internal.compat.f fVar;
        ArrayList arrayList2;
        boolean z5;
        n nVar;
        synchronized (this.f1267a) {
            try {
                if (this.f1274i != CaptureSession$State.OPENED) {
                    a0.a("CaptureSession", "Skipping issueBurstCaptureRequest due to session closed");
                    return;
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                try {
                    fVar = new androidx.camera.camera2.internal.compat.f(2);
                    arrayList2 = new ArrayList();
                    a0.a("CaptureSession", "Issuing capture request.");
                    int size = arrayList.size();
                    z5 = false;
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        d0 d0Var = (d0) obj;
                        if (Collections.unmodifiableList(d0Var.f1366a).isEmpty()) {
                            a0.a("CaptureSession", "Skipping issuing empty capture request.");
                        } else {
                            Iterator it = Collections.unmodifiableList(d0Var.f1366a).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    g0 g0Var = (g0) it.next();
                                    if (!this.f1272g.containsKey(g0Var)) {
                                        a0.a("CaptureSession", "Skipping capture request with invalid surface: " + g0Var);
                                        break;
                                    }
                                } else {
                                    if (d0Var.f1368c == 2) {
                                        z5 = true;
                                    }
                                    c0 c0Var = new c0(d0Var);
                                    if (d0Var.f1368c == 5 && (nVar = d0Var.f1371g) != null) {
                                        c0Var.f1359g = nVar;
                                    }
                                    s1 s1Var = this.f1271f;
                                    if (s1Var != null) {
                                        c0Var.c(s1Var.f1490g.f1367b);
                                    }
                                    c0Var.c(d0Var.f1367b);
                                    d0 d5 = c0Var.d();
                                    n0 n0Var = this.e;
                                    n0Var.f16262g.getClass();
                                    CaptureRequest c9 = me.c(d5, ((CameraCaptureSession) ((ef.i) n0Var.f16262g.f19953b).f12629b).getDevice(), this.f1272g, false, this.f1282q);
                                    if (c9 == null) {
                                        a0.a("CaptureSession", "Skipping issuing request without surface.");
                                        return;
                                    }
                                    ArrayList arrayList3 = new ArrayList();
                                    Iterator it2 = d0Var.f1369d.iterator();
                                    while (it2.hasNext()) {
                                        te.a((androidx.camera.core.impl.k) it2.next(), arrayList3);
                                    }
                                    fVar.a(c9, arrayList3);
                                    arrayList2.add(c9);
                                }
                            }
                        }
                    }
                } catch (CameraAccessException e) {
                    a0.b("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
                if (arrayList2.isEmpty()) {
                    a0.a("CaptureSession", "Skipping issuing burst request due to no valid request elements");
                    return;
                }
                if (this.f1278m.h(arrayList2, z5)) {
                    n0 n0Var2 = this.e;
                    pd.e(n0Var2.f16262g, "Need to call openCaptureSession before using this API.");
                    ((CameraCaptureSession) ((ef.i) n0Var2.f16262g.f19953b).f12629b).stopRepeating();
                    fVar.f1164b = new k(this);
                }
                if (this.f1279n.f(arrayList2, z5)) {
                    fVar.a((CaptureRequest) arrayList2.get(arrayList2.size() - 1), Collections.singletonList(new com.example.test.ui.view.b(this, 4)));
                }
                this.e.i(arrayList2, fVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void i(List list) {
        synchronized (this.f1267a) {
            try {
                switch (this.f1274i.ordinal()) {
                    case 0:
                        throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.f1274i);
                    case 1:
                    case 2:
                    case 3:
                        this.f1268b.addAll(list);
                        break;
                    case 4:
                        this.f1268b.addAll(list);
                        this.f1280o.e().a(new m5.a(this, 4), a6.a());
                        break;
                    case 5:
                    case 6:
                    case 7:
                        throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
                }
            } finally {
            }
        }
    }

    public final void j(s1 s1Var) {
        synchronized (this.f1267a) {
            try {
            } catch (Throwable th2) {
                throw th2;
            }
            if (s1Var == null) {
                a0.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
                return;
            }
            if (this.f1274i != CaptureSession$State.OPENED) {
                a0.a("CaptureSession", "Skipping issueRepeatingCaptureRequests due to session closed");
                return;
            }
            d0 d0Var = s1Var.f1490g;
            if (Collections.unmodifiableList(d0Var.f1366a).isEmpty()) {
                a0.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
                try {
                    n0 n0Var = this.e;
                    pd.e(n0Var.f16262g, "Need to call openCaptureSession before using this API.");
                    ((CameraCaptureSession) ((ef.i) n0Var.f16262g.f19953b).f12629b).stopRepeating();
                } catch (CameraAccessException e) {
                    a0.b("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
                return;
            }
            try {
                a0.a("CaptureSession", "Issuing request for session.");
                n0 n0Var2 = this.e;
                n0Var2.f16262g.getClass();
                CaptureRequest c9 = me.c(d0Var, ((CameraCaptureSession) ((ef.i) n0Var2.f16262g.f19953b).f12629b).getDevice(), this.f1272g, true, this.f1282q);
                if (c9 == null) {
                    a0.a("CaptureSession", "Skipping issuing empty request for session.");
                    return;
                } else {
                    this.e.o(c9, this.f1280o.c(b(d0Var.f1369d, new CameraCaptureSession.CaptureCallback[0])));
                    return;
                }
            } catch (CameraAccessException e10) {
                a0.b("CaptureSession", "Unable to access camera: " + e10.getMessage());
                Thread.dumpStack();
                return;
            }
            throw th2;
        }
    }

    public final ob.a k(final s1 s1Var, final CameraDevice cameraDevice, n0 n0Var) {
        ob.a p8;
        synchronized (this.f1267a) {
            try {
                if (this.f1274i.ordinal() != 1) {
                    a0.b("CaptureSession", "Open not allowed in state: " + this.f1274i);
                    return new x.k(new IllegalStateException("open() should not allow the state: " + this.f1274i), 1);
                }
                this.f1274i = CaptureSession$State.GET_SURFACE;
                ArrayList arrayList = new ArrayList(s1Var.b());
                this.f1273h = arrayList;
                this.f1270d = n0Var;
                synchronized (n0Var.f16271p) {
                    n0Var.f16272q = arrayList;
                    p8 = n0Var.p(arrayList);
                }
                x.d b3 = x.d.b(p8);
                x.a aVar = new x.a() { // from class: androidx.camera.camera2.internal.j
                    /* JADX WARN: Removed duplicated region for block: B:37:0x014b A[Catch: all -> 0x003f, TryCatch #1 {all -> 0x003f, blocks: (B:4:0x0016, B:10:0x0025, B:11:0x003d, B:14:0x0042, B:15:0x0048, B:17:0x004e, B:19:0x0063, B:20:0x00c6, B:22:0x00cc, B:24:0x00e4, B:26:0x00f6, B:28:0x00fa, B:29:0x0106, B:31:0x0123, B:33:0x0135, B:35:0x013d, B:37:0x014b, B:39:0x015d, B:41:0x0175, B:48:0x0182, B:50:0x0196, B:53:0x01ab, B:60:0x01b8, B:62:0x01d1, B:64:0x01d5, B:66:0x01de, B:67:0x01ff, B:69:0x0205, B:71:0x0215, B:73:0x022f, B:75:0x0234, B:76:0x023c, B:79:0x023f, B:80:0x0245, B:82:0x0247, B:83:0x0260), top: B:3:0x0016, inners: #0 }] */
                    /* JADX WARN: Removed duplicated region for block: B:44:0x0172  */
                    @Override // x.a
                    /* renamed from: apply */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final ob.a mo0apply(java.lang.Object r25) {
                        /*
                            Method dump skipped, instructions count: 612
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.j.mo0apply(java.lang.Object):ob.a");
                    }
                };
                androidx.camera.core.impl.utils.executor.b bVar = this.f1270d.f16260d;
                b3.getClass();
                x.b f2 = x.i.f(b3, aVar, bVar);
                f2.a(new x.h(0, f2, new mc.g(this, 2)), this.f1270d.f16260d);
                return x.i.d(f2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final ob.a l() {
        synchronized (this.f1267a) {
            try {
                switch (this.f1274i.ordinal()) {
                    case 0:
                        throw new IllegalStateException("release() should not be possible in state: " + this.f1274i);
                    case 2:
                        pd.e(this.f1270d, "The Opener shouldn't null in state:" + this.f1274i);
                        this.f1270d.q();
                    case 1:
                        this.f1274i = CaptureSession$State.RELEASED;
                        return x.k.f19707c;
                    case 4:
                    case 5:
                        n0 n0Var = this.e;
                        if (n0Var != null) {
                            n0Var.j();
                        }
                    case 3:
                        this.f1274i = CaptureSession$State.RELEASING;
                        this.f1280o.h();
                        pd.e(this.f1270d, "The Opener shouldn't null in state:" + this.f1274i);
                        if (this.f1270d.q()) {
                            d();
                            return x.k.f19707c;
                        }
                    case 6:
                        if (this.f1275j == null) {
                            this.f1275j = ve.a(new af.a(this, 21));
                        }
                        return this.f1275j;
                    default:
                        return x.k.f19707c;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void m(s1 s1Var) {
        synchronized (this.f1267a) {
            try {
                switch (this.f1274i.ordinal()) {
                    case 0:
                        throw new IllegalStateException("setSessionConfig() should not be possible in state: " + this.f1274i);
                    case 1:
                    case 2:
                    case 3:
                        this.f1271f = s1Var;
                        break;
                    case 4:
                        this.f1271f = s1Var;
                        if (s1Var != null) {
                            if (!this.f1272g.keySet().containsAll(s1Var.b())) {
                                a0.b("CaptureSession", "Does not have the proper configured lists");
                                return;
                            } else {
                                a0.a("CaptureSession", "Attempting to submit CaptureRequest after setting");
                                j(this.f1271f);
                                break;
                            }
                        } else {
                            return;
                        }
                    case 5:
                    case 6:
                    case 7:
                        throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
                }
            } finally {
            }
        }
    }
}
