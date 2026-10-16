package com.example.database.api;

import android.content.Context;
import com.example.database.dao.DaoMaster;
import java.nio.charset.StandardCharsets;
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import net.zetetic.database.sqlcipher.SQLiteDatabaseHook;
import net.zetetic.database.sqlcipher.SQLiteOpenHelper;
import org.greenrobot.greendao.database.Database;

/* loaded from: classes.dex */
public class SqlCipherHelper extends SQLiteOpenHelper {
    private final MySQLiteOpenHelper greenDaoHelper;

    public SqlCipherHelper(Context context, String str, String str2) {
        super(context, str, str2.getBytes(StandardCharsets.UTF_8), (SQLiteDatabase.CursorFactory) null, 12, 0, (DatabaseErrorHandler) null, (SQLiteDatabaseHook) null, false);
        this.greenDaoHelper = new MySQLiteOpenHelper(context, str, null);
    }

    public Database getEncryptedDatabase() {
        return new SqlCipherDatabase(getWritableDatabase());
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        DaoMaster.createAllTables(new SqlCipherDatabase(sQLiteDatabase), false);
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i10) {
        this.greenDaoHelper.onUpgrade(new SqlCipherDatabase(sQLiteDatabase), i3, i10);
    }
}
