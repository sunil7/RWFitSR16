package net.zetetic.database.sqlcipher;

import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.support.v4.media.session.e;
import android.util.EventLog;
import androidx.sqlite.db.SupportSQLiteProgram;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Arrays;
import r5.a;

/* loaded from: classes2.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements SupportSQLiteProgram {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f16569h = new String[0];

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteDatabase f16570b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16571c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16572d;
    public final String[] e;

    /* renamed from: f, reason: collision with root package name */
    public final int f16573f;

    /* renamed from: g, reason: collision with root package name */
    public final Object[] f16574g;

    public SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        this.f16570b = sQLiteDatabase;
        String trim = str.trim();
        this.f16571c = trim;
        int sqlStatementType = DatabaseUtils.getSqlStatementType(trim);
        if (sqlStatementType == 4 || sqlStatementType == 5 || sqlStatementType == 6) {
            this.f16572d = false;
            this.e = f16569h;
            this.f16573f = 0;
        } else {
            boolean z5 = sqlStatementType == 1;
            SQLiteStatementInfo sQLiteStatementInfo = new SQLiteStatementInfo();
            SQLiteSession l3 = sQLiteDatabase.l();
            int k10 = SQLiteDatabase.k(z5);
            l3.getClass();
            if (trim == null) {
                throw new IllegalArgumentException("sql must not be null.");
            }
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            l3.a(trim, k10, cancellationSignal);
            try {
                l3.f16577b.q(trim, sQLiteStatementInfo);
                l3.k();
                this.f16572d = sQLiteStatementInfo.f16587c;
                this.e = sQLiteStatementInfo.f16586b;
                this.f16573f = sQLiteStatementInfo.f16585a;
            } catch (Throwable th2) {
                l3.k();
                throw th2;
            }
        }
        if (objArr != null && objArr.length > this.f16573f) {
            StringBuilder sb2 = new StringBuilder("Too many bind arguments.  ");
            sb2.append(objArr.length);
            sb2.append(" arguments were provided but the statement needs ");
            throw new IllegalArgumentException(a.e(sb2, this.f16573f, " arguments."));
        }
        int i3 = this.f16573f;
        if (i3 == 0) {
            this.f16574g = null;
            return;
        }
        Object[] objArr2 = new Object[i3];
        this.f16574g = objArr2;
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int i3, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException(l0.k(i3, "the bind value at index ", " is null"));
        }
        f(i3, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int i3, double d5) {
        f(i3, Double.valueOf(d5));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i3, long j4) {
        f(i3, Long.valueOf(j4));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i3) {
        f(i3, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int i3, String str) {
        if (str == null) {
            throw new IllegalArgumentException(l0.k(i3, "the bind value at index ", " is null"));
        }
        f(i3, str);
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    public final void c() {
        clearBindings();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void clearBindings() {
        Object[] objArr = this.f16574g;
        if (objArr != null) {
            Arrays.fill(objArr, (Object) null);
        }
    }

    public final void f(int i3, Object obj) {
        int i10 = this.f16573f;
        if (i3 < 1 || i3 > i10) {
            throw new IllegalArgumentException(e.g(i3, "Cannot bind argument at index ", i10, " because the index is out of range.  The statement has ", " parameters."));
        }
        this.f16574g[i3 - 1] = obj;
    }

    public final int g() {
        this.f16570b.getClass();
        return SQLiteDatabase.k(this.f16572d);
    }

    public final void h() {
        String str;
        SQLiteDatabase sQLiteDatabase = this.f16570b;
        synchronized (sQLiteDatabase.e) {
            str = sQLiteDatabase.f16543g.f16554b;
        }
        EventLog.writeEvent(75004, str);
        sQLiteDatabase.f16541d.a(sQLiteDatabase);
    }
}
