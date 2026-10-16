package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class zzh implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzh[] f11203a;
    public static final zzh zza;

    static {
        zzh zzhVar = new zzh("INSTANCE", 0);
        zza = zzhVar;
        f11203a = new zzh[]{zzhVar};
    }

    public static zzh[] values() {
        return (zzh[]) f11203a.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        a.a().f11202a.post(runnable);
    }
}
