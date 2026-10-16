package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* loaded from: classes.dex */
public class g8 implements IDistanceSearch {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4201d = "g8";

    /* renamed from: a, reason: collision with root package name */
    private Context f4202a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f4203b;

    /* renamed from: c, reason: collision with root package name */
    private DistanceSearch.OnDistanceSearchListener f4204c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DistanceSearch.DistanceQuery f4205a;

        public a(DistanceSearch.DistanceQuery distanceQuery) {
            this.f4205a = distanceQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.what = 400;
            obtainMessage.arg1 = 16;
            Bundle bundle = new Bundle();
            DistanceResult distanceResult = null;
            try {
                try {
                    distanceResult = g8.this.calculateRouteDistance(this.f4205a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = g8.this.f4204c;
                bundle.putParcelable("result", distanceResult);
                obtainMessage.setData(bundle);
                g8.this.f4203b.sendMessage(obtainMessage);
            }
        }
    }

    public g8(Context context) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4202a = context.getApplicationContext();
        this.f4203b = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            v6.a(this.f4202a);
            if (distanceQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            DistanceSearch.DistanceQuery m27clone = distanceQuery.m27clone();
            DistanceResult c9 = new n6(this.f4202a, m27clone).c();
            if (c9 == null) {
                return c9;
            }
            c9.setDistanceQuery(m27clone);
            return c9;
        } catch (AMapException e) {
            d6.a(e, f4201d, "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery distanceQuery) {
        u7.b().a(new a(distanceQuery));
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.f4204c = onDistanceSearchListener;
    }
}
