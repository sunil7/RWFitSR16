package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IAutoTSearch;
import com.autonavi.base.ae.gmap.glyph.FontStyle;

/* loaded from: classes.dex */
public class c8 implements IAutoTSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f3812a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f3813b;

    /* renamed from: c, reason: collision with root package name */
    private AutoTSearch.Query f3814c;

    /* renamed from: d, reason: collision with root package name */
    private AutoTSearch.OnChargeStationListener f3815d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = c8.this.f3813b.obtainMessage();
            obtainMessage.arg1 = 20;
            obtainMessage.what = FontStyle.WEIGHT_SEMI_BOLD;
            Bundle bundle = new Bundle();
            AutoTChargeStationResult autoTChargeStationResult = null;
            try {
                autoTChargeStationResult = c8.this.searchChargeStation();
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e) {
                bundle.putInt("errorCode", e.getErrorCode());
            } finally {
                x6.a aVar = new x6.a();
                aVar.f5346b = c8.this.f3815d;
                aVar.f5345a = autoTChargeStationResult;
                obtainMessage.obj = aVar;
                obtainMessage.setData(bundle);
                c8.this.f3813b.sendMessage(obtainMessage);
            }
        }
    }

    public c8(Context context) throws AMapException {
        this.f3813b = null;
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f3812a = context.getApplicationContext();
        this.f3813b = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public AutoTChargeStationResult searchChargeStation() throws AMapException {
        try {
            v6.a(this.f3812a);
            AutoTSearch.Query query = this.f3814c;
            if (query != null) {
                return new c6(this.f3812a, query.m17clone()).c();
            }
            throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        } catch (AMapException e) {
            throw new AMapException(e.getMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public void searchChargeStationAsync() {
        try {
            u7.b().a(new a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener) {
        this.f3815d = onChargeStationListener;
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public void setQuery(AutoTSearch.Query query) {
        this.f3814c = query;
    }
}
