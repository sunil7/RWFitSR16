package com.amap.api.col.p0003sl;

import android.content.Context;
import android.support.v4.media.session.e;
import com.amap.api.col.p0003sl.l7;
import com.amap.api.col.p0003sl.n7;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f7 extends b7<j7, PoiResultV2> {

    /* renamed from: s, reason: collision with root package name */
    private int f4085s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f4086t;

    public f7(Context context, j7 j7Var) {
        super(context, j7Var);
        this.f4085s = 0;
        this.f4086t = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0218  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(boolean r20) {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.f7.a(boolean):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        if (str == null) {
            j7 j7Var = (j7) this.f3985n;
            return PoiResultV2.createPagedResult(j7Var.f4328a, j7Var.f4329b, this.f4085s, arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f4085s = jSONObject.optInt(Const.SP_KEY_CALL_LOC_COUNT);
            arrayList = u6.l(jSONObject);
        } catch (JSONException e) {
            d6.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e10) {
            d6.a(e10, "PoiSearchKeywordHandler", "paseJSONException");
        }
        j7 j7Var2 = (j7) this.f3985n;
        return PoiResultV2.createPagedResult(j7Var2.f4328a, j7Var2.f4329b, this.f4085s, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.e6
    public l7.b f() {
        l7.b bVar = new l7.b();
        if (!this.f4086t) {
            bVar.f4475a = getURL() + a(true) + "language=" + ServiceSettings.getInstance().getLanguage();
            return bVar;
        }
        m7 a3 = l7.a().a("regeo");
        n7 n7Var = a3 == null ? null : (n7) a3;
        double b3 = n7Var != null ? n7Var.b() : 0.0d;
        bVar.f4475a = getURL() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        if (((j7) this.f3985n).f4329b.getShape().equals("Bound")) {
            bVar.f4476b = new n7.a(d6.a(((j7) this.f3985n).f4329b.getCenter().getLatitude()), d6.a(((j7) this.f3985n).f4329b.getCenter().getLongitude()), b3);
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        String str = m6.d(this.f3987p) + "/place";
        PoiSearchV2.SearchBound searchBound = ((j7) this.f3985n).f4329b;
        if (searchBound == null) {
            return e.l(str, "/text?");
        }
        if (!searchBound.getShape().equals("Bound")) {
            return (((j7) this.f3985n).f4329b.getShape().equals("Rectangle") || ((j7) this.f3985n).f4329b.getShape().equals("Polygon")) ? e.l(str, "/polygon?") : str;
        }
        String l3 = e.l(str, "/around?");
        this.f4086t = true;
        return l3;
    }

    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        return a(true);
    }
}
