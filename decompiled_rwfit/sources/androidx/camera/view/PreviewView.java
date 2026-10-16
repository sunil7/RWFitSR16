package androidx.camera.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.camera.core.impl.u;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.lifecycle.b0;
import androidx.lifecycle.y;
import com.google.android.gms.internal.mlkit_common.o;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import g9.n;
import h0.e;
import h0.f;
import h0.l;
import java.util.concurrent.atomic.AtomicReference;
import l1.z0;
import t.f1;
import t.h1;
import t.k0;
import t.u0;
import t.w0;

/* loaded from: classes.dex */
public final class PreviewView extends FrameLayout {

    /* renamed from: m, reason: collision with root package name */
    public static final ImplementationMode f1566m = ImplementationMode.PERFORMANCE;

    /* renamed from: a, reason: collision with root package name */
    public ImplementationMode f1567a;

    /* renamed from: b, reason: collision with root package name */
    public e f1568b;

    /* renamed from: c, reason: collision with root package name */
    public final ScreenFlashView f1569c;

    /* renamed from: d, reason: collision with root package name */
    public final c f1570d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final b0 f1571f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference f1572g;

    /* renamed from: h, reason: collision with root package name */
    public final f f1573h;

    /* renamed from: i, reason: collision with root package name */
    public u f1574i;

    /* renamed from: j, reason: collision with root package name */
    public final h0.d f1575j;

    /* renamed from: k, reason: collision with root package name */
    public final n f1576k;

    /* renamed from: l, reason: collision with root package name */
    public final d f1577l;

    public enum ImplementationMode {
        PERFORMANCE(0),
        COMPATIBLE(1);

        private final int mId;

        ImplementationMode(int i3) {
            this.mId = i3;
        }

        public static ImplementationMode fromId(int i3) {
            for (ImplementationMode implementationMode : values()) {
                if (implementationMode.mId == i3) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException(l0.j(i3, "Unknown implementation mode id "));
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum ScaleType {
        FILL_START(0),
        FILL_CENTER(1),
        FILL_END(2),
        FIT_START(3),
        FIT_CENTER(4),
        FIT_END(5);

        private final int mId;

        ScaleType(int i3) {
            this.mId = i3;
        }

        public static ScaleType fromId(int i3) {
            for (ScaleType scaleType : values()) {
                if (scaleType.mId == i3) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException(l0.j(i3, "Unknown scale type id "));
        }

        public int getId() {
            return this.mId;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class StreamState {
        public static final StreamState IDLE;
        public static final StreamState STREAMING;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StreamState[] f1580a;

        static {
            StreamState streamState = new StreamState("IDLE", 0);
            IDLE = streamState;
            StreamState streamState2 = new StreamState("STREAMING", 1);
            STREAMING = streamState2;
            f1580a = new StreamState[]{streamState, streamState2};
        }

        public static StreamState valueOf(String str) {
            return (StreamState) Enum.valueOf(StreamState.class, str);
        }

        public static StreamState[] values() {
            return (StreamState[]) f1580a.clone();
        }
    }

    public PreviewView(Context context) {
        this(context, null);
    }

    public static boolean b(f1 f1Var, ImplementationMode implementationMode) {
        boolean equals = f1Var.f18322d.h().d().equals("androidx.camera.camera2.legacy");
        boolean z5 = (j0.b.f15163a.f(SurfaceViewStretchedQuirk.class) == null && j0.b.f15163a.f(SurfaceViewNotCroppedByParentQuirk.class) == null) ? false : true;
        if (!equals && !z5) {
            int ordinal = implementationMode.ordinal();
            if (ordinal == 0) {
                return false;
            }
            if (ordinal != 1) {
                throw new IllegalArgumentException("Invalid implementation mode: " + implementationMode);
            }
        }
        return true;
    }

    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    private k0 getScreenFlashInternal() {
        return this.f1569c.getScreenFlash();
    }

    private int getViewPortScaleType() {
        int ordinal = getScaleType().ordinal();
        if (ordinal == 0) {
            return 0;
        }
        int i3 = 1;
        if (ordinal != 1) {
            i3 = 2;
            if (ordinal != 2) {
                i3 = 3;
                if (ordinal != 3 && ordinal != 4 && ordinal != 5) {
                    throw new IllegalStateException("Unexpected scale type: " + getScaleType());
                }
            }
        }
        return i3;
    }

    private void setScreenFlashUiInfo(k0 k0Var) {
        a0.a("PreviewView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public final void a() {
        Rect rect;
        Display display;
        u uVar;
        y5.a();
        if (this.f1568b != null) {
            if (this.e && (display = getDisplay()) != null && (uVar = this.f1574i) != null) {
                int f2 = uVar.f(display.getRotation());
                int rotation = display.getRotation();
                c cVar = this.f1570d;
                if (cVar.f1595g) {
                    cVar.f1592c = f2;
                    cVar.e = rotation;
                }
            }
            this.f1568b.f();
        }
        f fVar = this.f1573h;
        Size size = new Size(getWidth(), getHeight());
        int layoutDirection = getLayoutDirection();
        fVar.getClass();
        y5.a();
        synchronized (fVar) {
            try {
                if (size.getWidth() != 0 && size.getHeight() != 0 && (rect = fVar.f14226c) != null) {
                    fVar.f14227d = fVar.f14225b.a(layoutDirection, rect, size);
                    return;
                }
                fVar.f14227d = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Bitmap getBitmap() {
        Bitmap b3;
        y5.a();
        e eVar = this.f1568b;
        if (eVar == null || (b3 = eVar.b()) == null) {
            return null;
        }
        FrameLayout frameLayout = eVar.f14222b;
        Size size = new Size(frameLayout.getWidth(), frameLayout.getHeight());
        int layoutDirection = frameLayout.getLayoutDirection();
        c cVar = eVar.f14223c;
        if (!cVar.f()) {
            return b3;
        }
        Matrix d5 = cVar.d();
        RectF e = cVar.e(size, layoutDirection);
        Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), b3.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(d5);
        matrix.postScale(e.width() / cVar.f1590a.getWidth(), e.height() / cVar.f1590a.getHeight());
        matrix.postTranslate(e.left, e.top);
        canvas.drawBitmap(b3, matrix, new Paint(7));
        return createBitmap;
    }

    public h0.a getController() {
        y5.a();
        return null;
    }

    public ImplementationMode getImplementationMode() {
        y5.a();
        return this.f1567a;
    }

    public u0 getMeteringPointFactory() {
        y5.a();
        return this.f1573h;
    }

    public k0.a getOutputTransform() {
        Matrix matrix;
        c cVar = this.f1570d;
        y5.a();
        try {
            matrix = cVar.c(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrix = null;
        }
        Rect rect = cVar.f1591b;
        if (matrix == null || rect == null) {
            a0.a("PreviewView", "Transform info is not ready");
            return null;
        }
        RectF rectF = v.d.f19111a;
        RectF rectF2 = new RectF(rect);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(v.d.f19111a, rectF2, Matrix.ScaleToFit.FILL);
        matrix.preConcat(matrix2);
        if (this.f1568b instanceof l) {
            matrix.postConcat(getMatrix());
        } else if (!getMatrix().isIdentity()) {
            a0.e("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        }
        new Size(rect.width(), rect.height());
        return new k0.a();
    }

    public y getPreviewStreamState() {
        return this.f1571f;
    }

    public ScaleType getScaleType() {
        y5.a();
        return this.f1570d.f1596h;
    }

    public k0 getScreenFlash() {
        return getScreenFlashInternal();
    }

    public Matrix getSensorToViewTransform() {
        y5.a();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        Size size = new Size(getWidth(), getHeight());
        int layoutDirection = getLayoutDirection();
        c cVar = this.f1570d;
        if (!cVar.f()) {
            return null;
        }
        Matrix matrix = new Matrix(cVar.f1593d);
        matrix.postConcat(cVar.c(size, layoutDirection));
        return matrix;
    }

    public w0 getSurfaceProvider() {
        y5.a();
        return this.f1577l;
    }

    public h1 getViewPort() {
        y5.a();
        if (getDisplay() == null) {
            return null;
        }
        getDisplay().getRotation();
        y5.a();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        new Rational(getWidth(), getHeight());
        getViewPortScaleType();
        getLayoutDirection();
        return new h1();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        DisplayManager displayManager = getDisplayManager();
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.f1575j, new Handler(Looper.getMainLooper()));
        }
        addOnLayoutChangeListener(this.f1576k);
        e eVar = this.f1568b;
        if (eVar != null) {
            eVar.c();
        }
        y5.a();
        getViewPort();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.f1576k);
        e eVar = this.f1568b;
        if (eVar != null) {
            eVar.d();
        }
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.unregisterDisplayListener(this.f1575j);
    }

    public void setController(h0.a aVar) {
        y5.a();
        y5.a();
        getViewPort();
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public void setImplementationMode(ImplementationMode implementationMode) {
        y5.a();
        this.f1567a = implementationMode;
    }

    public void setScaleType(ScaleType scaleType) {
        y5.a();
        this.f1570d.f1596h = scaleType;
        a();
        y5.a();
        getViewPort();
    }

    public void setScreenFlashOverlayColor(int i3) {
        this.f1569c.setBackgroundColor(i3);
    }

    public void setScreenFlashWindow(Window window) {
        y5.a();
        this.f1569c.setScreenFlashWindow(window);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, 0);
        ImplementationMode implementationMode = f1566m;
        this.f1567a = implementationMode;
        c cVar = new c();
        cVar.f1596h = c.f1589i;
        this.f1570d = cVar;
        this.e = true;
        this.f1571f = new b0(StreamState.IDLE);
        this.f1572g = new AtomicReference();
        this.f1573h = new f(cVar);
        this.f1575j = new h0.d(this, 0);
        this.f1576k = new n(this, 2);
        this.f1577l = new d(this);
        y5.a();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.PreviewView, i3, 0);
        z0.m(this, context, R$styleable.PreviewView, attributeSet, obtainStyledAttributes, i3);
        try {
            setScaleType(ScaleType.fromId(obtainStyledAttributes.getInteger(R$styleable.PreviewView_scaleType, cVar.f1596h.getId())));
            setImplementationMode(ImplementationMode.fromId(obtainStyledAttributes.getInteger(R$styleable.PreviewView_implementationMode, implementationMode.getId())));
            obtainStyledAttributes.recycle();
            new o(context, new b9.a(this, 29));
            if (getBackground() == null) {
                setBackgroundColor(a1.d.a(getContext(), R.color.black));
            }
            ScreenFlashView screenFlashView = new ScreenFlashView(context);
            this.f1569c = screenFlashView;
            screenFlashView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
