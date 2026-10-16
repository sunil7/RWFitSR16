package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.col.p0003sl.r8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;

/* loaded from: classes.dex */
public class WeatherSearch {

    /* renamed from: a, reason: collision with root package name */
    private IWeatherSearch f6554a;

    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i3);

        void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i3);
    }

    public WeatherSearch(Context context) throws AMapException {
        this.f6554a = null;
        try {
            this.f6554a = new r8(context);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof AMapException) {
                throw ((AMapException) e);
            }
        }
    }

    public WeatherSearchQuery getQuery() {
        IWeatherSearch iWeatherSearch = this.f6554a;
        if (iWeatherSearch != null) {
            return iWeatherSearch.getQuery();
        }
        return null;
    }

    public void searchWeatherAsyn() {
        IWeatherSearch iWeatherSearch = this.f6554a;
        if (iWeatherSearch != null) {
            iWeatherSearch.searchWeatherAsyn();
        }
    }

    public void setOnWeatherSearchListener(OnWeatherSearchListener onWeatherSearchListener) {
        IWeatherSearch iWeatherSearch = this.f6554a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setOnWeatherSearchListener(onWeatherSearchListener);
        }
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        IWeatherSearch iWeatherSearch = this.f6554a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setQuery(weatherSearchQuery);
        }
    }
}
