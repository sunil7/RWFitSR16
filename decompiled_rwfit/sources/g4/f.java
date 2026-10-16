package g4;

import android.graphics.ImageDecoder;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal.http2.Http2;

/* loaded from: classes.dex */
public final class f implements x3.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13820a;

    /* renamed from: b, reason: collision with root package name */
    public final a f13821b;

    public f(int i3) {
        this.f13820a = i3;
        switch (i3) {
            case 1:
                this.f13821b = new a();
                break;
            default:
                this.f13821b = new a();
                break;
        }
    }

    @Override // x3.g
    public final /* bridge */ /* synthetic */ boolean a(Object obj, x3.f fVar) {
        switch (this.f13820a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // x3.g
    public final z3.s b(Object obj, int i3, int i10, x3.f fVar) {
        ImageDecoder.Source createSource;
        ImageDecoder.Source createSource2;
        a aVar = this.f13821b;
        switch (this.f13820a) {
            case 0:
                createSource = ImageDecoder.createSource((ByteBuffer) obj);
                return aVar.c(createSource, i3, i10, fVar);
            default:
                InputStream inputStream = (InputStream) obj;
                AtomicReference atomicReference = t4.b.f18505a;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
                AtomicReference atomicReference2 = t4.b.f18505a;
                byte[] bArr = (byte[]) atomicReference2.getAndSet(null);
                if (bArr == null) {
                    bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
                }
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        atomicReference2.set(bArr);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        createSource2 = ImageDecoder.createSource((ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0));
                        return aVar.c(createSource2, i3, i10, fVar);
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
        }
    }
}
