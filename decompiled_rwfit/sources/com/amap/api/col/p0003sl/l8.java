package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class l8 implements IPoiSearch {

    /* renamed from: i, reason: collision with root package name */
    private static HashMap<Integer, PoiResult> f4479i;

    /* renamed from: a, reason: collision with root package name */
    private PoiSearch.SearchBound f4480a;

    /* renamed from: b, reason: collision with root package name */
    private PoiSearch.Query f4481b;

    /* renamed from: c, reason: collision with root package name */
    private Context f4482c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearch.OnPoiSearchListener f4483d;
    private String e = "zh-CN";

    /* renamed from: f, reason: collision with root package name */
    private PoiSearch.Query f4484f;

    /* renamed from: g, reason: collision with root package name */
    private PoiSearch.SearchBound f4485g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f4486h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = l8.this.f4486h.obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = FontStyle.WEIGHT_SEMI_BOLD;
            Bundle bundle = new Bundle();
            PoiResult poiResult = null;
            try {
                poiResult = l8.this.searchPOI();
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e) {
                bundle.putInt("errorCode", e.getErrorCode());
            } finally {
                x6.j jVar = new x6.j();
                jVar.f5364b = l8.this.f4483d;
                jVar.f5363a = poiResult;
                obtainMessage.obj = jVar;
                obtainMessage.setData(bundle);
                l8.this.f4486h.sendMessage(obtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4488a;

        public b(String str) {
            this.f4488a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = 602;
            Bundle bundle = new Bundle();
            PoiItem poiItem = null;
            try {
                poiItem = l8.this.searchPOIId(this.f4488a);
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e) {
                d6.a(e, "PoiSearch", "searchPOIIdAsyn");
                bundle.putInt("errorCode", e.getErrorCode());
            } finally {
                x6.h hVar = new x6.h();
                hVar.f5360b = l8.this.f4483d;
                hVar.f5359a = poiItem;
                obtainMessage.obj = hVar;
                obtainMessage.setData(bundle);
                l8.this.f4486h.sendMessage(obtainMessage);
            }
        }
    }

    public l8(Context context, PoiSearch.Query query) throws AMapException {
        this.f4486h = null;
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4482c = context.getApplicationContext();
        setQuery(query);
        this.f4486h = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiSearch.SearchBound getBound() {
        return this.f4480a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public String getLanguage() {
        return this.e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiSearch.Query getQuery() {
        return this.f4481b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiResult searchPOI() throws AMapException {
        PoiSearch.Query query;
        try {
            v6.a(this.f4482c);
            PoiSearch.SearchBound searchBound = this.f4480a;
            if ((searchBound == null || !searchBound.getShape().equals("Bound")) && ((query = this.f4481b) == null || (d6.a(query.getQueryString()) && d6.a(this.f4481b.getCategory())))) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a()) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            PoiSearch.Query query2 = this.f4481b;
            if (query2 == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if ((!query2.queryEquals(this.f4484f) && this.f4480a == null) || (!this.f4481b.queryEquals(this.f4484f) && !this.f4480a.equals(this.f4485g))) {
                this.f4484f = this.f4481b.m23clone();
                PoiSearch.SearchBound searchBound2 = this.f4480a;
                if (searchBound2 != null) {
                    this.f4485g = searchBound2.m24clone();
                }
                HashMap<Integer, PoiResult> hashMap = f4479i;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            PoiSearch.SearchBound searchBound3 = this.f4480a;
            PoiSearch.SearchBound m24clone = searchBound3 != null ? searchBound3.m24clone() : null;
            o7.a().a(this.f4481b.getQueryString());
            this.f4481b.setPageNum(o7.a().a(this.f4481b.getPageNum()));
            this.f4481b.setPageSize(o7.a().b(this.f4481b.getPageSize()));
            PoiResult c9 = new e7(this.f4482c, new i7(this.f4481b.m23clone(), m24clone)).c();
            f4479i = new HashMap<>();
            return c9;
        } catch (AMapException e) {
            d6.a(e, "PoiSearch", "searchPOI");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void searchPOIAsyn() {
        try {
            u7.b().a(new a());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiItem searchPOIId(String str) throws AMapException {
        v6.a(this.f4482c);
        PoiSearch.Query query = this.f4481b;
        return new c7(this.f4482c, str, query != null ? query.m23clone() : null).c();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void searchPOIIdAsyn(String str) {
        u7.b().a(new b(str));
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setBound(PoiSearch.SearchBound searchBound) {
        this.f4480a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.f4483d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setQuery(PoiSearch.Query query) {
        this.f4481b = query;
    }

    private boolean a() {
        PoiSearch.SearchBound searchBound = this.f4480a;
        if (searchBound == null) {
            return true;
        }
        if (searchBound.getShape().equals("Bound")) {
            return searchBound.getCenter() != null;
        }
        if (!searchBound.getShape().equals("Polygon")) {
            if (!searchBound.getShape().equals("Rectangle")) {
                return true;
            }
            LatLonPoint lowerLeft = searchBound.getLowerLeft();
            LatLonPoint upperRight = searchBound.getUpperRight();
            return lowerLeft != null && upperRight != null && lowerLeft.getLatitude() < upperRight.getLatitude() && lowerLeft.getLongitude() < upperRight.getLongitude();
        }
        List<LatLonPoint> polyGonList = searchBound.getPolyGonList();
        if (polyGonList == null || polyGonList.size() == 0) {
            return false;
        }
        for (int i3 = 0; i3 < polyGonList.size(); i3++) {
            if (polyGonList.get(i3) == null) {
                return false;
            }
        }
        return true;
    }
}
