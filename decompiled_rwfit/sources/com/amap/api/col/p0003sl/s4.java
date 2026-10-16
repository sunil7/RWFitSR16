package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* loaded from: classes.dex */
public class s4 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5003a = new File("/system/framework/amap.jar").exists();

    public static AssetManager a(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (f5003a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, "/system/framework/amap.jar");
                return assets;
            } catch (Throwable th2) {
                ka.a(th2, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
