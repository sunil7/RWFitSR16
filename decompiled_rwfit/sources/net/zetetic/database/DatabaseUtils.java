package net.zetetic.database;

import java.util.Locale;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import net.zetetic.database.sqlcipher.SQLiteStatement;

/* loaded from: classes2.dex */
public class DatabaseUtils {

    @Deprecated
    public static class InsertHelper {

        /* renamed from: a, reason: collision with root package name */
        public final SQLiteDatabase f16470a;

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
            this.f16470a = sQLiteDatabase;
        }
    }

    public static int a(String str) {
        String trim = str.trim();
        if (trim.length() < 3) {
            return 99;
        }
        String upperCase = trim.substring(0, 3).toUpperCase(Locale.ROOT);
        if (upperCase.equals("SEL")) {
            return 1;
        }
        if (upperCase.equals("INS") || upperCase.equals("UPD") || upperCase.equals("REP") || upperCase.equals("DEL")) {
            return 2;
        }
        if (upperCase.equals("ATT")) {
            return 3;
        }
        if (upperCase.equals("COM") || upperCase.equals("END")) {
            return 5;
        }
        if (upperCase.equals("ROL")) {
            return 6;
        }
        if (upperCase.equals("BEG")) {
            return 4;
        }
        if (upperCase.equals("PRA")) {
            return 7;
        }
        if (upperCase.equals("CRE") || upperCase.equals("DRO") || upperCase.equals("ALT")) {
            return 8;
        }
        return (upperCase.equals("ANA") || upperCase.equals("DET")) ? 9 : 99;
    }

    public static long b(SQLiteDatabase sQLiteDatabase, String str) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return compileStatement.simpleQueryForLong();
        } finally {
            compileStatement.e();
        }
    }
}
