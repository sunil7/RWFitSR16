package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.h9;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.autonavi.aps.amapapi.utils.Utils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class AgeEstimator<T> {

    /* renamed from: a, reason: collision with root package name */
    private File f6648a;

    /* renamed from: d, reason: collision with root package name */
    private Handler f6651d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6652f;
    public String mTag;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6649b = false;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, SignalAge> f6650c = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    private Runnable f6653g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.AgeEstimator.2
        @Override // java.lang.Runnable
        public void run() {
            if (AgeEstimator.this.f6649b) {
                if (AgeEstimator.this.f6652f) {
                    AgeEstimator.d(AgeEstimator.this);
                    AgeEstimator.this.f6652f = false;
                }
                if (AgeEstimator.this.f6651d != null) {
                    AgeEstimator.this.f6651d.postDelayed(AgeEstimator.this.f6653g, 60000L);
                }
            }
        }
    };

    public static class SignalAge {

        /* renamed from: a, reason: collision with root package name */
        int f6656a;

        /* renamed from: b, reason: collision with root package name */
        long f6657b;

        /* renamed from: c, reason: collision with root package name */
        long f6658c;

        public SignalAge(int i3, long j4, long j10) {
            this.f6656a = i3;
            this.f6657b = j4;
            this.f6658c = j10;
        }
    }

    public AgeEstimator(Context context, String str, Handler handler) {
        this.e = null;
        if (context == null) {
            return;
        }
        this.f6651d = handler;
        this.mTag = TextUtils.isEmpty(str) ? "unknow" : str;
        this.e = Utils.getPackageNameMD5(context);
        try {
            this.f6648a = new File(context.getFilesDir().getPath(), this.mTag);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        c();
    }

    public static int compare(long j4, long j10) {
        if (j4 < j10) {
            return -1;
        }
        return j4 == j10 ? 0 : 1;
    }

    public static void d(AgeEstimator ageEstimator) {
        if (ageEstimator.a() > 0) {
            ageEstimator.f6650c.size();
            if (ageEstimator.b() > 0) {
                long timeBoot = Utils.getTimeBoot();
                Iterator<Map.Entry<String, SignalAge>> it = ageEstimator.f6650c.entrySet().iterator();
                while (it.hasNext()) {
                    if (timeBoot - ageEstimator.f6650c.get(it.next().getKey()).f6658c > ageEstimator.b()) {
                        it.remove();
                    }
                }
            }
            if (ageEstimator.f6650c.size() > ageEstimator.a()) {
                ArrayList arrayList = new ArrayList(ageEstimator.f6650c.keySet());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.autonavi.aps.amapapi.restruct.AgeEstimator.1
                    @Override // java.util.Comparator
                    public int compare(String str, String str2) {
                        return AgeEstimator.compare(((SignalAge) AgeEstimator.this.f6650c.get(str2)).f6658c, ((SignalAge) AgeEstimator.this.f6650c.get(str)).f6658c);
                    }
                });
                for (int a3 = (int) ageEstimator.a(); a3 < arrayList.size(); a3++) {
                    ageEstimator.f6650c.remove(arrayList.get(a3));
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, SignalAge> entry : ageEstimator.f6650c.entrySet()) {
            try {
                sb2.append(h9.c(Encrypt.aesEncrypt((entry.getKey() + Const.STR_MART_COMMA + entry.getValue().f6656a + Const.STR_MART_COMMA + entry.getValue().f6657b + Const.STR_MART_COMMA + entry.getValue().f6658c).getBytes("UTF-8"), ageEstimator.e)) + "\n");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String sb3 = sb2.toString();
        if (TextUtils.isEmpty(sb3)) {
            return;
        }
        Utils.writeStringToFile(ageEstimator.f6648a, sb3, false);
    }

    public abstract int a(T t8);

    public abstract long a();

    public abstract void a(T t8, long j4);

    public abstract long b();

    public abstract long b(T t8);

    public void destroy(boolean z5) {
        Handler handler = this.f6651d;
        if (handler != null) {
            handler.removeCallbacks(this.f6653g);
        }
        if (!z5) {
            this.f6653g.run();
        }
        this.f6649b = false;
    }

    public long getAge(T t8) {
        return (Utils.getTimeBoot() - b((AgeEstimator<T>) t8)) / 1000;
    }

    public abstract String getKey(T t8);

    public void start() {
        Handler handler;
        if (!this.f6649b && (handler = this.f6651d) != null) {
            handler.removeCallbacks(this.f6653g);
            this.f6651d.postDelayed(this.f6653g, 60000L);
        }
        this.f6649b = true;
    }

    public void update(T t8) {
        b(t8, Utils.getTimeBoot());
    }

    private void b(T t8, long j4) {
        if (t8 == null || b((AgeEstimator<T>) t8) < 0) {
            return;
        }
        String key = getKey(t8);
        SignalAge signalAge = this.f6650c.get(key);
        if (signalAge == null) {
            a((AgeEstimator<T>) t8, j4);
            this.f6650c.put(key, new SignalAge(a((AgeEstimator<T>) t8), b((AgeEstimator<T>) t8), j4));
            this.f6652f = true;
            return;
        }
        signalAge.f6658c = j4;
        if (signalAge.f6656a == a((AgeEstimator<T>) t8)) {
            a((AgeEstimator<T>) t8, signalAge.f6657b);
            return;
        }
        a((AgeEstimator<T>) t8, j4);
        signalAge.f6656a = a((AgeEstimator<T>) t8);
        signalAge.f6657b = b((AgeEstimator<T>) t8);
        this.f6652f = true;
    }

    private void c() {
        try {
            Iterator<String> it = Utils.readLines(this.f6648a).iterator();
            while (it.hasNext()) {
                try {
                    String[] split = new String(Encrypt.aesDecrypt(h9.a(it.next()), this.e), "UTF-8").split(Const.STR_MART_COMMA);
                    this.f6650c.put(split[0], new SignalAge(Integer.parseInt(split[1]), Long.parseLong(split[2]), split.length >= 4 ? Long.parseLong(split[3]) : Utils.getTimeBoot()));
                } catch (Throwable th2) {
                    if (this.f6648a.exists()) {
                        this.f6648a.delete();
                    }
                    th2.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void update(List<T> list) {
        long timeBoot = Utils.getTimeBoot();
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            b(it.next(), timeBoot);
        }
        if (this.f6650c.size() >= list.size()) {
            this.f6652f = true;
        }
        if (this.f6650c.size() > 16384 || a() <= 0) {
            this.f6650c.clear();
            for (T t8 : list) {
                this.f6650c.put(getKey(t8), new SignalAge(a((AgeEstimator<T>) t8), b((AgeEstimator<T>) t8), timeBoot));
            }
        }
    }
}
