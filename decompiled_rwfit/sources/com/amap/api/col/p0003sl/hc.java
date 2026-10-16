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
public abstract class hc {

    /* renamed from: a, reason: collision with root package name */
    hc f4276a;

    /* renamed from: b, reason: collision with root package name */
    byte[] f4277b = null;

    public hc() {
    }

    public void a(byte[] bArr) {
    }

    public abstract byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] b3 = b(this.f4277b);
        hc hcVar = this.f4276a;
        if (hcVar == null) {
            return b3;
        }
        hcVar.f4277b = b3;
        return hcVar.a();
    }

    public hc(hc hcVar) {
        this.f4276a = hcVar;
    }
}
