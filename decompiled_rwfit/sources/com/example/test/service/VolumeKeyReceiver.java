package com.example.test.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.example.blesdk.bean.function.MusicPushBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VolumeKeyReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Log.e("qob", "onReceive " + intent.getAction());
        if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            ArrayList a3 = g0.f7705a.a();
            Log.e("qob", "musicVolumeControlCurrent " + a3.size());
            int size = a3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = a3.get(i3);
                i3++;
                MusicPushBean musicPushBean = (MusicPushBean) obj;
                if (musicPushBean.getAttr() == 2 && musicPushBean.getEntity() == 0) {
                    com.google.android.gms.internal.mlkit_vision_common.p.B(musicPushBean);
                }
            }
        }
    }
}
