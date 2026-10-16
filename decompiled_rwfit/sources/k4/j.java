package k4;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.android.gms.internal.mlkit_vision_common.h6;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import okhttp3.internal.http2.Http2;
import z3.s;

/* loaded from: classes.dex */
public final class j implements x3.g {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f15503a;

    /* renamed from: b, reason: collision with root package name */
    public final a f15504b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.g f15505c;

    public j(ArrayList arrayList, a aVar, a4.g gVar) {
        this.f15503a = arrayList;
        this.f15504b = aVar;
        this.f15505c = gVar;
    }

    @Override // x3.g
    public final boolean a(Object obj, x3.f fVar) {
        InputStream inputStream = (InputStream) obj;
        if (((Boolean) fVar.c(i.f15502b)).booleanValue()) {
            return false;
        }
        return h6.b(this.f15505c, inputStream, this.f15503a) == ImageHeaderParser$ImageType.GIF;
    }

    @Override // x3.g
    public final s b(Object obj, int i3, int i10, x3.f fVar) {
        byte[] bArr;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            byte[] bArr2 = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.f15504b.b(ByteBuffer.wrap(bArr), i3, i10, fVar);
    }
}
