package n;

import android.app.Notification;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import android.os.Looper;
import android.util.Size;
import android.util.SparseArray;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.w1;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.test.ui.mine.activity.SelectActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.jc;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import t.a1;

/* loaded from: classes.dex */
public final class m0 implements x.c, nd.b, pe.r, m1.o, w4.a, androidx.camera.core.impl.r0, androidx.lifecycle.p0, wa.f, vg.g, vg.p, vg.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16253a;

    /* renamed from: b, reason: collision with root package name */
    public Object f16254b;

    public /* synthetic */ m0(int i3, boolean z5) {
        this.f16253a = i3;
    }

    public static m0 A(androidx.camera.camera2.internal.compat.n nVar) {
        CameraCharacteristics.Key key;
        int i3 = Build.VERSION.SDK_INT;
        m0 m0Var = null;
        if (i3 >= 33) {
            key = CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES;
            DynamicRangeProfiles b3 = androidx.activity.j.b(nVar.a(key));
            if (b3 != null) {
                pd.f("DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.", i3 >= 33);
                m0Var = new m0(new o.c(b3), 3);
            }
        }
        return m0Var == null ? o.d.f16619a : m0Var;
    }

    public static a1 w(t.p0 p0Var) {
        if (p0Var == null) {
            return null;
        }
        return new a1(p0Var, new Size(p0Var.getWidth(), p0Var.getHeight()), new y.c(new g0.i(null, w1.f1513b, p0Var.u().d())));
    }

    public int B() {
        URLConnection uRLConnection = (URLConnection) this.f16254b;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // x.c
    public void C(Throwable th2) {
        switch (this.f16253a) {
            case 0:
                n0 n0Var = (n0) this.f16254b;
                synchronized (n0Var.f16257a) {
                    try {
                        List list = n0Var.f16266k;
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((androidx.camera.core.impl.g0) it.next()).b();
                            }
                            n0Var.f16266k = null;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                n0Var.f16275u.h();
                g0 g0Var = n0Var.f16258b;
                g0Var.i(n0Var);
                synchronized (g0Var.f16175b) {
                    ((LinkedHashSet) g0Var.e).remove(n0Var);
                }
                return;
            default:
                ((t.h0) this.f16254b).close();
                return;
        }
    }

    public void D() {
        s3.e eVar = (s3.e) this.f16254b;
        try {
            Date parse = s3.h.f18189q.parse(eVar.f18177m.b());
            SelectActivity this$0 = eVar.e.f17749a.f8151a;
            kotlin.jvm.internal.e.f(this$0, "this$0");
            kotlin.jvm.internal.e.c(parse);
            this$0.H = parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override // w4.a
    public void E(int i3) {
        s3.f fVar = (s3.f) this.f16254b;
        fVar.f18184h.e(fVar.f18178a.getCurrentItem(), fVar.f18179b.getCurrentItem(), i3);
    }

    @Override // wa.f
    public ViewGroup.LayoutParams K() {
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.f16254b;
        return new ViewGroup.LayoutParams(extendedFloatingActionButton.getCollapsedSize(), extendedFloatingActionButton.getCollapsedSize());
    }

    @Override // pe.r
    public byte a(int i3) {
        return ((pe.r) this.f16254b).a(i3);
    }

    @Override // pe.r
    public boolean b() {
        return ((pe.r) this.f16254b).b();
    }

    @Override // pe.r
    public boolean c(int i3) {
        return ((pe.r) this.f16254b).c(i3);
    }

    @Override // androidx.camera.core.impl.r0
    public void close() {
        ((t.c) this.f16254b).close();
    }

    @Override // androidx.camera.core.impl.r0
    public Surface e() {
        return ((t.c) this.f16254b).e();
    }

    public boolean equals(Object obj) {
        switch (this.f16253a) {
            case 20:
                return ((t.h) this.f16254b).equals(obj);
            default:
                return super.equals(obj);
        }
    }

    @Override // vg.g
    public void f(Object obj) {
        ((vg.a) this.f16254b).run();
    }

    @Override // m1.o
    public boolean g(View view) {
        DrawerLayout drawerLayout = (DrawerLayout) this.f16254b;
        if (!DrawerLayout.m(view) || drawerLayout.h(view) == 2) {
            return false;
        }
        drawerLayout.b(view);
        return true;
    }

    @Override // androidx.camera.core.impl.r0, wa.f
    public int getHeight() {
        switch (this.f16253a) {
            case 22:
                return ((t.c) this.f16254b).getHeight();
            default:
                return ((ExtendedFloatingActionButton) this.f16254b).getCollapsedSize();
        }
    }

    @Override // androidx.camera.core.impl.r0, wa.f
    public int getWidth() {
        switch (this.f16253a) {
            case 22:
                return ((t.c) this.f16254b).getWidth();
            default:
                return ((ExtendedFloatingActionButton) this.f16254b).getCollapsedSize();
        }
    }

    @Override // nd.b
    public void h(boolean z5) {
        if (z5) {
            fd.c cVar = (fd.c) this.f16254b;
            nd.d dVar = (nd.d) cVar.e;
            if (dVar.isAdded()) {
                ArrayList arrayList = (ArrayList) cVar.f13571d;
                int[] iArr = new int[arrayList.size()];
                Arrays.fill(iArr, 0);
                dVar.onRequestPermissionsResult(cVar.f13569b, (String[]) arrayList.toArray(new String[0]), iArr);
            }
        }
    }

    public int hashCode() {
        switch (this.f16253a) {
            case 20:
                return ((t.h) this.f16254b).hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override // nd.b
    public void i() {
        fd.c cVar = (fd.c) this.f16254b;
        nd.d dVar = (nd.d) cVar.e;
        if (dVar.isAdded()) {
            ArrayList arrayList = (ArrayList) cVar.f13571d;
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = "android.permission.ACCESS_BACKGROUND_LOCATION".equals(arrayList.get(i3)) ? -1 : 0;
            }
            dVar.onRequestPermissionsResult(cVar.f13569b, (String[]) arrayList.toArray(new String[0]), iArr);
        }
    }

    @Override // pe.r
    public void j() {
        ((pe.r) this.f16254b).j();
    }

    @Override // androidx.camera.core.impl.r0
    public t.p0 k() {
        return w(((t.c) this.f16254b).k());
    }

    @Override // vg.p
    public boolean l(Object obj) {
        return ((Class) this.f16254b).isInstance(obj);
    }

    @Override // androidx.camera.core.impl.r0
    public int m() {
        return ((t.c) this.f16254b).m();
    }

    @Override // pe.r
    public boolean n(String str, String str2, boolean z5) {
        return ((pe.r) this.f16254b).n(str, str2, z5);
    }

    @Override // androidx.camera.core.impl.r0
    public void o() {
        ((t.c) this.f16254b).o();
    }

    @Override // x.c
    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        switch (this.f16253a) {
            case 0:
                break;
            default:
                break;
        }
    }

    @Override // pe.r
    public boolean p() {
        return ((pe.r) this.f16254b).p();
    }

    @Override // androidx.camera.core.impl.r0
    public int q() {
        return ((t.c) this.f16254b).q();
    }

    @Override // androidx.camera.core.impl.r0
    public t.p0 r() {
        return w(((t.c) this.f16254b).r());
    }

    @Override // vg.a
    public void run() {
        ((vg.g) this.f16254b).f(rg.j.f18126b);
    }

    @Override // pe.r
    public void s(Context context) {
        ((pe.r) this.f16254b).s(context);
    }

    @Override // androidx.camera.core.impl.r0
    public void t(androidx.camera.core.impl.q0 q0Var, Executor executor) {
        ((t.c) this.f16254b).t(new c0.b(22, this, q0Var), executor);
    }

    public String toString() {
        switch (this.f16253a) {
            case 20:
                return ((t.h) this.f16254b).toString();
            case 26:
                return "ForegroundServiceConfig{notificationId=17301506, notificationChannelId='filedownloader_channel', notificationChannelName='Filedownloader', notification=" + ((Notification) this.f16254b) + ", needRecreateChannelId=true}";
            default:
                return super.toString();
        }
    }

    @Override // wa.f
    public int u() {
        return ((ExtendedFloatingActionButton) this.f16254b).getCollapsedPadding();
    }

    @Override // androidx.lifecycle.p0
    public androidx.lifecycle.m0 v(Class cls, w1.c cVar) {
        androidx.lifecycle.m0 m0Var = null;
        for (w1.d dVar : (w1.d[]) this.f16254b) {
            if (dVar.f19465a.equals(cls)) {
                Object invoke = dVar.f19466b.invoke(cVar);
                m0Var = invoke instanceof androidx.lifecycle.m0 ? (androidx.lifecycle.m0) invoke : null;
            }
        }
        if (m0Var != null) {
            return m0Var;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }

    @Override // wa.f
    public int x() {
        return ((ExtendedFloatingActionButton) this.f16254b).getCollapsedPadding();
    }

    public int y(int i3, int[] iArr) {
        int[] iArr2;
        uc.a aVar;
        int[] iArr3;
        int i10;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            iArr2 = iArr;
        } else {
            int i11 = 1;
            while (i11 < length && iArr[i11] == 0) {
                i11++;
            }
            if (i11 == length) {
                iArr2 = new int[]{0};
            } else {
                int i12 = length - i11;
                int[] iArr4 = new int[i12];
                System.arraycopy(iArr, i11, iArr4, 0, i12);
                iArr2 = iArr4;
            }
        }
        int[] iArr5 = new int[i3];
        boolean z5 = true;
        int i13 = 0;
        while (true) {
            aVar = (uc.a) this.f16254b;
            if (i13 >= i3) {
                break;
            }
            int i14 = aVar.f19040a[aVar.f19045g + i13];
            if (i14 == 0) {
                i10 = iArr2[iArr2.length - 1];
            } else if (i14 == 1) {
                int i15 = 0;
                for (int i16 : iArr2) {
                    uc.a aVar2 = uc.a.f19032h;
                    i15 ^= i16;
                }
                i10 = i15;
            } else {
                int i17 = iArr2[0];
                int length2 = iArr2.length;
                for (int i18 = 1; i18 < length2; i18++) {
                    i17 = aVar.c(i14, i17) ^ iArr2[i18];
                }
                i10 = i17;
            }
            iArr5[(i3 - 1) - i13] = i10;
            if (i10 != 0) {
                z5 = false;
            }
            i13++;
        }
        if (z5) {
            return 0;
        }
        uc.b bVar = new uc.b(aVar, iArr5);
        uc.b a3 = aVar.a(i3, 1);
        if (a3.d() >= bVar.d()) {
            a3 = bVar;
            bVar = a3;
        }
        uc.b bVar2 = aVar.f19042c;
        uc.b bVar3 = aVar.f19043d;
        uc.b bVar4 = a3;
        uc.b bVar5 = bVar;
        uc.b bVar6 = bVar4;
        uc.b bVar7 = bVar2;
        while (bVar6.d() * 2 >= i3) {
            if (bVar6.e()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            int b3 = aVar.b(bVar6.c(bVar6.d()));
            uc.b bVar8 = bVar2;
            while (bVar5.d() >= bVar6.d() && !bVar5.e()) {
                int d5 = bVar5.d() - bVar6.d();
                int c9 = aVar.c(bVar5.c(bVar5.d()), b3);
                bVar8 = bVar8.a(aVar.a(d5, c9));
                bVar5 = bVar5.a(bVar6.h(d5, c9));
            }
            uc.b a10 = bVar8.g(bVar3).a(bVar7);
            if (bVar5.d() >= bVar6.d()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial? r: " + bVar5 + ", rLast: " + bVar6);
            }
            uc.b bVar9 = bVar5;
            bVar5 = bVar6;
            bVar6 = bVar9;
            bVar7 = bVar3;
            bVar3 = a10;
        }
        int c10 = bVar3.c(0);
        if (c10 == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        int b10 = aVar.b(c10);
        uc.b[] bVarArr = {bVar3.f(b10), bVar6.f(b10)};
        uc.b bVar10 = bVarArr[0];
        uc.b bVar11 = bVarArr[1];
        int d8 = bVar10.d();
        if (d8 == 1) {
            iArr3 = new int[]{bVar10.c(1)};
        } else {
            int[] iArr6 = new int[d8];
            int i19 = 0;
            for (int i20 = 1; i20 < aVar.e && i19 < d8; i20++) {
                if (bVar10.b(i20) == 0) {
                    iArr6[i19] = aVar.b(i20);
                    i19++;
                }
            }
            if (i19 != d8) {
                throw new ReedSolomonException("Error locator degree does not match number of roots");
            }
            iArr3 = iArr6;
        }
        int length3 = iArr3.length;
        int[] iArr7 = new int[length3];
        for (int i21 = 0; i21 < length3; i21++) {
            int b11 = aVar.b(iArr3[i21]);
            int i22 = 1;
            for (int i23 = 0; i23 < length3; i23++) {
                if (i21 != i23) {
                    int c11 = aVar.c(iArr3[i23], b11);
                    i22 = aVar.c(i22, (c11 & 1) == 0 ? c11 | 1 : c11 & (-2));
                }
            }
            int c12 = aVar.c(bVar11.b(b11), aVar.b(i22));
            iArr7[i21] = c12;
            if (aVar.f19045g != 0) {
                iArr7[i21] = aVar.c(c12, b11);
            }
        }
        for (int i24 = 0; i24 < iArr3.length; i24++) {
            int length4 = iArr.length - 1;
            int i25 = iArr3[i24];
            if (i25 == 0) {
                throw new IllegalArgumentException();
            }
            int i26 = length4 - aVar.f19041b[i25];
            if (i26 < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[i26] = iArr[i26] ^ iArr7[i24];
        }
        return iArr3.length;
    }

    public void z() {
        try {
            ((URLConnection) this.f16254b).getInputStream().close();
        } catch (IOException unused) {
        }
    }

    public /* synthetic */ m0(Object obj, int i3) {
        this.f16253a = i3;
        this.f16254b = obj;
    }

    public m0(int i3) {
        Object obj;
        this.f16253a = i3;
        switch (i3) {
            case 7:
                this.f16254b = jc.a(Looper.getMainLooper());
                return;
            case 8:
                this.f16254b = ye.c.f20115a.f20119d ? new pe.k() : new pe.m();
                return;
            case 9:
                this.f16254b = new SparseArray();
                return;
            case 11:
                this.f16254b = (ExtraCroppingQuirk) p.a.f17285a.f(ExtraCroppingQuirk.class);
                return;
            case 18:
                androidx.camera.core.impl.x0 f2 = androidx.camera.core.impl.x0.f();
                this.f16254b = f2;
                Object obj2 = null;
                try {
                    obj = f2.e(y.i.S0);
                } catch (IllegalArgumentException unused) {
                    obj = null;
                }
                Class cls = (Class) obj;
                if (cls != null && !cls.equals(androidx.camera.core.b.class)) {
                    throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
                }
                androidx.camera.core.impl.c cVar = y.i.S0;
                androidx.camera.core.impl.x0 x0Var = (androidx.camera.core.impl.x0) this.f16254b;
                x0Var.m(cVar, androidx.camera.core.b.class);
                try {
                    obj2 = x0Var.e(y.i.R0);
                } catch (IllegalArgumentException unused2) {
                }
                if (obj2 == null) {
                    x0Var.m(y.i.R0, androidx.camera.core.b.class.getCanonicalName() + "-" + UUID.randomUUID());
                    return;
                }
                return;
            default:
                this.f16254b = new ArrayList();
                return;
        }
    }

    public m0(int i3, Rect rect, Size size) {
        this.f16253a = 20;
        this.f16254b = new t.h(i3, rect, size);
    }

    public m0(w1.d[] initializers) {
        this.f16253a = 24;
        kotlin.jvm.internal.e.f(initializers, "initializers");
        this.f16254b = initializers;
    }

    public m0(TextView textView) {
        this.f16253a = 21;
        this.f16254b = new t1.g(textView);
    }
}
