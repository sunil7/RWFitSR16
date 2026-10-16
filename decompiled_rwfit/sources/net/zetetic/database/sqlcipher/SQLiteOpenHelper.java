package net.zetetic.database.sqlcipher;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.File;
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes2.dex */
public abstract class SQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private static final boolean DEBUG_STRICT_READONLY = false;
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final SQLiteDatabaseHook mDatabaseHook;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private boolean mIsInitializing;
    private final int mMinimumSupportedVersion;
    private final String mName;
    private final int mNewVersion;
    private byte[] mPassword;

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        this(context, str, cursorFactory, i3, null);
    }

    public final SQLiteDatabase b(boolean z5) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            if (!sQLiteDatabase.isOpen()) {
                this.mDatabase = null;
            } else if (!z5 || !this.mDatabase.isReadOnly()) {
                return this.mDatabase;
            }
        }
        if (this.mIsInitializing) {
            throw new IllegalStateException("getDatabase called recursively");
        }
        SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
        try {
            this.mIsInitializing = true;
            if (sQLiteDatabase2 == null) {
                String str = this.mName;
                if (str == null) {
                    sQLiteDatabase2 = SQLiteDatabase.y(AMapEngineUtils.MAX_P20_WIDTH, ":memory:", null, null, null, new byte[0]);
                } else {
                    try {
                        if (!str.startsWith("file:")) {
                            str = this.mContext.getDatabasePath(str).getPath();
                        }
                        String str2 = str;
                        File file = new File(new File(str2).getParent());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        sQLiteDatabase2 = SQLiteDatabase.y(this.mEnableWriteAheadLogging ? 805306368 : AMapEngineUtils.MAX_P20_WIDTH, str2, this.mErrorHandler, this.mFactory, this.mDatabaseHook, this.mPassword);
                    } catch (SQLiteException e) {
                        if (z5) {
                            throw e;
                        }
                        Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", e);
                        sQLiteDatabase2 = SQLiteDatabase.y(1, this.mContext.getDatabasePath(this.mName).getPath(), this.mErrorHandler, this.mFactory, this.mDatabaseHook, this.mPassword);
                    }
                }
            } else if (z5 && sQLiteDatabase2.isReadOnly()) {
                sQLiteDatabase2.O();
            }
            onConfigure(sQLiteDatabase2);
            int version = sQLiteDatabase2.getVersion();
            if (version != this.mNewVersion) {
                if (sQLiteDatabase2.isReadOnly()) {
                    throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabase2.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
                }
                if (version > 0 && version < this.mMinimumSupportedVersion) {
                    File file2 = new File(sQLiteDatabase2.getPath());
                    onBeforeDelete(sQLiteDatabase2);
                    sQLiteDatabase2.e();
                    if (!SQLiteDatabase.h(file2)) {
                        throw new IllegalStateException("Unable to delete obsolete database " + this.mName + " with version " + version);
                    }
                    this.mIsInitializing = false;
                    SQLiteDatabase b3 = b(z5);
                    this.mIsInitializing = false;
                    if (sQLiteDatabase2 != this.mDatabase) {
                        sQLiteDatabase2.e();
                    }
                    return b3;
                }
                sQLiteDatabase2.beginTransaction();
                try {
                    if (version == 0) {
                        onCreate(sQLiteDatabase2);
                    } else {
                        int i3 = this.mNewVersion;
                        if (version > i3) {
                            onDowngrade(sQLiteDatabase2, version, i3);
                        } else {
                            onUpgrade(sQLiteDatabase2, version, i3);
                        }
                    }
                    sQLiteDatabase2.setVersion(this.mNewVersion);
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                } catch (Throwable th2) {
                    sQLiteDatabase2.endTransaction();
                    throw th2;
                }
            }
            onOpen(sQLiteDatabase2);
            if (sQLiteDatabase2.isReadOnly()) {
                Log.w(TAG, "Opened " + this.mName + " in read-only mode");
            }
            this.mDatabase = sQLiteDatabase2;
            this.mIsInitializing = false;
            return sQLiteDatabase2;
        } finally {
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.mDatabase.e();
            this.mDatabase = null;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mName;
    }

    public void onBeforeDelete(SQLiteDatabase sQLiteDatabase) {
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i10) {
        throw new SQLiteException(l0.i(i3, i10, "Can't downgrade database from version ", " to "));
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i10);

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z5) {
        synchronized (this) {
            try {
                if (this.mEnableWriteAheadLogging != z5) {
                    SQLiteDatabase sQLiteDatabase = this.mDatabase;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                        if (z5) {
                            this.mDatabase.enableWriteAheadLogging();
                        } else {
                            this.mDatabase.disableWriteAheadLogging();
                        }
                    }
                    this.mEnableWriteAheadLogging = z5;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, cursorFactory, i3, 0, databaseErrorHandler);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase b3;
        synchronized (this) {
            b3 = b(false);
        }
        return b3;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase b3;
        synchronized (this) {
            b3 = b(true);
        }
        return b3;
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3, int i10, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, new byte[0], cursorFactory, i3, i10, databaseErrorHandler, (SQLiteDatabaseHook) null, false);
    }

    public SQLiteOpenHelper(Context context, String str, byte[] bArr, SQLiteDatabase.CursorFactory cursorFactory, int i3, int i10, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z5) {
        if (i3 >= 1) {
            this.mContext = context;
            this.mName = str;
            this.mPassword = bArr;
            this.mFactory = cursorFactory;
            this.mNewVersion = i3;
            this.mErrorHandler = databaseErrorHandler;
            this.mDatabaseHook = sQLiteDatabaseHook;
            this.mEnableWriteAheadLogging = z5;
            this.mMinimumSupportedVersion = Math.max(0, i10);
            return;
        }
        throw new IllegalArgumentException(l0.j(i3, "Version must be >= 1, was "));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SQLiteOpenHelper(android.content.Context r12, java.lang.String r13, java.lang.String r14, net.zetetic.database.sqlcipher.SQLiteDatabase.CursorFactory r15, int r16, int r17, net.zetetic.database.DatabaseErrorHandler r18, net.zetetic.database.sqlcipher.SQLiteDatabaseHook r19, boolean r20) {
        /*
            r11 = this;
            if (r14 == 0) goto L30
            int r0 = r14.length()
            if (r0 != 0) goto L9
            goto L30
        L9:
            java.nio.CharBuffer r14 = java.nio.CharBuffer.wrap(r14)
            java.lang.String r0 = "UTF-8"
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
            java.nio.ByteBuffer r14 = r0.encode(r14)
            int r0 = r14.limit()
            byte[] r0 = new byte[r0]
            r14.get(r0)
        L20:
            r1 = r11
            r2 = r12
            r3 = r13
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r4 = r0
            goto L34
        L30:
            r14 = 0
            byte[] r0 = new byte[r14]
            goto L20
        L34:
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zetetic.database.sqlcipher.SQLiteOpenHelper.<init>(android.content.Context, java.lang.String, java.lang.String, net.zetetic.database.sqlcipher.SQLiteDatabase$CursorFactory, int, int, net.zetetic.database.DatabaseErrorHandler, net.zetetic.database.sqlcipher.SQLiteDatabaseHook, boolean):void");
    }
}
