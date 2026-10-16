package m5;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.dh.keeplive.pix.OnePixActivity;
import ia.j;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15974a;

    /* renamed from: b, reason: collision with root package name */
    public int f15975b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15976c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15977d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public Object f15978f;

    /* renamed from: g, reason: collision with root package name */
    public Object f15979g;

    public /* synthetic */ c() {
        this.f15974a = 0;
    }

    private final void a(Activity activity, Bundle bundle) {
    }

    private final void b(Activity activity) {
    }

    private final void c(Activity activity, Bundle bundle) {
    }

    private final void d(Activity activity) {
    }

    public void e() {
        Context context;
        WeakReference weakReference = (WeakReference) this.f15979g;
        if (weakReference == null || (context = (Context) weakReference.get()) == null) {
            context = (Context) this.f15978f;
        }
        if (context == null || !this.e) {
            return;
        }
        if (this.f15975b == 0) {
            this.f15976c = false;
            Handler b3 = com.dh.keeplive.ext.a.b();
            if (this.f15977d) {
                b3.postDelayed(new b(this, context, this, 0), 1000L);
                return;
            } else {
                context.sendBroadcast(new Intent().setAction(com.dh.keeplive.a.e));
                return;
            }
        }
        if (this.f15976c) {
            return;
        }
        this.f15976c = true;
        Handler b10 = com.dh.keeplive.ext.a.b();
        if (this.f15977d) {
            b10.postDelayed(new b(this, context, this, 1), 1000L);
        } else {
            context.sendBroadcast(new Intent().setAction(com.dh.keeplive.a.f7203f));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        switch (this.f15974a) {
            case 0:
                e.f(activity, "activity");
                if (!(activity instanceof OnePixActivity)) {
                    this.f15979g = new WeakReference(activity);
                    break;
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        switch (this.f15974a) {
            case 0:
                e.f(activity, "activity");
                break;
            default:
                if (((Activity) this.f15979g) == activity) {
                    this.f15979g = null;
                    this.f15977d = true;
                    break;
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        switch (this.f15974a) {
            case 0:
                e.f(activity, "activity");
                break;
            default:
                if (this.f15977d && !this.e && !this.f15976c) {
                    Object obj = this.f15978f;
                    try {
                        Object obj2 = y0.e.f19865c.get(activity);
                        if (obj2 == obj && activity.hashCode() == this.f15975b) {
                            y0.e.f19868g.postAtFrontOfQueue(new j(y0.e.f19864b.get(activity), 26, obj2, false));
                            this.e = true;
                            this.f15978f = null;
                            break;
                        }
                    } catch (Throwable th2) {
                        Log.e("ActivityRecreator", "Exception while fetching field values", th2);
                    }
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.f15974a) {
            case 0:
                e.f(activity, "activity");
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        switch (this.f15974a) {
            case 0:
                e.f(activity, "activity");
                e.f(outState, "outState");
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        switch (this.f15974a) {
            case 0:
                e.f(activity, "activity");
                com.dh.keeplive.ext.a.d("onActivityStarted mFrontActivityCount " + this.f15975b);
                if (!(activity instanceof OnePixActivity)) {
                    this.f15975b++;
                    e();
                    break;
                }
                break;
            default:
                if (((Activity) this.f15979g) == activity) {
                    this.f15976c = true;
                    break;
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        switch (this.f15974a) {
            case 0:
                e.f(activity, "activity");
                com.dh.keeplive.ext.a.d("onActivityStopped mFrontActivityCount " + this.f15975b);
                if (!(activity instanceof OnePixActivity)) {
                    this.f15975b--;
                    e();
                    break;
                }
                break;
        }
    }

    public c(Activity activity) {
        this.f15974a = 1;
        this.f15976c = false;
        this.f15977d = false;
        this.e = false;
        this.f15979g = activity;
        this.f15975b = activity.hashCode();
    }
}
