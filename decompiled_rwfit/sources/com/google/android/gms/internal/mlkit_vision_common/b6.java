package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import org.greenrobot.greendao.database.Database;

/* loaded from: classes.dex */
public abstract class b6 {

    /* renamed from: a, reason: collision with root package name */
    public static WeakReference f9873a;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(org.greenrobot.greendao.database.Database r3, boolean r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r3 == 0) goto L52
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto La
            goto L52
        La:
            if (r4 == 0) goto Lf
            java.lang.String r4 = "sqlite_temp_master"
            goto L11
        Lf:
            java.lang.String r4 = "sqlite_master"
        L11:
            java.lang.String r1 = "SELECT COUNT(*) FROM `"
            java.lang.String r2 = "` WHERE type = ? AND name = ?"
            java.lang.String r4 = com.google.android.gms.internal.mlkit_vision_barcode.l0.o(r1, r4, r2)
            r1 = 0
            java.lang.String r2 = "table"
            java.lang.String[] r5 = new java.lang.String[]{r2, r5}     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            android.database.Cursor r1 = r3.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r1 == 0) goto L39
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r3 != 0) goto L2d
            goto L39
        L2d:
            int r3 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            r1.close()
            goto L48
        L35:
            r3 = move-exception
            goto L4c
        L37:
            r3 = move-exception
            goto L3f
        L39:
            if (r1 == 0) goto L52
            r1.close()
            return r0
        L3f:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L35
            if (r1 == 0) goto L47
            r1.close()
        L47:
            r3 = r0
        L48:
            if (r3 <= 0) goto L4b
            r0 = 1
        L4b:
            return r0
        L4c:
            if (r1 == 0) goto L51
            r1.close()
        L51:
            throw r3
        L52:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.b6.a(org.greenrobot.greendao.database.Database, boolean, java.lang.String):boolean");
    }

    public static void b(Database database, String str, boolean z5, Class... clsArr) {
        if (clsArr.length < 1) {
            return;
        }
        try {
            for (Class cls : clsArr) {
                cls.getDeclaredMethod(str, Database.class, Boolean.TYPE).invoke(null, database, Boolean.valueOf(z5));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        } catch (InvocationTargetException e11) {
            e11.printStackTrace();
        }
    }
}
