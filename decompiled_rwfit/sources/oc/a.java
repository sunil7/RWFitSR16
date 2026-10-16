package oc;

import android.os.SystemClock;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import q9.n;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final o4.c f16911c = new o4.c("StreamingFormatChecker", "");

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f16912a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public long f16913b = -1;

    public final void a(nc.a aVar) {
        if (aVar.e != -1) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        LinkedList linkedList = this.f16912a;
        linkedList.add(Long.valueOf(elapsedRealtime));
        if (linkedList.size() > 5) {
            linkedList.removeFirst();
        }
        if (linkedList.size() == 5) {
            Long l3 = (Long) linkedList.peekFirst();
            n.e(l3);
            if (elapsedRealtime - l3.longValue() < 5000) {
                long j4 = this.f16913b;
                if (j4 == -1 || elapsedRealtime - j4 >= TimeUnit.SECONDS.toMillis(5L)) {
                    this.f16913b = elapsedRealtime;
                    o4.c cVar = f16911c;
                    if (Log.isLoggable((String) cVar.f16732a, 5)) {
                        Log.w("StreamingFormatChecker", cVar.r("ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit."));
                    }
                }
            }
        }
    }
}
