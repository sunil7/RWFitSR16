package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class t6 extends f6<InputtipsQuery, ArrayList<Tip>> {
    public t6(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        try {
            return u6.s(new JSONObject(str));
        } catch (JSONException e) {
            d6.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/assistant/inputtips?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("output=json");
        String d5 = d(((InputtipsQuery) this.f3985n).getKeyword());
        if (!TextUtils.isEmpty(d5)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(d5);
        }
        String city = ((InputtipsQuery) this.f3985n).getCity();
        if (!u6.a(city)) {
            String d8 = d(city);
            stringBuffer.append("&city=");
            stringBuffer.append(d8);
        }
        String type = ((InputtipsQuery) this.f3985n).getType();
        if (!u6.a(type)) {
            String d10 = d(type);
            stringBuffer.append("&type=");
            stringBuffer.append(d10);
        }
        if (((InputtipsQuery) this.f3985n).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.f3985n).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(Const.STR_MART_COMMA);
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(b9.e(this.f3987p));
        return stringBuffer.toString();
    }
}
