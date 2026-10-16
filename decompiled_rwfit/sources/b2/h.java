package b2;

import android.database.Cursor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class h implements g8.e {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f3120a;

    @Override // g8.e
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        x7.b bVar = g8.g.e;
        while (cursor.moveToNext()) {
            long j4 = cursor.getLong(0);
            Long valueOf = Long.valueOf(j4);
            HashMap hashMap = this.f3120a;
            Set set = (Set) hashMap.get(valueOf);
            if (set == null) {
                set = new HashSet();
                hashMap.put(Long.valueOf(j4), set);
            }
            set.add(new g8.f(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }
}
