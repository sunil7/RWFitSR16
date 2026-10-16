package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.l7;
import com.amap.api.col.p0003sl.pb;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.tencent.connect.common.Constants;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class e6<T, V> extends j9 {

    /* renamed from: n, reason: collision with root package name */
    protected T f3985n;

    /* renamed from: p, reason: collision with root package name */
    protected Context f3987p;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f3984m = true;

    /* renamed from: o, reason: collision with root package name */
    protected int f3986o = 1;

    /* renamed from: q, reason: collision with root package name */
    private int f3988q = 1;
    protected String r = "";

    public e6(Context context, T t8) {
        a(context, t8);
    }

    private void a(Context context, T t8) {
        this.f3987p = context;
        this.f3985n = t8;
        this.f3986o = 1;
        setSoTimeout(ServiceSettings.getInstance().getSoTimeOut());
        setConnectionTimeout(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0171 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private V d() throws com.amap.api.services.core.AMapException {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e6.d():java.lang.Object");
    }

    public abstract V b(String str) throws AMapException;

    public V c() throws AMapException {
        String str;
        if (this.f3985n == null) {
            return null;
        }
        try {
            return d();
        } catch (AMapException e) {
            String e10 = e();
            String str2 = this.r;
            if (e10 != null) {
                String errorType = e.getErrorType();
                if (e.getErrorLevel() == 0) {
                    int errorCode = e.getErrorCode();
                    if (errorCode == 0) {
                        str = Constants.VIA_TO_TYPE_QZONE;
                    } else {
                        int pow = (int) Math.pow(10.0d, Math.floor(Math.log10(errorCode)));
                        str = ((pow * 4) + (errorCode % pow)) + "";
                    }
                } else {
                    str = e.getErrorCode() + "";
                }
                String str3 = str;
                if (str3 != null && str3.length() >= 1) {
                    ka.a(m6.a(true), e10, errorType, str2, "", str3);
                }
            }
            throw e;
        }
    }

    public String e() {
        String ipv6url = getIPV6URL();
        if (ipv6url == null) {
            return null;
        }
        try {
            int indexOf = ipv6url.indexOf(".com/");
            int indexOf2 = ipv6url.indexOf("?");
            return indexOf2 == -1 ? ipv6url.substring(indexOf + 5) : ipv6url.substring(indexOf + 5, indexOf2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public l7.b f() {
        return null;
    }

    public V g() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getSDKName() {
        return "sea";
    }

    public V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            d6.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        d6.d(str);
        return b(str);
    }

    public byte[] a(int i3, ob obVar, j9 j9Var) throws a9 {
        qb e;
        setHttpProtocol(i3 == 1 ? pb.c.HTTP : pb.c.HTTPS);
        if (this.f3984m) {
            e = obVar.a(j9Var);
        } else {
            e = obVar.e(j9Var);
        }
        byte[] bArr = e.f4927a;
        this.r = e.f4930d;
        return bArr;
    }
}
