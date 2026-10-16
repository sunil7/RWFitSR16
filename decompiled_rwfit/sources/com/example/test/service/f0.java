package com.example.test.service;

import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;
import com.example.blesdk.bean.function.MusicPushBean;

/* loaded from: classes.dex */
public final class f0 extends MediaController.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaController f7700a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f7701b;

    public f0(h0 h0Var, MediaController mediaController) {
        this.f7701b = h0Var;
        this.f7700a = mediaController;
    }

    @Override // android.media.session.MediaController.Callback
    public final void onMetadataChanged(MediaMetadata mediaMetadata) {
        if (mediaMetadata != null) {
            String string = mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_TITLE);
            String string2 = mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_ARTIST);
            mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST);
            String string3 = mediaMetadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM);
            int currentVolume = this.f7700a.getPlaybackInfo().getCurrentVolume();
            h0 h0Var = this.f7701b;
            h0Var.f7714d = currentVolume;
            String str = string + "_" + string3 + "_" + currentVolume + "_" + h0Var.e;
            StringBuilder v6 = com.google.android.gms.internal.mlkit_vision_barcode.l0.v("MusicControll onMetadataChanged trackName ", string, " artistName ", string2, " albumName ");
            v6.append(string3);
            Log.e("qob", v6.toString());
            if (str.equals(h0Var.f7713c)) {
                Log.e("qob", "MusicControll onMetadataChanged TAG名字相同");
                return;
            }
            MusicPushBean musicPushBean = new MusicPushBean();
            musicPushBean.setEntity(2);
            musicPushBean.setAttr(2);
            musicPushBean.setContent(string);
            com.google.android.gms.internal.mlkit_vision_common.p.B(musicPushBean);
            MusicPushBean musicPushBean2 = new MusicPushBean();
            musicPushBean2.setEntity(0);
            musicPushBean2.setAttr(1);
            if (h0Var.e.booleanValue()) {
                musicPushBean2.setContent("1");
            } else {
                musicPushBean2.setContent("0");
            }
            com.google.android.gms.internal.mlkit_vision_common.p.B(musicPushBean2);
            h0Var.f7713c = str;
        }
    }

    @Override // android.media.session.MediaController.Callback
    public final void onPlaybackStateChanged(PlaybackState playbackState) {
        String str;
        if (playbackState != null) {
            boolean z5 = playbackState.getState() == 3;
            Boolean valueOf = Boolean.valueOf(z5);
            h0 h0Var = this.f7701b;
            h0Var.e = valueOf;
            MediaController mediaController = this.f7700a;
            if (mediaController == null) {
                return;
            }
            int currentVolume = mediaController.getPlaybackInfo().getCurrentVolume();
            int maxVolume = (int) ((currentVolume / mediaController.getPlaybackInfo().getMaxVolume()) * 100.0f);
            h0Var.f7714d = currentVolume;
            String[] split = h0Var.f7713c.split("_");
            if (split.length > 1) {
                str = split[0] + "_" + split[1] + "_" + currentVolume + "_" + z5;
            } else {
                str = "";
            }
            Log.e("qob", "MusicControll onPlaybackStateChanged  isPlaying " + z5 + " currentVolume " + maxVolume);
            if (str.equals(h0Var.f7713c)) {
                Log.e("qob", "MusicControll onPlaybackStateChanged TAG名字相同");
                return;
            }
            MusicPushBean musicPushBean = new MusicPushBean();
            musicPushBean.setEntity(0);
            musicPushBean.setAttr(2);
            musicPushBean.setContent(maxVolume + "");
            com.google.android.gms.internal.mlkit_vision_common.p.B(musicPushBean);
            MusicPushBean musicPushBean2 = new MusicPushBean();
            musicPushBean2.setEntity(0);
            musicPushBean2.setAttr(1);
            if (z5) {
                musicPushBean2.setContent("1");
            } else {
                musicPushBean2.setContent("0");
            }
            com.google.android.gms.internal.mlkit_vision_common.p.B(musicPushBean2);
            h0Var.f7713c = str;
        }
    }
}
