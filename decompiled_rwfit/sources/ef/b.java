package ef;

import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final int f12597b;

    /* renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet f12598c;

    /* renamed from: a, reason: collision with root package name */
    public String f12599a;

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        f12598c = copyOnWriteArraySet;
        a aVar = new a();
        f12597b = 3;
        copyOnWriteArraySet.add(aVar);
    }

    public static b a(String str) {
        b bVar = new b();
        bVar.f12599a = str;
        return bVar;
    }

    public final String b(int i3, Object... objArr) {
        Throwable th2 = null;
        if (f12597b <= i3) {
            CopyOnWriteArraySet copyOnWriteArraySet = f12598c;
            if (copyOnWriteArraySet.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (Object obj : objArr) {
                    if (obj instanceof Throwable) {
                        th2 = (Throwable) obj;
                    }
                    sb2.append(String.valueOf(obj));
                    sb2.append(" ");
                }
                String trim = sb2.toString().trim();
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).getClass();
                    String str = this.f12599a;
                    if (i3 == 0) {
                        Log.v(str, trim, th2);
                    } else if (i3 == 1) {
                        Log.i(str, trim, th2);
                    } else if (i3 == 2) {
                        Log.w(str, trim, th2);
                    } else if (i3 == 3) {
                        Log.e(str, trim, th2);
                    }
                }
                return trim;
            }
        }
        return null;
    }
}
