package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.g0;
import androidx.lifecycle.i0;
import androidx.lifecycle.k0;
import androidx.lifecycle.m0;
import androidx.lifecycle.n0;
import androidx.lifecycle.p0;
import androidx.lifecycle.q;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import com.google.android.gms.internal.mlkit_vision_barcode.lc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements c.a, r0, androidx.lifecycle.j, e2.f, p, androidx.activity.result.g {
    public static final /* synthetic */ int r = 0;

    /* renamed from: b, reason: collision with root package name */
    public final c.b f331b = new c.b();

    /* renamed from: c, reason: collision with root package name */
    public final ef.i f332c = new ef.i(new b(this, 0));

    /* renamed from: d, reason: collision with root package name */
    public final u f333d;
    public final e2.e e;

    /* renamed from: f, reason: collision with root package name */
    public q0 f334f;

    /* renamed from: g, reason: collision with root package name */
    public k0 f335g;

    /* renamed from: h, reason: collision with root package name */
    public final o f336h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f337i;

    /* renamed from: j, reason: collision with root package name */
    public final g f338j;

    /* renamed from: k, reason: collision with root package name */
    public final CopyOnWriteArrayList f339k;

    /* renamed from: l, reason: collision with root package name */
    public final CopyOnWriteArrayList f340l;

    /* renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArrayList f341m;

    /* renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList f342n;

    /* renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList f343o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f344p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f345q;

    public ComponentActivity() {
        u uVar = new u(this);
        this.f333d = uVar;
        e2.e eVar = new e2.e(this);
        this.e = eVar;
        this.f336h = new o(new e(this, 0));
        this.f337i = new AtomicInteger();
        this.f338j = new g(this);
        this.f339k = new CopyOnWriteArrayList();
        this.f340l = new CopyOnWriteArrayList();
        this.f341m = new CopyOnWriteArrayList();
        this.f342n = new CopyOnWriteArrayList();
        this.f343o = new CopyOnWriteArrayList();
        this.f344p = false;
        this.f345q = false;
        uVar.a(new q() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.q
            public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
                if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        uVar.a(new q() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.q
            public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
                if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
                    ComponentActivity.this.f331b.f3278b = null;
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    HashMap hashMap = ComponentActivity.this.getViewModelStore().f2386a;
                    Iterator it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        ((m0) it.next()).clear();
                    }
                    hashMap.clear();
                }
            }
        });
        uVar.a(new q() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.q
            public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
                ComponentActivity componentActivity = ComponentActivity.this;
                if (componentActivity.f334f == null) {
                    i iVar = (i) componentActivity.getLastNonConfigurationInstance();
                    if (iVar != null) {
                        componentActivity.f334f = iVar.f366a;
                    }
                    if (componentActivity.f334f == null) {
                        componentActivity.f334f = new q0();
                    }
                }
                componentActivity.f333d.b(this);
            }
        });
        eVar.a();
        Lifecycle$State lifecycle$State = uVar.f2390b;
        kotlin.jvm.internal.e.e(lifecycle$State, "lifecycle.currentState");
        if (lifecycle$State != Lifecycle$State.INITIALIZED && lifecycle$State != Lifecycle$State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        e2.d dVar = eVar.f12443b;
        if (dVar.b() == null) {
            i0 i0Var = new i0(dVar, this);
            dVar.c("androidx.lifecycle.internal.SavedStateHandlesProvider", i0Var);
            uVar.a(new SavedStateHandleAttacher(i0Var));
        }
        dVar.c("android:support:activity-result", new c(this, 0));
        addOnContextAvailableListener(new c.c() { // from class: androidx.activity.d
            @Override // c.c
            public final void a() {
                ComponentActivity componentActivity = ComponentActivity.this;
                Bundle a3 = componentActivity.e.f12443b.a("android:support:activity-result");
                if (a3 != null) {
                    g gVar = componentActivity.f338j;
                    gVar.getClass();
                    ArrayList<Integer> integerArrayList = a3.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = a3.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    gVar.e = a3.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    gVar.f390a = (Random) a3.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                    Bundle bundle = a3.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    Bundle bundle2 = gVar.f396h;
                    bundle2.putAll(bundle);
                    for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                        String str = stringArrayList.get(i3);
                        HashMap hashMap = gVar.f392c;
                        boolean containsKey = hashMap.containsKey(str);
                        HashMap hashMap2 = gVar.f391b;
                        if (containsKey) {
                            Integer num = (Integer) hashMap.remove(str);
                            if (!bundle2.containsKey(str)) {
                                hashMap2.remove(num);
                            }
                        }
                        Integer num2 = integerArrayList.get(i3);
                        num2.intValue();
                        String str2 = stringArrayList.get(i3);
                        hashMap2.put(num2, str2);
                        hashMap.put(str2, num2);
                    }
                }
            }
        });
    }

    public final void B0() {
        getWindow().getDecorView().setTag(androidx.lifecycle.runtime.R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.e.f(decorView, "<this>");
        decorView.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
        View decorView2 = getWindow().getDecorView();
        kotlin.jvm.internal.e.f(decorView2, "<this>");
        decorView2.setTag(R$id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    @Override // androidx.activity.result.g
    public final androidx.activity.result.f Z() {
        return this.f338j;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        B0();
        super.addContentView(view, layoutParams);
    }

    @Override // c.a
    public final void addOnContextAvailableListener(c.c cVar) {
        this.f331b.addOnContextAvailableListener(cVar);
    }

    @Override // androidx.lifecycle.j
    public final w1.b getDefaultViewModelCreationExtras() {
        w1.c cVar = new w1.c(w1.a.f19463b);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = cVar.f19464a;
        if (application != null) {
            linkedHashMap.put(n0.f2381a, getApplication());
        }
        linkedHashMap.put(androidx.lifecycle.l.f2374a, this);
        linkedHashMap.put(androidx.lifecycle.l.f2375b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(androidx.lifecycle.l.f2376c, getIntent().getExtras());
        }
        return cVar;
    }

    @Override // androidx.lifecycle.j
    public final p0 getDefaultViewModelProviderFactory() {
        if (this.f335g == null) {
            this.f335g = new k0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.f335g;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.s
    public final androidx.lifecycle.n getLifecycle() {
        return this.f333d;
    }

    @Override // e2.f
    public final e2.d getSavedStateRegistry() {
        return this.e.f12443b;
    }

    @Override // androidx.lifecycle.r0
    public final q0 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f334f == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.f334f = iVar.f366a;
            }
            if (this.f334f == null) {
                this.f334f = new q0();
            }
        }
        return this.f334f;
    }

    @Override // androidx.activity.p
    public final o l() {
        return this.f336h;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i3, int i10, Intent intent) {
        if (this.f338j.a(i3, i10, intent)) {
            return;
        }
        super.onActivityResult(i3, i10, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f336h.b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.f339k.iterator();
        while (it.hasNext()) {
            ((k1.a) it.next()).f(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.e.b(bundle);
        c.b bVar = this.f331b;
        bVar.f3278b = this;
        Iterator it = bVar.f3277a.iterator();
        while (it.hasNext()) {
            ((c.c) it.next()).a();
        }
        super.onCreate(bundle);
        g0.c(this);
        if (ic.b()) {
            o oVar = this.f336h;
            oVar.e = h.a(this);
            oVar.c();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i3, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f332c.f12630c).iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        if (i3 != 0) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) this.f332c.f12630c).iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z5) {
        if (this.f344p) {
            return;
        }
        Iterator it = this.f342n.iterator();
        while (it.hasNext()) {
            ((k1.a) it.next()).f(new gc.b(24));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.f341m.iterator();
        while (it.hasNext()) {
            ((k1.a) it.next()).f(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        Iterator it = ((CopyOnWriteArrayList) this.f332c.f12630c).iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z5) {
        if (this.f345q) {
            return;
        }
        Iterator it = this.f343o.iterator();
        while (it.hasNext()) {
            ((k1.a) it.next()).f(new hc.a(24));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onPreparePanel(i3, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.f332c.f12630c).iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (this.f338j.a(i3, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        q0 q0Var = this.f334f;
        if (q0Var == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            q0Var = iVar.f366a;
        }
        if (q0Var == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f366a = q0Var;
        return iVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        u uVar = this.f333d;
        if (uVar != null) {
            Lifecycle$State lifecycle$State = Lifecycle$State.CREATED;
            uVar.d("setCurrentState");
            uVar.f(lifecycle$State);
        }
        super.onSaveInstanceState(bundle);
        this.e.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        Iterator it = this.f340l.iterator();
        while (it.hasNext()) {
            ((k1.a) it.next()).f(Integer.valueOf(i3));
        }
    }

    @Override // c.a
    public final void removeOnContextAvailableListener(c.c cVar) {
        this.f331b.removeOnContextAvailableListener(cVar);
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (lc.b()) {
                Trace.beginSection(lc.d("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            Trace.endSection();
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i3) {
        B0();
        super.setContentView(i3);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        B0();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        B0();
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z5, Configuration configuration) {
        this.f344p = true;
        try {
            super.onMultiWindowModeChanged(z5, configuration);
            this.f344p = false;
            Iterator it = this.f342n.iterator();
            while (it.hasNext()) {
                ((k1.a) it.next()).f(new gc.b(24));
            }
        } catch (Throwable th2) {
            this.f344p = false;
            throw th2;
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z5, Configuration configuration) {
        this.f345q = true;
        try {
            super.onPictureInPictureModeChanged(z5, configuration);
            this.f345q = false;
            Iterator it = this.f343o.iterator();
            while (it.hasNext()) {
                ((k1.a) it.next()).f(new hc.a(24));
            }
        } catch (Throwable th2) {
            this.f345q = false;
            throw th2;
        }
    }
}
