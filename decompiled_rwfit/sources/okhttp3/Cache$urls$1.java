package okhttp3;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.ke;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.e;
import okhttp3.internal.cache.DiskLruCache;
import ph.a;

/* loaded from: classes2.dex */
public final class Cache$urls$1 implements Iterator<String>, a {
    private boolean canRemove;
    private final Iterator<DiskLruCache.Snapshot> delegate;
    private String nextUrl;
    final /* synthetic */ Cache this$0;

    public Cache$urls$1(Cache cache) {
        this.this$0 = cache;
        this.delegate = cache.getCache$okhttp().snapshots();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextUrl != null) {
            return true;
        }
        this.canRemove = false;
        while (this.delegate.hasNext()) {
            try {
                DiskLruCache.Snapshot next = this.delegate.next();
                try {
                    continue;
                    this.nextUrl = e6.b(next.getSource(0)).M(Format.OFFSET_SAMPLE_RELATIVE);
                    ke.a(next, null);
                    return true;
                } finally {
                    try {
                        continue;
                    } catch (Throwable th2) {
                    }
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
            throw new IllegalStateException("remove() before next()");
        }
        this.delegate.remove();
    }

    @Override // java.util.Iterator
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.nextUrl;
        e.c(str);
        this.nextUrl = null;
        this.canRemove = true;
        return str;
    }
}
