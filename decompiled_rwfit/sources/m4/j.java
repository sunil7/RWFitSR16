package m4;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.appcompat.app.t;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.t0;
import androidx.fragment.app.u0;
import com.example.test.ui.device.activity.f0;
import com.google.android.gms.internal.mlkit_common.o;
import g4.u;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class j implements Handler.Callback {

    /* renamed from: g, reason: collision with root package name */
    public static final ec.a f15957g = new ec.a(15);

    /* renamed from: a, reason: collision with root package name */
    public volatile com.bumptech.glide.j f15958a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f15959b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f15960c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Handler f15961d;
    public final ec.a e;

    /* renamed from: f, reason: collision with root package name */
    public final e f15962f;

    public j(t tVar) {
        new Bundle();
        this.e = f15957g;
        this.f15961d = new Handler(Looper.getMainLooper(), this);
        this.f15962f = (u.f13850h && u.f13849g) ? ((Map) tVar.f568b).containsKey(com.bumptech.glide.e.class) ? new d() : new eb.e(15) : new n9.e(14);
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final com.bumptech.glide.j b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = t4.l.f18523a;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return c((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!(Looper.myLooper() == Looper.getMainLooper())) {
                    return b(activity.getApplicationContext());
                }
                if (activity instanceof FragmentActivity) {
                    return c((FragmentActivity) activity);
                }
                if (activity.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                this.f15962f.getClass();
                FragmentManager fragmentManager = activity.getFragmentManager();
                Activity a3 = a(activity);
                boolean z5 = a3 == null || !a3.isFinishing();
                i d5 = d(fragmentManager);
                com.bumptech.glide.j jVar = d5.f15956d;
                if (jVar != null) {
                    return jVar;
                }
                com.bumptech.glide.b b3 = com.bumptech.glide.b.b(activity);
                f0 f0Var = d5.f15954b;
                this.e.getClass();
                com.bumptech.glide.j jVar2 = new com.bumptech.glide.j(b3, d5.f15953a, f0Var, activity);
                if (z5) {
                    jVar2.i();
                }
                d5.f15956d = jVar2;
                return jVar2;
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.f15958a == null) {
            synchronized (this) {
                try {
                    if (this.f15958a == null) {
                        com.bumptech.glide.b b10 = com.bumptech.glide.b.b(context.getApplicationContext());
                        ec.a aVar = this.e;
                        gc.b bVar = new gc.b(14);
                        o oVar = new o(15);
                        Context applicationContext = context.getApplicationContext();
                        aVar.getClass();
                        this.f15958a = new com.bumptech.glide.j(b10, bVar, oVar, applicationContext);
                    }
                } finally {
                }
            }
        }
        return this.f15958a;
    }

    public final com.bumptech.glide.j c(FragmentActivity fragmentActivity) {
        char[] cArr = t4.l.f18523a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return b(fragmentActivity.getApplicationContext());
        }
        if (fragmentActivity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.f15962f.getClass();
        u0 C0 = fragmentActivity.C0();
        Activity a3 = a(fragmentActivity);
        boolean z5 = a3 == null || !a3.isFinishing();
        l e = e(C0);
        com.bumptech.glide.j jVar = e.e;
        if (jVar != null) {
            return jVar;
        }
        com.bumptech.glide.b b3 = com.bumptech.glide.b.b(fragmentActivity);
        this.e.getClass();
        com.bumptech.glide.j jVar2 = new com.bumptech.glide.j(b3, e.f15963a, e.f15964b, fragmentActivity);
        if (z5) {
            jVar2.i();
        }
        e.e = jVar2;
        return jVar2;
    }

    public final i d(FragmentManager fragmentManager) {
        i iVar = (i) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (iVar != null) {
            return iVar;
        }
        HashMap hashMap = this.f15959b;
        i iVar2 = (i) hashMap.get(fragmentManager);
        if (iVar2 != null) {
            return iVar2;
        }
        i iVar3 = new i();
        hashMap.put(fragmentManager, iVar3);
        fragmentManager.beginTransaction().add(iVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f15961d.obtainMessage(1, fragmentManager).sendToTarget();
        return iVar3;
    }

    public final l e(t0 t0Var) {
        l lVar = (l) t0Var.w("com.bumptech.glide.manager");
        if (lVar != null) {
            return lVar;
        }
        HashMap hashMap = this.f15960c;
        l lVar2 = (l) hashMap.get(t0Var);
        if (lVar2 != null) {
            return lVar2;
        }
        l lVar3 = new l();
        hashMap.put(t0Var, lVar3);
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(t0Var);
        aVar.e(0, lVar3, "com.bumptech.glide.manager", 1);
        aVar.d(true);
        this.f15961d.obtainMessage(2, t0Var).sendToTarget();
        return lVar3;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        Object obj3;
        int i3 = message.what;
        boolean z5 = true;
        if (i3 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f15959b.remove(obj);
        } else {
            if (i3 != 2) {
                obj3 = null;
                z5 = false;
                obj2 = null;
                if (z5 && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z5;
            }
            obj = (t0) message.obj;
            remove = this.f15960c.remove(obj);
        }
        Object obj4 = remove;
        obj2 = obj;
        obj3 = obj4;
        if (z5) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z5;
    }
}
