package androidx.camera.lifecycle;

import android.annotation.SuppressLint;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t.m;

@SuppressLint({"UsesNonDefaultVisibleForTesting"})
/* loaded from: classes.dex */
public final class LifecycleCamera implements r, m {

    /* renamed from: b, reason: collision with root package name */
    public final ComponentActivity f1545b;

    /* renamed from: c, reason: collision with root package name */
    public final y.e f1546c;

    /* renamed from: a, reason: collision with root package name */
    public final Object f1544a = new Object();

    /* renamed from: d, reason: collision with root package name */
    public boolean f1547d = false;

    public LifecycleCamera(ComponentActivity componentActivity, y.e eVar) {
        this.f1545b = componentActivity;
        this.f1546c = eVar;
        u uVar = componentActivity.f333d;
        if (uVar.f2390b.isAtLeast(Lifecycle$State.STARTED)) {
            eVar.i();
        } else {
            eVar.r();
        }
        uVar.a(this);
    }

    @Override // t.m
    public final androidx.camera.core.impl.u getCameraInfo() {
        return this.f1546c.f19853q;
    }

    public final List i() {
        List unmodifiableList;
        synchronized (this.f1544a) {
            unmodifiableList = Collections.unmodifiableList(this.f1546c.v());
        }
        return unmodifiableList;
    }

    public final void j() {
        synchronized (this.f1544a) {
            try {
                if (this.f1547d) {
                    return;
                }
                onStop(this.f1545b);
                this.f1547d = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void k() {
        synchronized (this.f1544a) {
            try {
                if (this.f1547d) {
                    this.f1547d = false;
                    if (this.f1545b.f333d.f2390b.isAtLeast(Lifecycle$State.STARTED)) {
                        onStart(this.f1545b);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @d0(Lifecycle$Event.ON_DESTROY)
    public void onDestroy(s sVar) {
        synchronized (this.f1544a) {
            y.e eVar = this.f1546c;
            eVar.y((ArrayList) eVar.v());
        }
    }

    @d0(Lifecycle$Event.ON_PAUSE)
    public void onPause(s sVar) {
        this.f1546c.f19838a.a(false);
    }

    @d0(Lifecycle$Event.ON_RESUME)
    public void onResume(s sVar) {
        this.f1546c.f19838a.a(true);
    }

    @d0(Lifecycle$Event.ON_START)
    public void onStart(s sVar) {
        synchronized (this.f1544a) {
            try {
                if (!this.f1547d) {
                    this.f1546c.i();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @d0(Lifecycle$Event.ON_STOP)
    public void onStop(s sVar) {
        synchronized (this.f1544a) {
            try {
                if (!this.f1547d) {
                    this.f1546c.r();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
