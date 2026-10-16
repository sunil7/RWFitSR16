package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class f8 implements ICloudSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f4087a;

    /* renamed from: b, reason: collision with root package name */
    private CloudSearch.OnCloudSearchListener f4088b;

    /* renamed from: c, reason: collision with root package name */
    private CloudSearch.Query f4089c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Integer, CloudResult> f4090d;
    private Handler e;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CloudSearch.Query f4091a;

        public a(CloudSearch.Query query) {
            this.f4091a = query;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = FontStyle.WEIGHT_BOLD;
                    x6.e eVar = new x6.e();
                    eVar.f5354b = f8.this.f4088b;
                    obtainMessage.obj = eVar;
                    eVar.f5353a = f8.a(f8.this, this.f4091a);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                f8.this.e.sendMessage(obtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4093a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4094b;

        public b(String str, String str2) {
            this.f4093a = str;
            this.f4094b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = 701;
                    x6.d dVar = new x6.d();
                    dVar.f5352b = f8.this.f4088b;
                    obtainMessage.obj = dVar;
                    dVar.f5351a = f8.a(f8.this, this.f4093a, this.f4094b);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                f8.this.e.sendMessage(obtainMessage);
            }
        }
    }

    public f8(Context context) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4087a = context.getApplicationContext();
        this.e = x6.a();
    }

    public static CloudResult a(f8 f8Var, CloudSearch.Query query) throws AMapException {
        f8Var.getClass();
        CloudResult cloudResult = null;
        try {
            if (!f8Var.a(query)) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!query.queryEquals(f8Var.f4089c)) {
                f8Var.f4089c = query.m20clone();
                HashMap<Integer, CloudResult> hashMap = f8Var.f4090d;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            CloudResult c9 = new l6(f8Var.f4087a, query).c();
            try {
                f8Var.f4090d = new HashMap<>();
                return c9;
            } catch (Throwable th2) {
                th = th2;
                cloudResult = c9;
                d6.a(th, "CloudSearch", "searchCloud");
                if (th instanceof AMapException) {
                    throw th;
                }
                th.printStackTrace();
                return cloudResult;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public void searchCloudAsyn(CloudSearch.Query query) {
        try {
            u7.b().a(new a(query));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public void searchCloudDetailAsyn(String str, String str2) {
        try {
            u7.b().a(new b(str, str2));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.f4088b = onCloudSearchListener;
    }

    public static CloudItemDetail a(f8 f8Var, String str, String str2) throws AMapException {
        f8Var.getClass();
        if (str != null && !str.trim().equals("")) {
            if (str2 != null && !str2.trim().equals("")) {
                try {
                    return new k6(f8Var.f4087a, new h7(str, str2)).c();
                } catch (Throwable th2) {
                    d6.a(th2, "CloudSearch", "searchCloudDetail");
                    if (!(th2 instanceof AMapException)) {
                        th2.printStackTrace();
                        return null;
                    }
                    throw th2;
                }
            }
            throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        }
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }

    private boolean a(CloudSearch.Query query) {
        if (query == null || d6.a(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i3 = 0; i3 < polyGonList.size(); i3++) {
            if (polyGonList.get(i3) == null) {
                return false;
            }
        }
        return true;
    }
}
