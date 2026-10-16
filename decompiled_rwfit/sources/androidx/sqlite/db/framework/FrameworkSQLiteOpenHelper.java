package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;
    private final SupportSQLiteOpenHelper.Callback callback;
    private final Context context;
    private final eh.b lazyDelegate;
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    public static final class Companion {
        public /* synthetic */ Companion(c cVar) {
            this();
        }

        private Companion() {
        }
    }

    public static final class DBRefHolder {

        /* renamed from: db, reason: collision with root package name */
        private FrameworkSQLiteDatabase f2824db;

        public DBRefHolder(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f2824db = frameworkSQLiteDatabase;
        }

        public final FrameworkSQLiteDatabase getDb() {
            return this.f2824db;
        }

        public final void setDb(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f2824db = frameworkSQLiteDatabase;
        }
    }

    public static final class OpenHelper extends SQLiteOpenHelper implements AutoCloseable {
        public static final Companion Companion = new Companion(null);
        private final boolean allowDataLossOnRecovery;
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Context context;
        private final DBRefHolder dbRef;
        private final g2.a lock;
        private boolean migrated;
        private boolean opened;

        public static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName, Throwable cause) {
                super(cause);
                e.f(callbackName, "callbackName");
                e.f(cause, "cause");
                this.callbackName = callbackName;
                this.cause = cause;
            }

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }
        }

        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        public static final class Companion {
            public /* synthetic */ Companion(c cVar) {
                this();
            }

            public final FrameworkSQLiteDatabase getWrappedDb(DBRefHolder refHolder, SQLiteDatabase sqLiteDatabase) {
                e.f(refHolder, "refHolder");
                e.f(sqLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase db2 = refHolder.getDb();
                if (db2 != null && db2.isDelegate(sqLiteDatabase)) {
                    return db2;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sqLiteDatabase);
                refHolder.setDb(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }

            private Companion() {
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CallbackName.values().length];
                try {
                    iArr[CallbackName.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallbackName.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CallbackName.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CallbackName.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CallbackName.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final DBRefHolder dbRef, final SupportSQLiteOpenHelper.Callback callback, boolean z5) {
            super(context, str, null, callback.version, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.b
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteOpenHelper.OpenHelper._init_$lambda$0(SupportSQLiteOpenHelper.Callback.this, dbRef, sQLiteDatabase);
                }
            });
            String str2;
            e.f(context, "context");
            e.f(dbRef, "dbRef");
            e.f(callback, "callback");
            this.context = context;
            this.dbRef = dbRef;
            this.callback = callback;
            this.allowDataLossOnRecovery = z5;
            if (str == null) {
                str2 = UUID.randomUUID().toString();
                e.e(str2, "randomUUID().toString()");
            } else {
                str2 = str;
            }
            this.lock = new g2.a(context.getCacheDir(), str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback callback, DBRefHolder dbRef, SQLiteDatabase dbObj) {
            e.f(callback, "$callback");
            e.f(dbRef, "$dbRef");
            Companion companion = Companion;
            e.e(dbObj, "dbObj");
            callback.onCorruption(companion.getWrappedDb(dbRef, dbObj));
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean z5) {
            if (z5) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                e.e(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = getReadableDatabase();
            e.e(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        private final SQLiteDatabase innerGetDatabase(boolean z5) {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z6 = this.opened;
            if (databaseName != null && !z6 && (parentFile = this.context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w(FrameworkSQLiteOpenHelper.TAG, "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return getWritableOrReadableDatabase(z5);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return getWritableOrReadableDatabase(z5);
                } catch (Throwable th2) {
                    super.close();
                    if (th2 instanceof CallbackException) {
                        CallbackException callbackException = th2;
                        Throwable cause = callbackException.getCause();
                        int i3 = WhenMappings.$EnumSwitchMapping$0[callbackException.getCallbackName().ordinal()];
                        if (i3 == 1) {
                            throw cause;
                        }
                        if (i3 == 2) {
                            throw cause;
                        }
                        if (i3 == 3) {
                            throw cause;
                        }
                        if (i3 == 4) {
                            throw cause;
                        }
                        if (!(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                    } else {
                        if (!(th2 instanceof SQLiteException)) {
                            throw th2;
                        }
                        if (databaseName == null || !this.allowDataLossOnRecovery) {
                            throw th2;
                        }
                    }
                    this.context.deleteDatabase(databaseName);
                    try {
                        return getWritableOrReadableDatabase(z5);
                    } catch (CallbackException e) {
                        throw e.getCause();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                g2.a aVar = this.lock;
                HashMap hashMap = g2.a.f13789d;
                aVar.getClass();
                aVar.a(false);
                super.close();
                this.dbRef.setDb(null);
                this.opened = false;
            } finally {
                this.lock.b();
            }
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        public final Context getContext() {
            return this.context;
        }

        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        public final SupportSQLiteDatabase getSupportDatabase(boolean z5) {
            SupportSQLiteDatabase wrappedDb;
            try {
                this.lock.a((this.opened || getDatabaseName() == null) ? false : true);
                this.migrated = false;
                SQLiteDatabase innerGetDatabase = innerGetDatabase(z5);
                if (this.migrated) {
                    close();
                    wrappedDb = getSupportDatabase(z5);
                } else {
                    wrappedDb = getWrappedDb(innerGetDatabase);
                }
                this.lock.b();
                return wrappedDb;
            } catch (Throwable th2) {
                this.lock.b();
                throw th2;
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sqLiteDatabase) {
            e.f(sqLiteDatabase, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, sqLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase db2) {
            e.f(db2, "db");
            if (!this.migrated && this.callback.version != db2.getVersion()) {
                db2.setMaxSqlCacheSize(1);
            }
            try {
                this.callback.onConfigure(getWrappedDb(db2));
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            e.f(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.onCreate(getWrappedDb(sqLiteDatabase));
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_CREATE, th2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase db2, int i3, int i10) {
            e.f(db2, "db");
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(db2), i3, i10);
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db2) {
            e.f(db2, "db");
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(db2));
                } catch (Throwable th2) {
                    throw new CallbackException(CallbackName.ON_OPEN, th2);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i3, int i10) {
            e.f(sqLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sqLiteDatabase), i3, i10);
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        this(context, str, callback, false, false, 24, null);
        e.f(context, "context");
        e.f(callback, "callback");
    }

    private final OpenHelper getDelegate() {
        return (OpenHelper) this.lazyDelegate.getValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.name;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z5) {
        if (this.lazyDelegate.isInitialized()) {
            SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(getDelegate(), z5);
        }
        this.writeAheadLoggingEnabled = z5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z5) {
        this(context, str, callback, z5, false, 16, null);
        e.f(context, "context");
        e.f(callback, "callback");
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z5, boolean z6) {
        e.f(context, "context");
        e.f(callback, "callback");
        this.context = context;
        this.name = str;
        this.callback = callback;
        this.useNoBackupDirectory = z5;
        this.allowDataLossOnRecovery = z6;
        this.lazyDelegate = kotlin.a.b(new oh.a() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$lazyDelegate$1
            {
                super(0);
            }

            @Override // oh.a
            public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
                String str2;
                Context context2;
                String str3;
                SupportSQLiteOpenHelper.Callback callback2;
                boolean z8;
                FrameworkSQLiteOpenHelper.OpenHelper openHelper;
                boolean z10;
                boolean z11;
                Context context3;
                String str4;
                Context context4;
                SupportSQLiteOpenHelper.Callback callback3;
                boolean z12;
                str2 = FrameworkSQLiteOpenHelper.this.name;
                if (str2 != null) {
                    z11 = FrameworkSQLiteOpenHelper.this.useNoBackupDirectory;
                    if (z11) {
                        context3 = FrameworkSQLiteOpenHelper.this.context;
                        File noBackupFilesDir = SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(context3);
                        str4 = FrameworkSQLiteOpenHelper.this.name;
                        File file = new File(noBackupFilesDir, str4);
                        context4 = FrameworkSQLiteOpenHelper.this.context;
                        String absolutePath = file.getAbsolutePath();
                        FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder = new FrameworkSQLiteOpenHelper.DBRefHolder(null);
                        callback3 = FrameworkSQLiteOpenHelper.this.callback;
                        z12 = FrameworkSQLiteOpenHelper.this.allowDataLossOnRecovery;
                        openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(context4, absolutePath, dBRefHolder, callback3, z12);
                        z10 = FrameworkSQLiteOpenHelper.this.writeAheadLoggingEnabled;
                        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, z10);
                        return openHelper;
                    }
                }
                context2 = FrameworkSQLiteOpenHelper.this.context;
                str3 = FrameworkSQLiteOpenHelper.this.name;
                FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder2 = new FrameworkSQLiteOpenHelper.DBRefHolder(null);
                callback2 = FrameworkSQLiteOpenHelper.this.callback;
                z8 = FrameworkSQLiteOpenHelper.this.allowDataLossOnRecovery;
                openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(context2, str3, dBRefHolder2, callback2, z8);
                z10 = FrameworkSQLiteOpenHelper.this.writeAheadLoggingEnabled;
                SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, z10);
                return openHelper;
            }
        });
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z5, boolean z6, int i3, c cVar) {
        this(context, str, callback, (i3 & 8) != 0 ? false : z5, (i3 & 16) != 0 ? false : z6);
    }
}
