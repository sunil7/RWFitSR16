package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.p0003sl.d8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;

/* loaded from: classes.dex */
public class BusLineSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a, reason: collision with root package name */
    private IBusLineSearch f5882a;

    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i3);
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f5882a = null;
        try {
            this.f5882a = new d8(context, busLineQuery);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof AMapException) {
                throw ((AMapException) e);
            }
        }
    }

    public BusLineQuery getQuery() {
        IBusLineSearch iBusLineSearch = this.f5882a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.getQuery();
        }
        return null;
    }

    public BusLineResult searchBusLine() throws AMapException {
        IBusLineSearch iBusLineSearch = this.f5882a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.searchBusLine();
        }
        return null;
    }

    public void searchBusLineAsyn() {
        IBusLineSearch iBusLineSearch = this.f5882a;
        if (iBusLineSearch != null) {
            iBusLineSearch.searchBusLineAsyn();
        }
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        IBusLineSearch iBusLineSearch = this.f5882a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setOnBusLineSearchListener(onBusLineSearchListener);
        }
    }

    public void setQuery(BusLineQuery busLineQuery) {
        IBusLineSearch iBusLineSearch = this.f5882a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setQuery(busLineQuery);
        }
    }
}
