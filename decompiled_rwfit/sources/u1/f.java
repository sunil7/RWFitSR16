package u1;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class f extends b {
    public f(byte[] bArr) {
        super(bArr);
        this.f18833a.mark(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public final void c(long j4) {
        int i3 = this.f18835c;
        if (i3 > j4) {
            this.f18835c = 0;
            this.f18833a.reset();
        } else {
            j4 -= i3;
        }
        b((int) j4);
    }

    public f(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.f18833a.mark(SubsamplingScaleImageView.TILE_SIZE_AUTO);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
