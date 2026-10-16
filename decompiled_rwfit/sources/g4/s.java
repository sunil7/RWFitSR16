package g4;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class s implements x3.b {
    @Override // x3.b
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // x3.b
    public final int b(InputStream inputStream, a4.g gVar) {
        int c9 = new u1.g(inputStream).c(1, "Orientation");
        if (c9 == 0) {
            return -1;
        }
        return c9;
    }

    @Override // x3.b
    public final ImageHeaderParser$ImageType c(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
}
