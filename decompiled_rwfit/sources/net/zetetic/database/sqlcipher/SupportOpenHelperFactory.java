package net.zetetic.database.sqlcipher;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes2.dex */
public class SupportOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f16590a;

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteDatabaseHook f16591b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16592c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16593d;

    public SupportOpenHelperFactory(byte[] bArr) {
        this(bArr, null, false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        int i3 = this.f16593d;
        if (i3 == -1) {
            return new SupportHelper(configuration, this.f16590a, this.f16591b, this.f16592c);
        }
        return new SupportHelper(configuration, this.f16590a, this.f16591b, this.f16592c, i3);
    }

    public SupportOpenHelperFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z5) {
        this(bArr, sQLiteDatabaseHook, z5, -1);
    }

    public SupportOpenHelperFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z5, int i3) {
        this.f16590a = bArr;
        this.f16591b = sQLiteDatabaseHook;
        this.f16592c = z5;
        this.f16593d = i3;
    }
}
