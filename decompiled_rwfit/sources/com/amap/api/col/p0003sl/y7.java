package com.amap.api.col.p0003sl;

import android.content.Context;
import android.support.v4.media.session.e;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y7 extends a8<WeatherSearchQuery, LocalWeatherForecast> {

    /* renamed from: s, reason: collision with root package name */
    private LocalWeatherForecast f5464s;

    public y7(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.f5464s = new LocalWeatherForecast();
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        LocalWeatherForecast localWeatherForecast;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("forecasts")) {
                localWeatherForecast = new LocalWeatherForecast();
                JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
                if (jSONArray != null && jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    if (optJSONObject != null) {
                        localWeatherForecast.setCity(u6.d(optJSONObject, "city"));
                        localWeatherForecast.setAdCode(u6.d(optJSONObject, Const.JSON_KEY_ADCODE));
                        localWeatherForecast.setProvince(u6.d(optJSONObject, "province"));
                        localWeatherForecast.setReportTime(u6.d(optJSONObject, "reporttime"));
                        if (optJSONObject.has("casts")) {
                            ArrayList arrayList = new ArrayList();
                            JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                                    if (optJSONObject2 != null) {
                                        localDayWeatherForecast.setDate(u6.d(optJSONObject2, "date"));
                                        localDayWeatherForecast.setWeek(u6.d(optJSONObject2, "week"));
                                        localDayWeatherForecast.setDayWeather(u6.d(optJSONObject2, "dayweather"));
                                        localDayWeatherForecast.setNightWeather(u6.d(optJSONObject2, "nightweather"));
                                        localDayWeatherForecast.setDayTemp(u6.d(optJSONObject2, "daytemp"));
                                        localDayWeatherForecast.setNightTemp(u6.d(optJSONObject2, "nighttemp"));
                                        localDayWeatherForecast.setDayWindDirection(u6.d(optJSONObject2, "daywind"));
                                        localDayWeatherForecast.setNightWindDirection(u6.d(optJSONObject2, "nightwind"));
                                        localDayWeatherForecast.setDayWindPower(u6.d(optJSONObject2, "daypower"));
                                        localDayWeatherForecast.setNightWindPower(u6.d(optJSONObject2, "nightpower"));
                                        arrayList.add(localDayWeatherForecast);
                                    }
                                }
                                localWeatherForecast.setWeatherForecast(arrayList);
                            }
                            localWeatherForecast.setWeatherForecast(arrayList);
                        }
                    }
                }
            } else {
                localWeatherForecast = null;
            }
            this.f5464s = localWeatherForecast;
            return localWeatherForecast;
        } catch (JSONException e) {
            throw e.b(e, "JSONHelper", "WeatherForecastResult", AMapException.AMAP_CLIENT_ERROR_PROTOCOL);
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/weather/weatherInfo?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("output=json");
        String city = ((WeatherSearchQuery) this.f3985n).getCity();
        if (!u6.a(city)) {
            String d5 = d(city);
            stringBuffer.append("&city=");
            stringBuffer.append(d5);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + b9.e(this.f3987p));
        return stringBuffer.toString();
    }

    public Object i() {
        return this.f3985n;
    }
}
