package io.reactivex.internal.util;

import java.io.Serializable;
import rg.s;
import xg.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class NotificationLite {
    public static final NotificationLite COMPLETE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotificationLite[] f15119a;

    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: d, reason: collision with root package name */
        final ug.b f15120d;

        public DisposableNotification(ug.b bVar) {
            this.f15120d = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f15120d + "]";
        }
    }

    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;

        public ErrorNotification(Throwable th2) {
            this.e = th2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return c.a(this.e, ((ErrorNotification) obj).e);
            }
            return false;
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.e + "]";
        }
    }

    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;

        /* renamed from: s, reason: collision with root package name */
        final ci.c f15121s;

        public SubscriptionNotification(ci.c cVar) {
            this.f15121s = cVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f15121s + "]";
        }
    }

    static {
        NotificationLite notificationLite = new NotificationLite("COMPLETE", 0);
        COMPLETE = notificationLite;
        f15119a = new NotificationLite[]{notificationLite};
    }

    public static <T> boolean accept(Object obj, ci.b bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            bVar.onError(((ErrorNotification) obj).e);
            return true;
        }
        bVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, ci.b bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            bVar.onError(((ErrorNotification) obj).e);
            return true;
        }
        if (obj instanceof SubscriptionNotification) {
            bVar.onSubscribe(((SubscriptionNotification) obj).f15121s);
            return false;
        }
        bVar.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(ug.b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object error(Throwable th2) {
        return new ErrorNotification(th2);
    }

    public static ug.b getDisposable(Object obj) {
        return ((DisposableNotification) obj).f15120d;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).e;
    }

    public static ci.c getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).f15121s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t8) {
        return t8;
    }

    public static Object subscription(ci.c cVar) {
        return new SubscriptionNotification(cVar);
    }

    public static NotificationLite valueOf(String str) {
        return (NotificationLite) Enum.valueOf(NotificationLite.class, str);
    }

    public static NotificationLite[] values() {
        return (NotificationLite[]) f15119a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, s sVar) {
        if (obj == COMPLETE) {
            sVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            sVar.onError(((ErrorNotification) obj).e);
            return true;
        }
        sVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, s sVar) {
        if (obj == COMPLETE) {
            sVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            sVar.onError(((ErrorNotification) obj).e);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            sVar.onSubscribe(((DisposableNotification) obj).f15120d);
            return false;
        }
        sVar.onNext(obj);
        return false;
    }
}
