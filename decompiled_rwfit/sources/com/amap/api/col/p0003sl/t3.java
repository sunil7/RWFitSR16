package com.amap.api.col.p0003sl;

import android.content.Context;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class t3 extends t8<String, a> {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f5076a;
    }

    public t3(Context context, String str) {
        super(context, str);
        this.f5096p = "/map/styles";
    }

    @Override // com.amap.api.col.p0003sl.t8
    public a a(byte[] bArr) throws s8 {
        a aVar = new a();
        aVar.f5076a = bArr;
        return aVar;
    }

    @Override // com.amap.api.col.p0003sl.t8
    public /* bridge */ /* synthetic */ a b(String str) throws s8 {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getIPV6URL() {
        return v4.a(this.f5096p, this.f5095o);
    }

    @Override // com.amap.api.col.p0003sl.b4, com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", b9.e(this.f5095o));
        hashMap.put("output", "bin");
        String c9 = e9.c();
        String a3 = e9.a(this.f5095o, c9, n9.a(hashMap));
        hashMap.put(Constants.TS, c9);
        hashMap.put("scode", a3);
        return hashMap;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return this.f5096p;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public boolean isSupportIPV6() {
        return true;
    }
}
