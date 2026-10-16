package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.col.p0003sl.c9;
import com.amap.api.col.p0003sl.t0;
import com.amap.api.col.p0003sl.w0;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class s0 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private Context f4962a;

    /* renamed from: b, reason: collision with root package name */
    WeakReference<IAMapDelegate> f4963b;

    public class a extends rc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4964a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4965b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4966c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f4967d;
        final /* synthetic */ String e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4968f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f4969h;

        public a(String str, String str2, boolean z5, String str3, String str4, String str5, String str6) {
            this.f4964a = str;
            this.f4965b = str2;
            this.f4966c = z5;
            this.f4967d = str3;
            this.e = str4;
            this.f4968f = str5;
            this.f4969h = str6;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            if (!TextUtils.isEmpty(this.f4964a) && !TextUtils.isEmpty(this.f4965b)) {
                boolean z5 = this.f4966c;
                String str = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                String str2 = this.f4965b;
                String str3 = this.f4964a;
                String str4 = this.f4967d;
                if (z5) {
                    t0.d dVar = new t0.d(str2, str3, str4, str);
                    dVar.e = new t0.c("amap_web_logo", "md5_day");
                    Context context = s0.this.f4962a;
                    v4.b();
                    new t0(context, dVar).a();
                }
                WeakReference<IAMapDelegate> weakReference = s0.this.f4963b;
                if (weakReference != null && weakReference.get() != null) {
                    s0.this.f4963b.get().changeLogoIconStyle(str, z5, 0);
                }
            }
            if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f4968f)) {
                return;
            }
            boolean z6 = this.f4966c;
            String str5 = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
            String str6 = this.f4968f;
            String str7 = this.e;
            String str8 = this.f4969h;
            if (z6) {
                t0.d dVar2 = new t0.d(str6, str7, str8, str5);
                dVar2.e = new t0.c("amap_web_logo", "md5_night");
                Context context2 = s0.this.f4962a;
                v4.b();
                new t0(context2, dVar2).a();
            }
            WeakReference<IAMapDelegate> weakReference2 = s0.this.f4963b;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            s0.this.f4963b.get().changeLogoIconStyle(str5, z6, 1);
        }
    }

    public s0(Context context, IAMapDelegate iAMapDelegate) {
        this.f4963b = null;
        this.f4962a = context;
        this.f4963b = new WeakReference<>(iAMapDelegate);
    }

    @Override // java.lang.Thread
    public void interrupt() {
        super.interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02b5 A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #5 {all -> 0x0118, blocks: (B:3:0x0024, B:8:0x002c, B:23:0x00d5, B:26:0x00dd, B:28:0x00e1, B:30:0x00e9, B:32:0x00f6, B:36:0x0112, B:37:0x011d, B:39:0x0123, B:40:0x0128, B:42:0x012e, B:44:0x0140, B:46:0x0144, B:48:0x014a, B:51:0x0158, B:67:0x019f, B:70:0x0215, B:84:0x024a, B:86:0x024f, B:88:0x0253, B:90:0x025b, B:93:0x026a, B:95:0x026e, B:107:0x02b5, B:109:0x02b9, B:111:0x02c1, B:114:0x0335, B:116:0x0339, B:123:0x0368, B:125:0x036c, B:134:0x038d, B:136:0x0391, B:143:0x039e, B:145:0x03a2, B:147:0x03a9, B:149:0x03ad, B:151:0x03b7, B:153:0x03cb, B:154:0x03ce, B:156:0x03de, B:158:0x03e4, B:207:0x0210, B:183:0x01a8, B:185:0x01ac, B:187:0x01b4, B:189:0x01ba, B:191:0x01c5, B:193:0x01cd, B:194:0x01dd, B:196:0x01e3, B:198:0x01fa, B:200:0x01fe, B:202:0x0204, B:73:0x0219, B:75:0x0221, B:77:0x0227, B:79:0x0233, B:81:0x0239, B:54:0x015e, B:56:0x0164, B:62:0x0185, B:64:0x0196), top: B:2:0x0024, inners: #4, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0335 A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #5 {all -> 0x0118, blocks: (B:3:0x0024, B:8:0x002c, B:23:0x00d5, B:26:0x00dd, B:28:0x00e1, B:30:0x00e9, B:32:0x00f6, B:36:0x0112, B:37:0x011d, B:39:0x0123, B:40:0x0128, B:42:0x012e, B:44:0x0140, B:46:0x0144, B:48:0x014a, B:51:0x0158, B:67:0x019f, B:70:0x0215, B:84:0x024a, B:86:0x024f, B:88:0x0253, B:90:0x025b, B:93:0x026a, B:95:0x026e, B:107:0x02b5, B:109:0x02b9, B:111:0x02c1, B:114:0x0335, B:116:0x0339, B:123:0x0368, B:125:0x036c, B:134:0x038d, B:136:0x0391, B:143:0x039e, B:145:0x03a2, B:147:0x03a9, B:149:0x03ad, B:151:0x03b7, B:153:0x03cb, B:154:0x03ce, B:156:0x03de, B:158:0x03e4, B:207:0x0210, B:183:0x01a8, B:185:0x01ac, B:187:0x01b4, B:189:0x01ba, B:191:0x01c5, B:193:0x01cd, B:194:0x01dd, B:196:0x01e3, B:198:0x01fa, B:200:0x01fe, B:202:0x0204, B:73:0x0219, B:75:0x0221, B:77:0x0227, B:79:0x0233, B:81:0x0239, B:54:0x015e, B:56:0x0164, B:62:0x0185, B:64:0x0196), top: B:2:0x0024, inners: #4, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0368 A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #5 {all -> 0x0118, blocks: (B:3:0x0024, B:8:0x002c, B:23:0x00d5, B:26:0x00dd, B:28:0x00e1, B:30:0x00e9, B:32:0x00f6, B:36:0x0112, B:37:0x011d, B:39:0x0123, B:40:0x0128, B:42:0x012e, B:44:0x0140, B:46:0x0144, B:48:0x014a, B:51:0x0158, B:67:0x019f, B:70:0x0215, B:84:0x024a, B:86:0x024f, B:88:0x0253, B:90:0x025b, B:93:0x026a, B:95:0x026e, B:107:0x02b5, B:109:0x02b9, B:111:0x02c1, B:114:0x0335, B:116:0x0339, B:123:0x0368, B:125:0x036c, B:134:0x038d, B:136:0x0391, B:143:0x039e, B:145:0x03a2, B:147:0x03a9, B:149:0x03ad, B:151:0x03b7, B:153:0x03cb, B:154:0x03ce, B:156:0x03de, B:158:0x03e4, B:207:0x0210, B:183:0x01a8, B:185:0x01ac, B:187:0x01b4, B:189:0x01ba, B:191:0x01c5, B:193:0x01cd, B:194:0x01dd, B:196:0x01e3, B:198:0x01fa, B:200:0x01fe, B:202:0x0204, B:73:0x0219, B:75:0x0221, B:77:0x0227, B:79:0x0233, B:81:0x0239, B:54:0x015e, B:56:0x0164, B:62:0x0185, B:64:0x0196), top: B:2:0x0024, inners: #4, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x038d A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #5 {all -> 0x0118, blocks: (B:3:0x0024, B:8:0x002c, B:23:0x00d5, B:26:0x00dd, B:28:0x00e1, B:30:0x00e9, B:32:0x00f6, B:36:0x0112, B:37:0x011d, B:39:0x0123, B:40:0x0128, B:42:0x012e, B:44:0x0140, B:46:0x0144, B:48:0x014a, B:51:0x0158, B:67:0x019f, B:70:0x0215, B:84:0x024a, B:86:0x024f, B:88:0x0253, B:90:0x025b, B:93:0x026a, B:95:0x026e, B:107:0x02b5, B:109:0x02b9, B:111:0x02c1, B:114:0x0335, B:116:0x0339, B:123:0x0368, B:125:0x036c, B:134:0x038d, B:136:0x0391, B:143:0x039e, B:145:0x03a2, B:147:0x03a9, B:149:0x03ad, B:151:0x03b7, B:153:0x03cb, B:154:0x03ce, B:156:0x03de, B:158:0x03e4, B:207:0x0210, B:183:0x01a8, B:185:0x01ac, B:187:0x01b4, B:189:0x01ba, B:191:0x01c5, B:193:0x01cd, B:194:0x01dd, B:196:0x01e3, B:198:0x01fa, B:200:0x01fe, B:202:0x0204, B:73:0x0219, B:75:0x0221, B:77:0x0227, B:79:0x0233, B:81:0x0239, B:54:0x015e, B:56:0x0164, B:62:0x0185, B:64:0x0196), top: B:2:0x0024, inners: #4, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x039e A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #5 {all -> 0x0118, blocks: (B:3:0x0024, B:8:0x002c, B:23:0x00d5, B:26:0x00dd, B:28:0x00e1, B:30:0x00e9, B:32:0x00f6, B:36:0x0112, B:37:0x011d, B:39:0x0123, B:40:0x0128, B:42:0x012e, B:44:0x0140, B:46:0x0144, B:48:0x014a, B:51:0x0158, B:67:0x019f, B:70:0x0215, B:84:0x024a, B:86:0x024f, B:88:0x0253, B:90:0x025b, B:93:0x026a, B:95:0x026e, B:107:0x02b5, B:109:0x02b9, B:111:0x02c1, B:114:0x0335, B:116:0x0339, B:123:0x0368, B:125:0x036c, B:134:0x038d, B:136:0x0391, B:143:0x039e, B:145:0x03a2, B:147:0x03a9, B:149:0x03ad, B:151:0x03b7, B:153:0x03cb, B:154:0x03ce, B:156:0x03de, B:158:0x03e4, B:207:0x0210, B:183:0x01a8, B:185:0x01ac, B:187:0x01b4, B:189:0x01ba, B:191:0x01c5, B:193:0x01cd, B:194:0x01dd, B:196:0x01e3, B:198:0x01fa, B:200:0x01fe, B:202:0x0204, B:73:0x0219, B:75:0x0221, B:77:0x0227, B:79:0x0233, B:81:0x0239, B:54:0x015e, B:56:0x0164, B:62:0x0185, B:64:0x0196), top: B:2:0x0024, inners: #4, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03a9 A[Catch: all -> 0x0118, TryCatch #5 {all -> 0x0118, blocks: (B:3:0x0024, B:8:0x002c, B:23:0x00d5, B:26:0x00dd, B:28:0x00e1, B:30:0x00e9, B:32:0x00f6, B:36:0x0112, B:37:0x011d, B:39:0x0123, B:40:0x0128, B:42:0x012e, B:44:0x0140, B:46:0x0144, B:48:0x014a, B:51:0x0158, B:67:0x019f, B:70:0x0215, B:84:0x024a, B:86:0x024f, B:88:0x0253, B:90:0x025b, B:93:0x026a, B:95:0x026e, B:107:0x02b5, B:109:0x02b9, B:111:0x02c1, B:114:0x0335, B:116:0x0339, B:123:0x0368, B:125:0x036c, B:134:0x038d, B:136:0x0391, B:143:0x039e, B:145:0x03a2, B:147:0x03a9, B:149:0x03ad, B:151:0x03b7, B:153:0x03cb, B:154:0x03ce, B:156:0x03de, B:158:0x03e4, B:207:0x0210, B:183:0x01a8, B:185:0x01ac, B:187:0x01b4, B:189:0x01ba, B:191:0x01c5, B:193:0x01cd, B:194:0x01dd, B:196:0x01e3, B:198:0x01fa, B:200:0x01fe, B:202:0x0204, B:73:0x0219, B:75:0x0221, B:77:0x0227, B:79:0x0233, B:81:0x0239, B:54:0x015e, B:56:0x0164, B:62:0x0185, B:64:0x0196), top: B:2:0x0024, inners: #4, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03cb A[Catch: all -> 0x0118, TryCatch #5 {all -> 0x0118, blocks: (B:3:0x0024, B:8:0x002c, B:23:0x00d5, B:26:0x00dd, B:28:0x00e1, B:30:0x00e9, B:32:0x00f6, B:36:0x0112, B:37:0x011d, B:39:0x0123, B:40:0x0128, B:42:0x012e, B:44:0x0140, B:46:0x0144, B:48:0x014a, B:51:0x0158, B:67:0x019f, B:70:0x0215, B:84:0x024a, B:86:0x024f, B:88:0x0253, B:90:0x025b, B:93:0x026a, B:95:0x026e, B:107:0x02b5, B:109:0x02b9, B:111:0x02c1, B:114:0x0335, B:116:0x0339, B:123:0x0368, B:125:0x036c, B:134:0x038d, B:136:0x0391, B:143:0x039e, B:145:0x03a2, B:147:0x03a9, B:149:0x03ad, B:151:0x03b7, B:153:0x03cb, B:154:0x03ce, B:156:0x03de, B:158:0x03e4, B:207:0x0210, B:183:0x01a8, B:185:0x01ac, B:187:0x01b4, B:189:0x01ba, B:191:0x01c5, B:193:0x01cd, B:194:0x01dd, B:196:0x01e3, B:198:0x01fa, B:200:0x01fe, B:202:0x0204, B:73:0x0219, B:75:0x0221, B:77:0x0227, B:79:0x0233, B:81:0x0239, B:54:0x015e, B:56:0x0164, B:62:0x0185, B:64:0x0196), top: B:2:0x0024, inners: #4, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03de A[Catch: all -> 0x0118, TryCatch #5 {all -> 0x0118, blocks: (B:3:0x0024, B:8:0x002c, B:23:0x00d5, B:26:0x00dd, B:28:0x00e1, B:30:0x00e9, B:32:0x00f6, B:36:0x0112, B:37:0x011d, B:39:0x0123, B:40:0x0128, B:42:0x012e, B:44:0x0140, B:46:0x0144, B:48:0x014a, B:51:0x0158, B:67:0x019f, B:70:0x0215, B:84:0x024a, B:86:0x024f, B:88:0x0253, B:90:0x025b, B:93:0x026a, B:95:0x026e, B:107:0x02b5, B:109:0x02b9, B:111:0x02c1, B:114:0x0335, B:116:0x0339, B:123:0x0368, B:125:0x036c, B:134:0x038d, B:136:0x0391, B:143:0x039e, B:145:0x03a2, B:147:0x03a9, B:149:0x03ad, B:151:0x03b7, B:153:0x03cb, B:154:0x03ce, B:156:0x03de, B:158:0x03e4, B:207:0x0210, B:183:0x01a8, B:185:0x01ac, B:187:0x01b4, B:189:0x01ba, B:191:0x01c5, B:193:0x01cd, B:194:0x01dd, B:196:0x01e3, B:198:0x01fa, B:200:0x01fe, B:202:0x0204, B:73:0x0219, B:75:0x0221, B:77:0x0227, B:79:0x0233, B:81:0x0239, B:54:0x015e, B:56:0x0164, B:62:0x0185, B:64:0x0196), top: B:2:0x0024, inners: #4, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x030c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x01a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x027c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 1045
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.s0.run():void");
    }

    private void a(JSONObject jSONObject) {
        w0 w0Var;
        w0 w0Var2;
        w0 w0Var3;
        w0 w0Var4;
        IAMapDelegate iAMapDelegate;
        IAMapDelegate iAMapDelegate2;
        IAMapDelegate iAMapDelegate3;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("1A1");
            w0Var = w0.b.f5207a;
            w0Var.a(optJSONObject);
            w0Var2 = w0.b.f5207a;
            if (!w0Var2.a("feature_terrain") && MapsInitializer.isTerrainEnable() && (iAMapDelegate3 = this.f4963b.get()) != null) {
                iAMapDelegate3.setTerrainAuth(false);
                v4.a(new AMapException(AMapException.FEATURE_TERRAIN_NOT_SUPPORT));
            }
            w0Var3 = w0.b.f5207a;
            if (!w0Var3.a("feature_gltf") && (iAMapDelegate2 = this.f4963b.get()) != null && iAMapDelegate2.isUseGLTF()) {
                IGlOverlayLayer glOverlayLayer = iAMapDelegate2.getGlOverlayLayer();
                if (glOverlayLayer != null) {
                    glOverlayLayer.clearOverlayByType("GLTFOVERLAY");
                }
                v4.a(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
            }
            w0Var4 = w0.b.f5207a;
            if (w0Var4.a("feature_mvt") || (iAMapDelegate = this.f4963b.get()) == null || !iAMapDelegate.isUseMVT()) {
                return;
            }
            IGlOverlayLayer glOverlayLayer2 = iAMapDelegate.getGlOverlayLayer();
            if (glOverlayLayer2 != null) {
                glOverlayLayer2.clearOverlayByType("MVTTILEOVERLAY");
            }
            v4.a(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Pair<JSONObject, c9.c.a> a(StringBuilder sb2) {
        String str;
        JSONObject jSONObject;
        c9.c.a aVar;
        WeakReference<IAMapDelegate> weakReference;
        try {
            long longValue = o4.a(this.f4962a, "cloud_config_pull", "cloud_config_pull_timestamp", (Long) 0L).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - longValue) >= Const.DAY_IN_MILLIS) {
                str = sb2.toString();
                str.replaceAll(";;", Const.STR_MART_SEMICOLON);
                o4.b(this.f4962a, "cloud_config_pull", "cloud_config_pull_timestamp", new Long(currentTimeMillis));
            } else {
                str = "";
            }
            c9.c a3 = c9.a(this.f4962a, v4.b(), str, (Map<String, String>) null);
            if (c9.f3817a != 1 && str != "" && (weakReference = this.f4963b) != null && weakReference.get() != null) {
                Message obtainMessage = this.f4963b.get().getMainHandler().obtainMessage();
                obtainMessage.what = 2;
                String str2 = a3.f3845a;
                if (str2 != null) {
                    obtainMessage.obj = str2;
                }
                this.f4963b.get().getMainHandler().sendMessage(obtainMessage);
            }
            String str3 = GLFileUtil.getCacheDir(this.f4962a).getAbsolutePath() + "/authCustomConfigName";
            if (!TextUtils.isEmpty(str) && (jSONObject = a3.f3847c) != null) {
                GLFileUtil.writeDatasToFile(str3, jSONObject.toString().getBytes());
            } else {
                jSONObject = new JSONObject(new String(GLFileUtil.readFileContents(str3)));
            }
            String str4 = GLFileUtil.getCacheDir(this.f4962a).getAbsolutePath() + "/authLogConfigName";
            if (!TextUtils.isEmpty(str) && a3.f3848d != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("IsExceptionUpdate", a3.f3848d.f3849a);
                jSONObject2.put("mOfflineLoc", a3.f3848d.f3850b);
                GLFileUtil.writeDatasToFile(str4, jSONObject2.toString().getBytes());
                aVar = a3.f3848d;
            } else {
                byte[] readFileContents = GLFileUtil.readFileContents(str4);
                c9.c.a aVar2 = new c9.c.a();
                JSONObject jSONObject3 = new JSONObject(new String(readFileContents));
                aVar2.f3849a = jSONObject3.getBoolean("IsExceptionUpdate");
                if (jSONObject3.has("mOfflineLoc")) {
                    aVar2.f3850b = jSONObject3.getJSONObject("mOfflineLoc");
                }
                aVar = aVar2;
            }
            return new Pair<>(jSONObject, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }
}
