package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class DataSource {
    public static final DataSource DATA_DISK_CACHE;
    public static final DataSource LOCAL;
    public static final DataSource MEMORY_CACHE;
    public static final DataSource REMOTE;
    public static final DataSource RESOURCE_DISK_CACHE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataSource[] f6954a;

    static {
        DataSource dataSource = new DataSource("LOCAL", 0);
        LOCAL = dataSource;
        DataSource dataSource2 = new DataSource("REMOTE", 1);
        REMOTE = dataSource2;
        DataSource dataSource3 = new DataSource("DATA_DISK_CACHE", 2);
        DATA_DISK_CACHE = dataSource3;
        DataSource dataSource4 = new DataSource("RESOURCE_DISK_CACHE", 3);
        RESOURCE_DISK_CACHE = dataSource4;
        DataSource dataSource5 = new DataSource("MEMORY_CACHE", 4);
        MEMORY_CACHE = dataSource5;
        f6954a = new DataSource[]{dataSource, dataSource2, dataSource3, dataSource4, dataSource5};
    }

    public static DataSource valueOf(String str) {
        return (DataSource) Enum.valueOf(DataSource.class, str);
    }

    public static DataSource[] values() {
        return (DataSource[]) f6954a.clone();
    }
}
