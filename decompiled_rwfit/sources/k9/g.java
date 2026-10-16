package k9;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.google.android.gms.internal.mlkit_vision_barcode.sc;
import java.io.Serializable;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class g implements j9.e, a {

    /* renamed from: a, reason: collision with root package name */
    public int f15548a;

    /* renamed from: b, reason: collision with root package name */
    public Serializable f15549b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f15550c;

    /* renamed from: d, reason: collision with root package name */
    public Object f15551d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Object f15552f;

    /* renamed from: g, reason: collision with root package name */
    public Object f15553g;

    /* renamed from: h, reason: collision with root package name */
    public Object f15554h;

    /* renamed from: i, reason: collision with root package name */
    public Object f15555i;

    /* renamed from: j, reason: collision with root package name */
    public Object f15556j;

    public g(int i3) {
        switch (i3) {
            case 1:
                this.f15548a = -1;
                break;
            default:
                this.f15549b = new AtomicBoolean();
                this.f15550c = new AtomicBoolean(true);
                this.f15551d = new e();
                this.e = new a2.g(3);
                this.f15552f = new i9.f();
                this.f15553g = new i9.f();
                this.f15554h = new float[16];
                this.f15555i = new float[16];
                break;
        }
    }

    public SurfaceTexture a() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        sc.b();
        e eVar = (e) this.f15551d;
        eVar.getClass();
        int c9 = sc.c(TextUtils.join("\n", e.f15535i), TextUtils.join("\n", e.f15536j));
        eVar.f15542c = c9;
        eVar.f15543d = GLES20.glGetUniformLocation(c9, "uMvpMatrix");
        eVar.e = GLES20.glGetUniformLocation(eVar.f15542c, "uTexMatrix");
        eVar.f15544f = GLES20.glGetAttribLocation(eVar.f15542c, "aPosition");
        eVar.f15545g = GLES20.glGetAttribLocation(eVar.f15542c, "aTexCoords");
        eVar.f15546h = GLES20.glGetUniformLocation(eVar.f15542c, "uTexture");
        sc.b();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        sc.b();
        this.f15548a = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f15548a);
        this.f15556j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: k9.f
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                ((AtomicBoolean) g.this.f15549b).set(true);
            }
        });
        return (SurfaceTexture) this.f15556j;
    }

    public void b(int i3, byte[] bArr, byte[] bArr2) {
        if (bArr != null && i3 < 0) {
            throw new IllegalArgumentException("invalid manufacture id");
        }
        if (bArr2 != null) {
            if (bArr == null) {
                throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
            }
            if (bArr.length != bArr2.length) {
                throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
            }
        }
        this.f15548a = i3;
        this.f15555i = bArr;
        this.f15556j = bArr2;
    }

    public void c(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
        if (parcelUuid == null) {
            throw new IllegalArgumentException("serviceDataUuid is null");
        }
        if (bArr2 != null) {
            if (bArr == null) {
                throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
            }
            if (bArr.length != bArr2.length) {
                throw new IllegalArgumentException("size mismatch for service data and service data mask");
            }
        }
        this.f15552f = parcelUuid;
        this.f15553g = bArr;
        this.f15554h = bArr2;
    }
}
