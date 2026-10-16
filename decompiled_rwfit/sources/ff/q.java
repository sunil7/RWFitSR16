package ff;

import android.graphics.PointF;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.impl.y0;
import com.example.test.ui.device.activity.f0;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import com.google.android.gms.internal.mlkit_vision_common.c6;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.gesture.Gesture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class q implements uf.g {
    public static final ef.b T = ef.b.a(q.class.getSimpleName());
    public pf.c A;
    public final lf.b B;
    public wf.c C;
    public wf.c D;
    public wf.c E;
    public Facing F;
    public Mode G;
    public Audio H;
    public long I;
    public int J;
    public int K;
    public int L;
    public long M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public tf.a S;

    /* renamed from: a, reason: collision with root package name */
    public qf.i f13645a;

    /* renamed from: c, reason: collision with root package name */
    public final ef.i f13647c;
    public vf.a e;

    /* renamed from: f, reason: collision with root package name */
    public ef.c f13649f;

    /* renamed from: g, reason: collision with root package name */
    public ab.n f13650g;

    /* renamed from: h, reason: collision with root package name */
    public wf.b f13651h;

    /* renamed from: i, reason: collision with root package name */
    public wf.b f13652i;

    /* renamed from: j, reason: collision with root package name */
    public wf.b f13653j;

    /* renamed from: k, reason: collision with root package name */
    public int f13654k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f13655l;

    /* renamed from: m, reason: collision with root package name */
    public Flash f13656m;

    /* renamed from: n, reason: collision with root package name */
    public WhiteBalance f13657n;

    /* renamed from: o, reason: collision with root package name */
    public VideoCodec f13658o;

    /* renamed from: p, reason: collision with root package name */
    public AudioCodec f13659p;

    /* renamed from: q, reason: collision with root package name */
    public Hdr f13660q;
    public PictureFormat r;

    /* renamed from: s, reason: collision with root package name */
    public Location f13661s;

    /* renamed from: t, reason: collision with root package name */
    public float f13662t;

    /* renamed from: u, reason: collision with root package name */
    public float f13663u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13664v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13665w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13666x;

    /* renamed from: y, reason: collision with root package name */
    public float f13667y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f13668z;

    /* renamed from: d, reason: collision with root package name */
    public final nf.e f13648d = new nf.e(new s(this));

    /* renamed from: b, reason: collision with root package name */
    public final Handler f13646b = new Handler(Looper.getMainLooper());

    public q(ef.i iVar) {
        this.f13647c = iVar;
        y(false);
        lf.b bVar = new lf.b();
        bVar.f15871b = 0;
        bVar.f15872c = 0;
        bVar.f15873d = 0;
        this.B = bVar;
        xc.c(null);
        xc.c(null);
        xc.c(null);
        xc.c(null);
        xc.c(null);
        xc.c(null);
        xc.c(null);
        xc.c(null);
    }

    public static void b(q qVar, Throwable th2, boolean z5) {
        qVar.getClass();
        ef.b bVar = T;
        if (z5) {
            bVar.b(3, "EXCEPTION:", "Handler thread is gone. Replacing.");
            qVar.y(false);
        }
        bVar.b(3, "EXCEPTION:", "Scheduling on the crash handler...");
        qVar.f13646b.post(new x.h(qVar, 20, th2, false));
    }

    public final void A() {
        nf.e eVar = this.f13648d;
        T.b(1, "RESTART BIND:", "scheduled. State:", eVar.e);
        R(false);
        Q(false);
        eVar.c(CameraState.ENGINE, CameraState.BIND, true, new r(this, 4));
        O();
    }

    public abstract void B(float f2, float[] fArr, PointF[] pointFArr, boolean z5);

    public abstract void C(Flash flash);

    public abstract void D(int i3);

    public abstract void E(boolean z5);

    public abstract void F(Hdr hdr);

    public abstract void G(Location location);

    public abstract void H(PictureFormat pictureFormat);

    public abstract void I(boolean z5);

    public abstract void J(float f2);

    public abstract void K(WhiteBalance whiteBalance);

    public abstract void L(float f2, PointF[] pointFArr, boolean z5);

    public final void M() {
        nf.e eVar = this.f13648d;
        T.b(1, "START:", "scheduled. State:", eVar.e);
        CameraState cameraState = CameraState.OFF;
        CameraState cameraState2 = CameraState.ENGINE;
        ia.m c9 = eVar.c(cameraState, cameraState2, true, new r(this, 2));
        c9.f14399b.f(new ia.i(ia.h.f14383a, new i0(this, 17), new ia.m(), 5));
        c9.k();
        eVar.c(cameraState2, CameraState.BIND, true, new r(this, 4));
        O();
    }

    public abstract void N(Gesture gesture, l4.c cVar, PointF pointF);

    public final ia.m O() {
        return this.f13648d.c(CameraState.BIND, CameraState.PREVIEW, true, new r(this, 0));
    }

    public final ia.m P(boolean z5) {
        nf.e eVar = this.f13648d;
        T.b(1, "STOP:", "scheduled. State:", eVar.e);
        R(z5);
        Q(z5);
        ia.m c9 = eVar.c(CameraState.ENGINE, CameraState.OFF, !z5, new r(this, 3));
        c9.b(ia.h.f14383a, new s(this));
        return c9;
    }

    public final void Q(boolean z5) {
        this.f13648d.c(CameraState.BIND, CameraState.ENGINE, !z5, new r(this, 5));
    }

    public final void R(boolean z5) {
        this.f13648d.c(CameraState.PREVIEW, CameraState.BIND, !z5, new r(this, 1));
    }

    @Override // uf.g
    public void a(y0 y0Var, Exception exc) {
        this.f13650g = null;
        ef.i iVar = this.f13647c;
        if (y0Var == null || ((byte[]) y0Var.e) == null) {
            T.b(3, "onPictureResult", "result or data is null: something went wrong.", exc);
            iVar.l(new CameraException(exc, 4));
        } else {
            ((ef.b) iVar.f12629b).b(1, "dispatchOnPictureTaken", y0Var);
            ((CameraView) iVar.f12630c).f11550j.post(new x.h(iVar, 12, y0Var, false));
        }
    }

    public abstract boolean c(Facing facing);

    public final wf.b d(Mode mode) {
        wf.c cVar;
        Set unmodifiableSet;
        boolean b3 = this.B.b(Reference.SENSOR, Reference.VIEW);
        if (mode == Mode.PICTURE) {
            cVar = this.D;
            unmodifiableSet = Collections.unmodifiableSet(this.f13649f.e);
        } else {
            cVar = this.E;
            unmodifiableSet = Collections.unmodifiableSet(this.f13649f.f12604f);
        }
        wf.c[] cVarArr = {cVar, new wf.e(0)};
        ArrayList arrayList = new ArrayList(unmodifiableSet);
        List list = null;
        for (wf.c cVar2 : cVarArr) {
            list = cVar2.a(arrayList);
            if (!list.isEmpty()) {
                break;
            }
        }
        if (list == null) {
            list = new ArrayList();
        }
        wf.b bVar = (wf.b) list.get(0);
        if (!arrayList.contains(bVar)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        T.b(1, "computeCaptureSize:", "result:", bVar, "flip:", Boolean.valueOf(b3), "mode:", mode);
        return b3 ? bVar.a() : bVar;
    }

    public final wf.b e() {
        byte b3 = 0;
        ArrayList i3 = i();
        boolean b10 = this.B.b(Reference.SENSOR, Reference.VIEW);
        ArrayList arrayList = new ArrayList(i3.size());
        int size = i3.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = i3.get(i10);
            i10++;
            wf.b bVar = (wf.b) obj;
            if (b10) {
                bVar = bVar.a();
            }
            arrayList.add(bVar);
        }
        wf.b k10 = k(Reference.VIEW);
        if (k10 == null) {
            throw new IllegalStateException("targetMinSize should not be null here.");
        }
        wf.b bVar2 = this.f13651h;
        wf.a a3 = wf.a.a(bVar2.f19627a, bVar2.f19628b);
        if (b10) {
            a3 = wf.a.a(a3.f19626b, a3.f19625a);
        }
        ef.b bVar3 = T;
        bVar3.b(1, "computePreviewStreamSize:", "targetRatio:", a3, "targetMinSize:", k10);
        wf.f a10 = c6.a(c6.b(new wf.d(a3.c())), new wf.e(0));
        wf.f a11 = c6.a(c6.b(new o2.m(b3, k10.f19628b, 11)), c6.b(new o2.m(b3, k10.f19627a, 9)), new wf.e(1));
        wf.c[] cVarArr = {c6.a(a10, a11), a11, a10, new wf.e(0)};
        wf.f fVar = new wf.f(1);
        fVar.f19632b = cVarArr;
        wf.c cVar = this.C;
        if (cVar != null) {
            wf.c[] cVarArr2 = {cVar, fVar};
            fVar = new wf.f(1);
            fVar.f19632b = cVarArr2;
        }
        wf.b bVar4 = (wf.b) fVar.a(arrayList).get(0);
        if (!arrayList.contains(bVar4)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        if (b10) {
            bVar4 = bVar4.a();
        }
        bVar3.b(1, "computePreviewStreamSize:", "result:", bVar4, "flip:", Boolean.valueOf(b10));
        return bVar4;
    }

    public final void f(int i3, boolean z5) {
        Object[] objArr = {"DESTROY:", "state:", this.f13648d.e, "thread:", Thread.currentThread(), "depth:", Integer.valueOf(i3), "unrecoverably:", Boolean.valueOf(z5)};
        ef.b bVar = T;
        bVar.b(1, objArr);
        if (z5) {
            this.f13645a.f17955b.setUncaughtExceptionHandler(new u());
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ia.m P = P(true);
        P.f14399b.f(new ia.i(this.f13645a.f17957d, new f0(countDownLatch, 16)));
        P.k();
        try {
            if (countDownLatch.await(6L, TimeUnit.SECONDS)) {
                return;
            }
            bVar.b(3, "DESTROY: Could not destroy synchronously after 6 seconds.", "Current thread:", Thread.currentThread(), "Handler thread:", this.f13645a.f17955b);
            int i10 = i3 + 1;
            if (i10 >= 2) {
                bVar.b(2, "DESTROY: Giving up because DESTROY_RETRIES was reached.");
                return;
            }
            y(true);
            bVar.b(3, "DESTROY: Trying again on thread:", this.f13645a.f17955b);
            f(i10, z5);
        } catch (InterruptedException unused) {
        }
    }

    public final pf.c g() {
        if (this.A == null) {
            this.A = m(this.R);
        }
        return this.A;
    }

    public final wf.b h(Reference reference) {
        wf.b bVar = this.f13651h;
        if (bVar == null || this.G == Mode.VIDEO) {
            return null;
        }
        return this.B.b(Reference.SENSOR, reference) ? bVar.a() : bVar;
    }

    public abstract ArrayList i();

    public final wf.b j(Reference reference) {
        wf.b bVar = this.f13652i;
        if (bVar == null) {
            return null;
        }
        return this.B.b(Reference.SENSOR, reference) ? bVar.a() : bVar;
    }

    public final wf.b k(Reference reference) {
        vf.a aVar = this.e;
        if (aVar == null) {
            return null;
        }
        if (!this.B.b(Reference.VIEW, reference)) {
            return new wf.b(aVar.f19239d, aVar.e);
        }
        return new wf.b(aVar.e, aVar.f19239d);
    }

    public final wf.b l(Reference reference) {
        wf.b j4 = j(reference);
        if (j4 == null) {
            return null;
        }
        boolean b3 = this.B.b(reference, Reference.VIEW);
        int i3 = b3 ? this.O : this.N;
        int i10 = b3 ? this.N : this.O;
        if (i3 <= 0) {
            i3 = Integer.MAX_VALUE;
        }
        if (i10 <= 0) {
            i10 = Integer.MAX_VALUE;
        }
        HashMap hashMap = wf.a.f19624c;
        int i11 = j4.f19627a;
        int i12 = j4.f19628b;
        if (wf.a.a(i3, i10).c() >= wf.a.a(i11, i12).c()) {
            return new wf.b((int) Math.floor(r6 * r3), Math.min(i12, i10));
        }
        return new wf.b(Math.min(i11, i3), (int) Math.floor(r6 / r3));
    }

    public abstract pf.c m(int i3);

    public final boolean n() {
        nf.e eVar = this.f13648d;
        synchronized (eVar.f16613d) {
            try {
                Iterator it = eVar.f16611b.iterator();
                while (it.hasNext()) {
                    nf.b bVar = (nf.b) it.next();
                    if (!bVar.f16596a.contains(" >> ") && !bVar.f16596a.contains(" << ")) {
                    }
                    if (!bVar.f16597b.f14382a.e()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean o() {
        return this.f13650g != null;
    }

    public abstract void p();

    public abstract ia.m q();

    public abstract ia.m r();

    public abstract ia.m s();

    public abstract ia.m t();

    public abstract ia.m u();

    public abstract ia.m v();

    public abstract void w(y0 y0Var, boolean z5);

    public abstract void x(y0 y0Var, wf.a aVar, boolean z5);

    public final void y(boolean z5) {
        qf.i iVar = this.f13645a;
        if (iVar != null) {
            qf.h hVar = iVar.f17955b;
            if (hVar.isAlive()) {
                hVar.interrupt();
                hVar.quit();
            }
            qf.i.f17953f.remove(iVar.f17954a);
        }
        qf.i a3 = qf.i.a("CameraViewEngine");
        this.f13645a = a3;
        a3.f17955b.setUncaughtExceptionHandler(new t(this));
        if (z5) {
            nf.e eVar = this.f13648d;
            synchronized (eVar.f16613d) {
                try {
                    HashSet hashSet = new HashSet();
                    Iterator it = eVar.f16611b.iterator();
                    while (it.hasNext()) {
                        hashSet.add(((nf.b) it.next()).f16596a);
                    }
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        eVar.e(0, (String) it2.next());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void z() {
        T.b(1, "RESTART:", "scheduled. State:", this.f13648d.e);
        P(false);
        M();
    }
}
