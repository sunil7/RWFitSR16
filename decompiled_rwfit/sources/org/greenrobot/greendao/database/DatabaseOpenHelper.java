package org.greenrobot.greendao.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.greenrobot.greendao.DaoException;

/* loaded from: classes2.dex */
public abstract class DatabaseOpenHelper extends SQLiteOpenHelper {
    private final Context context;
    private EncryptedHelper encryptedHelper;
    private boolean loadSQLCipherNativeLibs;
    private final String name;
    private final int version;

    public interface EncryptedHelper {
        Database getEncryptedReadableDb(String str);

        Database getEncryptedReadableDb(char[] cArr);

        Database getEncryptedWritableDb(String str);

        Database getEncryptedWritableDb(char[] cArr);
    }

    public DatabaseOpenHelper(Context context, String str, int i3) {
        this(context, str, null, i3);
    }

    private EncryptedHelper checkEncryptedHelper() {
        if (this.encryptedHelper == null) {
            try {
                Class.forName("net.sqlcipher.database.SQLiteOpenHelper");
                try {
                    this.encryptedHelper = (EncryptedHelper) Class.forName("org.greenrobot.greendao.database.SqlCipherEncryptedHelper").getConstructor(DatabaseOpenHelper.class, Context.class, String.class, Integer.TYPE, Boolean.TYPE).newInstance(this, this.context, this.name, Integer.valueOf(this.version), Boolean.valueOf(this.loadSQLCipherNativeLibs));
                } catch (Exception e) {
                    throw new DaoException(e);
                }
            } catch (ClassNotFoundException unused) {
                throw new DaoException("Using an encrypted database requires SQLCipher, make sure to add it to dependencies: https://greenrobot.org/greendao/documentation/database-encryption/");
            }
        }
        return this.encryptedHelper;
    }

    public Database getEncryptedReadableDb(String str) {
        return checkEncryptedHelper().getEncryptedReadableDb(str);
    }

    public Database getEncryptedWritableDb(String str) {
        return checkEncryptedHelper().getEncryptedWritableDb(str);
    }

    public Database getReadableDb() {
        return wrap(getReadableDatabase());
    }

    public Database getWritableDb() {
        return wrap(getWritableDatabase());
    }

    public void onCreate(Database database) {
    }

    public void onOpen(Database database) {
    }

    public void onUpgrade(Database database, int i3, int i10) {
    }

    public void setLoadSQLCipherNativeLibs(boolean z5) {
        this.loadSQLCipherNativeLibs = z5;
    }

    public Database wrap(SQLiteDatabase sQLiteDatabase) {
        return new StandardDatabase(sQLiteDatabase);
    }

    public DatabaseOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, cursorFactory, i3);
        this.loadSQLCipherNativeLibs = true;
        this.context = context;
        this.name = str;
        this.version = i3;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreate(wrap(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        onOpen(wrap(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i10) {
        onUpgrade(wrap(sQLiteDatabase), i3, i10);
    }

    public Database getEncryptedReadableDb(char[] cArr) {
        return checkEncryptedHelper().getEncryptedReadableDb(cArr);
    }

    public Database getEncryptedWritableDb(char[] cArr) {
        return checkEncryptedHelper().getEncryptedWritableDb(cArr);
    }

    @SuppressLint({"NewApi"})
    public DatabaseOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, cursorFactory, i3, databaseErrorHandler);
        this.loadSQLCipherNativeLibs = true;
        this.context = context;
        this.name = str;
        this.version = i3;
    }
}
