package com.amap.api.col.p0003sl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class sb {

    /* renamed from: d, reason: collision with root package name */
    private static sb f5040d = null;
    static final /* synthetic */ boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Map<String, List<String>>> f5041a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<String>> f5042b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f5043c = new ArrayList();

    public static synchronized sb a() {
        sb sbVar;
        synchronized (sb.class) {
            try {
                if (f5040d == null) {
                    f5040d = new sb();
                }
                sbVar = f5040d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return sbVar;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f5044a;

        /* renamed from: b, reason: collision with root package name */
        public String f5045b;

        /* renamed from: c, reason: collision with root package name */
        public String f5046c;

        public a(URL url) {
            this.f5044a = url.getProtocol();
            this.f5045b = url.getHost();
            this.f5046c = url.getPath();
        }

        public a(String str, String str2) {
            this.f5044a = null;
            this.f5045b = str;
            this.f5046c = str2;
        }
    }

    public boolean a(String str) {
        int i3;
        String str2;
        a aVar;
        int i10;
        if (str == null || str.length() == 0) {
            return false;
        }
        a aVar2 = null;
        try {
            aVar = new a(new URL(str));
        } catch (MalformedURLException unused) {
            if (str.contains("://")) {
                aVar = null;
            } else {
                while (str.startsWith("/")) {
                    str = str.substring(1);
                }
                String[] split = str.split("/");
                if (split[0].contains(".")) {
                    str2 = split[0];
                    i3 = 1;
                } else {
                    i3 = 0;
                    str2 = null;
                }
                StringBuilder sb2 = new StringBuilder();
                while (i3 < split.length) {
                    if (sb2.length() > 0) {
                        sb2.append("/");
                    }
                    sb2.append(split[i3]);
                    i3++;
                }
                if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '/') {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
                aVar = new a(str2, sb2.toString());
            }
        }
        if (aVar != null) {
            String str3 = aVar.f5046c;
            if (str3 != null && str3.length() != 0) {
                while (true) {
                    String str4 = aVar.f5046c;
                    if (str4.charAt(str4.length() - 1) != '/') {
                        break;
                    }
                    String str5 = aVar.f5046c;
                    aVar.f5046c = str5.substring(0, str5.length() - 1);
                }
                while (aVar.f5046c.charAt(0) == '/') {
                    aVar.f5046c = aVar.f5046c.substring(1);
                }
            }
            aVar2 = aVar;
        }
        if (aVar2 == null) {
            return false;
        }
        synchronized (this) {
            try {
                if (aVar2.f5046c.length() != 0) {
                    Map<String, List<String>> map = this.f5042b;
                    String str6 = aVar2.f5044a;
                    if (str6 != null && this.f5041a.containsKey(str6)) {
                        map = this.f5041a.get(aVar2.f5044a);
                    }
                    List<String> list = this.f5043c;
                    boolean z5 = e;
                    if (!z5 && map == null) {
                        throw new AssertionError();
                    }
                    String str7 = aVar2.f5045b;
                    if (str7 != null && map.containsKey(str7)) {
                        list = map.get(aVar2.f5045b);
                    }
                    if (!z5 && list == null) {
                        throw new AssertionError();
                    }
                    for (String str8 : list) {
                        String str9 = aVar2.f5046c;
                        String[] split2 = str8.split("/");
                        String[] split3 = str9.split("/");
                        if (split3.length >= split2.length) {
                            for (0; i10 < split2.length; i10 + 1) {
                                i10 = (split2[i10].equals("*") || split2[i10].equals(split3[i10])) ? i10 + 1 : 0;
                            }
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
