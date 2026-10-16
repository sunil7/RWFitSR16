package net.zetetic.database.sqlcipher;

import android.os.CancellationSignal;

/* loaded from: classes2.dex */
public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f16563a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16564b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16565c;

    /* renamed from: d, reason: collision with root package name */
    public final CancellationSignal f16566d;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2, CancellationSignal cancellationSignal) {
        this.f16563a = sQLiteDatabase;
        this.f16564b = str2;
        this.f16565c = str;
        this.f16566d = cancellationSignal;
    }

    public final String toString() {
        return "SQLiteDirectCursorDriver: " + this.f16565c;
    }
}
