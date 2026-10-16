package b2;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes.dex */
public final class k extends SupportSQLiteOpenHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    public a f3131a;

    /* renamed from: b, reason: collision with root package name */
    public final mc.g f3132b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3133c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3134d;

    public k(a aVar, mc.g gVar) {
        super(12);
        this.f3131a = aVar;
        this.f3132b = gVar;
        this.f3133c = "c103703e120ae8cc73c9248622f3cd1e";
        this.f3134d = "49f946663a8deb7054212b8adda248c6";
    }

    public final void a(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + this.f3133c + "')");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[ORIG_RETURN, RETURN] */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(androidx.sqlite.db.SupportSQLiteDatabase r6) {
        /*
            r5 = this;
            r0 = 1
            java.lang.String r1 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
            android.database.Cursor r1 = r6.query(r1)
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L16
            r3 = 0
            if (r2 == 0) goto L18
            int r2 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L16
            if (r2 != 0) goto L18
            r2 = r0
            goto L19
        L16:
            r6 = move-exception
            goto L66
        L18:
            r2 = r3
        L19:
            r1.close()
            mc.g r1 = r5.f3132b
            r1.getClass()
            mc.g.c(r6)
            if (r2 != 0) goto L45
            b2.j r2 = mc.g.h(r6)
            boolean r4 = r2.f3130b
            if (r4 == 0) goto L2f
            goto L45
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r1)
            java.lang.String r1 = r2.f3129a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L45:
            r5.a(r6)
            int r6 = androidx.work.impl.WorkDatabase_Impl.f3007s
            java.lang.Object r6 = r1.f16022b
            androidx.work.impl.WorkDatabase_Impl r6 = (androidx.work.impl.WorkDatabase_Impl) r6
            java.util.ArrayList r1 = r6.f3126g
            if (r1 == 0) goto L65
            int r1 = r1.size()
        L56:
            if (r3 >= r1) goto L65
            java.util.ArrayList r2 = r6.f3126g
            java.lang.Object r2 = r2.get(r3)
            p2.g r2 = (p2.g) r2
            r2.getClass()
            int r3 = r3 + r0
            goto L56
        L65:
            return
        L66:
            r1.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.k.onCreate(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i3, int i10) {
        onUpgrade(supportSQLiteDatabase, i3, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x005c  */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onOpen(androidx.sqlite.db.SupportSQLiteDatabase r11) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.k.onOpen(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x006b A[EDGE_INSN: B:78:0x006b->B:62:0x006b BREAK  A[LOOP:3: B:42:0x001e->B:63:?], SYNTHETIC] */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onUpgrade(androidx.sqlite.db.SupportSQLiteDatabase r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.k.onUpgrade(androidx.sqlite.db.SupportSQLiteDatabase, int, int):void");
    }
}
