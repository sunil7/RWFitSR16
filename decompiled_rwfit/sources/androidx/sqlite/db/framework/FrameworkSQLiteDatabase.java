package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import oh.r;

/* loaded from: classes.dex */
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private final SQLiteDatabase delegate;
    public static final Companion Companion = new Companion(null);
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        public final void execPerConnectionSQL(SQLiteDatabase sQLiteDatabase, String sql, Object[] objArr) {
            e.f(sQLiteDatabase, "sQLiteDatabase");
            e.f(sql, "sql");
            sQLiteDatabase.execPerConnectionSQL(sql, objArr);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(c cVar) {
            this();
        }

        private Companion() {
        }
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase delegate) {
        e.f(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor query$lambda$0(r tmp0, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        e.f(tmp0, "$tmp0");
        return (Cursor) tmp0.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor query$lambda$1(SupportSQLiteQuery query, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        e.f(query, "$query");
        e.c(sQLiteQuery);
        query.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        e.f(transactionListener, "transactionListener");
        this.delegate.beginTransactionWithListener(transactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener transactionListener) {
        e.f(transactionListener, "transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(transactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String sql) {
        e.f(sql, "sql");
        SQLiteStatement compileStatement = this.delegate.compileStatement(sql);
        e.e(compileStatement, "delegate.compileStatement(sql)");
        return new FrameworkSQLiteStatement(compileStatement);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String table, String str, Object[] objArr) {
        e.f(table, "table");
        StringBuilder sb2 = new StringBuilder("DELETE FROM ");
        sb2.append(table);
        if (str != null && str.length() != 0) {
            sb2.append(" WHERE ");
            sb2.append(str);
        }
        String sb3 = sb2.toString();
        e.e(sb3, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement compileStatement = compileStatement(sb3);
        SimpleSQLiteQuery.Companion.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.delegate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String sql, Object[] objArr) {
        e.f(sql, "sql");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 30) {
            throw new UnsupportedOperationException(l0.j(i3, "execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: "));
        }
        Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, sql, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String sql) throws SQLException {
        e.f(sql, "sql");
        this.delegate.execSQL(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String table, int i3, ContentValues values) throws SQLException {
        e.f(table, "table");
        e.f(values, "values");
        return this.delegate.insertWithOnConflict(table, null, values, i3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public final boolean isDelegate(SQLiteDatabase sqLiteDatabase) {
        e.f(sqLiteDatabase, "sqLiteDatabase");
        return e.a(this.delegate, sqLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.delegate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i3) {
        return this.delegate.needUpgrade(i3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String query) {
        e.f(query, "query");
        return query(new SimpleSQLiteQuery(query));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z5) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.delegate, z5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        e.f(locale, "locale");
        this.delegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i3) {
        this.delegate.setMaxSqlCacheSize(i3);
    }

    /* renamed from: setMaximumSize, reason: collision with other method in class */
    public void m1setMaximumSize(long j4) {
        this.delegate.setMaximumSize(j4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j4) {
        this.delegate.setPageSize(j4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i3) {
        this.delegate.setVersion(i3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String table, int i3, ContentValues values, String str, Object[] objArr) {
        e.f(table, "table");
        e.f(values, "values");
        if (values.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        int size = values.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb2 = new StringBuilder("UPDATE ");
        sb2.append(CONFLICT_VALUES[i3]);
        sb2.append(table);
        sb2.append(" SET ");
        int i10 = 0;
        for (String str2 : values.keySet()) {
            sb2.append(i10 > 0 ? Const.STR_MART_COMMA : "");
            sb2.append(str2);
            objArr2[i10] = values.get(str2);
            sb2.append("=?");
            i10++;
        }
        if (objArr != null) {
            for (int i11 = size; i11 < length; i11++) {
                objArr2[i11] = objArr[i11 - size];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append(" WHERE ");
            sb2.append(str);
        }
        String sb3 = sb2.toString();
        e.e(sb3, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement compileStatement = compileStatement(sb3);
        SimpleSQLiteQuery.Companion.bind(compileStatement, objArr2);
        return compileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String sql, Object[] bindArgs) throws SQLException {
        e.f(sql, "sql");
        e.f(bindArgs, "bindArgs");
        this.delegate.execSQL(sql, bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String query, Object[] bindArgs) {
        e.f(query, "query");
        e.f(bindArgs, "bindArgs");
        return query(new SimpleSQLiteQuery(query, bindArgs));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j4) {
        this.delegate.setMaximumSize(j4);
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j4) {
        return this.delegate.yieldIfContendedSafely(j4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery query) {
        e.f(query, "query");
        Cursor rawQueryWithFactory = this.delegate.rawQueryWithFactory(new a(new r() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$query$cursorFactory$1
            {
                super(4);
            }

            @Override // oh.r
            public final SQLiteCursor invoke(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                SupportSQLiteQuery supportSQLiteQuery = SupportSQLiteQuery.this;
                e.c(sQLiteQuery);
                supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, 1), query.getSql(), EMPTY_STRING_ARRAY, null);
        e.e(rawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return rawQueryWithFactory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
        e.f(query, "query");
        SQLiteDatabase sQLiteDatabase = this.delegate;
        String sql = query.getSql();
        String[] strArr = EMPTY_STRING_ARRAY;
        e.c(cancellationSignal);
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(sQLiteDatabase, sql, strArr, null, cancellationSignal, new a(query, 0));
    }
}
