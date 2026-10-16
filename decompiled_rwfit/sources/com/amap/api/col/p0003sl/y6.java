package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* loaded from: classes.dex */
public class y6 extends f6<String, Integer> {

    /* renamed from: s, reason: collision with root package name */
    private Context f5462s;

    /* renamed from: t, reason: collision with root package name */
    private String f5463t;

    public y6(Context context, String str) {
        super(context, str);
        this.f5462s = context;
        this.f5463t = str;
    }

    @Override // com.amap.api.col.p0003sl.e6
    public Object b(String str) throws AMapException {
        return 0;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return m6.f(this.f5462s) + "/nearby/data/delete";
    }

    @Override // com.amap.api.col.p0003sl.f6
    public String h() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(b9.e(this.f5462s));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f5463t);
        return stringBuffer.toString();
    }
}
