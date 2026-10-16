package d2;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f12214a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f12215b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f12216c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f12217d;

    public e(String str, HashMap hashMap, HashSet hashSet, HashSet hashSet2) {
        this.f12214a = str;
        this.f12215b = Collections.unmodifiableMap(hashMap);
        this.f12216c = Collections.unmodifiableSet(hashSet);
        this.f12217d = hashSet2 == null ? null : Collections.unmodifiableSet(hashSet2);
    }

    public static e a(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        int i3;
        int i10;
        int i11;
        int i12;
        ArrayList arrayList;
        Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (query.getColumnCount() > 0) {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("notnull");
                int columnIndex4 = query.getColumnIndex("pk");
                int columnIndex5 = query.getColumnIndex("dflt_value");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    hashMap.put(string, new a(string, query.getString(columnIndex2), query.getInt(columnIndex3) != 0, query.getInt(columnIndex4), query.getString(columnIndex5), 2));
                }
            }
            query.close();
            HashSet hashSet = new HashSet();
            query = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = query.getColumnIndex("id");
                int columnIndex7 = query.getColumnIndex("seq");
                int columnIndex8 = query.getColumnIndex("table");
                int columnIndex9 = query.getColumnIndex("on_delete");
                int columnIndex10 = query.getColumnIndex("on_update");
                ArrayList b3 = b(query);
                int count = query.getCount();
                int i13 = 0;
                while (i13 < count) {
                    query.moveToPosition(i13);
                    if (query.getInt(columnIndex7) != 0) {
                        i3 = i13;
                        i10 = columnIndex6;
                        i11 = columnIndex7;
                        arrayList = b3;
                        i12 = count;
                    } else {
                        int i14 = query.getInt(columnIndex6);
                        i3 = i13;
                        ArrayList arrayList2 = new ArrayList();
                        i10 = columnIndex6;
                        ArrayList arrayList3 = new ArrayList();
                        i11 = columnIndex7;
                        int size = b3.size();
                        i12 = count;
                        int i15 = 0;
                        while (i15 < size) {
                            Object obj = b3.get(i15);
                            i15++;
                            int i16 = size;
                            c cVar = (c) obj;
                            ArrayList arrayList4 = b3;
                            if (cVar.f12207a == i14) {
                                arrayList2.add(cVar.f12209c);
                                arrayList3.add(cVar.f12210d);
                            }
                            size = i16;
                            b3 = arrayList4;
                        }
                        arrayList = b3;
                        hashSet.add(new b(query.getString(columnIndex8), query.getString(columnIndex9), query.getString(columnIndex10), arrayList2, arrayList3));
                    }
                    i13 = i3 + 1;
                    columnIndex6 = i10;
                    columnIndex7 = i11;
                    count = i12;
                    b3 = arrayList;
                }
                query.close();
                query = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = query.getColumnIndex("name");
                    int columnIndex12 = query.getColumnIndex("origin");
                    int columnIndex13 = query.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 != -1 && columnIndex12 != -1 && columnIndex13 != -1) {
                        HashSet hashSet3 = new HashSet();
                        while (query.moveToNext()) {
                            if ("c".equals(query.getString(columnIndex12))) {
                                d c9 = c(supportSQLiteDatabase, query.getString(columnIndex11), query.getInt(columnIndex13) == 1);
                                if (c9 != null) {
                                    hashSet3.add(c9);
                                }
                            }
                        }
                        query.close();
                        hashSet2 = hashSet3;
                        return new e(str, hashMap, hashSet, hashSet2);
                    }
                    return new e(str, hashMap, hashSet, hashSet2);
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static ArrayList b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(Constants.FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < count; i3++) {
            cursor.moveToPosition(i3);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX WARN: Finally extract failed */
    public static d c(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z5) {
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("seqno");
            int columnIndex2 = query.getColumnIndex("cid");
            int columnIndex3 = query.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (query.moveToNext()) {
                    if (query.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(query.getInt(columnIndex)), query.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                d dVar = new d(str, z5, arrayList);
                query.close();
                return dVar;
            }
            query.close();
            return null;
        } catch (Throwable th2) {
            query.close();
            throw th2;
        }
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        String str = eVar.f12214a;
        String str2 = this.f12214a;
        if (str2 == null ? str != null : !str2.equals(str)) {
            return false;
        }
        Map map = eVar.f12215b;
        Map map2 = this.f12215b;
        if (map2 == null ? map != null : !map2.equals(map)) {
            return false;
        }
        Set set2 = eVar.f12216c;
        Set set3 = this.f12216c;
        if (set3 == null ? set2 != null : !set3.equals(set2)) {
            return false;
        }
        Set set4 = this.f12217d;
        if (set4 == null || (set = eVar.f12217d) == null) {
            return true;
        }
        return set4.equals(set);
    }

    public final int hashCode() {
        String str = this.f12214a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.f12215b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set set = this.f12216c;
        return hashCode2 + (set != null ? set.hashCode() : 0);
    }

    public final String toString() {
        return "TableInfo{name='" + this.f12214a + "', columns=" + this.f12215b + ", foreignKeys=" + this.f12216c + ", indices=" + this.f12217d + '}';
    }
}
