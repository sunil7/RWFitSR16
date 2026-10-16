package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class f3 implements c3 {

    /* renamed from: a, reason: collision with root package name */
    public final int f14642a;

    public f3(int i3) {
        this.f14642a = i3;
    }

    @Override // io.reactivex.internal.operators.observable.c3
    public final e3 call() {
        final int i3 = this.f14642a;
        return new ObservableReplay$BoundedReplayBuffer<T>(i3) { // from class: io.reactivex.internal.operators.observable.ObservableReplay$SizeBoundReplayBuffer
            private static final long serialVersionUID = -5898283885385201806L;
            final int limit;

            {
                this.limit = i3;
            }

            @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
            public void truncate() {
                if (this.size > this.limit) {
                    removeFirst();
                }
            }
        };
    }
}
