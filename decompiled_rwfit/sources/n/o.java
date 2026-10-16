package n;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraState$Type;
import androidx.camera.core.impl.i1;
import com.google.android.gms.internal.mlkit_vision_barcode.of;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class o implements androidx.camera.core.impl.u {

    /* renamed from: a, reason: collision with root package name */
    public final String f16278a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.camera2.internal.compat.n f16279b;

    /* renamed from: c, reason: collision with root package name */
    public final m0 f16280c;
    public h e;

    /* renamed from: h, reason: collision with root package name */
    public final n f16284h;

    /* renamed from: j, reason: collision with root package name */
    public final i1 f16286j;

    /* renamed from: d, reason: collision with root package name */
    public final Object f16281d = new Object();

    /* renamed from: f, reason: collision with root package name */
    public n f16282f = null;

    /* renamed from: g, reason: collision with root package name */
    public n f16283g = null;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f16285i = null;

    public o(androidx.camera.camera2.internal.compat.u uVar, String str) {
        str.getClass();
        this.f16278a = str;
        androidx.camera.camera2.internal.compat.n b3 = uVar.b(str);
        this.f16279b = b3;
        m0 m0Var = new m0(14, false);
        m0Var.f16254b = this;
        this.f16280c = m0Var;
        this.f16286j = of.a(b3);
        new HashMap();
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            com.google.android.gms.internal.mlkit_vision_common.a0.e("Camera2EncoderProfilesProvider", "Camera id is not an integer: " + str + ", unable to create Camera2EncoderProfilesProvider");
        }
        this.f16284h = new n(new t.e(CameraState$Type.CLOSED, null));
    }

    @Override // androidx.camera.core.impl.u
    public final int a() {
        return f(0);
    }

    @Override // androidx.camera.core.impl.u
    public final int b() {
        Integer num = (Integer) this.f16279b.a(CameraCharacteristics.LENS_FACING);
        pd.a("Unable to get the lens facing of the camera.", num != null);
        int intValue = num.intValue();
        if (intValue == 0) {
            return 0;
        }
        if (intValue == 1) {
            return 1;
        }
        if (intValue == 2) {
            return 2;
        }
        throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.k(intValue, "The given lens facing integer: ", " can not be recognized."));
    }

    @Override // androidx.camera.core.impl.u
    public final String c() {
        return this.f16278a;
    }

    @Override // androidx.camera.core.impl.u
    public final String d() {
        Integer num = (Integer) this.f16279b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        num.getClass();
        return num.intValue() == 2 ? "androidx.camera.camera2.legacy" : "androidx.camera.camera2";
    }

    @Override // androidx.camera.core.impl.u
    public final androidx.lifecycle.y e() {
        synchronized (this.f16281d) {
            try {
                h hVar = this.e;
                if (hVar == null) {
                    if (this.f16282f == null) {
                        this.f16282f = new n(0);
                    }
                    return this.f16282f;
                }
                n nVar = this.f16282f;
                if (nVar != null) {
                    return nVar;
                }
                return hVar.f16186j.f16298b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.u
    public final int f(int i3) {
        Integer num = (Integer) this.f16279b.a(CameraCharacteristics.SENSOR_ORIENTATION);
        num.getClass();
        return com.google.android.gms.internal.mlkit_vision_common.j0.a(com.google.android.gms.internal.mlkit_vision_common.j0.b(i3), num.intValue(), 1 == b());
    }

    @Override // androidx.camera.core.impl.u
    public final boolean g() {
        androidx.camera.camera2.internal.compat.n nVar = this.f16279b;
        Objects.requireNonNull(nVar);
        return com.google.android.gms.internal.mlkit_vision_common.o.a(new af.a(nVar, 19));
    }

    @Override // androidx.camera.core.impl.u
    public final i1 i() {
        return this.f16286j;
    }

    @Override // androidx.camera.core.impl.u
    public final List j(int i3) {
        Size[] B = this.f16279b.b().B(i3);
        return B != null ? Arrays.asList(B) : Collections.EMPTY_LIST;
    }

    @Override // androidx.camera.core.impl.u
    public final androidx.lifecycle.y k() {
        synchronized (this.f16281d) {
            try {
                h hVar = this.e;
                if (hVar != null) {
                    n nVar = this.f16283g;
                    if (nVar != null) {
                        return nVar;
                    }
                    return (androidx.lifecycle.b0) hVar.f16185i.e;
                }
                if (this.f16283g == null) {
                    u0 c9 = v0.c(this.f16279b);
                    w0 w0Var = new w0(c9.d(), c9.f());
                    w0Var.e(1.0f);
                    this.f16283g = new n(y.b.e(w0Var));
                }
                return this.f16283g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.u
    public final void l(w.a aVar, h0.c cVar) {
        synchronized (this.f16281d) {
            try {
                h hVar = this.e;
                if (hVar != null) {
                    hVar.f16180c.execute(new androidx.camera.camera2.internal.compat.h(hVar, 11, aVar, cVar));
                } else {
                    if (this.f16285i == null) {
                        this.f16285i = new ArrayList();
                    }
                    this.f16285i.add(new Pair(cVar, aVar));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.u
    public final boolean m(t.v vVar) {
        synchronized (this.f16281d) {
            try {
                h hVar = this.e;
                if (hVar == null) {
                    return false;
                }
                return hVar.f16184h.c(vVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.u
    public final void n(androidx.camera.core.impl.k kVar) {
        synchronized (this.f16281d) {
            try {
                h hVar = this.e;
                if (hVar != null) {
                    hVar.f16180c.execute(new androidx.appcompat.app.i0(22, hVar, kVar));
                    return;
                }
                ArrayList arrayList = this.f16285i;
                if (arrayList == null) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((Pair) it.next()).first == kVar) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void o(h hVar) {
        synchronized (this.f16281d) {
            try {
                this.e = hVar;
                n nVar = this.f16283g;
                if (nVar != null) {
                    nVar.m((androidx.lifecycle.b0) hVar.f16185i.e);
                }
                n nVar2 = this.f16282f;
                if (nVar2 != null) {
                    nVar2.m(this.e.f16186j.f16298b);
                }
                ArrayList arrayList = this.f16285i;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        Pair pair = (Pair) obj;
                        h hVar2 = this.e;
                        Executor executor = (Executor) pair.second;
                        androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) pair.first;
                        hVar2.getClass();
                        hVar2.f16180c.execute(new androidx.camera.camera2.internal.compat.h(hVar2, 11, executor, kVar));
                    }
                    this.f16285i = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Integer num = (Integer) this.f16279b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        num.getClass();
        int intValue = num.intValue();
        String n4 = com.google.android.gms.internal.mlkit_vision_barcode.l0.n("Device Level: ", intValue != 0 ? intValue != 1 ? intValue != 2 ? intValue != 3 ? intValue != 4 ? com.google.android.gms.internal.mlkit_vision_barcode.l0.j(intValue, "Unknown value: ") : "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL" : "INFO_SUPPORTED_HARDWARE_LEVEL_3" : "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY" : "INFO_SUPPORTED_HARDWARE_LEVEL_FULL" : "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED");
        if (com.google.android.gms.internal.mlkit_vision_common.a0.d(4, "Camera2CameraInfo")) {
            Log.i("Camera2CameraInfo", n4);
        }
    }
}
