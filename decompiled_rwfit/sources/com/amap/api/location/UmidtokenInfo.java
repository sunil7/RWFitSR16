package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003sl.f9;
import com.autonavi.aps.amapapi.utils.CoreUtil;

/* loaded from: classes.dex */
public class UmidtokenInfo {

    /* renamed from: a, reason: collision with root package name */
    private static AMapLocationClient f5682a;

    /* renamed from: b, reason: collision with root package name */
    static Handler f5683b = new Handler();

    /* renamed from: c, reason: collision with root package name */
    static String f5684c = null;

    /* renamed from: d, reason: collision with root package name */
    static boolean f5685d = true;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UmidtokenInfo.f5682a != null) {
                    UmidtokenInfo.f5682a.onDestroy();
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "UmidListener", "postDelayed");
            }
        }
    }

    public static class b implements AMapLocationListener {
        @Override // com.amap.api.location.AMapLocationListener
        public void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.f5682a != null) {
                    UmidtokenInfo.f5683b.removeCallbacksAndMessages(null);
                    UmidtokenInfo.f5682a.onDestroy();
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return f5684c;
    }

    public static void setLocAble(boolean z5) {
        f5685d = z5;
    }

    public static synchronized void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                f5684c = str;
                f9.a(str);
                if (f5682a == null && f5685d) {
                    b bVar = new b();
                    f5682a = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    f5682a.setLocationOption(aMapLocationClientOption);
                    f5682a.setLocationListener(bVar);
                    f5682a.startLocation();
                    f5683b.postDelayed(new a(), 30000L);
                }
            } finally {
            }
        }
    }
}
