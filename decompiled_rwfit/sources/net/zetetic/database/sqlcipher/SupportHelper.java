package net.zetetic.database.sqlcipher;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes2.dex */
public class SupportHelper implements SupportSQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteOpenHelper f16588a;

    public SupportHelper(SupportSQLiteOpenHelper.Configuration configuration, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z5) {
        this(configuration, bArr, sQLiteDatabaseHook, z5, 0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f16588a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final String getDatabaseName() {
        return this.f16588a.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getReadableDatabase() {
        return this.f16588a.getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getWritableDatabase() {
        return this.f16588a.getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z5) {
        this.f16588a.setWriteAheadLoggingEnabled(z5);
    }

    public SupportHelper(final SupportSQLiteOpenHelper.Configuration configuration, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z5, int i3) {
        this.f16588a = new SQLiteOpenHelper(configuration.context, configuration.name, bArr, configuration.callback.version, i3, sQLiteDatabaseHook, z5) { // from class: net.zetetic.database.sqlcipher.SupportHelper.1
            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onConfigure(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void onCreate(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onCreate(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
                configuration.callback.onDowngrade(sQLiteDatabase, i10, i11);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void onOpen(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onOpen(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
                configuration.callback.onUpgrade(sQLiteDatabase, i10, i11);
            }
        };
    }
}
