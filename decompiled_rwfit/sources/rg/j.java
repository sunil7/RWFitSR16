package rg;

import io.reactivex.internal.util.NotificationLite;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final j f18126b = new j(null);

    /* renamed from: a, reason: collision with root package name */
    public final Object f18127a;

    public j(Object obj) {
        this.f18127a = obj;
    }

    public final Throwable a() {
        Object obj = this.f18127a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public final boolean b() {
        Object obj = this.f18127a;
        return (obj == null || NotificationLite.isError(obj)) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return xg.c.a(this.f18127a, ((j) obj).f18127a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f18127a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        Object obj = this.f18127a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + obj + "]";
    }
}
