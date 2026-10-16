package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.n;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import androidx.camera.camera2.internal.compat.u;
import androidx.camera.core.impl.CameraInternal$State;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.b1;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.r1;
import androidx.camera.core.impl.s0;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.v0;
import androidx.camera.core.impl.y1;
import androidx.camera.core.impl.z;
import androidx.lifecycle.b0;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.ui.device.activity.f0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.ne;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.se;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import n.g0;
import n.h0;
import n.i0;
import n.m0;
import n.n0;
import n.y;

/* loaded from: classes.dex */
public final class i implements v {
    public final HashSet A;
    public o B;
    public final Object C;
    public boolean D;
    public final y E;
    public final m0 F;
    public final i0 G;
    public final com.example.test.utils.y H;

    /* renamed from: a, reason: collision with root package name */
    public final com.example.test.utils.y f1238a;

    /* renamed from: b, reason: collision with root package name */
    public final u f1239b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.camera.core.impl.utils.executor.b f1240c;

    /* renamed from: d, reason: collision with root package name */
    public final w.c f1241d;
    public volatile Camera2CameraImpl$InternalState e = Camera2CameraImpl$InternalState.INITIALIZED;

    /* renamed from: f, reason: collision with root package name */
    public final ef.i f1242f;

    /* renamed from: g, reason: collision with root package name */
    public final com.example.test.utils.y f1243g;

    /* renamed from: h, reason: collision with root package name */
    public final n.h f1244h;

    /* renamed from: i, reason: collision with root package name */
    public final h f1245i;

    /* renamed from: j, reason: collision with root package name */
    public final n.o f1246j;

    /* renamed from: k, reason: collision with root package name */
    public CameraDevice f1247k;

    /* renamed from: l, reason: collision with root package name */
    public int f1248l;

    /* renamed from: m, reason: collision with root package name */
    public m f1249m;

    /* renamed from: n, reason: collision with root package name */
    public final LinkedHashMap f1250n;

    /* renamed from: o, reason: collision with root package name */
    public int f1251o;

    /* renamed from: p, reason: collision with root package name */
    public final e f1252p;

    /* renamed from: q, reason: collision with root package name */
    public final f8.f f1253q;
    public final z r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f1254s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f1255t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1256u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1257v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1258w;

    /* renamed from: x, reason: collision with root package name */
    public g0 f1259x;

    /* renamed from: y, reason: collision with root package name */
    public final g0 f1260y;

    /* renamed from: z, reason: collision with root package name */
    public final g0 f1261z;

    public i(Context context, u uVar, String str, n.o oVar, f8.f fVar, z zVar, Executor executor, Handler handler, y yVar, long j4) {
        ef.i iVar = new ef.i(4);
        this.f1242f = iVar;
        this.f1248l = 0;
        new AtomicInteger(0);
        this.f1250n = new LinkedHashMap();
        this.f1251o = 0;
        this.f1256u = false;
        this.f1257v = false;
        this.f1258w = true;
        this.A = new HashSet();
        this.B = r.f1477a;
        this.C = new Object();
        this.D = false;
        this.H = new com.example.test.utils.y(this);
        this.f1239b = uVar;
        this.f1253q = fVar;
        this.r = zVar;
        w.c cVar = new w.c(handler);
        this.f1241d = cVar;
        androidx.camera.core.impl.utils.executor.b bVar = new androidx.camera.core.impl.utils.executor.b(executor);
        this.f1240c = bVar;
        this.f1245i = new h(this, bVar, cVar, j4);
        this.f1238a = new com.example.test.utils.y(str);
        ((b0) iVar.f12629b).i(new v0(CameraInternal$State.CLOSED));
        com.example.test.utils.y yVar2 = new com.example.test.utils.y(zVar);
        this.f1243g = yVar2;
        g0 g0Var = new g0();
        g0Var.f16175b = new Object();
        g0Var.f16176c = new LinkedHashSet();
        g0Var.f16177d = new LinkedHashSet();
        g0Var.e = new LinkedHashSet();
        g0Var.f16178f = new com.example.test.ui.view.a(g0Var, 2);
        g0Var.f16174a = bVar;
        this.f1260y = g0Var;
        this.E = yVar;
        try {
            n b3 = uVar.b(str);
            n.h hVar = new n.h(b3, cVar, bVar, new f0(this, 29), oVar.f16286j);
            this.f1244h = hVar;
            this.f1246j = oVar;
            oVar.o(hVar);
            oVar.f16284h.m((b0) yVar2.f8774c);
            this.F = m0.A(b3);
            this.f1249m = y();
            this.f1261z = new g0(bVar, cVar, handler, g0Var, oVar.f16286j, p.a.f17285a);
            this.f1254s = oVar.f16286j.d(LegacyCameraOutputConfigNullPointerQuirk.class);
            this.f1255t = oVar.f16286j.d(LegacyCameraSurfaceCleanupQuirk.class);
            e eVar = new e(this, str);
            this.f1252p = eVar;
            f fVar2 = new f(this);
            synchronized (zVar.f1535b) {
                pd.f("Camera is already registered: " + this, !zVar.e.containsKey(this));
                zVar.e.put(this, new androidx.camera.core.impl.y(bVar, fVar2, eVar));
            }
            uVar.f1223a.I(bVar, eVar);
            this.G = new i0(context, str, uVar, new n9.e(15));
        } catch (CameraAccessExceptionCompat e) {
            throw se.a(e);
        }
    }

    public static String u(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    public static String v(g0 g0Var) {
        StringBuilder sb2 = new StringBuilder("MeteringRepeating");
        g0Var.getClass();
        sb2.append(g0Var.hashCode());
        return sb2.toString();
    }

    public static String w(androidx.camera.core.f fVar) {
        return fVar.f() + fVar.hashCode();
    }

    public final void A() {
        int i3 = 0;
        pd.f(null, this.e == Camera2CameraImpl$InternalState.OPENED);
        r1 p8 = this.f1238a.p();
        if (!p8.f1480k || !p8.f1479j) {
            s("Unable to create capture session due to conflicting configurations", null);
            return;
        }
        if (!this.r.e(this.f1247k.getId(), this.f1253q.c(this.f1247k.getId()))) {
            s("Unable to create capture session in camera operating mode = " + this.f1253q.f13516b, null);
            return;
        }
        HashMap hashMap = new HashMap();
        Collection<s1> q5 = this.f1238a.q();
        Collection r = this.f1238a.r();
        androidx.camera.core.impl.c cVar = h0.f16200a;
        ArrayList arrayList = new ArrayList(r);
        Iterator it = q5.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            s1 s1Var = (s1) it.next();
            d1 d1Var = s1Var.f1490g.f1367b;
            androidx.camera.core.impl.c cVar2 = h0.f16200a;
            if (d1Var.f1374a.containsKey(cVar2) && s1Var.b().size() != 1) {
                a0.b("StreamUseCaseUtil", String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", Integer.valueOf(s1Var.b().size())));
                break;
            }
            if (s1Var.f1490g.f1367b.f1374a.containsKey(cVar2)) {
                int i10 = 0;
                for (s1 s1Var2 : q5) {
                    if (((a2) arrayList.get(i10)).p() == UseCaseConfigFactory$CaptureType.METERING_REPEATING) {
                        pd.f("MeteringRepeating should contain a surface", !s1Var2.b().isEmpty());
                        hashMap.put((androidx.camera.core.impl.g0) s1Var2.b().get(0), 1L);
                    } else if (s1Var2.f1490g.f1367b.f1374a.containsKey(cVar2) && !s1Var2.b().isEmpty()) {
                        hashMap.put((androidx.camera.core.impl.g0) s1Var2.b().get(0), (Long) s1Var2.f1490g.f1367b.e(cVar2));
                    }
                    i10++;
                }
            }
        }
        m mVar = this.f1249m;
        synchronized (mVar.f1267a) {
            mVar.f1277l = hashMap;
        }
        m mVar2 = this.f1249m;
        s1 b3 = p8.b();
        CameraDevice cameraDevice = this.f1247k;
        cameraDevice.getClass();
        g0 g0Var = this.f1261z;
        ob.a k10 = mVar2.k(b3, cameraDevice, new n0((i1) g0Var.e, (i1) g0Var.f16178f, (g0) g0Var.f16177d, (androidx.camera.core.impl.utils.executor.b) g0Var.f16174a, (w.c) g0Var.f16175b, (Handler) g0Var.f16176c));
        k10.a(new x.h(i3, k10, new d(this, mVar2)), this.f1240c);
    }

    public final void B() {
        if (this.f1259x != null) {
            StringBuilder sb2 = new StringBuilder("MeteringRepeating");
            this.f1259x.getClass();
            sb2.append(this.f1259x.hashCode());
            String sb3 = sb2.toString();
            com.example.test.utils.y yVar = this.f1238a;
            LinkedHashMap linkedHashMap = (LinkedHashMap) yVar.f8774c;
            if (linkedHashMap.containsKey(sb3)) {
                y1 y1Var = (y1) linkedHashMap.get(sb3);
                y1Var.e = false;
                if (!y1Var.f1533f) {
                    linkedHashMap.remove(sb3);
                }
            }
            StringBuilder sb4 = new StringBuilder("MeteringRepeating");
            this.f1259x.getClass();
            sb4.append(this.f1259x.hashCode());
            String sb5 = sb4.toString();
            LinkedHashMap linkedHashMap2 = (LinkedHashMap) yVar.f8774c;
            if (linkedHashMap2.containsKey(sb5)) {
                y1 y1Var2 = (y1) linkedHashMap2.get(sb5);
                y1Var2.f1533f = false;
                if (!y1Var2.e) {
                    linkedHashMap2.remove(sb5);
                }
            }
            g0 g0Var = this.f1259x;
            g0Var.getClass();
            a0.a("MeteringRepeating", "MeteringRepeating clear!");
            s0 s0Var = (s0) g0Var.f16174a;
            if (s0Var != null) {
                s0Var.a();
            }
            g0Var.f16174a = null;
            this.f1259x = null;
        }
    }

    public final void C() {
        s1 s1Var;
        List unmodifiableList;
        pd.f(null, this.f1249m != null);
        s("Resetting Capture Session", null);
        m mVar = this.f1249m;
        synchronized (mVar.f1267a) {
            s1Var = mVar.f1271f;
        }
        synchronized (mVar.f1267a) {
            unmodifiableList = Collections.unmodifiableList(mVar.f1268b);
        }
        m y4 = y();
        this.f1249m = y4;
        y4.m(s1Var);
        this.f1249m.i(unmodifiableList);
        if (this.e.ordinal() != 8) {
            s("Skipping Capture Session state check due to current camera state: " + this.e + " and previous session status: " + mVar.g(), null);
        } else if (this.f1254s && mVar.g()) {
            s("Close camera before creating new session", null);
            D(Camera2CameraImpl$InternalState.REOPENING_QUIRK);
        }
        if (this.f1255t && mVar.g()) {
            s("ConfigAndClose is required when close the camera.", null);
            this.f1256u = true;
        }
        mVar.a();
        ob.a l3 = mVar.l();
        s("Releasing session in state " + this.e.name(), null);
        this.f1250n.put(mVar, l3);
        l3.a(new x.h(0, l3, new ef.i(this, 26, mVar, false)), a6.a());
    }

    public final void D(Camera2CameraImpl$InternalState camera2CameraImpl$InternalState) {
        E(camera2CameraImpl$InternalState, null, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r10, t.f r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.i.E(androidx.camera.camera2.internal.Camera2CameraImpl$InternalState, t.f, boolean):void");
    }

    public final ArrayList F(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            androidx.camera.core.f fVar = (androidx.camera.core.f) obj;
            boolean z5 = this.f1258w;
            String w8 = w(fVar);
            Class<?> cls = fVar.getClass();
            s1 s1Var = z5 ? fVar.f1330m : fVar.f1331n;
            a2 a2Var = fVar.f1323f;
            androidx.camera.core.impl.h hVar = fVar.f1324g;
            arrayList2.add(new n.b(w8, cls, s1Var, a2Var, hVar != null ? hVar.f1405a : null, hVar, fVar.b() != null ? g0.c.G(fVar) : null));
        }
        return arrayList2;
    }

    public final void G(ArrayList arrayList) {
        boolean z5;
        y1 y1Var;
        Size size;
        boolean isEmpty = this.f1238a.q().isEmpty();
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        Rational rational = null;
        int i3 = 0;
        while (i3 < size2) {
            Object obj = arrayList.get(i3);
            i3++;
            n.b bVar = (n.b) obj;
            if (!this.f1238a.z(bVar.f16137a)) {
                com.example.test.utils.y yVar = this.f1238a;
                String str = bVar.f16137a;
                s1 s1Var = bVar.f16139c;
                a2 a2Var = bVar.f16140d;
                androidx.camera.core.impl.h hVar = bVar.f16141f;
                ArrayList arrayList3 = bVar.f16142g;
                LinkedHashMap linkedHashMap = (LinkedHashMap) yVar.f8774c;
                y1 y1Var2 = (y1) linkedHashMap.get(str);
                if (y1Var2 == null) {
                    y1Var = new y1(s1Var, a2Var, hVar, arrayList3);
                    linkedHashMap.put(str, y1Var);
                } else {
                    y1Var = y1Var2;
                }
                y1Var.e = true;
                yVar.J(str, s1Var, a2Var, hVar, arrayList3);
                arrayList2.add(bVar.f16137a);
                if (bVar.f16138b == androidx.camera.core.c.class && (size = bVar.e) != null) {
                    rational = new Rational(size.getWidth(), size.getHeight());
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        s("Use cases [" + TextUtils.join(", ", arrayList2) + "] now ATTACHED", null);
        if (isEmpty) {
            z5 = true;
            this.f1244h.t(true);
            n.h hVar2 = this.f1244h;
            synchronized (hVar2.f16181d) {
                hVar2.f16192p++;
            }
        } else {
            z5 = true;
        }
        o();
        K();
        J();
        C();
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = this.e;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState2 = Camera2CameraImpl$InternalState.OPENED;
        if (camera2CameraImpl$InternalState == camera2CameraImpl$InternalState2) {
            A();
        } else {
            int ordinal = this.e.ordinal();
            if (ordinal == 2 || ordinal == 3) {
                H(false);
            } else if (ordinal != 4) {
                s("open() ignored due to being in state: " + this.e, null);
            } else {
                D(Camera2CameraImpl$InternalState.REOPENING);
                if (!this.f1250n.isEmpty() && !this.f1257v && this.f1248l == 0) {
                    pd.f("Camera Device should be open if session close is not complete", this.f1247k != null ? z5 : false);
                    D(camera2CameraImpl$InternalState2);
                    A();
                }
            }
        }
        if (rational != null) {
            this.f1244h.f16184h.e = rational;
        }
    }

    public final void H(boolean z5) {
        s("Attempting to force open the camera.", null);
        if (this.r.d(this)) {
            z(z5);
        } else {
            s("No cameras available. Waiting for available camera before opening camera.", null);
            D(Camera2CameraImpl$InternalState.PENDING_OPEN);
        }
    }

    public final void I(boolean z5) {
        s("Attempting to open the camera.", null);
        if (this.f1252p.f1228b && this.r.d(this)) {
            z(z5);
        } else {
            s("No cameras available. Waiting for available camera before opening camera.", null);
            D(Camera2CameraImpl$InternalState.PENDING_OPEN);
        }
    }

    public final void J() {
        com.example.test.utils.y yVar = this.f1238a;
        yVar.getClass();
        r1 r1Var = new r1();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) yVar.f8774c).entrySet()) {
            y1 y1Var = (y1) entry.getValue();
            if (y1Var.f1533f && y1Var.e) {
                String str = (String) entry.getKey();
                r1Var.a(y1Var.f1529a);
                arrayList.add(str);
            }
        }
        a0.a("UseCaseAttachState", "Active and attached use case: " + arrayList + " for camera: " + ((String) yVar.f8773b));
        boolean z5 = r1Var.f1480k && r1Var.f1479j;
        n.h hVar = this.f1244h;
        if (!z5) {
            hVar.f16197v = 1;
            hVar.f16184h.f16162m = 1;
            hVar.f16190n.getClass();
            this.f1249m.m(hVar.n());
            return;
        }
        int i3 = r1Var.b().f1490g.f1368c;
        hVar.f16197v = i3;
        hVar.f16184h.f16162m = i3;
        hVar.f16190n.getClass();
        r1Var.a(hVar.n());
        this.f1249m.m(r1Var.b());
    }

    public final void K() {
        Iterator it = this.f1238a.r().iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= ((Boolean) ((a2) it.next()).k(a2.I0, Boolean.FALSE)).booleanValue();
        }
        this.f1244h.f16188l.f16330c = z5;
    }

    @Override // androidx.camera.core.impl.v
    public final void a(final boolean z5) {
        this.f1240c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.c
            @Override // java.lang.Runnable
            public final void run() {
                i iVar = i.this;
                boolean z6 = z5;
                iVar.D = z6;
                if (z6 && iVar.e == Camera2CameraImpl$InternalState.PENDING_OPEN) {
                    iVar.H(false);
                }
            }
        });
    }

    @Override // androidx.camera.core.impl.v
    public final void b(q qVar) {
        if (qVar == null) {
            qVar = r.f1477a;
        }
        qVar.q();
        this.B = qVar;
        synchronized (this.C) {
        }
    }

    @Override // t.g1
    public final void c(androidx.camera.core.f fVar) {
        this.f1240c.execute(new n.k(this, w(fVar), this.f1258w ? fVar.f1330m : fVar.f1331n, fVar.f1323f, fVar.f1324g, fVar.b() == null ? null : g0.c.G(fVar), 1));
    }

    @Override // androidx.camera.core.impl.v
    public final void d(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return;
        }
        final ArrayList arrayList3 = new ArrayList(F(arrayList2));
        ArrayList arrayList4 = new ArrayList(arrayList2);
        int size = arrayList4.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList4.get(i3);
            i3++;
            androidx.camera.core.f fVar = (androidx.camera.core.f) obj;
            String w8 = w(fVar);
            HashSet hashSet = this.A;
            if (hashSet.contains(w8)) {
                fVar.u();
                hashSet.remove(w8);
            }
        }
        this.f1240c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.a
            @Override // java.lang.Runnable
            public final void run() {
                n.l lVar;
                i iVar = i.this;
                ArrayList arrayList5 = arrayList3;
                iVar.getClass();
                ArrayList arrayList6 = new ArrayList();
                int size2 = arrayList5.size();
                boolean z5 = false;
                int i10 = 0;
                while (i10 < size2) {
                    Object obj2 = arrayList5.get(i10);
                    i10++;
                    n.b bVar = (n.b) obj2;
                    if (iVar.f1238a.z(bVar.f16137a)) {
                        ((LinkedHashMap) iVar.f1238a.f8774c).remove(bVar.f16137a);
                        arrayList6.add(bVar.f16137a);
                        if (bVar.f16138b == androidx.camera.core.c.class) {
                            z5 = true;
                        }
                    }
                }
                if (arrayList6.isEmpty()) {
                    return;
                }
                iVar.s("Use cases [" + TextUtils.join(", ", arrayList6) + "] now DETACHED for camera", null);
                if (z5) {
                    iVar.f1244h.f16184h.e = null;
                }
                iVar.o();
                if (iVar.f1238a.r().isEmpty()) {
                    iVar.f1244h.f16188l.f16330c = false;
                } else {
                    iVar.K();
                }
                if (!iVar.f1238a.q().isEmpty()) {
                    iVar.J();
                    iVar.C();
                    if (iVar.e == Camera2CameraImpl$InternalState.OPENED) {
                        iVar.A();
                        return;
                    }
                    return;
                }
                iVar.f1244h.l();
                iVar.C();
                iVar.f1244h.t(false);
                iVar.f1249m = iVar.y();
                iVar.s("Closing camera.", null);
                switch (iVar.e.ordinal()) {
                    case 3:
                        pd.f(null, iVar.f1247k == null);
                        iVar.D(Camera2CameraImpl$InternalState.INITIALIZED);
                        break;
                    case 4:
                    default:
                        iVar.s("close() ignored due to being in state: " + iVar.e, null);
                        break;
                    case 5:
                    case 6:
                    case 7:
                        if (iVar.f1245i.a() || ((lVar = (n.l) iVar.H.f8773b) != null && !((AtomicBoolean) lVar.f16246c).get())) {
                            r4 = true;
                        }
                        iVar.H.l();
                        iVar.D(Camera2CameraImpl$InternalState.CLOSING);
                        if (r4) {
                            pd.f(null, iVar.f1250n.isEmpty());
                            iVar.q();
                            break;
                        }
                        break;
                    case 8:
                    case 9:
                        iVar.D(Camera2CameraImpl$InternalState.CLOSING);
                        iVar.p();
                        break;
                }
            }
        });
    }

    @Override // androidx.camera.core.impl.v
    public final void e(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return;
        }
        n.h hVar = this.f1244h;
        synchronized (hVar.f16181d) {
            hVar.f16192p++;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        int size = arrayList3.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList3.get(i3);
            i3++;
            androidx.camera.core.f fVar = (androidx.camera.core.f) obj;
            String w8 = w(fVar);
            HashSet hashSet = this.A;
            if (!hashSet.contains(w8)) {
                hashSet.add(w8);
                fVar.t();
                fVar.r();
            }
        }
        try {
            this.f1240c.execute(new androidx.appcompat.app.i0(27, this, new ArrayList(F(arrayList2))));
        } catch (RejectedExecutionException e) {
            s("Unable to attach use cases.", e);
            hVar.l();
        }
    }

    @Override // androidx.camera.core.impl.v
    public final void g(boolean z5) {
        this.f1258w = z5;
    }

    @Override // androidx.camera.core.impl.v
    public final androidx.camera.core.impl.u h() {
        return this.f1246j;
    }

    @Override // t.g1
    public final void i(androidx.camera.core.f fVar) {
        fVar.getClass();
        this.f1240c.execute(new b(this, w(fVar), this.f1258w ? fVar.f1330m : fVar.f1331n, fVar.f1323f, fVar.f1324g, fVar.b() == null ? null : g0.c.G(fVar)));
    }

    @Override // t.g1
    public final void j(androidx.camera.core.f fVar) {
        this.f1240c.execute(new androidx.appcompat.app.i0(28, this, w(fVar)));
    }

    @Override // t.g1
    public final void k(androidx.camera.core.f fVar) {
        this.f1240c.execute(new n.k(this, w(fVar), this.f1258w ? fVar.f1330m : fVar.f1331n, fVar.f1323f, fVar.f1324g, fVar.b() == null ? null : g0.c.G(fVar), 0));
    }

    @Override // androidx.camera.core.impl.v
    public final b1 l() {
        return this.f1242f;
    }

    @Override // androidx.camera.core.impl.v
    public final t m() {
        return this.f1244h;
    }

    @Override // androidx.camera.core.impl.v
    public final o n() {
        return this.B;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0107, code lost:
    
        r4 = (android.util.Size) r6.get(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o() {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.i.o():void");
    }

    public final void p() {
        ArrayList arrayList;
        int i3 = 0;
        pd.f("closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.e + " (error: " + u(this.f1248l) + ")", this.e == Camera2CameraImpl$InternalState.CLOSING || this.e == Camera2CameraImpl$InternalState.RELEASING || (this.e == Camera2CameraImpl$InternalState.REOPENING && this.f1248l != 0));
        C();
        m mVar = this.f1249m;
        synchronized (mVar.f1267a) {
            try {
                if (mVar.f1268b.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(mVar.f1268b);
                    mVar.f1268b.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                d0 d0Var = (d0) obj;
                for (androidx.camera.core.impl.k kVar : d0Var.f1369d) {
                    Object obj2 = d0Var.f1370f.f1514a.get("CAPTURE_CONFIG_ID_KEY");
                    kVar.a(obj2 == null ? -1 : ((Integer) obj2).intValue());
                }
            }
        }
    }

    public final void q() {
        pd.f(null, this.e == Camera2CameraImpl$InternalState.RELEASING || this.e == Camera2CameraImpl$InternalState.CLOSING);
        pd.f(null, this.f1250n.isEmpty());
        if (!this.f1256u) {
            t();
            return;
        }
        if (this.f1257v) {
            s("Ignored since configAndClose is processing", null);
            return;
        }
        if (!this.f1252p.f1228b) {
            this.f1256u = false;
            t();
            s("Ignore configAndClose and finish the close flow directly since camera is unavailable.", null);
        } else {
            s("Open camera to configAndClose", null);
            n0.i a3 = ve.a(new n.j(this, 0));
            this.f1257v = true;
            a3.f16358b.a(new m5.a(this, 1), this.f1240c);
        }
    }

    public final CameraDevice.StateCallback r() {
        ArrayList arrayList = new ArrayList(this.f1238a.p().b().f1487c);
        arrayList.add((com.example.test.ui.view.a) this.f1260y.f16178f);
        arrayList.add(this.f1245i);
        return ne.a(arrayList);
    }

    public final void s(String str, Throwable th2) {
        String p8 = l0.p(Const.STR_MART_JSON_BEGIN, toString(), "} ", str);
        if (a0.d(3, "Camera2CameraImpl")) {
            Log.d("Camera2CameraImpl", p8, th2);
        }
    }

    public final void t() {
        pd.f(null, this.e == Camera2CameraImpl$InternalState.RELEASING || this.e == Camera2CameraImpl$InternalState.CLOSING);
        pd.f(null, this.f1250n.isEmpty());
        this.f1247k = null;
        if (this.e == Camera2CameraImpl$InternalState.CLOSING) {
            D(Camera2CameraImpl$InternalState.INITIALIZED);
            return;
        }
        this.f1239b.f1223a.P(this.f1252p);
        D(Camera2CameraImpl$InternalState.RELEASED);
    }

    public final String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.f1246j.f16278a);
    }

    public final boolean x() {
        int i3;
        ArrayList arrayList = new ArrayList();
        synchronized (this.C) {
            try {
                i3 = this.f1253q.f13516b == 2 ? 1 : 0;
            } finally {
            }
        }
        com.example.test.utils.y yVar = this.f1238a;
        yVar.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) yVar.f8774c).entrySet()) {
            if (((y1) entry.getValue()).e) {
                arrayList2.add((y1) entry.getValue());
            }
        }
        for (y1 y1Var : Collections.unmodifiableCollection(arrayList2)) {
            List list = y1Var.f1532d;
            if (list == null || list.get(0) != UseCaseConfigFactory$CaptureType.METERING_REPEATING) {
                if (y1Var.f1531c == null || y1Var.f1532d == null) {
                    a0.e("Camera2CameraImpl", "Invalid stream spec or capture types in " + y1Var);
                    return false;
                }
                s1 s1Var = y1Var.f1529a;
                a2 a2Var = y1Var.f1530b;
                for (androidx.camera.core.impl.g0 g0Var : s1Var.b()) {
                    i0 i0Var = this.G;
                    int A = a2Var.A();
                    androidx.camera.core.impl.i c9 = androidx.camera.core.impl.i.c(i3, A, g0Var.f1398h, i0Var.i(A));
                    int A2 = a2Var.A();
                    Size size = g0Var.f1398h;
                    androidx.camera.core.impl.h hVar = y1Var.f1531c;
                    arrayList.add(new androidx.camera.core.impl.a(c9, A2, size, hVar.f1406b, y1Var.f1532d, hVar.f1408d, (Range) a2Var.k(a2.H0, null)));
                }
            }
        }
        this.f1259x.getClass();
        HashMap hashMap = new HashMap();
        g0 g0Var2 = this.f1259x;
        hashMap.put((n.f0) g0Var2.f16176c, Collections.singletonList((Size) g0Var2.f16177d));
        try {
            this.G.g(i3, arrayList, hashMap, false, false);
            s("Surface combination with metering repeating supported!", null);
            return true;
        } catch (IllegalArgumentException e) {
            s("Surface combination with metering repeating  not supported!", e);
            return false;
        }
    }

    public final m y() {
        m mVar;
        synchronized (this.C) {
            mVar = new m(this.F, this.f1246j.f16286j, false);
        }
        return mVar;
    }

    public final void z(boolean z5) {
        if (!z5) {
            this.f1245i.e.f16251b = -1L;
        }
        this.f1245i.a();
        this.H.l();
        s("Opening camera.", null);
        D(Camera2CameraImpl$InternalState.OPENING);
        try {
            this.f1239b.f1223a.H(this.f1246j.f16278a, this.f1240c, r());
        } catch (CameraAccessExceptionCompat e) {
            s("Unable to open camera due to " + e.getMessage(), null);
            if (e.getReason() == 10001) {
                E(Camera2CameraImpl$InternalState.INITIALIZED, new t.f(7, e), true);
                return;
            }
            com.example.test.utils.y yVar = this.H;
            if (((i) yVar.f8774c).e != Camera2CameraImpl$InternalState.OPENING) {
                ((i) yVar.f8774c).s("Don't need the onError timeout handler.", null);
                return;
            }
            ((i) yVar.f8774c).s("Camera waiting for onError.", null);
            yVar.l();
            yVar.f8773b = new n.l(yVar);
        } catch (SecurityException e10) {
            s("Unable to open camera due to " + e10.getMessage(), null);
            D(Camera2CameraImpl$InternalState.REOPENING);
            this.f1245i.b();
        }
    }
}
