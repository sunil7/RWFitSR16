package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import com.amap.api.maps.AMap;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
public class s3 extends rc {

    /* renamed from: a, reason: collision with root package name */
    private Context f4995a;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f4996b;

    /* renamed from: c, reason: collision with root package name */
    private r3 f4997c;

    /* renamed from: d, reason: collision with root package name */
    private String f4998d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f4999f;

    /* renamed from: h, reason: collision with root package name */
    private a f5000h;

    /* renamed from: i, reason: collision with root package name */
    private int f5001i;

    /* renamed from: j, reason: collision with root package name */
    private AMap.OnCustomMapStyleListener f5002j;

    public interface a {
    }

    public s3(Context context, a aVar, int i3, String str) {
        this.f4998d = null;
        this.e = null;
        this.f4999f = null;
        this.f4995a = context;
        this.f5000h = aVar;
        this.f5001i = i3;
        if (this.f4997c == null) {
            this.f4997c = new r3(context, "", i3 != 0);
        }
        this.f4997c.e(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i3);
        this.f4998d = r5.a.f(sb2, str == null ? "" : str, ".amapstyle");
        this.e = context.getCacheDir().getPath();
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        Context context = this.f4995a;
        String concat = "lastModified".concat(str);
        String simpleName = "".getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences("amap_style_config", 0);
        Object string = "String".equals(simpleName) ? sharedPreferences.getString(concat, "") : "Integer".equals(simpleName) ? Integer.valueOf(sharedPreferences.getInt(concat, ((Integer) "").intValue())) : "Boolean".equals(simpleName) ? Boolean.valueOf(sharedPreferences.getBoolean(concat, ((Boolean) "").booleanValue())) : "Float".equals(simpleName) ? Float.valueOf(sharedPreferences.getFloat(concat, ((Float) "").floatValue())) : "Long".equals(simpleName) ? Long.valueOf(sharedPreferences.getLong(concat, ((Long) "").longValue())) : null;
        if (!(string instanceof String) || string == "") {
            return null;
        }
        return (String) string;
    }

    public void b(String str) {
        r3 r3Var = this.f4997c;
        if (r3Var != null) {
            r3Var.c(str);
        }
        this.f4999f = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006b A[Catch: all -> 0x002d, TryCatch #1 {all -> 0x002d, blocks: (B:3:0x0002, B:8:0x000a, B:10:0x000e, B:12:0x0027, B:17:0x0054, B:20:0x005a, B:21:0x0061, B:23:0x006b, B:25:0x006f, B:27:0x0074, B:30:0x007c, B:32:0x0080, B:34:0x0088, B:35:0x00a5, B:39:0x00ac, B:41:0x00b0, B:42:0x00c9, B:46:0x00d0, B:47:0x0094, B:49:0x0098, B:52:0x00dc, B:54:0x00e1, B:56:0x00e5, B:57:0x0034, B:59:0x0038, B:60:0x00ea, B:62:0x00f7), top: B:2:0x0002 }] */
    @Override // com.amap.api.col.p0003sl.rc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void runTask() {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.s3.runTask():void");
    }

    public void a(AMap.OnCustomMapStyleListener onCustomMapStyleListener) {
        this.f5002j = onCustomMapStyleListener;
    }

    public void a() {
        this.f4995a = null;
        if (this.f4997c != null) {
            this.f4997c = null;
        }
    }

    public s3(Context context, IAMapDelegate iAMapDelegate) {
        this.f4998d = null;
        this.e = null;
        this.f4999f = null;
        this.f5001i = 0;
        this.f4995a = context;
        this.f4996b = iAMapDelegate;
        if (this.f4997c == null) {
            this.f4997c = new r3(context, "");
        }
    }
}
