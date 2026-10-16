package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final u f667a;

    /* renamed from: b, reason: collision with root package name */
    public final v f668b;

    /* renamed from: c, reason: collision with root package name */
    public final View f669c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f670d;
    public final ImageView e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f671f;

    /* renamed from: g, reason: collision with root package name */
    public l1.d f672g;

    /* renamed from: h, reason: collision with root package name */
    public final s f673h;

    /* renamed from: i, reason: collision with root package name */
    public ListPopupWindow f674i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f675j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f676k;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f677a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            de.o H = de.o.H(context, attributeSet, f677a);
            setBackgroundDrawable(H.w(0));
            H.K();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public final void a() {
        if (b()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f673h);
            }
        }
    }

    public final boolean b() {
        return getListPopupWindow().f779z.isShowing();
    }

    public q getDataModel() {
        this.f667a.getClass();
        return null;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f674i == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f674i = listPopupWindow;
            listPopupWindow.p(this.f667a);
            ListPopupWindow listPopupWindow2 = this.f674i;
            listPopupWindow2.f769o = this;
            listPopupWindow2.f778y = true;
            listPopupWindow2.f779z.setFocusable(true);
            ListPopupWindow listPopupWindow3 = this.f674i;
            v vVar = this.f668b;
            listPopupWindow3.setOnItemClickListener(vVar);
            this.f674i.setOnDismissListener(vVar);
        }
        return this.f674i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f667a.getClass();
        this.f676k = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f667a.getClass();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f673h);
        }
        if (b()) {
            a();
        }
        this.f676k = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        this.f669c.layout(0, 0, i11 - i3, i12 - i10);
        if (b()) {
            return;
        }
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        if (this.f671f.getVisibility() != 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i10), 1073741824);
        }
        View view = this.f669c;
        measureChild(view, i3, i10);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(q qVar) {
        u uVar = this.f667a;
        uVar.f1063a.f667a.getClass();
        uVar.notifyDataSetChanged();
        if (b()) {
            a();
            if (b() || !this.f676k) {
                return;
            }
            uVar.getClass();
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
    }

    public void setDefaultActionButtonContentDescription(int i3) {
    }

    public void setExpandActivityOverflowButtonContentDescription(int i3) {
        this.e.setContentDescription(getContext().getString(i3));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.e.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i3) {
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f675j = onDismissListener;
    }

    public void setProvider(l1.d dVar) {
        this.f672g = dVar;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int i10 = 0;
        new r(this, i10);
        this.f673h = new s(this, i10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActivityChooserView, i3, 0);
        l1.z0.m(this, context, R$styleable.ActivityChooserView, attributeSet, obtainStyledAttributes, i3);
        obtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, (ViewGroup) this, true);
        v vVar = new v(this);
        this.f668b = vVar;
        View findViewById = findViewById(R$id.activity_chooser_view_content);
        this.f669c = findViewById;
        findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.default_activity_button);
        this.f671f = frameLayout;
        frameLayout.setOnClickListener(vVar);
        frameLayout.setOnLongClickListener(vVar);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout2.setOnClickListener(vVar);
        frameLayout2.setAccessibilityDelegate(new t());
        frameLayout2.setOnTouchListener(new i(this, frameLayout2, 1));
        this.f670d = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R$id.image);
        this.e = imageView;
        imageView.setImageDrawable(drawable);
        u uVar = new u(this);
        this.f667a = uVar;
        uVar.registerDataSetObserver(new r(this, 1));
        Resources resources = context.getResources();
        Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }
}
