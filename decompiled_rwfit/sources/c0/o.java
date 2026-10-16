package c0;

import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.appcompat.app.i0;
import androidx.camera.core.impl.v;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.l0;
import java.io.Closeable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class o implements Closeable, AutoCloseable {

    /* renamed from: b, reason: collision with root package name */
    public final Surface f3344b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3345c;

    /* renamed from: d, reason: collision with root package name */
    public final Size f3346d;
    public final float[] e;

    /* renamed from: f, reason: collision with root package name */
    public k1.a f3347f;

    /* renamed from: g, reason: collision with root package name */
    public w.c f3348g;

    /* renamed from: j, reason: collision with root package name */
    public final n0.i f3351j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.concurrent.futures.b f3352k;

    /* renamed from: a, reason: collision with root package name */
    public final Object f3343a = new Object();

    /* renamed from: h, reason: collision with root package name */
    public boolean f3349h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3350i = false;

    public o(Surface surface, int i3, Size size, t.i iVar, t.i iVar2) {
        float[] fArr = new float[16];
        this.e = fArr;
        this.f3344b = surface;
        this.f3345c = i3;
        this.f3346d = size;
        b(fArr, new float[16], iVar);
        b(new float[16], new float[16], iVar2);
        this.f3351j = ve.a(new af.a(this, 2));
    }

    public static void b(float[] fArr, float[] fArr2, t.i iVar) {
        Matrix.setIdentityM(fArr, 0);
        if (iVar == null) {
            return;
        }
        l0.b(fArr);
        int i3 = iVar.f18345d;
        l0.a(i3, fArr);
        boolean z5 = iVar.e;
        if (z5) {
            Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
            Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
        }
        Size e = v.d.e(iVar.f18342a, i3);
        float f2 = 0;
        android.graphics.Matrix a3 = v.d.a(new RectF(f2, f2, r6.getWidth(), r6.getHeight()), new RectF(f2, f2, e.getWidth(), e.getHeight()), i3, z5);
        RectF rectF = new RectF(iVar.f18343b);
        a3.mapRect(rectF);
        float width = rectF.left / e.getWidth();
        float height = ((e.getHeight() - rectF.height()) - rectF.top) / e.getHeight();
        float width2 = rectF.width() / e.getWidth();
        float height2 = rectF.height() / e.getHeight();
        Matrix.translateM(fArr, 0, width, height, 0.0f);
        Matrix.scaleM(fArr, 0, width2, height2, 1.0f);
        Matrix.setIdentityM(fArr2, 0);
        l0.b(fArr2);
        v vVar = iVar.f18344c;
        if (vVar != null) {
            pd.f("Camera has no transform.", vVar.f());
            l0.a(vVar.h().a(), fArr2);
            if (vVar.h().b() == 0) {
                Matrix.translateM(fArr2, 0, 1.0f, 0.0f, 0.0f);
                Matrix.scaleM(fArr2, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        Matrix.invertM(fArr2, 0, fArr2, 0);
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
    }

    public final Surface c(w.c cVar, k1.a aVar) {
        boolean z5;
        synchronized (this.f3343a) {
            this.f3348g = cVar;
            this.f3347f = aVar;
            z5 = this.f3349h;
        }
        if (z5) {
            e();
        }
        return this.f3344b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f3343a) {
            try {
                if (!this.f3350i) {
                    this.f3350i = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f3352k.a(null);
    }

    public final void e() {
        w.c cVar;
        k1.a aVar;
        AtomicReference atomicReference = new AtomicReference();
        synchronized (this.f3343a) {
            try {
                if (this.f3348g != null && (aVar = this.f3347f) != null) {
                    if (!this.f3350i) {
                        atomicReference.set(aVar);
                        cVar = this.f3348g;
                        this.f3349h = false;
                    }
                    cVar = null;
                }
                this.f3349h = true;
                cVar = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (cVar != null) {
            try {
                cVar.execute(new i0(7, this, atomicReference));
            } catch (RejectedExecutionException e) {
                if (a0.d(3, "SurfaceOutputImpl")) {
                    Log.d("SurfaceOutputImpl", "Processor executor closed. Close request not posted.", e);
                }
            }
        }
    }
}
