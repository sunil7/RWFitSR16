package net.zetetic.database.sqlcipher;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.os.Looper;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.DatabaseUtils;
import net.zetetic.database.DefaultDatabaseErrorHandler;
import r5.a;

/* loaded from: classes2.dex */
public final class SQLiteDatabase extends SQLiteClosable implements SupportSQLiteDatabase {

    /* renamed from: j, reason: collision with root package name */
    public static final WeakHashMap f16537j = new WeakHashMap();

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f16538k = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c, reason: collision with root package name */
    public final CursorFactory f16540c;

    /* renamed from: d, reason: collision with root package name */
    public final DatabaseErrorHandler f16541d;

    /* renamed from: g, reason: collision with root package name */
    public final SQLiteDatabaseConfiguration f16543g;

    /* renamed from: h, reason: collision with root package name */
    public SQLiteConnectionPool f16544h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16545i;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadLocal f16539b = new ThreadLocal<SQLiteSession>() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.1
        @Override // java.lang.ThreadLocal
        public final SQLiteSession initialValue() {
            SQLiteConnectionPool sQLiteConnectionPool;
            SQLiteDatabase sQLiteDatabase = SQLiteDatabase.this;
            synchronized (sQLiteDatabase.e) {
                sQLiteDatabase.W();
                sQLiteConnectionPool = sQLiteDatabase.f16544h;
            }
            return new SQLiteSession(sQLiteConnectionPool);
        }
    };
    public final Object e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final CloseGuard f16542f = new CloseGuard();

    public interface CursorFactory {
        Cursor a();
    }

    public interface CustomFunction {
        void a();
    }

    public SQLiteDatabase(int i3, String str, DatabaseErrorHandler databaseErrorHandler, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, byte[] bArr) {
        this.f16540c = cursorFactory;
        this.f16541d = databaseErrorHandler == null ? new DefaultDatabaseErrorHandler() : databaseErrorHandler;
        this.f16543g = new SQLiteDatabaseConfiguration(str, i3, bArr, sQLiteDatabaseHook);
    }

    public static boolean h(File file) {
        boolean delete = file.delete() | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            final String str = file.getName() + "-mj";
            File[] listFiles = parentFile.listFiles(new FileFilter() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.4
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return file2.getName().startsWith(str);
                }
            });
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    delete |= file2.delete();
                }
            }
        }
        return delete;
    }

    public static int k(boolean z5) {
        int i3 = z5 ? 1 : 2;
        Looper myLooper = Looper.myLooper();
        return (myLooper == null || myLooper != Looper.getMainLooper()) ? i3 : i3 | 4;
    }

    public static SQLiteDatabase y(int i3, String str, DatabaseErrorHandler databaseErrorHandler, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(i3, str, databaseErrorHandler, cursorFactory, sQLiteDatabaseHook, bArr);
        try {
            try {
                sQLiteDatabase.A();
                return sQLiteDatabase;
            } catch (SQLiteDatabaseCorruptException unused) {
                synchronized (sQLiteDatabase.e) {
                    EventLog.writeEvent(75004, sQLiteDatabase.f16543g.f16554b);
                    sQLiteDatabase.f16541d.a(sQLiteDatabase);
                    sQLiteDatabase.A();
                    return sQLiteDatabase;
                }
            }
        } catch (SQLiteException e) {
            StringBuilder sb2 = new StringBuilder("Failed to open database '");
            synchronized (sQLiteDatabase.e) {
                sb2.append(sQLiteDatabase.f16543g.f16554b);
                sb2.append("'.");
                Log.e("SQLiteDatabase", sb2.toString(), e);
                sQLiteDatabase.e();
                throw e;
            }
        }
    }

    public final void A() {
        synchronized (this.e) {
            SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16543g;
            if (sQLiteDatabaseConfiguration == null) {
                throw new IllegalArgumentException("configuration must not be null.");
            }
            SQLiteConnectionPool sQLiteConnectionPool = new SQLiteConnectionPool(sQLiteDatabaseConfiguration);
            sQLiteConnectionPool.f16515k = sQLiteConnectionPool.i(sQLiteConnectionPool.f16509d, true);
            sQLiteConnectionPool.f16510f = true;
            sQLiteConnectionPool.f16506a.a();
            this.f16544h = sQLiteConnectionPool;
            this.f16542f.a();
        }
        WeakHashMap weakHashMap = f16537j;
        synchronized (weakHashMap) {
            weakHashMap.put(this, null);
        }
    }

    public final Cursor F(String str, Object... objArr) {
        b();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, null, null);
            CursorFactory cursorFactory = this.f16540c;
            SQLiteQuery sQLiteQuery = new SQLiteQuery(sQLiteDirectCursorDriver.f16563a, sQLiteDirectCursorDriver.f16565c, sQLiteDirectCursorDriver.f16566d);
            if (objArr != null) {
                try {
                    for (int length = objArr.length; length != 0; length--) {
                        sQLiteQuery.f(length, objArr[length - 1]);
                    }
                } catch (RuntimeException e) {
                    sQLiteQuery.e();
                    throw e;
                }
            }
            return cursorFactory == null ? new SQLiteCursor(sQLiteDirectCursorDriver, sQLiteDirectCursorDriver.f16564b, sQLiteQuery) : cursorFactory.a();
        } finally {
            e();
        }
    }

    public final Cursor I(String str, String[] strArr) {
        b();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, null, null);
            CursorFactory cursorFactory = this.f16540c;
            SQLiteQuery sQLiteQuery = new SQLiteQuery(sQLiteDirectCursorDriver.f16563a, sQLiteDirectCursorDriver.f16565c, sQLiteDirectCursorDriver.f16566d);
            if (strArr != null) {
                try {
                    for (int length = strArr.length; length != 0; length--) {
                        sQLiteQuery.bindString(length, strArr[length - 1]);
                    }
                } catch (RuntimeException e) {
                    sQLiteQuery.e();
                    throw e;
                }
            }
            return cursorFactory == null ? new SQLiteCursor(sQLiteDirectCursorDriver, sQLiteDirectCursorDriver.f16564b, sQLiteQuery) : cursorFactory.a();
        } finally {
            e();
        }
    }

    public final void O() {
        synchronized (this.e) {
            try {
                W();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16543g;
                int i3 = sQLiteDatabaseConfiguration.f16555c;
                boolean z5 = true;
                if ((i3 & 1) != 1) {
                    z5 = false;
                }
                if (z5) {
                    sQLiteDatabaseConfiguration.f16555c = i3 & (-2);
                    try {
                        this.f16544h.j(sQLiteDatabaseConfiguration);
                    } catch (RuntimeException e) {
                        this.f16543g.f16555c = i3;
                        throw e;
                    }
                }
            } finally {
            }
        }
    }

    public final void W() {
        if (this.f16544h == null) {
            throw new IllegalStateException(a.f(new StringBuilder("The database '"), this.f16543g.f16554b, "' is not open."));
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransaction() {
        f(null, true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionNonExclusive() {
        f(null, false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionWithListener(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        f(new SQLiteTransactionListener() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.2
            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void a() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void b() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void c() {
                sQLiteTransactionListener.onRollback();
            }
        }, true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionWithListenerNonExclusive(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        f(new SQLiteTransactionListener() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.3
            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void a() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void b() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void c() {
                sQLiteTransactionListener.onRollback();
            }
        }, false);
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    public final void c() {
        i(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int delete(String str, String str2, Object[] objArr) {
        String[] strArr = new String[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            strArr[i3] = objArr[i3].toString();
        }
        b();
        try {
            StringBuilder sb2 = new StringBuilder("DELETE FROM ");
            sb2.append(str);
            sb2.append(TextUtils.isEmpty(str2) ? "" : " WHERE " + str2);
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb2.toString(), strArr, null);
            try {
                int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
                e();
                return executeUpdateDelete;
            } finally {
                sQLiteStatement.e();
            }
        } catch (Throwable th2) {
            e();
            throw th2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void disableWriteAheadLogging() {
        synchronized (this.e) {
            try {
                W();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16543g;
                int i3 = sQLiteDatabaseConfiguration.f16555c;
                if ((i3 & 536870912) == 0) {
                    return;
                }
                sQLiteDatabaseConfiguration.f16555c = i3 & (-536870913);
                try {
                    this.f16544h.j(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e) {
                    SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.f16543g;
                    sQLiteDatabaseConfiguration2.f16555c = 536870912 | sQLiteDatabaseConfiguration2.f16555c;
                    throw e;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean enableWriteAheadLogging() {
        synchronized (this.e) {
            try {
                W();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16543g;
                int i3 = sQLiteDatabaseConfiguration.f16555c;
                if ((i3 & 536870912) != 0) {
                    return true;
                }
                if ((i3 & 1) == 1) {
                    return false;
                }
                if (sQLiteDatabaseConfiguration.f16553a.equalsIgnoreCase(":memory:")) {
                    Log.i("SQLiteDatabase", "can't enable WAL for memory databases.");
                    return false;
                }
                if (this.f16545i) {
                    if (Log.isLoggable("SQLiteDatabase", 3)) {
                        Log.d("SQLiteDatabase", "this database: " + this.f16543g.f16554b + " has attached databases. can't  enable WAL.");
                    }
                    return false;
                }
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.f16543g;
                sQLiteDatabaseConfiguration2.f16555c |= 536870912;
                try {
                    this.f16544h.j(sQLiteDatabaseConfiguration2);
                    return true;
                } catch (RuntimeException e) {
                    this.f16543g.f16555c &= -536870913;
                    throw e;
                }
            } finally {
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void endTransaction() {
        b();
        try {
            SQLiteSession l3 = l();
            if (l3.f16580f == null) {
                throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
            }
            l3.c(null, false);
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void execSQL(String str) {
        j(str, null);
    }

    public final void f(SQLiteTransactionListener sQLiteTransactionListener, boolean z5) {
        b();
        try {
            SQLiteSession l3 = l();
            int i3 = z5 ? 2 : 1;
            int k10 = k(false);
            l3.l();
            l3.b(i3, sQLiteTransactionListener, k10, null);
        } finally {
            e();
        }
    }

    public final void finalize() {
        try {
            i(true);
        } finally {
            super.finalize();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final SQLiteStatement compileStatement(String str) {
        b();
        try {
            return new SQLiteStatement(this, str, null, null);
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final List getAttachedDbs() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.e) {
            try {
                Cursor cursor = null;
                if (this.f16544h == null) {
                    return null;
                }
                if (!this.f16545i) {
                    arrayList.add(new Pair("main", this.f16543g.f16553a));
                    return arrayList;
                }
                b();
                try {
                    try {
                        cursor = I("pragma database_list;", null);
                        while (cursor.moveToNext()) {
                            arrayList.add(new Pair(cursor.getString(1), cursor.getString(2)));
                        }
                        cursor.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th2;
                    }
                } finally {
                    e();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long getMaximumSize() {
        return DatabaseUtils.b(this, "PRAGMA page_size;") * DatabaseUtils.b(this, "PRAGMA max_page_count;");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long getPageSize() {
        return DatabaseUtils.b(this, "PRAGMA page_size;");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String getPath() {
        String str;
        synchronized (this.e) {
            str = this.f16543g.f16553a;
        }
        return str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int getVersion() {
        return Long.valueOf(DatabaseUtils.b(this, "PRAGMA user_version;")).intValue();
    }

    public final void i(boolean z5) {
        SQLiteConnectionPool sQLiteConnectionPool;
        Throwable th2;
        synchronized (this.e) {
            try {
                CloseGuard closeGuard = this.f16542f;
                if (closeGuard != null) {
                    if (z5 && (th2 = closeGuard.f16473a) != null) {
                        Log.w("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", th2);
                    }
                    this.f16542f.f16473a = null;
                }
                sQLiteConnectionPool = this.f16544h;
                this.f16544h = null;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (z5) {
            return;
        }
        WeakHashMap weakHashMap = f16537j;
        synchronized (weakHashMap) {
            weakHashMap.remove(this);
        }
        if (sQLiteConnectionPool != null) {
            sQLiteConnectionPool.e(false);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean inTransaction() {
        b();
        try {
            return l().f16580f != null;
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long insert(String str, int i3, ContentValues contentValues) {
        Object[] objArr;
        b();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("INSERT");
            sb2.append(f16538k[i3]);
            sb2.append(" INTO ");
            sb2.append(str);
            sb2.append('(');
            int i10 = 0;
            int size = (contentValues == null || contentValues.size() <= 0) ? 0 : contentValues.size();
            if (size > 0) {
                objArr = new Object[size];
                int i11 = 0;
                for (String str2 : contentValues.keySet()) {
                    sb2.append(i11 > 0 ? Const.STR_MART_COMMA : "");
                    sb2.append(str2);
                    objArr[i11] = contentValues.get(str2);
                    i11++;
                }
                sb2.append(')');
                sb2.append(" VALUES (");
                while (i10 < size) {
                    sb2.append(i10 > 0 ? ",?" : "?");
                    i10++;
                }
            } else {
                sb2.append("null) VALUES (NULL");
                objArr = null;
            }
            sb2.append(')');
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb2.toString(), objArr, null);
            try {
                long executeInsert = sQLiteStatement.executeInsert();
                e();
                return executeInsert;
            } finally {
                sQLiteStatement.e();
            }
        } catch (Throwable th2) {
            e();
            throw th2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isDatabaseIntegrityOk() {
        List list;
        List attachedDbs;
        b();
        try {
            try {
                attachedDbs = getAttachedDbs();
            } catch (SQLiteException unused) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("main", getPath()));
                list = arrayList;
            }
            if (attachedDbs == null) {
                throw new IllegalStateException("databaselist for: " + getPath() + " couldn't be retrieved. probably because the database is closed");
            }
            list = attachedDbs;
            for (int i3 = 0; i3 < list.size(); i3++) {
                Pair pair = (Pair) list.get(i3);
                SQLiteStatement sQLiteStatement = null;
                try {
                    sQLiteStatement = compileStatement("PRAGMA " + ((String) pair.first) + ".integrity_check(1);");
                    String simpleQueryForString = sQLiteStatement.simpleQueryForString();
                    if (!simpleQueryForString.equalsIgnoreCase("ok")) {
                        Log.e("SQLiteDatabase", "PRAGMA integrity_check on " + ((String) pair.second) + " returned: " + simpleQueryForString);
                        sQLiteStatement.e();
                        return false;
                    }
                    sQLiteStatement.e();
                } catch (Throwable th2) {
                    if (sQLiteStatement != null) {
                        sQLiteStatement.e();
                    }
                    throw th2;
                }
            }
            e();
            return true;
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isDbLockedByCurrentThread() {
        b();
        try {
            return l().f16577b != null;
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isOpen() {
        boolean z5;
        synchronized (this.e) {
            z5 = this.f16544h != null;
        }
        return z5;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isReadOnly() {
        boolean z5;
        synchronized (this.e) {
            z5 = true;
            if ((this.f16543g.f16555c & 1) != 1) {
                z5 = false;
            }
        }
        return z5;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isWriteAheadLoggingEnabled() {
        boolean z5;
        synchronized (this.e) {
            W();
            z5 = (this.f16543g.f16555c & 536870912) != 0;
        }
        return z5;
    }

    public final void j(String str, Object[] objArr) {
        boolean z5;
        b();
        try {
            if (DatabaseUtils.a(str) == 3) {
                synchronized (this.e) {
                    try {
                        if (this.f16545i) {
                            z5 = false;
                        } else {
                            z5 = true;
                            this.f16545i = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (z5) {
                    disableWriteAheadLogging();
                }
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, str, objArr, null);
            try {
                sQLiteStatement.executeUpdateDelete();
            } finally {
                sQLiteStatement.e();
            }
        } finally {
            e();
        }
    }

    public final SQLiteSession l() {
        return (SQLiteSession) this.f16539b.get();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean needUpgrade(int i3) {
        return i3 > getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(String str) {
        return F(str, new Object[0]);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setForeignKeyConstraintsEnabled(boolean z5) {
        synchronized (this.e) {
            try {
                W();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16543g;
                if (sQLiteDatabaseConfiguration.f16557f == z5) {
                    return;
                }
                sQLiteDatabaseConfiguration.f16557f = z5;
                try {
                    this.f16544h.j(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e) {
                    this.f16543g.f16557f = !z5;
                    throw e;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setLocale(Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("locale must not be null.");
        }
        synchronized (this.e) {
            try {
                W();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16543g;
                Locale locale2 = sQLiteDatabaseConfiguration.e;
                sQLiteDatabaseConfiguration.e = locale;
                try {
                    this.f16544h.j(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e) {
                    this.f16543g.e = locale2;
                    throw e;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setMaxSqlCacheSize(int i3) {
        if (i3 > 100 || i3 < 0) {
            throw new IllegalStateException("expected value between 0 and 100");
        }
        synchronized (this.e) {
            try {
                W();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16543g;
                int i10 = sQLiteDatabaseConfiguration.f16556d;
                sQLiteDatabaseConfiguration.f16556d = i3;
                try {
                    this.f16544h.j(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e) {
                    this.f16543g.f16556d = i10;
                    throw e;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long setMaximumSize(long j4) {
        long b3 = DatabaseUtils.b(this, "PRAGMA page_size;");
        long j10 = j4 / b3;
        if (j4 % b3 != 0) {
            j10++;
        }
        return DatabaseUtils.b(this, "PRAGMA max_page_count = " + j10) * b3;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setPageSize(long j4) {
        j("PRAGMA page_size = " + j4, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setTransactionSuccessful() {
        b();
        try {
            SQLiteSession l3 = l();
            if (l3.f16580f == null) {
                throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
            }
            l3.l();
            l3.f16580f.f16584d = true;
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setVersion(int i3) {
        j("PRAGMA user_version = " + i3, null);
    }

    public final String toString() {
        return "SQLiteDatabase: " + getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int update(String str, int i3, ContentValues contentValues, String str2, Object[] objArr) {
        int length = objArr.length;
        String[] strArr = new String[length];
        int i10 = 0;
        for (int i11 = 0; i11 < objArr.length; i11++) {
            strArr[i11] = objArr[i11].toString();
        }
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        b();
        try {
            StringBuilder sb2 = new StringBuilder(120);
            sb2.append("UPDATE ");
            sb2.append(f16538k[i3]);
            sb2.append(str);
            sb2.append(" SET ");
            int size = contentValues.size();
            int i12 = length + size;
            Object[] objArr2 = new Object[i12];
            for (String str3 : contentValues.keySet()) {
                sb2.append(i10 > 0 ? Const.STR_MART_COMMA : "");
                sb2.append(str3);
                objArr2[i10] = contentValues.get(str3);
                sb2.append("=?");
                i10++;
            }
            for (int i13 = size; i13 < i12; i13++) {
                objArr2[i13] = strArr[i13 - size];
            }
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(" WHERE ");
                sb2.append(str2);
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb2.toString(), objArr2, null);
            try {
                int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
                e();
                return executeUpdateDelete;
            } finally {
                sQLiteStatement.e();
            }
        } catch (Throwable th2) {
            e();
            throw th2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean yieldIfContendedSafely() {
        b();
        try {
            return l().m(-1L);
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void execSQL(String str, Object[] objArr) {
        if (objArr == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        }
        j(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(String str, Object[] objArr) {
        return F(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (CancellationSignal) null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        b();
        try {
            String sql = supportSQLiteQuery.getSql();
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, sql, "", cancellationSignal);
            SQLiteQuery sQLiteQuery = new SQLiteQuery(this, sql, cancellationSignal);
            supportSQLiteQuery.bindTo(sQLiteQuery);
            return new SQLiteCursor(sQLiteDirectCursorDriver, "", sQLiteQuery);
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean yieldIfContendedSafely(long j4) {
        b();
        try {
            return l().m(j4);
        } finally {
            e();
        }
    }
}
