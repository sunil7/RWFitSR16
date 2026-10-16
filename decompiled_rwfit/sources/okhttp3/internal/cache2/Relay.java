package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.internal.Util;
import okio.ByteString;
import wh.c0;
import wh.f0;
import wh.j;
import wh.m;

/* loaded from: classes2.dex */
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN;
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final j buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private c0 upstream;
    private final j upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    public static final class Companion {
        private Companion() {
        }

        public final Relay edit(File file, c0 upstream, ByteString metadata, long j4) throws IOException {
            e.f(file, "file");
            e.f(upstream, "upstream");
            e.f(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, j4, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            e.f(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            e.e(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            j jVar = new j();
            fileOperator.read(0L, jVar, 32L);
            if (!e.a(jVar.s(r11.size()), Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long readLong = jVar.readLong();
            long readLong2 = jVar.readLong();
            j jVar2 = new j();
            fileOperator.read(32 + readLong, jVar2, readLong2);
            return new Relay(randomAccessFile, null, readLong, jVar2.s(jVar2.f19654b), 0L, null);
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public final class RelaySource implements c0 {
        private FileOperator fileOperator;
        private long sourcePos;
        private final f0 timeout = new f0();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            e.c(file);
            FileChannel channel = file.getChannel();
            e.e(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay.this.setSourceCount(r2.getSourceCount() - 1);
                if (Relay.this.getSourceCount() == 0) {
                    RandomAccessFile file = Relay.this.getFile();
                    Relay.this.setFile(null);
                    randomAccessFile = file;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0084, code lost:
        
            if (r0 != 2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0086, code lost:
        
            r6 = java.lang.Math.min(r21, r19.this$0.getUpstreamPos() - r19.sourcePos);
            r2 = r19.fileOperator;
            kotlin.jvm.internal.e.c(r2);
            r2.read(r19.sourcePos + 32, r20, r6);
            r19.sourcePos += r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00a5, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:
        
            r0 = r19.this$0.getUpstream();
            kotlin.jvm.internal.e.c(r0);
            r11 = r0.read(r19.this$0.getUpstreamBuffer(), r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00c2, code lost:
        
            if (r11 != (-1)) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00c4, code lost:
        
            r0 = r19.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00cd, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00cf, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:
        
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00d7, code lost:
        
            if (r0 == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00d9, code lost:
        
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00dd, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00ed, code lost:
        
            r6 = java.lang.Math.min(r11, r21);
            r19.this$0.getUpstreamBuffer().f(0, r20, r6);
            r19.sourcePos += r6;
            r13 = r19.fileOperator;
            kotlin.jvm.internal.e.c(r13);
            r13.write(r19.this$0.getUpstreamPos() + 32, r19.this$0.getUpstreamBuffer().clone(), r11);
            r4 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0123, code lost:
        
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0124, code lost:
        
            r19.this$0.getBuffer().write(r19.this$0.getUpstreamBuffer(), r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0143, code lost:
        
            if (r19.this$0.getBuffer().f19654b <= r19.this$0.getBufferMaxSize()) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0145, code lost:
        
            r19.this$0.getBuffer().a(r19.this$0.getBuffer().f19654b - r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0160, code lost:
        
            r0 = r19.this$0;
            r0.setUpstreamPos(r0.getUpstreamPos() + r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x016a, code lost:
        
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x016b, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x016d, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x016e, code lost:
        
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0175, code lost:
        
            if (r0 == null) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0177, code lost:
        
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x017a, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x017b, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0185, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x015e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0189, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00ea, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x018c, code lost:
        
            monitor-enter(r19.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x018d, code lost:
        
            r19.this$0.setUpstreamReader(null);
            r3 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0194, code lost:
        
            if (r3 == null) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x019d, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x01a0, code lost:
        
            r3.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x01a4, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x019e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01a6, code lost:
        
            throw r0;
         */
        @Override // wh.c0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long read(wh.j r20, long r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 433
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(wh.j, long):long");
        }

        @Override // wh.c0
        public f0 timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion.getClass();
        PREFIX_CLEAN = m.c("OkHttp cache v1\n");
        PREFIX_DIRTY = m.c("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, c0 c0Var, long j4, ByteString byteString, long j10) {
        this.file = randomAccessFile;
        this.upstream = c0Var;
        this.upstreamPos = j4;
        this.metadata = byteString;
        this.bufferMaxSize = j10;
        this.upstreamBuffer = new j();
        this.complete = c0Var == null;
        this.buffer = new j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j4, long j10) throws IOException {
        j jVar = new j();
        jVar.W(byteString);
        jVar.d0(j4);
        jVar.d0(j10);
        if (jVar.f19654b != 32) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        RandomAccessFile randomAccessFile = this.file;
        e.c(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        e.e(channel, "file!!.channel");
        new FileOperator(channel).write(0L, jVar, 32L);
    }

    private final void writeMetadata(long j4) throws IOException {
        j jVar = new j();
        jVar.W(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        e.c(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        e.e(channel, "file!!.channel");
        new FileOperator(channel).write(32 + j4, jVar, this.metadata.size());
    }

    public final void commit(long j4) throws IOException {
        writeMetadata(j4);
        RandomAccessFile randomAccessFile = this.file;
        e.c(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j4, this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        e.c(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        c0 c0Var = this.upstream;
        if (c0Var != null) {
            Util.closeQuietly(c0Var);
        }
        this.upstream = null;
    }

    public final j getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final c0 getUpstream() {
        return this.upstream;
    }

    public final j getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final c0 newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z5) {
        this.complete = z5;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i3) {
        this.sourceCount = i3;
    }

    public final void setUpstream(c0 c0Var) {
        this.upstream = c0Var;
    }

    public final void setUpstreamPos(long j4) {
        this.upstreamPos = j4;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, c0 c0Var, long j4, ByteString byteString, long j10, c cVar) {
        this(randomAccessFile, c0Var, j4, byteString, j10);
    }
}
