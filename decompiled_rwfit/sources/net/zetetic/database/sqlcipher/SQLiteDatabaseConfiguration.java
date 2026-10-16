package net.zetetic.database.sqlcipher;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class SQLiteDatabaseConfiguration {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f16552j = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");

    /* renamed from: a, reason: collision with root package name */
    public final String f16553a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16554b;

    /* renamed from: c, reason: collision with root package name */
    public int f16555c;

    /* renamed from: d, reason: collision with root package name */
    public int f16556d;
    public Locale e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16557f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f16558g;

    /* renamed from: h, reason: collision with root package name */
    public SQLiteDatabaseHook f16559h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f16560i;

    public SQLiteDatabaseConfiguration(String str, int i3) {
        this(str, i3, null, null);
    }

    public final void a(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        if (sQLiteDatabaseConfiguration == null) {
            throw new IllegalArgumentException("other must not be null.");
        }
        if (!this.f16553a.equals(sQLiteDatabaseConfiguration.f16553a)) {
            throw new IllegalArgumentException("other configuration must refer to the same database.");
        }
        this.f16555c = sQLiteDatabaseConfiguration.f16555c;
        this.f16556d = sQLiteDatabaseConfiguration.f16556d;
        this.e = sQLiteDatabaseConfiguration.e;
        this.f16557f = sQLiteDatabaseConfiguration.f16557f;
        this.f16558g = sQLiteDatabaseConfiguration.f16558g;
        this.f16559h = sQLiteDatabaseConfiguration.f16559h;
        ArrayList arrayList = this.f16560i;
        arrayList.clear();
        arrayList.addAll(sQLiteDatabaseConfiguration.f16560i);
    }

    public SQLiteDatabaseConfiguration(String str, int i3, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this.f16560i = new ArrayList();
        if (str == null) {
            throw new IllegalArgumentException("path must not be null.");
        }
        this.f16553a = str;
        int indexOf = str.indexOf(63);
        str = indexOf >= 0 ? (String) str.subSequence(0, indexOf) : str;
        this.f16554b = str.indexOf(64) != -1 ? f16552j.matcher(str).replaceAll("XX@YY") : str;
        this.f16555c = i3;
        this.f16558g = bArr;
        this.f16559h = sQLiteDatabaseHook;
        this.f16556d = 25;
        this.e = Locale.getDefault();
    }

    public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        this.f16560i = new ArrayList();
        if (sQLiteDatabaseConfiguration != null) {
            this.f16553a = sQLiteDatabaseConfiguration.f16553a;
            this.f16554b = sQLiteDatabaseConfiguration.f16554b;
            a(sQLiteDatabaseConfiguration);
            return;
        }
        throw new IllegalArgumentException("other must not be null.");
    }
}
