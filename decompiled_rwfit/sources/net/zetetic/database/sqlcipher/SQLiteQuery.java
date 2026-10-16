package net.zetetic.database.sqlcipher;

import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.util.Log;

/* loaded from: classes2.dex */
public final class SQLiteQuery extends SQLiteProgram {

    /* renamed from: i, reason: collision with root package name */
    public final CancellationSignal f16575i;

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, null, cancellationSignal);
        this.f16575i = cancellationSignal;
    }

    public final int i(CursorWindow cursorWindow, int i3, int i10, boolean z5) {
        b();
        try {
            try {
                cursorWindow.acquireReference();
            } catch (Throwable th2) {
                e();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
        } catch (SQLiteDatabaseCorruptException e) {
            e = e;
        } catch (SQLiteException e10) {
            e = e10;
        } catch (Throwable th4) {
            th = th4;
            Throwable th5 = th;
            cursorWindow.releaseReference();
            throw th5;
        }
        try {
            int f2 = this.f16570b.l().f(this.f16571c, this.f16574g, cursorWindow, i3, i10, z5, g(), this.f16575i);
            cursorWindow.releaseReference();
            e();
            return f2;
        } catch (SQLiteDatabaseCorruptException e11) {
            e = e11;
            SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = e;
            h();
            throw sQLiteDatabaseCorruptException;
        } catch (SQLiteException e12) {
            e = e12;
            SQLiteException sQLiteException = e;
            Log.e("SQLiteQuery", "exception: " + sQLiteException.getMessage() + "; query: " + this.f16571c);
            throw sQLiteException;
        }
    }

    public final String toString() {
        return "SQLiteQuery: " + this.f16571c;
    }
}
