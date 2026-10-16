package k9;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import androidx.appcompat.app.i0;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.gms.internal.mlkit_vision_barcode.sc;
import java.nio.Buffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import okhttp3.internal.http2.Http2;

/* loaded from: classes.dex */
public final class h implements GLSurfaceView.Renderer, b {

    /* renamed from: a, reason: collision with root package name */
    public final g f15557a;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f15560d;
    public final float[] e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f15561f;

    /* renamed from: g, reason: collision with root package name */
    public float f15562g;

    /* renamed from: h, reason: collision with root package name */
    public float f15563h;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SphericalGLSurfaceView f15566k;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f15558b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f15559c = new float[16];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f15564i = new float[16];

    /* renamed from: j, reason: collision with root package name */
    public final float[] f15565j = new float[16];

    public h(SphericalGLSurfaceView sphericalGLSurfaceView, g gVar) {
        this.f15566k = sphericalGLSurfaceView;
        float[] fArr = new float[16];
        this.f15560d = fArr;
        float[] fArr2 = new float[16];
        this.e = fArr2;
        float[] fArr3 = new float[16];
        this.f15561f = fArr3;
        this.f15557a = gVar;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.f15563h = 3.1415927f;
    }

    @Override // k9.b
    public final synchronized void a(float f2, float[] fArr) {
        float[] fArr2 = this.f15560d;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        float f10 = -f2;
        this.f15563h = f10;
        Matrix.setRotateM(this.e, 0, -this.f15562g, (float) Math.cos(f10), (float) Math.sin(this.f15563h), 0.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        Object b3;
        Object b10;
        Object b11;
        synchronized (this) {
            Matrix.multiplyMM(this.f15565j, 0, this.f15560d, 0, this.f15561f, 0);
            Matrix.multiplyMM(this.f15564i, 0, this.e, 0, this.f15565j, 0);
        }
        Matrix.multiplyMM(this.f15559c, 0, this.f15558b, 0, this.f15564i, 0);
        g gVar = this.f15557a;
        float[] fArr = this.f15559c;
        GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
        sc.b();
        if (((AtomicBoolean) gVar.f15549b).compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) gVar.f15556j;
            surfaceTexture.getClass();
            surfaceTexture.updateTexImage();
            sc.b();
            if (((AtomicBoolean) gVar.f15550c).compareAndSet(true, false)) {
                Matrix.setIdentityM((float[]) gVar.f15554h, 0);
            }
            long timestamp = ((SurfaceTexture) gVar.f15556j).getTimestamp();
            i9.f fVar = (i9.f) gVar.f15552f;
            synchronized (fVar) {
                b3 = fVar.b(timestamp, false);
            }
            Long l3 = (Long) b3;
            if (l3 != null) {
                a2.g gVar2 = (a2.g) gVar.e;
                float[] fArr2 = (float[]) gVar.f15554h;
                long longValue = l3.longValue();
                i9.f fVar2 = (i9.f) gVar2.f35d;
                synchronized (fVar2) {
                    b11 = fVar2.b(longValue, true);
                }
                float[] fArr3 = (float[]) b11;
                if (fArr3 != null) {
                    float f2 = fArr3[0];
                    float f10 = -fArr3[1];
                    float f11 = -fArr3[2];
                    float length = Matrix.length(f2, f10, f11);
                    float[] fArr4 = (float[]) gVar2.f34c;
                    if (length != 0.0f) {
                        Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f2 / length, f10 / length, f11 / length);
                    } else {
                        Matrix.setIdentityM(fArr4, 0);
                    }
                    if (!gVar2.f32a) {
                        a2.g.e((float[]) gVar2.f33b, (float[]) gVar2.f34c);
                        gVar2.f32a = true;
                    }
                    Matrix.multiplyMM(fArr2, 0, (float[]) gVar2.f33b, 0, (float[]) gVar2.f34c, 0);
                }
            }
            i9.f fVar3 = (i9.f) gVar.f15553g;
            synchronized (fVar3) {
                b10 = fVar3.b(timestamp, true);
            }
        }
        Matrix.multiplyMM((float[]) gVar.f15555i, 0, fArr, 0, (float[]) gVar.f15554h, 0);
        e eVar = (e) gVar.f15551d;
        int i3 = gVar.f15548a;
        float[] fArr5 = (float[]) gVar.f15555i;
        i9.f fVar4 = eVar.f15541b;
        if (fVar4 == null) {
            return;
        }
        GLES20.glUseProgram(eVar.f15542c);
        sc.b();
        GLES20.glEnableVertexAttribArray(eVar.f15544f);
        GLES20.glEnableVertexAttribArray(eVar.f15545g);
        sc.b();
        int i10 = eVar.f15540a;
        GLES20.glUniformMatrix3fv(eVar.e, 1, false, i10 == 1 ? e.f15538l : i10 == 2 ? e.f15539m : e.f15537k, 0);
        GLES20.glUniformMatrix4fv(eVar.f15543d, 1, false, fArr5, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i3);
        GLES20.glUniform1i(eVar.f15546h, 0);
        sc.b();
        GLES20.glVertexAttribPointer(eVar.f15544f, 3, 5126, false, 12, (Buffer) fVar4.f14377d);
        sc.b();
        GLES20.glVertexAttribPointer(eVar.f15545g, 2, 5126, false, 8, (Buffer) fVar4.e);
        sc.b();
        GLES20.glDrawArrays(fVar4.f14376c, 0, fVar4.f14375b);
        sc.b();
        GLES20.glDisableVertexAttribArray(eVar.f15544f);
        GLES20.glDisableVertexAttribArray(eVar.f15545g);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i3, int i10) {
        GLES20.glViewport(0, 0, i3, i10);
        float f2 = i3 / i10;
        Matrix.perspectiveM(this.f15558b, 0, f2 > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f2)) * 2.0d) : 90.0f, f2, 0.1f, 100.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.f15566k;
        sphericalGLSurfaceView.e.post(new i0(20, sphericalGLSurfaceView, this.f15557a.a()));
    }
}
