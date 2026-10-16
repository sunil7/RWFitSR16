package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.activity.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z0;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.t;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import com.google.android.gms.internal.mlkit_vision_barcode.zb;
import d4.a0;
import g9.e0;
import g9.j0;
import g9.n;
import g9.o;
import g9.p;
import g9.q;
import g9.s;
import g9.v;
import i9.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class StyledPlayerControlView extends FrameLayout {

    /* renamed from: a1, reason: collision with root package name */
    public static final /* synthetic */ int f8981a1 = 0;
    public final Drawable A;
    public final Drawable B;
    public final float C;
    public final float D;
    public final String E;
    public final String F;
    public final Drawable G;
    public final Drawable H;
    public final String I;
    public final String J;
    public c K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public int Q;
    public int R;
    public long[] S;
    public boolean[] T;
    public final long[] U;
    public final ImageView U0;
    public final boolean[] V;
    public final ImageView V0;
    public long W;
    public final ImageView W0;
    public final View X0;
    public final View Y0;
    public final View Z0;

    /* renamed from: a, reason: collision with root package name */
    public final p f8982a;

    /* renamed from: a0, reason: collision with root package name */
    public final e0 f8983a0;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f8984b;

    /* renamed from: b0, reason: collision with root package name */
    public final Resources f8985b0;

    /* renamed from: c, reason: collision with root package name */
    public final View f8986c;

    /* renamed from: c0, reason: collision with root package name */
    public final RecyclerView f8987c0;

    /* renamed from: d, reason: collision with root package name */
    public final View f8988d;

    /* renamed from: d0, reason: collision with root package name */
    public final v f8989d0;
    public final View e;

    /* renamed from: e0, reason: collision with root package name */
    public final s f8990e0;

    /* renamed from: f, reason: collision with root package name */
    public final View f8991f;

    /* renamed from: f0, reason: collision with root package name */
    public final PopupWindow f8992f0;

    /* renamed from: g, reason: collision with root package name */
    public final View f8993g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f8994g0;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f8995h;

    /* renamed from: h0, reason: collision with root package name */
    public final int f8996h0;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f8997i;
    public final o i0;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f8998j;

    /* renamed from: j0, reason: collision with root package name */
    public final o f8999j0;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f9000k;

    /* renamed from: k0, reason: collision with root package name */
    public final a0 f9001k0;

    /* renamed from: l, reason: collision with root package name */
    public final View f9002l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f9003m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f9004n;

    /* renamed from: o, reason: collision with root package name */
    public final j0 f9005o;

    /* renamed from: p, reason: collision with root package name */
    public final StringBuilder f9006p;

    /* renamed from: q, reason: collision with root package name */
    public final Formatter f9007q;
    public final com.google.android.exoplayer2.s r;

    /* renamed from: s, reason: collision with root package name */
    public final t f9008s;

    /* renamed from: t, reason: collision with root package name */
    public final b f9009t;

    /* renamed from: u, reason: collision with root package name */
    public final Drawable f9010u;

    /* renamed from: v, reason: collision with root package name */
    public final Drawable f9011v;

    /* renamed from: w, reason: collision with root package name */
    public final Drawable f9012w;

    /* renamed from: x, reason: collision with root package name */
    public final String f9013x;

    /* renamed from: y, reason: collision with root package name */
    public final String f9014y;

    /* renamed from: z, reason: collision with root package name */
    public final String f9015z;

    static {
        f.a("goog.exo.ui");
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
    }

    public final boolean b(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        return false;
    }

    public final void c(com.google.android.exoplayer2.p pVar) {
        int i3 = pVar.i();
        if (i3 == 1) {
            ((d) this.K).getClass();
            pVar.n();
        } else if (i3 == 4) {
            int D = pVar.D();
            ((d) this.K).getClass();
            pVar.f(D, -9223372036854775807L);
        }
        ((d) this.K).getClass();
        pVar.a(true);
    }

    public final void d(z0 z0Var) {
        this.f8987c0.setAdapter(z0Var);
        m();
        this.f8994g0 = false;
        PopupWindow popupWindow = this.f8992f0;
        popupWindow.dismiss();
        this.f8994g0 = true;
        int width = getWidth() - popupWindow.getWidth();
        int i3 = this.f8996h0;
        popupWindow.showAsDropDown(this, width - i3, (-popupWindow.getHeight()) - i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final void e(zb zbVar, int i3, ArrayList arrayList) {
        zbVar.getClass();
        throw null;
    }

    public final void f() {
        e0 e0Var = this.f8983a0;
        int i3 = e0Var.f13948z;
        if (i3 == 3 || i3 == 2) {
            return;
        }
        e0Var.f();
        if (!e0Var.C) {
            e0Var.i(2);
        } else if (e0Var.f13948z == 1) {
            e0Var.f13936m.start();
        } else {
            e0Var.f13937n.start();
        }
    }

    public final boolean g() {
        e0 e0Var = this.f8983a0;
        return e0Var.f13948z == 0 && e0Var.f13925a.h();
    }

    public com.google.android.exoplayer2.p getPlayer() {
        return null;
    }

    public int getRepeatToggleModes() {
        return this.R;
    }

    public boolean getShowShuffleButton() {
        return this.f8983a0.b(this.f9000k);
    }

    public boolean getShowSubtitleButton() {
        return this.f8983a0.b(this.U0);
    }

    public int getShowTimeoutMs() {
        return this.P;
    }

    public boolean getShowVrButton() {
        return this.f8983a0.b(this.f9002l);
    }

    public final boolean h() {
        return getVisibility() == 0;
    }

    public final void i() {
        View view;
        if (h() && this.L && (view = this.e) != null) {
            Resources resources = this.f8985b0;
            ((ImageView) view).setImageDrawable(resources.getDrawable(R$drawable.exo_styled_controls_play));
            view.setContentDescription(resources.getString(R$string.exo_controls_play_description));
        }
        k();
        l();
        n();
        o oVar = this.i0;
        oVar.getClass();
        List list = Collections.EMPTY_LIST;
        oVar.f13993b = list;
        o oVar2 = this.f8999j0;
        oVar2.getClass();
        oVar2.f13993b = list;
        j(this.U0, oVar.getItemCount() > 0);
        o();
    }

    public final void j(View view, boolean z5) {
        if (view == null) {
            return;
        }
        view.setEnabled(z5);
        view.setAlpha(z5 ? this.C : this.D);
    }

    public final void k() {
        if (h() && this.L) {
            View view = this.f8993g;
            View view2 = this.f8991f;
            j(this.f8986c, false);
            j(view, false);
            j(view2, false);
            j(this.f8988d, false);
            j0 j0Var = this.f9005o;
            if (j0Var != null) {
                j0Var.setEnabled(false);
            }
        }
    }

    public final void l() {
        ImageView imageView;
        if (h() && this.L && (imageView = this.f8998j) != null) {
            if (this.R == 0) {
                j(imageView, false);
                return;
            }
            String str = this.f9013x;
            Drawable drawable = this.f9010u;
            j(imageView, false);
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(str);
        }
    }

    public final void m() {
        RecyclerView recyclerView = this.f8987c0;
        recyclerView.measure(0, 0);
        int width = getWidth();
        int i3 = this.f8996h0;
        int min = Math.min(recyclerView.getMeasuredWidth(), width - (i3 * 2));
        PopupWindow popupWindow = this.f8992f0;
        popupWindow.setWidth(min);
        popupWindow.setHeight(Math.min(getHeight() - (i3 * 2), recyclerView.getMeasuredHeight()));
    }

    public final void n() {
        ImageView imageView;
        if (h() && this.L && (imageView = this.f9000k) != null) {
            if (!this.f8983a0.b(imageView)) {
                j(imageView, false);
                return;
            }
            String str = this.F;
            Drawable drawable = this.B;
            j(imageView, false);
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(str);
        }
    }

    public final void o() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e0 e0Var = this.f8983a0;
        e0Var.f13925a.addOnLayoutChangeListener(e0Var.f13946x);
        this.L = true;
        if (g()) {
            e0Var.g();
        }
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e0 e0Var = this.f8983a0;
        e0Var.f13925a.removeOnLayoutChangeListener(e0Var.f13946x);
        this.L = false;
        removeCallbacks(this.f9009t);
        e0Var.f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        View view = this.f8983a0.f13926b;
        if (view != null) {
            view.layout(0, 0, i11 - i3, i12 - i10);
        }
    }

    public void setAnimationEnabled(boolean z5) {
        this.f8983a0.C = z5;
    }

    @Deprecated
    public void setControlDispatcher(c cVar) {
        if (this.K != cVar) {
            this.K = cVar;
            k();
        }
    }

    public void setOnFullScreenModeChangedListener(q qVar) {
        boolean z5 = qVar != null;
        ImageView imageView = this.V0;
        if (imageView != null) {
            if (z5) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        boolean z6 = qVar != null;
        ImageView imageView2 = this.W0;
        if (imageView2 == null) {
            return;
        }
        if (z6) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
    }

    public void setPlayer(com.google.android.exoplayer2.p pVar) {
        pc.b(Looper.myLooper() == Looper.getMainLooper());
        pc.a(pVar == null || pVar.z() == Looper.getMainLooper());
        if (pVar == null) {
            return;
        }
        p pVar2 = this.f8982a;
        if (pVar != null) {
            pVar.e(pVar2);
        }
        if (pVar instanceof r) {
            boolean z5 = ((r) pVar).J() instanceof f9.b;
        }
        i();
    }

    public void setProgressUpdateListener(g9.t tVar) {
    }

    public void setRepeatToggleModes(int i3) {
        this.R = i3;
        this.f8983a0.h(this.f8998j, i3 != 0);
        l();
    }

    public void setShowFastForwardButton(boolean z5) {
        this.f8983a0.h(this.f8991f, z5);
        k();
    }

    public void setShowMultiWindowTimeBar(boolean z5) {
        this.M = z5;
        o();
    }

    public void setShowNextButton(boolean z5) {
        this.f8983a0.h(this.f8988d, z5);
        k();
    }

    public void setShowPreviousButton(boolean z5) {
        this.f8983a0.h(this.f8986c, z5);
        k();
    }

    public void setShowRewindButton(boolean z5) {
        this.f8983a0.h(this.f8993g, z5);
        k();
    }

    public void setShowShuffleButton(boolean z5) {
        this.f8983a0.h(this.f9000k, z5);
        n();
    }

    public void setShowSubtitleButton(boolean z5) {
        this.f8983a0.h(this.U0, z5);
    }

    public void setShowTimeoutMs(int i3) {
        this.P = i3;
        if (g()) {
            this.f8983a0.g();
        }
    }

    public void setShowVrButton(boolean z5) {
        this.f8983a0.h(this.f9002l, z5);
    }

    public void setTimeBarMinUpdateInterval(int i3) {
        this.Q = g.b(i3, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.f9002l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            j(view, onClickListener != null);
        }
    }

    public StyledPlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.widget.TextView] */
    public StyledPlayerControlView(Context context, AttributeSet attributeSet, int i3, AttributeSet attributeSet2) {
        super(context, attributeSet, i3);
        boolean z5;
        boolean z6;
        boolean z8;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        p pVar;
        boolean z15;
        boolean z16;
        Typeface typeface;
        int i10 = 2;
        int i11 = R$layout.exo_styled_player_control_view;
        this.P = 5000;
        this.R = 0;
        this.Q = 200;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.StyledPlayerControlView, i3, 0);
            try {
                i11 = obtainStyledAttributes.getResourceId(R$styleable.StyledPlayerControlView_controller_layout_id, i11);
                this.P = obtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_show_timeout, this.P);
                this.R = obtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_repeat_toggle_modes, this.R);
                boolean z17 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z18 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z19 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z20 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_next_button, true);
                boolean z21 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z22 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z23 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_time_bar_min_update_interval, this.Q));
                boolean z24 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_animation_enabled, true);
                obtainStyledAttributes.recycle();
                z8 = z22;
                z5 = z23;
                z13 = z19;
                z14 = z20;
                z11 = z17;
                z10 = z24;
                z6 = z21;
                z12 = z18;
            } catch (Throwable th2) {
                obtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            z5 = false;
            z6 = false;
            z8 = false;
            z10 = true;
            z11 = true;
            z12 = true;
            z13 = true;
            z14 = true;
        }
        LayoutInflater.from(context).inflate(i11, this);
        setDescendantFocusability(262144);
        p pVar2 = new p(this);
        this.f8982a = pVar2;
        this.f8984b = new CopyOnWriteArrayList();
        this.r = new com.google.android.exoplayer2.s();
        this.f9008s = new t();
        StringBuilder sb2 = new StringBuilder();
        this.f9006p = sb2;
        this.f9007q = new Formatter(sb2, Locale.getDefault());
        this.S = new long[0];
        this.T = new boolean[0];
        this.U = new long[0];
        this.V = new boolean[0];
        this.K = new d();
        this.f9009t = new b(this, 27);
        this.f9003m = (TextView) findViewById(R$id.exo_duration);
        this.f9004n = (TextView) findViewById(R$id.exo_position);
        ImageView imageView = (ImageView) findViewById(R$id.exo_subtitle);
        this.U0 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(pVar2);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_fullscreen);
        this.V0 = imageView2;
        com.example.test.ui.testui.p pVar3 = new com.example.test.ui.testui.p(this, i10);
        if (imageView2 != null) {
            imageView2.setVisibility(8);
            imageView2.setOnClickListener(pVar3);
        }
        ImageView imageView3 = (ImageView) findViewById(R$id.exo_minimal_fullscreen);
        this.W0 = imageView3;
        com.example.test.ui.testui.p pVar4 = new com.example.test.ui.testui.p(this, i10);
        if (imageView3 != null) {
            imageView3.setVisibility(8);
            imageView3.setOnClickListener(pVar4);
        }
        View findViewById = findViewById(R$id.exo_settings);
        this.X0 = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(pVar2);
        }
        View findViewById2 = findViewById(R$id.exo_playback_speed);
        this.Y0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(pVar2);
        }
        View findViewById3 = findViewById(R$id.exo_audio_track);
        this.Z0 = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(pVar2);
        }
        j0 j0Var = (j0) findViewById(R$id.exo_progress);
        View findViewById4 = findViewById(R$id.exo_progress_placeholder);
        if (j0Var != null) {
            this.f9005o = j0Var;
            pVar = pVar2;
            z15 = z5;
            z16 = z10;
            typeface = null;
        } else if (findViewById4 != null) {
            pVar = pVar2;
            z15 = z5;
            z16 = z10;
            typeface = null;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R$style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(R$id.exo_progress);
            defaultTimeBar.setLayoutParams(findViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById4.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById4);
            viewGroup.removeView(findViewById4);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f9005o = defaultTimeBar;
        } else {
            pVar = pVar2;
            z15 = z5;
            z16 = z10;
            typeface = null;
            this.f9005o = null;
        }
        j0 j0Var2 = this.f9005o;
        p pVar5 = pVar;
        if (j0Var2 != null) {
            j0Var2.addListener(pVar5);
        }
        View findViewById5 = findViewById(R$id.exo_play_pause);
        this.e = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(pVar5);
        }
        View findViewById6 = findViewById(R$id.exo_prev);
        this.f8986c = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(pVar5);
        }
        View findViewById7 = findViewById(R$id.exo_next);
        this.f8988d = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(pVar5);
        }
        int i12 = R$font.roboto_medium_numbers;
        ThreadLocal threadLocal = b1.o.f3076a;
        Typeface a3 = context.isRestricted() ? typeface : b1.o.a(context, i12, new TypedValue(), 0, null, false, false);
        View findViewById8 = findViewById(R$id.exo_rew);
        ?? r72 = findViewById8 == null ? (TextView) findViewById(R$id.exo_rew_with_amount) : typeface;
        this.f8997i = r72;
        if (r72 != 0) {
            r72.setTypeface(a3);
        }
        findViewById8 = findViewById8 == null ? r72 : findViewById8;
        this.f8993g = findViewById8;
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(pVar5);
        }
        View findViewById9 = findViewById(R$id.exo_ffwd);
        ?? r8 = findViewById9 == null ? (TextView) findViewById(R$id.exo_ffwd_with_amount) : typeface;
        this.f8995h = r8;
        if (r8 != 0) {
            r8.setTypeface(a3);
        }
        findViewById9 = findViewById9 == null ? r8 : findViewById9;
        this.f8991f = findViewById9;
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(pVar5);
        }
        ImageView imageView4 = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f8998j = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(pVar5);
        }
        ImageView imageView5 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f9000k = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(pVar5);
        }
        Resources resources = context.getResources();
        this.f8985b0 = resources;
        this.C = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View findViewById10 = findViewById(R$id.exo_vr);
        this.f9002l = findViewById10;
        if (findViewById10 != null) {
            j(findViewById10, false);
        }
        e0 e0Var = new e0(this);
        this.f8983a0 = e0Var;
        e0Var.C = z16;
        boolean z25 = z8;
        v vVar = new v(this, new String[]{resources.getString(R$string.exo_controls_playback_speed), resources.getString(R$string.exo_track_selection_title_audio)}, new Drawable[]{resources.getDrawable(R$drawable.exo_styled_controls_speed), resources.getDrawable(R$drawable.exo_styled_controls_audiotrack)});
        this.f8989d0 = vVar;
        this.f8996h0 = resources.getDimensionPixelSize(R$dimen.exo_settings_offset);
        boolean z26 = z6;
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.exo_styled_settings_list, (ViewGroup) null);
        this.f8987c0 = recyclerView;
        recyclerView.setAdapter(vVar);
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        this.f8992f0 = popupWindow;
        if (g.f14378a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(pVar5);
        this.f8994g0 = true;
        this.f9001k0 = new a0(getResources(), 1);
        this.G = resources.getDrawable(R$drawable.exo_styled_controls_subtitle_on);
        this.H = resources.getDrawable(R$drawable.exo_styled_controls_subtitle_off);
        this.I = resources.getString(R$string.exo_controls_cc_enabled_description);
        this.J = resources.getString(R$string.exo_controls_cc_disabled_description);
        this.i0 = new o(this, 1);
        this.f8999j0 = new o(this, 0);
        this.f8990e0 = new s(this, resources.getStringArray(R$array.exo_playback_speeds), resources.getIntArray(R$array.exo_speed_multiplied_by_100));
        resources.getDrawable(R$drawable.exo_styled_controls_fullscreen_exit);
        resources.getDrawable(R$drawable.exo_styled_controls_fullscreen_enter);
        this.f9010u = resources.getDrawable(R$drawable.exo_styled_controls_repeat_off);
        this.f9011v = resources.getDrawable(R$drawable.exo_styled_controls_repeat_one);
        this.f9012w = resources.getDrawable(R$drawable.exo_styled_controls_repeat_all);
        this.A = resources.getDrawable(R$drawable.exo_styled_controls_shuffle_on);
        this.B = resources.getDrawable(R$drawable.exo_styled_controls_shuffle_off);
        resources.getString(R$string.exo_controls_fullscreen_exit_description);
        resources.getString(R$string.exo_controls_fullscreen_enter_description);
        this.f9013x = resources.getString(R$string.exo_controls_repeat_off_description);
        this.f9014y = resources.getString(R$string.exo_controls_repeat_one_description);
        this.f9015z = resources.getString(R$string.exo_controls_repeat_all_description);
        this.E = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.F = resources.getString(R$string.exo_controls_shuffle_off_description);
        e0Var.h((ViewGroup) findViewById(R$id.exo_bottom_bar), true);
        e0Var.h(findViewById9, z12);
        e0Var.h(findViewById8, z11);
        e0Var.h(findViewById6, z13);
        e0Var.h(findViewById7, z14);
        e0Var.h(imageView5, z26);
        e0Var.h(imageView, z25);
        e0Var.h(findViewById10, z15);
        e0Var.h(imageView4, this.R != 0);
        addOnLayoutChangeListener(new n(this, 0));
    }
}
