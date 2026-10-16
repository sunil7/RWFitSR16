package com.amap.api.col.p0003sl;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public class cc extends hc {

    /* renamed from: c, reason: collision with root package name */
    private bb f3877c;

    public cc(hc hcVar) {
        super(hcVar);
        this.f3877c = new db();
    }

    @Override // com.amap.api.col.p0003sl.hc
    public byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f3877c.b(bArr);
    }
}
