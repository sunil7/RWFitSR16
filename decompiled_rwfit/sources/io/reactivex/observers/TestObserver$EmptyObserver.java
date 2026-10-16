package io.reactivex.observers;

import rg.s;
import ug.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
final class TestObserver$EmptyObserver implements s {
    public static final TestObserver$EmptyObserver INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TestObserver$EmptyObserver[] f15124a;

    static {
        TestObserver$EmptyObserver testObserver$EmptyObserver = new TestObserver$EmptyObserver("INSTANCE", 0);
        INSTANCE = testObserver$EmptyObserver;
        f15124a = new TestObserver$EmptyObserver[]{testObserver$EmptyObserver};
    }

    public static TestObserver$EmptyObserver valueOf(String str) {
        return (TestObserver$EmptyObserver) Enum.valueOf(TestObserver$EmptyObserver.class, str);
    }

    public static TestObserver$EmptyObserver[] values() {
        return (TestObserver$EmptyObserver[]) f15124a.clone();
    }

    @Override // rg.s
    public void onComplete() {
    }

    @Override // rg.s
    public void onError(Throwable th2) {
    }

    @Override // rg.s
    public void onNext(Object obj) {
    }

    @Override // rg.s
    public void onSubscribe(b bVar) {
    }
}
