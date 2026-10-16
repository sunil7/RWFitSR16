package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class zb {

    /* renamed from: a, reason: collision with root package name */
    private Context f5571a;

    /* renamed from: b, reason: collision with root package name */
    private String f5572b;

    /* renamed from: c, reason: collision with root package name */
    private String f5573c;

    /* renamed from: d, reason: collision with root package name */
    private String f5574d;
    private String e;

    public zb(Context context, String str, String str2, String str3) throws a9 {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new a9(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        }
        this.f5571a = context.getApplicationContext();
        this.f5573c = str;
        this.f5574d = str2;
        this.f5572b = str3;
    }

    public void a(String str) throws a9 {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new a9(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        }
        this.e = str;
    }

    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream;
        int i3;
        byte[] a3;
        byte[] bArr = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        try {
            n9.a(byteArrayOutputStream, this.f5573c);
            n9.a(byteArrayOutputStream, this.f5574d);
            n9.a(byteArrayOutputStream, this.f5572b);
            n9.a(byteArrayOutputStream, String.valueOf(f9.g(this.f5571a)));
            try {
                i3 = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
                i3 = 0;
            }
            byteArrayOutputStream.write(new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)});
            if (TextUtils.isEmpty(this.e)) {
                a3 = new byte[]{0, 0};
            } else {
                byte[] e = n9.e(this.e);
                if (e == null) {
                    a3 = new byte[]{0, 0};
                } else {
                    a3 = n9.a(e.length, 2);
                }
            }
            byteArrayOutputStream.write(a3);
            byteArrayOutputStream.write(n9.e(this.e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th4) {
            th = th4;
            try {
                ka.a(th, "se", "tds");
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Throwable th5) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                throw th5;
            }
        }
        return bArr;
    }
}
