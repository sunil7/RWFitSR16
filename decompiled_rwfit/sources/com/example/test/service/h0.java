package com.example.test.service;

import android.content.ContextWrapper;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;
import android.view.KeyEvent;
import com.example.blesdk.bean.function.MusicPushBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public List f7711a;

    /* renamed from: b, reason: collision with root package name */
    public ContextWrapper f7712b;

    /* renamed from: c, reason: collision with root package name */
    public String f7713c;

    /* renamed from: d, reason: collision with root package name */
    public int f7714d;
    public Boolean e;

    /* renamed from: f, reason: collision with root package name */
    public long f7715f;

    /* renamed from: g, reason: collision with root package name */
    public f0 f7716g;

    public final ArrayList a() {
        boolean z5;
        ArrayList arrayList = new ArrayList();
        try {
            ContextWrapper contextWrapper = this.f7712b;
            if (((HashSet) y0.r.a(contextWrapper)).contains(contextWrapper.getPackageName())) {
                Log.e("musicControll", "isNotificationListenerEnabled true");
                z5 = true;
            } else {
                Log.e("musicControll", "isNotificationListenerEnabled false");
                z5 = false;
            }
            if (z5) {
                for (MediaController mediaController : this.f7711a) {
                    if (mediaController.getMetadata() != null) {
                        String string = mediaController.getMetadata().getString(MediaMetadataCompat.METADATA_KEY_TITLE);
                        mediaController.getMetadata().getString(MediaMetadataCompat.METADATA_KEY_ARTIST);
                        mediaController.getMetadata().getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST);
                        String string2 = mediaController.getMetadata().getString(MediaMetadataCompat.METADATA_KEY_ALBUM);
                        boolean z6 = mediaController.getPlaybackState().getState() == 3;
                        this.e = Boolean.valueOf(z6);
                        int currentVolume = mediaController.getPlaybackInfo().getCurrentVolume();
                        int maxVolume = (int) ((currentVolume / mediaController.getPlaybackInfo().getMaxVolume()) * 100.0f);
                        String str = string + "_" + string2 + "_" + currentVolume + "_" + this.e;
                        if (str.equals(this.f7713c)) {
                            Log.e("qob", "MusicControll getCurrentMusicInfo TAG名字相同");
                            return arrayList;
                        }
                        this.f7713c = str;
                        if (string != null && string.length() > 1) {
                            MusicPushBean musicPushBean = new MusicPushBean();
                            musicPushBean.setEntity(2);
                            musicPushBean.setAttr(2);
                            musicPushBean.setContent(string);
                            arrayList.add(musicPushBean);
                        }
                        if (currentVolume != this.f7714d) {
                            MusicPushBean musicPushBean2 = new MusicPushBean();
                            musicPushBean2.setEntity(0);
                            musicPushBean2.setAttr(2);
                            musicPushBean2.setContent(maxVolume + "");
                            arrayList.add(musicPushBean2);
                            this.f7714d = currentVolume;
                        } else {
                            Log.e("qob", "MusicControll getCurrentMusicInfo 音量值相同 不同步");
                        }
                        MusicPushBean musicPushBean3 = new MusicPushBean();
                        musicPushBean3.setEntity(0);
                        musicPushBean3.setAttr(1);
                        if (z6) {
                            musicPushBean3.setContent("1");
                        } else {
                            musicPushBean3.setContent("0");
                        }
                        arrayList.add(musicPushBean3);
                        this.f7713c = string + "_" + string2 + "_" + currentVolume + "_" + z6;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("MusicControll 22222 ");
                        sb2.append(string);
                        sb2.append(" isPlaying ");
                        sb2.append(z6);
                        sb2.append(" currentVolume  packgetID ");
                        sb2.append(mediaController.getPackageName());
                        Log.e("qob", sb2.toString());
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final void b(int i3) {
        AudioManager audioManager = (AudioManager) this.f7712b.getSystemService("audio");
        audioManager.dispatchMediaKeyEvent(new KeyEvent(0, i3));
        audioManager.dispatchMediaKeyEvent(new KeyEvent(1, i3));
    }

    public final void c() {
        for (MediaController mediaController : this.f7711a) {
            if (this.f7716g == null) {
                this.f7716g = new f0(this, mediaController);
            }
            mediaController.registerCallback(this.f7716g);
        }
    }

    public final void d(int i3) {
        AudioManager audioManager = (AudioManager) this.f7712b.getSystemService("audio");
        if (i3 == 6) {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3) / 10;
            audioManager.setStreamVolume(3, streamVolume - (streamMaxVolume >= 1 ? streamMaxVolume : 1), 0);
        } else if (i3 == 5) {
            int streamVolume2 = audioManager.getStreamVolume(3);
            int streamMaxVolume2 = audioManager.getStreamMaxVolume(3);
            int i10 = streamMaxVolume2 / 10;
            int i11 = i10 >= 1 ? i10 : 1;
            Log.e("qob", "提高音量 " + streamVolume2 + " maxVolume " + streamMaxVolume2);
            audioManager.setStreamVolume(3, streamVolume2 + i11, 0);
        }
    }
}
