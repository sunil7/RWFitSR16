package g8;

import android.database.Cursor;
import android.util.Base64;
import de.o;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final d f13884a = new d();

    @Override // g8.e
    public final Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        x7.b bVar = g.e;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            o a3 = a8.b.a();
            String string = cursor.getString(1);
            if (string == null) {
                throw new NullPointerException("Null backendName");
            }
            a3.f12377b = string;
            a3.f12378c = j8.a.b(cursor.getInt(2));
            String string2 = cursor.getString(3);
            a3.f12379d = string2 == null ? null : Base64.decode(string2, 0);
            arrayList.add(a3.i());
        }
        return arrayList;
    }
}
