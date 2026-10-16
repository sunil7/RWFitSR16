package com.amap.api.col.p0003sl;

import android.content.Context;
import android.support.v4.media.session.e;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.autonavi.aps.amapapi.config.Const;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class z7 extends a8<WeatherSearchQuery, LocalWeatherLive> {

    /* renamed from: s, reason: collision with root package name */
    private LocalWeatherLive f5569s;

    public z7(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.f5569s = new LocalWeatherLive();
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        LocalWeatherLive localWeatherLive;
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("lives")) {
                localWeatherLive = new LocalWeatherLive();
                JSONArray optJSONArray = jSONObject.optJSONArray("lives");
                if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                    localWeatherLive.setAdCode(u6.d(optJSONObject, Const.JSON_KEY_ADCODE));
                    localWeatherLive.setProvince(u6.d(optJSONObject, "province"));
                    localWeatherLive.setCity(u6.d(optJSONObject, "city"));
                    localWeatherLive.setWeather(u6.d(optJSONObject, "weather"));
                    localWeatherLive.setTemperature(u6.d(optJSONObject, "temperature"));
                    localWeatherLive.setWindDirection(u6.d(optJSONObject, "winddirection"));
                    localWeatherLive.setWindPower(u6.d(optJSONObject, "windpower"));
                    localWeatherLive.setHumidity(u6.d(optJSONObject, "humidity"));
                    localWeatherLive.setReportTime(u6.d(optJSONObject, "reporttime"));
                }
            } else {
                localWeatherLive = null;
            }
            this.f5569s = localWeatherLive;
            return localWeatherLive;
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
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + b9.e(this.f3987p));
        return stringBuffer.toString();
    }

    public Object i() {
        return this.f3985n;
    }
}
