package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.col.p0003sl.a;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;

    /* renamed from: a, reason: collision with root package name */
    Context f5595a;

    /* renamed from: b, reason: collision with root package name */
    a f5596b;

    public GeoFenceClient(Context context) {
        this.f5595a = null;
        this.f5596b = null;
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            Context applicationContext = context.getApplicationContext();
            this.f5595a = applicationContext;
            this.f5596b = a(applicationContext);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "<init>");
        }
    }

    public a a(Context context) {
        return new a(context);
    }

    public void addGeoFence(DPoint dPoint, float f2, String str) {
        try {
            this.f5596b.a(dPoint, f2, str);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "addGeoFence round");
        }
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.f5596b.a(str);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.f5596b.e();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.f5596b.h();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.f5596b.j();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.f5596b.k();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "removeGeoFence");
        }
    }

    public void resumeGeoFence() {
        try {
            this.f5596b.l();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i3) {
        try {
            this.f5596b.c(i3);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z5) {
        try {
            this.f5596b.a(str, z5);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.f5596b.a(geoFenceListener);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void setLocationClientOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f5596b.a(aMapLocationClientOption);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.f5596b.a(list, str);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.f5596b.b(geoFence);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f2, int i3, String str3) {
        try {
            this.f5596b.a(str, str2, dPoint, f2, i3, str3);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i3, String str4) {
        try {
            this.f5596b.a(str, str2, str3, i3, str4);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.f5596b.a(str, str2);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceClient", "addGeoFence district");
        }
    }
}
