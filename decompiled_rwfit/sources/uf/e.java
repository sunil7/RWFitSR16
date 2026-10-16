package uf;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.DngCreator;
import android.media.Image;
import android.media.ImageReader;
import androidx.camera.core.impl.y0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class e extends f implements ImageReader.OnImageAvailableListener {
    public final ff.n e;

    /* renamed from: f, reason: collision with root package name */
    public final ff.j f19075f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageReader f19076g;

    /* renamed from: h, reason: collision with root package name */
    public final CaptureRequest.Builder f19077h;

    /* renamed from: i, reason: collision with root package name */
    public DngCreator f19078i;

    public e(y0 y0Var, ff.n nVar, CaptureRequest.Builder builder, ImageReader imageReader) {
        super(y0Var, nVar);
        this.e = nVar;
        this.f19077h = builder;
        this.f19076g = imageReader;
        imageReader.setOnImageAvailableListener(this, qf.i.a("FallbackCameraThread").f17956c);
        this.f19075f = new ff.j(this, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
    @Override // android.media.ImageReader.OnImageAvailableListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onImageAvailable(android.media.ImageReader r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Unknown format: "
            java.lang.String r1 = "onImageAvailable started."
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            ef.b r2 = uf.f.f19079d
            r3 = 1
            r2.b(r3, r1)
            r1 = 0
            android.media.Image r7 = r7.acquireNextImage()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            int[] r4 = uf.d.f19074a     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.lang.Object r5 = r6.f194a     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            androidx.camera.core.impl.y0 r5 = (androidx.camera.core.impl.y0) r5     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.io.Serializable r5 = r5.f1528f     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            com.otaliastudios.cameraview.controls.PictureFormat r5 = (com.otaliastudios.cameraview.controls.PictureFormat) r5     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            int r5 = r5.ordinal()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            r4 = r4[r5]     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            if (r4 == r3) goto L4b
            r5 = 2
            if (r4 != r5) goto L31
            r6.y(r7)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            goto L4e
        L2c:
            r0 = move-exception
            r1 = r7
            goto L71
        L2f:
            r0 = move-exception
            goto L64
        L31:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.lang.Object r0 = r6.f194a     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            androidx.camera.core.impl.y0 r0 = (androidx.camera.core.impl.y0) r0     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.io.Serializable r0 = r0.f1528f     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            com.otaliastudios.cameraview.controls.PictureFormat r0 = (com.otaliastudios.cameraview.controls.PictureFormat) r0     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            r3.append(r0)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            throw r2     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
        L4b:
            r6.x(r7)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
        L4e:
            if (r7 == 0) goto L53
            r7.close()
        L53:
            java.lang.String r7 = "onImageAvailable ended."
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            r2.b(r3, r7)
            r6.n()
            return
        L60:
            r0 = move-exception
            goto L71
        L62:
            r0 = move-exception
            r7 = r1
        L64:
            r6.f194a = r1     // Catch: java.lang.Throwable -> L2c
            r6.f196c = r0     // Catch: java.lang.Throwable -> L2c
            r6.n()     // Catch: java.lang.Throwable -> L2c
            if (r7 == 0) goto L70
            r7.close()
        L70:
            return
        L71:
            if (r1 == 0) goto L76
            r1.close()
        L76:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: uf.e.onImageAvailable(android.media.ImageReader):void");
    }

    @Override // ab.n
    public final void u() {
        this.f19075f.l(this.e);
    }

    public final void x(Image image) {
        int i3 = 0;
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        y0 y0Var = (y0) this.f194a;
        y0Var.e = bArr;
        y0Var.f1525b = 0;
        try {
            int c9 = new u1.g(new ByteArrayInputStream((byte[]) ((y0) this.f194a).e)).c(1, "Orientation");
            y0 y0Var2 = (y0) this.f194a;
            switch (c9) {
                case 3:
                case 4:
                    i3 = 180;
                    break;
                case 5:
                case 6:
                    i3 = 90;
                    break;
                case 7:
                case 8:
                    i3 = SubsamplingScaleImageView.ORIENTATION_270;
                    break;
            }
            y0Var2.f1525b = i3;
        } catch (IOException unused) {
        }
    }

    public final void y(Image image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        try {
            this.f19078i.writeImage(bufferedOutputStream, image);
            bufferedOutputStream.flush();
            ((y0) this.f194a).e = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.f19078i.close();
            try {
                bufferedOutputStream.close();
            } catch (IOException unused) {
            }
            throw new RuntimeException(e);
        }
    }
}
