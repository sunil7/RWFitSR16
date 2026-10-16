package c0;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import com.example.blesdk.service.z;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.l0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;
import t.t;

/* loaded from: classes.dex */
public final class f implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public final h f3291a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f3292b;

    /* renamed from: c, reason: collision with root package name */
    public final w.c f3293c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f3294d;
    public final AtomicBoolean e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f3295f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f3296g;

    /* renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f3297h;

    /* renamed from: i, reason: collision with root package name */
    public int f3298i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3299j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f3300k;

    public f(t tVar) {
        Map map = Collections.EMPTY_MAP;
        this.e = new AtomicBoolean(false);
        this.f3295f = new float[16];
        this.f3296g = new float[16];
        this.f3297h = new LinkedHashMap();
        this.f3298i = 0;
        this.f3299j = false;
        this.f3300k = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.f3292b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f3294d = handler;
        this.f3293c = new w.c(handler);
        this.f3291a = new h();
        try {
            try {
                ve.a(new b(this, tVar)).get();
            } catch (InterruptedException | ExecutionException e) {
                e = e;
                e = e instanceof ExecutionException ? e.getCause() : e;
                if (!(e instanceof RuntimeException)) {
                    throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
                }
                throw ((RuntimeException) e);
            }
        } catch (RuntimeException e10) {
            e();
            throw e10;
        }
    }

    public final void a() {
        if (this.f3299j && this.f3298i == 0) {
            LinkedHashMap linkedHashMap = this.f3297h;
            Iterator it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((o) it.next()).close();
            }
            ArrayList arrayList = this.f3300k;
            if (arrayList.size() > 0) {
                ((a) arrayList.get(0)).getClass();
                new Exception("Failed to snapshot: DefaultSurfaceProcessor is released.");
                throw null;
            }
            linkedHashMap.clear();
            h hVar = this.f3291a;
            if (hVar.f3303a.getAndSet(false)) {
                e0.h.c(hVar.f3305c);
                hVar.h();
            }
            this.f3292b.quit();
        }
    }

    public final void b(Runnable runnable, Runnable runnable2) {
        try {
            this.f3293c.execute(new androidx.camera.camera2.internal.compat.h(this, 3, runnable2, runnable));
        } catch (RejectedExecutionException e) {
            a0.f("DefaultSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    public final void c(Exception exc) {
        ArrayList arrayList = this.f3300k;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            ((a) arrayList.get(0)).getClass();
            throw null;
        }
    }

    public final Bitmap d(Size size, float[] fArr, int i3) {
        float[] fArr2 = (float[]) fArr.clone();
        l0.a(i3, fArr2);
        l0.b(fArr2);
        Size e = v.d.e(size, i3);
        h hVar = this.f3291a;
        hVar.getClass();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(e.getHeight() * e.getWidth() * 4);
        pd.a("ByteBuffer capacity is not equal to width * height * 4.", allocateDirect.capacity() == (e.getHeight() * e.getWidth()) * 4);
        pd.a("ByteBuffer is not direct.", allocateDirect.isDirect());
        int[] iArr = e0.h.f12427a;
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        e0.h.b("glGenTextures");
        int i10 = iArr2[0];
        GLES20.glActiveTexture(33985);
        e0.h.b("glActiveTexture");
        GLES20.glBindTexture(3553, i10);
        e0.h.b("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, e.getWidth(), e.getHeight(), 0, 6407, 5121, null);
        e0.h.b("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int[] iArr3 = new int[1];
        GLES20.glGenFramebuffers(1, iArr3, 0);
        e0.h.b("glGenFramebuffers");
        int i11 = iArr3[0];
        GLES20.glBindFramebuffer(36160, i11);
        e0.h.b("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i10, 0);
        e0.h.b("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        e0.h.b("glActiveTexture");
        GLES20.glBindTexture(36197, hVar.f3314m);
        e0.h.b("glBindTexture");
        hVar.f3310i = null;
        GLES20.glViewport(0, 0, e.getWidth(), e.getHeight());
        GLES20.glScissor(0, 0, e.getWidth(), e.getHeight());
        e0.f fVar = hVar.f3312k;
        fVar.getClass();
        if (fVar instanceof e0.g) {
            GLES20.glUniformMatrix4fv(((e0.g) fVar).f12425f, 1, false, fArr2, 0);
            e0.h.b("glUniformMatrix4fv");
        }
        GLES20.glDrawArrays(5, 0, 4);
        e0.h.b("glDrawArrays");
        GLES20.glReadPixels(0, 0, e.getWidth(), e.getHeight(), 6408, 5121, allocateDirect);
        e0.h.b("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteTextures(1, new int[]{i10}, 0);
        e0.h.b("glDeleteTextures");
        GLES20.glDeleteFramebuffers(1, new int[]{i11}, 0);
        e0.h.b("glDeleteFramebuffers");
        int i12 = hVar.f3314m;
        GLES20.glActiveTexture(33984);
        e0.h.b("glActiveTexture");
        GLES20.glBindTexture(36197, i12);
        e0.h.b("glBindTexture");
        Bitmap createBitmap = Bitmap.createBitmap(e.getWidth(), e.getHeight(), Bitmap.Config.ARGB_8888);
        allocateDirect.rewind();
        ImageProcessingUtil.c(createBitmap, allocateDirect, e.getWidth() * 4);
        return createBitmap;
    }

    public final void e() {
        if (this.e.getAndSet(true)) {
            return;
        }
        b(new androidx.activity.b(this, 10), new z(6));
    }

    public final void f(Triple triple) {
        ArrayList arrayList = this.f3300k;
        if (arrayList.isEmpty()) {
            return;
        }
        if (triple == null) {
            c(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator it = arrayList.iterator();
                if (!it.hasNext()) {
                    byteArrayOutputStream.close();
                    return;
                }
                ((a) it.next()).getClass();
                Bitmap d5 = d((Size) triple.getSecond(), (float[]) triple.getThird(), 0);
                byteArrayOutputStream.reset();
                d5.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Surface surface = (Surface) triple.getFirst();
                Objects.requireNonNull(byteArray);
                ImageProcessingUtil.f(byteArray, surface);
                throw null;
            } finally {
            }
        } catch (IOException e) {
            c(e);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.e.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        float[] fArr = this.f3295f;
        surfaceTexture.getTransformMatrix(fArr);
        Triple triple = null;
        for (Map.Entry entry : this.f3297h.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            o oVar = (o) entry.getKey();
            float[] fArr2 = oVar.e;
            float[] fArr3 = this.f3296g;
            Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
            int i3 = oVar.f3345c;
            if (i3 == 34) {
                try {
                    this.f3291a.j(surfaceTexture.getTimestamp(), fArr3, surface);
                } catch (RuntimeException e) {
                    a0.c("DefaultSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            } else {
                pd.f("Unsupported format: " + i3, i3 == 256);
                pd.f("Only one JPEG output is supported.", triple == null);
                triple = new Triple(surface, oVar.f3346d, (float[]) fArr3.clone());
            }
        }
        try {
            f(triple);
        } catch (RuntimeException e10) {
            c(e10);
        }
    }
}
