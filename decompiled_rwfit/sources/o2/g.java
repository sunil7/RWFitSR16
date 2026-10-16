package o2;

import android.app.Notification;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f16712a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16713b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f16714c;

    public g(int i3, Notification notification, int i10) {
        this.f16712a = i3;
        this.f16714c = notification;
        this.f16713b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f16712a == gVar.f16712a && this.f16713b == gVar.f16713b) {
            return this.f16714c.equals(gVar.f16714c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f16714c.hashCode() + (((this.f16712a * 31) + this.f16713b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f16712a + ", mForegroundServiceType=" + this.f16713b + ", mNotification=" + this.f16714c + '}';
    }
}
