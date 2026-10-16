package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class zzcw implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzcw[] f9717a;
    public static final zzcw zza;

    static {
        zzcw zzcwVar = new zzcw("INSTANCE", 0);
        zza = zzcwVar;
        f9717a = new zzcw[]{zzcwVar};
    }

    public static zzcw[] values() {
        return (zzcw[]) f9717a.clone();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        oa.c("no calls to next() since the last call to remove()", false);
    }
}
