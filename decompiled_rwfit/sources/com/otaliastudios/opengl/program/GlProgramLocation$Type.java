package com.otaliastudios.opengl.program;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class GlProgramLocation$Type {
    public static final GlProgramLocation$Type ATTRIB;
    public static final GlProgramLocation$Type UNIFORM;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GlProgramLocation$Type[] f11621a;

    static {
        GlProgramLocation$Type glProgramLocation$Type = new GlProgramLocation$Type("ATTRIB", 0);
        ATTRIB = glProgramLocation$Type;
        GlProgramLocation$Type glProgramLocation$Type2 = new GlProgramLocation$Type("UNIFORM", 1);
        UNIFORM = glProgramLocation$Type2;
        f11621a = new GlProgramLocation$Type[]{glProgramLocation$Type, glProgramLocation$Type2};
    }

    public static GlProgramLocation$Type valueOf(String str) {
        return (GlProgramLocation$Type) Enum.valueOf(GlProgramLocation$Type.class, str);
    }

    public static GlProgramLocation$Type[] values() {
        return (GlProgramLocation$Type[]) f11621a.clone();
    }
}
