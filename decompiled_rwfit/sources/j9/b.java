package j9;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.gms.internal.mlkit_vision_barcode.sc;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public final class b implements GLSurfaceView.Renderer {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f15371h = {"y_tex", "u_tex", "v_tex"};

    /* renamed from: i, reason: collision with root package name */
    public static final FloatBuffer f15372i;

    /* renamed from: a, reason: collision with root package name */
    public final VideoDecoderGLSurfaceView f15373a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f15374b = new int[3];

    /* renamed from: c, reason: collision with root package name */
    public final int[] f15375c = new int[3];

    /* renamed from: d, reason: collision with root package name */
    public final int[] f15376d = new int[3];
    public final int[] e = new int[3];

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f15377f = new AtomicReference();

    /* renamed from: g, reason: collision with root package name */
    public int f15378g;

    static {
        float[] fArr = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
        f15372i = (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).flip();
    }

    public b(VideoDecoderGLSurfaceView videoDecoderGLSurfaceView) {
        this.f15373a = videoDecoderGLSurfaceView;
        for (int i3 = 0; i3 < 3; i3++) {
            int[] iArr = this.f15376d;
            this.e[i3] = -1;
            iArr[i3] = -1;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        if (this.f15377f.getAndSet(null) != null) {
            throw new ClassCastException();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i3, int i10) {
        GLES20.glViewport(0, 0, i3, i10);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int c9 = sc.c("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
        this.f15378g = c9;
        GLES20.glUseProgram(c9);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f15378g, "in_pos");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, (Buffer) f15372i);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f15378g, "in_tc_y");
        int[] iArr = this.f15375c;
        iArr[0] = glGetAttribLocation2;
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        int glGetAttribLocation3 = GLES20.glGetAttribLocation(this.f15378g, "in_tc_u");
        iArr[1] = glGetAttribLocation3;
        GLES20.glEnableVertexAttribArray(glGetAttribLocation3);
        int glGetAttribLocation4 = GLES20.glGetAttribLocation(this.f15378g, "in_tc_v");
        iArr[2] = glGetAttribLocation4;
        GLES20.glEnableVertexAttribArray(glGetAttribLocation4);
        sc.b();
        GLES20.glGetUniformLocation(this.f15378g, "mColorConversion");
        sc.b();
        int[] iArr2 = this.f15374b;
        GLES20.glGenTextures(3, iArr2, 0);
        for (int i3 = 0; i3 < 3; i3++) {
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f15378g, f15371h[i3]), i3);
            GLES20.glActiveTexture(33984 + i3);
            GLES20.glBindTexture(3553, iArr2[i3]);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        sc.b();
        sc.b();
    }
}
