package m9;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f15992c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public static a f15993d;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f15994a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f15995b;

    public a(Context context) {
        this.f15995b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public final String a(String str) {
        ReentrantLock reentrantLock = this.f15994a;
        reentrantLock.lock();
        try {
            return this.f15995b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
