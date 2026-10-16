package com.otaliastudios.cameraview.overlay;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class Overlay$Target {
    public static final Overlay$Target PICTURE_SNAPSHOT;
    public static final Overlay$Target PREVIEW;
    public static final Overlay$Target VIDEO_SNAPSHOT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Overlay$Target[] f11617a;

    static {
        Overlay$Target overlay$Target = new Overlay$Target("PREVIEW", 0);
        PREVIEW = overlay$Target;
        Overlay$Target overlay$Target2 = new Overlay$Target("PICTURE_SNAPSHOT", 1);
        PICTURE_SNAPSHOT = overlay$Target2;
        Overlay$Target overlay$Target3 = new Overlay$Target("VIDEO_SNAPSHOT", 2);
        VIDEO_SNAPSHOT = overlay$Target3;
        f11617a = new Overlay$Target[]{overlay$Target, overlay$Target2, overlay$Target3};
    }

    public static Overlay$Target valueOf(String str) {
        return (Overlay$Target) Enum.valueOf(Overlay$Target.class, str);
    }

    public static Overlay$Target[] values() {
        return (Overlay$Target[]) f11617a.clone();
    }
}
