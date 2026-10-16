package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i6<T> extends f6<T, Object> {

    /* renamed from: s, reason: collision with root package name */
    private int f4287s;

    /* renamed from: t, reason: collision with root package name */
    private List<String> f4288t;

    /* renamed from: u, reason: collision with root package name */
    private List<SuggestionCity> f4289u;

    public i6(Context context, T t8) {
        super(context, t8);
        this.f4287s = 0;
        this.f4288t = new ArrayList();
        this.f4289u = new ArrayList();
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.f4289u = u6.b(optJSONObject);
                this.f4288t = u6.c(optJSONObject);
            }
            this.f4287s = jSONObject.optInt(Const.SP_KEY_CALL_LOC_COUNT);
            if (this.f3985n instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) this.f3985n, this.f4287s, this.f4289u, this.f4288t, u6.u(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) this.f3985n, this.f4287s, this.f4289u, this.f4288t, u6.w(jSONObject));
        } catch (Exception e) {
            d6.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        T t8 = this.f3985n;
        return m6.b(this.f3987p) + "/bus/" + (t8 instanceof BusLineQuery ? ((BusLineQuery) t8).getCategory() == BusLineQuery.SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) this.f3985n).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "" : "stopname") + "?";
    }

    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuilder sb2 = new StringBuilder("output=json");
        T t8 = this.f3985n;
        if (t8 instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) t8;
            if (TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb2.append("&extensions=base");
            } else {
                sb2.append("&extensions=");
                sb2.append(busLineQuery.getExtensions());
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb2.append("&id=");
                sb2.append(d(((BusLineQuery) this.f3985n).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!u6.a(city)) {
                    String d5 = d(city);
                    sb2.append("&city=");
                    sb2.append(d5);
                }
                sb2.append("&keywords=" + d(busLineQuery.getQueryString()));
                sb2.append("&offset=" + busLineQuery.getPageSize());
                sb2.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) t8;
            String city2 = busStationQuery.getCity();
            if (!u6.a(city2)) {
                String d8 = d(city2);
                sb2.append("&city=");
                sb2.append(d8);
            }
            sb2.append("&keywords=" + d(busStationQuery.getQueryString()));
            sb2.append("&offset=" + busStationQuery.getPageSize());
            sb2.append("&page=" + busStationQuery.getPageNumber());
        }
        sb2.append("&key=" + b9.e(this.f3987p));
        return sb2.toString();
    }
}
