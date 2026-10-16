package u1;

import android.media.MediaDataSource;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a extends MediaDataSource implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public long f18830a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f18831b;

    public a(f fVar) {
        this.f18831b = fVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j4, byte[] bArr, int i3, int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (j4 < 0) {
            return -1;
        }
        try {
            long j10 = this.f18830a;
            f fVar = this.f18831b;
            if (j10 != j4) {
                if (j10 >= 0 && j4 >= j10 + fVar.f18833a.available()) {
                    return -1;
                }
                fVar.c(j4);
                this.f18830a = j4;
            }
            if (i10 > fVar.f18833a.available()) {
                i10 = fVar.f18833a.available();
            }
            int read = fVar.read(bArr, i3, i10);
            if (read >= 0) {
                this.f18830a += read;
                return read;
            }
        } catch (IOException unused) {
        }
        this.f18830a = -1L;
        return -1;
    }
}
