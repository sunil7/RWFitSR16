package com.otaliastudios.cameraview.controls;

import android.content.Context;
import android.content.res.TypedArray;
import com.otaliastudios.cameraview.R$styleable;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f11578a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11579b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11580c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11581d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11582f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11583g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11584h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11585i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11586j;

    /* renamed from: k, reason: collision with root package name */
    public final int f11587k;

    /* renamed from: l, reason: collision with root package name */
    public final int f11588l;

    public b(Context context, TypedArray typedArray) {
        this.f11578a = typedArray.getInteger(R$styleable.CameraView_cameraPreview, Preview.DEFAULT.value());
        this.f11579b = typedArray.getInteger(R$styleable.CameraView_cameraFacing, Facing.DEFAULT(context).value());
        this.f11580c = typedArray.getInteger(R$styleable.CameraView_cameraFlash, Flash.DEFAULT.value());
        this.f11581d = typedArray.getInteger(R$styleable.CameraView_cameraGrid, Grid.DEFAULT.value());
        this.e = typedArray.getInteger(R$styleable.CameraView_cameraWhiteBalance, WhiteBalance.DEFAULT.value());
        this.f11582f = typedArray.getInteger(R$styleable.CameraView_cameraMode, Mode.DEFAULT.value());
        this.f11583g = typedArray.getInteger(R$styleable.CameraView_cameraHdr, Hdr.DEFAULT.value());
        this.f11584h = typedArray.getInteger(R$styleable.CameraView_cameraAudio, Audio.DEFAULT.value());
        this.f11585i = typedArray.getInteger(R$styleable.CameraView_cameraVideoCodec, VideoCodec.DEFAULT.value());
        this.f11586j = typedArray.getInteger(R$styleable.CameraView_cameraAudioCodec, AudioCodec.DEFAULT.value());
        this.f11587k = typedArray.getInteger(R$styleable.CameraView_cameraEngine, Engine.DEFAULT.value());
        this.f11588l = typedArray.getInteger(R$styleable.CameraView_cameraPictureFormat, PictureFormat.DEFAULT.value());
    }
}
