package b2;

import android.content.Context;
import android.util.Log;
import androidx.room.RoomDatabase$JournalMode;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f3109a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3110b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f3111c;

    /* renamed from: d, reason: collision with root package name */
    public Executor f3112d;
    public Executor e;

    /* renamed from: f, reason: collision with root package name */
    public SupportSQLiteOpenHelper.Factory f3113f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3114g;

    /* renamed from: h, reason: collision with root package name */
    public final RoomDatabase$JournalMode f3115h = RoomDatabase$JournalMode.AUTOMATIC;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3116i = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3117j;

    /* renamed from: k, reason: collision with root package name */
    public final h f3118k;

    /* renamed from: l, reason: collision with root package name */
    public HashSet f3119l;

    public g(Context context, String str) {
        this.f3110b = context;
        this.f3109a = str;
        h hVar = new h();
        hVar.f3120a = new HashMap();
        this.f3118k = hVar;
    }

    public final void a(c2.a... aVarArr) {
        if (this.f3119l == null) {
            this.f3119l = new HashSet();
        }
        for (c2.a aVar : aVarArr) {
            this.f3119l.add(Integer.valueOf(aVar.f3372a));
            this.f3119l.add(Integer.valueOf(aVar.f3373b));
        }
        h hVar = this.f3118k;
        hVar.getClass();
        for (c2.a aVar2 : aVarArr) {
            int i3 = aVar2.f3372a;
            HashMap hashMap = hVar.f3120a;
            TreeMap treeMap = (TreeMap) hashMap.get(Integer.valueOf(i3));
            if (treeMap == null) {
                treeMap = new TreeMap();
                hashMap.put(Integer.valueOf(i3), treeMap);
            }
            int i10 = aVar2.f3373b;
            c2.a aVar3 = (c2.a) treeMap.get(Integer.valueOf(i10));
            if (aVar3 != null) {
                Log.w("ROOM", "Overriding migration " + aVar3 + " with " + aVar2);
            }
            treeMap.put(Integer.valueOf(i10), aVar2);
        }
    }
}
