package g4;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a0 extends MediaDataSource implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f13811a;

    public a0(ByteBuffer byteBuffer) {
        this.f13811a = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f13811a.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j4, byte[] bArr, int i3, int i10) {
        ByteBuffer byteBuffer = this.f13811a;
        if (j4 >= byteBuffer.limit()) {
            return -1;
        }
        byteBuffer.position((int) j4);
        int min = Math.min(i10, byteBuffer.remaining());
        byteBuffer.get(bArr, i3, min);
        return min;
    }
}
