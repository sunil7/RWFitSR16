package n;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import com.google.android.gms.common.ConnectionResult;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class v0 implements q9.b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16306a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f16307b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f16308c;

    /* renamed from: d, reason: collision with root package name */
    public Object f16309d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Object f16310f;

    public v0(o9.c cVar, com.google.android.gms.common.api.c cVar2, o9.a aVar) {
        this.f16310f = cVar;
        this.f16309d = null;
        this.e = null;
        this.f16306a = false;
        this.f16307b = cVar2;
        this.f16308c = aVar;
    }

    public static u0 c(androidx.camera.camera2.internal.compat.n nVar) {
        Range range;
        CameraCharacteristics.Key key;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                key = CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE;
                range = (Range) nVar.a(key);
            } catch (AssertionError e) {
                com.google.android.gms.internal.mlkit_vision_common.a0.f("ZoomControl", "AssertionError, fail to get camera characteristic.", e);
                range = null;
            }
            if (range != null) {
                return new a(nVar);
            }
        }
        v2.h hVar = new v2.h();
        hVar.f19147b = null;
        hVar.f19149d = null;
        hVar.f19146a = nVar;
        return hVar;
    }

    @Override // q9.b
    public void a(ConnectionResult connectionResult) {
        ((o9.c) this.f16310f).f16862m.post(new ia.j(10, this, connectionResult));
    }

    public boolean b(Method method, Class cls) {
        StringBuilder sb2 = (StringBuilder) this.e;
        sb2.setLength(0);
        sb2.append(method.getName());
        sb2.append('>');
        sb2.append(cls.getName());
        String sb3 = sb2.toString();
        Class<?> declaringClass = method.getDeclaringClass();
        HashMap hashMap = (HashMap) this.f16309d;
        Class cls2 = (Class) hashMap.put(sb3, declaringClass);
        if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
            return true;
        }
        hashMap.put(sb3, cls2);
        return false;
    }

    public void d(y.b bVar) {
        Looper myLooper = Looper.myLooper();
        Looper mainLooper = Looper.getMainLooper();
        androidx.lifecycle.b0 b0Var = (androidx.lifecycle.b0) this.e;
        if (myLooper == mainLooper) {
            b0Var.k(bVar);
        } else {
            b0Var.i(bVar);
        }
    }

    public void e(ConnectionResult connectionResult) {
        o9.n nVar = (o9.n) ((o9.c) this.f16310f).f16859j.get((o9.a) this.f16308c);
        if (nVar != null) {
            nVar.p(connectionResult);
        }
    }

    public v0(h hVar, androidx.camera.camera2.internal.compat.n nVar, androidx.camera.core.impl.utils.executor.b bVar) {
        this.f16306a = false;
        t0 t0Var = new t0(this);
        this.f16307b = hVar;
        this.f16308c = bVar;
        u0 c9 = c(nVar);
        this.f16310f = c9;
        w0 w0Var = new w0(c9.d(), c9.f());
        this.f16309d = w0Var;
        w0Var.e(1.0f);
        this.e = new androidx.lifecycle.b0(y.b.e(w0Var));
        hVar.k(t0Var);
    }

    public v0() {
        this.f16307b = new ArrayList();
        this.f16308c = new HashMap();
        this.f16309d = new HashMap();
        this.e = new StringBuilder(128);
    }
}
