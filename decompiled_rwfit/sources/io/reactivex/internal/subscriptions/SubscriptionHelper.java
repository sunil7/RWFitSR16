package io.reactivex.internal.subscriptions;

import ci.c;
import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ed;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class SubscriptionHelper implements c {
    public static final SubscriptionHelper CANCELLED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubscriptionHelper[] f15114a;

    static {
        SubscriptionHelper subscriptionHelper = new SubscriptionHelper("CANCELLED", 0);
        CANCELLED = subscriptionHelper;
        f15114a = new SubscriptionHelper[]{subscriptionHelper};
    }

    public static void deferredRequest(AtomicReference<c> atomicReference, AtomicLong atomicLong, long j4) {
        c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.request(j4);
            return;
        }
        if (validate(j4)) {
            ed.a(atomicLong, j4);
            c cVar2 = atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    cVar2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<c> atomicReference, AtomicLong atomicLong, c cVar) {
        if (!setOnce(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        cVar.request(andSet);
        return true;
    }

    public static boolean isCancelled(c cVar) {
        return cVar == CANCELLED;
    }

    public static boolean replace(AtomicReference<c> atomicReference, c cVar) {
        while (true) {
            c cVar2 = atomicReference.get();
            if (cVar2 == CANCELLED) {
                if (cVar == null) {
                    return false;
                }
                cVar.cancel();
                return false;
            }
            while (!atomicReference.compareAndSet(cVar2, cVar)) {
                if (atomicReference.get() != cVar2) {
                    break;
                }
            }
            return true;
        }
    }

    public static void reportMoreProduced(long j4) {
        a1.b(new ProtocolViolationException(l0.l(j4, "More produced than requested: ")));
    }

    public static void reportSubscriptionSet() {
        a1.b(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<c> atomicReference, c cVar) {
        while (true) {
            c cVar2 = atomicReference.get();
            if (cVar2 == CANCELLED) {
                if (cVar == null) {
                    return false;
                }
                cVar.cancel();
                return false;
            }
            while (!atomicReference.compareAndSet(cVar2, cVar)) {
                if (atomicReference.get() != cVar2) {
                    break;
                }
            }
            if (cVar2 == null) {
                return true;
            }
            cVar2.cancel();
            return true;
        }
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c cVar) {
        xg.c.b(cVar, "s is null");
        while (!atomicReference.compareAndSet(null, cVar)) {
            if (atomicReference.get() != null) {
                cVar.cancel();
                if (atomicReference.get() == CANCELLED) {
                    return false;
                }
                reportSubscriptionSet();
                return false;
            }
        }
        return true;
    }

    public static boolean validate(c cVar, c cVar2) {
        if (cVar2 == null) {
            a1.b(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.cancel();
        reportSubscriptionSet();
        return false;
    }

    public static SubscriptionHelper valueOf(String str) {
        return (SubscriptionHelper) Enum.valueOf(SubscriptionHelper.class, str);
    }

    public static SubscriptionHelper[] values() {
        return (SubscriptionHelper[]) f15114a.clone();
    }

    @Override // ci.c
    public void cancel() {
    }

    @Override // ci.c
    public void request(long j4) {
    }

    public static boolean cancel(AtomicReference<c> atomicReference) {
        c andSet;
        c cVar = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (cVar == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean validate(long j4) {
        if (j4 > 0) {
            return true;
        }
        a1.b(new IllegalArgumentException(l0.l(j4, "n > 0 required but it was ")));
        return false;
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c cVar, long j4) {
        if (!setOnce(atomicReference, cVar)) {
            return false;
        }
        cVar.request(j4);
        return true;
    }
}
