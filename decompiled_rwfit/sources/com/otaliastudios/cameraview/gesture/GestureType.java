package com.otaliastudios.cameraview.gesture;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class GestureType {
    public static final GestureType CONTINUOUS;
    public static final GestureType ONE_SHOT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GestureType[] f11594a;

    static {
        GestureType gestureType = new GestureType("ONE_SHOT", 0);
        ONE_SHOT = gestureType;
        GestureType gestureType2 = new GestureType("CONTINUOUS", 1);
        CONTINUOUS = gestureType2;
        f11594a = new GestureType[]{gestureType, gestureType2};
    }

    public static GestureType valueOf(String str) {
        return (GestureType) Enum.valueOf(GestureType.class, str);
    }

    public static GestureType[] values() {
        return (GestureType[]) f11594a.clone();
    }
}
