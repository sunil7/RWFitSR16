package bg;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import n.l;
import zf.b;
import zf.c;
import zf.d;
import zf.e;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public l f3258a;

    /* renamed from: b, reason: collision with root package name */
    public e f3259b;

    /* renamed from: c, reason: collision with root package name */
    public int f3260c;

    /* renamed from: d, reason: collision with root package name */
    public int f3261d;

    public final void a(ByteArrayOutputStream byteArrayOutputStream) {
        Bitmap.CompressFormat format = Bitmap.CompressFormat.JPEG;
        kotlin.jvm.internal.e.f(format, "format");
        e eglSurface = this.f3259b;
        l lVar = this.f3258a;
        lVar.getClass();
        kotlin.jvm.internal.e.f(eglSurface, "eglSurface");
        if (!kotlin.jvm.internal.e.a((b) lVar.f16246c, new b(EGL14.eglGetCurrentContext())) || !eglSurface.equals(new e(EGL14.eglGetCurrentSurface(d.f20412h)))) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        int i3 = this.f3260c;
        if (i3 < 0) {
            e eglSurface2 = this.f3259b;
            int i10 = d.f20410f;
            kotlin.jvm.internal.e.f(eglSurface2, "eglSurface");
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(((c) lVar.f16245b).f20405a, eglSurface2.f20422a, i10, iArr, 0);
            i3 = iArr[0];
        }
        int i11 = i3;
        int i12 = this.f3261d;
        if (i12 < 0) {
            e eglSurface3 = this.f3259b;
            int i13 = d.f20411g;
            kotlin.jvm.internal.e.f(eglSurface3, "eglSurface");
            int[] iArr2 = new int[1];
            EGL14.eglQuerySurface(((c) lVar.f16245b).f20405a, eglSurface3.f20422a, i13, iArr2, 0);
            i12 = iArr2[0];
        }
        int i14 = i12;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i11 * i14 * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, i11, i14, 6408, 5121, allocateDirect);
        xf.a.b("glReadPixels");
        allocateDirect.rewind();
        Bitmap createBitmap = Bitmap.createBitmap(i11, i14, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        createBitmap.compress(format, 90, byteArrayOutputStream);
        createBitmap.recycle();
    }
}
