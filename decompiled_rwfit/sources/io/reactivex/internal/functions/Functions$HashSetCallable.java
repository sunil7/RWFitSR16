package io.reactivex.internal.functions;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
final class Functions$HashSetCallable implements Callable<Set<Object>> {
    public static final Functions$HashSetCallable INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Functions$HashSetCallable[] f14440a;

    static {
        Functions$HashSetCallable functions$HashSetCallable = new Functions$HashSetCallable("INSTANCE", 0);
        INSTANCE = functions$HashSetCallable;
        f14440a = new Functions$HashSetCallable[]{functions$HashSetCallable};
    }

    public static Functions$HashSetCallable valueOf(String str) {
        return (Functions$HashSetCallable) Enum.valueOf(Functions$HashSetCallable.class, str);
    }

    public static Functions$HashSetCallable[] values() {
        return (Functions$HashSetCallable[]) f14440a.clone();
    }

    @Override // java.util.concurrent.Callable
    public Set<Object> call() throws Exception {
        return new HashSet();
    }
}
