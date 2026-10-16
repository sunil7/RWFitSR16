package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.h9;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.security.Encrypt;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ReportRecorder {

    /* renamed from: h, reason: collision with root package name */
    private static ReportRecorder f6822h;

    /* renamed from: i, reason: collision with root package name */
    private static long f6823i;

    /* renamed from: b, reason: collision with root package name */
    private File f6825b;

    /* renamed from: c, reason: collision with root package name */
    private String f6826c;

    /* renamed from: d, reason: collision with root package name */
    private Context f6827d;
    private boolean e;

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashMap<String, Long> f6824a = new LinkedHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    String f6828f = "";

    /* renamed from: g, reason: collision with root package name */
    String f6829g = null;

    private ReportRecorder(Context context) {
        this.f6826c = null;
        Context applicationContext = context.getApplicationContext();
        this.f6827d = applicationContext;
        String path = applicationContext.getFilesDir().getPath();
        if (this.f6826c == null) {
            this.f6826c = Utils.getPackageNameMD5(this.f6827d);
        }
        try {
            this.f6825b = new File(path, "reportRecorder");
        } catch (Throwable unused) {
        }
        a();
    }

    private synchronized void a() {
        LinkedHashMap<String, Long> linkedHashMap = this.f6824a;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            try {
                this.f6828f = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
                Iterator<String> it = Utils.readLines(this.f6825b).iterator();
                while (it.hasNext()) {
                    try {
                        try {
                            String[] split = new String(Encrypt.aesDecrypt(h9.a(it.next()), this.f6826c), "UTF-8").split(Const.STR_MART_COMMA);
                            if (split != null && split.length > 1) {
                                this.f6824a.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    public static synchronized ReportRecorder getInstance(Context context) {
        ReportRecorder reportRecorder;
        synchronized (ReportRecorder.class) {
            try {
                if (f6822h == null) {
                    f6822h = new ReportRecorder(context);
                }
                reportRecorder = f6822h;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return reportRecorder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x002b, code lost:
    
        if (r6.f6824a.size() >= 9) goto L14;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080 A[Catch: all -> 0x0016, TRY_ENTER, TryCatch #1 {all -> 0x0016, blocks: (B:3:0x0001, B:5:0x000b, B:8:0x002d, B:9:0x003c, B:11:0x0042, B:51:0x005f, B:19:0x0063, B:21:0x006a, B:23:0x0078, B:28:0x0080, B:30:0x0087, B:33:0x008f, B:35:0x009b, B:36:0x00c5, B:38:0x00cd, B:40:0x00d4, B:41:0x00d7, B:45:0x00b8, B:54:0x0019, B:56:0x0023, B:13:0x0048), top: B:2:0x0001, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void addRecortNum(com.amap.api.location.AMapLocation r7) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.ReportRecorder.addRecortNum(com.amap.api.location.AMapLocation):void");
    }

    public synchronized void applyStatistics() {
        Context context;
        try {
            context = this.f6827d;
            if (this.f6829g == null) {
                this.f6829g = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.STR_PREF_KEY_LAST_SAVE, "0");
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (this.f6829g.equals(this.f6828f)) {
            return;
        }
        SharedPreferences.Editor startEdit = SPUtil.startEdit(context, Const.STR_PREF);
        SPUtil.setPrefsStr(startEdit, Const.STR_PREF_KEY_LAST_SAVE, this.f6828f);
        SPUtil.endEdit(startEdit);
        this.f6829g = this.f6828f;
        for (Map.Entry<String, Long> entry : this.f6824a.entrySet()) {
            try {
                if (!this.f6828f.equals(entry.getKey())) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_long_first", entry.getKey());
                    jSONObject.put("param_long_second", entry.getValue());
                    ReportUtil.applyStatistics(this.f6827d, ReportUtil.STATICS_ID_OFFLINECOUNT, jSONObject);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    public synchronized void synToDisk() {
        if (this.e) {
            try {
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry<String, Long> entry : this.f6824a.entrySet()) {
                    try {
                        sb2.append(h9.c(Encrypt.aesEncrypt((entry.getKey() + Const.STR_MART_COMMA + entry.getValue()).getBytes("UTF-8"), this.f6826c)) + "\n");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                String sb3 = sb2.toString();
                if (!TextUtils.isEmpty(sb3)) {
                    Utils.writeStringToFile(this.f6825b, sb3, false);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            this.e = false;
        }
    }
}
