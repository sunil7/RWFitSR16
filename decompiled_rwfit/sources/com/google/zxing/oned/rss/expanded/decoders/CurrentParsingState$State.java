package com.google.zxing.oned.rss.expanded.decoders;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class CurrentParsingState$State {
    public static final CurrentParsingState$State ALPHA;
    public static final CurrentParsingState$State ISO_IEC_646;
    public static final CurrentParsingState$State NUMERIC;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CurrentParsingState$State[] f11249a;

    static {
        CurrentParsingState$State currentParsingState$State = new CurrentParsingState$State("NUMERIC", 0);
        NUMERIC = currentParsingState$State;
        CurrentParsingState$State currentParsingState$State2 = new CurrentParsingState$State("ALPHA", 1);
        ALPHA = currentParsingState$State2;
        CurrentParsingState$State currentParsingState$State3 = new CurrentParsingState$State("ISO_IEC_646", 2);
        ISO_IEC_646 = currentParsingState$State3;
        f11249a = new CurrentParsingState$State[]{currentParsingState$State, currentParsingState$State2, currentParsingState$State3};
    }

    public static CurrentParsingState$State valueOf(String str) {
        return (CurrentParsingState$State) Enum.valueOf(CurrentParsingState$State.class, str);
    }

    public static CurrentParsingState$State[] values() {
        return (CurrentParsingState$State[]) f11249a.clone();
    }
}
