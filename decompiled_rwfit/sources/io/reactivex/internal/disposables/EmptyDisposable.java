package io.reactivex.internal.disposables;

import rg.h;
import rg.s;
import rg.z;
import yg.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class EmptyDisposable implements b {
    public static final EmptyDisposable INSTANCE;
    public static final EmptyDisposable NEVER;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptyDisposable[] f14439a;

    static {
        EmptyDisposable emptyDisposable = new EmptyDisposable("INSTANCE", 0);
        INSTANCE = emptyDisposable;
        EmptyDisposable emptyDisposable2 = new EmptyDisposable("NEVER", 1);
        NEVER = emptyDisposable2;
        f14439a = new EmptyDisposable[]{emptyDisposable, emptyDisposable2};
    }

    public static void complete(s sVar) {
        sVar.onSubscribe(INSTANCE);
        sVar.onComplete();
    }

    public static void error(Throwable th2, s sVar) {
        sVar.onSubscribe(INSTANCE);
        sVar.onError(th2);
    }

    public static EmptyDisposable valueOf(String str) {
        return (EmptyDisposable) Enum.valueOf(EmptyDisposable.class, str);
    }

    public static EmptyDisposable[] values() {
        return (EmptyDisposable[]) f14439a.clone();
    }

    @Override // yg.f
    public void clear() {
    }

    @Override // ug.b
    public void dispose() {
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // yg.f
    public boolean isEmpty() {
        return true;
    }

    @Override // yg.f
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // yg.f
    public Object poll() throws Exception {
        return null;
    }

    @Override // yg.c
    public int requestFusion(int i3) {
        return i3 & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(h hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onComplete();
    }

    public static void error(Throwable th2, rg.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th2);
    }

    public static void complete(rg.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th2, z zVar) {
        zVar.onSubscribe(INSTANCE);
        zVar.onError(th2);
    }

    public static void error(Throwable th2, h hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onError(th2);
    }
}
