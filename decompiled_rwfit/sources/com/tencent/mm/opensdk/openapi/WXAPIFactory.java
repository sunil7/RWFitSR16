package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.mm.opensdk.utils.Log;

/* loaded from: classes2.dex */
public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        throw new RuntimeException(getClass().getSimpleName().concat(" should not be instantiated"));
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, true);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z5) {
        Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z5);
        return new WXApiImplV10(context, str, z5);
    }
}
