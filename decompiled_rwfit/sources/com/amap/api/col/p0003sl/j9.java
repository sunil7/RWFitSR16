package com.amap.api.col.p0003sl;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class j9 extends pb {
    @Override // com.amap.api.col.p0003sl.pb
    public String getIPV6URL() {
        if (TextUtils.isEmpty(getURL())) {
            return getURL();
        }
        String url = getURL();
        Uri parse = Uri.parse(url);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return url;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
    }

    @Override // com.amap.api.col.p0003sl.pb
    public boolean isSupportIPV6() {
        return true;
    }
}
