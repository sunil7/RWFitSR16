package net.zetetic.database.sqlcipher;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes2.dex */
public final class SQLiteStatement extends SQLiteProgram implements SupportSQLiteStatement {
    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final void execute() {
        b();
        try {
            try {
                this.f16570b.l().d(g(), this.f16571c, this.f16574g);
            } catch (SQLiteDatabaseCorruptException e) {
                h();
                throw e;
            }
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long executeInsert() {
        b();
        try {
            try {
                return this.f16570b.l().g(g(), this.f16571c, this.f16574g);
            } catch (SQLiteDatabaseCorruptException e) {
                h();
                throw e;
            }
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final int executeUpdateDelete() {
        b();
        try {
            try {
                return this.f16570b.l().e(g(), this.f16571c, this.f16574g);
            } catch (SQLiteDatabaseCorruptException e) {
                h();
                throw e;
            }
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long simpleQueryForLong() {
        b();
        try {
            try {
                return this.f16570b.l().h(g(), this.f16571c, this.f16574g);
            } catch (SQLiteDatabaseCorruptException e) {
                h();
                throw e;
            }
        } finally {
            e();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final String simpleQueryForString() {
        b();
        try {
            try {
                return this.f16570b.l().i(g(), this.f16571c, this.f16574g);
            } catch (SQLiteDatabaseCorruptException e) {
                h();
                throw e;
            }
        } finally {
            e();
        }
    }

    public final String toString() {
        return "SQLiteProgram: " + this.f16571c;
    }
}
