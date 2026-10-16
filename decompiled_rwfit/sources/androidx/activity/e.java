package androidx.activity;

import android.database.Cursor;
import android.location.Location;
import android.widget.Toast;
import androidx.sqlite.db.SimpleSQLiteQuery;
import com.tencent.connect.common.Constants;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f359a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f360b;

    public /* synthetic */ e(Object obj, int i3) {
        this.f359a = i3;
        this.f360b = obj;
    }

    private final void b() {
        synchronized (com.example.baselibrary.utils.d.f7270c) {
            try {
                Toast toast = com.example.baselibrary.utils.d.f7271d;
                if (toast != null) {
                    toast.setText((String) ((e) this.f360b).f360b);
                } else {
                    com.example.baselibrary.utils.d.f7271d = Toast.makeText(com.example.baselibrary.utils.d.f7269b, (String) ((e) this.f360b).f360b, 0);
                }
                int intValue = Integer.valueOf(Constants.VIA_REPORT_TYPE_START_GROUP).intValue();
                if (intValue == 17) {
                    com.example.baselibrary.utils.d.f7271d.setGravity(17, 0, 0);
                } else if (intValue == 48) {
                    com.example.baselibrary.utils.d.f7271d.setGravity(48, 0, 0);
                }
                com.example.baselibrary.utils.d.f7271d.show();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void c() {
        nf.b bVar;
        synchronized (((nf.e) this.f360b).f16613d) {
            try {
                nf.b bVar2 = null;
                if (!((nf.e) this.f360b).f16612c) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = ((nf.e) this.f360b).f16611b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        nf.b bVar3 = (nf.b) it.next();
                        if (bVar3.e <= currentTimeMillis) {
                            bVar2 = bVar3;
                            break;
                        }
                    }
                    if (bVar2 != null) {
                        ((nf.e) this.f360b).f16612c = true;
                    }
                }
                bVar = bVar2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (bVar != null) {
            nf.e eVar = (nf.e) this.f360b;
            eVar.getClass();
            qf.i iVar = eVar.f16610a.f13671a.f13645a;
            e8.a aVar = new e8.a(eVar, bVar, iVar, 5, false);
            iVar.getClass();
            if (Thread.currentThread() == iVar.f17955b) {
                aVar.run();
            } else {
                iVar.f17956c.post(aVar);
            }
        }
    }

    public HashSet a() {
        HashSet hashSet = new HashSet();
        Cursor g10 = ((b2.e) this.f360b).f3102c.g(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
        while (g10.moveToNext()) {
            try {
                hashSet.add(Integer.valueOf(g10.getInt(0)));
            } catch (Throwable th2) {
                g10.close();
                throw th2;
            }
        }
        g10.close();
        if (!hashSet.isEmpty()) {
            ((b2.e) this.f360b).f3104f.executeUpdateDelete();
        }
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.e.run():void");
    }

    public e(o9.k kVar, d6.a aVar) {
        this.f359a = 27;
        this.f360b = aVar;
    }

    public e(ff.e eVar, Location location) {
        this.f359a = 19;
        this.f360b = eVar;
    }
}
