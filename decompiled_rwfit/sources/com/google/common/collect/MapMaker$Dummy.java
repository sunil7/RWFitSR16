package com.google.common.collect;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class MapMaker$Dummy {
    public static final MapMaker$Dummy VALUE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MapMaker$Dummy[] f11021a;

    static {
        MapMaker$Dummy mapMaker$Dummy = new MapMaker$Dummy("VALUE", 0);
        VALUE = mapMaker$Dummy;
        f11021a = new MapMaker$Dummy[]{mapMaker$Dummy};
    }

    public static MapMaker$Dummy valueOf(String str) {
        return (MapMaker$Dummy) Enum.valueOf(MapMaker$Dummy.class, str);
    }

    public static MapMaker$Dummy[] values() {
        return (MapMaker$Dummy[]) f11021a.clone();
    }
}
