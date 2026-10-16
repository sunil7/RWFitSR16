package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* loaded from: classes.dex */
public class r8 implements IWeatherSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f4949a;

    /* renamed from: b, reason: collision with root package name */
    private WeatherSearchQuery f4950b;

    /* renamed from: c, reason: collision with root package name */
    private WeatherSearch.OnWeatherSearchListener f4951c;

    /* renamed from: d, reason: collision with root package name */
    private LocalWeatherLiveResult f4952d;
    private LocalWeatherForecastResult e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f4953f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.arg1 = 13;
            Bundle bundle = new Bundle();
            if (r8.this.f4950b == null) {
                try {
                    throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
                } catch (AMapException e) {
                    d6.a(e, "WeatherSearch", "searchWeatherAsyn");
                    return;
                }
            }
            if (r8.this.f4950b.getType() == 1) {
                try {
                    r8 r8Var = r8.this;
                    r8Var.f4952d = r8.c(r8Var);
                    bundle.putInt("errorCode", 1000);
                    return;
                } catch (AMapException e10) {
                    bundle.putInt("errorCode", e10.getErrorCode());
                    d6.a(e10, "WeatherSearch", "searchWeatherAsyn");
                    return;
                } catch (Throwable th2) {
                    d6.a(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                    return;
                } finally {
                    x6.o oVar = new x6.o();
                    obtainMessage.what = 1301;
                    oVar.f5374b = r8.this.f4951c;
                    oVar.f5373a = r8.this.f4952d;
                    obtainMessage.obj = oVar;
                    obtainMessage.setData(bundle);
                    r8.this.f4953f.sendMessage(obtainMessage);
                }
            }
            if (r8.this.f4950b.getType() == 2) {
                try {
                    r8 r8Var2 = r8.this;
                    r8Var2.e = r8.g(r8Var2);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e11) {
                    bundle.putInt("errorCode", e11.getErrorCode());
                    d6.a(e11, "WeatherSearch", "searchWeatherAsyn");
                } catch (Throwable th3) {
                    d6.a(th3, "WeatherSearch", "searchWeatherAnsyThrowable");
                } finally {
                    x6.n nVar = new x6.n();
                    obtainMessage.what = 1302;
                    nVar.f5372b = r8.this.f4951c;
                    nVar.f5371a = r8.this.e;
                    obtainMessage.obj = nVar;
                    obtainMessage.setData(bundle);
                    r8.this.f4953f.sendMessage(obtainMessage);
                }
            }
        }
    }

    public r8(Context context) throws AMapException {
        this.f4953f = null;
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4949a = context.getApplicationContext();
        this.f4953f = x6.a();
    }

    public static LocalWeatherLiveResult c(r8 r8Var) throws AMapException {
        v6.a(r8Var.f4949a);
        WeatherSearchQuery weatherSearchQuery = r8Var.f4950b;
        if (weatherSearchQuery == null) {
            throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        }
        z7 z7Var = new z7(r8Var.f4949a, weatherSearchQuery);
        return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) z7Var.i(), z7Var.c());
    }

    public static LocalWeatherForecastResult g(r8 r8Var) throws AMapException {
        v6.a(r8Var.f4949a);
        WeatherSearchQuery weatherSearchQuery = r8Var.f4950b;
        if (weatherSearchQuery == null) {
            throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        }
        y7 y7Var = new y7(r8Var.f4949a, weatherSearchQuery);
        return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) y7Var.i(), y7Var.c());
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public WeatherSearchQuery getQuery() {
        return this.f4950b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public void searchWeatherAsyn() {
        try {
            u7.b().a(new a());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.f4951c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.f4950b = weatherSearchQuery;
    }
}
