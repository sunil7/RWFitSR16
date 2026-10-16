package com.otaliastudios.cameraview.engine.offset;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class Reference {
    public static final Reference BASE;
    public static final Reference OUTPUT;
    public static final Reference SENSOR;
    public static final Reference VIEW;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Reference[] f11590a;

    static {
        Reference reference = new Reference("BASE", 0);
        BASE = reference;
        Reference reference2 = new Reference("SENSOR", 1);
        SENSOR = reference2;
        Reference reference3 = new Reference("VIEW", 2);
        VIEW = reference3;
        Reference reference4 = new Reference("OUTPUT", 3);
        OUTPUT = reference4;
        f11590a = new Reference[]{reference, reference2, reference3, reference4};
    }

    public static Reference valueOf(String str) {
        return (Reference) Enum.valueOf(Reference.class, str);
    }

    public static Reference[] values() {
        return (Reference[]) f11590a.clone();
    }
}
