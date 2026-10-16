package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.tencent.open.apireq.BaseResp;

/* loaded from: classes.dex */
public class v3 {

    /* renamed from: a, reason: collision with root package name */
    int f5175a;

    /* renamed from: b, reason: collision with root package name */
    int[] f5176b;

    /* renamed from: c, reason: collision with root package name */
    int f5177c;

    /* renamed from: d, reason: collision with root package name */
    int f5178d;
    String e;

    /* renamed from: f, reason: collision with root package name */
    String f5179f;

    public v3(int i3, int[] iArr, String str, String str2, String str3) {
        this.f5175a = i3;
        this.f5176b = iArr;
        this.e = str;
        this.f5179f = str2;
        str = TextUtils.isEmpty(str) ? str2 : str;
        this.f5177c = BaseResp.CODE_QQ_NOT_INSTALLED;
        if ("regions".equals(str)) {
            this.f5177c = 1001;
        } else if ("water".equals(str)) {
            this.f5177c = 1002;
        } else if ("buildings".equals(str)) {
            this.f5177c = 1003;
        } else if ("roads".equals(str)) {
            this.f5177c = 1004;
        } else if ("labels".equals(str)) {
            this.f5177c = 1005;
        } else if ("borders".equals(str)) {
            this.f5177c = AMapException.CODE_AMAP_INVALID_USER_IP;
        }
        this.f5178d = iArr.hashCode() + (i3 * 1000);
    }
}
