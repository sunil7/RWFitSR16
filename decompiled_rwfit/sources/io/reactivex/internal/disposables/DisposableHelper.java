package io.reactivex.internal.disposables;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;
import ug.b;
import xg.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class DisposableHelper implements b {
    public static final DisposableHelper DISPOSED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisposableHelper[] f14438a;

    static {
        DisposableHelper disposableHelper = new DisposableHelper("DISPOSED", 0);
        DISPOSED = disposableHelper;
        f14438a = new DisposableHelper[]{disposableHelper};
    }

    public static boolean replace(AtomicReference<b> atomicReference, b bVar) {
        while (true) {
            b bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
            while (!atomicReference.compareAndSet(bVar2, bVar)) {
                if (atomicReference.get() != bVar2) {
                    break;
                }
            }
            return true;
        }
    }

    public static void reportDisposableSet() {
        a1.b(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<b> atomicReference, b bVar) {
        while (true) {
            b bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
            while (!atomicReference.compareAndSet(bVar2, bVar)) {
                if (atomicReference.get() != bVar2) {
                    break;
                }
            }
            if (bVar2 == null) {
                return true;
            }
            bVar2.dispose();
            return true;
        }
    }

    public static boolean setOnce(AtomicReference<b> atomicReference, b bVar) {
        c.b(bVar, "d is null");
        while (!atomicReference.compareAndSet(null, bVar)) {
            if (atomicReference.get() != null) {
                bVar.dispose();
                if (atomicReference.get() == DISPOSED) {
                    return false;
                }
                reportDisposableSet();
                return false;
            }
        }
        return true;
    }

    public static boolean trySet(AtomicReference<b> atomicReference, b bVar) {
        while (!atomicReference.compareAndSet(null, bVar)) {
            if (atomicReference.get() != null) {
                if (atomicReference.get() != DISPOSED) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        }
        return true;
    }

    public static boolean validate(b bVar, b bVar2) {
        if (bVar2 == null) {
            a1.b(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        reportDisposableSet();
        return false;
    }

    public static DisposableHelper valueOf(String str) {
        return (DisposableHelper) Enum.valueOf(DisposableHelper.class, str);
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[]) f14438a.clone();
    }

    @Override // ug.b
    public void dispose() {
    }

    @Override // ug.b
    public boolean isDisposed() {
        return true;
    }

    public static boolean dispose(AtomicReference<b> atomicReference) {
        b andSet;
        b bVar = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (bVar == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(b bVar) {
        return bVar == DISPOSED;
    }
}
