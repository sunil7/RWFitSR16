package o2;

import com.autonavi.aps.amapapi.config.Const;
import com.dh.keeplive.workmanager.KeepLiveWorker;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class n extends ab.n {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f16721d = 1;

    public /* synthetic */ n(Class cls) {
        super(cls);
    }

    @Override // ab.n
    public final u b() {
        switch (this.f16721d) {
            case 0:
                return new o((UUID) this.f194a, (x2.h) this.f195b, (HashSet) this.f196c);
            default:
                x2.h hVar = (x2.h) this.f195b;
                if (hVar.f19764q) {
                    throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
                }
                return new t((UUID) this.f194a, hVar, (HashSet) this.f196c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n() {
        super(KeepLiveWorker.class);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        x2.h hVar = (x2.h) this.f195b;
        long millis = timeUnit.toMillis(15L);
        hVar.getClass();
        long j4 = 900000;
        String str = x2.h.f19748s;
        if (millis < 900000) {
            m.g().k(str, "Interval duration lesser than minimum allowed value; Changed to 900000", new Throwable[0]);
            millis = 900000;
        }
        if (millis < 900000) {
            m.g().k(str, "Interval duration lesser than minimum allowed value; Changed to 900000", new Throwable[0]);
        } else {
            j4 = millis;
        }
        if (millis < Const.L_GPS_REBOOT_INTERVAL) {
            m.g().k(str, "Flex duration lesser than minimum allowed value; Changed to 300000", new Throwable[0]);
            millis = 300000;
        }
        if (millis > j4) {
            m.g().k(str, l0.l(j4, "Flex duration greater than interval duration; Changed to "), new Throwable[0]);
            millis = j4;
        }
        hVar.f19755h = j4;
        hVar.f19756i = millis;
    }
}
