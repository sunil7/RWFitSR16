package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import vg.o;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ArrayListSupplier implements Callable<List<Object>>, o {
    public static final ArrayListSupplier INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArrayListSupplier[] f15115a;

    static {
        ArrayListSupplier arrayListSupplier = new ArrayListSupplier("INSTANCE", 0);
        INSTANCE = arrayListSupplier;
        f15115a = new ArrayListSupplier[]{arrayListSupplier};
    }

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> o asFunction() {
        return INSTANCE;
    }

    public static ArrayListSupplier valueOf(String str) {
        return (ArrayListSupplier) Enum.valueOf(ArrayListSupplier.class, str);
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[]) f15115a.clone();
    }

    @Override // vg.o
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
