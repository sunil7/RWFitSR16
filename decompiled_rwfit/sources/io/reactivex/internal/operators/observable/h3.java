package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class h3 implements c3 {

    /* renamed from: a, reason: collision with root package name */
    public final int f14675a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14676b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f14677c;

    /* renamed from: d, reason: collision with root package name */
    public final rg.x f14678d;

    public h3(int i3, long j4, TimeUnit timeUnit, rg.x xVar) {
        this.f14675a = i3;
        this.f14676b = j4;
        this.f14677c = timeUnit;
        this.f14678d = xVar;
    }

    @Override // io.reactivex.internal.operators.observable.c3
    public final e3 call() {
        final TimeUnit timeUnit = this.f14677c;
        final rg.x xVar = this.f14678d;
        final int i3 = this.f14675a;
        final long j4 = this.f14676b;
        return new ObservableReplay$BoundedReplayBuffer<T>(i3, j4, timeUnit, xVar) { // from class: io.reactivex.internal.operators.observable.ObservableReplay$SizeAndTimeBoundReplayBuffer
            private static final long serialVersionUID = 3457957419649567404L;
            final int limit;
            final long maxAge;
            final rg.x scheduler;
            final TimeUnit unit;

            {
                this.scheduler = xVar;
                this.limit = i3;
                this.maxAge = j4;
                this.unit = timeUnit;
            }

            @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
            public Object enterTransform(Object obj) {
                rg.x xVar2 = this.scheduler;
                TimeUnit timeUnit2 = this.unit;
                xVar2.getClass();
                return new ch.g(obj, rg.x.b(timeUnit2), this.unit);
            }

            @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
            public ObservableReplay$Node getHead() {
                ObservableReplay$Node observableReplay$Node;
                rg.x xVar2 = this.scheduler;
                TimeUnit timeUnit2 = this.unit;
                xVar2.getClass();
                long b3 = rg.x.b(timeUnit2) - this.maxAge;
                ObservableReplay$Node observableReplay$Node2 = get();
                ObservableReplay$Node observableReplay$Node3 = observableReplay$Node2.get();
                while (true) {
                    ObservableReplay$Node observableReplay$Node4 = observableReplay$Node3;
                    observableReplay$Node = observableReplay$Node2;
                    observableReplay$Node2 = observableReplay$Node4;
                    if (observableReplay$Node2 != null) {
                        ch.g gVar = (ch.g) observableReplay$Node2.value;
                        if (NotificationLite.isComplete(gVar.f3508a) || NotificationLite.isError(gVar.f3508a) || gVar.f3509b > b3) {
                            break;
                        }
                        observableReplay$Node3 = observableReplay$Node2.get();
                    } else {
                        break;
                    }
                }
                return observableReplay$Node;
            }

            @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
            public Object leaveTransform(Object obj) {
                return ((ch.g) obj).f3508a;
            }

            @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
            public void truncate() {
                ObservableReplay$Node observableReplay$Node;
                rg.x xVar2 = this.scheduler;
                TimeUnit timeUnit2 = this.unit;
                xVar2.getClass();
                long b3 = rg.x.b(timeUnit2) - this.maxAge;
                ObservableReplay$Node observableReplay$Node2 = get();
                ObservableReplay$Node observableReplay$Node3 = observableReplay$Node2.get();
                int i10 = 0;
                while (true) {
                    ObservableReplay$Node observableReplay$Node4 = observableReplay$Node3;
                    observableReplay$Node = observableReplay$Node2;
                    observableReplay$Node2 = observableReplay$Node4;
                    if (observableReplay$Node2 != null) {
                        int i11 = this.size;
                        if (i11 <= this.limit) {
                            if (((ch.g) observableReplay$Node2.value).f3509b > b3) {
                                break;
                            }
                            i10++;
                            this.size = i11 - 1;
                            observableReplay$Node3 = observableReplay$Node2.get();
                        } else {
                            i10++;
                            this.size = i11 - 1;
                            observableReplay$Node3 = observableReplay$Node2.get();
                        }
                    } else {
                        break;
                    }
                }
                if (i10 != 0) {
                    setFirst(observableReplay$Node);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
            
                setFirst(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
            
                return;
             */
            @Override // io.reactivex.internal.operators.observable.ObservableReplay$BoundedReplayBuffer
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void truncateFinal() {
                /*
                    r9 = this;
                    rg.x r0 = r9.scheduler
                    java.util.concurrent.TimeUnit r1 = r9.unit
                    r0.getClass()
                    long r0 = rg.x.b(r1)
                    long r2 = r9.maxAge
                    long r0 = r0 - r2
                    java.lang.Object r2 = r9.get()
                    io.reactivex.internal.operators.observable.ObservableReplay$Node r2 = (io.reactivex.internal.operators.observable.ObservableReplay$Node) r2
                    java.lang.Object r3 = r2.get()
                    io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay$Node) r3
                    r4 = 0
                L1b:
                    r8 = r3
                    r3 = r2
                    r2 = r8
                    if (r2 == 0) goto L3c
                    int r5 = r9.size
                    r6 = 1
                    if (r5 <= r6) goto L3c
                    java.lang.Object r6 = r2.value
                    ch.g r6 = (ch.g) r6
                    long r6 = r6.f3509b
                    int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                    if (r6 > 0) goto L3c
                    int r4 = r4 + 1
                    int r5 = r5 + (-1)
                    r9.size = r5
                    java.lang.Object r3 = r2.get()
                    io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay$Node) r3
                    goto L1b
                L3c:
                    if (r4 == 0) goto L41
                    r9.setFirst(r3)
                L41:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay$SizeAndTimeBoundReplayBuffer.truncateFinal():void");
            }
        };
    }
}
