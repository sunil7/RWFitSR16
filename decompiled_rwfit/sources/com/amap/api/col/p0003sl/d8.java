package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d8 implements IBusLineSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f3900a;

    /* renamed from: b, reason: collision with root package name */
    private BusLineSearch.OnBusLineSearchListener f3901b;

    /* renamed from: c, reason: collision with root package name */
    private BusLineQuery f3902c;

    /* renamed from: d, reason: collision with root package name */
    private BusLineQuery f3903d;
    private ArrayList<BusLineResult> e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private Handler f3904f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 3;
                    obtainMessage.what = 1000;
                    x6.b bVar = new x6.b();
                    obtainMessage.obj = bVar;
                    bVar.f5348b = d8.this.f3901b;
                    bVar.f5347a = d8.this.searchBusLine();
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                }
            } finally {
                d8.this.f3904f.sendMessage(obtainMessage);
            }
        }
    }

    public d8(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f3904f = null;
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f3900a = context.getApplicationContext();
        this.f3902c = busLineQuery;
        if (busLineQuery != null) {
            this.f3903d = busLineQuery.m18clone();
        }
        this.f3904f = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public BusLineQuery getQuery() {
        return this.f3902c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public BusLineResult searchBusLine() throws AMapException {
        try {
            v6.a(this.f3900a);
            if (this.f3903d != null) {
                boolean z5 = true;
                if (this.f3902c == null ? false : !d6.a(r0.getQueryString())) {
                    if (!this.f3902c.weakEquals(this.f3903d)) {
                        this.f3903d = this.f3902c.m18clone();
                        ArrayList<BusLineResult> arrayList = this.e;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                    BusLineResult busLineResult = (BusLineResult) new i6(this.f3900a, this.f3902c.m18clone()).c();
                    this.e = new ArrayList<>();
                    int pageNumber = this.f3902c.getPageNumber();
                    if (pageNumber >= 0 || pageNumber < 0) {
                        z5 = false;
                    }
                    if (z5) {
                        this.e.set(this.f3902c.getPageNumber(), busLineResult);
                    }
                    return busLineResult;
                }
            }
            throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        } catch (AMapException e) {
            d6.a(e, "BusLineSearch", "searchBusLine");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public void searchBusLineAsyn() {
        try {
            u7.b().a(new a());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.f3901b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public void setQuery(BusLineQuery busLineQuery) {
        if (this.f3902c.weakEquals(busLineQuery)) {
            return;
        }
        this.f3902c = busLineQuery;
        this.f3903d = busLineQuery.m18clone();
    }
}
