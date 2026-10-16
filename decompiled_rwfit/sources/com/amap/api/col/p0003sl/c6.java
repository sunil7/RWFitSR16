package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c6 extends f6<AutoTSearch.Query, AutoTChargeStationResult> {

    /* renamed from: s, reason: collision with root package name */
    private b6 f3810s;

    public c6(Context context, AutoTSearch.Query query) {
        super(context, query);
        this.f3810s = null;
        this.f3810s = new b6(context);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        try {
            return d6.b(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        try {
            String a3 = x.a(new HashMap(), ((AutoTSearch.Query) this.f3985n).getAccessKey());
            return m6.a(this.f3987p) + "/ws/mapapi/poi/infolite/auto?" + a3 + "&Signature=" + x.a(Constants.HTTP_POST, a3, ((AutoTSearch.Query) this.f3985n).getSecretKey());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuilder sb2 = new StringBuilder(this.f3810s.a());
        String adCode = ((AutoTSearch.Query) this.f3985n).getAdCode();
        if (!TextUtils.isEmpty(adCode)) {
            sb2.append("&adcode=");
            sb2.append(d(adCode));
        }
        String city = ((AutoTSearch.Query) this.f3985n).getCity();
        if (!TextUtils.isEmpty(city)) {
            sb2.append("&city=");
            sb2.append(d(city));
        }
        String dataType = ((AutoTSearch.Query) this.f3985n).getDataType();
        if (!TextUtils.isEmpty(dataType)) {
            sb2.append("&data_type=");
            sb2.append(d(dataType));
        }
        String geoObj = ((AutoTSearch.Query) this.f3985n).getGeoObj();
        if (!TextUtils.isEmpty(geoObj)) {
            sb2.append("&geoobj=");
            sb2.append(d(geoObj));
        }
        String keywords = ((AutoTSearch.Query) this.f3985n).getKeywords();
        if (!TextUtils.isEmpty(keywords)) {
            sb2.append("&keywords=");
            sb2.append(d(keywords));
        }
        sb2.append("&pagenum=");
        sb2.append(((AutoTSearch.Query) this.f3985n).getPageNum());
        sb2.append("&pagesize=");
        sb2.append(((AutoTSearch.Query) this.f3985n).getPageSize());
        sb2.append("&qii=");
        sb2.append(((AutoTSearch.Query) this.f3985n).isQii());
        String queryType = ((AutoTSearch.Query) this.f3985n).getQueryType();
        if (!TextUtils.isEmpty(queryType)) {
            sb2.append("&query_type=");
            sb2.append(d(queryType));
        }
        sb2.append("&range=");
        sb2.append(((AutoTSearch.Query) this.f3985n).getRange());
        LatLonPoint latLonPoint = ((AutoTSearch.Query) this.f3985n).getLatLonPoint();
        if (latLonPoint != null) {
            sb2.append("&longitude=");
            sb2.append(latLonPoint.getLongitude());
            sb2.append("&latitude=");
            sb2.append(latLonPoint.getLatitude());
        }
        String userLoc = ((AutoTSearch.Query) this.f3985n).getUserLoc();
        if (!TextUtils.isEmpty(userLoc)) {
            sb2.append("&user_loc=");
            sb2.append(d(userLoc));
        }
        String userCity = ((AutoTSearch.Query) this.f3985n).getUserCity();
        if (!TextUtils.isEmpty(userCity)) {
            sb2.append("&user_city=");
            sb2.append(d(userCity));
        }
        AutoTSearch.FilterBox filterBox = ((AutoTSearch.Query) this.f3985n).getFilterBox();
        if (filterBox != null) {
            String retainState = filterBox.getRetainState();
            if (!TextUtils.isEmpty(retainState)) {
                sb2.append("&retain_state=");
                sb2.append(d(retainState));
            }
            String checkedLevel = filterBox.getCheckedLevel();
            if (!TextUtils.isEmpty(checkedLevel)) {
                sb2.append("&checked_level=");
                sb2.append(d(checkedLevel));
            }
            String classifyV2Data = filterBox.getClassifyV2Data();
            if (!TextUtils.isEmpty(classifyV2Data)) {
                sb2.append("&classify_v2_data=");
                sb2.append(d(classifyV2Data));
            }
            String classifyV2Level2Data = filterBox.getClassifyV2Level2Data();
            if (!TextUtils.isEmpty(classifyV2Level2Data)) {
                sb2.append("&classify_v2_level2_data=");
                sb2.append(d(classifyV2Level2Data));
            }
            String classifyV2Level3Data = filterBox.getClassifyV2Level3Data();
            if (!TextUtils.isEmpty(classifyV2Level3Data)) {
                sb2.append("&classify_v2_level3_data=");
                sb2.append(d(classifyV2Level3Data));
            }
        }
        return sb2.toString();
    }
}
