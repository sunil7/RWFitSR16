package c0;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.camera.core.impl.s0;
import androidx.camera.core.impl.v;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import t.b1;
import t.e1;
import t.f1;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final int f3329a;

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f3330b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3331c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f3332d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3333f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.camera.core.impl.h f3334g;

    /* renamed from: h, reason: collision with root package name */
    public int f3335h;

    /* renamed from: i, reason: collision with root package name */
    public int f3336i;

    /* renamed from: k, reason: collision with root package name */
    public f1 f3338k;

    /* renamed from: l, reason: collision with root package name */
    public m f3339l;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3337j = false;

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f3340m = new HashSet();

    /* renamed from: n, reason: collision with root package name */
    public boolean f3341n = false;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f3342o = new ArrayList();

    public n(int i3, int i10, androidx.camera.core.impl.h hVar, Matrix matrix, boolean z5, Rect rect, int i11, int i12, boolean z6) {
        this.f3333f = i3;
        this.f3329a = i10;
        this.f3334g = hVar;
        this.f3330b = matrix;
        this.f3331c = z5;
        this.f3332d = rect;
        this.f3336i = i11;
        this.f3335h = i12;
        this.e = z6;
        this.f3339l = new m(hVar.f1405a, i10);
    }

    public final void a() {
        pd.f("Edge is already closed.", !this.f3341n);
    }

    public final void b() {
        y5.a();
        this.f3339l.a();
        this.f3341n = true;
    }

    public final f1 c(v vVar, boolean z5) {
        y5.a();
        a();
        androidx.camera.core.impl.h hVar = this.f3334g;
        f1 f1Var = new f1(hVar.f1405a, vVar, z5, hVar.f1406b, new i(this, 0));
        try {
            s0 s0Var = f1Var.f18328k;
            m mVar = this.f3339l;
            Objects.requireNonNull(mVar);
            if (mVar.g(s0Var, new j(mVar, 0))) {
                x.i.d(mVar.e).a(new androidx.activity.b(s0Var, 11), a6.a());
            }
            this.f3338k = f1Var;
            e();
            return f1Var;
        } catch (DeferrableSurface$SurfaceClosedException e) {
            throw new AssertionError("Surface is somehow already closed", e);
        } catch (RuntimeException e10) {
            f1Var.c();
            throw e10;
        }
    }

    public final void d() {
        boolean z5;
        y5.a();
        a();
        m mVar = this.f3339l;
        mVar.getClass();
        y5.a();
        if (mVar.f3328q == null) {
            synchronized (mVar.f1392a) {
                z5 = mVar.f1394c;
            }
            if (!z5) {
                return;
            }
        }
        this.f3337j = false;
        this.f3339l.a();
        this.f3339l = new m(this.f3334g.f1405a, this.f3329a);
        Iterator it = this.f3340m.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final void e() {
        e1 e1Var;
        Executor executor;
        y5.a();
        t.l lVar = new t.l(this.f3332d, this.f3336i, this.f3335h, this.f3331c, this.f3330b, this.e);
        f1 f1Var = this.f3338k;
        if (f1Var != null) {
            synchronized (f1Var.f18319a) {
                f1Var.f18329l = lVar;
                e1Var = f1Var.f18330m;
                executor = f1Var.f18331n;
            }
            if (e1Var != null && executor != null) {
                executor.execute(new b1(e1Var, lVar, 0));
            }
        }
        ArrayList arrayList = this.f3342o;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((k1.a) obj).f(lVar);
        }
    }
}
