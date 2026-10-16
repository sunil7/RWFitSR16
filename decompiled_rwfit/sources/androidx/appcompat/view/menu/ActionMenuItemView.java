package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.y3;
import h.b;
import h.j;
import h.k;
import h.y;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements y, View.OnClickListener, m {

    /* renamed from: h, reason: collision with root package name */
    public h.m f578h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f579i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f580j;

    /* renamed from: k, reason: collision with root package name */
    public j f581k;

    /* renamed from: l, reason: collision with root package name */
    public i f582l;

    /* renamed from: m, reason: collision with root package name */
    public b f583m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f584n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f585o;

    /* renamed from: p, reason: collision with root package name */
    public final int f586p;

    /* renamed from: q, reason: collision with root package name */
    public int f587q;
    public final int r;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.m
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.widget.m
    public final boolean b() {
        return !TextUtils.isEmpty(getText()) && this.f578h.getIcon() == null;
    }

    @Override // h.y
    public final void d(h.m mVar) {
        this.f578h = mVar;
        setIcon(mVar.getIcon());
        setTitle(mVar.getTitleCondensed());
        setId(mVar.f14169a);
        setVisibility(mVar.isVisible() ? 0 : 8);
        setEnabled(mVar.isEnabled());
        if (mVar.hasSubMenu() && this.f582l == null) {
            this.f582l = new i(this);
        }
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i10 = configuration.screenHeightDp;
        if (i3 < 480) {
            return (i3 >= 640 && i10 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // h.y
    public h.m getItemData() {
        return this.f578h;
    }

    public final void h() {
        boolean z5 = true;
        boolean z6 = !TextUtils.isEmpty(this.f579i);
        if (this.f580j != null && ((this.f578h.f14191y & 4) != 4 || (!this.f584n && !this.f585o))) {
            z5 = false;
        }
        boolean z8 = z6 & z5;
        setText(z8 ? this.f579i : null);
        CharSequence charSequence = this.f578h.f14184q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z8 ? null : this.f578h.e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f578h.r;
        if (TextUtils.isEmpty(charSequence2)) {
            y3.a(this, z8 ? null : this.f578h.e);
        } else {
            y3.a(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        j jVar = this.f581k;
        if (jVar != null) {
            jVar.b(this.f578h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f584n = g();
        h();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i3, int i10) {
        int i11;
        boolean isEmpty = TextUtils.isEmpty(getText());
        if (!isEmpty && (i11 = this.f587q) >= 0) {
            super.setPadding(i11, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i3, i10);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int measuredWidth = getMeasuredWidth();
        int i12 = this.f586p;
        int min = mode == Integer.MIN_VALUE ? Math.min(size, i12) : i12;
        if (mode != 1073741824 && i12 > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i10);
        }
        if (!isEmpty || this.f580j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f580j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        i iVar;
        if (this.f578h.hasSubMenu() && (iVar = this.f582l) != null && iVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z5) {
    }

    public void setChecked(boolean z5) {
    }

    public void setExpandedFormat(boolean z5) {
        if (this.f585o != z5) {
            this.f585o = z5;
            h.m mVar = this.f578h;
            if (mVar != null) {
                k kVar = mVar.f14181n;
                kVar.f14153k = true;
                kVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f580j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i3 = this.r;
            if (intrinsicWidth > i3) {
                intrinsicHeight = (int) (intrinsicHeight * (i3 / intrinsicWidth));
                intrinsicWidth = i3;
            }
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (intrinsicWidth * (i3 / intrinsicHeight));
            } else {
                i3 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i3);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(j jVar) {
        this.f581k = jVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i3, int i10, int i11, int i12) {
        this.f587q = i3;
        super.setPadding(i3, i10, i11, i12);
    }

    public void setPopupCallback(b bVar) {
        this.f583m = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f579i = charSequence;
        h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Resources resources = context.getResources();
        this.f584n = g();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i3, 0);
        this.f586p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f587q = -1;
        setSaveEnabled(false);
    }
}
