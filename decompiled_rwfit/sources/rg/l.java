package rg;

import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import com.google.android.gms.internal.mlkit_vision_barcode.cd;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.a1;
import io.reactivex.internal.operators.observable.a2;
import io.reactivex.internal.operators.observable.a3;
import io.reactivex.internal.operators.observable.a4;
import io.reactivex.internal.operators.observable.b0;
import io.reactivex.internal.operators.observable.b2;
import io.reactivex.internal.operators.observable.b3;
import io.reactivex.internal.operators.observable.b4;
import io.reactivex.internal.operators.observable.c1;
import io.reactivex.internal.operators.observable.c2;
import io.reactivex.internal.operators.observable.c4;
import io.reactivex.internal.operators.observable.d0;
import io.reactivex.internal.operators.observable.d1;
import io.reactivex.internal.operators.observable.d2;
import io.reactivex.internal.operators.observable.d3;
import io.reactivex.internal.operators.observable.e0;
import io.reactivex.internal.operators.observable.e1;
import io.reactivex.internal.operators.observable.f0;
import io.reactivex.internal.operators.observable.f1;
import io.reactivex.internal.operators.observable.f2;
import io.reactivex.internal.operators.observable.f3;
import io.reactivex.internal.operators.observable.g0;
import io.reactivex.internal.operators.observable.g1;
import io.reactivex.internal.operators.observable.g2;
import io.reactivex.internal.operators.observable.g4;
import io.reactivex.internal.operators.observable.h0;
import io.reactivex.internal.operators.observable.h3;
import io.reactivex.internal.operators.observable.h4;
import io.reactivex.internal.operators.observable.i2;
import io.reactivex.internal.operators.observable.j0;
import io.reactivex.internal.operators.observable.j1;
import io.reactivex.internal.operators.observable.j2;
import io.reactivex.internal.operators.observable.j3;
import io.reactivex.internal.operators.observable.j4;
import io.reactivex.internal.operators.observable.k0;
import io.reactivex.internal.operators.observable.k2;
import io.reactivex.internal.operators.observable.k3;
import io.reactivex.internal.operators.observable.k4;
import io.reactivex.internal.operators.observable.l2;
import io.reactivex.internal.operators.observable.l3;
import io.reactivex.internal.operators.observable.m2;
import io.reactivex.internal.operators.observable.m3;
import io.reactivex.internal.operators.observable.m4;
import io.reactivex.internal.operators.observable.n1;
import io.reactivex.internal.operators.observable.o0;
import io.reactivex.internal.operators.observable.o1;
import io.reactivex.internal.operators.observable.p1;
import io.reactivex.internal.operators.observable.p2;
import io.reactivex.internal.operators.observable.q2;
import io.reactivex.internal.operators.observable.r1;
import io.reactivex.internal.operators.observable.s1;
import io.reactivex.internal.operators.observable.s2;
import io.reactivex.internal.operators.observable.s3;
import io.reactivex.internal.operators.observable.t1;
import io.reactivex.internal.operators.observable.t2;
import io.reactivex.internal.operators.observable.t3;
import io.reactivex.internal.operators.observable.u1;
import io.reactivex.internal.operators.observable.u2;
import io.reactivex.internal.operators.observable.u3;
import io.reactivex.internal.operators.observable.v1;
import io.reactivex.internal.operators.observable.v2;
import io.reactivex.internal.operators.observable.w1;
import io.reactivex.internal.operators.observable.w2;
import io.reactivex.internal.operators.observable.w4;
import io.reactivex.internal.operators.observable.x1;
import io.reactivex.internal.operators.observable.y1;
import io.reactivex.internal.operators.observable.y2;
import io.reactivex.internal.operators.observable.y3;
import io.reactivex.internal.operators.observable.z1;
import io.reactivex.internal.operators.observable.z2;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.HashMapSupplier;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import n.m0;

/* loaded from: classes2.dex */
public abstract class l<T> implements q {
    public static <T> l<T> amb(Iterable<? extends q> iterable) {
        xg.c.b(iterable, "sources is null");
        return new io.reactivex.internal.operators.observable.o(0, null, iterable);
    }

    public static <T> l<T> ambArray(q... qVarArr) {
        xg.c.b(qVarArr, "sources is null");
        int length = qVarArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(qVarArr[0]);
        }
        return new io.reactivex.internal.operators.observable.o(0, qVarArr, null);
    }

    public static int bufferSize() {
        return e.f18125a;
    }

    public static <T, R> l<R> combineLatest(vg.o oVar, int i3, q... qVarArr) {
        return combineLatest(qVarArr, oVar, i3);
    }

    public static <T, R> l<R> combineLatestDelayError(q[] qVarArr, vg.o oVar) {
        return combineLatestDelayError(qVarArr, oVar, bufferSize());
    }

    public static <T> l<T> concat(Iterable<? extends q> iterable) {
        xg.c.b(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(io.reactivex.internal.functions.a.f14442a, bufferSize(), false);
    }

    public static <T> l<T> concatArray(q... qVarArr) {
        return qVarArr.length == 0 ? empty() : qVarArr.length == 1 ? wrap(qVarArr[0]) : new f0(fromArray(qVarArr), io.reactivex.internal.functions.a.f14442a, bufferSize(), ErrorMode.BOUNDARY);
    }

    public static <T> l<T> concatArrayDelayError(q... qVarArr) {
        return qVarArr.length == 0 ? empty() : qVarArr.length == 1 ? wrap(qVarArr[0]) : concatDelayError(fromArray(qVarArr));
    }

    public static <T> l<T> concatArrayEager(q... qVarArr) {
        return concatArrayEager(bufferSize(), bufferSize(), qVarArr);
    }

    public static <T> l<T> concatDelayError(Iterable<? extends q> iterable) {
        xg.c.b(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> l<T> concatEager(q qVar) {
        return concatEager(qVar, bufferSize(), bufferSize());
    }

    public static <T> l<T> create(o oVar) {
        xg.c.b(oVar, "source is null");
        return new k0(oVar, 0);
    }

    public static <T> l<T> defer(Callable<? extends q> callable) {
        xg.c.b(callable, "supplier is null");
        return new o0(callable, 0);
    }

    public static <T> l<T> empty() {
        return d1.f14610a;
    }

    public static <T> l<T> error(Callable<? extends Throwable> callable) {
        xg.c.b(callable, "errorSupplier is null");
        return new o0(callable, 1);
    }

    public static <T> l<T> fromArray(T... tArr) {
        xg.c.b(tArr, "items is null");
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : new k0(tArr, 1);
    }

    public static <T> l<T> fromCallable(Callable<? extends T> callable) {
        xg.c.b(callable, "supplier is null");
        return new j1(callable);
    }

    public static <T> l<T> fromFuture(Future<? extends T> future) {
        xg.c.b(future, "future is null");
        return new h4(future, 0L, (TimeUnit) null);
    }

    public static <T> l<T> fromIterable(Iterable<? extends T> iterable) {
        xg.c.b(iterable, "source is null");
        return new k0(iterable, 2);
    }

    public static <T> l<T> fromPublisher(ci.a aVar) {
        xg.c.b(aVar, "publisher is null");
        return new k0(aVar, 3);
    }

    public static <T> l<T> generate(vg.g gVar) {
        xg.c.b(gVar, "generator  is null");
        return generate(io.reactivex.internal.functions.a.f14448h, new z1(gVar, 1), io.reactivex.internal.functions.a.f14445d);
    }

    public static l<Long> interval(long j4, long j10, TimeUnit timeUnit) {
        return interval(j4, j10, timeUnit, ch.f.f3504a);
    }

    public static l<Long> intervalRange(long j4, long j10, long j11, long j12, TimeUnit timeUnit) {
        return intervalRange(j4, j10, j11, j12, timeUnit, ch.f.f3504a);
    }

    public static <T> l<T> just(T t8) {
        xg.c.b(t8, "The item is null");
        return new d2(t8);
    }

    public static <T> l<T> merge(Iterable<? extends q> iterable, int i3, int i10) {
        return fromIterable(iterable).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, false, i3, i10);
    }

    public static <T> l<T> mergeArray(int i3, int i10, q... qVarArr) {
        return fromArray(qVarArr).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, false, i3, i10);
    }

    public static <T> l<T> mergeArrayDelayError(int i3, int i10, q... qVarArr) {
        return fromArray(qVarArr).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, true, i3, i10);
    }

    public static <T> l<T> mergeDelayError(Iterable<? extends q> iterable) {
        return fromIterable(iterable).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, true);
    }

    public static <T> l<T> never() {
        return l2.f14736a;
    }

    public static l<Integer> range(int i3, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(l0.j(i10, "count >= 0 required but it was "));
        }
        if (i10 == 0) {
            return empty();
        }
        if (i10 == 1) {
            return just(Integer.valueOf(i3));
        }
        if (i3 + (i10 - 1) <= 2147483647L) {
            return new t2(i3, i10);
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    public static l<Long> rangeLong(long j4, long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException(l0.l(j10, "count >= 0 required but it was "));
        }
        if (j10 == 0) {
            return empty();
        }
        if (j10 == 1) {
            return just(Long.valueOf(j4));
        }
        long j11 = (j10 - 1) + j4;
        if (j4 <= 0 || j11 >= 0) {
            return new u2(j4, j10);
        }
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    public static <T> y sequenceEqual(q qVar, q qVar2) {
        return sequenceEqual(qVar, qVar2, xg.c.f19826a, bufferSize());
    }

    public static <T> l<T> switchOnNext(q qVar, int i3) {
        xg.c.b(qVar, "sources is null");
        xg.c.c(i3, "bufferSize");
        return new m2(qVar, (vg.o) io.reactivex.internal.functions.a.f14442a, i3, false);
    }

    public static <T> l<T> switchOnNextDelayError(q qVar) {
        return switchOnNextDelayError(qVar, bufferSize());
    }

    public static l<Long> timer(long j4, TimeUnit timeUnit) {
        return timer(j4, timeUnit, ch.f.f3504a);
    }

    public static <T> l<T> unsafeCreate(q qVar) {
        xg.c.b(qVar, "source is null");
        if (qVar instanceof l) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return new k0(qVar, 4);
    }

    public static <T, D> l<T> using(Callable<? extends D> callable, vg.o oVar, vg.g gVar) {
        return using(callable, oVar, gVar, true);
    }

    public static <T> l<T> wrap(q qVar) {
        xg.c.b(qVar, "source is null");
        return qVar instanceof l ? (l) qVar : new k0(qVar, 4);
    }

    public static <T, R> l<R> zip(Iterable<? extends q> iterable, vg.o oVar) {
        xg.c.b(oVar, "zipper is null");
        xg.c.b(iterable, "sources is null");
        return new e0(null, iterable, oVar, bufferSize(), false, 1);
    }

    public static <T, R> l<R> zipArray(vg.o oVar, boolean z5, int i3, q... qVarArr) {
        if (qVarArr.length == 0) {
            return empty();
        }
        xg.c.b(oVar, "zipper is null");
        xg.c.c(i3, "bufferSize");
        return new e0(qVarArr, null, oVar, i3, z5, 1);
    }

    public static <T, R> l<R> zipIterable(Iterable<? extends q> iterable, vg.o oVar, boolean z5, int i3) {
        xg.c.b(oVar, "zipper is null");
        xg.c.b(iterable, "sources is null");
        xg.c.c(i3, "bufferSize");
        return new e0(null, iterable, oVar, i3, z5, 1);
    }

    public final r1 a(vg.g gVar, vg.g gVar2, vg.a aVar, vg.a aVar2) {
        xg.c.b(gVar, "onNext is null");
        xg.c.b(gVar2, "onError is null");
        xg.c.b(aVar, "onComplete is null");
        return new r1(this, gVar, gVar2, aVar, aVar2, 2);
    }

    public final y all(vg.p pVar) {
        xg.c.b(pVar, "predicate is null");
        return new io.reactivex.internal.operators.observable.m(this, pVar, 0);
    }

    public final l<T> ambWith(q qVar) {
        xg.c.b(qVar, "other is null");
        return ambArray(this, qVar);
    }

    public final y any(vg.p pVar) {
        xg.c.b(pVar, "predicate is null");
        return new io.reactivex.internal.operators.observable.m(this, pVar, 1);
    }

    public final <R> R as(m mVar) {
        xg.c.b(mVar, "converter is null");
        throw new ClassCastException();
    }

    public final g4 b(long j4, TimeUnit timeUnit, x xVar, q qVar) {
        xg.c.b(timeUnit, "timeUnit is null");
        xg.c.b(xVar, "scheduler is null");
        return new g4(this, j4, timeUnit, xVar, qVar);
    }

    public final T blockingFirst() {
        io.reactivex.internal.observers.c cVar = new io.reactivex.internal.observers.c(1, 0);
        subscribe(cVar);
        T t8 = (T) cVar.a();
        if (t8 != null) {
            return t8;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(vg.g gVar) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                gVar.f(it.next());
            } catch (Throwable th2) {
                ad.a(th2);
                ((ug.b) it).dispose();
                throw io.reactivex.internal.util.b.b(th2);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() {
        io.reactivex.internal.observers.c cVar = new io.reactivex.internal.observers.c(1, 1);
        subscribe(cVar);
        T t8 = (T) cVar.a();
        if (t8 != null) {
            return t8;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new io.reactivex.internal.operators.observable.d(this, 0);
    }

    public final Iterable<T> blockingMostRecent(T t8) {
        return new io.reactivex.internal.operators.observable.g(this, t8);
    }

    public final Iterable<T> blockingNext() {
        return new io.reactivex.internal.operators.observable.d(this, 1);
    }

    public final T blockingSingle() {
        g singleElement = singleElement();
        singleElement.getClass();
        io.reactivex.internal.observers.d dVar = new io.reactivex.internal.observers.d(1);
        singleElement.b(dVar);
        T t8 = (T) dVar.a();
        if (t8 != null) {
            return t8;
        }
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        io.reactivex.internal.util.a aVar = new io.reactivex.internal.util.a(1);
        gc.b bVar = io.reactivex.internal.functions.a.f14445d;
        LambdaObserver lambdaObserver = new LambdaObserver(bVar, aVar, aVar, bVar);
        subscribe(lambdaObserver);
        if (aVar.getCount() != 0) {
            try {
                aVar.await();
            } catch (InterruptedException e) {
                lambdaObserver.dispose();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
        Throwable th2 = aVar.f15122a;
        if (th2 != null) {
            throw io.reactivex.internal.util.b.b(th2);
        }
    }

    public final l<List<T>> buffer(long j4, long j10, TimeUnit timeUnit) {
        return (l<List<T>>) buffer(j4, j10, timeUnit, ch.f.f3504a, ArrayListSupplier.asCallable());
    }

    public final l<T> cache() {
        xg.c.c(16, "capacityHint");
        return new b0(this, new io.reactivex.internal.operators.observable.a0(this, 16));
    }

    public final l<T> cacheWithInitialCapacity(int i3) {
        xg.c.c(i3, "capacityHint");
        return new b0(this, new io.reactivex.internal.operators.observable.a0(this, i3));
    }

    public final <U> l<U> cast(Class<U> cls) {
        xg.c.b(cls, "clazz is null");
        return (l<U>) map(new n6.a(cls, 25));
    }

    public final <U> y collect(Callable<? extends U> callable, vg.b bVar) {
        xg.c.b(callable, "initialValueSupplier is null");
        xg.c.b(bVar, "collector is null");
        return new d0(this, callable, bVar);
    }

    public final <U> y collectInto(U u10, vg.b bVar) {
        xg.c.b(u10, "initialValue is null");
        return collect(new com.google.android.gms.internal.mlkit_common.i(u10, 4), bVar);
    }

    public final <R> l<R> compose(r rVar) {
        xg.c.b(rVar, "composer is null");
        throw new ClassCastException();
    }

    public final <R> l<R> concatMap(vg.o oVar) {
        return concatMap(oVar, 2);
    }

    public final a concatMapCompletable(vg.o oVar) {
        return concatMapCompletable(oVar, 2);
    }

    public final a concatMapCompletableDelayError(vg.o oVar) {
        return concatMapCompletableDelayError(oVar, true, 2);
    }

    public final <R> l<R> concatMapDelayError(vg.o oVar) {
        return concatMapDelayError(oVar, bufferSize(), true);
    }

    public final <R> l<R> concatMapEager(vg.o oVar) {
        return concatMapEager(oVar, SubsamplingScaleImageView.TILE_SIZE_AUTO, bufferSize());
    }

    public final <R> l<R> concatMapEagerDelayError(vg.o oVar, boolean z5) {
        return concatMapEagerDelayError(oVar, SubsamplingScaleImageView.TILE_SIZE_AUTO, bufferSize(), z5);
    }

    public final <U> l<U> concatMapIterable(vg.o oVar) {
        xg.c.b(oVar, "mapper is null");
        return new s2(this, oVar, 2);
    }

    public final <R> l<R> concatMapMaybe(vg.o oVar) {
        return concatMapMaybe(oVar, 2);
    }

    public final <R> l<R> concatMapMaybeDelayError(vg.o oVar) {
        return concatMapMaybeDelayError(oVar, true, 2);
    }

    public final <R> l<R> concatMapSingle(vg.o oVar) {
        return concatMapSingle(oVar, 2);
    }

    public final <R> l<R> concatMapSingleDelayError(vg.o oVar) {
        return concatMapSingleDelayError(oVar, true, 2);
    }

    public final l<T> concatWith(q qVar) {
        xg.c.b(qVar, "other is null");
        return concat(this, qVar);
    }

    public final y contains(Object obj) {
        xg.c.b(obj, "element is null");
        return any(new yh.i(obj));
    }

    public final y count() {
        return new j0(this);
    }

    public final l<T> debounce(long j4, TimeUnit timeUnit) {
        return debounce(j4, timeUnit, ch.f.f3504a);
    }

    public final l<T> defaultIfEmpty(T t8) {
        xg.c.b(t8, "defaultItem is null");
        return switchIfEmpty(just(t8));
    }

    public final l<T> delay(long j4, TimeUnit timeUnit) {
        return delay(j4, timeUnit, ch.f.f3504a, false);
    }

    public final l<T> delaySubscription(long j4, TimeUnit timeUnit) {
        return delaySubscription(j4, timeUnit, ch.f.f3504a);
    }

    public final <T2> l<T2> dematerialize() {
        return new a3(this, 2);
    }

    public final l<T> distinct() {
        return distinct(io.reactivex.internal.functions.a.f14442a, io.reactivex.internal.functions.a.a());
    }

    public final l<T> distinctUntilChanged() {
        return distinctUntilChanged(io.reactivex.internal.functions.a.f14442a);
    }

    public final l<T> doAfterNext(vg.g gVar) {
        xg.c.b(gVar, "onAfterNext is null");
        return new h0(this, gVar, 5);
    }

    public final l<T> doAfterTerminate(vg.a aVar) {
        xg.c.b(aVar, "onFinally is null");
        gc.b bVar = io.reactivex.internal.functions.a.f14445d;
        return a(bVar, bVar, io.reactivex.internal.functions.a.f14444c, aVar);
    }

    public final l<T> doFinally(vg.a aVar) {
        xg.c.b(aVar, "onFinally is null");
        return new h0(this, aVar, 3);
    }

    public final l<T> doOnComplete(vg.a aVar) {
        gc.b bVar = io.reactivex.internal.functions.a.f14445d;
        return a(bVar, bVar, aVar, io.reactivex.internal.functions.a.f14444c);
    }

    public final l<T> doOnDispose(vg.a aVar) {
        return doOnLifecycle(io.reactivex.internal.functions.a.f14445d, aVar);
    }

    public final l<T> doOnEach(vg.g gVar) {
        xg.c.b(gVar, "consumer is null");
        return a(new n6.a(gVar, 27), new mc.g(gVar, 25), new m0(gVar, 29), io.reactivex.internal.functions.a.f14444c);
    }

    public final l<T> doOnError(vg.g gVar) {
        gc.b bVar = io.reactivex.internal.functions.a.f14445d;
        ec.a aVar = io.reactivex.internal.functions.a.f14444c;
        return a(bVar, gVar, aVar, aVar);
    }

    public final l<T> doOnLifecycle(vg.g gVar, vg.a aVar) {
        xg.c.b(gVar, "onSubscribe is null");
        xg.c.b(aVar, "onDispose is null");
        return new b0(this, gVar, aVar, 7);
    }

    public final l<T> doOnNext(vg.g gVar) {
        gc.b bVar = io.reactivex.internal.functions.a.f14445d;
        ec.a aVar = io.reactivex.internal.functions.a.f14444c;
        return a(gVar, bVar, aVar, aVar);
    }

    public final l<T> doOnSubscribe(vg.g gVar) {
        return doOnLifecycle(gVar, io.reactivex.internal.functions.a.f14444c);
    }

    public final l<T> doOnTerminate(vg.a aVar) {
        xg.c.b(aVar, "onTerminate is null");
        return a(io.reactivex.internal.functions.a.f14445d, new m0(aVar, 27), aVar, io.reactivex.internal.functions.a.f14444c);
    }

    public final g elementAt(long j4) {
        if (j4 >= 0) {
            return new a1(this, j4);
        }
        throw new IndexOutOfBoundsException(l0.l(j4, "index >= 0 required but it was "));
    }

    public final y elementAtOrError(long j4) {
        if (j4 >= 0) {
            return new c1(this, j4, null);
        }
        throw new IndexOutOfBoundsException(l0.l(j4, "index >= 0 required but it was "));
    }

    public final l<T> filter(vg.p pVar) {
        xg.c.b(pVar, "predicate is null");
        return new io.reactivex.internal.operators.observable.k(this, pVar, 2);
    }

    public final y first(T t8) {
        return elementAt(0L, t8);
    }

    public final g firstElement() {
        return elementAt(0L);
    }

    public final y firstOrError() {
        return elementAtOrError(0L);
    }

    public final <R> l<R> flatMap(vg.o oVar) {
        return flatMap(oVar, false);
    }

    public final a flatMapCompletable(vg.o oVar) {
        return flatMapCompletable(oVar, false);
    }

    public final <U> l<U> flatMapIterable(vg.o oVar) {
        xg.c.b(oVar, "mapper is null");
        return new s2(this, oVar, 2);
    }

    public final <R> l<R> flatMapMaybe(vg.o oVar) {
        return flatMapMaybe(oVar, false);
    }

    public final <R> l<R> flatMapSingle(vg.o oVar) {
        return flatMapSingle(oVar, false);
    }

    public final ug.b forEach(vg.g gVar) {
        return subscribe(gVar);
    }

    public final ug.b forEachWhile(vg.p pVar) {
        return forEachWhile(pVar, io.reactivex.internal.functions.a.e, io.reactivex.internal.functions.a.f14444c);
    }

    public final <K> l<o1> groupBy(vg.o oVar) {
        return groupBy(oVar, io.reactivex.internal.functions.a.f14442a, false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> l<R> groupJoin(q qVar, vg.o oVar, vg.o oVar2, vg.c cVar) {
        xg.c.b(qVar, "other is null");
        xg.c.b(oVar, "leftEnd is null");
        xg.c.b(oVar2, "rightEnd is null");
        xg.c.b(cVar, "resultSelector is null");
        return new r1(this, qVar, oVar, oVar2, cVar, 0);
    }

    public final l<T> hide() {
        return new a3(this, 4);
    }

    public final a ignoreElements() {
        return new s1(this);
    }

    public final y isEmpty() {
        return all(io.reactivex.internal.functions.a.f14447g);
    }

    public final <TRight, TLeftEnd, TRightEnd, R> l<R> join(q qVar, vg.o oVar, vg.o oVar2, vg.c cVar) {
        xg.c.b(qVar, "other is null");
        xg.c.b(oVar, "leftEnd is null");
        xg.c.b(oVar2, "rightEnd is null");
        xg.c.b(cVar, "resultSelector is null");
        return new r1(this, qVar, oVar, oVar2, cVar, 1);
    }

    public final y last(T t8) {
        xg.c.b(t8, "defaultItem is null");
        return new g2(0, this, t8);
    }

    public final g lastElement() {
        return new f2(this, 0);
    }

    public final y lastOrError() {
        return new g2(0, this, null);
    }

    public final <R> l<R> lift(p pVar) {
        xg.c.b(pVar, "onLift is null");
        return new a3(this, 6);
    }

    public final <R> l<R> map(vg.o oVar) {
        xg.c.b(oVar, "mapper is null");
        return new s2(this, oVar, 3);
    }

    public final l<j> materialize() {
        return new a3(this, 7);
    }

    public final l<T> mergeWith(q qVar) {
        xg.c.b(qVar, "other is null");
        return merge(this, qVar);
    }

    public final l<T> observeOn(x xVar) {
        return observeOn(xVar, false, bufferSize());
    }

    public final <U> l<U> ofType(Class<U> cls) {
        xg.c.b(cls, "clazz is null");
        return filter(new m0(cls, 28)).cast(cls);
    }

    public final l<T> onErrorResumeNext(vg.o oVar) {
        xg.c.b(oVar, "resumeFunction is null");
        return new f1(this, oVar, false, 3);
    }

    public final l<T> onErrorReturn(vg.o oVar) {
        xg.c.b(oVar, "valueSupplier is null");
        return new s2(this, oVar, 4);
    }

    public final l<T> onErrorReturnItem(T t8) {
        xg.c.b(t8, "item is null");
        return onErrorReturn(new com.google.android.gms.internal.mlkit_common.i(t8, 4));
    }

    public final l<T> onExceptionResumeNext(q qVar) {
        xg.c.b(qVar, "next is null");
        return new f1(this, new com.google.android.gms.internal.mlkit_common.i(qVar, 4), true, 3);
    }

    public final l<T> onTerminateDetach() {
        return new a3(this, 3);
    }

    public final zg.a publish() {
        AtomicReference atomicReference = new AtomicReference();
        return new q2(new p2(atomicReference), this, atomicReference);
    }

    public final g reduce(vg.c cVar) {
        xg.c.b(cVar, "reducer is null");
        return new v2(this, cVar);
    }

    public final <R> y reduceWith(Callable<R> callable, vg.c cVar) {
        xg.c.b(callable, "seedSupplier is null");
        xg.c.b(cVar, "reducer is null");
        return new w2(this, callable, cVar, 1);
    }

    public final l<T> repeat() {
        return repeat(Format.OFFSET_SAMPLE_RELATIVE);
    }

    public final l<T> repeatUntil(vg.e eVar) {
        xg.c.b(eVar, "stop is null");
        return new a3(this, 0);
    }

    public final l<T> repeatWhen(vg.o oVar) {
        xg.c.b(oVar, "handler is null");
        return new b3(this, oVar);
    }

    public final zg.a replay() {
        return j3.d(this, j3.e);
    }

    public final l<T> retry() {
        return retry(Format.OFFSET_SAMPLE_RELATIVE, io.reactivex.internal.functions.a.f14446f);
    }

    public final l<T> retryUntil(vg.e eVar) {
        xg.c.b(eVar, "stop is null");
        return retry(Format.OFFSET_SAMPLE_RELATIVE, new eb.e(23));
    }

    public final l<T> retryWhen(vg.o oVar) {
        xg.c.b(oVar, "handler is null");
        return new l3(this, oVar);
    }

    public final void safeSubscribe(s sVar) {
        xg.c.b(sVar, "s is null");
        if (sVar instanceof ah.b) {
            subscribe(sVar);
        } else {
            subscribe(new ah.b(sVar));
        }
    }

    public final l<T> sample(long j4, TimeUnit timeUnit) {
        return sample(j4, timeUnit, ch.f.f3504a);
    }

    public final l<T> scan(vg.c cVar) {
        xg.c.b(cVar, "accumulator is null");
        return new h0(this, cVar, 6);
    }

    public final <R> l<R> scanWith(Callable<R> callable, vg.c cVar) {
        xg.c.b(callable, "seedSupplier is null");
        xg.c.b(cVar, "accumulator is null");
        return new b0(this, callable, cVar, 8, false);
    }

    public final l<T> serialize() {
        return new a3(this, 8);
    }

    public final l<T> share() {
        zg.a publish = publish();
        publish.getClass();
        return new y2(publish);
    }

    public final y single(T t8) {
        xg.c.b(t8, "defaultItem is null");
        return new g2(1, this, t8);
    }

    public final g singleElement() {
        return new f2(this, 1);
    }

    public final y singleOrError() {
        return new g2(1, this, null);
    }

    public final l<T> skip(long j4) {
        return j4 <= 0 ? this : new z2(this, j4, 1);
    }

    public final l<T> skipLast(long j4, TimeUnit timeUnit) {
        return skipLast(j4, timeUnit, ch.f.f3506c, false, bufferSize());
    }

    public final <U> l<T> skipUntil(q qVar) {
        xg.c.b(qVar, "other is null");
        return new b4(this, qVar, 1);
    }

    public final l<T> skipWhile(vg.p pVar) {
        xg.c.b(pVar, "predicate is null");
        return new io.reactivex.internal.operators.observable.k(this, pVar, 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final l<T> sorted() {
        y list = toList();
        list.getClass();
        return (list instanceof yg.a ? ((yg.a) list).a() : new io.reactivex.internal.operators.single.a(list)).map(new n6.a(io.reactivex.internal.functions.a.b(), 26)).flatMapIterable(io.reactivex.internal.functions.a.f14442a);
    }

    public final l<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final l<T> startWithArray(T... tArr) {
        l fromArray = fromArray(tArr);
        return fromArray == empty() ? this : concatArray(fromArray, this);
    }

    public final ug.b subscribe() {
        gc.b bVar = io.reactivex.internal.functions.a.f14445d;
        return subscribe(bVar, io.reactivex.internal.functions.a.e, io.reactivex.internal.functions.a.f14444c, bVar);
    }

    public abstract void subscribeActual(s sVar);

    public final l<T> subscribeOn(x xVar) {
        xg.c.b(xVar, "scheduler is null");
        return new y3(this, xVar, 0);
    }

    public final <E extends s> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final l<T> switchIfEmpty(q qVar) {
        xg.c.b(qVar, "other is null");
        return new b4(this, qVar, 2);
    }

    public final <R> l<R> switchMap(vg.o oVar) {
        return switchMap(oVar, bufferSize());
    }

    public final a switchMapCompletable(vg.o oVar) {
        xg.c.b(oVar, "mapper is null");
        return new io.reactivex.internal.operators.mixed.d(this, oVar, false);
    }

    public final a switchMapCompletableDelayError(vg.o oVar) {
        xg.c.b(oVar, "mapper is null");
        return new io.reactivex.internal.operators.mixed.d(this, oVar, true);
    }

    public final <R> l<R> switchMapDelayError(vg.o oVar) {
        return switchMapDelayError(oVar, bufferSize());
    }

    public final <R> l<R> switchMapMaybe(vg.o oVar) {
        xg.c.b(oVar, "mapper is null");
        return new io.reactivex.internal.operators.mixed.e(this, oVar, false, 0);
    }

    public final <R> l<R> switchMapMaybeDelayError(vg.o oVar) {
        xg.c.b(oVar, "mapper is null");
        return new io.reactivex.internal.operators.mixed.e(this, oVar, true, 0);
    }

    public final <R> l<R> switchMapSingle(vg.o oVar) {
        xg.c.b(oVar, "mapper is null");
        return new io.reactivex.internal.operators.mixed.e(this, oVar, false, 1);
    }

    public final <R> l<R> switchMapSingleDelayError(vg.o oVar) {
        xg.c.b(oVar, "mapper is null");
        return new io.reactivex.internal.operators.mixed.e(this, oVar, true, 1);
    }

    public final l<T> take(long j4) {
        if (j4 >= 0) {
            return new z2(this, j4, 2);
        }
        throw new IllegalArgumentException(l0.l(j4, "count >= 0 required but it was "));
    }

    public final l<T> takeLast(long j4, long j10, TimeUnit timeUnit) {
        return takeLast(j4, j10, timeUnit, ch.f.f3506c, false, bufferSize());
    }

    public final <U> l<T> takeUntil(q qVar) {
        xg.c.b(qVar, "other is null");
        return new b4(this, qVar, 0);
    }

    public final l<T> takeWhile(vg.p pVar) {
        xg.c.b(pVar, "predicate is null");
        return new io.reactivex.internal.operators.observable.k(this, pVar, 5);
    }

    public final io.reactivex.observers.a test() {
        io.reactivex.observers.a aVar = new io.reactivex.observers.a();
        subscribe(aVar);
        return aVar;
    }

    public final l<T> throttleFirst(long j4, TimeUnit timeUnit) {
        return throttleFirst(j4, timeUnit, ch.f.f3504a);
    }

    public final l<T> throttleLast(long j4, TimeUnit timeUnit) {
        return sample(j4, timeUnit);
    }

    public final l<T> throttleWithTimeout(long j4, TimeUnit timeUnit) {
        return debounce(j4, timeUnit);
    }

    public final l<ch.g> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, ch.f.f3504a);
    }

    public final l<T> timeout(long j4, TimeUnit timeUnit) {
        return b(j4, timeUnit, ch.f.f3504a, null);
    }

    public final l<ch.g> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, ch.f.f3504a);
    }

    public final <R> R to(vg.o oVar) {
        try {
            xg.c.b(oVar, "converter is null");
            return (R) oVar.apply(this);
        } catch (Throwable th2) {
            ad.a(th2);
            throw io.reactivex.internal.util.b.b(th2);
        }
    }

    public final e toFlowable(BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.operators.flowable.c cVar = new io.reactivex.internal.operators.flowable.c(this);
        int i3 = k.f18128a[backpressureStrategy.ordinal()];
        if (i3 == 1) {
            return new io.reactivex.internal.operators.flowable.e(cVar);
        }
        if (i3 == 2) {
            return new io.reactivex.internal.operators.flowable.f(cVar, 1);
        }
        if (i3 == 3) {
            return cVar;
        }
        if (i3 == 4) {
            return new io.reactivex.internal.operators.flowable.f(cVar, 0);
        }
        int i10 = e.f18125a;
        xg.c.c(i10, "bufferSize");
        return new io.reactivex.internal.operators.flowable.d(cVar, i10);
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new io.reactivex.internal.observers.f());
    }

    public final y toList() {
        return toList(16);
    }

    public final <K> y toMap(vg.o oVar) {
        xg.c.b(oVar, "keySelector is null");
        return collect(HashMapSupplier.asCallable(), new mc.g(oVar, 26));
    }

    public final <K> y toMultimap(vg.o oVar) {
        return toMultimap(oVar, io.reactivex.internal.functions.a.f14442a, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final y toSortedList() {
        return toSortedList(io.reactivex.internal.functions.a.f14449i);
    }

    public final l<T> unsubscribeOn(x xVar) {
        xg.c.b(xVar, "scheduler is null");
        return new y3(this, xVar, 1);
    }

    public final l<l<T>> window(long j4, long j10, TimeUnit timeUnit) {
        return window(j4, j10, timeUnit, ch.f.f3504a, bufferSize());
    }

    public final <U, R> l<R> withLatestFrom(q qVar, vg.c cVar) {
        xg.c.b(qVar, "other is null");
        xg.c.b(cVar, "combiner is null");
        return new b0(this, cVar, qVar, 1);
    }

    public final <U, R> l<R> zipWith(Iterable<U> iterable, vg.c cVar) {
        xg.c.b(iterable, "other is null");
        xg.c.b(cVar, "zipper is null");
        return new n1(this, iterable, cVar);
    }

    public static <T, R> l<R> combineLatest(Iterable<? extends q> iterable, vg.o oVar) {
        return combineLatest(iterable, oVar, bufferSize());
    }

    public static <T, R> l<R> combineLatestDelayError(vg.o oVar, int i3, q... qVarArr) {
        return combineLatestDelayError(qVarArr, oVar, i3);
    }

    public static <T> l<T> concatArrayEager(int i3, int i10, q... qVarArr) {
        return fromArray(qVarArr).concatMapEagerDelayError(io.reactivex.internal.functions.a.f14442a, i3, i10, false);
    }

    public static <T> l<T> concatEager(q qVar, int i3, int i10) {
        return wrap(qVar).concatMapEager(io.reactivex.internal.functions.a.f14442a, i3, i10);
    }

    public static <T> l<T> merge(Iterable<? extends q> iterable) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.a.f14442a);
    }

    public static <T> l<T> mergeArray(q... qVarArr) {
        return fromArray(qVarArr).flatMap(io.reactivex.internal.functions.a.f14442a, qVarArr.length);
    }

    public static <T> l<T> mergeArrayDelayError(q... qVarArr) {
        return fromArray(qVarArr).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, true, qVarArr.length);
    }

    public static <T> l<T> mergeDelayError(Iterable<? extends q> iterable, int i3, int i10) {
        return fromIterable(iterable).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, true, i3, i10);
    }

    public static <T> y sequenceEqual(q qVar, q qVar2, vg.d dVar) {
        return sequenceEqual(qVar, qVar2, dVar, bufferSize());
    }

    public static <T> l<T> switchOnNextDelayError(q qVar, int i3) {
        xg.c.b(qVar, "sources is null");
        xg.c.c(i3, "prefetch");
        return new m2(qVar, (vg.o) io.reactivex.internal.functions.a.f14442a, i3, true);
    }

    public static <T, D> l<T> using(Callable<? extends D> callable, vg.o oVar, vg.g gVar, boolean z5) {
        xg.c.b(callable, "resourceSupplier is null");
        xg.c.b(oVar, "sourceSupplier is null");
        xg.c.b(gVar, "disposer is null");
        return new j4(callable, oVar, gVar, z5);
    }

    public final Iterable<T> blockingIterable(int i3) {
        xg.c.c(i3, "bufferSize");
        return new io.reactivex.internal.operators.observable.b(this, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> l<R> concatMap(vg.o oVar, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "prefetch");
        if (!(this instanceof yg.d)) {
            return new f0(this, oVar, i3, ErrorMode.IMMEDIATE);
        }
        Object call = ((yg.d) this).call();
        return call == null ? empty() : new io.reactivex.internal.operators.observable.o(3, call, oVar);
    }

    public final a concatMapCompletable(vg.o oVar, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "capacityHint");
        return new io.reactivex.internal.operators.mixed.a(this, oVar, ErrorMode.IMMEDIATE, i3);
    }

    public final a concatMapCompletableDelayError(vg.o oVar, boolean z5) {
        return concatMapCompletableDelayError(oVar, z5, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> l<R> concatMapDelayError(vg.o oVar, int i3, boolean z5) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "prefetch");
        if (!(this instanceof yg.d)) {
            return new f0(this, oVar, i3, z5 ? ErrorMode.END : ErrorMode.BOUNDARY);
        }
        Object call = ((yg.d) this).call();
        return call == null ? empty() : new io.reactivex.internal.operators.observable.o(3, call, oVar);
    }

    public final <R> l<R> concatMapEager(vg.o oVar, int i3, int i10) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "maxConcurrency");
        xg.c.c(i10, "prefetch");
        return new g0(this, oVar, ErrorMode.IMMEDIATE, i3, i10);
    }

    public final <R> l<R> concatMapEagerDelayError(vg.o oVar, int i3, int i10, boolean z5) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "maxConcurrency");
        xg.c.c(i10, "prefetch");
        return new g0(this, oVar, z5 ? ErrorMode.END : ErrorMode.BOUNDARY, i3, i10);
    }

    public final <R> l<R> concatMapMaybe(vg.o oVar, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "prefetch");
        return new io.reactivex.internal.operators.mixed.b(this, oVar, ErrorMode.IMMEDIATE, i3, 0);
    }

    public final <R> l<R> concatMapMaybeDelayError(vg.o oVar, boolean z5) {
        return concatMapMaybeDelayError(oVar, z5, 2);
    }

    public final <R> l<R> concatMapSingle(vg.o oVar, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "prefetch");
        return new io.reactivex.internal.operators.mixed.b(this, oVar, ErrorMode.IMMEDIATE, i3, 1);
    }

    public final <R> l<R> concatMapSingleDelayError(vg.o oVar, boolean z5) {
        return concatMapSingleDelayError(oVar, z5, 2);
    }

    public final <K> l<T> distinct(vg.o oVar) {
        return distinct(oVar, io.reactivex.internal.functions.a.a());
    }

    public final <K> l<T> distinctUntilChanged(vg.o oVar) {
        xg.c.b(oVar, "keySelector is null");
        return new b0(this, oVar, xg.c.f19826a, 6);
    }

    public final <R> l<R> flatMap(vg.o oVar, boolean z5) {
        return flatMap(oVar, z5, SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public final a flatMapCompletable(vg.o oVar, boolean z5) {
        xg.c.b(oVar, "mapper is null");
        return new g1(this, oVar, z5);
    }

    public final <R> l<R> flatMapMaybe(vg.o oVar, boolean z5) {
        xg.c.b(oVar, "mapper is null");
        return new f1(this, oVar, z5, 1);
    }

    public final <R> l<R> flatMapSingle(vg.o oVar, boolean z5) {
        xg.c.b(oVar, "mapper is null");
        return new f1(this, oVar, z5, 2);
    }

    public final ug.b forEachWhile(vg.p pVar, vg.g gVar) {
        return forEachWhile(pVar, gVar, io.reactivex.internal.functions.a.f14444c);
    }

    public final <K> l<o1> groupBy(vg.o oVar, boolean z5) {
        return groupBy(oVar, io.reactivex.internal.functions.a.f14442a, z5, bufferSize());
    }

    public final l<T> observeOn(x xVar, boolean z5) {
        return observeOn(xVar, z5, bufferSize());
    }

    public final l<T> repeat(long j4) {
        if (j4 >= 0) {
            return j4 == 0 ? empty() : new z2(this, j4, 0);
        }
        throw new IllegalArgumentException(l0.l(j4, "times >= 0 required but it was "));
    }

    public final <R> l<R> replay(vg.o oVar, int i3, long j4, TimeUnit timeUnit) {
        return replay(oVar, i3, j4, timeUnit, ch.f.f3504a);
    }

    public final l<T> retry(vg.d dVar) {
        xg.c.b(dVar, "predicate is null");
        return new h0(this, dVar, 4);
    }

    public final l<T> skip(long j4, TimeUnit timeUnit) {
        return skipUntil(timer(j4, timeUnit));
    }

    public final l<T> startWith(q qVar) {
        xg.c.b(qVar, "other is null");
        return concatArray(qVar, this);
    }

    public final ug.b subscribe(vg.g gVar) {
        return subscribe(gVar, io.reactivex.internal.functions.a.e, io.reactivex.internal.functions.a.f14444c, io.reactivex.internal.functions.a.f14445d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> l<R> switchMap(vg.o oVar, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "bufferSize");
        if (!(this instanceof yg.d)) {
            return new m2((q) this, oVar, i3, false);
        }
        Object call = ((yg.d) this).call();
        return call == null ? empty() : new io.reactivex.internal.operators.observable.o(3, call, oVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> l<R> switchMapDelayError(vg.o oVar, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "bufferSize");
        if (!(this instanceof yg.d)) {
            return new m2((q) this, oVar, i3, true);
        }
        Object call = ((yg.d) this).call();
        return call == null ? empty() : new io.reactivex.internal.operators.observable.o(3, call, oVar);
    }

    public final l<T> throttleLast(long j4, TimeUnit timeUnit, x xVar) {
        return sample(j4, timeUnit, xVar);
    }

    public final l<T> throttleWithTimeout(long j4, TimeUnit timeUnit, x xVar) {
        return debounce(j4, timeUnit, xVar);
    }

    public final y toList(int i3) {
        xg.c.c(i3, "capacityHint");
        return new io.reactivex.internal.operators.observable.m(this, i3);
    }

    public final y toSortedList(Comparator<? super T> comparator) {
        xg.c.b(comparator, "comparator is null");
        y list = toList();
        n6.a aVar = new n6.a(comparator, 26);
        list.getClass();
        return new g2(2, list, aVar);
    }

    public static <T, R> l<R> combineLatest(Iterable<? extends q> iterable, vg.o oVar, int i3) {
        xg.c.b(iterable, "sources is null");
        xg.c.b(oVar, "combiner is null");
        xg.c.c(i3, "bufferSize");
        return new e0(null, iterable, oVar, i3 << 1, false, 0);
    }

    public static <T, R> l<R> combineLatestDelayError(q[] qVarArr, vg.o oVar, int i3) {
        xg.c.c(i3, "bufferSize");
        xg.c.b(oVar, "combiner is null");
        if (qVarArr.length == 0) {
            return empty();
        }
        return new e0(qVarArr, null, oVar, i3 << 1, true, 0);
    }

    public static <T> l<T> concat(q qVar) {
        return concat(qVar, bufferSize());
    }

    public static <T> l<T> concatDelayError(q qVar) {
        return concatDelayError(qVar, bufferSize(), true);
    }

    public static <T> l<T> concatEager(Iterable<? extends q> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> l<T> error(Throwable th2) {
        xg.c.b(th2, "e is null");
        return error(new com.google.android.gms.internal.mlkit_common.i(th2, 4));
    }

    public static <T> l<T> fromFuture(Future<? extends T> future, long j4, TimeUnit timeUnit) {
        xg.c.b(future, "future is null");
        xg.c.b(timeUnit, "unit is null");
        return new h4(future, j4, timeUnit);
    }

    public static l<Long> interval(long j4, TimeUnit timeUnit) {
        return interval(j4, j4, timeUnit, ch.f.f3504a);
    }

    public static l<Long> intervalRange(long j4, long j10, long j11, long j12, TimeUnit timeUnit, x xVar) {
        if (j10 < 0) {
            throw new IllegalArgumentException(l0.l(j10, "count >= 0 required but it was "));
        }
        if (j10 == 0) {
            return empty().delay(j11, timeUnit, xVar);
        }
        long j13 = (j10 - 1) + j4;
        if (j4 > 0 && j13 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new c2(j4, j13, Math.max(0L, j11), Math.max(0L, j12), timeUnit, xVar);
    }

    public static <T> l<T> just(T t8, T t10) {
        xg.c.b(t8, "The first item is null");
        xg.c.b(t10, "The second item is null");
        return fromArray(t8, t10);
    }

    public static <T> l<T> merge(Iterable<? extends q> iterable, int i3) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.a.f14442a, i3);
    }

    public static <T> l<T> mergeDelayError(Iterable<? extends q> iterable, int i3) {
        return fromIterable(iterable).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, true, i3);
    }

    public static <T> y sequenceEqual(q qVar, q qVar2, vg.d dVar, int i3) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(dVar, "isEqual is null");
        xg.c.c(i3, "bufferSize");
        return new s3(qVar, qVar2, dVar, i3);
    }

    public static l<Long> timer(long j4, TimeUnit timeUnit, x xVar) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new h4(Math.max(j4, 0L), timeUnit, xVar);
    }

    public final l<List<T>> buffer(long j4, TimeUnit timeUnit) {
        return buffer(j4, timeUnit, ch.f.f3504a, SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public final a concatMapCompletableDelayError(vg.o oVar, boolean z5, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "prefetch");
        return new io.reactivex.internal.operators.mixed.a(this, oVar, z5 ? ErrorMode.END : ErrorMode.BOUNDARY, i3);
    }

    public final <U> l<U> concatMapIterable(vg.o oVar, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "prefetch");
        return (l<U>) concatMap(new v1(oVar, 0), i3);
    }

    public final <R> l<R> concatMapMaybeDelayError(vg.o oVar, boolean z5, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "prefetch");
        return new io.reactivex.internal.operators.mixed.b(this, oVar, z5 ? ErrorMode.END : ErrorMode.BOUNDARY, i3, 0);
    }

    public final <R> l<R> concatMapSingleDelayError(vg.o oVar, boolean z5, int i3) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "prefetch");
        return new io.reactivex.internal.operators.mixed.b(this, oVar, z5 ? ErrorMode.END : ErrorMode.BOUNDARY, i3, 1);
    }

    public final l<T> concatWith(a0 a0Var) {
        xg.c.b(a0Var, "other is null");
        return new h0(this, a0Var, 2);
    }

    public final <U> l<T> debounce(vg.o oVar) {
        xg.c.b(oVar, "debounceSelector is null");
        return new s2(this, oVar, 1);
    }

    public final l<T> delay(long j4, TimeUnit timeUnit, boolean z5) {
        return delay(j4, timeUnit, ch.f.f3504a, z5);
    }

    public final <U> l<T> delaySubscription(q qVar) {
        xg.c.b(qVar, "other is null");
        return new io.reactivex.internal.operators.observable.o(1, this, qVar);
    }

    public final <K> l<T> distinct(vg.o oVar, Callable<? extends Collection<? super K>> callable) {
        xg.c.b(oVar, "keySelector is null");
        xg.c.b(callable, "collectionSupplier is null");
        return new b0(this, oVar, callable, 5);
    }

    public final <R> l<R> flatMap(vg.o oVar, boolean z5, int i3) {
        return flatMap(oVar, z5, i3, bufferSize());
    }

    public final <U, V> l<V> flatMapIterable(vg.o oVar, vg.c cVar) {
        xg.c.b(oVar, "mapper is null");
        xg.c.b(cVar, "resultSelector is null");
        return (l<V>) flatMap(new v1(oVar, 0), cVar, false, bufferSize(), bufferSize());
    }

    public final ug.b forEachWhile(vg.p pVar, vg.g gVar, vg.a aVar) {
        xg.c.b(pVar, "onNext is null");
        xg.c.b(gVar, "onError is null");
        xg.c.b(aVar, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(pVar, gVar, aVar);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final <K, V> l<o1> groupBy(vg.o oVar, vg.o oVar2) {
        return groupBy(oVar, oVar2, false, bufferSize());
    }

    public final l<T> mergeWith(a0 a0Var) {
        xg.c.b(a0Var, "other is null");
        return new k2(this, a0Var);
    }

    public final l<T> observeOn(x xVar, boolean z5, int i3) {
        xg.c.b(xVar, "scheduler is null");
        xg.c.c(i3, "bufferSize");
        return new m2(this, xVar, z5, i3);
    }

    public final l<T> onErrorResumeNext(q qVar) {
        xg.c.b(qVar, "next is null");
        return onErrorResumeNext(new com.google.android.gms.internal.mlkit_common.i(qVar, 4));
    }

    public final <R> y reduce(R r, vg.c cVar) {
        xg.c.b(r, "seed is null");
        xg.c.b(cVar, "reducer is null");
        return new w2(this, r, cVar, 0);
    }

    public final l<T> sample(long j4, TimeUnit timeUnit, boolean z5) {
        return sample(j4, timeUnit, ch.f.f3504a, z5);
    }

    public final <R> l<R> scan(R r, vg.c cVar) {
        xg.c.b(r, "seed is null");
        return scanWith(new com.google.android.gms.internal.mlkit_common.i(r, 4), cVar);
    }

    public final l<T> skip(long j4, TimeUnit timeUnit, x xVar) {
        return skipUntil(timer(j4, timeUnit, xVar));
    }

    public final l<T> skipLast(long j4, TimeUnit timeUnit, boolean z5) {
        return skipLast(j4, timeUnit, ch.f.f3506c, z5, bufferSize());
    }

    public final ug.b subscribe(vg.g gVar, vg.g gVar2) {
        return subscribe(gVar, gVar2, io.reactivex.internal.functions.a.f14444c, io.reactivex.internal.functions.a.f14445d);
    }

    public final l<T> takeLast(long j4, TimeUnit timeUnit) {
        return takeLast(j4, timeUnit, ch.f.f3506c, false, bufferSize());
    }

    public final l<T> takeUntil(vg.p pVar) {
        xg.c.b(pVar, "predicate is null");
        return new io.reactivex.internal.operators.observable.k(this, pVar, 4);
    }

    public final io.reactivex.observers.a test(boolean z5) {
        io.reactivex.observers.a aVar = new io.reactivex.observers.a();
        if (z5) {
            aVar.dispose();
        }
        subscribe(aVar);
        return aVar;
    }

    public final l<T> throttleFirst(long j4, TimeUnit timeUnit, x xVar) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new c4(0, j4, timeUnit, this, xVar);
    }

    public final l<ch.g> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, ch.f.f3504a);
    }

    public final <V> l<T> timeout(vg.o oVar, q qVar) {
        xg.c.b(qVar, "other is null");
        xg.c.b(oVar, "itemTimeoutIndicator is null");
        return new io.reactivex.internal.operators.observable.r(this, null, oVar, qVar, 1);
    }

    public final l<ch.g> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, ch.f.f3504a);
    }

    public final l<l<T>> window(long j4, TimeUnit timeUnit) {
        return window(j4, timeUnit, ch.f.f3504a, Format.OFFSET_SAMPLE_RELATIVE, false);
    }

    public static <T> l<T> concat(q qVar, int i3) {
        xg.c.b(qVar, "sources is null");
        xg.c.c(i3, "prefetch");
        return new f0(qVar, io.reactivex.internal.functions.a.f14442a, i3, ErrorMode.IMMEDIATE);
    }

    public static <T> l<T> concatDelayError(q qVar, int i3, boolean z5) {
        xg.c.b(qVar, "sources is null");
        xg.c.c(i3, "prefetch is null");
        return new f0(qVar, io.reactivex.internal.functions.a.f14442a, i3, z5 ? ErrorMode.END : ErrorMode.BOUNDARY);
    }

    public static <T> l<T> concatEager(Iterable<? extends q> iterable, int i3, int i10) {
        return fromIterable(iterable).concatMapEagerDelayError(io.reactivex.internal.functions.a.f14442a, i3, i10, false);
    }

    public static <T> l<T> merge(q qVar) {
        xg.c.b(qVar, "sources is null");
        return new e1(qVar, io.reactivex.internal.functions.a.f14442a, false, SubsamplingScaleImageView.TILE_SIZE_AUTO, bufferSize());
    }

    public static <T> l<T> mergeDelayError(q qVar) {
        xg.c.b(qVar, "sources is null");
        return new e1(qVar, io.reactivex.internal.functions.a.f14442a, true, SubsamplingScaleImageView.TILE_SIZE_AUTO, bufferSize());
    }

    public static <T> l<T> switchOnNext(q qVar) {
        return switchOnNext(qVar, bufferSize());
    }

    public static <T, R> l<R> zip(q qVar, vg.o oVar) {
        xg.c.b(oVar, "zipper is null");
        xg.c.b(qVar, "sources is null");
        return new h0(qVar).flatMap(new v1(oVar, 2));
    }

    public final l<T> distinctUntilChanged(vg.d dVar) {
        xg.c.b(dVar, "comparer is null");
        return new b0(this, io.reactivex.internal.functions.a.f14442a, dVar, 6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> l<R> flatMap(vg.o oVar, boolean z5, int i3, int i10) {
        xg.c.b(oVar, "mapper is null");
        xg.c.c(i3, "maxConcurrency");
        xg.c.c(i10, "bufferSize");
        if (this instanceof yg.d) {
            Object call = ((yg.d) this).call();
            if (call == null) {
                return empty();
            }
            return new io.reactivex.internal.operators.observable.o(3, call, oVar);
        }
        return new e1(this, oVar, z5, i3, i10);
    }

    public final <K, V> l<o1> groupBy(vg.o oVar, vg.o oVar2, boolean z5) {
        return groupBy(oVar, oVar2, z5, bufferSize());
    }

    public final <R> l<R> publish(vg.o oVar) {
        xg.c.b(oVar, "selector is null");
        return new s2(this, oVar, 0);
    }

    public final <R> l<R> replay(vg.o oVar, long j4, TimeUnit timeUnit) {
        return replay(oVar, j4, timeUnit, ch.f.f3504a);
    }

    public final l<T> retry(long j4) {
        return retry(j4, io.reactivex.internal.functions.a.f14446f);
    }

    public final l<T> startWith(T t8) {
        xg.c.b(t8, "item is null");
        return concatArray(just(t8), this);
    }

    public final ug.b subscribe(vg.g gVar, vg.g gVar2, vg.a aVar) {
        return subscribe(gVar, gVar2, aVar, io.reactivex.internal.functions.a.f14445d);
    }

    public final <U extends Collection<? super T>> y toList(Callable<U> callable) {
        xg.c.b(callable, "collectionSupplier is null");
        return new io.reactivex.internal.operators.observable.m(this, callable, 2);
    }

    public final <T1, T2, R> l<R> withLatestFrom(q qVar, q qVar2, vg.h hVar) {
        xg.c.b(qVar, "o1 is null");
        xg.c.b(qVar2, "o2 is null");
        xg.c.b(hVar, "combiner is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final <U, R> l<R> zipWith(q qVar, vg.c cVar) {
        xg.c.b(qVar, "other is null");
        return zip(this, qVar, cVar);
    }

    public static l<Long> interval(long j4, long j10, TimeUnit timeUnit, x xVar) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new b2(Math.max(0L, j4), Math.max(0L, j10), timeUnit, xVar);
    }

    public final l<List<T>> buffer(long j4, TimeUnit timeUnit, int i3) {
        return buffer(j4, timeUnit, ch.f.f3504a, i3);
    }

    public final l<T> concatWith(i iVar) {
        xg.c.b(iVar, "other is null");
        return new h0(this, iVar, 1);
    }

    public final l<T> debounce(long j4, TimeUnit timeUnit, x xVar) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new c4(1, j4, timeUnit, this, xVar);
    }

    public final <U> l<T> delay(vg.o oVar) {
        xg.c.b(oVar, "itemDelay is null");
        return (l<T>) flatMap(new v1(oVar, 1));
    }

    public final l<T> delaySubscription(long j4, TimeUnit timeUnit, x xVar) {
        return delaySubscription(timer(j4, timeUnit, xVar));
    }

    public final <K, V> l<o1> groupBy(vg.o oVar, vg.o oVar2, boolean z5, int i3) {
        xg.c.b(oVar, "keySelector is null");
        xg.c.b(oVar2, "valueSelector is null");
        xg.c.c(i3, "bufferSize");
        return new p1(this, oVar, oVar2, i3, z5);
    }

    public final l<T> mergeWith(i iVar) {
        xg.c.b(iVar, "other is null");
        return new j2(this, iVar);
    }

    public final l<T> retry(long j4, vg.p pVar) {
        if (j4 >= 0) {
            xg.c.b(pVar, "predicate is null");
            return new k3(this, j4, pVar);
        }
        throw new IllegalArgumentException(l0.l(j4, "times >= 0 required but it was "));
    }

    public final l<T> sample(long j4, TimeUnit timeUnit, x xVar) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new m3(0, j4, timeUnit, this, xVar, false);
    }

    public final l<T> skipLast(int i3) {
        if (i3 >= 0) {
            return i3 == 0 ? this : new t3(this, i3, 0);
        }
        throw new IndexOutOfBoundsException(l0.j(i3, "count >= 0 required but it was "));
    }

    public final ug.b subscribe(vg.g gVar, vg.g gVar2, vg.a aVar, vg.g gVar3) {
        xg.c.b(gVar, "onNext is null");
        xg.c.b(gVar2, "onError is null");
        xg.c.b(aVar, "onComplete is null");
        xg.c.b(gVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(gVar, gVar2, aVar, gVar3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public final l<T> takeLast(long j4, TimeUnit timeUnit, boolean z5) {
        return takeLast(j4, timeUnit, ch.f.f3506c, z5, bufferSize());
    }

    public final <K, V> y toMap(vg.o oVar, vg.o oVar2) {
        xg.c.b(oVar, "keySelector is null");
        xg.c.b(oVar2, "valueSelector is null");
        return collect(HashMapSupplier.asCallable(), new o4.c(oVar2, oVar));
    }

    public final <K, V> y toMultimap(vg.o oVar, vg.o oVar2) {
        return toMultimap(oVar, oVar2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final l<l<T>> window(long j4, TimeUnit timeUnit, long j10) {
        return window(j4, timeUnit, ch.f.f3504a, j10, false);
    }

    public static <T> l<T> fromFuture(Future<? extends T> future, long j4, TimeUnit timeUnit, x xVar) {
        xg.c.b(xVar, "scheduler is null");
        return fromFuture(future, j4, timeUnit).subscribeOn(xVar);
    }

    public static <T, S> l<T> generate(Callable<S> callable, vg.b bVar) {
        xg.c.b(bVar, "generator  is null");
        return generate(callable, new z1(bVar, 0), io.reactivex.internal.functions.a.f14445d);
    }

    public static <T> l<T> just(T t8, T t10, T t11) {
        xg.c.b(t8, "The first item is null");
        xg.c.b(t10, "The second item is null");
        xg.c.b(t11, "The third item is null");
        return fromArray(t8, t10, t11);
    }

    public static <T> l<T> merge(q qVar, int i3) {
        xg.c.b(qVar, "sources is null");
        xg.c.c(i3, "maxConcurrency");
        return new e1(qVar, io.reactivex.internal.functions.a.f14442a, false, i3, bufferSize());
    }

    public static <T> l<T> mergeDelayError(q qVar, int i3) {
        xg.c.b(qVar, "sources is null");
        xg.c.c(i3, "maxConcurrency");
        return new e1(qVar, io.reactivex.internal.functions.a.f14442a, true, i3, bufferSize());
    }

    public final T blockingFirst(T t8) {
        io.reactivex.internal.observers.c cVar = new io.reactivex.internal.observers.c(1, 0);
        subscribe(cVar);
        T t10 = (T) cVar.a();
        return t10 != null ? t10 : t8;
    }

    public final T blockingLast(T t8) {
        io.reactivex.internal.observers.c cVar = new io.reactivex.internal.observers.c(1, 1);
        subscribe(cVar);
        T t10 = (T) cVar.a();
        return t10 != null ? t10 : t8;
    }

    public final zg.a replay(int i3, long j4, TimeUnit timeUnit) {
        return replay(i3, j4, timeUnit, ch.f.f3504a);
    }

    public final l<ch.g> timeInterval(x xVar) {
        return timeInterval(TimeUnit.MILLISECONDS, xVar);
    }

    public final l<T> timeout(long j4, TimeUnit timeUnit, q qVar) {
        xg.c.b(qVar, "other is null");
        return b(j4, timeUnit, ch.f.f3504a, qVar);
    }

    public final l<ch.g> timestamp(x xVar) {
        return timestamp(TimeUnit.MILLISECONDS, xVar);
    }

    public final <U, R> l<R> zipWith(q qVar, vg.c cVar, boolean z5) {
        return zip(this, qVar, cVar, z5);
    }

    public static <T, R> l<R> combineLatest(q[] qVarArr, vg.o oVar) {
        return combineLatest(qVarArr, oVar, bufferSize());
    }

    public static <T> l<T> concat(q qVar, q qVar2) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        return concatArray(qVar, qVar2);
    }

    public final T blockingSingle(T t8) {
        y single = single(t8);
        single.getClass();
        io.reactivex.internal.observers.d dVar = new io.reactivex.internal.observers.d(1);
        single.b(dVar);
        return (T) dVar.a();
    }

    public final l<List<T>> buffer(int i3) {
        return buffer(i3, i3);
    }

    public final l<T> concatWith(c cVar) {
        xg.c.b(cVar, "other is null");
        return new h0(this, cVar, 0);
    }

    public final l<T> doOnEach(s sVar) {
        xg.c.b(sVar, "observer is null");
        return a(new x1(sVar, 2), new x1(sVar, 1), new x1(sVar, 0), io.reactivex.internal.functions.a.f14444c);
    }

    public final l<T> mergeWith(c cVar) {
        xg.c.b(cVar, "other is null");
        return new i2(this, cVar);
    }

    public final l<T> takeLast(int i3) {
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(l0.j(i3, "count >= 0 required but it was "));
        }
        if (i3 == 0) {
            return new a3(this, 5);
        }
        if (i3 == 1) {
            return new a3(this, 9);
        }
        return new t3(this, i3, 1);
    }

    public final l<ch.g> timeInterval(TimeUnit timeUnit, x xVar) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new b0(this, timeUnit, xVar, 9, false);
    }

    public final l<ch.g> timestamp(TimeUnit timeUnit, x xVar) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return map(new xg.b(timeUnit, xVar));
    }

    public final y toSortedList(Comparator<? super T> comparator, int i3) {
        xg.c.b(comparator, "comparator is null");
        y list = toList(i3);
        n6.a aVar = new n6.a(comparator, 26);
        list.getClass();
        return new g2(2, list, aVar);
    }

    public final l<l<T>> window(long j4, TimeUnit timeUnit, long j10, boolean z5) {
        return window(j4, timeUnit, ch.f.f3504a, j10, z5);
    }

    public final <U, R> l<R> zipWith(q qVar, vg.c cVar, boolean z5, int i3) {
        return zip(this, qVar, cVar, z5, i3);
    }

    public static <T, R> l<R> combineLatest(q[] qVarArr, vg.o oVar, int i3) {
        xg.c.b(qVarArr, "sources is null");
        if (qVarArr.length == 0) {
            return empty();
        }
        xg.c.b(oVar, "combiner is null");
        xg.c.c(i3, "bufferSize");
        return new e0(qVarArr, null, oVar, i3 << 1, false, 0);
    }

    public static <T, R> l<R> combineLatestDelayError(Iterable<? extends q> iterable, vg.o oVar) {
        return combineLatestDelayError(iterable, oVar, bufferSize());
    }

    public static l<Long> interval(long j4, TimeUnit timeUnit, x xVar) {
        return interval(j4, j4, timeUnit, xVar);
    }

    public static <T> y sequenceEqual(q qVar, q qVar2, int i3) {
        return sequenceEqual(qVar, qVar2, xg.c.f19826a, i3);
    }

    public final l<List<T>> buffer(int i3, int i10) {
        return (l<List<T>>) buffer(i3, i10, ArrayListSupplier.asCallable());
    }

    public final l<T> delay(long j4, TimeUnit timeUnit, x xVar) {
        return delay(j4, timeUnit, xVar, false);
    }

    public final zg.a replay(long j4, TimeUnit timeUnit) {
        return replay(j4, timeUnit, ch.f.f3504a);
    }

    public final l<T> sample(long j4, TimeUnit timeUnit, x xVar, boolean z5) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new m3(0, j4, timeUnit, this, xVar, z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final l<T> sorted(Comparator<? super T> comparator) {
        l aVar;
        xg.c.b(comparator, "sortFunction is null");
        y list = toList();
        list.getClass();
        if (list instanceof yg.a) {
            aVar = ((yg.a) list).a();
        } else {
            aVar = new io.reactivex.internal.operators.single.a(list);
        }
        return aVar.map(new n6.a(comparator, 26)).flatMapIterable(io.reactivex.internal.functions.a.f14442a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> y toMultimap(vg.o oVar, vg.o oVar2, Callable<? extends Map<K, Collection<V>>> callable, vg.o oVar3) {
        xg.c.b(oVar, "keySelector is null");
        xg.c.b(oVar2, "valueSelector is null");
        xg.c.b(callable, "mapSupplier is null");
        xg.c.b(oVar3, "collectionFactory is null");
        return collect(callable, new n.l(oVar3, oVar2, oVar, 15, false));
    }

    public final <T1, T2, T3, R> l<R> withLatestFrom(q qVar, q qVar2, q qVar3, vg.i iVar) {
        xg.c.b(qVar, "o1 is null");
        xg.c.b(qVar2, "o2 is null");
        xg.c.b(qVar3, "o3 is null");
        xg.c.b(iVar, "combiner is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public static <T, R> l<R> combineLatestDelayError(Iterable<? extends q> iterable, vg.o oVar, int i3) {
        xg.c.b(iterable, "sources is null");
        xg.c.b(oVar, "combiner is null");
        xg.c.c(i3, "bufferSize");
        return new e0(null, iterable, oVar, i3 << 1, true, 0);
    }

    public static <T> l<T> fromFuture(Future<? extends T> future, x xVar) {
        xg.c.b(xVar, "scheduler is null");
        return fromFuture(future).subscribeOn(xVar);
    }

    public static <T, S> l<T> generate(Callable<S> callable, vg.b bVar, vg.g gVar) {
        xg.c.b(bVar, "generator  is null");
        return generate(callable, new z1(bVar, 0), gVar);
    }

    public static <T> l<T> merge(q qVar, q qVar2) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        return fromArray(qVar, qVar2).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, false, 2);
    }

    public static <T> l<T> mergeDelayError(q qVar, q qVar2) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        return fromArray(qVar, qVar2).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, true, 2);
    }

    public static <T1, T2, R> l<R> zip(q qVar, q qVar2, vg.c cVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(cVar, "f is null");
        return zipArray(new mc.g(cVar, 24), false, bufferSize(), qVar, qVar2);
    }

    public final <U extends Collection<? super T>> l<U> buffer(int i3, int i10, Callable<U> callable) {
        xg.c.c(i3, Const.SP_KEY_CALL_LOC_COUNT);
        xg.c.c(i10, "skip");
        xg.c.b(callable, "bufferSupplier is null");
        return new io.reactivex.internal.operators.observable.q(this, i3, i10, callable);
    }

    public final l<T> delay(long j4, TimeUnit timeUnit, x xVar, boolean z5) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new m3(1, j4, timeUnit, this, xVar, z5);
    }

    public final y elementAt(long j4, T t8) {
        if (j4 >= 0) {
            xg.c.b(t8, "defaultItem is null");
            return new c1(this, j4, t8);
        }
        throw new IndexOutOfBoundsException(l0.l(j4, "index >= 0 required but it was "));
    }

    public final l<T> take(long j4, TimeUnit timeUnit) {
        return takeUntil(timer(j4, timeUnit));
    }

    public final l<T> timeout(long j4, TimeUnit timeUnit, x xVar, q qVar) {
        xg.c.b(qVar, "other is null");
        return b(j4, timeUnit, xVar, qVar);
    }

    public final l<l<T>> window(long j4) {
        return window(j4, j4, bufferSize());
    }

    public static <T> l<T> concat(q qVar, q qVar2, q qVar3) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        return concatArray(qVar, qVar2, qVar3);
    }

    public static <T> l<T> just(T t8, T t10, T t11, T t12) {
        xg.c.b(t8, "The first item is null");
        xg.c.b(t10, "The second item is null");
        xg.c.b(t11, "The third item is null");
        xg.c.b(t12, "The fourth item is null");
        return fromArray(t8, t10, t11, t12);
    }

    public final <R> l<R> replay(vg.o oVar) {
        xg.c.b(oVar, "selector is null");
        return new io.reactivex.internal.operators.observable.o(2, new y1(this), oVar);
    }

    public final l<T> take(long j4, TimeUnit timeUnit, x xVar) {
        return takeUntil(timer(j4, timeUnit, xVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> y toMap(vg.o oVar, vg.o oVar2, Callable<? extends Map<K, V>> callable) {
        xg.c.b(oVar, "keySelector is null");
        xg.c.b(oVar2, "valueSelector is null");
        xg.c.b(callable, "mapSupplier is null");
        return collect(callable, new o4.c(oVar2, oVar));
    }

    public final l<l<T>> window(long j4, long j10) {
        return window(j4, j10, bufferSize());
    }

    public final <U> l<T> sample(q qVar) {
        xg.c.b(qVar, "sampler is null");
        return new f1(this, qVar, false, 4);
    }

    @Override // rg.q
    public final void subscribe(s sVar) {
        xg.c.b(sVar, "observer is null");
        try {
            subscribeActual(sVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            ad.a(th2);
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public final l<T> timeout(long j4, TimeUnit timeUnit, x xVar) {
        return b(j4, timeUnit, xVar, null);
    }

    public final l<l<T>> window(long j4, long j10, int i3) {
        xg.c.d(j4, Const.SP_KEY_CALL_LOC_COUNT);
        xg.c.d(j10, "skip");
        xg.c.c(i3, "bufferSize");
        return new k4(this, j4, j10, i3);
    }

    public static <T, S> l<T> generate(Callable<S> callable, vg.c cVar) {
        return generate(callable, cVar, io.reactivex.internal.functions.a.f14445d);
    }

    public static <T> l<T> merge(q qVar, q qVar2, q qVar3) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        return fromArray(qVar, qVar2, qVar3).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, false, 3);
    }

    public static <T> l<T> mergeDelayError(q qVar, q qVar2, q qVar3) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        return fromArray(qVar, qVar2, qVar3).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, true, 3);
    }

    public final <U, V> l<T> delay(q qVar, vg.o oVar) {
        return delaySubscription(qVar).delay(oVar);
    }

    public final <R> l<R> flatMap(vg.o oVar, vg.o oVar2, Callable<? extends q> callable) {
        xg.c.b(oVar, "onNextMapper is null");
        xg.c.b(oVar2, "onErrorMapper is null");
        xg.c.b(callable, "onCompleteSupplier is null");
        return merge(new io.reactivex.internal.operators.observable.r(this, oVar, oVar2, callable));
    }

    public final <U, V> l<T> timeout(q qVar, vg.o oVar) {
        xg.c.b(qVar, "firstTimeoutIndicator is null");
        xg.c.b(oVar, "itemTimeoutIndicator is null");
        return new io.reactivex.internal.operators.observable.r(this, qVar, oVar, null, 1);
    }

    public final y toSortedList(int i3) {
        return toSortedList(io.reactivex.internal.functions.a.f14449i, i3);
    }

    public static <T, S> l<T> generate(Callable<S> callable, vg.c cVar, vg.g gVar) {
        xg.c.b(callable, "initialState is null");
        xg.c.b(cVar, "generator  is null");
        xg.c.b(gVar, "disposeState is null");
        return new n1(callable, cVar, gVar);
    }

    public final void blockingSubscribe(vg.g gVar) {
        cd.b(this, gVar, io.reactivex.internal.functions.a.e, io.reactivex.internal.functions.a.f14444c);
    }

    public final <U extends Collection<? super T>> l<U> buffer(int i3, Callable<U> callable) {
        return buffer(i3, i3, callable);
    }

    public final <R> l<R> replay(vg.o oVar, int i3) {
        xg.c.b(oVar, "selector is null");
        xg.c.c(i3, "bufferSize");
        return new io.reactivex.internal.operators.observable.o(2, new t1(this, i3), oVar);
    }

    public final <U> l<T> sample(q qVar, boolean z5) {
        xg.c.b(qVar, "sampler is null");
        return new f1(this, qVar, z5, 4);
    }

    public final l<T> skipLast(long j4, TimeUnit timeUnit, x xVar) {
        return skipLast(j4, timeUnit, xVar, false, bufferSize());
    }

    public final <T1, T2, T3, T4, R> l<R> withLatestFrom(q qVar, q qVar2, q qVar3, q qVar4, vg.j jVar) {
        xg.c.b(qVar, "o1 is null");
        xg.c.b(qVar2, "o2 is null");
        xg.c.b(qVar3, "o3 is null");
        xg.c.b(qVar4, "o4 is null");
        xg.c.b(jVar, "combiner is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public static <T1, T2, R> l<R> combineLatest(q qVar, q qVar2, vg.c cVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(cVar, "f is null");
        return combineLatest(new mc.g(cVar, 24), bufferSize(), qVar, qVar2);
    }

    public static <T> l<T> concat(q qVar, q qVar2, q qVar3, q qVar4) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        return concatArray(qVar, qVar2, qVar3, qVar4);
    }

    public static <T1, T2, R> l<R> zip(q qVar, q qVar2, vg.c cVar, boolean z5) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(cVar, "f is null");
        return zipArray(new mc.g(cVar, 24), z5, bufferSize(), qVar, qVar2);
    }

    public final void blockingSubscribe(vg.g gVar, vg.g gVar2) {
        cd.b(this, gVar, gVar2, io.reactivex.internal.functions.a.f14444c);
    }

    public final l<List<T>> buffer(long j4, long j10, TimeUnit timeUnit, x xVar) {
        return (l<List<T>>) buffer(j4, j10, timeUnit, xVar, ArrayListSupplier.asCallable());
    }

    public final l<T> retry(vg.p pVar) {
        return retry(Format.OFFSET_SAMPLE_RELATIVE, pVar);
    }

    public final l<T> skipLast(long j4, TimeUnit timeUnit, x xVar, boolean z5) {
        return skipLast(j4, timeUnit, xVar, z5, bufferSize());
    }

    public final <K, V> y toMultimap(vg.o oVar, vg.o oVar2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(oVar, oVar2, callable, ArrayListSupplier.asFunction());
    }

    public static <T> l<T> just(T t8, T t10, T t11, T t12, T t13) {
        xg.c.b(t8, "The first item is null");
        xg.c.b(t10, "The second item is null");
        xg.c.b(t11, "The third item is null");
        xg.c.b(t12, "The fourth item is null");
        xg.c.b(t13, "The fifth item is null");
        return fromArray(t8, t10, t11, t12, t13);
    }

    public final void blockingSubscribe(vg.g gVar, vg.g gVar2, vg.a aVar) {
        cd.b(this, gVar, gVar2, aVar);
    }

    public final <U extends Collection<? super T>> l<U> buffer(long j4, long j10, TimeUnit timeUnit, x xVar, Callable<U> callable) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        xg.c.b(callable, "bufferSupplier is null");
        return new io.reactivex.internal.operators.observable.z(this, j4, j10, timeUnit, xVar, callable, SubsamplingScaleImageView.TILE_SIZE_AUTO, false);
    }

    public final l<T> skipLast(long j4, TimeUnit timeUnit, x xVar, boolean z5, int i3) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        xg.c.c(i3, "bufferSize");
        return new u3(i3 << 1, j4, timeUnit, this, xVar, z5);
    }

    public final <U, V> l<T> timeout(q qVar, vg.o oVar, q qVar2) {
        xg.c.b(qVar, "firstTimeoutIndicator is null");
        xg.c.b(qVar2, "other is null");
        xg.c.b(oVar, "itemTimeoutIndicator is null");
        return new io.reactivex.internal.operators.observable.r(this, qVar, oVar, qVar2, 1);
    }

    public final l<l<T>> window(long j4, long j10, TimeUnit timeUnit, x xVar) {
        return window(j4, j10, timeUnit, xVar, bufferSize());
    }

    public static <T> l<T> merge(q qVar, q qVar2, q qVar3, q qVar4) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        return fromArray(qVar, qVar2, qVar3, qVar4).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, false, 4);
    }

    public static <T> l<T> mergeDelayError(q qVar, q qVar2, q qVar3, q qVar4) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        return fromArray(qVar, qVar2, qVar3, qVar4).flatMap((vg.o) io.reactivex.internal.functions.a.f14442a, true, 4);
    }

    public final void blockingSubscribe(s sVar) {
        cd.a(this, sVar);
    }

    public final <R> l<R> flatMap(vg.o oVar, vg.o oVar2, Callable<? extends q> callable, int i3) {
        xg.c.b(oVar, "onNextMapper is null");
        xg.c.b(oVar2, "onErrorMapper is null");
        xg.c.b(callable, "onCompleteSupplier is null");
        return merge(new io.reactivex.internal.operators.observable.r(this, oVar, oVar2, callable), i3);
    }

    public final l<l<T>> window(long j4, long j10, TimeUnit timeUnit, x xVar, int i3) {
        xg.c.d(j4, "timespan");
        xg.c.d(j10, "timeskip");
        xg.c.c(i3, "bufferSize");
        xg.c.b(xVar, "scheduler is null");
        xg.c.b(timeUnit, "unit is null");
        return new w4(this, j4, j10, timeUnit, xVar, Format.OFFSET_SAMPLE_RELATIVE, i3, false);
    }

    public final <R> l<R> replay(vg.o oVar, int i3, long j4, TimeUnit timeUnit, x xVar) {
        xg.c.b(oVar, "selector is null");
        xg.c.c(i3, "bufferSize");
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new io.reactivex.internal.operators.observable.o(2, new u1(i3, j4, timeUnit, this, xVar), oVar);
    }

    public static <T1, T2, T3, R> l<R> combineLatest(q qVar, q qVar2, q qVar3, vg.h hVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public static <T1, T2, R> l<R> zip(q qVar, q qVar2, vg.c cVar, boolean z5, int i3) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(cVar, "f is null");
        return zipArray(new mc.g(cVar, 24), z5, i3, qVar, qVar2);
    }

    public final l<List<T>> buffer(long j4, TimeUnit timeUnit, x xVar, int i3) {
        return (l<List<T>>) buffer(j4, timeUnit, xVar, i3, ArrayListSupplier.asCallable(), false);
    }

    public final l<T> takeLast(long j4, long j10, TimeUnit timeUnit, x xVar) {
        return takeLast(j4, j10, timeUnit, xVar, false, bufferSize());
    }

    public final <V> l<T> timeout(vg.o oVar) {
        xg.c.b(oVar, "itemTimeoutIndicator is null");
        q qVar = null;
        return new io.reactivex.internal.operators.observable.r(this, qVar, oVar, qVar, 1);
    }

    public final <R> l<R> withLatestFrom(q[] qVarArr, vg.o oVar) {
        xg.c.b(qVarArr, "others is null");
        xg.c.b(oVar, "combiner is null");
        return new io.reactivex.internal.operators.observable.r(this, qVarArr, oVar);
    }

    public final <U extends Collection<? super T>> l<U> buffer(long j4, TimeUnit timeUnit, x xVar, int i3, Callable<U> callable, boolean z5) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        xg.c.b(callable, "bufferSupplier is null");
        xg.c.c(i3, Const.SP_KEY_CALL_LOC_COUNT);
        return new io.reactivex.internal.operators.observable.z(this, j4, j4, timeUnit, xVar, callable, i3, z5);
    }

    public final <R> l<R> flatMap(vg.o oVar, int i3) {
        return flatMap(oVar, false, i3, bufferSize());
    }

    public final l<T> takeLast(long j4, long j10, TimeUnit timeUnit, x xVar, boolean z5, int i3) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        xg.c.c(i3, "bufferSize");
        if (j4 >= 0) {
            return new a4(this, j4, j10, timeUnit, xVar, i3, z5);
        }
        throw new IndexOutOfBoundsException(l0.l(j4, "count >= 0 required but it was "));
    }

    public static <T> l<T> just(T t8, T t10, T t11, T t12, T t13, T t14) {
        xg.c.b(t8, "The first item is null");
        xg.c.b(t10, "The second item is null");
        xg.c.b(t11, "The third item is null");
        xg.c.b(t12, "The fourth item is null");
        xg.c.b(t13, "The fifth item is null");
        xg.c.b(t14, "The sixth item is null");
        return fromArray(t8, t10, t11, t12, t13, t14);
    }

    public final <U, R> l<R> flatMap(vg.o oVar, vg.c cVar) {
        return flatMap(oVar, cVar, false, bufferSize(), bufferSize());
    }

    public final <U, R> l<R> flatMap(vg.o oVar, vg.c cVar, boolean z5) {
        return flatMap(oVar, cVar, z5, bufferSize(), bufferSize());
    }

    public final l<l<T>> window(long j4, TimeUnit timeUnit, x xVar) {
        return window(j4, timeUnit, xVar, Format.OFFSET_SAMPLE_RELATIVE, false);
    }

    public final <R> l<R> withLatestFrom(Iterable<? extends q> iterable, vg.o oVar) {
        xg.c.b(iterable, "others is null");
        xg.c.b(oVar, "combiner is null");
        return new io.reactivex.internal.operators.observable.r(this, iterable, oVar);
    }

    public static <T1, T2, T3, T4, R> l<R> combineLatest(q qVar, q qVar2, q qVar3, q qVar4, vg.i iVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final <U, R> l<R> flatMap(vg.o oVar, vg.c cVar, boolean z5, int i3) {
        return flatMap(oVar, cVar, z5, i3, bufferSize());
    }

    public final <R> l<R> replay(vg.o oVar, int i3, x xVar) {
        xg.c.b(oVar, "selector is null");
        xg.c.b(xVar, "scheduler is null");
        xg.c.c(i3, "bufferSize");
        return new io.reactivex.internal.operators.observable.o(2, new t1(this, i3), new w1(2, oVar, xVar));
    }

    public final l<l<T>> window(long j4, TimeUnit timeUnit, x xVar, long j10) {
        return window(j4, timeUnit, xVar, j10, false);
    }

    public static <T1, T2, T3, R> l<R> zip(q qVar, q qVar2, q qVar3, vg.h hVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final <U, R> l<R> flatMap(vg.o oVar, vg.c cVar, boolean z5, int i3, int i10) {
        xg.c.b(oVar, "mapper is null");
        xg.c.b(cVar, "combiner is null");
        return flatMap(new w1(1, cVar, oVar), z5, i3, i10);
    }

    public final l<l<T>> window(long j4, TimeUnit timeUnit, x xVar, long j10, boolean z5) {
        return window(j4, timeUnit, xVar, j10, z5, bufferSize());
    }

    public final l<List<T>> buffer(long j4, TimeUnit timeUnit, x xVar) {
        return (l<List<T>>) buffer(j4, timeUnit, xVar, SubsamplingScaleImageView.TILE_SIZE_AUTO, ArrayListSupplier.asCallable(), false);
    }

    public final l<l<T>> window(long j4, TimeUnit timeUnit, x xVar, long j10, boolean z5, int i3) {
        xg.c.c(i3, "bufferSize");
        xg.c.b(xVar, "scheduler is null");
        xg.c.b(timeUnit, "unit is null");
        xg.c.d(j10, Const.SP_KEY_CALL_LOC_COUNT);
        return new w4(this, j4, j4, timeUnit, xVar, j10, i3, z5);
    }

    public final <TOpening, TClosing> l<List<T>> buffer(q qVar, vg.o oVar) {
        return (l<List<T>>) buffer(qVar, oVar, ArrayListSupplier.asCallable());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> l<U> buffer(q qVar, vg.o oVar, Callable<U> callable) {
        xg.c.b(qVar, "openingIndicator is null");
        xg.c.b(oVar, "closingIndicator is null");
        xg.c.b(callable, "bufferSupplier is null");
        return new io.reactivex.internal.operators.observable.r(this, qVar, oVar, callable, 0);
    }

    public static <T1, T2, T3, T4, T5, R> l<R> combineLatest(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, vg.j jVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public static <T> l<T> just(T t8, T t10, T t11, T t12, T t13, T t14, T t15) {
        xg.c.b(t8, "The first item is null");
        xg.c.b(t10, "The second item is null");
        xg.c.b(t11, "The third item is null");
        xg.c.b(t12, "The fourth item is null");
        xg.c.b(t13, "The fifth item is null");
        xg.c.b(t14, "The sixth item is null");
        xg.c.b(t15, "The seventh item is null");
        return fromArray(t8, t10, t11, t12, t13, t14, t15);
    }

    public static <T1, T2, T3, T4, R> l<R> zip(q qVar, q qVar2, q qVar3, q qVar4, vg.i iVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final <U, R> l<R> flatMap(vg.o oVar, vg.c cVar, int i3) {
        return flatMap(oVar, cVar, false, i3, bufferSize());
    }

    public final <R> l<R> replay(vg.o oVar, long j4, TimeUnit timeUnit, x xVar) {
        xg.c.b(oVar, "selector is null");
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return new io.reactivex.internal.operators.observable.o(2, new a2(this, j4, timeUnit, xVar), oVar);
    }

    public final <B> l<l<T>> window(q qVar) {
        return window(qVar, bufferSize());
    }

    public final <B> l<List<T>> buffer(q qVar) {
        return (l<List<T>>) buffer(qVar, ArrayListSupplier.asCallable());
    }

    public final l<T> takeLast(long j4, TimeUnit timeUnit, x xVar) {
        return takeLast(j4, timeUnit, xVar, false, bufferSize());
    }

    public final <B> l<l<T>> window(q qVar, int i3) {
        xg.c.b(qVar, "boundary is null");
        xg.c.c(i3, "bufferSize");
        return new m4(this, qVar, i3, 0);
    }

    public final <B> l<List<T>> buffer(q qVar, int i3) {
        xg.c.c(i3, "initialCapacity");
        return (l<List<T>>) buffer(qVar, new xg.a(i3));
    }

    public final l<T> takeLast(long j4, TimeUnit timeUnit, x xVar, boolean z5) {
        return takeLast(j4, timeUnit, xVar, z5, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> l<R> zip(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, vg.j jVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final l<T> takeLast(long j4, TimeUnit timeUnit, x xVar, boolean z5, int i3) {
        return takeLast(Format.OFFSET_SAMPLE_RELATIVE, j4, timeUnit, xVar, z5, i3);
    }

    public static <T1, T2, T3, T4, T5, T6, R> l<R> combineLatest(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, q qVar6, vg.k kVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(qVar6, "source6 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final <R> l<R> replay(vg.o oVar, x xVar) {
        xg.c.b(oVar, "selector is null");
        xg.c.b(xVar, "scheduler is null");
        return new io.reactivex.internal.operators.observable.o(2, new y1(this), new w1(2, oVar, xVar));
    }

    public final <U, V> l<l<T>> window(q qVar, vg.o oVar) {
        return window(qVar, oVar, bufferSize());
    }

    public final <B, U extends Collection<? super T>> l<U> buffer(q qVar, Callable<U> callable) {
        xg.c.b(qVar, "boundary is null");
        xg.c.b(callable, "bufferSupplier is null");
        return new b0(this, qVar, callable, 3);
    }

    public final <U, V> l<l<T>> window(q qVar, vg.o oVar, int i3) {
        xg.c.b(qVar, "openingIndicator is null");
        xg.c.b(oVar, "closingIndicator is null");
        xg.c.c(i3, "bufferSize");
        return new f0(this, qVar, oVar, i3);
    }

    public static <T> l<T> just(T t8, T t10, T t11, T t12, T t13, T t14, T t15, T t16) {
        xg.c.b(t8, "The first item is null");
        xg.c.b(t10, "The second item is null");
        xg.c.b(t11, "The third item is null");
        xg.c.b(t12, "The fourth item is null");
        xg.c.b(t13, "The fifth item is null");
        xg.c.b(t14, "The sixth item is null");
        xg.c.b(t15, "The seventh item is null");
        xg.c.b(t16, "The eighth item is null");
        return fromArray(t8, t10, t11, t12, t13, t14, t15, t16);
    }

    public final <B> l<List<T>> buffer(Callable<? extends q> callable) {
        return (l<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    public static <T1, T2, T3, T4, T5, T6, R> l<R> zip(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, q qVar6, vg.k kVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(qVar6, "source6 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final <B, U extends Collection<? super T>> l<U> buffer(Callable<? extends q> callable, Callable<U> callable2) {
        xg.c.b(callable, "boundarySupplier is null");
        xg.c.b(callable2, "bufferSupplier is null");
        return new b0(this, callable, callable2, 2);
    }

    public final zg.a replay(int i3) {
        xg.c.c(i3, "bufferSize");
        if (i3 == Integer.MAX_VALUE) {
            return j3.d(this, j3.e);
        }
        return j3.d(this, new f3(i3));
    }

    public final <B> l<l<T>> window(Callable<? extends q> callable) {
        return window(callable, bufferSize());
    }

    public final <B> l<l<T>> window(Callable<? extends q> callable, int i3) {
        xg.c.b(callable, "boundary is null");
        xg.c.c(i3, "bufferSize");
        return new m4(this, callable, i3, 1);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> l<R> combineLatest(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, q qVar6, q qVar7, vg.l lVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(qVar6, "source6 is null");
        xg.c.b(qVar7, "source7 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final zg.a replay(int i3, long j4, TimeUnit timeUnit, x xVar) {
        xg.c.c(i3, "bufferSize");
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return j3.d(this, new h3(i3, j4, timeUnit, xVar));
    }

    public static <T> l<T> just(T t8, T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        xg.c.b(t8, "The first item is null");
        xg.c.b(t10, "The second item is null");
        xg.c.b(t11, "The third item is null");
        xg.c.b(t12, "The fourth item is null");
        xg.c.b(t13, "The fifth item is null");
        xg.c.b(t14, "The sixth item is null");
        xg.c.b(t15, "The seventh item is null");
        xg.c.b(t16, "The eighth item is null");
        xg.c.b(t17, "The ninth item is null");
        return fromArray(t8, t10, t11, t12, t13, t14, t15, t16, t17);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> l<R> zip(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, q qVar6, q qVar7, vg.l lVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(qVar6, "source6 is null");
        xg.c.b(qVar7, "source7 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final zg.a replay(int i3, x xVar) {
        xg.c.c(i3, "bufferSize");
        zg.a replay = replay(i3);
        return new d3(replay, replay.observeOn(xVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> l<R> combineLatest(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, q qVar6, q qVar7, q qVar8, vg.m mVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(qVar6, "source6 is null");
        xg.c.b(qVar7, "source7 is null");
        xg.c.b(qVar8, "source8 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public final zg.a replay(long j4, TimeUnit timeUnit, x xVar) {
        xg.c.b(timeUnit, "unit is null");
        xg.c.b(xVar, "scheduler is null");
        return j3.d(this, new h3(SubsamplingScaleImageView.TILE_SIZE_AUTO, j4, timeUnit, xVar));
    }

    public final zg.a replay(x xVar) {
        xg.c.b(xVar, "scheduler is null");
        zg.a replay = replay();
        return new d3(replay, replay.observeOn(xVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> l<R> zip(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, q qVar6, q qVar7, q qVar8, vg.m mVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(qVar6, "source6 is null");
        xg.c.b(qVar7, "source7 is null");
        xg.c.b(qVar8, "source8 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public static <T> l<T> just(T t8, T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        xg.c.b(t8, "The first item is null");
        xg.c.b(t10, "The second item is null");
        xg.c.b(t11, "The third item is null");
        xg.c.b(t12, "The fourth item is null");
        xg.c.b(t13, "The fifth item is null");
        xg.c.b(t14, "The sixth item is null");
        xg.c.b(t15, "The seventh item is null");
        xg.c.b(t16, "The eighth item is null");
        xg.c.b(t17, "The ninth item is null");
        xg.c.b(t18, "The tenth item is null");
        return fromArray(t8, t10, t11, t12, t13, t14, t15, t16, t17, t18);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> l<R> combineLatest(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, q qVar6, q qVar7, q qVar8, q qVar9, vg.n nVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(qVar6, "source6 is null");
        xg.c.b(qVar7, "source7 is null");
        xg.c.b(qVar8, "source8 is null");
        xg.c.b(qVar9, "source9 is null");
        xg.c.b(null, "f is null");
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> l<R> zip(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, q qVar6, q qVar7, q qVar8, q qVar9, vg.n nVar) {
        xg.c.b(qVar, "source1 is null");
        xg.c.b(qVar2, "source2 is null");
        xg.c.b(qVar3, "source3 is null");
        xg.c.b(qVar4, "source4 is null");
        xg.c.b(qVar5, "source5 is null");
        xg.c.b(qVar6, "source6 is null");
        xg.c.b(qVar7, "source7 is null");
        xg.c.b(qVar8, "source8 is null");
        xg.c.b(qVar9, "source9 is null");
        xg.c.b(null, "f is null");
        throw null;
    }
}
