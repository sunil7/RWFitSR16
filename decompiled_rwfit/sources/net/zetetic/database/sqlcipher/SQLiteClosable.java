package net.zetetic.database.sqlcipher;

import java.io.Closeable;

/* loaded from: classes2.dex */
public abstract class SQLiteClosable implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public int f16474a = 1;

    public final void b() {
        synchronized (this) {
            try {
                int i3 = this.f16474a;
                if (i3 <= 0) {
                    throw new IllegalStateException("attempt to re-open an already-closed object: " + this);
                }
                this.f16474a = i3 + 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract void c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        e();
    }

    public final void e() {
        boolean z5;
        synchronized (this) {
            z5 = true;
            int i3 = this.f16474a - 1;
            this.f16474a = i3;
            if (i3 != 0) {
                z5 = false;
            }
        }
        if (z5) {
            c();
        }
    }
}
