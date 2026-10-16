package t5;

import android.app.PendingIntent;
import android.os.Handler;
import com.example.blesdk.ble.scan.ScanSettings;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: n, reason: collision with root package name */
    public final h f18542n;

    public e(boolean z5, boolean z6, ArrayList arrayList, ScanSettings scanSettings, PendingIntent pendingIntent) {
        super(z5, z6, arrayList, scanSettings, new h(pendingIntent, scanSettings), new Handler());
        this.f18542n = (h) this.f18532h;
    }
}
