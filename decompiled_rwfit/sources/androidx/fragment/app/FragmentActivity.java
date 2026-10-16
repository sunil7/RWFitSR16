package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements y0.c {

    /* renamed from: u, reason: collision with root package name */
    public boolean f2092u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2093v;

    /* renamed from: s, reason: collision with root package name */
    public final s f2090s = new s(new b0(this), 4);

    /* renamed from: t, reason: collision with root package name */
    public final androidx.lifecycle.u f2091t = new androidx.lifecycle.u(this);

    /* renamed from: w, reason: collision with root package name */
    public boolean f2094w = true;

    public FragmentActivity() {
        this.e.f12443b.c("android:support:fragments", new z(this));
        addOnContextAvailableListener(new a0(this));
    }

    public static boolean D0(t0 t0Var, Lifecycle$State lifecycle$State) {
        boolean z5 = false;
        for (Fragment fragment : t0Var.f2272c.e()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z5 |= D0(fragment.getChildFragmentManager(), lifecycle$State);
                }
                l1 l1Var = fragment.mViewLifecycleOwner;
                if (l1Var != null) {
                    l1Var.b();
                    if (l1Var.f2220d.f2390b.isAtLeast(Lifecycle$State.STARTED)) {
                        androidx.lifecycle.u uVar = fragment.mViewLifecycleOwner.f2220d;
                        uVar.d("setCurrentState");
                        uVar.f(lifecycle$State);
                        z5 = true;
                    }
                }
                if (fragment.mLifecycleRegistry.f2390b.isAtLeast(Lifecycle$State.STARTED)) {
                    androidx.lifecycle.u uVar2 = fragment.mLifecycleRegistry;
                    uVar2.d("setCurrentState");
                    uVar2.f(lifecycle$State);
                    z5 = true;
                }
            }
        }
        return z5;
    }

    public final u0 C0() {
        return ((b0) this.f2090s.f2264b).f2184d;
    }

    @Override // android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f2092u);
        printWriter.print(" mResumed=");
        printWriter.print(this.f2093v);
        printWriter.print(" mStopped=");
        printWriter.print(this.f2094w);
        if (getApplication() != null) {
            m0.l lVar = ((x1.b) new de.o(getViewModelStore(), x1.b.f19733b).q(x1.b.class)).f19734a;
            if (lVar.f15923c > 0) {
                printWriter.print(str2);
                printWriter.println("Loaders:");
                if (lVar.f15923c > 0) {
                    if (lVar.f15922b[0] != null) {
                        throw new ClassCastException();
                    }
                    printWriter.print(str2);
                    printWriter.print("  #");
                    printWriter.print(lVar.f15921a[0]);
                    printWriter.print(": ");
                    throw null;
                }
            }
        }
        ((b0) this.f2090s.f2264b).f2184d.p(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i10, Intent intent) {
        this.f2090s.a();
        super.onActivityResult(i3, i10, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        s sVar = this.f2090s;
        sVar.a();
        super.onConfigurationChanged(configuration);
        for (Fragment fragment : ((b0) sVar.f2264b).f2184d.f2272c.e()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2091t.e(Lifecycle$Event.ON_CREATE);
        u0 u0Var = ((b0) this.f2090s.f2264b).f2184d;
        u0Var.f2293z = false;
        u0Var.A = false;
        u0Var.G.f2319f = false;
        u0Var.o(1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0) {
            super.onCreatePanelMenu(i3, menu);
            return true;
        }
        super.onCreatePanelMenu(i3, menu);
        ((b0) this.f2090s.f2264b).f2184d.i(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((b0) this.f2090s.f2264b).f2184d.f2274f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((b0) this.f2090s.f2264b).f2184d.j();
        this.f2091t.e(Lifecycle$Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        for (Fragment fragment : ((b0) this.f2090s.f2264b).f2184d.f2272c.e()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        s sVar = this.f2090s;
        if (i3 == 0) {
            return ((b0) sVar.f2264b).f2184d.k(menuItem);
        }
        if (i3 != 6) {
            return false;
        }
        return ((b0) sVar.f2264b).f2184d.h(menuItem);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onMultiWindowModeChanged(boolean z5) {
        for (Fragment fragment : ((b0) this.f2090s.f2264b).f2184d.f2272c.e()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z5);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        this.f2090s.a();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        if (i3 == 0) {
            ((b0) this.f2090s.f2264b).f2184d.l(menu);
        }
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f2093v = false;
        ((b0) this.f2090s.f2264b).f2184d.o(5);
        this.f2091t.e(Lifecycle$Event.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z5) {
        for (Fragment fragment : ((b0) this.f2090s.f2264b).f2184d.f2272c.e()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z5);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f2091t.e(Lifecycle$Event.ON_RESUME);
        u0 u0Var = ((b0) this.f2090s.f2264b).f2184d;
        u0Var.f2293z = false;
        u0Var.A = false;
        u0Var.G.f2319f = false;
        u0Var.o(7);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i3, View view, Menu menu) {
        if (i3 != 0) {
            super.onPreparePanel(i3, view, menu);
            return true;
        }
        super.onPreparePanel(0, view, menu);
        ((b0) this.f2090s.f2264b).f2184d.n(menu);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.f2090s.a();
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        s sVar = this.f2090s;
        sVar.a();
        super.onResume();
        this.f2093v = true;
        ((b0) sVar.f2264b).f2184d.s(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        s sVar = this.f2090s;
        sVar.a();
        super.onStart();
        this.f2094w = false;
        boolean z5 = this.f2092u;
        b0 b0Var = (b0) sVar.f2264b;
        if (!z5) {
            this.f2092u = true;
            u0 u0Var = b0Var.f2184d;
            u0Var.f2293z = false;
            u0Var.A = false;
            u0Var.G.f2319f = false;
            u0Var.o(4);
        }
        b0Var.f2184d.s(true);
        this.f2091t.e(Lifecycle$Event.ON_START);
        u0 u0Var2 = b0Var.f2184d;
        u0Var2.f2293z = false;
        u0Var2.A = false;
        u0Var2.G.f2319f = false;
        u0Var2.o(5);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.f2090s.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f2094w = true;
        while (D0(C0(), Lifecycle$State.CREATED)) {
        }
        u0 u0Var = ((b0) this.f2090s.f2264b).f2184d;
        u0Var.A = true;
        u0Var.G.f2319f = true;
        u0Var.o(4);
        this.f2091t.e(Lifecycle$Event.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((b0) this.f2090s.f2264b).f2184d.f2274f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }
}
