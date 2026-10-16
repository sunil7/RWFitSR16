package androidx.camera.core.impl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Config$OptionPriority {
    public static final Config$OptionPriority ALWAYS_OVERRIDE;
    public static final Config$OptionPriority HIGH_PRIORITY_REQUIRED;
    public static final Config$OptionPriority OPTIONAL;
    public static final Config$OptionPriority REQUIRED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Config$OptionPriority[] f1337a;

    static {
        Config$OptionPriority config$OptionPriority = new Config$OptionPriority("ALWAYS_OVERRIDE", 0);
        ALWAYS_OVERRIDE = config$OptionPriority;
        Config$OptionPriority config$OptionPriority2 = new Config$OptionPriority("HIGH_PRIORITY_REQUIRED", 1);
        HIGH_PRIORITY_REQUIRED = config$OptionPriority2;
        Config$OptionPriority config$OptionPriority3 = new Config$OptionPriority("REQUIRED", 2);
        REQUIRED = config$OptionPriority3;
        Config$OptionPriority config$OptionPriority4 = new Config$OptionPriority("OPTIONAL", 3);
        OPTIONAL = config$OptionPriority4;
        f1337a = new Config$OptionPriority[]{config$OptionPriority, config$OptionPriority2, config$OptionPriority3, config$OptionPriority4};
    }

    public static Config$OptionPriority valueOf(String str) {
        return (Config$OptionPriority) Enum.valueOf(Config$OptionPriority.class, str);
    }

    public static Config$OptionPriority[] values() {
        return (Config$OptionPriority[]) f1337a.clone();
    }
}
