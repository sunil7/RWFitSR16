package net.zetetic.database;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import net.zetetic.database.sqlcipher.SQLiteConnection;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes2.dex */
public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    public static void b(String str) {
        if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
            return;
        }
        Log.e("DefaultDatabaseErrorHandler", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.h(new File(str));
        } catch (Exception e) {
            Log.w("DefaultDatabaseErrorHandler", "delete failed: " + e.getMessage());
        }
    }

    @Override // net.zetetic.database.DatabaseErrorHandler
    public final void a(SQLiteDatabase sQLiteDatabase) {
        Log.e("DefaultDatabaseErrorHandler", "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
        if (SQLiteConnection.o()) {
            return;
        }
        if (!sQLiteDatabase.isOpen()) {
            b(sQLiteDatabase.getPath());
            return;
        }
        List list = null;
        try {
            try {
                list = sQLiteDatabase.getAttachedDbs();
            } finally {
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        b((String) ((Pair) it.next()).second);
                    }
                } else {
                    b(sQLiteDatabase.getPath());
                }
            }
        } catch (SQLiteException unused) {
        }
        try {
            sQLiteDatabase.e();
        } catch (SQLiteException unused2) {
        }
    }
}
