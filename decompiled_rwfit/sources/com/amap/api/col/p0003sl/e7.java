package com.amap.api.col.p0003sl;

import android.content.Context;
import android.support.v4.media.session.e;
import com.amap.api.col.p0003sl.l7;
import com.amap.api.col.p0003sl.n7;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e7 extends b7<i7, PoiResult> {

    /* renamed from: s, reason: collision with root package name */
    private int f3989s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f3990t;

    /* renamed from: u, reason: collision with root package name */
    private List<String> f3991u;

    /* renamed from: v, reason: collision with root package name */
    private List<SuggestionCity> f3992v;

    public e7(Context context, i7 i7Var) {
        super(context, i7Var);
        this.f3989s = 0;
        this.f3990t = false;
        this.f3991u = new ArrayList();
        this.f3992v = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0203  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(boolean r20) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e7.a(boolean):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        ArrayList<PoiItem> arrayList;
        JSONObject jSONObject;
        ArrayList<PoiItem> arrayList2 = new ArrayList<>();
        if (str == null) {
            i7 i7Var = (i7) this.f3985n;
            PoiSearch.Query query = i7Var.f4290a;
            return PoiResult.createPagedResult(query, i7Var.f4291b, this.f3991u, this.f3992v, query.getPageSize(), this.f3989s, arrayList2);
        }
        try {
            jSONObject = new JSONObject(str);
            this.f3989s = jSONObject.optInt(Const.SP_KEY_CALL_LOC_COUNT);
            arrayList = u6.k(jSONObject);
            try {
            } catch (JSONException e) {
                e = e;
                arrayList2 = arrayList;
                d6.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
                arrayList = arrayList2;
                i7 i7Var2 = (i7) this.f3985n;
                PoiSearch.Query query2 = i7Var2.f4290a;
                return PoiResult.createPagedResult(query2, i7Var2.f4291b, this.f3991u, this.f3992v, query2.getPageSize(), this.f3989s, arrayList);
            } catch (Exception e10) {
                e = e10;
                arrayList2 = arrayList;
                d6.a(e, "PoiSearchKeywordHandler", "paseJSONException");
                arrayList = arrayList2;
                i7 i7Var22 = (i7) this.f3985n;
                PoiSearch.Query query22 = i7Var22.f4290a;
                return PoiResult.createPagedResult(query22, i7Var22.f4291b, this.f3991u, this.f3992v, query22.getPageSize(), this.f3989s, arrayList);
            }
        } catch (JSONException e11) {
            e = e11;
        } catch (Exception e12) {
            e = e12;
        }
        if (!jSONObject.has("suggestion")) {
            T t8 = this.f3985n;
            return PoiResult.createPagedResult(((i7) t8).f4290a, ((i7) t8).f4291b, this.f3991u, this.f3992v, ((i7) t8).f4290a.getPageSize(), this.f3989s, arrayList);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
        if (optJSONObject == null) {
            T t10 = this.f3985n;
            return PoiResult.createPagedResult(((i7) t10).f4290a, ((i7) t10).f4291b, this.f3991u, this.f3992v, ((i7) t10).f4290a.getPageSize(), this.f3989s, arrayList);
        }
        this.f3992v = u6.b(optJSONObject);
        this.f3991u = u6.c(optJSONObject);
        i7 i7Var222 = (i7) this.f3985n;
        PoiSearch.Query query222 = i7Var222.f4290a;
        return PoiResult.createPagedResult(query222, i7Var222.f4291b, this.f3991u, this.f3992v, query222.getPageSize(), this.f3989s, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.e6
    public l7.b f() {
        l7.b bVar = new l7.b();
        if (!this.f3990t) {
            bVar.f4475a = getURL() + a(true) + "language=" + ServiceSettings.getInstance().getLanguage();
            return bVar;
        }
        m7 a3 = l7.a().a("regeo");
        n7 n7Var = a3 == null ? null : (n7) a3;
        double b3 = n7Var != null ? n7Var.b() : 0.0d;
        bVar.f4475a = getURL() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        if (((i7) this.f3985n).f4291b.getShape().equals("Bound")) {
            bVar.f4476b = new n7.a(d6.a(((i7) this.f3985n).f4291b.getCenter().getLatitude()), d6.a(((i7) this.f3985n).f4291b.getCenter().getLongitude()), b3);
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        String str = m6.b(this.f3987p) + "/place";
        PoiSearch.SearchBound searchBound = ((i7) this.f3985n).f4291b;
        if (searchBound == null) {
            return e.l(str, "/text?");
        }
        if (!searchBound.getShape().equals("Bound")) {
            return (((i7) this.f3985n).f4291b.getShape().equals("Rectangle") || ((i7) this.f3985n).f4291b.getShape().equals("Polygon")) ? e.l(str, "/polygon?") : str;
        }
        String l3 = e.l(str, "/around?");
        this.f3990t = true;
        return l3;
    }

    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        return a(true);
    }
}
