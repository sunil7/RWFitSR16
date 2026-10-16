package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b4;
import androidx.appcompat.widget.j1;
import androidx.appcompat.widget.k1;
import androidx.appcompat.widget.r3;
import androidx.appcompat.widget.x3;
import com.google.android.gms.internal.mlkit_vision_common.i6;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import l1.g1;
import l1.z0;

/* loaded from: classes.dex */
public final class c0 extends p implements h.i, LayoutInflater.Factory2 {

    /* renamed from: h0, reason: collision with root package name */
    public static final m0.k f421h0 = new m0.k();
    public static final int[] i0 = {R.attr.windowBackground};

    /* renamed from: j0, reason: collision with root package name */
    public static final boolean f422j0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: k0, reason: collision with root package name */
    public static final boolean f423k0 = true;
    public ViewGroup A;
    public TextView B;
    public View C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public b0[] L;
    public b0 M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public Configuration R;
    public final int S;
    public int T;
    public int U;
    public boolean V;
    public x W;
    public x X;
    public boolean Y;
    public int Z;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f425b0;

    /* renamed from: c0, reason: collision with root package name */
    public Rect f426c0;

    /* renamed from: d0, reason: collision with root package name */
    public Rect f427d0;

    /* renamed from: e0, reason: collision with root package name */
    public g0 f428e0;

    /* renamed from: f0, reason: collision with root package name */
    public OnBackInvokedDispatcher f429f0;

    /* renamed from: g0, reason: collision with root package name */
    public OnBackInvokedCallback f430g0;

    /* renamed from: j, reason: collision with root package name */
    public final Object f431j;

    /* renamed from: k, reason: collision with root package name */
    public final Context f432k;

    /* renamed from: l, reason: collision with root package name */
    public Window f433l;

    /* renamed from: m, reason: collision with root package name */
    public w f434m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f435n;

    /* renamed from: o, reason: collision with root package name */
    public p0 f436o;

    /* renamed from: p, reason: collision with root package name */
    public g.i f437p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f438q;
    public j1 r;

    /* renamed from: s, reason: collision with root package name */
    public t f439s;

    /* renamed from: t, reason: collision with root package name */
    public r f440t;

    /* renamed from: u, reason: collision with root package name */
    public g.a f441u;

    /* renamed from: v, reason: collision with root package name */
    public ActionBarContextView f442v;

    /* renamed from: w, reason: collision with root package name */
    public PopupWindow f443w;

    /* renamed from: x, reason: collision with root package name */
    public q f444x;

    /* renamed from: z, reason: collision with root package name */
    public boolean f446z;

    /* renamed from: y, reason: collision with root package name */
    public g1 f445y = null;

    /* renamed from: a0, reason: collision with root package name */
    public final q f424a0 = new q(this, 0);

    public c0(Context context, Window window, m mVar, Object obj) {
        AppCompatActivity appCompatActivity;
        this.S = -100;
        this.f432k = context;
        this.f435n = mVar;
        this.f431j = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof AppCompatActivity)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    appCompatActivity = (AppCompatActivity) context;
                    break;
                }
            }
            appCompatActivity = null;
            if (appCompatActivity != null) {
                this.S = ((c0) appCompatActivity.E0()).S;
            }
        }
        if (this.S == -100) {
            m0.k kVar = f421h0;
            Integer num = (Integer) kVar.getOrDefault(this.f431j.getClass().getName(), null);
            if (num != null) {
                this.S = num.intValue();
                kVar.remove(this.f431j.getClass().getName());
            }
        }
        if (window != null) {
            o(window);
        }
        androidx.appcompat.widget.y.d();
    }

    public static h1.i p(Context context) {
        h1.i iVar;
        h1.i iVar2;
        if (Build.VERSION.SDK_INT >= 33 || (iVar = p.f532c) == null) {
            return null;
        }
        h1.i b3 = u.b(context.getApplicationContext().getResources().getConfiguration());
        h1.j jVar = iVar.f14253a;
        if (jVar.f14254a.isEmpty()) {
            iVar2 = h1.i.f14252b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i3 = 0;
            while (i3 < b3.b() + iVar.b()) {
                Locale locale = i3 < iVar.b() ? jVar.f14254a.get(i3) : b3.f14253a.f14254a.get(i3 - iVar.b());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i3++;
            }
            iVar2 = new h1.i(new h1.j(h1.h.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return iVar2.f14253a.f14254a.isEmpty() ? b3 : iVar2;
    }

    public static Configuration t(Context context, int i3, h1.i iVar, Configuration configuration, boolean z5) {
        int i10 = i3 != 1 ? i3 != 2 ? z5 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i10 | (configuration2.uiMode & (-49));
        if (iVar != null) {
            u.d(configuration2, iVar);
        }
        return configuration2;
    }

    public final void A() {
        w();
        if (this.F && this.f436o == null) {
            Object obj = this.f431j;
            if (obj instanceof Activity) {
                this.f436o = new p0((Activity) obj, this.G);
            } else if (obj instanceof Dialog) {
                this.f436o = new p0((Dialog) obj);
            }
            p0 p0Var = this.f436o;
            if (p0Var != null) {
                p0Var.d(this.f425b0);
            }
        }
    }

    public final void B(int i3) {
        this.Z = (1 << i3) | this.Z;
        if (this.Y) {
            return;
        }
        View decorView = this.f433l.getDecorView();
        q qVar = this.f424a0;
        WeakHashMap weakHashMap = z0.f15748a;
        l1.h0.m(decorView, qVar);
        this.Y = true;
    }

    public final int C(Context context, int i3) {
        if (i3 != -100) {
            if (i3 != -1) {
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.X == null) {
                            this.X = new x(this, context);
                        }
                        return this.X.x();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return y(context).x();
                }
            }
            return i3;
        }
        return -1;
    }

    public final boolean D() {
        k1 k1Var;
        r3 r3Var;
        boolean z5 = this.N;
        this.N = false;
        b0 z6 = z(0);
        if (!z6.f415m) {
            g.a aVar = this.f441u;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            A();
            p0 p0Var = this.f436o;
            if (p0Var == null || (k1Var = p0Var.e) == null || (r3Var = ((x3) k1Var).f1109a.L) == null || r3Var.f1037b == null) {
                return false;
            }
            r3 r3Var2 = ((x3) k1Var).f1109a.L;
            h.m mVar = r3Var2 == null ? null : r3Var2.f1037b;
            if (mVar != null) {
                mVar.collapseActionView();
            }
        } else if (!z5) {
            s(z6, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0175, code lost:
    
        if (r3.f14137g.getCount() > 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0155, code lost:
    
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(androidx.appcompat.app.b0 r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c0.E(androidx.appcompat.app.b0, android.view.KeyEvent):void");
    }

    public final boolean F(b0 b0Var, int i3, KeyEvent keyEvent) {
        h.k kVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((b0Var.f413k || G(b0Var, keyEvent)) && (kVar = b0Var.f410h) != null) {
            return kVar.performShortcut(i3, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cd, code lost:
    
        if (r12.f410h == null) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean G(androidx.appcompat.app.b0 r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c0.G(androidx.appcompat.app.b0, android.view.KeyEvent):boolean");
    }

    public final void H() {
        if (this.f446z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void I() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z5 = false;
            if (this.f429f0 != null && (z(0).f415m || this.f441u != null)) {
                z5 = true;
            }
            if (z5 && this.f430g0 == null) {
                this.f430g0 = v.b(this.f429f0, this);
            } else {
                if (z5 || (onBackInvokedCallback = this.f430g0) == null) {
                    return;
                }
                v.c(this.f429f0, onBackInvokedCallback);
            }
        }
    }

    @Override // androidx.appcompat.app.p
    public final void a() {
        LayoutInflater from = LayoutInflater.from(this.f432k);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            if (from.getFactory2() instanceof c0) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.p
    public final void b() {
        if (this.f436o != null) {
            A();
            this.f436o.getClass();
            B(0);
        }
    }

    @Override // h.i
    public final boolean d(h.k kVar, MenuItem menuItem) {
        b0 b0Var;
        Window.Callback callback = this.f433l.getCallback();
        if (callback != null && !this.Q) {
            h.k k10 = kVar.k();
            b0[] b0VarArr = this.L;
            int length = b0VarArr != null ? b0VarArr.length : 0;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    b0Var = b0VarArr[i3];
                    if (b0Var != null && b0Var.f410h == k10) {
                        break;
                    }
                    i3++;
                } else {
                    b0Var = null;
                    break;
                }
            }
            if (b0Var != null) {
                return callback.onMenuItemSelected(b0Var.f404a, menuItem);
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.p
    public final void e() {
        String str;
        this.O = true;
        n(false, true);
        x();
        Object obj = this.f431j;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = i6.c(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                p0 p0Var = this.f436o;
                if (p0Var == null) {
                    this.f425b0 = true;
                } else {
                    p0Var.d(true);
                }
            }
            synchronized (p.f536h) {
                p.g(this);
                p.f535g.add(new WeakReference(this));
            }
        }
        this.R = new Configuration(this.f432k.getResources().getConfiguration());
        this.P = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.app.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f431j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = androidx.appcompat.app.p.f536h
            monitor-enter(r0)
            androidx.appcompat.app.p.g(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.Y
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f433l
            android.view.View r0 = r0.getDecorView()
            androidx.appcompat.app.q r1 = r3.f424a0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.Q = r0
            int r0 = r3.S
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f431j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            m0.k r0 = androidx.appcompat.app.c0.f421h0
            java.lang.Object r1 = r3.f431j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.S
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            m0.k r0 = androidx.appcompat.app.c0.f421h0
            java.lang.Object r1 = r3.f431j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            androidx.appcompat.app.x r0 = r3.W
            if (r0 == 0) goto L63
            r0.v()
        L63:
            androidx.appcompat.app.x r0 = r3.X
            if (r0 == 0) goto L6a
            r0.v()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c0.f():void");
    }

    @Override // androidx.appcompat.app.p
    public final boolean h(int i3) {
        if (i3 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i3 = 108;
        } else if (i3 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i3 = 109;
        }
        if (this.J && i3 == 108) {
            return false;
        }
        if (this.F && i3 == 1) {
            this.F = false;
        }
        if (i3 == 1) {
            H();
            this.J = true;
            return true;
        }
        if (i3 == 2) {
            H();
            this.D = true;
            return true;
        }
        if (i3 == 5) {
            H();
            this.E = true;
            return true;
        }
        if (i3 == 10) {
            H();
            this.H = true;
            return true;
        }
        if (i3 == 108) {
            H();
            this.F = true;
            return true;
        }
        if (i3 != 109) {
            return this.f433l.requestFeature(i3);
        }
        H();
        this.G = true;
        return true;
    }

    @Override // androidx.appcompat.app.p
    public final void i(int i3) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f432k).inflate(i3, viewGroup);
        this.f434m.a(this.f433l.getCallback());
    }

    @Override // androidx.appcompat.app.p
    public final void j(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f434m.a(this.f433l.getCallback());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r6.f() != false) goto L20;
     */
    @Override // h.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(h.k r6) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c0.k(h.k):void");
    }

    @Override // androidx.appcompat.app.p
    public final void l(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f434m.a(this.f433l.getCallback());
    }

    @Override // androidx.appcompat.app.p
    public final void m(CharSequence charSequence) {
        this.f438q = charSequence;
        j1 j1Var = this.r;
        if (j1Var != null) {
            j1Var.setWindowTitle(charSequence);
            return;
        }
        p0 p0Var = this.f436o;
        if (p0Var == null) {
            TextView textView = this.B;
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        x3 x3Var = (x3) p0Var.e;
        if (x3Var.f1114g) {
            return;
        }
        x3Var.f1115h = charSequence;
        if ((x3Var.f1110b & 8) != 0) {
            Toolbar toolbar = x3Var.f1109a;
            toolbar.setTitle(charSequence);
            if (x3Var.f1114g) {
                z0.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0162 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(boolean r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c0.n(boolean, boolean):boolean");
    }

    public final void o(Window window) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        if (this.f433l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof w) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        w wVar = new w(this, callback);
        this.f434m = wVar;
        window.setCallback(wVar);
        de.o H = de.o.H(this.f432k, null, i0);
        Drawable x10 = H.x(0);
        if (x10 != null) {
            window.setBackgroundDrawable(x10);
        }
        H.K();
        this.f433l = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.f429f0) != null) {
            return;
        }
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f430g0) != null) {
            v.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f430g0 = null;
        }
        Object obj = this.f431j;
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.f429f0 = v.a(activity);
                I();
            }
        }
        this.f429f0 = null;
        I();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e5  */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r12, java.lang.String r13, android.content.Context r14, android.util.AttributeSet r15) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void q(int i3, b0 b0Var, h.k kVar) {
        if (kVar == null) {
            if (b0Var == null && i3 >= 0) {
                b0[] b0VarArr = this.L;
                if (i3 < b0VarArr.length) {
                    b0Var = b0VarArr[i3];
                }
            }
            if (b0Var != null) {
                kVar = b0Var.f410h;
            }
        }
        if ((b0Var == null || b0Var.f415m) && !this.Q) {
            w wVar = this.f434m;
            Window.Callback callback = this.f433l.getCallback();
            wVar.getClass();
            try {
                wVar.f572d = true;
                callback.onPanelClosed(i3, kVar);
            } finally {
                wVar.f572d = false;
            }
        }
    }

    public final void r(h.k kVar) {
        androidx.appcompat.widget.l lVar;
        if (this.K) {
            return;
        }
        this.K = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.r;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((x3) actionBarOverlayLayout.e).f1109a.f836a;
        if (actionMenuView != null && (lVar = actionMenuView.f660t) != null) {
            lVar.d();
            androidx.appcompat.widget.f fVar = lVar.f971u;
            if (fVar != null && fVar.b()) {
                fVar.f14212i.dismiss();
            }
        }
        Window.Callback callback = this.f433l.getCallback();
        if (callback != null && !this.Q) {
            callback.onPanelClosed(108, kVar);
        }
        this.K = false;
    }

    public final void s(b0 b0Var, boolean z5) {
        z zVar;
        j1 j1Var;
        androidx.appcompat.widget.l lVar;
        if (z5 && b0Var.f404a == 0 && (j1Var = this.r) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) j1Var;
            actionBarOverlayLayout.k();
            ActionMenuView actionMenuView = ((x3) actionBarOverlayLayout.e).f1109a.f836a;
            if (actionMenuView != null && (lVar = actionMenuView.f660t) != null && lVar.f()) {
                r(b0Var.f410h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f432k.getSystemService("window");
        if (windowManager != null && b0Var.f415m && (zVar = b0Var.e) != null) {
            windowManager.removeView(zVar);
            if (z5) {
                q(b0Var.f404a, b0Var, null);
            }
        }
        b0Var.f413k = false;
        b0Var.f414l = false;
        b0Var.f415m = false;
        b0Var.f408f = null;
        b0Var.f416n = true;
        if (this.M == b0Var) {
            this.M = null;
        }
        if (b0Var.f404a == 0) {
            I();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r4.dispatchKeyEvent(r7) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dc, code lost:
    
        if (r7.d() != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0102, code lost:
    
        if (r7.n() != false) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean u(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c0.u(android.view.KeyEvent):boolean");
    }

    public final void v(int i3) {
        b0 z5 = z(i3);
        if (z5.f410h != null) {
            Bundle bundle = new Bundle();
            z5.f410h.u(bundle);
            if (bundle.size() > 0) {
                z5.f418p = bundle;
            }
            z5.f410h.y();
            z5.f410h.clear();
        }
        z5.f417o = true;
        z5.f416n = true;
        if ((i3 == 108 || i3 == 0) && this.r != null) {
            b0 z6 = z(0);
            z6.f413k = false;
            G(z6, null);
        }
    }

    public final void w() {
        ViewGroup viewGroup;
        int i3 = 1;
        if (this.f446z) {
            return;
        }
        int[] iArr = R$styleable.AppCompatTheme;
        Context context = this.f432k;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            h(1);
        } else if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
            h(108);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            h(109);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            h(10);
        }
        this.I = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        x();
        this.f433l.getDecorView();
        LayoutInflater from = LayoutInflater.from(context);
        if (this.J) {
            viewGroup = this.H ? (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.I) {
            viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.G = false;
            this.F = false;
        } else if (this.F) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new g.d(context, typedValue.resourceId) : context).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            j1 j1Var = (j1) viewGroup.findViewById(R$id.decor_content_parent);
            this.r = j1Var;
            j1Var.setWindowCallback(this.f433l.getCallback());
            if (this.G) {
                ((ActionBarOverlayLayout) this.r).h(109);
            }
            if (this.D) {
                ((ActionBarOverlayLayout) this.r).h(2);
            }
            if (this.E) {
                ((ActionBarOverlayLayout) this.r).h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.F + ", windowActionBarOverlay: " + this.G + ", android:windowIsFloating: " + this.I + ", windowActionModeOverlay: " + this.H + ", windowNoTitle: " + this.J + " }");
        }
        r rVar = new r(this);
        WeakHashMap weakHashMap = z0.f15748a;
        l1.n0.u(viewGroup, rVar);
        if (this.r == null) {
            this.B = (TextView) viewGroup.findViewById(R$id.title);
        }
        Method method = b4.f875a;
        try {
            Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method2.isAccessible()) {
                method2.setAccessible(true);
            }
            method2.invoke(viewGroup, null);
        } catch (IllegalAccessException e) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f433l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f433l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new y2.f(this, i3));
        this.A = viewGroup;
        Object obj = this.f431j;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f438q;
        if (!TextUtils.isEmpty(title)) {
            j1 j1Var2 = this.r;
            if (j1Var2 != null) {
                j1Var2.setWindowTitle(title);
            } else {
                p0 p0Var = this.f436o;
                if (p0Var != null) {
                    x3 x3Var = (x3) p0Var.e;
                    if (!x3Var.f1114g) {
                        x3Var.f1115h = title;
                        if ((x3Var.f1110b & 8) != 0) {
                            Toolbar toolbar = x3Var.f1109a;
                            toolbar.setTitle(title);
                            if (x3Var.f1114g) {
                                z0.o(toolbar.getRootView(), title);
                            }
                        }
                    }
                } else {
                    TextView textView = this.B;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.A.findViewById(R.id.content);
        View decorView = this.f433l.getDecorView();
        contentFrameLayout2.f740g.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        WeakHashMap weakHashMap2 = z0.f15748a;
        if (l1.k0.c(contentFrameLayout2)) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
        obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
        if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
        }
        if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
        }
        if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
        }
        if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
        }
        obtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.f446z = true;
        b0 z5 = z(0);
        if (this.Q || z5.f410h != null) {
            return;
        }
        B(108);
    }

    public final void x() {
        if (this.f433l == null) {
            Object obj = this.f431j;
            if (obj instanceof Activity) {
                o(((Activity) obj).getWindow());
            }
        }
        if (this.f433l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final a2.h y(Context context) {
        if (this.W == null) {
            if (de.o.e == null) {
                Context applicationContext = context.getApplicationContext();
                de.o.e = new de.o(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.W = new x(this, de.o.e);
        }
        return this.W;
    }

    public final b0 z(int i3) {
        b0[] b0VarArr = this.L;
        if (b0VarArr == null || b0VarArr.length <= i3) {
            b0[] b0VarArr2 = new b0[i3 + 1];
            if (b0VarArr != null) {
                System.arraycopy(b0VarArr, 0, b0VarArr2, 0, b0VarArr.length);
            }
            this.L = b0VarArr2;
            b0VarArr = b0VarArr2;
        }
        b0 b0Var = b0VarArr[i3];
        if (b0Var != null) {
            return b0Var;
        }
        b0 b0Var2 = new b0();
        b0Var2.f404a = i3;
        b0Var2.f416n = false;
        b0VarArr[i3] = b0Var2;
        return b0Var2;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
