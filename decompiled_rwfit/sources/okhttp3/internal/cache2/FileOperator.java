package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.e;
import wh.j;

/* loaded from: classes2.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        e.f(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j4, j sink, long j10) {
        e.f(sink, "sink");
        if (j10 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j11 = j4;
        long j12 = j10;
        while (j12 > 0) {
            long transferTo = this.fileChannel.transferTo(j11, j12, sink);
            j11 += transferTo;
            j12 -= transferTo;
        }
    }

    public final void write(long j4, j source, long j10) throws IOException {
        e.f(source, "source");
        if (j10 < 0 || j10 > source.f19654b) {
            throw new IndexOutOfBoundsException();
        }
        long j11 = j4;
        long j12 = j10;
        while (j12 > 0) {
            long transferFrom = this.fileChannel.transferFrom(source, j11, j12);
            j11 += transferFrom;
            j12 -= transferFrom;
        }
    }
}
