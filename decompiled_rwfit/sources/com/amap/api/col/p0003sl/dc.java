package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public class dc extends hc {

    /* renamed from: c, reason: collision with root package name */
    private String f3923c;

    /* renamed from: d, reason: collision with root package name */
    private bb f3924d;
    private Object[] e;

    public dc(Context context, hc hcVar, bb bbVar, String str, Object... objArr) {
        super(hcVar);
        this.f3923c = str;
        this.f3924d = bbVar;
        this.e = objArr;
    }

    @Override // com.amap.api.col.p0003sl.hc
    public byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String str;
        String c9 = n9.c(bArr);
        if (TextUtils.isEmpty(c9)) {
            return null;
        }
        try {
            str = String.format(n9.b(this.f3923c), this.e);
        } catch (Throwable th2) {
            th2.printStackTrace();
            ka.a(th2, "ofm", "gpj");
            str = "";
        }
        return n9.e("{\"pinfo\":\"" + n9.c(this.f3924d.b(n9.e(str))) + "\",\"els\":[" + c9 + "]}");
    }
}
