package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class HashMapSupplier implements Callable<Map<Object, Object>> {
    public static final HashMapSupplier INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HashMapSupplier[] f15118a;

    static {
        HashMapSupplier hashMapSupplier = new HashMapSupplier("INSTANCE", 0);
        INSTANCE = hashMapSupplier;
        f15118a = new HashMapSupplier[]{hashMapSupplier};
    }

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    public static HashMapSupplier valueOf(String str) {
        return (HashMapSupplier) Enum.valueOf(HashMapSupplier.class, str);
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[]) f15118a.clone();
    }

    @Override // java.util.concurrent.Callable
    public Map<Object, Object> call() throws Exception {
        return new HashMap();
    }
}
