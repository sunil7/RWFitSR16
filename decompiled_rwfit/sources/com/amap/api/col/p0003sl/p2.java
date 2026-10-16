package com.amap.api.col.p0003sl;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class p2 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile p2 f4804b;

    /* renamed from: c, reason: collision with root package name */
    private static ta f4805c;

    /* renamed from: a, reason: collision with root package name */
    private Context f4806a;

    private p2(Context context) {
        this.f4806a = context;
        f4805c = a(context);
    }

    private ta a(Context context) {
        try {
            return new ta(context, o2.a());
        } catch (Throwable th2) {
            ka.a(th2, "OfflineDB", "getDB");
            th2.printStackTrace();
            return null;
        }
    }

    public static p2 b(Context context) {
        if (f4804b == null) {
            synchronized (p2.class) {
                try {
                    if (f4804b == null) {
                        f4804b = new p2(context);
                    }
                } finally {
                }
            }
        }
        return f4804b;
    }

    public synchronized k2 c(String str) {
        if (!a()) {
            return null;
        }
        ArrayList arrayList = (ArrayList) f4805c.b(n2.b(str), k2.class);
        if (arrayList.size() <= 0) {
            return null;
        }
        return (k2) arrayList.get(0);
    }

    public synchronized String d(String str) {
        if (!a()) {
            return null;
        }
        ArrayList arrayList = (ArrayList) f4805c.b(n2.a(str), n2.class);
        return arrayList.size() > 0 ? ((n2) arrayList.get(0)).e : null;
    }

    private boolean a() {
        ta taVar;
        if (f4805c == null) {
            try {
                taVar = new ta(this.f4806a, o2.a());
            } catch (Throwable th2) {
                ka.a(th2, "OfflineDB", "getDB");
                th2.printStackTrace();
                taVar = null;
            }
            f4805c = taVar;
        }
        return f4805c != null;
    }

    public ArrayList<k2> b() {
        ArrayList<k2> arrayList = new ArrayList<>();
        if (a()) {
            ArrayList arrayList2 = (ArrayList) f4805c.b("", k2.class);
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                arrayList.add((k2) obj);
            }
        }
        return arrayList;
    }

    public synchronized void a(String str) {
        if (a()) {
            f4805c.a(n2.b(str), n2.class);
            f4805c.a(m2.a(str), m2.class);
            f4805c.a(l2.a(str), l2.class);
        }
    }

    public synchronized void b(k2 k2Var) {
        try {
            if (a()) {
                f4805c.a(k2Var, n2.a(k2Var.f4687m));
                String f2 = k2Var.f();
                String str = k2Var.f4678c;
                if (f2 != null && f2.length() > 0) {
                    String a3 = m2.a(str);
                    if (((ArrayList) f4805c.b(a3, m2.class)).size() > 0) {
                        f4805c.a(a3, m2.class);
                    }
                    String[] split = f2.split(Const.STR_MART_SEMICOLON);
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : split) {
                        arrayList.add(new m2(str, str2));
                    }
                    f4805c.a((List) arrayList);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(k2 k2Var) {
        if (a()) {
            f4805c.a(n2.a(k2Var.f4687m), n2.class);
            f4805c.a(m2.a(k2Var.f4678c), m2.class);
            f4805c.a(l2.a(k2Var.f4678c), l2.class);
        }
    }

    public void a(String str, int i3, long j4, long j10, long j11) {
        if (a()) {
            long[] jArr = {j10, 0, 0, 0, 0};
            long[] jArr2 = {j11, 0, 0, 0, 0};
            synchronized (this) {
                if (a()) {
                    f4805c.a(new l2(str, j4, i3, jArr[0], jArr2[0]), l2.a(str));
                }
            }
        }
    }

    public synchronized List<String> b(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            if (!a()) {
                return arrayList;
            }
            List b3 = f4805c.b(m2.a(str), m2.class);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = (ArrayList) b3;
            if (arrayList3.size() > 0) {
                int size = arrayList3.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList3.get(i3);
                    i3++;
                    arrayList2.add(((m2) obj).a());
                }
            }
            arrayList.addAll(arrayList2);
            return arrayList;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
