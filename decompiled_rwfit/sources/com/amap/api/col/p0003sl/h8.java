package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

/* loaded from: classes.dex */
public class h8 implements IDistrictSearch {

    /* renamed from: g, reason: collision with root package name */
    private static HashMap<Integer, DistrictResult> f4261g;

    /* renamed from: a, reason: collision with root package name */
    private Context f4262a;

    /* renamed from: b, reason: collision with root package name */
    private DistrictSearchQuery f4263b;

    /* renamed from: c, reason: collision with root package name */
    private DistrictSearch.OnDistrictSearchListener f4264c;

    /* renamed from: d, reason: collision with root package name */
    private DistrictSearchQuery f4265d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f4266f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            DistrictResult districtResult = new DistrictResult();
            districtResult.setQuery(h8.this.f4263b);
            try {
                try {
                    try {
                        districtResult = h8.this.searchDistrict();
                        if (districtResult != null) {
                            districtResult.setAMapException(new AMapException());
                        }
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = h8.this.f4264c;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle);
                        if (h8.this.f4266f == null) {
                            return;
                        }
                    } catch (AMapException e) {
                        districtResult.setAMapException(e);
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = h8.this.f4264c;
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle2);
                        if (h8.this.f4266f == null) {
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    d6.a(th2, "DistrictSearch", "searchDistrictAnsyThrowable");
                    obtainMessage.arg1 = 4;
                    obtainMessage.obj = h8.this.f4264c;
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("result", districtResult);
                    obtainMessage.setData(bundle3);
                    if (h8.this.f4266f == null) {
                        return;
                    }
                }
                h8.this.f4266f.sendMessage(obtainMessage);
            } catch (Throwable th3) {
                obtainMessage.arg1 = 4;
                obtainMessage.obj = h8.this.f4264c;
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable("result", districtResult);
                obtainMessage.setData(bundle4);
                if (h8.this.f4266f != null) {
                    h8.this.f4266f.sendMessage(obtainMessage);
                }
                throw th3;
            }
        }
    }

    public h8(Context context) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4262a = context.getApplicationContext();
        this.f4266f = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public DistrictSearchQuery getQuery() {
        return this.f4263b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public DistrictResult searchDistrict() throws AMapException {
        int i3;
        int i10;
        try {
            DistrictResult districtResult = new DistrictResult();
            v6.a(this.f4262a);
            if (this.f4263b == null) {
                this.f4263b = new DistrictSearchQuery();
            }
            districtResult.setQuery(this.f4263b.m22clone());
            if (!this.f4263b.weakEquals(this.f4265d)) {
                this.e = 0;
                this.f4265d = this.f4263b.m22clone();
                HashMap<Integer, DistrictResult> hashMap = f4261g;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            if (this.e == 0) {
                DistrictResult c9 = new o6(this.f4262a, this.f4263b.m22clone()).c();
                if (c9 == null) {
                    return c9;
                }
                this.e = c9.getPageCount();
                f4261g = new HashMap<>();
                DistrictSearchQuery districtSearchQuery = this.f4263b;
                if (districtSearchQuery != null && (i10 = this.e) > 0 && i10 > districtSearchQuery.getPageNum()) {
                    f4261g.put(Integer.valueOf(this.f4263b.getPageNum()), c9);
                }
                return c9;
            }
            int pageNum = this.f4263b.getPageNum();
            if (pageNum >= this.e || pageNum < 0) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            DistrictResult districtResult2 = f4261g.get(Integer.valueOf(pageNum));
            if (districtResult2 == null) {
                districtResult2 = new o6(this.f4262a, this.f4263b.m22clone()).c();
                DistrictSearchQuery districtSearchQuery2 = this.f4263b;
                if (districtSearchQuery2 != null && districtResult2 != null && (i3 = this.e) > 0 && i3 > districtSearchQuery2.getPageNum()) {
                    f4261g.put(Integer.valueOf(this.f4263b.getPageNum()), districtResult2);
                }
            }
            return districtResult2;
        } catch (AMapException e) {
            d6.a(e, "DistrictSearch", "searchDistrict");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void searchDistrictAnsy() {
        try {
            u7.b().a(new a());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void searchDistrictAsyn() {
        try {
            u7.b().a(new a());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.f4264c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f4263b = districtSearchQuery;
    }
}
