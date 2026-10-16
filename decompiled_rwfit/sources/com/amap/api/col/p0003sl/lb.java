package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.connect.common.Constants;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class lb {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f4511a = new ConcurrentHashMap<>(8);

    /* renamed from: b, reason: collision with root package name */
    public static volatile List<String> f4512b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f4513c = new ConcurrentHashMap<>(8);

    /* renamed from: d, reason: collision with root package name */
    private static Random f4514d = new Random();
    private static ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>(8);

    /* renamed from: f, reason: collision with root package name */
    private static List<zb> f4515f = Collections.synchronizedList(new ArrayList(16));

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f4516a;

        /* renamed from: b, reason: collision with root package name */
        int f4517b;

        /* renamed from: c, reason: collision with root package name */
        double f4518c;

        private a() {
        }

        public /* synthetic */ a(byte b3) {
            this();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        qb f4519a;

        /* renamed from: b, reason: collision with root package name */
        long f4520b;

        private b() {
        }

        public /* synthetic */ b(byte b3) {
            this();
        }
    }

    public static synchronized void a(m9 m9Var, JSONObject jSONObject) {
        synchronized (lb.class) {
            if (m9Var == null) {
                return;
            }
            try {
                String d5 = m9Var.d();
                if (TextUtils.isEmpty(d5)) {
                    return;
                }
                if (jSONObject == null) {
                    a(d5);
                }
                if (!c9.a(jSONObject.optString("able", null), false)) {
                    a(d5);
                    return;
                }
                xa.a(c9.f3819c, "Yb3Blbl9odHRwX2NvbnRyb2w", d5, jSONObject.toString());
                a(d5, jSONObject);
            } catch (Throwable th2) {
                ga.a(th2, "hlUtil", "par");
            }
        }
    }

    public static synchronized String b(String str, String str2) throws a9 {
        synchronized (lb.class) {
            try {
                try {
                    try {
                        System.currentTimeMillis();
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                            Context context = c9.f3819c;
                            try {
                                if (f4512b == null) {
                                    f4512b = Collections.synchronizedList(new ArrayList(8));
                                }
                                if (context != null && !f4512b.contains(str2)) {
                                    f4512b.add(str2);
                                    String a3 = xa.a(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                    if (!TextUtils.isEmpty(a3)) {
                                        a(str2, new JSONObject(a3));
                                    }
                                }
                            } catch (Throwable th2) {
                                ga.a(th2, "hlUtil", "llhl");
                            }
                            if (f4511a != null && f4511a.size() > 0) {
                                if (!f4511a.containsKey(str2)) {
                                    return str;
                                }
                                c cVar = f4511a.get(str2);
                                if (cVar == null) {
                                    return str;
                                }
                                if (a(str, cVar, str2)) {
                                    throw new a9("服务QPS超限");
                                }
                                return b(str, cVar, str2);
                            }
                            return str;
                        }
                        return str;
                    } catch (a9 e10) {
                        throw e10;
                    }
                } catch (Throwable th3) {
                    ga.a(th3, "hlUtil", "pcr");
                    return str;
                }
            } finally {
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        Map<String, List<a>> f4521a;

        /* renamed from: b, reason: collision with root package name */
        Map<String, String> f4522b;

        private c() {
            this.f4521a = new HashMap(8);
            this.f4522b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f4521a.equals(cVar.f4521a) && this.f4522b.equals(cVar.f4522b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f4521a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f4522b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        public /* synthetic */ c(byte b3) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(String str, JSONObject jSONObject) {
        JSONArray names;
        try {
            c cVar = new c(0 == true ? 1 : 0);
            a(cVar, jSONObject);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
                if (optJSONObject != null && (names = optJSONObject.names()) != null) {
                    HashMap hashMap = new HashMap(8);
                    int length = names.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = names.optString(i3);
                        hashMap.put(optString, optJSONObject.optString(optString));
                    }
                    cVar.f4522b = hashMap;
                }
            } catch (Throwable th2) {
                ga.a(th2, "hlUtil", "pdr");
            }
            if (cVar.f4522b == null && cVar.f4521a == null) {
                a(str);
                return;
            }
            try {
                if (f4511a == null) {
                    f4511a = new ConcurrentHashMap<>(8);
                }
                f4511a.put(str, cVar);
            } catch (Throwable th3) {
                ga.a(th3, "hlUtil", "ucr");
            }
        } catch (Throwable unused) {
        }
    }

    private static String b(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.f4522b;
            if (map != null && map.size() > 0) {
                Uri parse = Uri.parse(str);
                String authority = parse.getAuthority();
                if (map.containsKey(authority)) {
                    String str3 = map.get(authority);
                    str = parse.buildUpon().authority(str3).toString();
                    a(str2, authority, str3);
                    return str;
                }
            }
            return str;
        } catch (Throwable th2) {
            ga.a(th2, "hlUtil", "pdr");
            return str;
        }
    }

    public static void a(URL url, qb qbVar) {
        List<String> list;
        try {
            if (f4513c == null) {
                f4513c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = qbVar.f4928b;
            if (map != null && map.containsKey("nb") && (list = qbVar.f4928b.get("nb")) != null && list.size() > 0) {
                byte b3 = 0;
                String[] split = list.get(0).split(Const.STR_MART_WELL);
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                b bVar = new b(b3);
                bVar.f4519a = qbVar;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                bVar.f4520b = (parseInt2 * 1000) + SystemClock.elapsedRealtime();
                if (parseInt == 1) {
                    f4513c.put(Constants.JumpUrlConstants.SRC_TYPE_APP, bVar);
                } else {
                    if (parseInt != 2 || url == null) {
                        return;
                    }
                    f4513c.put(url.getPath(), bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static List<zb> b() {
        ArrayList arrayList = null;
        try {
            synchronized (f4515f) {
                try {
                    List<zb> list = f4515f;
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            arrayList2.addAll(f4515f);
                            f4515f.clear();
                            arrayList = arrayList2;
                        } catch (Throwable th2) {
                            th = th2;
                            arrayList = arrayList2;
                            throw th;
                        }
                    }
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    public static qb a(String str, String str2) {
        Uri parse;
        if (f4513c == null) {
            return null;
        }
        if (f4513c.containsKey(Constants.JumpUrlConstants.SRC_TYPE_APP)) {
            b bVar = f4513c.get(Constants.JumpUrlConstants.SRC_TYPE_APP);
            if (SystemClock.elapsedRealtime() > bVar.f4520b) {
                f4513c.remove(Constants.JumpUrlConstants.SRC_TYPE_APP);
            } else {
                qb qbVar = bVar.f4519a;
                a(true, str2, str, 1);
                return qbVar;
            }
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (f4513c.containsKey(path)) {
                b bVar2 = f4513c.get(path);
                if (SystemClock.elapsedRealtime() <= bVar2.f4520b) {
                    qb qbVar2 = bVar2.f4519a;
                    a(true, str2, str, 2);
                    return qbVar2;
                }
                f4513c.remove(path);
            }
        }
        return null;
    }

    private static void a(c cVar, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            byte b3 = 0;
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("api");
                    if (!TextUtils.isEmpty(optString)) {
                        if (!optString.startsWith("/")) {
                            optString = "/".concat(optString);
                        }
                        if (optString.endsWith("/")) {
                            optString = optString.substring(0, optString.length() - 1);
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                        ArrayList arrayList = new ArrayList();
                        for (int i10 = 0; i10 < optJSONArray2.length(); i10++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i10);
                            if (optJSONObject2 != null) {
                                a aVar = new a(b3);
                                aVar.f4516a = optJSONObject2.optString("begin");
                                aVar.f4517b = optJSONObject2.optInt("duration");
                                aVar.f4518c = optJSONObject2.optDouble("percent");
                                arrayList.add(aVar);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            cVar.f4521a = hashMap;
        } catch (Throwable th2) {
            ga.a(th2, "hlUtil", "pbr");
        }
    }

    private static synchronized void a(String str) {
        synchronized (lb.class) {
            try {
                if (f4511a.containsKey(str)) {
                    f4511a.remove(str);
                }
                SharedPreferences.Editor a3 = xa.a(c9.f3819c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                if (a3 != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            a3.remove(str);
                        }
                    } catch (Throwable th2) {
                        ga.a(th2, "sp", "rk");
                    }
                }
                xa.a(a3);
            } catch (Throwable th3) {
                ga.a(th3, "hlUtil", "rc");
            }
        }
    }

    private static boolean a(String str, c cVar, String str2) {
        Map<String, List<a>> map;
        try {
            map = cVar.f4521a;
        } catch (Throwable th2) {
            ga.a(th2, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey("*")) {
                Iterator<Map.Entry<String, List<a>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (a(it.next().getValue())) {
                        a(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                String path = Uri.parse(str).getPath();
                if (map.containsKey(path) && a(map.get(path))) {
                    a(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean a(List<a> list) {
        Calendar calendar;
        if (list != null && list.size() > 0) {
            for (a aVar : list) {
                if (aVar != null && aVar.f4518c != 1.0d) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(aVar.f4516a) && aVar.f4517b > 0) {
                        String str = aVar.f4516a;
                        int i3 = n9.f4707d;
                        try {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
                            calendar = Calendar.getInstance();
                            Calendar calendar2 = Calendar.getInstance();
                            calendar2.setTime(simpleDateFormat.parse(str));
                            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar2.get(11), calendar2.get(12), calendar2.get(13));
                        } catch (ParseException e10) {
                            ga.a(e10, "ut", "ctt");
                            calendar = null;
                        }
                        long timeInMillis = currentTimeMillis - calendar.getTimeInMillis();
                        if (timeInMillis > 0 && timeInMillis < aVar.f4517b * 1000) {
                            if (aVar.f4518c != 0.0d) {
                                if (f4514d == null) {
                                    f4514d = new Random();
                                }
                                f4514d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                                if (f4514d.nextDouble() > aVar.f4518c) {
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void a(boolean z5, String str) {
        try {
            Context context = c9.f3819c;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (z5) {
                    jSONObject.put("type", ca.f3873f);
                } else {
                    jSONObject.put("type", ca.e);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", ca.a(str));
                String jSONObject2 = jSONObject.toString();
                zb zbVar = new zb(context, "core", "2.0", "O005");
                zbVar.a(jSONObject2);
                ac.a(zbVar, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2, String str3) {
        try {
            Context context = c9.f3819c;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (e == null) {
                    e = new ConcurrentHashMap<>(8);
                }
                synchronized (e) {
                    try {
                        if (e.containsKey(str2)) {
                            return;
                        }
                        e.put(str2, str3);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put("type", ca.f3876i);
                        jSONObject.put("name", str);
                        jSONObject.put("version", ca.a(str));
                        jSONObject.put("hostname", str2 + Const.STR_MART_WELL + str3);
                        String jSONObject2 = jSONObject.toString();
                        if (TextUtils.isEmpty(jSONObject2)) {
                            return;
                        }
                        zb zbVar = new zb(context, "core", "2.0", "O005");
                        zbVar.a(jSONObject2);
                        ac.a(zbVar, context);
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(boolean z5, String str, String str2, int i3) {
        try {
            Context context = c9.f3819c;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                String a3 = ca.a(str);
                if (z5) {
                    jSONObject.put("type", ca.f3875h);
                } else {
                    jSONObject.put("type", ca.f3874g);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", a3);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i3);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                zb zbVar = new zb(context, "core", "2.0", "O005");
                zbVar.a(jSONObject2);
                if (f4515f == null) {
                    f4515f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f4515f) {
                    f4515f.add(zbVar);
                    if (f4515f.size() >= 15) {
                        try {
                            Context context2 = c9.f3819c;
                            if (context2 != null) {
                                ac.b(b(), context2);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void a() {
        try {
            Context context = c9.f3819c;
            if (context == null) {
                return;
            }
            ac.b(b(), context);
        } catch (Throwable unused) {
        }
    }
}
