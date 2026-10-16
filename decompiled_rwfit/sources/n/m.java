package n;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final long f16250a;

    /* renamed from: b, reason: collision with root package name */
    public long f16251b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f16252c;

    public m(long j4) {
        this.f16252c = new LinkedHashMap(100, 0.75f, true);
        this.f16250a = j4;
    }

    public synchronized Object a(Object obj) {
        t4.h hVar;
        hVar = (t4.h) ((LinkedHashMap) this.f16252c).get(obj);
        return hVar != null ? hVar.f18516a : null;
    }

    public int b() {
        if (!((androidx.camera.camera2.internal.h) this.f16252c).c()) {
            return FontStyle.WEIGHT_BOLD;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f16251b == -1) {
            this.f16251b = uptimeMillis;
        }
        long j4 = uptimeMillis - this.f16251b;
        if (j4 <= 120000) {
            return 1000;
        }
        return j4 <= Const.L_GPS_REBOOT_INTERVAL ? 2000 : 4000;
    }

    public int c() {
        boolean c9 = ((androidx.camera.camera2.internal.h) this.f16252c).c();
        long j4 = this.f16250a;
        if (c9) {
            if (j4 > 0) {
                return Math.min((int) j4, 1800000);
            }
            return 1800000;
        }
        if (j4 > 0) {
            return Math.min((int) j4, 10000);
        }
        return 10000;
    }

    public int d(Object obj) {
        return 1;
    }

    public void e(Object obj, Object obj2) {
    }

    public synchronized Object f(Object obj, Object obj2) {
        int d5 = d(obj2);
        long j4 = d5;
        if (j4 >= this.f16250a) {
            e(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f16251b += j4;
        }
        t4.h hVar = (t4.h) ((LinkedHashMap) this.f16252c).put(obj, obj2 == null ? null : new t4.h(obj2, d5));
        if (hVar != null) {
            this.f16251b -= hVar.f18517b;
            if (!hVar.f18516a.equals(obj2)) {
                e(obj, hVar.f18516a);
            }
        }
        g(this.f16250a);
        return hVar != null ? hVar.f18516a : null;
    }

    public synchronized void g(long j4) {
        while (this.f16251b > j4) {
            Iterator it = ((LinkedHashMap) this.f16252c).entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            t4.h hVar = (t4.h) entry.getValue();
            this.f16251b -= hVar.f18517b;
            Object key = entry.getKey();
            it.remove();
            e(key, hVar.f18516a);
        }
    }

    public m(androidx.camera.camera2.internal.h hVar, long j4) {
        this.f16252c = hVar;
        this.f16251b = -1L;
        this.f16250a = j4;
    }
}
