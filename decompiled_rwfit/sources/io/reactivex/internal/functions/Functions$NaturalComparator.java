package io.reactivex.internal.functions;

import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
final class Functions$NaturalComparator implements Comparator<Object> {
    public static final Functions$NaturalComparator INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Functions$NaturalComparator[] f14441a;

    static {
        Functions$NaturalComparator functions$NaturalComparator = new Functions$NaturalComparator("INSTANCE", 0);
        INSTANCE = functions$NaturalComparator;
        f14441a = new Functions$NaturalComparator[]{functions$NaturalComparator};
    }

    public static Functions$NaturalComparator valueOf(String str) {
        return (Functions$NaturalComparator) Enum.valueOf(Functions$NaturalComparator.class, str);
    }

    public static Functions$NaturalComparator[] values() {
        return (Functions$NaturalComparator[]) f14441a.clone();
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo(obj2);
    }
}
