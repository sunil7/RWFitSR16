package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class m8 implements IPoiSearchV2 {

    /* renamed from: i, reason: collision with root package name */
    private static HashMap<Integer, PoiResultV2> f4580i;

    /* renamed from: a, reason: collision with root package name */
    private PoiSearchV2.SearchBound f4581a;

    /* renamed from: b, reason: collision with root package name */
    private PoiSearchV2.Query f4582b;

    /* renamed from: c, reason: collision with root package name */
    private Context f4583c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearchV2.OnPoiSearchListener f4584d;
    private String e = "zh-CN";

    /* renamed from: f, reason: collision with root package name */
    private PoiSearchV2.Query f4585f;

    /* renamed from: g, reason: collision with root package name */
    private PoiSearchV2.SearchBound f4586g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f4587h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = m8.this.f4587h.obtainMessage();
            obtainMessage.arg1 = 19;
            obtainMessage.what = 603;
            Bundle bundle = new Bundle();
            PoiResultV2 poiResultV2 = null;
            try {
                poiResultV2 = m8.this.searchPOI();
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e) {
                bundle.putInt("errorCode", e.getErrorCode());
            } finally {
                x6.k kVar = new x6.k();
                kVar.f5366b = m8.this.f4584d;
                kVar.f5365a = poiResultV2;
                obtainMessage.obj = kVar;
                obtainMessage.setData(bundle);
                m8.this.f4587h.sendMessage(obtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4589a;

        public b(String str) {
            this.f4589a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.arg1 = 19;
            obtainMessage.what = 604;
            Bundle bundle = new Bundle();
            PoiItemV2 poiItemV2 = null;
            try {
                poiItemV2 = m8.this.searchPOIId(this.f4589a);
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e) {
                d6.a(e, "PoiSearch", "searchPOIIdAsyn");
                bundle.putInt("errorCode", e.getErrorCode());
            } finally {
                x6.i iVar = new x6.i();
                iVar.f5362b = m8.this.f4584d;
                iVar.f5361a = poiItemV2;
                obtainMessage.obj = iVar;
                obtainMessage.setData(bundle);
                m8.this.f4587h.sendMessage(obtainMessage);
            }
        }
    }

    public m8(Context context, PoiSearchV2.Query query) throws AMapException {
        this.f4587h = null;
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4583c = context.getApplicationContext();
        setQuery(query);
        this.f4587h = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public PoiSearchV2.SearchBound getBound() {
        return this.f4581a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public String getLanguage() {
        return this.e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public PoiSearchV2.Query getQuery() {
        return this.f4582b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public PoiResultV2 searchPOI() throws AMapException {
        PoiSearchV2.Query query;
        try {
            v6.a(this.f4583c);
            PoiSearchV2.SearchBound searchBound = this.f4581a;
            if ((searchBound == null || !searchBound.getShape().equals("Bound")) && ((query = this.f4582b) == null || (d6.a(query.getQueryString()) && d6.a(this.f4582b.getCategory())))) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!a()) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            PoiSearchV2.Query query2 = this.f4582b;
            if (query2 == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if ((!query2.queryEquals(this.f4585f) && this.f4581a == null) || (!this.f4582b.queryEquals(this.f4585f) && !this.f4581a.equals(this.f4586g))) {
                this.f4585f = this.f4582b.m25clone();
                PoiSearchV2.SearchBound searchBound2 = this.f4581a;
                if (searchBound2 != null) {
                    this.f4586g = searchBound2.m26clone();
                }
                HashMap<Integer, PoiResultV2> hashMap = f4580i;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            PoiSearchV2.SearchBound searchBound3 = this.f4581a;
            PoiSearchV2.SearchBound m26clone = searchBound3 != null ? searchBound3.m26clone() : null;
            o7.a().a(this.f4582b.getQueryString());
            this.f4582b.setPageNum(o7.a().a(this.f4582b.getPageNum()));
            this.f4582b.setPageSize(o7.a().b(this.f4582b.getPageSize()));
            PoiResultV2 c9 = new f7(this.f4583c, new j7(this.f4582b.m25clone(), m26clone)).c();
            f4580i = new HashMap<>();
            return c9;
        } catch (AMapException e) {
            d6.a(e, "PoiSearch", "searchPOI");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void searchPOIAsyn() {
        try {
            u7.b().a(new a());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public PoiItemV2 searchPOIId(String str) throws AMapException {
        v6.a(this.f4583c);
        PoiSearchV2.Query query = this.f4582b;
        return new d7(this.f4583c, str, query != null ? query.m25clone() : null).c();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void searchPOIIdAsyn(String str) {
        u7.b().a(new b(str));
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void setBound(PoiSearchV2.SearchBound searchBound) {
        this.f4581a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void setOnPoiSearchListener(PoiSearchV2.OnPoiSearchListener onPoiSearchListener) {
        this.f4584d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void setQuery(PoiSearchV2.Query query) {
        this.f4582b = query;
    }

    private boolean a() {
        PoiSearchV2.SearchBound searchBound = this.f4581a;
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
