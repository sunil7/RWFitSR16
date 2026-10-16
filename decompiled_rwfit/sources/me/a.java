package me;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.concurrent.futures.b;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import de.o;
import ia.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import n.g0;
import n.m0;
import n.n0;
import n0.g;
import n0.i;
import o.q;
import t.a1;
import x.h;
import x.k;
import y2.f;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements d, g, x.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f16124a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16125b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16126c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f16127d;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f16124a = obj;
        this.f16125b = obj2;
        this.f16126c = obj3;
        this.f16127d = obj4;
    }

    @Override // x.a
    /* renamed from: apply */
    public ob.a mo0apply(Object obj) {
        n0 n0Var = (n0) this.f16124a;
        CameraDevice cameraDevice = (CameraDevice) this.f16125b;
        q qVar = (q) this.f16126c;
        List list = (List) this.f16127d;
        if (n0Var.f16276v.f8766a) {
            ArrayList j4 = n0Var.f16258b.j();
            int size = j4.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = j4.get(i3);
                i3++;
                ((n0) obj2).j();
            }
        }
        n0Var.l("start openCaptureSession");
        synchronized (n0Var.f16257a) {
            try {
                if (n0Var.f16268m) {
                    return new k(new CancellationException("Opener is disabled"), 1);
                }
                g0 g0Var = n0Var.f16258b;
                synchronized (g0Var.f16175b) {
                    ((LinkedHashSet) g0Var.e).add(n0Var);
                }
                i a3 = ve.a(new a(n0Var, list, new f(cameraDevice, n0Var.f16259c), qVar));
                n0Var.f16263h = a3;
                m0 m0Var = new m0(n0Var, 0);
                a3.a(new h(0, a3, m0Var), a6.a());
                return x.i.d(n0Var.f16263h);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // n0.g
    public Object b(b bVar) {
        String str;
        n0 n0Var = (n0) this.f16124a;
        List list = (List) this.f16125b;
        f fVar = (f) this.f16126c;
        q qVar = (q) this.f16127d;
        synchronized (n0Var.f16257a) {
            synchronized (n0Var.f16257a) {
                synchronized (n0Var.f16257a) {
                    try {
                        List list2 = n0Var.f16266k;
                        if (list2 != null) {
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                ((androidx.camera.core.impl.g0) it.next()).b();
                            }
                            n0Var.f16266k = null;
                        }
                    } finally {
                    }
                }
                if (!list.isEmpty()) {
                    int i3 = 0;
                    do {
                        try {
                            ((androidx.camera.core.impl.g0) list.get(i3)).d();
                            i3++;
                        } catch (DeferrableSurface$SurfaceClosedException e) {
                            for (int i10 = i3 - 1; i10 >= 0; i10--) {
                                ((androidx.camera.core.impl.g0) list.get(i10)).b();
                            }
                            throw e;
                        }
                    } while (i3 < list.size());
                }
                n0Var.f16266k = list;
            }
            pd.f("The openCaptureSessionCompleter can only set once!", n0Var.f16264i == null);
            n0Var.f16264i = bVar;
            ((androidx.camera.camera2.internal.compat.q) fVar.f19953b).D(qVar);
            str = "openCaptureSession[session=" + n0Var + "]";
        }
        return str;
    }

    @Override // ia.d
    public void onSuccess(Object obj) {
        o oVar = (o) this.f16124a;
        oVar.getClass();
        boolean isEmpty = obj == null ? true : obj instanceof Collection ? ((Collection) obj).isEmpty() : false;
        byte[] bArr = (byte[]) this.f16125b;
        i0 i0Var = (i0) this.f16126c;
        if (isEmpty) {
            ((ConcurrentLinkedQueue) oVar.f12377b).add(bArr);
            ((fe.d) i0Var.f7866b).f13588m.i(null);
        } else {
            ((a1) this.f16127d).e.b();
            ((AtomicBoolean) oVar.f12378c).set(false);
            ((fe.d) i0Var.f7866b).f13588m.i(new fe.a(obj));
        }
    }
}
