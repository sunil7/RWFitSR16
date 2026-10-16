package com.amap.api.col.p0003sl;

import android.content.Context;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.s3;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a0 implements s3.a {
    private a A;

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f3538a;

    /* renamed from: b, reason: collision with root package name */
    private CustomMapStyleOptions f3539b;

    /* renamed from: h, reason: collision with root package name */
    private int f3544h;

    /* renamed from: i, reason: collision with root package name */
    private Context f3545i;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3551o;

    /* renamed from: s, reason: collision with root package name */
    private s3 f3554s;

    /* renamed from: t, reason: collision with root package name */
    private s3 f3555t;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3558w;

    /* renamed from: y, reason: collision with root package name */
    private AMap3DModelTileOverlay f3560y;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3540c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3541d = false;
    private boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3542f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3543g = false;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f3546j = null;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f3547k = null;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f3548l = null;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f3549m = null;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f3550n = null;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3552p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3553q = false;
    private boolean r = false;

    /* renamed from: u, reason: collision with root package name */
    private byte[] f3556u = null;

    /* renamed from: v, reason: collision with root package name */
    private byte[] f3557v = null;

    /* renamed from: x, reason: collision with root package name */
    private HashMap<String, byte[]> f3559x = new HashMap<>();

    /* renamed from: z, reason: collision with root package name */
    private MyTrafficStyle f3561z = new MyTrafficStyle();

    public interface a {
    }

    public a0(IAMapDelegate iAMapDelegate, Context context, boolean z5) {
        this.f3544h = -1;
        this.f3551o = false;
        this.f3558w = false;
        this.f3538a = iAMapDelegate;
        this.f3545i = context;
        this.f3551o = false;
        this.f3558w = z5;
        this.f3544h = ((b0) iAMapDelegate).getGLMapEngine().getEngineIDWithType(1);
    }

    private void a(byte[] bArr) {
        w3 a3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (bArr == null || (a3 = z3.a(bArr)) == null || a3.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(a3.a());
            JSONObject optJSONObject3 = jSONObject.optJSONObject("mapStyle");
            String str = null;
            boolean z5 = true;
            if (optJSONObject3 != null && (optJSONObject2 = optJSONObject3.optJSONObject("bg")) != null) {
                z5 = optJSONObject2.optBoolean("visible", true);
                str = optJSONObject2.optString("lineColor", null);
            }
            a(str, z5);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("layer");
            if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("traffic")) != null) {
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("multiFillColors");
                if (optJSONObject.optBoolean("visible") && optJSONObject5 != null) {
                    int a10 = z3.a(optJSONObject5.optString("smooth"));
                    int a11 = z3.a(optJSONObject5.optString("slow"));
                    int a12 = z3.a(optJSONObject5.optString("congested"));
                    int a13 = z3.a(optJSONObject5.optString("seriousCongested"));
                    this.f3561z.setSmoothColor(a10);
                    this.f3561z.setSlowColor(a11);
                    this.f3561z.setCongestedColor(a12);
                    this.f3561z.setSeriousCongestedColor(a13);
                    if (this.f3550n == null) {
                        this.f3550n = FileUtil.readFileContentsFromAssets(this.f3545i, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_TRL_NAME);
                    }
                    this.f3538a.setTrafficStyleWithTexture(this.f3550n, this.f3561z);
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("third_layer");
            if (optJSONObject6 != null) {
                this.f3538a.getGLMapEngine().setCustomThirdLayerStyle(this.f3544h, optJSONObject6.toString());
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("model_layer");
            if (optJSONObject7 != null) {
                a(optJSONObject7.optString("id"));
            }
        } catch (Throwable th2) {
            ka.a(th2, "AMapCustomStyleManager", "setExtraStyle");
            v4.a(th2);
        }
    }

    public static byte[] b(byte[] bArr) {
        Throwable th2;
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read < 0) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    v4.a(th2);
                    th2.printStackTrace();
                    return null;
                } finally {
                    GLFileUtil.closeQuietly(byteArrayOutputStream);
                    GLFileUtil.closeQuietly(byteArrayInputStream);
                    GLFileUtil.closeQuietly(gZIPInputStream);
                }
            }
        } catch (Throwable th4) {
            th2 = th4;
            gZIPInputStream = null;
        }
    }

    private void e() {
        if (this.f3558w) {
            if (this.f3546j == null) {
                this.f3546j = b(FileUtil.readFileContentsFromAssets(this.f3545i, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_ABROAD));
            }
        } else if (this.f3546j == null) {
            this.f3546j = b(FileUtil.readFileContentsFromAssets(this.f3545i, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA));
        }
        this.f3538a.getGLMapEngine().setCustomStyleData(this.f3544h, this.f3546j, null);
        this.f3553q = false;
        this.f3559x.clear();
    }

    private void f() {
        if (this.f3552p) {
            if (this.f3548l == null) {
                this.f3548l = FileUtil.readFileContentsFromAssets(this.f3545i, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
            }
            this.f3552p = false;
            this.f3538a.getGLMapEngine().setCustomStyleTexture(this.f3544h, this.f3548l);
        }
    }

    private void g() {
        IAMapDelegate iAMapDelegate = this.f3538a;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && this.f3550n != null) {
            this.f3538a.getGLMapEngine().setTrafficStyleWithTexture(this.f3544h, this.f3550n, new MyTrafficStyle());
        }
        IAMapDelegate iAMapDelegate2 = this.f3538a;
        if (iAMapDelegate2 != null && iAMapDelegate2.getGLMapEngine() != null && this.f3547k != null) {
            this.f3538a.getGLMapEngine().setBackgroundTexture(this.f3544h, this.f3547k);
        }
        AMap3DModelTileOverlay aMap3DModelTileOverlay = this.f3560y;
        if (aMap3DModelTileOverlay != null) {
            aMap3DModelTileOverlay.remove();
        }
        this.r = false;
    }

    private void h() {
        CustomMapStyleOptions customMapStyleOptions = this.f3539b;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.f3539b.setStyleDataPath(null);
            this.f3539b.setStyleData(null);
            this.f3539b.setStyleTexturePath(null);
            this.f3539b.setStyleTextureData(null);
            this.f3539b.setStyleExtraData(null);
            this.f3539b.setStyleExtraPath(null);
        }
    }

    public void c() {
        if (this.f3539b == null) {
            return;
        }
        synchronized (this) {
            try {
                IAMapDelegate iAMapDelegate = this.f3538a;
                if (iAMapDelegate != null && iAMapDelegate.getMapConfig() != null && !this.f3538a.getMapConfig().isProFunctionAuthEnable()) {
                    this.f3539b.setStyleId(null);
                    this.f3556u = null;
                    this.f3557v = null;
                }
                this.e = true;
                this.f3541d = true;
                if (this.r) {
                    this.f3542f = true;
                }
                this.f3540c = true;
                this.f3543g = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void d() {
        synchronized (this) {
            try {
                CustomMapStyleOptions customMapStyleOptions = this.f3539b;
                if (customMapStyleOptions != null) {
                    customMapStyleOptions.setEnable(false);
                    h();
                    this.f3540c = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x019a A[Catch: all -> 0x0047, TryCatch #1 {all -> 0x0047, blocks: (B:11:0x0013, B:13:0x001b, B:15:0x001f, B:17:0x0025, B:19:0x0031, B:21:0x0039, B:23:0x003d, B:24:0x004a, B:25:0x0054, B:27:0x0058, B:28:0x0061, B:30:0x0065, B:32:0x006d, B:33:0x007e, B:35:0x0099, B:37:0x009f, B:39:0x00a5, B:40:0x00a8, B:42:0x00af, B:43:0x00b2, B:44:0x00b5, B:45:0x00b7, B:47:0x00b9, B:49:0x00bd, B:51:0x00cb, B:53:0x00d1, B:54:0x00da, B:56:0x00e2, B:58:0x00e8, B:59:0x0106, B:60:0x00ff, B:61:0x0103, B:62:0x0108, B:64:0x010c, B:66:0x011a, B:68:0x0120, B:69:0x0129, B:71:0x0131, B:74:0x0136, B:76:0x013a, B:77:0x01b4, B:78:0x0143, B:80:0x0147, B:83:0x0160, B:85:0x0171, B:91:0x019a, B:92:0x019e, B:94:0x01b1, B:99:0x018d, B:100:0x0176, B:101:0x01b6, B:103:0x01ba, B:105:0x01c8, B:107:0x01ce, B:108:0x01d7, B:110:0x01df, B:112:0x01f5, B:113:0x01e3, B:117:0x01f0, B:118:0x01e8, B:119:0x01f7, B:121:0x01fb, B:122:0x0200, B:96:0x017f), top: B:10:0x0013, outer: #0, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019e A[Catch: all -> 0x0047, TryCatch #1 {all -> 0x0047, blocks: (B:11:0x0013, B:13:0x001b, B:15:0x001f, B:17:0x0025, B:19:0x0031, B:21:0x0039, B:23:0x003d, B:24:0x004a, B:25:0x0054, B:27:0x0058, B:28:0x0061, B:30:0x0065, B:32:0x006d, B:33:0x007e, B:35:0x0099, B:37:0x009f, B:39:0x00a5, B:40:0x00a8, B:42:0x00af, B:43:0x00b2, B:44:0x00b5, B:45:0x00b7, B:47:0x00b9, B:49:0x00bd, B:51:0x00cb, B:53:0x00d1, B:54:0x00da, B:56:0x00e2, B:58:0x00e8, B:59:0x0106, B:60:0x00ff, B:61:0x0103, B:62:0x0108, B:64:0x010c, B:66:0x011a, B:68:0x0120, B:69:0x0129, B:71:0x0131, B:74:0x0136, B:76:0x013a, B:77:0x01b4, B:78:0x0143, B:80:0x0147, B:83:0x0160, B:85:0x0171, B:91:0x019a, B:92:0x019e, B:94:0x01b1, B:99:0x018d, B:100:0x0176, B:101:0x01b6, B:103:0x01ba, B:105:0x01c8, B:107:0x01ce, B:108:0x01d7, B:110:0x01df, B:112:0x01f5, B:113:0x01e3, B:117:0x01f0, B:118:0x01e8, B:119:0x01f7, B:121:0x01fb, B:122:0x0200, B:96:0x017f), top: B:10:0x0013, outer: #0, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i() {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.a0.i():void");
    }

    public byte[] b(String str) {
        MapConfig mapConfig = this.f3538a.getMapConfig();
        if (mapConfig == null) {
            return null;
        }
        if (!mapConfig.isProFunctionAuthEnable()) {
            int indexOf = str.indexOf("99999_");
            if (indexOf != -1) {
                str = str.substring(0, indexOf).replace("99999_", "");
            }
            return FileUtil.readFileContentsFromAssetsByPreName(this.f3545i, AMapEngineUtils.MAP_MAP_ASSETS_NAME, str);
        }
        for (String str2 : this.f3559x.keySet()) {
            if (str.contains(str2)) {
                return this.f3559x.get(str2);
            }
        }
        return null;
    }

    private void a(String str) {
        StringBuilder r = e.r("https://" + g9.b(this.f3545i).a(41) + "/rest/lbs/geohub/3d/tiles?z=%d&x=%d&y=%d", "&id=", str);
        AMap3DModelTileProvider aMap3DModelTileProvider = new AMap3DModelTileProvider();
        aMap3DModelTileProvider.setUrl(r.toString());
        AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions = new AMap3DModelTileOverlayOptions();
        aMap3DModelTileOverlayOptions.setTileProvider(aMap3DModelTileProvider);
        try {
            this.f3560y = this.f3538a.add3DModelTileOverlay(aMap3DModelTileOverlayOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean b() {
        return this.f3539b != null;
    }

    private void a(String str, boolean z5) {
        boolean z6;
        int a3 = !TextUtils.isEmpty(str) ? z3.a(str) : Integer.MIN_VALUE;
        IAMapDelegate iAMapDelegate = this.f3538a;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        if (this.f3547k == null) {
            this.f3547k = FileUtil.readFileContentsFromAssets(this.f3545i, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_CUSTOM_BACKGROUND_NAME);
        }
        byte[] bArr = this.f3547k;
        if (bArr != null) {
            if (z5) {
                z6 = a3 == Integer.MIN_VALUE;
            } else {
                a3 = 0;
                z6 = false;
            }
            this.f3538a.getGLMapEngine().setBackgroundTexture(this.f3544h, v4.a((byte[]) bArr.clone(), 0, a3, z6));
        }
    }

    public void a(CustomMapStyleOptions customMapStyleOptions, AMap.OnCustomMapStyleListener onCustomMapStyleListener) {
        IAMapDelegate iAMapDelegate;
        if (this.f3539b == null) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.f3551o) {
                    this.f3551o = true;
                    if (this.f3539b.isEnable()) {
                        this.f3540c = true;
                    }
                }
                if (this.f3539b.isEnable() != customMapStyleOptions.isEnable()) {
                    this.f3539b.setEnable(customMapStyleOptions.isEnable());
                    this.f3540c = true;
                    t4.b(this.f3545i, customMapStyleOptions.isEnable());
                }
                if (this.f3539b.isEnable()) {
                    if (!TextUtils.equals(this.f3539b.getStyleId(), customMapStyleOptions.getStyleId())) {
                        this.f3539b.setStyleId(customMapStyleOptions.getStyleId());
                        String styleId = this.f3539b.getStyleId();
                        if (!TextUtils.isEmpty(styleId) && (iAMapDelegate = this.f3538a) != null && iAMapDelegate.getMapConfig() != null && this.f3538a.getMapConfig().isProFunctionAuthEnable()) {
                            s3 s3Var = this.f3554s;
                            if (s3Var != null) {
                                u4.b().getClass();
                                try {
                                    s3Var.cancelTask();
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                }
                                this.f3554s = null;
                            }
                            if (this.f3558w) {
                                this.f3554s = new s3(this.f3545i, this, 2, "abroad_sdk_json_sdk_1110_zip");
                            } else {
                                this.f3554s = new s3(this.f3545i, this, 1, "sdk_1110");
                            }
                            if (onCustomMapStyleListener != null) {
                                this.f3554s.a(onCustomMapStyleListener);
                            }
                            this.f3554s.b(styleId);
                            s3 s3Var2 = this.f3554s;
                            s3Var2.getClass();
                            u4.b().a(s3Var2);
                            if (this.f3555t == null) {
                                this.f3555t = new s3(this.f3545i, this, 0, null);
                            }
                            if (onCustomMapStyleListener != null) {
                                this.f3555t.a(onCustomMapStyleListener);
                            }
                            this.f3555t.b(styleId);
                            s3 s3Var3 = this.f3555t;
                            s3Var3.getClass();
                            u4.b().a(s3Var3);
                        }
                    }
                    if (!TextUtils.equals(this.f3539b.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                        this.f3539b.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                        this.f3541d = true;
                    }
                    if (this.f3539b.getStyleData() != customMapStyleOptions.getStyleData()) {
                        this.f3539b.setStyleData(customMapStyleOptions.getStyleData());
                        this.f3541d = true;
                    }
                    if (!TextUtils.equals(this.f3539b.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                        this.f3539b.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                        this.e = true;
                    }
                    if (this.f3539b.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                        this.f3539b.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                        this.e = true;
                    }
                    if (!TextUtils.equals(this.f3539b.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                        this.f3539b.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                        this.f3542f = true;
                    }
                    if (this.f3539b.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                        this.f3539b.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                        this.f3542f = true;
                    }
                    if (!TextUtils.equals(this.f3539b.getStyleResDataPath(), customMapStyleOptions.getStyleResDataPath())) {
                        this.f3539b.setStyleResDataPath(customMapStyleOptions.getStyleResDataPath());
                        this.f3543g = true;
                    }
                    if (this.f3539b.getStyleResData() != customMapStyleOptions.getStyleResData()) {
                        this.f3539b.setStyleResData(customMapStyleOptions.getStyleResData());
                        this.f3543g = true;
                    }
                    t4.a(this.f3545i, true);
                } else {
                    h();
                    t4.a(this.f3545i, false);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public void a(byte[] bArr, int i3) {
        MapConfig mapConfig;
        a aVar;
        if (this.f3539b != null) {
            synchronized (this) {
                try {
                    IAMapDelegate iAMapDelegate = this.f3538a;
                    if (iAMapDelegate != null && (mapConfig = iAMapDelegate.getMapConfig()) != null && mapConfig.isProFunctionAuthEnable()) {
                        mapConfig.setUseProFunction(true);
                        if (i3 == 1) {
                            this.f3556u = bArr;
                            this.f3541d = true;
                        } else if (i3 == 0) {
                            this.f3557v = bArr;
                            this.f3542f = true;
                        } else if (i3 == 2) {
                            String str = this.f3539b.getStyleId() + "_sdk_1110.data";
                            String str2 = this.f3539b.getStyleId() + "_abroad_sdk.json";
                            Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr, new String[]{str, str2});
                            if (uncompressToByteWithKeys != null) {
                                byte[] bArr2 = uncompressToByteWithKeys.get(str);
                                if (bArr2 != null) {
                                    this.f3556u = bArr2;
                                    this.f3541d = true;
                                }
                                byte[] bArr3 = uncompressToByteWithKeys.get(str2);
                                if (bArr3 != null && (aVar = this.A) != null) {
                                    ((b0) aVar).a(bArr3);
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private void a(MapConfig mapConfig) {
        byte[] styleResData;
        byte[] bArr;
        if (!mapConfig.isProFunctionAuthEnable()) {
            this.f3559x.clear();
            return;
        }
        String styleResDataPath = this.f3539b.getStyleResDataPath();
        if (this.f3539b.getStyleResData() == null && !TextUtils.isEmpty(styleResDataPath)) {
            this.f3539b.setStyleResData(FileUtil.readFileContents(styleResDataPath));
        }
        if (this.f3539b.getStyleResData() == null || (styleResData = this.f3539b.getStyleResData()) == null) {
            return;
        }
        mapConfig.setUseProFunction(true);
        this.f3559x.clear();
        Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(styleResData, null);
        if (uncompressToByteWithKeys != null) {
            for (String str : uncompressToByteWithKeys.keySet()) {
                if (str != null && !str.contains("__MACOSX") && (bArr = uncompressToByteWithKeys.get(str)) != null) {
                    if (FileUtil.isGzip(bArr)) {
                        this.f3559x.put(str, bArr);
                    } else {
                        this.f3559x.put(str, FileUtil.compress(bArr));
                    }
                }
            }
        }
    }

    public void a(a aVar) {
        this.A = aVar;
    }

    public void a() {
        if (this.f3539b == null) {
            this.f3539b = new CustomMapStyleOptions();
        }
    }
}
