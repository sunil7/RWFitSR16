package com.bumptech.glide.load.resource.bitmap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class DownsampleStrategy$SampleSizeRounding {
    public static final DownsampleStrategy$SampleSizeRounding MEMORY;
    public static final DownsampleStrategy$SampleSizeRounding QUALITY;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownsampleStrategy$SampleSizeRounding[] f7020a;

    static {
        DownsampleStrategy$SampleSizeRounding downsampleStrategy$SampleSizeRounding = new DownsampleStrategy$SampleSizeRounding("MEMORY", 0);
        MEMORY = downsampleStrategy$SampleSizeRounding;
        DownsampleStrategy$SampleSizeRounding downsampleStrategy$SampleSizeRounding2 = new DownsampleStrategy$SampleSizeRounding("QUALITY", 1);
        QUALITY = downsampleStrategy$SampleSizeRounding2;
        f7020a = new DownsampleStrategy$SampleSizeRounding[]{downsampleStrategy$SampleSizeRounding, downsampleStrategy$SampleSizeRounding2};
    }

    public static DownsampleStrategy$SampleSizeRounding valueOf(String str) {
        return (DownsampleStrategy$SampleSizeRounding) Enum.valueOf(DownsampleStrategy$SampleSizeRounding.class, str);
    }

    public static DownsampleStrategy$SampleSizeRounding[] values() {
        return (DownsampleStrategy$SampleSizeRounding[]) f7020a.clone();
    }
}
