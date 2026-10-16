package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p0003sl.a1;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.c9;
import com.amap.api.col.p0003sl.f9;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.maps.model.LatLng;

/* loaded from: classes.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    public static String TERRAIN_LOCAL_DEM_SOURCE_PATH = null;
    private static boolean closeTileOverlay = false;
    private static ExceptionLogger exceptionLogger = null;
    private static boolean isContourLineEnable = false;
    private static boolean isLoadWorldGridMap = false;
    private static boolean isNeedDownloadCoordinateConvertLibrary = true;
    private static boolean isNetWorkEnable = true;
    private static boolean isPolyline2Enable = true;
    private static boolean isSupportRecycleView = true;
    private static boolean isTerrainEnable = false;
    private static boolean isTextureDestroyedRender = false;
    private static boolean isTextureSizeChangedInvoked = false;
    private static boolean isTextureViewDestorySync = true;
    private static boolean isloadWorldVectorMap = false;
    private static String mWorldVectorOfflineMapStyleAssetsPath = "";
    private static String mWorldVectorOfflineMapStyleFilePath = "";
    private static String sLibAbi = "";
    private static String sLibPath = "";
    public static String sdcardDir = "";
    private static LatLng sRegionLocation = new LatLng(39.909016d, 116.39746d);
    private static int mMapVersion = 0;
    private static int mProtocol = 1;

    public static void disableCachedMapDataUpdate(boolean z5) {
    }

    public static String getDeviceId(Context context) {
        return f9.l(context);
    }

    public static ExceptionLogger getExceptionLogger() {
        return exceptionLogger;
    }

    public static String getLibAbi() {
        return sLibAbi;
    }

    public static String getLibPath() {
        return sLibPath;
    }

    public static boolean getNetWorkEnable() {
        return isNetWorkEnable;
    }

    public static boolean getPolyline2Enable() {
        return true;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static int getRegionLanguageType() {
        return b9.b();
    }

    public static boolean getTextureDestroyRender() {
        return isTextureDestroyedRender;
    }

    public static boolean getTextureSizeChangedInvoked() {
        return isTextureSizeChangedInvoked;
    }

    public static boolean getTextureViewDestorySync() {
        return isTextureViewDestorySync;
    }

    public static String getVersion() {
        return "11.1.063";
    }

    public static String getWorldVectorOfflineMapStyleAssetsPath() {
        return mWorldVectorOfflineMapStyleAssetsPath;
    }

    public static String getWorldVectorOfflineMapStyleFilePath() {
        return mWorldVectorOfflineMapStyleFilePath;
    }

    public static void initRegionLanguageType(int i3) {
        b9.a(i3);
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            a1.f3562f = context.getApplicationContext();
        } else {
            Log.w("MapsInitializer", "the context is null");
        }
    }

    public static boolean isContourLineEnable() {
        return isContourLineEnable;
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return isNeedDownloadCoordinateConvertLibrary;
    }

    public static boolean isLoadWorldGridMap() {
        return isLoadWorldGridMap;
    }

    public static boolean isLoadWorldVectorMap() {
        return isloadWorldVectorMap;
    }

    public static boolean isSupportRecycleView() {
        return isSupportRecycleView;
    }

    public static boolean isTerrainEnable() {
        return isTerrainEnable;
    }

    public static void loadWorldVectorMap(boolean z5) {
        isloadWorldVectorMap = z5;
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        c9.a(a1.f3562f, str);
    }

    public static void setBuildingHeight(int i3) {
    }

    public static void setContourLIneEnable(boolean z5) {
        isContourLineEnable = z5;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z5) {
        isNeedDownloadCoordinateConvertLibrary = z5;
    }

    public static void setExceptionLogger(ExceptionLogger exceptionLogger2) {
        exceptionLogger = exceptionLogger2;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            ib.f4306a = -1;
            ib.f4307b = "";
        } else {
            ib.f4306a = 1;
            ib.f4307b = str;
        }
    }

    public static void setLibPath(String str, String str2) {
        sLibPath = str;
        sLibAbi = str2;
    }

    public static void setNetWorkEnable(boolean z5) {
        isNetWorkEnable = z5;
    }

    public static void setPolyline2Enable(boolean z5) {
    }

    public static void setProtocol(int i3) {
        mProtocol = i3;
    }

    public static void setSupportRecycleView(boolean z5) {
        isSupportRecycleView = z5;
    }

    public static void setTerrainEnable(boolean z5) {
        isTerrainEnable = z5;
    }

    public static void setTextureDestroyedRender(boolean z5) {
        isTextureDestroyedRender = z5;
    }

    public static void setTextureSizeChangedInvoked(boolean z5) {
        isTextureSizeChangedInvoked = z5;
    }

    public static void setTextureViewDestorySync(boolean z5) {
        isTextureViewDestorySync = z5;
    }

    public static void setWorldVectorOfflineMapStyleAssetsPath(String str) {
        mWorldVectorOfflineMapStyleAssetsPath = str;
    }

    public static void setWorldVectorOfflineMapStyleFilePath(String str) {
        mWorldVectorOfflineMapStyleFilePath = str;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z5) {
        synchronized (MapsInitializer.class) {
            k9.a(context, z5, v4.b());
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z5, boolean z6) {
        synchronized (MapsInitializer.class) {
            k9.a(context, z5, z6, v4.b());
        }
    }
}
