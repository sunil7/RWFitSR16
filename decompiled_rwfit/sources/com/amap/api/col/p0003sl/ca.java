package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class ca {

    /* renamed from: a, reason: collision with root package name */
    static byte[] f3869a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f3870b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f3871c = false;

    /* renamed from: d, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f3872d = new ConcurrentHashMap<>(8);
    public static final Integer e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final Integer f3873f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final Integer f3874g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final Integer f3875h = 4;

    /* renamed from: i, reason: collision with root package name */
    public static final Integer f3876i = 5;

    public static byte[] a() {
        if (f3869a == null) {
            f3869a = h9.a("ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09");
        }
        byte[] bArr = new byte[4];
        System.arraycopy(f3869a, 40, bArr, 0, 4);
        int i3 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i10 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i10];
        System.arraycopy(f3869a, i3, bArr2, 0, i10);
        return bArr2;
    }

    public static void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                synchronized (f3872d) {
                    try {
                        if (f3872d == null) {
                            f3872d = new ConcurrentHashMap<>(8);
                        }
                        if (!f3872d.containsKey(str)) {
                            f3872d.put(str, str2);
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        String str2 = "";
        try {
            synchronized (f3872d) {
                try {
                    if (f3872d != null && f3872d.containsKey(str)) {
                        str2 = f3872d.get(str);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }
}
