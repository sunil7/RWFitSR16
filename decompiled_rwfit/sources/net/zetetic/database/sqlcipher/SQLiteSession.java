package net.zetetic.database.sqlcipher;

import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import net.zetetic.database.sqlcipher.SQLiteConnectionPool;

/* loaded from: classes2.dex */
public final class SQLiteSession {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteConnectionPool f16576a;

    /* renamed from: b, reason: collision with root package name */
    public SQLiteConnection f16577b;

    /* renamed from: c, reason: collision with root package name */
    public int f16578c;

    /* renamed from: d, reason: collision with root package name */
    public int f16579d;
    public Transaction e;

    /* renamed from: f, reason: collision with root package name */
    public Transaction f16580f;

    public static final class Transaction {

        /* renamed from: a, reason: collision with root package name */
        public Transaction f16581a;

        /* renamed from: b, reason: collision with root package name */
        public int f16582b;

        /* renamed from: c, reason: collision with root package name */
        public SQLiteTransactionListener f16583c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f16584d;
        public boolean e;
    }

    public SQLiteSession(SQLiteConnectionPool sQLiteConnectionPool) {
        if (sQLiteConnectionPool == null) {
            throw new IllegalArgumentException("connectionPool must not be null");
        }
        this.f16576a = sQLiteConnectionPool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r21, int r22, android.os.CancellationSignal r23) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zetetic.database.sqlcipher.SQLiteSession.a(java.lang.String, int, android.os.CancellationSignal):void");
    }

    public final void b(int i3, SQLiteTransactionListener sQLiteTransactionListener, int i10, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (this.f16580f == null) {
            a(null, i10, cancellationSignal);
        }
        try {
            if (this.f16580f == null) {
                if (i3 == 1) {
                    this.f16577b.h("BEGIN IMMEDIATE;", null, cancellationSignal);
                } else if (i3 != 2) {
                    this.f16577b.h("BEGIN;", null, cancellationSignal);
                } else {
                    this.f16577b.h("BEGIN EXCLUSIVE;", null, cancellationSignal);
                }
            }
            if (sQLiteTransactionListener != null) {
                try {
                    sQLiteTransactionListener.b();
                } catch (RuntimeException e) {
                    if (this.f16580f == null) {
                        this.f16577b.h("ROLLBACK;", null, cancellationSignal);
                    }
                    throw e;
                }
            }
            Transaction transaction = this.e;
            if (transaction != null) {
                this.e = transaction.f16581a;
                transaction.f16581a = null;
                transaction.f16584d = false;
                transaction.e = false;
            } else {
                transaction = new Transaction();
            }
            transaction.f16582b = i3;
            transaction.f16583c = sQLiteTransactionListener;
            transaction.f16581a = this.f16580f;
            this.f16580f = transaction;
        } catch (Throwable th2) {
            if (this.f16580f == null) {
                k();
            }
            throw th2;
        }
    }

    public final void c(CancellationSignal cancellationSignal, boolean z5) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Transaction transaction = this.f16580f;
        boolean z6 = false;
        boolean z8 = (transaction.f16584d || z5) && !transaction.e;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.f16583c;
        if (sQLiteTransactionListener != null) {
            try {
                if (z8) {
                    sQLiteTransactionListener.a();
                } else {
                    sQLiteTransactionListener.c();
                }
            } catch (RuntimeException e) {
                e = e;
            }
        }
        z6 = z8;
        e = null;
        Transaction transaction2 = transaction.f16581a;
        this.f16580f = transaction2;
        transaction.f16581a = this.e;
        transaction.f16583c = null;
        this.e = transaction;
        if (transaction2 == null) {
            try {
                if (z6) {
                    this.f16577b.h("COMMIT;", null, cancellationSignal);
                } else {
                    this.f16577b.h("ROLLBACK;", null, cancellationSignal);
                }
                k();
            } catch (Throwable th2) {
                k();
                throw th2;
            }
        } else if (!z6) {
            transaction2.e = true;
        }
        if (e != null) {
            throw e;
        }
    }

    public final void d(int i3, String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i3, null)) {
            return;
        }
        a(str, i3, null);
        try {
            this.f16577b.h(str, objArr, null);
        } finally {
            k();
        }
    }

    public final int e(int i3, String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i3, null)) {
            return 0;
        }
        a(str, i3, null);
        try {
            return this.f16577b.i(str, objArr);
        } finally {
            k();
        }
    }

    public final int f(String str, Object[] objArr, CursorWindow cursorWindow, int i3, int i10, boolean z5, int i11, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        }
        if (j(str, i11, cancellationSignal)) {
            cursorWindow.clear();
            return 0;
        }
        a(str, i11, cancellationSignal);
        try {
            return this.f16577b.j(str, objArr, cursorWindow, i3, i10, z5, cancellationSignal);
        } finally {
            k();
        }
    }

    public final long g(int i3, String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i3, null)) {
            return 0L;
        }
        a(str, i3, null);
        try {
            return this.f16577b.k(str, objArr);
        } finally {
            k();
        }
    }

    public final long h(int i3, String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i3, null)) {
            return 0L;
        }
        a(str, i3, null);
        try {
            return this.f16577b.l(str, objArr);
        } finally {
            k();
        }
    }

    public final String i(int i3, String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i3, null)) {
            return null;
        }
        a(str, i3, null);
        try {
            return this.f16577b.m(str, objArr);
        } finally {
            k();
        }
    }

    public final boolean j(String str, int i3, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        int sqlStatementType = DatabaseUtils.getSqlStatementType(str);
        if (sqlStatementType == 4) {
            l();
            b(2, null, i3, cancellationSignal);
            return true;
        }
        if (sqlStatementType != 5) {
            if (sqlStatementType != 6) {
                return false;
            }
            if (this.f16580f == null) {
                throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
            }
            c(cancellationSignal, false);
            return true;
        }
        if (this.f16580f == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
        l();
        Transaction transaction = this.f16580f;
        transaction.f16584d = true;
        if (transaction == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
        c(cancellationSignal, false);
        return true;
    }

    public final void k() {
        int i3 = this.f16579d - 1;
        this.f16579d = i3;
        if (i3 == 0) {
            try {
                this.f16576a.y(this.f16577b);
            } finally {
                this.f16577b = null;
            }
        }
    }

    public final void l() {
        Transaction transaction = this.f16580f;
        if (transaction != null && transaction.f16584d) {
            throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        }
    }

    public final boolean m(long j4) {
        boolean z5;
        if (this.f16580f == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
        l();
        Transaction transaction = this.f16580f;
        if (transaction != null && transaction.f16581a != null) {
            throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
        }
        if (!transaction.e) {
            SQLiteConnectionPool sQLiteConnectionPool = this.f16576a;
            SQLiteConnection sQLiteConnection = this.f16577b;
            int i3 = this.f16578c;
            synchronized (sQLiteConnectionPool.f16507b) {
                try {
                    if (!sQLiteConnectionPool.f16516l.containsKey(sQLiteConnection)) {
                        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                    }
                    if (sQLiteConnectionPool.f16510f) {
                        boolean z6 = sQLiteConnection.e;
                        SQLiteConnectionPool.ConnectionWaiter connectionWaiter = sQLiteConnectionPool.f16513i;
                        if (connectionWaiter != null) {
                            int i10 = (i3 & 4) != 0 ? 1 : 0;
                            while (i10 <= connectionWaiter.f16524d) {
                                if (!z6 && connectionWaiter.e) {
                                    connectionWaiter = connectionWaiter.f16521a;
                                    if (connectionWaiter == null) {
                                        break;
                                    }
                                }
                                z5 = true;
                            }
                        }
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                } finally {
                }
            }
            if (z5) {
                Transaction transaction2 = this.f16580f;
                int i11 = transaction2.f16582b;
                SQLiteTransactionListener sQLiteTransactionListener = transaction2.f16583c;
                int i12 = this.f16578c;
                c(null, true);
                if (j4 > 0) {
                    try {
                        Thread.sleep(j4);
                    } catch (InterruptedException unused) {
                    }
                }
                b(i11, sQLiteTransactionListener, i12, null);
                return true;
            }
        }
        return false;
    }
}
