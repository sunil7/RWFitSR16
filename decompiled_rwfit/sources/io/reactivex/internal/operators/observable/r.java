package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class r extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14847b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14848c;

    /* renamed from: d, reason: collision with root package name */
    public final vg.o f14849d;
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(rg.l lVar, rg.q qVar, vg.o oVar, Object obj, int i3) {
        super(lVar);
        this.f14847b = i3;
        this.f14848c = qVar;
        this.f14849d = oVar;
        this.e = obj;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        int length;
        switch (this.f14847b) {
            case 0:
                ObservableBufferBoundary$BufferBoundaryObserver observableBufferBoundary$BufferBoundaryObserver = new ObservableBufferBoundary$BufferBoundaryObserver(sVar, (rg.q) this.f14848c, this.f14849d, (Callable) this.e);
                sVar.onSubscribe(observableBufferBoundary$BufferBoundaryObserver);
                this.f14546a.subscribe(observableBufferBoundary$BufferBoundaryObserver);
                break;
            case 1:
                rg.q qVar = this.f14546a;
                rg.q qVar2 = (rg.q) this.f14848c;
                vg.o oVar = this.f14849d;
                rg.q qVar3 = (rg.q) this.e;
                if (qVar3 == null) {
                    ObservableTimeout$TimeoutObserver observableTimeout$TimeoutObserver = new ObservableTimeout$TimeoutObserver(sVar, oVar);
                    sVar.onSubscribe(observableTimeout$TimeoutObserver);
                    observableTimeout$TimeoutObserver.startFirstTimeout(qVar2);
                    qVar.subscribe(observableTimeout$TimeoutObserver);
                    break;
                } else {
                    ObservableTimeout$TimeoutFallbackObserver observableTimeout$TimeoutFallbackObserver = new ObservableTimeout$TimeoutFallbackObserver(sVar, oVar, qVar3);
                    sVar.onSubscribe(observableTimeout$TimeoutFallbackObserver);
                    observableTimeout$TimeoutFallbackObserver.startFirstTimeout(qVar2);
                    qVar.subscribe(observableTimeout$TimeoutFallbackObserver);
                    break;
                }
            case 2:
                rg.q[] qVarArr = (rg.q[]) this.e;
                if (qVarArr == null) {
                    qVarArr = new rg.q[8];
                    try {
                        length = 0;
                        for (rg.q qVar4 : (Iterable) this.f14848c) {
                            if (length == qVarArr.length) {
                                qVarArr = (rg.q[]) Arrays.copyOf(qVarArr, (length >> 1) + length);
                            }
                            int i3 = length + 1;
                            qVarArr[length] = qVar4;
                            length = i3;
                        }
                    } catch (Throwable th2) {
                        ad.a(th2);
                        EmptyDisposable.error(th2, sVar);
                        return;
                    }
                } else {
                    length = qVarArr.length;
                }
                rg.q qVar5 = this.f14546a;
                if (length == 0) {
                    qVar5.subscribe(new v0(sVar, new z1(this, 3), 2));
                    break;
                } else {
                    ObservableWithLatestFromMany$WithLatestFromObserver observableWithLatestFromMany$WithLatestFromObserver = new ObservableWithLatestFromMany$WithLatestFromObserver(sVar, this.f14849d, length);
                    sVar.onSubscribe(observableWithLatestFromMany$WithLatestFromObserver);
                    observableWithLatestFromMany$WithLatestFromObserver.subscribe(qVarArr, length);
                    qVar5.subscribe(observableWithLatestFromMany$WithLatestFromObserver);
                    break;
                }
            default:
                this.f14546a.subscribe(new h2(sVar, this.f14849d, (vg.o) this.f14848c, (Callable) this.e));
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(rg.l lVar, vg.o oVar, vg.o oVar2, Callable callable) {
        super(lVar);
        this.f14847b = 3;
        this.f14849d = oVar;
        this.f14848c = oVar2;
        this.e = callable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(rg.l lVar, rg.q[] qVarArr, vg.o oVar) {
        super(lVar);
        this.f14847b = 2;
        this.e = qVarArr;
        this.f14848c = null;
        this.f14849d = oVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(rg.l lVar, Iterable iterable, vg.o oVar) {
        super(lVar);
        this.f14847b = 2;
        this.e = null;
        this.f14848c = iterable;
        this.f14849d = oVar;
    }
}
