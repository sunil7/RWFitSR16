package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import com.google.common.collect.ImmutableList;
import g9.a;
import g9.b;
import g9.e0;
import g9.f0;
import g9.q;
import g9.z;
import i9.g;
import j9.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class StyledPlayerView extends FrameLayout {

    /* renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f9016z = 0;

    /* renamed from: a, reason: collision with root package name */
    public final f0 f9017a;

    /* renamed from: b, reason: collision with root package name */
    public final AspectRatioFrameLayout f9018b;

    /* renamed from: c, reason: collision with root package name */
    public final View f9019c;

    /* renamed from: d, reason: collision with root package name */
    public final View f9020d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f9021f;

    /* renamed from: g, reason: collision with root package name */
    public final SubtitleView f9022g;

    /* renamed from: h, reason: collision with root package name */
    public final View f9023h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f9024i;

    /* renamed from: j, reason: collision with root package name */
    public final StyledPlayerControlView f9025j;

    /* renamed from: k, reason: collision with root package name */
    public final FrameLayout f9026k;

    /* renamed from: l, reason: collision with root package name */
    public final FrameLayout f9027l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9028m;

    /* renamed from: n, reason: collision with root package name */
    public z f9029n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9030o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f9031p;

    /* renamed from: q, reason: collision with root package name */
    public int f9032q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f9033s;

    /* renamed from: t, reason: collision with root package name */
    public int f9034t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9035u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f9036v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f9037w;

    /* renamed from: x, reason: collision with root package name */
    public int f9038x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f9039y;

    public StyledPlayerView(Context context) {
        this(context, null);
    }

    public static void a(TextureView textureView, int i3) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i3 != 0) {
            float f2 = width / 2.0f;
            float f10 = height / 2.0f;
            matrix.postRotate(i3, f2, f10);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f10);
        }
        textureView.setTransform(matrix);
    }

    public final void b(boolean z5) {
        if (k()) {
            StyledPlayerControlView styledPlayerControlView = this.f9025j;
            boolean z6 = styledPlayerControlView.g() && styledPlayerControlView.getShowTimeoutMs() <= 0;
            boolean d5 = d();
            if (z5 || z6 || d5) {
                e(d5);
            }
        }
    }

    public final boolean c(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f2 = intrinsicWidth / intrinsicHeight;
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f9018b;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(f2);
                }
                ImageView imageView = this.f9021f;
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean d() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z5 = keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        if (z5 && k() && !styledPlayerControlView.g()) {
            b(true);
            return true;
        }
        if ((k() && styledPlayerControlView.b(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            b(true);
            return true;
        }
        if (z5 && k()) {
            b(true);
        }
        return false;
    }

    public final void e(boolean z5) {
        if (k()) {
            int i3 = z5 ? 0 : this.f9034t;
            StyledPlayerControlView styledPlayerControlView = this.f9025j;
            styledPlayerControlView.setShowTimeoutMs(i3);
            e0 e0Var = styledPlayerControlView.f8983a0;
            StyledPlayerControlView styledPlayerControlView2 = e0Var.f13925a;
            if (!styledPlayerControlView2.h()) {
                styledPlayerControlView2.setVisibility(0);
                styledPlayerControlView2.i();
                View view = styledPlayerControlView2.e;
                if (view != null) {
                    view.requestFocus();
                }
            }
            e0Var.k();
        }
    }

    public final boolean f() {
        k();
        return false;
    }

    public final void g() {
        View view = this.f9023h;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public List<a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f9027l;
        if (frameLayout != null) {
            arrayList.add(new a(frameLayout));
        }
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        if (styledPlayerControlView != null) {
            arrayList.add(new a(styledPlayerControlView));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.f9026k;
        pc.d(frameLayout, "exo_ad_overlay must be present for ad playback");
        return frameLayout;
    }

    public boolean getControllerAutoShow() {
        return this.f9035u;
    }

    public boolean getControllerHideOnTouch() {
        return this.f9037w;
    }

    public int getControllerShowTimeoutMs() {
        return this.f9034t;
    }

    public Drawable getDefaultArtwork() {
        return this.f9031p;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.f9027l;
    }

    public p getPlayer() {
        return null;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f9018b;
        pc.c(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.f9022g;
    }

    public boolean getUseArtwork() {
        return this.f9030o;
    }

    public boolean getUseController() {
        return this.f9028m;
    }

    public View getVideoSurfaceView() {
        return this.f9020d;
    }

    public final void h() {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        if (styledPlayerControlView == null || !this.f9028m) {
            setContentDescription(null);
        } else if (styledPlayerControlView.g()) {
            setContentDescription(this.f9037w ? getResources().getString(R$string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R$string.exo_controls_show));
        }
    }

    public final void i() {
        TextView textView = this.f9024i;
        if (textView != null) {
            CharSequence charSequence = this.f9033s;
            if (charSequence == null) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequence);
                textView.setVisibility(0);
            }
        }
    }

    public final void j(boolean z5) {
        View view = this.f9019c;
        ImageView imageView = this.f9021f;
        if (this.r) {
            return;
        }
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            imageView.setVisibility(4);
        }
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final boolean k() {
        if (!this.f9028m) {
            return false;
        }
        pc.c(this.f9025j);
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        k();
        return false;
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        k();
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return f();
    }

    public void setAspectRatioListener(b bVar) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f9018b;
        pc.c(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(bVar);
    }

    @Deprecated
    public void setControlDispatcher(c cVar) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setControlDispatcher(cVar);
    }

    public void setControllerAutoShow(boolean z5) {
        this.f9035u = z5;
    }

    public void setControllerHideDuringAds(boolean z5) {
        this.f9036v = z5;
    }

    public void setControllerHideOnTouch(boolean z5) {
        pc.c(this.f9025j);
        this.f9037w = z5;
        h();
    }

    public void setControllerOnFullScreenModeChangedListener(q qVar) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setOnFullScreenModeChangedListener(qVar);
    }

    public void setControllerShowTimeoutMs(int i3) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        this.f9034t = i3;
        if (styledPlayerControlView.g()) {
            e(d());
        }
    }

    public void setControllerVisibilityListener(z zVar) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        z zVar2 = this.f9029n;
        if (zVar2 == zVar) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = styledPlayerControlView.f8984b;
        if (zVar2 != null) {
            copyOnWriteArrayList.remove(zVar2);
        }
        this.f9029n = zVar;
        if (zVar != null) {
            copyOnWriteArrayList.add(zVar);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        pc.b(this.f9024i != null);
        this.f9033s = charSequence;
        i();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.f9031p != drawable) {
            this.f9031p = drawable;
            j(false);
        }
    }

    public void setErrorMessageProvider(i9.a aVar) {
        if (aVar != null) {
            i();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z5) {
        if (this.r != z5) {
            this.r = z5;
            j(false);
        }
    }

    public void setPlayer(p pVar) {
        pc.b(Looper.myLooper() == Looper.getMainLooper());
        pc.a(pVar == null || pVar.z() == Looper.getMainLooper());
        if (pVar == null) {
            return;
        }
        View view = this.f9020d;
        f0 f0Var = this.f9017a;
        SubtitleView subtitleView = this.f9022g;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        boolean k10 = k();
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        if (k10) {
            styledPlayerControlView.setPlayer(pVar);
        }
        g();
        i();
        j(true);
        if (pVar == null) {
            if (styledPlayerControlView != null) {
                styledPlayerControlView.f();
                return;
            }
            return;
        }
        r rVar = (r) pVar;
        if (rVar.K(26)) {
            if (view instanceof TextureView) {
                pVar.E((TextureView) view);
            } else if (view instanceof SurfaceView) {
                pVar.r((SurfaceView) view);
            }
            f fVar = f.e;
            int i3 = fVar.f15379a;
            int i10 = fVar.f15380b;
            float f2 = (i10 == 0 || i3 == 0) ? 0.0f : (i3 * fVar.f15382d) / i10;
            View view2 = this.f9020d;
            if (view2 instanceof TextureView) {
                int i11 = fVar.f15381c;
                if (f2 > 0.0f && (i11 == 90 || i11 == 270)) {
                    f2 = 1.0f / f2;
                }
                int i12 = this.f9038x;
                f0 f0Var2 = this.f9017a;
                if (i12 != 0) {
                    view2.removeOnLayoutChangeListener(f0Var2);
                }
                this.f9038x = i11;
                if (i11 != 0) {
                    view2.addOnLayoutChangeListener(f0Var2);
                }
                a((TextureView) view2, this.f9038x);
            }
            float f10 = this.e ? 0.0f : f2;
            AspectRatioFrameLayout aspectRatioFrameLayout = this.f9018b;
            if (aspectRatioFrameLayout != null) {
                aspectRatioFrameLayout.setAspectRatio(f10);
            }
        }
        if (subtitleView != null && rVar.K(27)) {
            subtitleView.setCues(pVar.k());
        }
        pVar.e(f0Var);
        b(false);
    }

    public void setRepeatToggleModes(int i3) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setRepeatToggleModes(i3);
    }

    public void setResizeMode(int i3) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f9018b;
        pc.c(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i3);
    }

    public void setShowBuffering(int i3) {
        if (this.f9032q != i3) {
            this.f9032q = i3;
            g();
        }
    }

    public void setShowFastForwardButton(boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setShowFastForwardButton(z5);
    }

    public void setShowMultiWindowTimeBar(boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setShowMultiWindowTimeBar(z5);
    }

    public void setShowNextButton(boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setShowNextButton(z5);
    }

    public void setShowPreviousButton(boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setShowPreviousButton(z5);
    }

    public void setShowRewindButton(boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setShowRewindButton(z5);
    }

    public void setShowShuffleButton(boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setShowShuffleButton(z5);
    }

    public void setShowSubtitleButton(boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setShowSubtitleButton(z5);
    }

    public void setShowVrButton(boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.c(styledPlayerControlView);
        styledPlayerControlView.setShowVrButton(z5);
    }

    public void setShutterBackgroundColor(int i3) {
        View view = this.f9019c;
        if (view != null) {
            view.setBackgroundColor(i3);
        }
    }

    public void setUseArtwork(boolean z5) {
        pc.b((z5 && this.f9021f == null) ? false : true);
        if (this.f9030o != z5) {
            this.f9030o = z5;
            j(false);
        }
    }

    public void setUseController(boolean z5) {
        StyledPlayerControlView styledPlayerControlView = this.f9025j;
        pc.b((z5 && styledPlayerControlView == null) ? false : true);
        if (this.f9028m == z5) {
            return;
        }
        this.f9028m = z5;
        if (k()) {
            styledPlayerControlView.setPlayer(null);
        } else if (styledPlayerControlView != null) {
            styledPlayerControlView.f();
            styledPlayerControlView.setPlayer(null);
        }
        h();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        View view = this.f9020d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i3);
        }
    }

    public StyledPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StyledPlayerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int i10;
        boolean z5;
        boolean z6;
        boolean z8;
        boolean z10;
        int i11;
        int i12;
        int i13;
        boolean z11;
        int i14;
        int i15;
        boolean z12;
        boolean z13;
        int i16;
        boolean z14;
        f0 f0Var = new f0(this);
        this.f9017a = f0Var;
        if (isInEditMode()) {
            this.f9018b = null;
            this.f9019c = null;
            this.f9020d = null;
            this.e = false;
            this.f9021f = null;
            this.f9022g = null;
            this.f9023h = null;
            this.f9024i = null;
            this.f9025j = null;
            this.f9026k = null;
            this.f9027l = null;
            ImageView imageView = new ImageView(context);
            if (g.f14378a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo, null));
                imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color, null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(R$drawable.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources2.getColor(R$color.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i17 = R$layout.exo_styled_player_view;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.StyledPlayerView, i3, 0);
            try {
                boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.StyledPlayerView_shutter_background_color);
                int color = obtainStyledAttributes.getColor(R$styleable.StyledPlayerView_shutter_background_color, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.StyledPlayerView_player_layout_id, i17);
                boolean z15 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.StyledPlayerView_default_artwork, 0);
                boolean z16 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_use_controller, true);
                int i18 = obtainStyledAttributes.getInt(R$styleable.StyledPlayerView_surface_type, 1);
                int i19 = obtainStyledAttributes.getInt(R$styleable.StyledPlayerView_resize_mode, 0);
                int i20 = obtainStyledAttributes.getInt(R$styleable.StyledPlayerView_show_timeout, 5000);
                boolean z17 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_hide_on_touch, true);
                boolean z18 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_auto_show, true);
                i12 = obtainStyledAttributes.getInteger(R$styleable.StyledPlayerView_show_buffering, 0);
                this.r = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_keep_content_on_player_reset, this.r);
                boolean z19 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                i17 = resourceId;
                i11 = i20;
                z12 = z19;
                z10 = z16;
                i10 = i18;
                z6 = z17;
                z8 = z15;
                i15 = resourceId2;
                z11 = hasValue;
                i14 = color;
                i13 = i19;
                z5 = z18;
            } catch (Throwable th2) {
                obtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            i10 = 1;
            z5 = true;
            z6 = true;
            z8 = true;
            z10 = true;
            i11 = 5000;
            i12 = 0;
            i13 = 0;
            z11 = false;
            i14 = 0;
            i15 = 0;
            z12 = true;
        }
        LayoutInflater.from(context).inflate(i17, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.exo_content_frame);
        this.f9018b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i13);
        }
        View findViewById = findViewById(R$id.exo_shutter);
        this.f9019c = findViewById;
        if (findViewById != null && z11) {
            findViewById.setBackgroundColor(i14);
        }
        if (aspectRatioFrameLayout != null && i10 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i10 == 2) {
                this.f9020d = new TextureView(context);
            } else if (i10 == 3) {
                try {
                    int i21 = SphericalGLSurfaceView.f9055l;
                    this.f9020d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    z14 = true;
                    this.f9020d.setLayoutParams(layoutParams);
                    this.f9020d.setOnClickListener(f0Var);
                    this.f9020d.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f9020d, 0);
                    z13 = z14;
                } catch (Exception e) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                }
            } else if (i10 != 4) {
                this.f9020d = new SurfaceView(context);
            } else {
                try {
                    int i22 = VideoDecoderGLSurfaceView.f9053b;
                    this.f9020d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e10) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e10);
                }
            }
            z14 = false;
            this.f9020d.setLayoutParams(layoutParams);
            this.f9020d.setOnClickListener(f0Var);
            this.f9020d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f9020d, 0);
            z13 = z14;
        } else {
            this.f9020d = null;
            z13 = false;
        }
        this.e = z13;
        this.f9026k = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.f9027l = (FrameLayout) findViewById(R$id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.f9021f = imageView2;
        this.f9030o = z8 && imageView2 != null;
        if (i15 != 0) {
            this.f9031p = a1.c.b(getContext(), i15);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f9022g = subtitleView;
        if (subtitleView != null) {
            subtitleView.a();
            subtitleView.b();
        }
        View findViewById2 = findViewById(R$id.exo_buffering);
        this.f9023h = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f9032q = i12;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f9024i = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) findViewById(R$id.exo_controller);
        View findViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (styledPlayerControlView != null) {
            this.f9025j = styledPlayerControlView;
            i16 = 0;
        } else if (findViewById3 != null) {
            i16 = 0;
            StyledPlayerControlView styledPlayerControlView2 = new StyledPlayerControlView(context, null, 0, attributeSet);
            this.f9025j = styledPlayerControlView2;
            styledPlayerControlView2.setId(R$id.exo_controller);
            styledPlayerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(styledPlayerControlView2, indexOfChild);
        } else {
            i16 = 0;
            this.f9025j = null;
        }
        StyledPlayerControlView styledPlayerControlView3 = this.f9025j;
        this.f9034t = styledPlayerControlView3 != null ? i11 : i16;
        this.f9037w = z6;
        this.f9035u = z5;
        this.f9036v = z12;
        this.f9028m = (!z10 || styledPlayerControlView3 == null) ? i16 : 1;
        if (styledPlayerControlView3 != null) {
            e0 e0Var = styledPlayerControlView3.f8983a0;
            int i23 = e0Var.f13948z;
            if (i23 != 3 && i23 != 2) {
                e0Var.f();
                e0Var.i(2);
            }
            this.f9025j.f8984b.add(f0Var);
        }
        h();
    }
}
