package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.t;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import g9.e;
import g9.g;
import g9.h;
import g9.i;
import g9.j;
import g9.j0;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class PlayerControlView extends FrameLayout {

    /* renamed from: d0, reason: collision with root package name */
    public static final /* synthetic */ int f8929d0 = 0;
    public final Drawable A;
    public final Drawable B;
    public final float C;
    public final float D;
    public final String E;
    public final String F;
    public c G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public long T;
    public long[] U;
    public boolean[] V;
    public final long[] W;

    /* renamed from: a, reason: collision with root package name */
    public final g f8930a;

    /* renamed from: a0, reason: collision with root package name */
    public final boolean[] f8931a0;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f8932b;

    /* renamed from: b0, reason: collision with root package name */
    public long f8933b0;

    /* renamed from: c, reason: collision with root package name */
    public final View f8934c;

    /* renamed from: c0, reason: collision with root package name */
    public long f8935c0;

    /* renamed from: d, reason: collision with root package name */
    public final View f8936d;
    public final View e;

    /* renamed from: f, reason: collision with root package name */
    public final View f8937f;

    /* renamed from: g, reason: collision with root package name */
    public final View f8938g;

    /* renamed from: h, reason: collision with root package name */
    public final View f8939h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f8940i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f8941j;

    /* renamed from: k, reason: collision with root package name */
    public final View f8942k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f8943l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f8944m;

    /* renamed from: n, reason: collision with root package name */
    public final j0 f8945n;

    /* renamed from: o, reason: collision with root package name */
    public final StringBuilder f8946o;

    /* renamed from: p, reason: collision with root package name */
    public final Formatter f8947p;

    /* renamed from: q, reason: collision with root package name */
    public final s f8948q;
    public final t r;

    /* renamed from: s, reason: collision with root package name */
    public final e f8949s;

    /* renamed from: t, reason: collision with root package name */
    public final e f8950t;

    /* renamed from: u, reason: collision with root package name */
    public final Drawable f8951u;

    /* renamed from: v, reason: collision with root package name */
    public final Drawable f8952v;

    /* renamed from: w, reason: collision with root package name */
    public final Drawable f8953w;

    /* renamed from: x, reason: collision with root package name */
    public final String f8954x;

    /* renamed from: y, reason: collision with root package name */
    public final String f8955y;

    /* renamed from: z, reason: collision with root package name */
    public final String f8956z;

    static {
        f.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public final boolean a(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        return false;
    }

    public final void b(p pVar) {
        int i3 = pVar.i();
        if (i3 == 1) {
            ((d) this.G).getClass();
            pVar.n();
        } else if (i3 == 4) {
            int D = pVar.D();
            ((d) this.G).getClass();
            pVar.f(D, -9223372036854775807L);
        }
        ((d) this.G).getClass();
        pVar.a(true);
    }

    public final void c() {
        if (e()) {
            setVisibility(8);
            Iterator it = this.f8932b.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                getVisibility();
                j jVar = (j) iVar;
                jVar.getClass();
                jVar.f13975a.h();
            }
            removeCallbacks(this.f8949s);
            removeCallbacks(this.f8950t);
            this.T = -9223372036854775807L;
        }
    }

    public final void d() {
        e eVar = this.f8950t;
        removeCallbacks(eVar);
        if (this.L <= 0) {
            this.T = -9223372036854775807L;
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j4 = this.L;
        this.T = uptimeMillis + j4;
        if (this.H) {
            postDelayed(eVar, j4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f8950t);
        } else if (motionEvent.getAction() == 1) {
            d();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean e() {
        return getVisibility() == 0;
    }

    public final boolean f() {
        return false;
    }

    public final void g(boolean z5, boolean z6, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z6);
        view.setAlpha(z6 ? this.C : this.D);
        view.setVisibility(z5 ? 0 : 8);
    }

    public p getPlayer() {
        return null;
    }

    public int getRepeatToggleModes() {
        return this.N;
    }

    public boolean getShowShuffleButton() {
        return this.S;
    }

    public int getShowTimeoutMs() {
        return this.L;
    }

    public boolean getShowVrButton() {
        View view = this.f8942k;
        return view != null && view.getVisibility() == 0;
    }

    public final void h() {
        if (e() && this.H) {
            g(this.Q, false, this.f8934c);
            g(this.O, false, this.f8939h);
            g(this.P, false, this.f8938g);
            g(this.R, false, this.f8936d);
            j0 j0Var = this.f8945n;
            if (j0Var != null) {
                j0Var.setEnabled(false);
            }
        }
    }

    public final void i() {
        boolean z5;
        boolean z6;
        if (e() && this.H) {
            boolean f2 = f();
            View view = this.e;
            boolean z8 = true;
            if (view != null) {
                z5 = f2 && view.isFocused();
                z6 = i9.g.f14378a < 21 ? z5 : f2 && g9.f.a(view);
                view.setVisibility(f2 ? 8 : 0);
            } else {
                z5 = false;
                z6 = false;
            }
            View view2 = this.f8937f;
            if (view2 != null) {
                z5 |= !f2 && view2.isFocused();
                if (i9.g.f14378a < 21) {
                    z8 = z5;
                } else if (f2 || !g9.f.a(view2)) {
                    z8 = false;
                }
                z6 |= z8;
                view2.setVisibility(f2 ? 0 : 8);
            }
            if (z5) {
                boolean f10 = f();
                if (!f10 && view != null) {
                    view.requestFocus();
                } else if (f10 && view2 != null) {
                    view2.requestFocus();
                }
            }
            if (z6) {
                boolean f11 = f();
                if (!f11 && view != null) {
                    view.sendAccessibilityEvent(8);
                } else {
                    if (!f11 || view2 == null) {
                        return;
                    }
                    view2.sendAccessibilityEvent(8);
                }
            }
        }
    }

    public final void j() {
        ImageView imageView;
        if (e() && this.H && (imageView = this.f8940i) != null) {
            if (this.N == 0) {
                g(false, false, imageView);
                return;
            }
            String str = this.f8954x;
            Drawable drawable = this.f8951u;
            g(true, false, imageView);
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(str);
        }
    }

    public final void k() {
        ImageView imageView;
        if (e() && this.H && (imageView = this.f8941j) != null) {
            if (!this.S) {
                g(false, false, imageView);
                return;
            }
            String str = this.F;
            Drawable drawable = this.B;
            g(true, false, imageView);
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(str);
        }
    }

    public final void l() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = true;
        long j4 = this.T;
        if (j4 != -9223372036854775807L) {
            long uptimeMillis = j4 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                c();
            } else {
                postDelayed(this.f8950t, uptimeMillis);
            }
        } else if (e()) {
            d();
        }
        i();
        h();
        j();
        k();
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.H = false;
        removeCallbacks(this.f8949s);
        removeCallbacks(this.f8950t);
    }

    @Deprecated
    public void setControlDispatcher(c cVar) {
        if (this.G != cVar) {
            this.G = cVar;
            h();
        }
    }

    public void setPlayer(p pVar) {
        pc.b(Looper.myLooper() == Looper.getMainLooper());
        pc.a(pVar == null || pVar.z() == Looper.getMainLooper());
        if (pVar == null) {
            return;
        }
        g gVar = this.f8930a;
        if (pVar != null) {
            pVar.e(gVar);
        }
        i();
        h();
        j();
        k();
        l();
    }

    public void setProgressUpdateListener(h hVar) {
    }

    public void setRepeatToggleModes(int i3) {
        this.N = i3;
        j();
    }

    public void setShowFastForwardButton(boolean z5) {
        this.P = z5;
        h();
    }

    public void setShowMultiWindowTimeBar(boolean z5) {
        this.I = z5;
        l();
    }

    public void setShowNextButton(boolean z5) {
        this.R = z5;
        h();
    }

    public void setShowPreviousButton(boolean z5) {
        this.Q = z5;
        h();
    }

    public void setShowRewindButton(boolean z5) {
        this.O = z5;
        h();
    }

    public void setShowShuffleButton(boolean z5) {
        this.S = z5;
        k();
    }

    public void setShowTimeoutMs(int i3) {
        this.L = i3;
        if (e()) {
            d();
        }
    }

    public void setShowVrButton(boolean z5) {
        View view = this.f8942k;
        if (view != null) {
            view.setVisibility(z5 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i3) {
        this.M = i9.g.b(i3, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.f8942k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            g(getShowVrButton(), onClickListener != null, view);
        }
    }

    public PlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, attributeSet);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [g9.e] */
    /* JADX WARN: Type inference failed for: r1v6, types: [g9.e] */
    public PlayerControlView(Context context, AttributeSet attributeSet, int i3, AttributeSet attributeSet2) {
        super(context, attributeSet, i3);
        Context context2;
        int i10 = R$layout.exo_player_control_view;
        this.L = 5000;
        this.N = 0;
        this.M = 200;
        this.T = -9223372036854775807L;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, i3, 0);
            try {
                this.L = obtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, this.L);
                i10 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, i10);
                this.N = obtainStyledAttributes.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, this.N);
                this.O = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_rewind_button, this.O);
                this.P = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_fastforward_button, this.P);
                this.Q = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_previous_button, this.Q);
                this.R = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_next_button, this.R);
                this.S = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, this.S);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, this.M));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f8932b = new CopyOnWriteArrayList();
        this.f8948q = new s();
        this.r = new t();
        StringBuilder sb2 = new StringBuilder();
        this.f8946o = sb2;
        this.f8947p = new Formatter(sb2, Locale.getDefault());
        this.U = new long[0];
        this.V = new boolean[0];
        this.W = new long[0];
        this.f8931a0 = new boolean[0];
        g gVar = new g(this);
        this.f8930a = gVar;
        this.G = new d();
        final int i11 = 0;
        this.f8949s = new Runnable(this) { // from class: g9.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PlayerControlView f13924b;

            {
                this.f13924b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView playerControlView = this.f13924b;
                switch (i11) {
                    case 0:
                        int i12 = PlayerControlView.f8929d0;
                        if (playerControlView.e() && playerControlView.H) {
                            boolean z5 = 0 != playerControlView.f8935c0;
                            playerControlView.f8935c0 = 0L;
                            TextView textView = playerControlView.f8944m;
                            if (textView != null && !playerControlView.K && z5) {
                                textView.setText(i9.g.d(playerControlView.f8946o, playerControlView.f8947p, 0L));
                            }
                            j0 j0Var = playerControlView.f8945n;
                            if (j0Var != null) {
                                j0Var.setPosition(0L);
                                j0Var.setBufferedPosition(0L);
                            }
                            playerControlView.removeCallbacks(playerControlView.f8949s);
                            break;
                        }
                        break;
                    default:
                        playerControlView.c();
                        break;
                }
            }
        };
        final int i12 = 1;
        this.f8950t = new Runnable(this) { // from class: g9.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PlayerControlView f13924b;

            {
                this.f13924b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView playerControlView = this.f13924b;
                switch (i12) {
                    case 0:
                        int i122 = PlayerControlView.f8929d0;
                        if (playerControlView.e() && playerControlView.H) {
                            boolean z5 = 0 != playerControlView.f8935c0;
                            playerControlView.f8935c0 = 0L;
                            TextView textView = playerControlView.f8944m;
                            if (textView != null && !playerControlView.K && z5) {
                                textView.setText(i9.g.d(playerControlView.f8946o, playerControlView.f8947p, 0L));
                            }
                            j0 j0Var = playerControlView.f8945n;
                            if (j0Var != null) {
                                j0Var.setPosition(0L);
                                j0Var.setBufferedPosition(0L);
                            }
                            playerControlView.removeCallbacks(playerControlView.f8949s);
                            break;
                        }
                        break;
                    default:
                        playerControlView.c();
                        break;
                }
            }
        };
        LayoutInflater.from(context).inflate(i10, this);
        setDescendantFocusability(262144);
        j0 j0Var = (j0) findViewById(R$id.exo_progress);
        View findViewById = findViewById(R$id.exo_progress_placeholder);
        if (j0Var != null) {
            this.f8945n = j0Var;
            context2 = context;
        } else if (findViewById != null) {
            context2 = context;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context2, null, 0, attributeSet2, 0);
            defaultTimeBar.setId(R$id.exo_progress);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f8945n = defaultTimeBar;
        } else {
            context2 = context;
            this.f8945n = null;
        }
        this.f8943l = (TextView) findViewById(R$id.exo_duration);
        this.f8944m = (TextView) findViewById(R$id.exo_position);
        j0 j0Var2 = this.f8945n;
        if (j0Var2 != null) {
            j0Var2.addListener(gVar);
        }
        View findViewById2 = findViewById(R$id.exo_play);
        this.e = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(gVar);
        }
        View findViewById3 = findViewById(R$id.exo_pause);
        this.f8937f = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(gVar);
        }
        View findViewById4 = findViewById(R$id.exo_prev);
        this.f8934c = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(gVar);
        }
        View findViewById5 = findViewById(R$id.exo_next);
        this.f8936d = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(gVar);
        }
        View findViewById6 = findViewById(R$id.exo_rew);
        this.f8939h = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(gVar);
        }
        View findViewById7 = findViewById(R$id.exo_ffwd);
        this.f8938g = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(gVar);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f8940i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(gVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f8941j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(gVar);
        }
        View findViewById8 = findViewById(R$id.exo_vr);
        this.f8942k = findViewById8;
        setShowVrButton(false);
        g(false, false, findViewById8);
        Resources resources = context2.getResources();
        this.C = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f8951u = resources.getDrawable(R$drawable.exo_controls_repeat_off);
        this.f8952v = resources.getDrawable(R$drawable.exo_controls_repeat_one);
        this.f8953w = resources.getDrawable(R$drawable.exo_controls_repeat_all);
        this.A = resources.getDrawable(R$drawable.exo_controls_shuffle_on);
        this.B = resources.getDrawable(R$drawable.exo_controls_shuffle_off);
        this.f8954x = resources.getString(R$string.exo_controls_repeat_off_description);
        this.f8955y = resources.getString(R$string.exo_controls_repeat_one_description);
        this.f8956z = resources.getString(R$string.exo_controls_repeat_all_description);
        this.E = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.F = resources.getString(R$string.exo_controls_shuffle_off_description);
    }
}
