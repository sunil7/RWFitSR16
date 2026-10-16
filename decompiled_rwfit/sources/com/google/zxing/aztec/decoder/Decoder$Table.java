package com.google.zxing.aztec.decoder;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class Decoder$Table {
    public static final Decoder$Table BINARY;
    public static final Decoder$Table DIGIT;
    public static final Decoder$Table LOWER;
    public static final Decoder$Table MIXED;
    public static final Decoder$Table PUNCT;
    public static final Decoder$Table UPPER;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Decoder$Table[] f11218a;

    static {
        Decoder$Table decoder$Table = new Decoder$Table("UPPER", 0);
        UPPER = decoder$Table;
        Decoder$Table decoder$Table2 = new Decoder$Table("LOWER", 1);
        LOWER = decoder$Table2;
        Decoder$Table decoder$Table3 = new Decoder$Table("MIXED", 2);
        MIXED = decoder$Table3;
        Decoder$Table decoder$Table4 = new Decoder$Table("DIGIT", 3);
        DIGIT = decoder$Table4;
        Decoder$Table decoder$Table5 = new Decoder$Table("PUNCT", 4);
        PUNCT = decoder$Table5;
        Decoder$Table decoder$Table6 = new Decoder$Table("BINARY", 5);
        BINARY = decoder$Table6;
        f11218a = new Decoder$Table[]{decoder$Table, decoder$Table2, decoder$Table3, decoder$Table4, decoder$Table5, decoder$Table6};
    }

    public static Decoder$Table valueOf(String str) {
        return (Decoder$Table) Enum.valueOf(Decoder$Table.class, str);
    }

    public static Decoder$Table[] values() {
        return (Decoder$Table[]) f11218a.clone();
    }
}
