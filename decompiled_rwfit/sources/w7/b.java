package w7;

import android.database.Cursor;
import android.support.v4.media.session.e;
import java.util.ArrayList;
import org.greenrobot.greendao.database.Database;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f19519a;

    /* renamed from: b, reason: collision with root package name */
    public String f19520b;

    /* renamed from: c, reason: collision with root package name */
    public String f19521c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19522d;
    public String e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19523f;

    public static ArrayList a(Database database, String str) {
        Cursor rawQuery = database.rawQuery("PRAGMA table_info(`" + str + "`)", null);
        if (rawQuery == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            b bVar = new b();
            boolean z5 = false;
            bVar.f19519a = rawQuery.getInt(0);
            bVar.f19520b = rawQuery.getString(1);
            bVar.f19521c = rawQuery.getString(2);
            bVar.f19522d = rawQuery.getInt(3) == 1;
            bVar.e = rawQuery.getString(4);
            if (rawQuery.getInt(5) == 1) {
                z5 = true;
            }
            bVar.f19523f = z5;
            arrayList.add(bVar);
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return obj != null && b.class == obj.getClass() && this.f19520b.equals(((b) obj).f19520b);
        }
        return true;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TableInfo{cid=");
        sb2.append(this.f19519a);
        sb2.append(", name='");
        sb2.append(this.f19520b);
        sb2.append("', type='");
        sb2.append(this.f19521c);
        sb2.append("', notnull=");
        sb2.append(this.f19522d);
        sb2.append(", dfltValue='");
        sb2.append(this.e);
        sb2.append("', pk=");
        return e.o(sb2, this.f19523f, '}');
    }
}
