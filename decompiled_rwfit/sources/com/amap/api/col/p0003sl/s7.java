package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class s7 extends f6<RoutePOISearchQuery, RoutePOISearchResult> {
    public s7(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        try {
            arrayList = u6.r(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new RoutePOISearchResult(arrayList, (RoutePOISearchQuery) this.f3985n);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.b(this.f3987p) + "/place/route?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        String str;
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f3987p));
        stringBuffer.append("&range=");
        stringBuffer.append("" + ((RoutePOISearchQuery) this.f3985n).getRange());
        switch (((RoutePOISearchQuery) this.f3985n).getSearchType()) {
            case TypeGasStation:
                str = "010100";
                break;
            case TypeMaintenanceStation:
                str = "030000";
                break;
            case TypeATM:
                str = "160300";
                break;
            case TypeToilet:
                str = "200300";
                break;
            case TypeFillingStation:
                str = "010300";
                break;
            case TypeServiceArea:
                str = "180300";
                break;
            case TypeChargeStation:
                str = "011100";
                break;
            case TypeFood:
                str = "050000";
                break;
            case TypeHotel:
                str = "100000";
                break;
            default:
                str = "";
                break;
        }
        if (((RoutePOISearchQuery) this.f3985n).getPolylines() == null || ((RoutePOISearchQuery) this.f3985n).getPolylines().size() <= 0) {
            stringBuffer.append("&origin=");
            stringBuffer.append(d6.a(((RoutePOISearchQuery) this.f3985n).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(d6.a(((RoutePOISearchQuery) this.f3985n).getTo()));
            stringBuffer.append("&strategy=");
            stringBuffer.append("" + ((RoutePOISearchQuery) this.f3985n).getMode());
        } else {
            stringBuffer.append("&polyline=");
            stringBuffer.append(d6.a(((RoutePOISearchQuery) this.f3985n).getPolylines(), Const.STR_MART_SEMICOLON));
        }
        String channel = ((RoutePOISearchQuery) this.f3985n).getChannel();
        if (!TextUtils.isEmpty(channel)) {
            stringBuffer.append("&channel=");
            stringBuffer.append(channel);
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
