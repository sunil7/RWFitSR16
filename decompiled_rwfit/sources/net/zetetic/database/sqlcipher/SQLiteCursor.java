package net.zetetic.database.sqlcipher;

import android.database.AbstractWindowedCursor;
import android.database.CursorWindow;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.HashMap;
import l1.r1;

/* loaded from: classes2.dex */
public class SQLiteCursor extends AbstractWindowedCursor implements AutoCloseable {

    /* renamed from: g, reason: collision with root package name */
    public static final int f16530g = (int) (Math.pow(1024.0d, 2.0d) * 8.0d);

    /* renamed from: a, reason: collision with root package name */
    public final String[] f16531a;

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteQuery f16532b;

    /* renamed from: c, reason: collision with root package name */
    public final SQLiteCursorDriver f16533c;

    /* renamed from: d, reason: collision with root package name */
    public int f16534d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f16535f;

    @Deprecated
    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public final void b(int i3) {
        CursorWindow cursorWindow;
        SQLiteQuery sQLiteQuery = this.f16532b;
        String path = sQLiteQuery.f16570b.getPath();
        int i10 = f16530g + 512;
        CursorWindow window = getWindow();
        if (window == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                cursorWindow = r1.b(i10, path);
            } else {
                try {
                    Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                        declaredField.set(null, Integer.valueOf(i10));
                        Log.i("SQLiteCursor", "Set CursorWindow allocation size to " + i10);
                    }
                } catch (Exception e) {
                    Log.e("SQLiteCursor", "Failed to override CursorWindow allocation size", e);
                }
                cursorWindow = new CursorWindow(path);
            }
            setWindow(cursorWindow);
        } else {
            window.clear();
        }
        try {
            if (this.f16534d != -1) {
                sQLiteQuery.i(((AbstractWindowedCursor) this).mWindow, Math.max(i3 - (this.e / 3), 0), i3, false);
                return;
            }
            this.f16534d = sQLiteQuery.i(((AbstractWindowedCursor) this).mWindow, Math.max(i3, 0), i3, true);
            this.e = ((AbstractWindowedCursor) this).mWindow.getNumRows();
            if (Log.isLoggable("SQLiteCursor", 3)) {
                Log.d("SQLiteCursor", "received count(*) from native_fill_window: " + this.f16534d);
            }
        } catch (RuntimeException e10) {
            setWindow(null);
            throw e10;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        synchronized (this) {
            this.f16532b.e();
            this.f16533c.getClass();
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final void deactivate() {
        super.deactivate();
        this.f16533c.getClass();
    }

    @Override // android.database.AbstractCursor
    public final void finalize() {
        try {
            if (((AbstractWindowedCursor) this).mWindow != null) {
                close();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final int getColumnIndex(String str) {
        if (this.f16535f == null) {
            String[] strArr = this.f16531a;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i3 = 0; i3 < length; i3++) {
                hashMap.put(strArr[i3], Integer.valueOf(i3));
            }
            this.f16535f = hashMap;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Log.e("SQLiteCursor", "requesting column name with table name -- ".concat(str), new Exception());
            str = str.substring(lastIndexOf + 1);
        }
        Integer num = (Integer) this.f16535f.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final String[] getColumnNames() {
        return this.f16531a;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final int getCount() {
        if (this.f16534d == -1) {
            b(0);
        }
        return this.f16534d;
    }

    @Override // android.database.AbstractCursor, android.database.CrossProcessCursor
    public final boolean onMove(int i3, int i10) {
        CursorWindow cursorWindow = ((AbstractWindowedCursor) this).mWindow;
        if (cursorWindow != null && i10 >= cursorWindow.getStartPosition()) {
            if (i10 < ((AbstractWindowedCursor) this).mWindow.getNumRows() + ((AbstractWindowedCursor) this).mWindow.getStartPosition()) {
                return true;
            }
        }
        b(i10);
        return true;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final boolean requery() {
        if (isClosed()) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.f16532b.f16570b.isOpen()) {
                    return false;
                }
                CursorWindow cursorWindow = ((AbstractWindowedCursor) this).mWindow;
                if (cursorWindow != null) {
                    cursorWindow.clear();
                }
                ((AbstractWindowedCursor) this).mPos = -1;
                this.f16534d = -1;
                this.f16533c.getClass();
                try {
                    return super.requery();
                } catch (IllegalStateException e) {
                    Log.w("SQLiteCursor", "requery() failed " + e.getMessage(), e);
                    return false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.database.AbstractWindowedCursor
    public final void setWindow(CursorWindow cursorWindow) {
        super.setWindow(cursorWindow);
        this.f16534d = -1;
    }

    public SQLiteCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.f16534d = -1;
        if (sQLiteQuery == null) {
            throw new IllegalArgumentException("query object cannot be null");
        }
        this.f16533c = sQLiteCursorDriver;
        this.f16535f = null;
        this.f16532b = sQLiteQuery;
        this.f16531a = sQLiteQuery.e;
    }
}
