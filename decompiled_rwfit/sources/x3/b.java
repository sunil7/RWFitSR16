package x3;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface b {
    ImageHeaderParser$ImageType a(ByteBuffer byteBuffer);

    int b(InputStream inputStream, a4.g gVar);

    ImageHeaderParser$ImageType c(InputStream inputStream);
}
