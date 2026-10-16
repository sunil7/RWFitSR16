package io.reactivex.internal.util;

import ci.c;
import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import rg.f;
import rg.h;
import rg.s;
import rg.z;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class EmptyComponent implements f, s, h, z, rg.b, c, ug.b {
    public static final EmptyComponent INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptyComponent[] f15116a;

    static {
        EmptyComponent emptyComponent = new EmptyComponent("INSTANCE", 0);
        INSTANCE = emptyComponent;
        f15116a = new EmptyComponent[]{emptyComponent};
    }

    public static <T> s asObserver() {
        return INSTANCE;
    }

    public static <T> ci.b asSubscriber() {
        return INSTANCE;
    }

    public static EmptyComponent valueOf(String str) {
        return (EmptyComponent) Enum.valueOf(EmptyComponent.class, str);
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[]) f15116a.clone();
    }

    @Override // ci.c
    public void cancel() {
    }

    @Override // ug.b
    public void dispose() {
    }

    @Override // ug.b
    public boolean isDisposed() {
        return true;
    }

    @Override // ci.b
    public void onComplete() {
    }

    @Override // ci.b
    public void onError(Throwable th2) {
        a1.b(th2);
    }

    @Override // ci.b
    public void onNext(Object obj) {
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        bVar.dispose();
    }

    @Override // rg.h
    public void onSuccess(Object obj) {
    }

    @Override // ci.c
    public void request(long j4) {
    }

    @Override // ci.b
    public void onSubscribe(c cVar) {
        cVar.cancel();
    }
}
