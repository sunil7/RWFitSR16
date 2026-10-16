package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.os.Looper;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.e9;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.rc;
import com.amap.api.col.p0003sl.t4;
import com.amap.api.col.p0003sl.u4;
import com.amap.api.col.p0003sl.v0;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.col.p0003sl.y4;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.config.a;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.File;

/* loaded from: classes.dex */
public class AeUtil {
    private static final String AMAP_ASSETS_DB_CK_PATH = "ae/res.ck";
    private static final String AMAP_GLOBAL_DB_NAME = "global.db";
    private static final String AMAP_GLOBAL_SP_ITEM_MD5 = "amap_res_global_db_md5";
    private static final String AMAP_GLOBAL_SP_NAME = "amap_res_global_db";
    private static final String AMAP_INTERSECTION_ASSETS_DIR = "VM3DRes";
    public static final String AMAP_RESZIP_TARGET_DIR_NAME = "res920";
    public static final String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final String RESZIPNAME = "res.zip";
    public static final String ROOTPATH = "/amap/";
    public static final String ROOT_DATA_PATH_NAME = "data_v6";
    public static final String ROOT_DATA_PATH_OLD_NAME = "data";
    private static String global_db_path;

    private static boolean checkEngineRes(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.getName().contains(AMAP_GLOBAL_DB_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkLib(String str, String str2) {
        String b3 = e9.b(str);
        if (TextUtils.equals(str2, "arm64-v8a")) {
            return TextUtils.equals(b3, v0.f5166a[0]);
        }
        if (TextUtils.equals(str2, "armeabi-v7a")) {
            return TextUtils.equals(b3, v0.f5166a[1]);
        }
        if (TextUtils.equals(str2, "x86_64")) {
            return TextUtils.equals(b3, v0.f5166a[2]);
        }
        return false;
    }

    private static String formatFileSeparator(String str) {
        return str != null ? str.replace("//", "/") : str;
    }

    private static String getAssetsGlobalDbMd5(Context context) {
        return new String(FileUtil.readFileContentsFromAssets(context, AMAP_ASSETS_DB_CK_PATH));
    }

    public static String getGlobalDbPath() {
        return global_db_path;
    }

    public static void initCrashHandle(Context context) {
    }

    public static void initIntersectionRes(final Context context, final GLMapEngine.InitParam initParam) {
        String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String l3 = e.l(mapBaseStorage, "/VM3DRes/");
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(l3);
        if (!file2.exists()) {
            file2.mkdir();
        }
        initParam.mIntersectionResPath = l3;
        initParam.mIntersectionResPath = formatFileSeparator(l3);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            loadAndSaveIntersectionRes("map_assets/VM3DRes", initParam.mIntersectionResPath, context);
            return;
        }
        try {
            u4.b().a(new rc() { // from class: com.autonavi.base.amap.mapcore.AeUtil.2
                @Override // com.amap.api.col.p0003sl.rc
                public void runTask() {
                    AeUtil.loadAndSaveIntersectionRes("map_assets/VM3DRes", GLMapEngine.InitParam.this.mIntersectionResPath, context);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GLMapEngine.InitParam initResource(final Context context) {
        final String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String l3 = e.l(mapBaseStorage, "/data_v6/");
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(l3);
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                u4.b().a(new rc() { // from class: com.autonavi.base.amap.mapcore.AeUtil.1
                    @Override // com.amap.api.col.p0003sl.rc
                    public void runTask() {
                        AeUtil.loadEngineRes(mapBaseStorage, context);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
        byte[] readFileContentsFromAssets = FileUtil.readFileContentsFromAssets(context, "ae/GNaviConfig.xml");
        initParam.mRootPath = mapBaseStorage;
        if (readFileContentsFromAssets != null) {
            try {
                String str = new String(readFileContentsFromAssets, "utf-8");
                initParam.mConfigContent = str;
                if (!str.contains(ROOT_DATA_PATH_NAME)) {
                    throw new Exception("GNaviConfig.xml 和数据目录data_v6不匹配");
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                t4.c(context, "initConfig error:" + th2.getMessage());
            }
        }
        File file3 = new File(l3, "online");
        if (!file3.exists()) {
            file3.mkdir();
        }
        StringBuilder u10 = l0.u(l3, "/");
        u10.append(file3.getName());
        u10.append("/");
        initParam.mOnlineMapDataPath = u10.toString();
        initParam.mOfflineDataPath = e.l(l3, "/map/");
        initParam.mP3dCrossPath = l3;
        initParam.mOnlineMapDataPath = formatFileSeparator(initParam.mOnlineMapDataPath);
        initParam.mOfflineDataPath = formatFileSeparator(initParam.mOfflineDataPath);
        initParam.mRootPath = formatFileSeparator(initParam.mRootPath);
        initParam.mP3dCrossPath = formatFileSeparator(initParam.mP3dCrossPath);
        return initParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadAndSaveIntersectionRes(String str, String str2, Context context) {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            String[] list = context.getAssets().list(str);
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                readAssetsFileAndSave(str + "/" + str3, new File(str2, str3).getAbsolutePath(), context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(1:53)(1:5)|6|(6:8|(1:10)|(1:13)|14|15|(6:23|24|(1:26)|27|29|(2:19|20)(1:22))(2:17|(0)(0)))|50|(0)|14|15|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r8.equals(r10) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0077, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bd, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00bd -> B:26:0x00d2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void loadEngineRes(java.lang.String r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "loadEngineRes error:"
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "res920"
            r1.<init>(r10, r2)
            boolean r10 = r1.exists()
            r2 = 1
            r3 = 0
            r4 = 0
            if (r10 == 0) goto L18
            boolean r10 = r1.isDirectory()
            if (r10 != 0) goto L24
        L18:
            boolean r10 = r1.mkdirs()
            if (r10 == 0) goto L24
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            r5 = r2
            goto L26
        L24:
            r10 = r3
            r5 = r4
        L26:
            java.lang.String r6 = "amap_res_global_db_md5"
            java.lang.String r7 = "amap_res_global_db"
            if (r5 != 0) goto L43
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            java.lang.String r8 = ""
            java.lang.String r8 = com.amap.api.col.p0003sl.o4.a(r11, r7, r6, r8)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L44
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L43
            goto L44
        L43:
            r2 = r5
        L44:
            if (r2 == 0) goto L47
            goto L4b
        L47:
            boolean r4 = checkEngineRes(r1)
        L4b:
            java.lang.String r5 = "/global.db"
            if (r4 != 0) goto Lcc
            android.content.res.AssetManager r4 = r11.getAssets()     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            java.lang.String r8 = "ae/res.zip"
            java.io.InputStream r3 = r4.open(r8)     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            java.lang.String r4 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            com.autonavi.base.amap.mapcore.FileUtil.decompress(r3, r4)     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            r4.<init>()     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            r4.append(r1)     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            r4.append(r5)     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            com.autonavi.base.amap.mapcore.AeUtil.global_db_path = r1     // Catch: java.lang.Throwable -> L79 java.lang.OutOfMemoryError -> L7b java.lang.Exception -> L7d
            if (r3 == 0) goto Ld2
            r3.close()     // Catch: java.io.IOException -> L77
            goto Ld2
        L77:
            r0 = move-exception
            goto Lbd
        L79:
            r10 = move-exception
            goto Lc1
        L7b:
            r1 = move-exception
            goto L7f
        L7d:
            r1 = move-exception
            goto L9e
        L7f:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L79
            com.amap.api.col.p0003sl.v4.a(r1)     // Catch: java.lang.Throwable -> L79
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> L79
            r4.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L79
            com.amap.api.col.p0003sl.t4.c(r11, r0)     // Catch: java.lang.Throwable -> L79
            if (r3 == 0) goto Ld2
            r3.close()     // Catch: java.io.IOException -> L77
            goto Ld2
        L9e:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L79
            com.amap.api.col.p0003sl.v4.a(r1)     // Catch: java.lang.Throwable -> L79
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> L79
            r4.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L79
            com.amap.api.col.p0003sl.t4.c(r11, r0)     // Catch: java.lang.Throwable -> L79
            if (r3 == 0) goto Ld2
            r3.close()     // Catch: java.io.IOException -> L77
            goto Ld2
        Lbd:
            r0.printStackTrace()
            goto Ld2
        Lc1:
            if (r3 == 0) goto Lcb
            r3.close()     // Catch: java.io.IOException -> Lc7
            goto Lcb
        Lc7:
            r11 = move-exception
            r11.printStackTrace()
        Lcb:
            throw r10
        Lcc:
            java.lang.String r0 = android.support.v4.media.session.e.j(r1, r5)
            com.autonavi.base.amap.mapcore.AeUtil.global_db_path = r0
        Ld2:
            if (r2 == 0) goto Ld7
            com.amap.api.col.p0003sl.o4.b(r11, r7, r6, r10)
        Ld7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.AeUtil.loadEngineRes(java.lang.String, android.content.Context):void");
    }

    public static boolean loadLib(Context context) {
        try {
            if (!a.f6848a) {
                System.loadLibrary("AMapSDK_MAP_v11_1_063");
                a.f6848a = true;
            }
            return true;
        } catch (Throwable th2) {
            ka.a(th2, "AeUtil", "loadLib");
            v4.a(th2);
            y4.a("[map][lifecycle]", "load so failed " + th2.getMessage());
            return false;
        }
    }

    public static boolean loadLibPath(Context context) {
        try {
            String libPath = MapsInitializer.getLibPath();
            String libAbi = MapsInitializer.getLibAbi();
            if (!TextUtils.isEmpty(libPath) && !TextUtils.isEmpty(libAbi)) {
                if (checkLib(libPath, libAbi)) {
                    System.load(libPath);
                    return true;
                }
                v4.a(new AMapException(AMapException.ERROR_LIB_NOT_MATCH));
                return false;
            }
            return false;
        } catch (Throwable th2) {
            ka.a(th2, "AeUtil", "loadLibPath");
            v4.a(th2);
            y4.a("[map][lifecycle]", "load so failed " + th2.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x005a A[Catch: IOException -> 0x005e, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x005e, blocks: (B:21:0x0042, B:36:0x005a), top: B:4:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x005f -> B:22:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void readAssetsFileAndSave(java.lang.String r3, java.lang.String r4, android.content.Context r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L7
            goto L62
        L7:
            r0 = 0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L48
            java.io.InputStream r3 = r5.open(r3)     // Catch: java.lang.Throwable -> L48
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L1f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L1f
            boolean r4 = r5.exists()     // Catch: java.lang.Throwable -> L1f
            if (r4 == 0) goto L21
            r5.delete()     // Catch: java.lang.Throwable -> L1f
            goto L21
        L1f:
            r4 = move-exception
            goto L4a
        L21:
            r5.createNewFile()     // Catch: java.lang.Throwable -> L1f
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1f
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L1f
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r5]     // Catch: java.lang.Throwable -> L38
        L2d:
            r1 = 0
            int r2 = r3.read(r0, r1, r5)     // Catch: java.lang.Throwable -> L38
            if (r2 <= 0) goto L3a
            r4.write(r0, r1, r2)     // Catch: java.lang.Throwable -> L38
            goto L2d
        L38:
            r5 = move-exception
            goto L46
        L3a:
            r3.close()     // Catch: java.io.IOException -> L3e
            goto L42
        L3e:
            r3 = move-exception
            r3.printStackTrace()
        L42:
            r4.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L46:
            r0 = r4
            goto L4b
        L48:
            r4 = move-exception
            r3 = r0
        L4a:
            r5 = r4
        L4b:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L63
            if (r3 == 0) goto L58
            r3.close()     // Catch: java.io.IOException -> L54
            goto L58
        L54:
            r3 = move-exception
            r3.printStackTrace()
        L58:
            if (r0 == 0) goto L62
            r0.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r3 = move-exception
            r3.printStackTrace()
        L62:
            return
        L63:
            r4 = move-exception
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.io.IOException -> L6a
            goto L6e
        L6a:
            r3 = move-exception
            r3.printStackTrace()
        L6e:
            if (r0 == 0) goto L78
            r0.close()     // Catch: java.io.IOException -> L74
            goto L78
        L74:
            r3 = move-exception
            r3.printStackTrace()
        L78:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.AeUtil.readAssetsFileAndSave(java.lang.String, java.lang.String, android.content.Context):void");
    }
}
