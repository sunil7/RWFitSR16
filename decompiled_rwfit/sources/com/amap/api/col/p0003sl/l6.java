package com.amap.api.col.p0003sl;

import android.content.Context;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l6 extends j6<CloudSearch.Query, CloudResult> {

    /* renamed from: s, reason: collision with root package name */
    private int f4468s;

    public l6(Context context, CloudSearch.Query query) {
        super(context, query);
        this.f4468s = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String i() {
        return ((CloudSearch.Query) this.f3985n).getSortingrules() != null ? ((CloudSearch.Query) this.f3985n).getSortingrules().toString() : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str == null || str.equals("")) {
            CloudSearch.Query query = (CloudSearch.Query) this.f3985n;
            return CloudResult.createPagedResult(query, this.f4468s, query.getBound(), ((CloudSearch.Query) this.f3985n).getPageSize(), null);
        }
        try {
            arrayList = b(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        CloudSearch.Query query2 = (CloudSearch.Query) this.f3985n;
        return CloudResult.createPagedResult(query2, this.f4468s, query2.getBound(), ((CloudSearch.Query) this.f3985n).getPageSize(), arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.f6, com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", b9.e(this.f3987p));
        hashtable.put("output", "json");
        String str = "";
        if (((CloudSearch.Query) this.f3985n).getBound() != null) {
            if (((CloudSearch.Query) this.f3985n).getBound().getShape().equals("Bound")) {
                hashtable.put("center", d6.a(((CloudSearch.Query) this.f3985n).getBound().getCenter().getLongitude()) + Const.STR_MART_COMMA + d6.a(((CloudSearch.Query) this.f3985n).getBound().getCenter().getLatitude()));
                StringBuilder sb2 = new StringBuilder("");
                sb2.append(((CloudSearch.Query) this.f3985n).getBound().getRange());
                hashtable.put("radius", sb2.toString());
            } else if (((CloudSearch.Query) this.f3985n).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.f3985n).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.f3985n).getBound().getUpperRight();
                double a3 = d6.a(lowerLeft.getLatitude());
                hashtable.put("polygon", d6.a(lowerLeft.getLongitude()) + Const.STR_MART_COMMA + a3 + Const.STR_MART_SEMICOLON + d6.a(upperRight.getLongitude()) + Const.STR_MART_COMMA + d6.a(upperRight.getLatitude()));
            } else if (((CloudSearch.Query) this.f3985n).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.f3985n).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", d6.a(polyGonList, Const.STR_MART_SEMICOLON));
                }
            } else if (((CloudSearch.Query) this.f3985n).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put("city", ((CloudSearch.Query) this.f3985n).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) this.f3985n).getTableID());
        if (!d6.a(i())) {
            hashtable.put("sortrule", i());
        }
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.f3985n).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.f3985n).getFilterNumString();
        stringBuffer.append(filterString);
        if (!d6.a(filterString) && !d6.a(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        String stringBuffer2 = stringBuffer.toString();
        if (!d6.a(stringBuffer2)) {
            hashtable.put("filter", stringBuffer2);
        }
        String queryString = ((CloudSearch.Query) this.f3985n).getQueryString();
        if (queryString == null || "".equals(queryString)) {
            hashtable.put("keywords", "");
        } else {
            hashtable.put("keywords", queryString);
        }
        hashtable.put("pageSize", "" + ((CloudSearch.Query) this.f3985n).getPageSize());
        hashtable.put("pageNum", "" + ((CloudSearch.Query) this.f3985n).getPageNum());
        String c9 = e9.c();
        Context context = this.f3987p;
        StringBuilder sb3 = new StringBuilder();
        for (Map.Entry entry : hashtable.entrySet()) {
            if (sb3.length() > 0) {
                sb3.append(Const.STR_MART_ADD);
            }
            sb3.append((String) entry.getKey());
            sb3.append("=");
            sb3.append((String) entry.getValue());
        }
        String sb4 = sb3.toString();
        try {
        } catch (Throwable th2) {
            ga.a(th2, "ut", "sPa");
        }
        if (!TextUtils.isEmpty(sb4)) {
            if (sb4 != null) {
                sb4 = sb4.replace("&&", "%26%26");
            }
            String[] split = sb4.split(Const.STR_MART_ADD);
            Arrays.sort(split);
            StringBuffer stringBuffer3 = new StringBuffer();
            for (String str2 : split) {
                stringBuffer3.append(str2);
                stringBuffer3.append(Const.STR_MART_ADD);
            }
            String stringBuffer4 = stringBuffer3.toString();
            if (stringBuffer4 != null) {
                stringBuffer4 = stringBuffer4.replace("%26%26", "&&");
            }
            if (stringBuffer4.length() > 1) {
                str = (String) stringBuffer4.subSequence(0, stringBuffer4.length() - 1);
            }
            str = sb4;
        }
        String a10 = e9.a(context, c9, str);
        hashtable.put(Constants.TS, c9);
        hashtable.put("scode", a10);
        return hashtable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        String str = m6.e(this.f3987p) + "/datasearch";
        String shape = ((CloudSearch.Query) this.f3985n).getBound().getShape();
        return shape.equals("Bound") ? e.l(str, "/around") : (shape.equals("Polygon") || shape.equals("Rectangle")) ? e.l(str, "/polygon") : shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE) ? e.l(str, "/local") : str;
    }

    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        return null;
    }

    private ArrayList<CloudItem> b(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONObject optJSONObject2 = jSONObject.optJSONObject(AeUtil.ROOT_DATA_PATH_OLD_NAME);
        JSONArray optJSONArray = optJSONObject2 != null ? optJSONObject2.optJSONArray("list") : null;
        if (optJSONArray != null) {
            JSONObject optJSONObject3 = jSONObject.optJSONObject(AeUtil.ROOT_DATA_PATH_OLD_NAME);
            this.f4468s = (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("info")) == null) ? 0 : optJSONObject.optInt(Const.SP_KEY_CALL_LOC_COUNT);
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject4 = optJSONArray.optJSONObject(i3);
                CloudItemDetail a3 = a(optJSONObject4);
                a(a3, optJSONObject4);
                arrayList.add(a3);
            }
        }
        return arrayList;
    }
}
