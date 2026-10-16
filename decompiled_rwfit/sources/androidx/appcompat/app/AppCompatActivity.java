package androidx.appcompat.app;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$style;
import androidx.appcompat.widget.m2;
import androidx.appcompat.widget.x3;
import androidx.appcompat.widget.z3;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.runtime.R$id;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import com.google.android.gms.internal.mlkit_vision_common.i6;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements m {

    /* renamed from: x, reason: collision with root package name */
    public c0 f399x;

    public AppCompatActivity() {
        this.e.f12443b.c("androidx:appcompat", new k(this));
        addOnContextAvailableListener(new l(this));
    }

    public final p E0() {
        if (this.f399x == null) {
            j0 j0Var = p.f530a;
            this.f399x = new c0(this, null, this, this);
        }
        return this.f399x;
    }

    public final void F0() {
        getWindow().getDecorView().setTag(R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.e.f(decorView, "<this>");
        decorView.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
        View decorView2 = getWindow().getDecorView();
        kotlin.jvm.internal.e.f(decorView2, "<this>");
        decorView2.setTag(androidx.activity.R$id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        F0();
        c0 c0Var = (c0) E0();
        c0Var.w();
        ((ViewGroup) c0Var.A.findViewById(R.id.content)).addView(view, layoutParams);
        c0Var.f434m.a(c0Var.f433l.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Configuration configuration;
        int i3 = 3;
        c0 c0Var = (c0) E0();
        c0Var.O = true;
        int i10 = c0Var.S;
        if (i10 == -100) {
            i10 = p.f531b;
        }
        int C = c0Var.C(context, i10);
        if (p.c(context) && p.c(context)) {
            if (!ic.b()) {
                synchronized (p.f537i) {
                    try {
                        h1.i iVar = p.f532c;
                        if (iVar == null) {
                            if (p.f533d == null) {
                                p.f533d = h1.i.a(aa.a.b(context));
                            }
                            if (!p.f533d.f14253a.f14254a.isEmpty()) {
                                p.f532c = p.f533d;
                            }
                        } else if (!iVar.equals(p.f533d)) {
                            h1.i iVar2 = p.f532c;
                            p.f533d = iVar2;
                            aa.a.a(context, iVar2.f14253a.f14254a.toLanguageTags());
                        }
                    } finally {
                    }
                }
            } else if (!p.f534f) {
                p.f530a.execute(new androidx.activity.b(context, i3));
            }
        }
        h1.i p8 = c0.p(context);
        if (c0.f423k0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(c0.t(context, C, p8, null, false));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof g.d) {
            try {
                ((g.d) context).a(c0.t(context, C, p8, null, false));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (c0.f422j0) {
            int i11 = Build.VERSION.SDK_INT;
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (configuration3.equals(configuration4)) {
                configuration = null;
            } else {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f2 = configuration3.fontScale;
                    float f10 = configuration4.fontScale;
                    if (f2 != f10) {
                        configuration.fontScale = f10;
                    }
                    int i12 = configuration3.mcc;
                    int i13 = configuration4.mcc;
                    if (i12 != i13) {
                        configuration.mcc = i13;
                    }
                    int i14 = configuration3.mnc;
                    int i15 = configuration4.mnc;
                    if (i14 != i15) {
                        configuration.mnc = i15;
                    }
                    u.a(configuration3, configuration4, configuration);
                    int i16 = configuration3.touchscreen;
                    int i17 = configuration4.touchscreen;
                    if (i16 != i17) {
                        configuration.touchscreen = i17;
                    }
                    int i18 = configuration3.keyboard;
                    int i19 = configuration4.keyboard;
                    if (i18 != i19) {
                        configuration.keyboard = i19;
                    }
                    int i20 = configuration3.keyboardHidden;
                    int i21 = configuration4.keyboardHidden;
                    if (i20 != i21) {
                        configuration.keyboardHidden = i21;
                    }
                    int i22 = configuration3.navigation;
                    int i23 = configuration4.navigation;
                    if (i22 != i23) {
                        configuration.navigation = i23;
                    }
                    int i24 = configuration3.navigationHidden;
                    int i25 = configuration4.navigationHidden;
                    if (i24 != i25) {
                        configuration.navigationHidden = i25;
                    }
                    int i26 = configuration3.orientation;
                    int i27 = configuration4.orientation;
                    if (i26 != i27) {
                        configuration.orientation = i27;
                    }
                    int i28 = configuration3.screenLayout & 15;
                    int i29 = configuration4.screenLayout & 15;
                    if (i28 != i29) {
                        configuration.screenLayout |= i29;
                    }
                    int i30 = configuration3.screenLayout & 192;
                    int i31 = configuration4.screenLayout & 192;
                    if (i30 != i31) {
                        configuration.screenLayout |= i31;
                    }
                    int i32 = configuration3.screenLayout & 48;
                    int i33 = configuration4.screenLayout & 48;
                    if (i32 != i33) {
                        configuration.screenLayout |= i33;
                    }
                    int i34 = configuration3.screenLayout & 768;
                    int i35 = configuration4.screenLayout & 768;
                    if (i34 != i35) {
                        configuration.screenLayout |= i35;
                    }
                    int i36 = configuration3.colorMode & 3;
                    int i37 = 3 & configuration4.colorMode;
                    if (i36 != i37) {
                        configuration.colorMode = i37 | configuration.colorMode;
                    }
                    int i38 = configuration3.colorMode & 12;
                    int i39 = configuration4.colorMode & 12;
                    if (i38 != i39) {
                        configuration.colorMode |= i39;
                    }
                    int i40 = configuration3.uiMode & 15;
                    int i41 = configuration4.uiMode & 15;
                    if (i40 != i41) {
                        configuration.uiMode |= i41;
                    }
                    int i42 = configuration3.uiMode & 48;
                    int i43 = configuration4.uiMode & 48;
                    if (i42 != i43) {
                        configuration.uiMode |= i43;
                    }
                    int i44 = configuration3.screenWidthDp;
                    int i45 = configuration4.screenWidthDp;
                    if (i44 != i45) {
                        configuration.screenWidthDp = i45;
                    }
                    int i46 = configuration3.screenHeightDp;
                    int i47 = configuration4.screenHeightDp;
                    if (i46 != i47) {
                        configuration.screenHeightDp = i47;
                    }
                    int i48 = configuration3.smallestScreenWidthDp;
                    int i49 = configuration4.smallestScreenWidthDp;
                    if (i48 != i49) {
                        configuration.smallestScreenWidthDp = i49;
                    }
                    int i50 = configuration3.densityDpi;
                    int i51 = configuration4.densityDpi;
                    if (i50 != i51) {
                        configuration.densityDpi = i51;
                    }
                }
            }
            Configuration t8 = c0.t(context, C, p8, configuration, true);
            g.d dVar = new g.d(context, R$style.Theme_AppCompat_Empty);
            dVar.a(t8);
            try {
                if (context.getTheme() != null) {
                    Resources.Theme theme = dVar.getTheme();
                    if (i11 >= 29) {
                        b1.n.a(theme);
                    } else {
                        synchronized (b1.b.e) {
                            if (!b1.b.f3056g) {
                                try {
                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                    b1.b.f3055f = declaredMethod;
                                    declaredMethod.setAccessible(true);
                                } catch (NoSuchMethodException e) {
                                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                                }
                                b1.b.f3056g = true;
                            }
                            Method method = b1.b.f3055f;
                            if (method != null) {
                                try {
                                    method.invoke(theme, null);
                                } catch (IllegalAccessException | InvocationTargetException e10) {
                                    Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e10);
                                    b1.b.f3055f = null;
                                }
                            }
                        }
                    }
                }
            } catch (NullPointerException unused3) {
            }
            context = dVar;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        ((c0) E0()).A();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((c0) E0()).A();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final View findViewById(int i3) {
        c0 c0Var = (c0) E0();
        c0Var.w();
        return c0Var.f433l.findViewById(i3);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        c0 c0Var = (c0) E0();
        if (c0Var.f437p == null) {
            c0Var.A();
            p0 p0Var = c0Var.f436o;
            c0Var.f437p = new g.i(p0Var != null ? p0Var.b() : c0Var.f432k);
        }
        return c0Var.f437p;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i3 = z3.f1131a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        E0().b();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c0 c0Var = (c0) E0();
        if (c0Var.F && c0Var.f446z) {
            c0Var.A();
            p0 p0Var = c0Var.f436o;
            if (p0Var != null) {
                p0Var.e(a8.c.d(p0Var.f540a).f123a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs));
            }
        }
        androidx.appcompat.widget.y a3 = androidx.appcompat.widget.y.a();
        Context context = c0Var.f432k;
        synchronized (a3) {
            m2 m2Var = a3.f1125a;
            synchronized (m2Var) {
                m0.e eVar = (m0.e) m2Var.f995b.get(context);
                if (eVar != null) {
                    eVar.a();
                }
            }
        }
        c0Var.R = new Configuration(c0Var.f432k.getResources().getConfiguration());
        c0Var.n(false, false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        E0().f();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        Intent a3;
        if (!super.onMenuItemSelected(i3, menuItem)) {
            c0 c0Var = (c0) E0();
            c0Var.A();
            p0 p0Var = c0Var.f436o;
            if (menuItem.getItemId() != 16908332 || p0Var == null || (((x3) p0Var.e).f1110b & 4) == 0 || (a3 = i6.a(this)) == null) {
                return false;
            }
            if (!y0.j.c(this, a3)) {
                y0.j.b(this, a3);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent a10 = i6.a(this);
            if (a10 == null) {
                a10 = i6.a(this);
            }
            if (a10 != null) {
                ComponentName component = a10.getComponent();
                if (component == null) {
                    component = a10.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent b3 = i6.b(this, component);
                    while (b3 != null) {
                        arrayList.add(size, b3);
                        b3 = i6.b(this, b3.getComponent());
                    }
                    arrayList.add(a10);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e);
                }
            }
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            a1.a.a(this, intentArr, null);
            try {
                y0.a.a(this);
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((c0) E0()).w();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        c0 c0Var = (c0) E0();
        c0Var.A();
        p0 p0Var = c0Var.f436o;
        if (p0Var != null) {
            p0Var.f557t = true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ((c0) E0()).n(true, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        c0 c0Var = (c0) E0();
        c0Var.A();
        p0 p0Var = c0Var.f436o;
        if (p0Var != null) {
            p0Var.f557t = false;
            g.j jVar = p0Var.f556s;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i3) {
        super.onTitleChanged(charSequence, i3);
        E0().m(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        ((c0) E0()).A();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int i3) {
        F0();
        E0().i(i3);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i3) {
        super.setTheme(i3);
        ((c0) E0()).T = i3;
    }

    @Override // androidx.core.app.ComponentActivity
    public final void z0() {
        E0().b();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        F0();
        E0().j(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        F0();
        E0().l(view, layoutParams);
    }
}
