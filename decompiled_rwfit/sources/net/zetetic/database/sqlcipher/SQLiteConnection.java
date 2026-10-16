package net.zetetic.database.sqlcipher;

import android.database.CursorWindow;
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.v4.media.session.e;
import android.util.Log;
import android.util.LruCache;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import net.zetetic.database.DatabaseUtils;
import r5.a;

/* loaded from: classes2.dex */
public final class SQLiteConnection implements CancellationSignal.OnCancelListener {

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f16475m = new String[0];

    /* renamed from: n, reason: collision with root package name */
    public static final byte[] f16476n = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final CloseGuard f16477a;

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteConnectionPool f16478b;

    /* renamed from: c, reason: collision with root package name */
    public final SQLiteDatabaseConfiguration f16479c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16480d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f16481f;

    /* renamed from: g, reason: collision with root package name */
    public final PreparedStatementCache f16482g;

    /* renamed from: h, reason: collision with root package name */
    public PreparedStatement f16483h;

    /* renamed from: i, reason: collision with root package name */
    public final OperationLog f16484i;

    /* renamed from: j, reason: collision with root package name */
    public long f16485j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16486k;

    /* renamed from: l, reason: collision with root package name */
    public int f16487l;

    public static final class Operation {

        /* renamed from: a, reason: collision with root package name */
        public long f16488a;

        /* renamed from: b, reason: collision with root package name */
        public long f16489b;

        /* renamed from: c, reason: collision with root package name */
        public long f16490c;

        /* renamed from: d, reason: collision with root package name */
        public String f16491d;
        public String e;

        /* renamed from: f, reason: collision with root package name */
        public ArrayList f16492f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f16493g;

        /* renamed from: h, reason: collision with root package name */
        public RuntimeException f16494h;

        /* renamed from: i, reason: collision with root package name */
        public int f16495i;

        public final void a(StringBuilder sb2) {
            sb2.append(this.f16491d);
            if (this.f16493g) {
                sb2.append(" took ");
                sb2.append(this.f16490c - this.f16489b);
                sb2.append(Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            } else {
                sb2.append(" started ");
                sb2.append(System.currentTimeMillis() - this.f16488a);
                sb2.append("ms ago");
            }
            sb2.append(" - ");
            sb2.append(!this.f16493g ? "running" : this.f16494h != null ? "failed" : "succeeded");
            if (this.e != null) {
                sb2.append(", sql=\"");
                sb2.append(this.e.replaceAll("[\\s]*\\n+[\\s]*", " "));
                sb2.append("\"");
            }
            if (this.f16494h != null) {
                sb2.append(", exception=\"");
                sb2.append(this.f16494h.getMessage());
                sb2.append("\"");
            }
        }
    }

    public static final class OperationLog {

        /* renamed from: a, reason: collision with root package name */
        public final Operation[] f16496a = new Operation[20];

        /* renamed from: b, reason: collision with root package name */
        public int f16497b;

        /* renamed from: c, reason: collision with root package name */
        public int f16498c;

        public final int a(String str, String str2, Object[] objArr) {
            int i3;
            synchronized (this.f16496a) {
                try {
                    int i10 = (this.f16497b + 1) % 20;
                    Operation[] operationArr = this.f16496a;
                    Operation operation = operationArr[i10];
                    if (operation == null) {
                        operation = new Operation();
                        operationArr[i10] = operation;
                    } else {
                        operation.f16493g = false;
                        operation.f16494h = null;
                        ArrayList arrayList = operation.f16492f;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                    operation.f16488a = System.currentTimeMillis();
                    operation.f16489b = SystemClock.uptimeMillis();
                    operation.f16491d = str;
                    operation.e = str2;
                    if (objArr != null) {
                        ArrayList arrayList2 = operation.f16492f;
                        if (arrayList2 == null) {
                            operation.f16492f = new ArrayList();
                        } else {
                            arrayList2.clear();
                        }
                        for (Object obj : objArr) {
                            if (obj == null || !(obj instanceof byte[])) {
                                operation.f16492f.add(obj);
                            } else {
                                operation.f16492f.add(SQLiteConnection.f16476n);
                            }
                        }
                    }
                    int i11 = this.f16498c;
                    this.f16498c = i11 + 1;
                    i3 = (i11 << 8) | i10;
                    operation.f16495i = i3;
                    this.f16497b = i10;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return i3;
        }

        public final void b(int i3) {
            synchronized (this.f16496a) {
                Operation operation = this.f16496a[i3 & 255];
                if (operation.f16495i != i3) {
                    operation = null;
                }
                if (operation != null) {
                    operation.f16490c = SystemClock.uptimeMillis();
                    operation.f16493g = true;
                }
            }
        }

        public final void c(int i3) {
            synchronized (this.f16496a) {
                Operation operation = this.f16496a[i3 & 255];
                if (operation.f16495i != i3) {
                    operation = null;
                }
                if (operation != null) {
                    operation.f16490c = SystemClock.uptimeMillis();
                    operation.f16493g = true;
                }
            }
        }

        public final void d(RuntimeException runtimeException, int i3) {
            synchronized (this.f16496a) {
                Operation operation = this.f16496a[i3 & 255];
                if (operation.f16495i != i3) {
                    operation = null;
                }
                if (operation != null) {
                    operation.f16494h = runtimeException;
                }
            }
        }
    }

    public static final class PreparedStatement {

        /* renamed from: a, reason: collision with root package name */
        public PreparedStatement f16499a;

        /* renamed from: b, reason: collision with root package name */
        public String f16500b;

        /* renamed from: c, reason: collision with root package name */
        public long f16501c;

        /* renamed from: d, reason: collision with root package name */
        public int f16502d;
        public boolean e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f16503f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f16504g;
    }

    public final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        public PreparedStatementCache(int i3) {
            super(i3);
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean z5, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            PreparedStatement preparedStatement3 = preparedStatement;
            preparedStatement3.f16503f = false;
            if (preparedStatement3.f16504g) {
                return;
            }
            SQLiteConnection.this.n(preparedStatement3);
        }
    }

    public SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i3, boolean z5) {
        CloseGuard closeGuard = new CloseGuard();
        this.f16477a = closeGuard;
        this.f16484i = new OperationLog();
        this.f16478b = sQLiteConnectionPool;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.f16479c = sQLiteDatabaseConfiguration2;
        this.f16480d = i3;
        this.e = z5;
        this.f16481f = (sQLiteDatabaseConfiguration.f16555c & 1) != 0;
        this.f16482g = new PreparedStatementCache(sQLiteDatabaseConfiguration2.f16556d);
        closeGuard.a();
    }

    public static String d(String str) {
        return str.equals("0") ? "OFF" : str.equals("1") ? "NORMAL" : str.equals("2") ? "FULL" : str;
    }

    private static native void nativeBindBlob(long j4, long j10, int i3, byte[] bArr);

    private static native void nativeBindDouble(long j4, long j10, int i3, double d5);

    private static native void nativeBindLong(long j4, long j10, int i3, long j11);

    private static native void nativeBindNull(long j4, long j10, int i3);

    private static native void nativeBindString(long j4, long j10, int i3, String str);

    private static native void nativeCancel(long j4);

    private static native void nativeClose(long j4);

    private static native void nativeExecute(long j4, long j10);

    private static native int nativeExecuteForBlobFileDescriptor(long j4, long j10);

    private static native int nativeExecuteForChangedRowCount(long j4, long j10);

    private static native long nativeExecuteForCursorWindow(long j4, long j10, CursorWindow cursorWindow, int i3, int i10, boolean z5);

    private static native long nativeExecuteForLastInsertedRowId(long j4, long j10);

    private static native long nativeExecuteForLong(long j4, long j10);

    private static native String nativeExecuteForString(long j4, long j10);

    private static native void nativeExecuteRaw(long j4, long j10);

    private static native void nativeFinalizeStatement(long j4, long j10);

    private static native int nativeGetColumnCount(long j4, long j10);

    private static native String nativeGetColumnName(long j4, long j10, int i3);

    private static native int nativeGetDbLookaside(long j4);

    private static native int nativeGetParameterCount(long j4, long j10);

    private static native boolean nativeHasCodec();

    private static native boolean nativeIsReadOnly(long j4, long j10);

    private static native int nativeKey(long j4, byte[] bArr);

    private static native long nativeOpen(String str, int i3, String str2, boolean z5, boolean z6);

    private static native long nativePrepareStatement(long j4, String str);

    private static native int nativeReKey(long j4, byte[] bArr);

    private static native void nativeRegisterCustomFunction(long j4, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterLocalizedCollators(long j4, String str);

    private static native void nativeResetCancel(long j4, boolean z5);

    private static native void nativeResetStatementAndClearBindings(long j4, long j10);

    public static boolean o() {
        return nativeHasCodec();
    }

    public final PreparedStatement a(String str) {
        boolean z5;
        PreparedStatementCache preparedStatementCache = this.f16482g;
        PreparedStatement preparedStatement = preparedStatementCache.get(str);
        if (preparedStatement == null) {
            z5 = false;
        } else {
            if (!preparedStatement.f16504g) {
                return preparedStatement;
            }
            z5 = true;
        }
        long nativePrepareStatement = nativePrepareStatement(this.f16485j, str);
        try {
            int nativeGetParameterCount = nativeGetParameterCount(this.f16485j, nativePrepareStatement);
            int a3 = DatabaseUtils.a(str);
            boolean nativeIsReadOnly = nativeIsReadOnly(this.f16485j, nativePrepareStatement);
            PreparedStatement preparedStatement2 = this.f16483h;
            if (preparedStatement2 != null) {
                this.f16483h = preparedStatement2.f16499a;
                preparedStatement2.f16499a = null;
                preparedStatement2.f16503f = false;
            } else {
                preparedStatement2 = new PreparedStatement();
            }
            preparedStatement2.f16500b = str;
            preparedStatement2.f16501c = nativePrepareStatement;
            preparedStatement2.f16502d = nativeGetParameterCount;
            preparedStatement2.e = nativeIsReadOnly;
            if (!z5 && (a3 == 2 || a3 == 1)) {
                try {
                    preparedStatementCache.put(str, preparedStatement2);
                    preparedStatement2.f16503f = true;
                } catch (RuntimeException e) {
                    e = e;
                    preparedStatement = preparedStatement2;
                    if (preparedStatement == null || !preparedStatement.f16503f) {
                        nativeFinalizeStatement(this.f16485j, nativePrepareStatement);
                    }
                    throw e;
                }
            }
            preparedStatement2.f16504g = true;
            return preparedStatement2;
        } catch (RuntimeException e10) {
            e = e10;
        }
    }

    public final void b(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
            int i3 = this.f16487l + 1;
            this.f16487l = i3;
            if (i3 == 1) {
                nativeResetCancel(this.f16485j, true);
                cancellationSignal.setOnCancelListener(this);
            }
        }
    }

    public final void c(PreparedStatement preparedStatement, Object[] objArr) {
        int length = objArr != null ? objArr.length : 0;
        if (length != preparedStatement.f16502d) {
            throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.f16502d + " bind arguments but " + length + " were provided.");
        }
        if (length == 0) {
            return;
        }
        long j4 = preparedStatement.f16501c;
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = objArr[i3];
            char c9 = obj == null ? (char) 0 : obj instanceof byte[] ? (char) 4 : ((obj instanceof Float) || (obj instanceof Double)) ? (char) 2 : ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) ? (char) 1 : (char) 3;
            if (c9 == 0) {
                nativeBindNull(this.f16485j, j4, i3 + 1);
            } else if (c9 == 1) {
                nativeBindLong(this.f16485j, j4, i3 + 1, ((Number) obj).longValue());
            } else if (c9 == 2) {
                nativeBindDouble(this.f16485j, j4, i3 + 1, ((Number) obj).doubleValue());
            } else if (c9 == 4) {
                nativeBindBlob(this.f16485j, j4, i3 + 1, (byte[]) obj);
            } else if (obj instanceof Boolean) {
                nativeBindLong(this.f16485j, j4, i3 + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else {
                nativeBindString(this.f16485j, j4, i3 + 1, obj.toString());
            }
        }
    }

    public final void e(byte[] bArr) {
        int nativeReKey = nativeReKey(this.f16485j, bArr);
        Log.i("SQLiteConnection", "Database rekey operation returned:" + nativeReKey);
        if (nativeReKey != 0) {
            throw new SQLiteException(l0.j(nativeReKey, "Failed to rekey database, result code:"));
        }
    }

    public final void f(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            int i3 = this.f16487l - 1;
            this.f16487l = i3;
            if (i3 == 0) {
                cancellationSignal.setOnCancelListener(null);
                nativeResetCancel(this.f16485j, false);
            }
        }
    }

    public final void finalize() {
        try {
            SQLiteConnectionPool sQLiteConnectionPool = this.f16478b;
            if (sQLiteConnectionPool != null && this.f16485j != 0) {
                Log.w("SQLiteConnectionPool", "A SQLiteConnection object for database '" + sQLiteConnectionPool.f16509d.f16554b + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
                sQLiteConnectionPool.f16508c.set(true);
            }
            g(true);
            super.finalize();
        } catch (Throwable th2) {
            super.finalize();
            throw th2;
        }
    }

    public final void g(boolean z5) {
        Throwable th2;
        CloseGuard closeGuard = this.f16477a;
        if (z5 && (th2 = closeGuard.f16473a) != null) {
            Log.w("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", th2);
        }
        closeGuard.f16473a = null;
        if (this.f16485j != 0) {
            OperationLog operationLog = this.f16484i;
            int a3 = operationLog.a("close", null, null);
            try {
                this.f16482g.evictAll();
                nativeClose(this.f16485j);
                this.f16485j = 0L;
            } finally {
                operationLog.b(a3);
            }
        }
    }

    public final void h(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.f16484i;
        int a3 = operationLog.a("execute", str, objArr);
        try {
            try {
                PreparedStatement a10 = a(str);
                try {
                    x(a10);
                    c(a10, objArr);
                    b(cancellationSignal);
                    try {
                        nativeExecute(this.f16485j, a10.f16501c);
                    } finally {
                        f(cancellationSignal);
                    }
                } finally {
                    s(a10);
                }
            } finally {
                operationLog.b(a3);
            }
        } catch (RuntimeException e) {
            operationLog.d(e, a3);
            throw e;
        }
    }

    public final int i(String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.f16484i;
        int a3 = operationLog.a("executeForChangedRowCount", str, objArr);
        try {
            try {
                PreparedStatement a10 = a(str);
                try {
                    x(a10);
                    c(a10, objArr);
                    return nativeExecuteForChangedRowCount(this.f16485j, a10.f16501c);
                } finally {
                    s(a10);
                }
            } catch (RuntimeException e) {
                operationLog.d(e, a3);
                throw e;
            }
        } finally {
            operationLog.c(a3);
        }
    }

    public final int j(String str, Object[] objArr, CursorWindow cursorWindow, int i3, int i10, boolean z5, CancellationSignal cancellationSignal) {
        int a3;
        OperationLog operationLog = this.f16484i;
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        }
        cursorWindow.acquireReference();
        try {
            try {
                a3 = operationLog.a("executeForCursorWindow", str, objArr);
                try {
                    PreparedStatement a10 = a(str);
                    try {
                        x(a10);
                        c(a10, objArr);
                        b(cancellationSignal);
                        try {
                            long nativeExecuteForCursorWindow = nativeExecuteForCursorWindow(this.f16485j, a10.f16501c, cursorWindow, i3, i10, z5);
                            int i11 = (int) (nativeExecuteForCursorWindow >> 32);
                            int i12 = (int) nativeExecuteForCursorWindow;
                            cursorWindow.getNumRows();
                            cursorWindow.setStartPosition(i11);
                            f(cancellationSignal);
                            s(a10);
                            operationLog.c(a3);
                            return i12;
                        } catch (Throwable th2) {
                            f(cancellationSignal);
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        s(a10);
                        throw th3;
                    }
                } catch (RuntimeException e) {
                    operationLog.d(e, a3);
                    throw e;
                }
            } finally {
                cursorWindow.releaseReference();
            }
        } catch (Throwable th4) {
            operationLog.c(a3);
            throw th4;
        }
    }

    public final long k(String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.f16484i;
        int a3 = operationLog.a("executeForLastInsertedRowId", str, objArr);
        try {
            try {
                PreparedStatement a10 = a(str);
                try {
                    x(a10);
                    c(a10, objArr);
                    return nativeExecuteForLastInsertedRowId(this.f16485j, a10.f16501c);
                } finally {
                    s(a10);
                }
            } catch (RuntimeException e) {
                operationLog.d(e, a3);
                throw e;
            }
        } finally {
            operationLog.b(a3);
        }
    }

    public final long l(String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.f16484i;
        int a3 = operationLog.a("executeForLong", str, objArr);
        try {
            try {
                PreparedStatement a10 = a(str);
                try {
                    x(a10);
                    c(a10, objArr);
                    return nativeExecuteForLong(this.f16485j, a10.f16501c);
                } finally {
                    s(a10);
                }
            } catch (RuntimeException e) {
                operationLog.d(e, a3);
                throw e;
            }
        } finally {
            operationLog.b(a3);
        }
    }

    public final String m(String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.f16484i;
        int a3 = operationLog.a("executeForString", str, objArr);
        try {
            try {
                PreparedStatement a10 = a(str);
                try {
                    x(a10);
                    c(a10, objArr);
                    return nativeExecuteForString(this.f16485j, a10.f16501c);
                } finally {
                    s(a10);
                }
            } catch (RuntimeException e) {
                operationLog.d(e, a3);
                throw e;
            }
        } finally {
            operationLog.b(a3);
        }
    }

    public final void n(PreparedStatement preparedStatement) {
        nativeFinalizeStatement(this.f16485j, preparedStatement.f16501c);
        preparedStatement.f16500b = null;
        preparedStatement.f16499a = this.f16483h;
        this.f16483h = preparedStatement;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        nativeCancel(this.f16485j);
    }

    public final void p() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16479c;
        this.f16485j = nativeOpen(sQLiteDatabaseConfiguration.f16553a, sQLiteDatabaseConfiguration.f16555c, sQLiteDatabaseConfiguration.f16554b, SQLiteDebug.f16561a, SQLiteDebug.f16562b);
        SQLiteDatabaseHook sQLiteDatabaseHook = this.f16479c.f16559h;
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.a();
        }
        byte[] bArr = this.f16479c.f16558g;
        if (bArr != null && bArr.length > 0) {
            Log.i("SQLiteConnection", "Database keying operation returned:" + nativeKey(this.f16485j, bArr));
        }
        SQLiteDatabaseHook sQLiteDatabaseHook2 = this.f16479c.f16559h;
        if (sQLiteDatabaseHook2 != null) {
            sQLiteDatabaseHook2.b();
        }
        byte[] bArr2 = this.f16479c.f16558g;
        if (bArr2 != null && bArr2.length > 0) {
            l("SELECT COUNT(*) FROM sqlite_schema;", null);
        }
        if (!this.f16479c.f16553a.equalsIgnoreCase(":memory:") && !this.f16481f) {
            WeakHashMap weakHashMap = SQLiteDatabase.f16537j;
            if (!nativeHasCodec()) {
                synchronized (SQLiteGlobal.f16567a) {
                    try {
                        if (SQLiteGlobal.f16568b == 0) {
                            SQLiteGlobal.f16568b = new StatFs("/data").getBlockSize();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (l("PRAGMA page_size", null) != 4096) {
                    h("PRAGMA page_size=4096", null, null);
                }
            }
        }
        t();
        if (!this.f16479c.f16553a.equalsIgnoreCase(":memory:") && !this.f16481f) {
            if (l("PRAGMA journal_size_limit", null) != 10000) {
                l("PRAGMA journal_size_limit=10000", null);
            }
        }
        if (!this.f16479c.f16553a.equalsIgnoreCase(":memory:") && !this.f16481f) {
            long max = Math.max(1, 1000);
            if (l("PRAGMA wal_autocheckpoint", null) != max) {
                l("PRAGMA wal_autocheckpoint=" + max, null);
            }
        }
        w();
        if (!nativeHasCodec()) {
            v();
        }
        int size = this.f16479c.f16560i.size();
        for (int i3 = 0; i3 < size; i3++) {
            nativeRegisterCustomFunction(this.f16485j, (SQLiteCustomFunction) this.f16479c.f16560i.get(i3));
        }
    }

    public final void q(String str, SQLiteStatementInfo sQLiteStatementInfo) {
        OperationLog operationLog = this.f16484i;
        int a3 = operationLog.a("prepare", str, null);
        try {
            try {
                PreparedStatement a10 = a(str);
                try {
                    sQLiteStatementInfo.f16585a = a10.f16502d;
                    sQLiteStatementInfo.f16587c = a10.e;
                    int nativeGetColumnCount = nativeGetColumnCount(this.f16485j, a10.f16501c);
                    if (nativeGetColumnCount == 0) {
                        sQLiteStatementInfo.f16586b = f16475m;
                    } else {
                        sQLiteStatementInfo.f16586b = new String[nativeGetColumnCount];
                        for (int i3 = 0; i3 < nativeGetColumnCount; i3++) {
                            sQLiteStatementInfo.f16586b[i3] = nativeGetColumnName(this.f16485j, a10.f16501c, i3);
                        }
                    }
                    s(a10);
                } catch (Throwable th2) {
                    s(a10);
                    throw th2;
                }
            } catch (RuntimeException e) {
                operationLog.d(e, a3);
                throw e;
            }
        } finally {
            operationLog.b(a3);
        }
    }

    public final void r(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2;
        this.f16486k = false;
        int size = sQLiteDatabaseConfiguration.f16560i.size();
        int i3 = 0;
        while (true) {
            sQLiteDatabaseConfiguration2 = this.f16479c;
            if (i3 >= size) {
                break;
            }
            SQLiteCustomFunction sQLiteCustomFunction = (SQLiteCustomFunction) sQLiteDatabaseConfiguration.f16560i.get(i3);
            if (!sQLiteDatabaseConfiguration2.f16560i.contains(sQLiteCustomFunction)) {
                nativeRegisterCustomFunction(this.f16485j, sQLiteCustomFunction);
            }
            i3++;
        }
        boolean z5 = sQLiteDatabaseConfiguration.f16557f != sQLiteDatabaseConfiguration2.f16557f;
        boolean z6 = ((sQLiteDatabaseConfiguration.f16555c ^ sQLiteDatabaseConfiguration2.f16555c) & 536870912) != 0;
        boolean equals = sQLiteDatabaseConfiguration.e.equals(sQLiteDatabaseConfiguration2.e);
        sQLiteDatabaseConfiguration2.a(sQLiteDatabaseConfiguration);
        if (z5) {
            t();
        }
        if (z6) {
            w();
        }
        if (equals) {
            return;
        }
        v();
    }

    public final void s(PreparedStatement preparedStatement) {
        preparedStatement.f16504g = false;
        if (!preparedStatement.f16503f) {
            n(preparedStatement);
            return;
        }
        try {
            nativeResetStatementAndClearBindings(this.f16485j, preparedStatement.f16501c);
        } catch (SQLiteException unused) {
            this.f16482g.remove(preparedStatement.f16500b);
        }
    }

    public final void t() {
        if (this.f16481f) {
            return;
        }
        long j4 = this.f16479c.f16557f ? 1L : 0L;
        if (l("PRAGMA foreign_keys", null) != j4) {
            h(l0.l(j4, "PRAGMA foreign_keys="), null, null);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SQLiteConnection: ");
        sb2.append(this.f16479c.f16553a);
        sb2.append(" (");
        return a.e(sb2, this.f16480d, ")");
    }

    public final void u(String str) {
        String m10 = m("PRAGMA journal_mode", null);
        if (m10.equalsIgnoreCase(str)) {
            return;
        }
        try {
            if (m("PRAGMA journal_mode=".concat(str), null).equalsIgnoreCase(str)) {
                return;
            }
        } catch (SQLiteDatabaseLockedException unused) {
        }
        StringBuilder sb2 = new StringBuilder("Could not change the database journal mode of '");
        e.z(sb2, this.f16479c.f16554b, "' from '", m10, "' to '");
        sb2.append(str);
        sb2.append("' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        Log.w("SQLiteConnection", sb2.toString());
    }

    public final void v() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16479c;
        if ((sQLiteDatabaseConfiguration.f16555c & 16) != 0) {
            return;
        }
        String locale = sQLiteDatabaseConfiguration.e.toString();
        nativeRegisterLocalizedCollators(this.f16485j, locale);
        if (this.f16481f) {
            return;
        }
        try {
            h("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);
            String m10 = m("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null);
            if (m10 == null || !m10.equals(locale)) {
                h("BEGIN", null, null);
                try {
                    h("DELETE FROM android_metadata", null, null);
                    h("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{locale}, null);
                    h("REINDEX LOCALIZED", null, null);
                    h("COMMIT", null, null);
                } catch (Throwable th2) {
                    h("ROLLBACK", null, null);
                    throw th2;
                }
            }
        } catch (RuntimeException e) {
            throw new SQLiteException("Failed to change locale for db '" + sQLiteDatabaseConfiguration.f16554b + "' to '" + locale + "'.", e);
        }
    }

    public final void w() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16479c;
        if (sQLiteDatabaseConfiguration.f16553a.equalsIgnoreCase(":memory:") || this.f16481f) {
            return;
        }
        if ((sQLiteDatabaseConfiguration.f16555c & 536870912) != 0) {
            u("WAL");
            if (d(m("PRAGMA synchronous", null)).equalsIgnoreCase(d("normal"))) {
                return;
            }
            h("PRAGMA synchronous=".concat("normal"), null, null);
            return;
        }
        u("delete");
        if (d(m("PRAGMA synchronous", null)).equalsIgnoreCase(d("normal"))) {
            return;
        }
        h("PRAGMA synchronous=".concat("normal"), null, null);
    }

    public final void x(PreparedStatement preparedStatement) {
        if (this.f16486k && !preparedStatement.e) {
            throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        }
    }
}
