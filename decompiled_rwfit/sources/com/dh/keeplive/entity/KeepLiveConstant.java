package com.dh.keeplive.entity;

import com.example.test.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class KeepLiveConstant {
    public static final String KEEP_LIVE_CONFIG = "keepLiveConfig";
    public static final String KEEP_LIVE_EMOTE_SERVICE = "keepLiveRemoteService";
    public static final String KEEP_LIVE_FLAG_STOP = "com.xj.keeplive.flag.stop";
    public static final String KEEP_LIVE_JOB_ID = "jobId";
    public static final String KEEP_LIVE_NOTIFICATION_CONFIG = "notificationConfig";
    public static final String KEEP_LIVE_PACKAGE = "com.xj.keeplive";
    public static final String KEEP_LIVE_SERVICE_ID = "serviceId";
    public static final String KEEP_LIVE_TAG = "keeplive";
    public static final KeepLiveConstant INSTANCE = new KeepLiveConstant();
    private static final ArrayList<b> CALLBACKS = new ArrayList<>();
    private static final ArrayList<Object> BACKGROUND_CALLBACKS = new ArrayList<>();

    private KeepLiveConstant() {
    }

    public final ArrayList<Object> getBACKGROUND_CALLBACKS$keeplive_release() {
        return BACKGROUND_CALLBACKS;
    }

    public final ArrayList<b> getCALLBACKS$keeplive_release() {
        return CALLBACKS;
    }
}
