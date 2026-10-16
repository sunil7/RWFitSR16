package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class r1 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14853b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14854c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14855d;
    public final Object e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f14856f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r1(rg.l lVar, Object obj, Object obj2, Object obj3, Object obj4, int i3) {
        super(lVar);
        this.f14853b = i3;
        this.f14854c = obj;
        this.f14855d = obj2;
        this.e = obj3;
        this.f14856f = obj4;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14853b) {
            case 0:
                ObservableGroupJoin$GroupJoinDisposable observableGroupJoin$GroupJoinDisposable = new ObservableGroupJoin$GroupJoinDisposable(sVar, (vg.o) this.f14855d, (vg.o) this.e, (vg.c) this.f14856f);
                sVar.onSubscribe(observableGroupJoin$GroupJoinDisposable);
                ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver = new ObservableGroupJoin$LeftRightObserver(observableGroupJoin$GroupJoinDisposable, true);
                observableGroupJoin$GroupJoinDisposable.disposables.c(observableGroupJoin$LeftRightObserver);
                ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver2 = new ObservableGroupJoin$LeftRightObserver(observableGroupJoin$GroupJoinDisposable, false);
                observableGroupJoin$GroupJoinDisposable.disposables.c(observableGroupJoin$LeftRightObserver2);
                this.f14546a.subscribe(observableGroupJoin$LeftRightObserver);
                ((rg.q) this.f14854c).subscribe(observableGroupJoin$LeftRightObserver2);
                break;
            case 1:
                ObservableJoin$JoinDisposable observableJoin$JoinDisposable = new ObservableJoin$JoinDisposable(sVar, (vg.o) this.f14855d, (vg.o) this.e, (vg.c) this.f14856f);
                sVar.onSubscribe(observableJoin$JoinDisposable);
                ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver3 = new ObservableGroupJoin$LeftRightObserver(observableJoin$JoinDisposable, true);
                observableJoin$JoinDisposable.disposables.c(observableGroupJoin$LeftRightObserver3);
                ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver4 = new ObservableGroupJoin$LeftRightObserver(observableJoin$JoinDisposable, false);
                observableJoin$JoinDisposable.disposables.c(observableGroupJoin$LeftRightObserver4);
                this.f14546a.subscribe(observableGroupJoin$LeftRightObserver3);
                ((rg.q) this.f14854c).subscribe(observableGroupJoin$LeftRightObserver4);
                break;
            default:
                this.f14546a.subscribe(new w0(sVar, (vg.g) this.f14854c, (vg.g) this.f14855d, (vg.a) this.e, (vg.a) this.f14856f));
                break;
        }
    }
}
