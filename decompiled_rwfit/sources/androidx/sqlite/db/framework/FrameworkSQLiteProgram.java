package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram delegate) {
        e.f(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i3, byte[] value) {
        e.f(value, "value");
        this.delegate.bindBlob(i3, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i3, double d5) {
        this.delegate.bindDouble(i3, d5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i3, long j4) {
        this.delegate.bindLong(i3, j4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i3) {
        this.delegate.bindNull(i3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i3, String value) {
        e.f(value, "value");
        this.delegate.bindString(i3, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }
}
