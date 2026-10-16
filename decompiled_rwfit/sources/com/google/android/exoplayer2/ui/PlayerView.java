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
import g9.i;
import g9.j;
import i9.g;
import j9.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class PlayerView extends FrameLayout {

    /* renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f8957z = 0;

    /* renamed from: a, reason: collision with root package name */
    public final j f8958a;

    /* renamed from: b, reason: collision with root package name */
    public final AspectRatioFrameLayout f8959b;

    /* renamed from: c, reason: collision with root package name */
    public final View f8960c;

    /* renamed from: d, reason: collision with root package name */
    public final View f8961d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f8962f;

    /* renamed from: g, reason: collision with root package name */
    public final SubtitleView f8963g;

    /* renamed from: h, reason: collision with root package name */
    public final View f8964h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f8965i;

    /* renamed from: j, reason: collision with root package name */
    public final PlayerControlView f8966j;

    /* renamed from: k, reason: collision with root package name */
    public final FrameLayout f8967k;

    /* renamed from: l, reason: collision with root package name */
    public final FrameLayout f8968l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8969m;

    /* renamed from: n, reason: collision with root package name */
    public i f8970n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8971o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f8972p;

    /* renamed from: q, reason: collision with root package name */
    public int f8973q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f8974s;

    /* renamed from: t, reason: collision with root package name */
    public int f8975t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8976u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8977v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8978w;

    /* renamed from: x, reason: collision with root package name */
    public int f8979x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8980y;

    public PlayerView(Context context) {
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
            PlayerControlView playerControlView = this.f8966j;
            boolean z6 = playerControlView.e() && playerControlView.getShowTimeoutMs() <= 0;
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
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f8959b;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(f2);
                }
                ImageView imageView = this.f8962f;
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
        PlayerControlView playerControlView = this.f8966j;
        if (z5 && k() && !playerControlView.e()) {
            b(true);
            return true;
        }
        if ((k() && playerControlView.a(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
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
            int i3 = z5 ? 0 : this.f8975t;
            PlayerControlView playerControlView = this.f8966j;
            playerControlView.setShowTimeoutMs(i3);
            if (!playerControlView.e()) {
                playerControlView.setVisibility(0);
                Iterator it = playerControlView.f8932b.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    playerControlView.getVisibility();
                    j jVar = (j) iVar;
                    jVar.getClass();
                    jVar.f13975a.h();
                }
                playerControlView.i();
                playerControlView.h();
                playerControlView.j();
                playerControlView.k();
                playerControlView.l();
                boolean f2 = playerControlView.f();
                View view = playerControlView.f8937f;
                View view2 = playerControlView.e;
                if (!f2 && view2 != null) {
                    view2.requestFocus();
                } else if (f2 && view != null) {
                    view.requestFocus();
                }
                boolean f10 = playerControlView.f();
                if (!f10 && view2 != null) {
                    view2.sendAccessibilityEvent(8);
                } else if (f10 && view != null) {
                    view.sendAccessibilityEvent(8);
                }
            }
            playerControlView.d();
        }
    }

    public final boolean f() {
        k();
        return false;
    }

    public final void g() {
        View view = this.f8964h;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public List<a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f8968l;
        if (frameLayout != null) {
            arrayList.add(new a(frameLayout));
        }
        PlayerControlView playerControlView = this.f8966j;
        if (playerControlView != null) {
            arrayList.add(new a(playerControlView));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.f8967k;
        pc.d(frameLayout, "exo_ad_overlay must be present for ad playback");
        return frameLayout;
    }

    public boolean getControllerAutoShow() {
        return this.f8976u;
    }

    public boolean getControllerHideOnTouch() {
        return this.f8978w;
    }

    public int getControllerShowTimeoutMs() {
        return this.f8975t;
    }

    public Drawable getDefaultArtwork() {
        return this.f8972p;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.f8968l;
    }

    public p getPlayer() {
        return null;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f8959b;
        pc.c(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.f8963g;
    }

    public boolean getUseArtwork() {
        return this.f8971o;
    }

    public boolean getUseController() {
        return this.f8969m;
    }

    public View getVideoSurfaceView() {
        return this.f8961d;
    }

    public final void h() {
        PlayerControlView playerControlView = this.f8966j;
        if (playerControlView == null || !this.f8969m) {
            setContentDescription(null);
        } else if (playerControlView.getVisibility() == 0) {
            setContentDescription(this.f8978w ? getResources().getString(R$string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R$string.exo_controls_show));
        }
    }

    public final void i() {
        TextView textView = this.f8965i;
        if (textView != null) {
            CharSequence charSequence = this.f8974s;
            if (charSequence == null) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequence);
                textView.setVisibility(0);
            }
        }
    }

    public final void j(boolean z5) {
        View view = this.f8960c;
        ImageView imageView = this.f8962f;
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
        if (!this.f8969m) {
            return false;
        }
        pc.c(this.f8966j);
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
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f8959b;
        pc.c(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(bVar);
    }

    @Deprecated
    public void setControlDispatcher(c cVar) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        playerControlView.setControlDispatcher(cVar);
    }

    public void setControllerAutoShow(boolean z5) {
        this.f8976u = z5;
    }

    public void setControllerHideDuringAds(boolean z5) {
        this.f8977v = z5;
    }

    public void setControllerHideOnTouch(boolean z5) {
        pc.c(this.f8966j);
        this.f8978w = z5;
        h();
    }

    public void setControllerShowTimeoutMs(int i3) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        this.f8975t = i3;
        if (playerControlView.e()) {
            e(d());
        }
    }

    public void setControllerVisibilityListener(i iVar) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        i iVar2 = this.f8970n;
        if (iVar2 == iVar) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = playerControlView.f8932b;
        if (iVar2 != null) {
            copyOnWriteArrayList.remove(iVar2);
        }
        this.f8970n = iVar;
        if (iVar != null) {
            copyOnWriteArrayList.add(iVar);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        pc.b(this.f8965i != null);
        this.f8974s = charSequence;
        i();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.f8972p != drawable) {
            this.f8972p = drawable;
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
        View view = this.f8961d;
        j jVar = this.f8958a;
        SubtitleView subtitleView = this.f8963g;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        boolean k10 = k();
        PlayerControlView playerControlView = this.f8966j;
        if (k10) {
            playerControlView.setPlayer(pVar);
        }
        g();
        i();
        j(true);
        if (pVar == null) {
            if (playerControlView != null) {
                playerControlView.c();
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
            View view2 = this.f8961d;
            if (view2 instanceof TextureView) {
                int i11 = fVar.f15381c;
                if (f2 > 0.0f && (i11 == 90 || i11 == 270)) {
                    f2 = 1.0f / f2;
                }
                int i12 = this.f8979x;
                j jVar2 = this.f8958a;
                if (i12 != 0) {
                    view2.removeOnLayoutChangeListener(jVar2);
                }
                this.f8979x = i11;
                if (i11 != 0) {
                    view2.addOnLayoutChangeListener(jVar2);
                }
                a((TextureView) view2, this.f8979x);
            }
            float f10 = this.e ? 0.0f : f2;
            AspectRatioFrameLayout aspectRatioFrameLayout = this.f8959b;
            if (aspectRatioFrameLayout != null) {
                aspectRatioFrameLayout.setAspectRatio(f10);
            }
        }
        if (subtitleView != null && rVar.K(27)) {
            subtitleView.setCues(pVar.k());
        }
        pVar.e(jVar);
        b(false);
    }

    public void setRepeatToggleModes(int i3) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        playerControlView.setRepeatToggleModes(i3);
    }

    public void setResizeMode(int i3) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f8959b;
        pc.c(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i3);
    }

    public void setShowBuffering(int i3) {
        if (this.f8973q != i3) {
            this.f8973q = i3;
            g();
        }
    }

    public void setShowFastForwardButton(boolean z5) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        playerControlView.setShowFastForwardButton(z5);
    }

    public void setShowMultiWindowTimeBar(boolean z5) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        playerControlView.setShowMultiWindowTimeBar(z5);
    }

    public void setShowNextButton(boolean z5) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        playerControlView.setShowNextButton(z5);
    }

    public void setShowPreviousButton(boolean z5) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        playerControlView.setShowPreviousButton(z5);
    }

    public void setShowRewindButton(boolean z5) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        playerControlView.setShowRewindButton(z5);
    }

    public void setShowShuffleButton(boolean z5) {
        PlayerControlView playerControlView = this.f8966j;
        pc.c(playerControlView);
        playerControlView.setShowShuffleButton(z5);
    }

    public void setShutterBackgroundColor(int i3) {
        View view = this.f8960c;
        if (view != null) {
            view.setBackgroundColor(i3);
        }
    }

    public void setUseArtwork(boolean z5) {
        pc.b((z5 && this.f8962f == null) ? false : true);
        if (this.f8971o != z5) {
            this.f8971o = z5;
            j(false);
        }
    }

    public void setUseController(boolean z5) {
        PlayerControlView playerControlView = this.f8966j;
        pc.b((z5 && playerControlView == null) ? false : true);
        if (this.f8969m == z5) {
            return;
        }
        this.f8969m = z5;
        if (k()) {
            playerControlView.setPlayer(null);
        } else if (playerControlView != null) {
            playerControlView.c();
            playerControlView.setPlayer(null);
        }
        h();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        View view = this.f8961d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i3);
        }
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerView(Context context, AttributeSet attributeSet, int i3) {
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
        j jVar = new j(this);
        this.f8958a = jVar;
        if (isInEditMode()) {
            this.f8959b = null;
            this.f8960c = null;
            this.f8961d = null;
            this.e = false;
            this.f8962f = null;
            this.f8963g = null;
            this.f8964h = null;
            this.f8965i = null;
            this.f8966j = null;
            this.f8967k = null;
            this.f8968l = null;
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
        int i17 = R$layout.exo_player_view;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.PlayerView, i3, 0);
            try {
                boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.PlayerView_shutter_background_color);
                int color = obtainStyledAttributes.getColor(R$styleable.PlayerView_shutter_background_color, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.PlayerView_player_layout_id, i17);
                boolean z15 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.PlayerView_default_artwork, 0);
                boolean z16 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_controller, true);
                int i18 = obtainStyledAttributes.getInt(R$styleable.PlayerView_surface_type, 1);
                int i19 = obtainStyledAttributes.getInt(R$styleable.PlayerView_resize_mode, 0);
                int i20 = obtainStyledAttributes.getInt(R$styleable.PlayerView_show_timeout, 5000);
                boolean z17 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_on_touch, true);
                boolean z18 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_auto_show, true);
                i12 = obtainStyledAttributes.getInteger(R$styleable.PlayerView_show_buffering, 0);
                this.r = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_keep_content_on_player_reset, this.r);
                boolean z19 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_during_ads, true);
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
        this.f8959b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i13);
        }
        View findViewById = findViewById(R$id.exo_shutter);
        this.f8960c = findViewById;
        if (findViewById != null && z11) {
            findViewById.setBackgroundColor(i14);
        }
        if (aspectRatioFrameLayout != null && i10 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i10 == 2) {
                this.f8961d = new TextureView(context);
            } else if (i10 == 3) {
                try {
                    int i21 = SphericalGLSurfaceView.f9055l;
                    this.f8961d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    z14 = true;
                    this.f8961d.setLayoutParams(layoutParams);
                    this.f8961d.setOnClickListener(jVar);
                    this.f8961d.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f8961d, 0);
                    z13 = z14;
                } catch (Exception e) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                }
            } else if (i10 != 4) {
                this.f8961d = new SurfaceView(context);
            } else {
                try {
                    int i22 = VideoDecoderGLSurfaceView.f9053b;
                    this.f8961d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e10) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e10);
                }
            }
            z14 = false;
            this.f8961d.setLayoutParams(layoutParams);
            this.f8961d.setOnClickListener(jVar);
            this.f8961d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f8961d, 0);
            z13 = z14;
        } else {
            this.f8961d = null;
            z13 = false;
        }
        this.e = z13;
        this.f8967k = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.f8968l = (FrameLayout) findViewById(R$id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.f8962f = imageView2;
        this.f8971o = z8 && imageView2 != null;
        if (i15 != 0) {
            this.f8972p = a1.c.b(getContext(), i15);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f8963g = subtitleView;
        if (subtitleView != null) {
            subtitleView.a();
            subtitleView.b();
        }
        View findViewById2 = findViewById(R$id.exo_buffering);
        this.f8964h = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f8973q = i12;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f8965i = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(R$id.exo_controller);
        View findViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f8966j = playerControlView;
            i16 = 0;
        } else if (findViewById3 != null) {
            i16 = 0;
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f8966j = playerControlView2;
            playerControlView2.setId(R$id.exo_controller);
            playerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(playerControlView2, indexOfChild);
        } else {
            i16 = 0;
            this.f8966j = null;
        }
        PlayerControlView playerControlView3 = this.f8966j;
        this.f8975t = playerControlView3 != null ? i11 : i16;
        this.f8978w = z6;
        this.f8976u = z5;
        this.f8977v = z12;
        this.f8969m = (!z10 || playerControlView3 == null) ? i16 : 1;
        if (playerControlView3 != null) {
            playerControlView3.c();
        }
        h();
        PlayerControlView playerControlView4 = this.f8966j;
        if (playerControlView4 != null) {
            playerControlView4.f8932b.add(jVar);
        }
    }
}
