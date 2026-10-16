package com.amap.api.col.p0003sl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ta {

    /* renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends sa>, sa> f5103d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private wa f5104a;

    /* renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f5105b;

    /* renamed from: c, reason: collision with root package name */
    private sa f5106c;

    public ta(Context context, sa saVar) {
        try {
            this.f5104a = new wa(context.getApplicationContext(), saVar.getDBName(), saVar.getVersion(), saVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f5106c = saVar;
    }

    public static synchronized sa b(Class<? extends sa> cls) throws IllegalAccessException, InstantiationException {
        sa saVar;
        synchronized (ta.class) {
            try {
                if (f5103d.get(cls) == null) {
                    f5103d.put(cls, cls.newInstance());
                }
                saVar = f5103d.get(cls);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return saVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        if (r4 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> void a(java.lang.String r4, java.lang.Class<T> r5) {
        /*
            r3 = this;
            com.amap.api.col.3sl.sa r0 = r3.f5106c
            monitor-enter(r0)
            com.amap.api.col.3sl.ua r5 = a(r5)     // Catch: java.lang.Throwable -> L13
            java.lang.String r5 = a(r5)     // Catch: java.lang.Throwable -> L13
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L15
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            return
        L13:
            r4 = move-exception
            goto L46
        L15:
            android.database.sqlite.SQLiteDatabase r1 = r3.a()     // Catch: java.lang.Throwable -> L13
            r3.f5105b = r1     // Catch: java.lang.Throwable -> L13
            if (r1 != 0) goto L1f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            return
        L1f:
            r2 = 0
            r1.delete(r5, r4, r2)     // Catch: java.lang.Throwable -> L28
            android.database.sqlite.SQLiteDatabase r4 = r3.f5105b     // Catch: java.lang.Throwable -> L13
            if (r4 == 0) goto L39
            goto L34
        L28:
            r4 = move-exception
            java.lang.String r5 = "dbs"
            java.lang.String r1 = "dld"
            com.amap.api.col.p0003sl.ga.a(r4, r5, r1)     // Catch: java.lang.Throwable -> L3b
            android.database.sqlite.SQLiteDatabase r4 = r3.f5105b     // Catch: java.lang.Throwable -> L13
            if (r4 == 0) goto L39
        L34:
            r4.close()     // Catch: java.lang.Throwable -> L13
            r3.f5105b = r2     // Catch: java.lang.Throwable -> L13
        L39:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            return
        L3b:
            r4 = move-exception
            android.database.sqlite.SQLiteDatabase r5 = r3.f5105b     // Catch: java.lang.Throwable -> L13
            if (r5 == 0) goto L45
            r5.close()     // Catch: java.lang.Throwable -> L13
            r3.f5105b = r2     // Catch: java.lang.Throwable -> L13
        L45:
            throw r4     // Catch: java.lang.Throwable -> L13
        L46:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ta.a(java.lang.String, java.lang.Class):void");
    }

    public <T> List<T> b(String str, Class<T> cls) {
        ArrayList arrayList;
        ua a3;
        String a10;
        Throwable th2;
        Cursor cursor;
        synchronized (this.f5106c) {
            try {
                arrayList = new ArrayList();
                a3 = a((Class) cls);
                a10 = a(a3);
                SQLiteDatabase sQLiteDatabase = this.f5105b;
                if (sQLiteDatabase == null) {
                    if (sQLiteDatabase == null) {
                        try {
                            this.f5105b = this.f5104a.getReadableDatabase();
                        } catch (Throwable th3) {
                            ga.a(th3, "dbs", "grd");
                        }
                    }
                    this.f5105b = this.f5105b;
                }
            } catch (Throwable th4) {
                throw th4;
            }
            if (this.f5105b != null && !TextUtils.isEmpty(a10) && str != null) {
                try {
                    try {
                        cursor = this.f5105b.query(a10, null, str, null, null, null, null);
                    } catch (Throwable th5) {
                        th2 = th5;
                        cursor = null;
                    }
                } catch (Throwable th6) {
                    ga.a(th6, "dbs", "sld");
                }
                try {
                } catch (Throwable th7) {
                    th2 = th7;
                    try {
                        ga.a(th2, "dbs", "sld");
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th8) {
                                ga.a(th8, "dbs", "sld");
                            }
                        }
                        SQLiteDatabase sQLiteDatabase2 = this.f5105b;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                            this.f5105b = null;
                        }
                        return arrayList;
                    } finally {
                    }
                }
                if (cursor == null) {
                    this.f5105b.close();
                    this.f5105b = null;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th9) {
                            ga.a(th9, "dbs", "sld");
                        }
                    }
                    try {
                        SQLiteDatabase sQLiteDatabase3 = this.f5105b;
                        if (sQLiteDatabase3 != null) {
                            sQLiteDatabase3.close();
                            this.f5105b = null;
                        }
                    } catch (Throwable th10) {
                        ga.a(th10, "dbs", "sld");
                    }
                } else {
                    while (cursor.moveToNext()) {
                        arrayList.add(a(cursor, cls, a3));
                    }
                    try {
                        cursor.close();
                    } catch (Throwable th11) {
                        ga.a(th11, "dbs", "sld");
                    }
                    SQLiteDatabase sQLiteDatabase4 = this.f5105b;
                    if (sQLiteDatabase4 != null) {
                        sQLiteDatabase4.close();
                        this.f5105b = null;
                    }
                }
                throw th4;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        if (r5 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> void a(java.lang.String r5, java.lang.Object r6) {
        /*
            r4 = this;
            com.amap.api.col.3sl.sa r0 = r4.f5106c
            monitor-enter(r0)
            java.lang.Class r1 = r6.getClass()     // Catch: java.lang.Throwable -> L17
            com.amap.api.col.3sl.ua r1 = a(r1)     // Catch: java.lang.Throwable -> L17
            java.lang.String r2 = a(r1)     // Catch: java.lang.Throwable -> L17
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L17
            if (r3 == 0) goto L19
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            return
        L17:
            r5 = move-exception
            goto L4e
        L19:
            android.content.ContentValues r6 = a(r6, r1)     // Catch: java.lang.Throwable -> L17
            android.database.sqlite.SQLiteDatabase r1 = r4.a()     // Catch: java.lang.Throwable -> L17
            r4.f5105b = r1     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L27
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            return
        L27:
            r3 = 0
            r1.update(r2, r6, r5, r3)     // Catch: java.lang.Throwable -> L30
            android.database.sqlite.SQLiteDatabase r5 = r4.f5105b     // Catch: java.lang.Throwable -> L17
            if (r5 == 0) goto L41
            goto L3c
        L30:
            r5 = move-exception
            java.lang.String r6 = "dbs"
            java.lang.String r1 = "udd"
            com.amap.api.col.p0003sl.ga.a(r5, r6, r1)     // Catch: java.lang.Throwable -> L43
            android.database.sqlite.SQLiteDatabase r5 = r4.f5105b     // Catch: java.lang.Throwable -> L17
            if (r5 == 0) goto L41
        L3c:
            r5.close()     // Catch: java.lang.Throwable -> L17
            r4.f5105b = r3     // Catch: java.lang.Throwable -> L17
        L41:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            return
        L43:
            r5 = move-exception
            android.database.sqlite.SQLiteDatabase r6 = r4.f5105b     // Catch: java.lang.Throwable -> L17
            if (r6 == 0) goto L4d
            r6.close()     // Catch: java.lang.Throwable -> L17
            r4.f5105b = r3     // Catch: java.lang.Throwable -> L17
        L4d:
            throw r5     // Catch: java.lang.Throwable -> L17
        L4e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ta.a(java.lang.String, java.lang.Object):void");
    }

    public void a(Object obj, String str) {
        synchronized (this.f5106c) {
            try {
                if (((ArrayList) b(str, obj.getClass())).size() == 0) {
                    a((ta) obj);
                } else {
                    a(str, obj);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
    
        if (r5 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> void a(T r5) {
        /*
            r4 = this;
            com.amap.api.col.3sl.sa r0 = r4.f5106c
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r4.a()     // Catch: java.lang.Throwable -> Ld
            r4.f5105b = r1     // Catch: java.lang.Throwable -> Ld
            if (r1 != 0) goto Lf
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            return
        Ld:
            r5 = move-exception
            goto L36
        Lf:
            r2 = 0
            a(r1, r5)     // Catch: java.lang.Throwable -> L18
            android.database.sqlite.SQLiteDatabase r5 = r4.f5105b     // Catch: java.lang.Throwable -> Ld
            if (r5 == 0) goto L29
            goto L24
        L18:
            r5 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r3 = "itd"
            com.amap.api.col.p0003sl.ga.a(r5, r1, r3)     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r5 = r4.f5105b     // Catch: java.lang.Throwable -> Ld
            if (r5 == 0) goto L29
        L24:
            r5.close()     // Catch: java.lang.Throwable -> Ld
            r4.f5105b = r2     // Catch: java.lang.Throwable -> Ld
        L29:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            return
        L2b:
            r5 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r4.f5105b     // Catch: java.lang.Throwable -> Ld
            if (r1 == 0) goto L35
            r1.close()     // Catch: java.lang.Throwable -> Ld
            r4.f5105b = r2     // Catch: java.lang.Throwable -> Ld
        L35:
            throw r5     // Catch: java.lang.Throwable -> Ld
        L36:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ta.a(java.lang.Object):void");
    }

    private static <T> void a(SQLiteDatabase sQLiteDatabase, T t8) {
        ua a3 = a((Class) t8.getClass());
        String a10 = a(a3);
        if (TextUtils.isEmpty(a10) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(a10, null, a(t8, a3));
    }

    public <T> void a(List<T> list) {
        synchronized (this.f5106c) {
            try {
                if (list.size() == 0) {
                    return;
                }
                SQLiteDatabase a3 = a();
                this.f5105b = a3;
                if (a3 == null) {
                    return;
                }
                try {
                    try {
                        a3.beginTransaction();
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            a(this.f5105b, it.next());
                        }
                        this.f5105b.setTransactionSuccessful();
                        try {
                            if (this.f5105b.inTransaction()) {
                                this.f5105b.endTransaction();
                            }
                        } catch (Throwable th2) {
                            ga.a(th2, "dbs", "ild");
                        }
                        this.f5105b.close();
                        this.f5105b = null;
                    } catch (Throwable th3) {
                        try {
                            ga.a(th3, "dbs", "ild");
                            try {
                                if (this.f5105b.inTransaction()) {
                                    this.f5105b.endTransaction();
                                }
                            } catch (Throwable th4) {
                                ga.a(th4, "dbs", "ild");
                            }
                            this.f5105b.close();
                            this.f5105b = null;
                        } finally {
                        }
                    }
                } catch (Throwable th5) {
                    ga.a(th5, "dbs", "ild");
                }
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }

    private static <T> T a(Cursor cursor, Class<T> cls, ua uaVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] declaredFields;
        boolean isSuperField = uaVar.isSuperField();
        if (cls == null) {
            declaredFields = null;
        } else if (isSuperField) {
            declaredFields = cls.getSuperclass().getDeclaredFields();
        } else {
            declaredFields = cls.getDeclaredFields();
        }
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(null);
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(va.class);
            if (annotation != null) {
                va vaVar = (va) annotation;
                int fieldType = vaVar.fieldType();
                int columnIndex = cursor.getColumnIndex(vaVar.fieldName());
                switch (fieldType) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return newInstance;
    }

    private static ContentValues a(Object obj, ua uaVar) {
        Field[] declaredFields;
        ContentValues contentValues = new ContentValues();
        Class<?> cls = obj.getClass();
        if (uaVar.isSuperField()) {
            declaredFields = cls.getSuperclass().getDeclaredFields();
        } else {
            declaredFields = cls.getDeclaredFields();
        }
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(va.class);
            if (annotation != null) {
                va vaVar = (va) annotation;
                switch (vaVar.fieldType()) {
                    case 1:
                        contentValues.put(vaVar.fieldName(), Short.valueOf(field.getShort(obj)));
                        break;
                    case 2:
                        contentValues.put(vaVar.fieldName(), Integer.valueOf(field.getInt(obj)));
                        break;
                    case 3:
                        contentValues.put(vaVar.fieldName(), Float.valueOf(field.getFloat(obj)));
                        break;
                    case 4:
                        contentValues.put(vaVar.fieldName(), Double.valueOf(field.getDouble(obj)));
                        break;
                    case 5:
                        contentValues.put(vaVar.fieldName(), Long.valueOf(field.getLong(obj)));
                        break;
                    case 6:
                        contentValues.put(vaVar.fieldName(), (String) field.get(obj));
                        break;
                    case 7:
                        try {
                            contentValues.put(vaVar.fieldName(), (byte[]) field.get(obj));
                            break;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            break;
                        }
                }
            }
        }
        return contentValues;
    }

    private SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.f5105b;
        } catch (Throwable th2) {
            ga.a(th2, "dbs", "gwd");
        }
        if (sQLiteDatabase != null) {
            if (sQLiteDatabase.isReadOnly()) {
            }
            return this.f5105b;
        }
        SQLiteDatabase sQLiteDatabase2 = this.f5105b;
        if (sQLiteDatabase2 != null) {
            sQLiteDatabase2.close();
        }
        this.f5105b = this.f5104a.getWritableDatabase();
        return this.f5105b;
    }

    private static <T> String a(ua uaVar) {
        if (uaVar == null) {
            return null;
        }
        return uaVar.tableName();
    }

    private static <T> ua a(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(ua.class);
        if (annotation != null) {
            return (ua) annotation;
        }
        return null;
    }
}
