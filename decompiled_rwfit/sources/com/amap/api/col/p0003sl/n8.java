package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* loaded from: classes.dex */
public class n8 implements IRoutePOISearch {

    /* renamed from: a, reason: collision with root package name */
    private RoutePOISearchQuery f4699a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4700b;

    /* renamed from: c, reason: collision with root package name */
    private RoutePOISearch.OnRoutePOISearchListener f4701c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f4702d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = n8.this.f4702d.obtainMessage();
            obtainMessage.arg1 = 14;
            Bundle bundle = new Bundle();
            RoutePOISearchResult routePOISearchResult = null;
            try {
                routePOISearchResult = n8.this.searchRoutePOI();
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e) {
                bundle.putInt("errorCode", e.getErrorCode());
            } finally {
                x6.m mVar = new x6.m();
                mVar.f5370b = n8.this.f4701c;
                mVar.f5369a = routePOISearchResult;
                obtainMessage.obj = mVar;
                obtainMessage.setData(bundle);
                n8.this.f4702d.sendMessage(obtainMessage);
            }
        }
    }

    public n8(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        this.f4702d = null;
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4700b = context;
        this.f4699a = routePOISearchQuery;
        this.f4702d = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public RoutePOISearchQuery getQuery() {
        return this.f4699a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            v6.a(this.f4700b);
            RoutePOISearchQuery routePOISearchQuery = this.f4699a;
            if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null || (this.f4699a.getFrom() == null && this.f4699a.getTo() == null && this.f4699a.getPolylines() == null)) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            return new s7(this.f4700b, this.f4699a.m40clone()).c();
        } catch (AMapException e) {
            d6.a(e, "RoutePOISearchCore", "searchRoutePOI");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public void searchRoutePOIAsyn() {
        u7.b().a(new a());
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.f4699a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.f4701c = onRoutePOISearchListener;
    }
}
