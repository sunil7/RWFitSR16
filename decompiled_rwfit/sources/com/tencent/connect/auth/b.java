package com.tencent.connect.auth;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f11764a = null;

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f11765d = true;
    private static int e;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, a> f11766b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final String f11767c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public IUiListener f11768a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.connect.auth.a f11769b;

        /* renamed from: c, reason: collision with root package name */
        public String f11770c;
    }

    public static b a() {
        if (f11764a == null) {
            f11764a = new b();
        }
        return f11764a;
    }

    public static int b() {
        int i3 = e + 1;
        e = i3;
        return i3;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < ceil; i3++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int b3 = b();
        try {
            this.f11766b.put("" + b3, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return l0.j(b3, "");
    }
}
