package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReferenceArray;
import ug.b;

/* loaded from: classes2.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<b> implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i3) {
        super(i3);
    }

    @Override // ug.b
    public void dispose() {
        b andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i3 = 0; i3 < length; i3++) {
                b bVar = get(i3);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (bVar != disposableHelper && (andSet = getAndSet(i3, disposableHelper)) != disposableHelper && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public b replaceResource(int i3, b bVar) {
        b bVar2;
        do {
            bVar2 = get(i3);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return null;
            }
        } while (!compareAndSet(i3, bVar2, bVar));
        return bVar2;
    }

    public boolean setResource(int i3, b bVar) {
        b bVar2;
        do {
            bVar2 = get(i3);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return false;
            }
        } while (!compareAndSet(i3, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }
}
