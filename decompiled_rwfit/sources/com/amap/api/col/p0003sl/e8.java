package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class e8 implements IBusStationSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f3993a;

    /* renamed from: b, reason: collision with root package name */
    private BusStationSearch.OnBusStationSearchListener f3994b;

    /* renamed from: c, reason: collision with root package name */
    private BusStationQuery f3995c;

    /* renamed from: d, reason: collision with root package name */
    private BusStationQuery f3996d;
    private ArrayList<BusStationResult> e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private int f3997f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f3998g;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 7;
                    x6.c cVar = new x6.c();
                    cVar.f5350b = e8.this.f3994b;
                    obtainMessage.obj = cVar;
                    BusStationResult searchBusStation = e8.this.searchBusStation();
                    obtainMessage.what = 1000;
                    cVar.f5349a = searchBusStation;
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                }
            } finally {
                e8.this.f3998g.sendMessage(obtainMessage);
            }
        }
    }

    public e8(Context context, BusStationQuery busStationQuery) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f3993a = context.getApplicationContext();
        this.f3995c = busStationQuery;
        this.f3998g = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public BusStationQuery getQuery() {
        return this.f3995c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public BusStationResult searchBusStation() throws AMapException {
        try {
            v6.a(this.f3993a);
            boolean z5 = true;
            if (!(this.f3995c == null ? false : !d6.a(r2.getQueryString()))) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            if (!this.f3995c.weakEquals(this.f3996d)) {
                this.f3996d = this.f3995c.m19clone();
                this.f3997f = 0;
                ArrayList<BusStationResult> arrayList = this.e;
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            if (this.f3997f == 0) {
                BusStationResult busStationResult = (BusStationResult) new i6(this.f3993a, this.f3995c).c();
                this.f3997f = busStationResult.getPageCount();
                a(busStationResult);
                return busStationResult;
            }
            int pageNumber = this.f3995c.getPageNumber();
            if (pageNumber > this.f3997f || pageNumber < 0) {
                z5 = false;
            }
            if (!z5) {
                throw new IllegalArgumentException("page out of range");
            }
            BusStationResult busStationResult2 = this.e.get(pageNumber);
            if (busStationResult2 != null) {
                return busStationResult2;
            }
            BusStationResult busStationResult3 = (BusStationResult) new i6(this.f3993a, this.f3995c).c();
            this.e.set(this.f3995c.getPageNumber(), busStationResult3);
            return busStationResult3;
        } catch (AMapException e) {
            d6.a(e, "BusStationSearch", "searchBusStation");
            throw new AMapException(e.getErrorMessage());
        } catch (Throwable th2) {
            d6.a(th2, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public void searchBusStationAsyn() {
        try {
            u7.b().a(new a());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.f3994b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public void setQuery(BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.f3995c)) {
            return;
        }
        this.f3995c = busStationQuery;
    }

    private void a(BusStationResult busStationResult) {
        int i3;
        this.e = new ArrayList<>();
        int i10 = 0;
        while (true) {
            i3 = this.f3997f;
            if (i10 > i3) {
                break;
            }
            this.e.add(null);
            i10++;
        }
        if (i3 > 0) {
            this.e.set(this.f3995c.getPageNumber(), busStationResult);
        }
    }
}
