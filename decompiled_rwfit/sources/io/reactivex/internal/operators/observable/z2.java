package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes2.dex */
public final class z2 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f15038b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15039c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z2(rg.q qVar, long j4, int i3) {
        super(qVar);
        this.f15038b = i3;
        this.f15039c = j4;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f15038b) {
            case 0:
                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                sVar.onSubscribe(sequentialDisposable);
                long j4 = this.f15039c;
                long j10 = Format.OFFSET_SAMPLE_RELATIVE;
                if (j4 != Format.OFFSET_SAMPLE_RELATIVE) {
                    j10 = j4 - 1;
                }
                new ObservableRepeat$RepeatObserver(sVar, j10, sequentialDisposable, this.f14546a).subscribeNext();
                break;
            case 1:
                this.f14546a.subscribe(new i0(sVar, this.f15039c));
                break;
            default:
                this.f14546a.subscribe(new z3(sVar, this.f15039c));
                break;
        }
    }
}
