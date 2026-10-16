package androidx.recyclerview.widget;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.Priority;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class e implements ia.c, g8.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2535a;

    /* renamed from: b, reason: collision with root package name */
    public long f2536b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2537c;

    public e(long j4, a8.b bVar) {
        this.f2535a = 2;
        this.f2536b = j4;
        this.f2537c = bVar;
    }

    public void a(int i3) {
        if (i3 < 64) {
            this.f2536b &= ~(1 << i3);
            return;
        }
        e eVar = (e) this.f2537c;
        if (eVar != null) {
            eVar.a(i3 - 64);
        }
    }

    @Override // g8.e
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        x7.b bVar = g8.g.e;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f2536b));
        a8.b bVar2 = (a8.b) this.f2537c;
        String str = bVar2.f120a;
        Priority priority = bVar2.f122c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(j8.a.a(priority))}) < 1) {
            contentValues.put("backend_name", bVar2.f120a);
            contentValues.put("priority", Integer.valueOf(j8.a.a(priority)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public int b(int i3) {
        e eVar = (e) this.f2537c;
        if (eVar == null) {
            return i3 >= 64 ? Long.bitCount(this.f2536b) : Long.bitCount(this.f2536b & ((1 << i3) - 1));
        }
        if (i3 < 64) {
            return Long.bitCount(this.f2536b & ((1 << i3) - 1));
        }
        return Long.bitCount(this.f2536b) + eVar.b(i3 - 64);
    }

    public void c() {
        if (((e) this.f2537c) == null) {
            this.f2537c = new e();
        }
    }

    public boolean d(int i3) {
        if (i3 < 64) {
            return (this.f2536b & (1 << i3)) != 0;
        }
        c();
        return ((e) this.f2537c).d(i3 - 64);
    }

    public void e(int i3, boolean z5) {
        if (i3 >= 64) {
            c();
            ((e) this.f2537c).e(i3 - 64, z5);
            return;
        }
        long j4 = this.f2536b;
        boolean z6 = (Long.MIN_VALUE & j4) != 0;
        long j10 = (1 << i3) - 1;
        this.f2536b = ((j4 & (~j10)) << 1) | (j4 & j10);
        if (z5) {
            h(i3);
        } else {
            a(i3);
        }
        if (z6 || ((e) this.f2537c) != null) {
            c();
            ((e) this.f2537c).e(0, z6);
        }
    }

    public boolean f(int i3) {
        if (i3 >= 64) {
            c();
            return ((e) this.f2537c).f(i3 - 64);
        }
        long j4 = 1 << i3;
        long j10 = this.f2536b;
        boolean z5 = (j10 & j4) != 0;
        long j11 = j10 & (~j4);
        this.f2536b = j11;
        long j12 = j4 - 1;
        this.f2536b = (j11 & j12) | Long.rotateRight((~j12) & j11, 1);
        e eVar = (e) this.f2537c;
        if (eVar != null) {
            if (eVar.d(0)) {
                h(63);
            }
            ((e) this.f2537c).f(0);
        }
        return z5;
    }

    public void g() {
        this.f2536b = 0L;
        e eVar = (e) this.f2537c;
        if (eVar != null) {
            eVar.g();
        }
    }

    public void h(int i3) {
        if (i3 < 64) {
            this.f2536b |= 1 << i3;
        } else {
            c();
            ((e) this.f2537c).h(i3 - 64);
        }
    }

    public String toString() {
        switch (this.f2535a) {
            case 0:
                if (((e) this.f2537c) == null) {
                    return Long.toBinaryString(this.f2536b);
                }
                return ((e) this.f2537c).toString() + "xx" + Long.toBinaryString(this.f2536b);
            default:
                return super.toString();
        }
    }

    @Override // ia.c
    public void w(Exception exc) {
        ((AtomicLong) ((com.example.test.utils.y) this.f2537c).f8774c).set(this.f2536b);
    }

    public /* synthetic */ e(com.example.test.utils.y yVar, long j4) {
        this.f2535a = 1;
        this.f2537c = yVar;
        this.f2536b = j4;
    }

    public e() {
        this.f2535a = 0;
        this.f2536b = 0L;
    }
}
