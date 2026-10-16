package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public final class m1 extends Writer implements AutoCloseable {

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f2225b = new StringBuilder(128);

    /* renamed from: a, reason: collision with root package name */
    public final String f2224a = "FragmentManager";

    public final void b() {
        StringBuilder sb2 = this.f2225b;
        if (sb2.length() > 0) {
            Log.d(this.f2224a, sb2.toString());
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        b();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        b();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i3, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            char c9 = cArr[i3 + i11];
            if (c9 == '\n') {
                b();
            } else {
                this.f2225b.append(c9);
            }
        }
    }
}
