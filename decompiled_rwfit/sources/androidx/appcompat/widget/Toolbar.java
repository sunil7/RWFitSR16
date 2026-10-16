package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public ColorStateList A;
    public boolean B;
    public boolean C;
    public final ArrayList D;
    public final ArrayList E;
    public final int[] F;
    public final ef.i G;
    public ArrayList H;
    public final androidx.appcompat.app.t I;
    public x3 J;
    public l K;
    public r3 L;
    public boolean M;
    public OnBackInvokedCallback N;
    public OnBackInvokedDispatcher O;
    public boolean P;
    public final androidx.activity.e Q;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f836a;

    /* renamed from: b, reason: collision with root package name */
    public AppCompatTextView f837b;

    /* renamed from: c, reason: collision with root package name */
    public AppCompatTextView f838c;

    /* renamed from: d, reason: collision with root package name */
    public AppCompatImageButton f839d;
    public AppCompatImageView e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f840f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f841g;

    /* renamed from: h, reason: collision with root package name */
    public AppCompatImageButton f842h;

    /* renamed from: i, reason: collision with root package name */
    public View f843i;

    /* renamed from: j, reason: collision with root package name */
    public Context f844j;

    /* renamed from: k, reason: collision with root package name */
    public int f845k;

    /* renamed from: l, reason: collision with root package name */
    public int f846l;

    /* renamed from: m, reason: collision with root package name */
    public int f847m;

    /* renamed from: n, reason: collision with root package name */
    public final int f848n;

    /* renamed from: o, reason: collision with root package name */
    public final int f849o;

    /* renamed from: p, reason: collision with root package name */
    public int f850p;

    /* renamed from: q, reason: collision with root package name */
    public int f851q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f852s;

    /* renamed from: t, reason: collision with root package name */
    public o2 f853t;

    /* renamed from: u, reason: collision with root package name */
    public int f854u;

    /* renamed from: v, reason: collision with root package name */
    public int f855v;

    /* renamed from: w, reason: collision with root package name */
    public final int f856w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f857x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f858y;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f859z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new u3();

        /* renamed from: a, reason: collision with root package name */
        public int f860a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f861b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f860a = parcel.readInt();
            this.f861b = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f860a);
            parcel.writeInt(this.f861b ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i3 = 0; i3 < menu.size(); i3++) {
            arrayList.add(menu.getItem(i3));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new g.i(getContext());
    }

    public static s3 h() {
        s3 s3Var = new s3(-2, -2);
        s3Var.f1049b = 0;
        s3Var.f1048a = 8388627;
        return s3Var;
    }

    public static s3 i(ViewGroup.LayoutParams layoutParams) {
        boolean z5 = layoutParams instanceof s3;
        if (z5) {
            s3 s3Var = (s3) layoutParams;
            s3 s3Var2 = new s3(s3Var);
            s3Var2.f1049b = 0;
            s3Var2.f1049b = s3Var.f1049b;
            return s3Var2;
        }
        if (z5) {
            s3 s3Var3 = new s3((s3) layoutParams);
            s3Var3.f1049b = 0;
            return s3Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            s3 s3Var4 = new s3(layoutParams);
            s3Var4.f1049b = 0;
            return s3Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        s3 s3Var5 = new s3(marginLayoutParams);
        s3Var5.f1049b = 0;
        ((ViewGroup.MarginLayoutParams) s3Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) s3Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) s3Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) s3Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return s3Var5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return l1.p.b(marginLayoutParams) + l1.p.c(marginLayoutParams);
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i3, ArrayList arrayList) {
        WeakHashMap weakHashMap = l1.z0.f15748a;
        boolean z5 = l1.i0.d(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, l1.i0.d(this));
        arrayList.clear();
        if (!z5) {
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                s3 s3Var = (s3) childAt.getLayoutParams();
                if (s3Var.f1049b == 0 && s(childAt)) {
                    int i11 = s3Var.f1048a;
                    WeakHashMap weakHashMap2 = l1.z0.f15748a;
                    int d5 = l1.i0.d(this);
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i11, d5) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = d5 == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i12 = childCount - 1; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            s3 s3Var2 = (s3) childAt2.getLayoutParams();
            if (s3Var2.f1049b == 0 && s(childAt2)) {
                int i13 = s3Var2.f1048a;
                WeakHashMap weakHashMap3 = l1.z0.f15748a;
                int d8 = l1.i0.d(this);
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i13, d8) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = d8 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        s3 h4 = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (s3) layoutParams;
        h4.f1049b = 1;
        if (!z5 || this.f843i == null) {
            addView(view, h4);
        } else {
            view.setLayoutParams(h4);
            this.E.add(view);
        }
    }

    public final void c() {
        if (this.f842h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.f842h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f840f);
            this.f842h.setContentDescription(this.f841g);
            s3 h4 = h();
            h4.f1048a = (this.f848n & 112) | 8388611;
            h4.f1049b = 2;
            this.f842h.setLayoutParams(h4);
            this.f842h.setOnClickListener(new androidx.appcompat.app.c(this, 2));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof s3);
    }

    public final void d() {
        if (this.f853t == null) {
            o2 o2Var = new o2();
            o2Var.f1013a = 0;
            o2Var.f1014b = 0;
            o2Var.f1015c = Integer.MIN_VALUE;
            o2Var.f1016d = Integer.MIN_VALUE;
            o2Var.e = 0;
            o2Var.f1017f = 0;
            o2Var.f1018g = false;
            o2Var.f1019h = false;
            this.f853t = o2Var;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f836a;
        if (actionMenuView.f657p == null) {
            h.k kVar = (h.k) actionMenuView.getMenu();
            if (this.L == null) {
                this.L = new r3(this);
            }
            this.f836a.setExpandedActionViewsExclusive(true);
            kVar.b(this.L, this.f844j);
            t();
        }
    }

    public final void f() {
        if (this.f836a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f836a = actionMenuView;
            actionMenuView.setPopupTheme(this.f845k);
            this.f836a.setOnMenuItemClickListener(this.I);
            ActionMenuView actionMenuView2 = this.f836a;
            a2.d dVar = new a2.d(this, 2);
            actionMenuView2.getClass();
            actionMenuView2.f661u = dVar;
            s3 h4 = h();
            h4.f1048a = (this.f848n & 112) | 8388613;
            this.f836a.setLayoutParams(h4);
            b(this.f836a, false);
        }
    }

    public final void g() {
        if (this.f839d == null) {
            this.f839d = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            s3 h4 = h();
            h4.f1048a = (this.f848n & 112) | 8388611;
            this.f839d.setLayoutParams(h4);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f842h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        AppCompatImageButton appCompatImageButton = this.f842h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        o2 o2Var = this.f853t;
        if (o2Var != null) {
            return o2Var.f1018g ? o2Var.f1013a : o2Var.f1014b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i3 = this.f855v;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        o2 o2Var = this.f853t;
        if (o2Var != null) {
            return o2Var.f1013a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        o2 o2Var = this.f853t;
        if (o2Var != null) {
            return o2Var.f1014b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        o2 o2Var = this.f853t;
        if (o2Var != null) {
            return o2Var.f1018g ? o2Var.f1014b : o2Var.f1013a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i3 = this.f854u;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        h.k kVar;
        ActionMenuView actionMenuView = this.f836a;
        return (actionMenuView == null || (kVar = actionMenuView.f657p) == null || !kVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f855v, 0));
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = l1.z0.f15748a;
        return l1.i0.d(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = l1.z0.f15748a;
        return l1.i0.d(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f854u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.e;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.e;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f836a.getMenu();
    }

    public View getNavButtonView() {
        return this.f839d;
    }

    public CharSequence getNavigationContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f839d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        AppCompatImageButton appCompatImageButton = this.f839d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public l getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f836a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f844j;
    }

    public int getPopupTheme() {
        return this.f845k;
    }

    public CharSequence getSubtitle() {
        return this.f858y;
    }

    public final TextView getSubtitleTextView() {
        return this.f838c;
    }

    public CharSequence getTitle() {
        return this.f857x;
    }

    public int getTitleMarginBottom() {
        return this.f852s;
    }

    public int getTitleMarginEnd() {
        return this.f851q;
    }

    public int getTitleMarginStart() {
        return this.f850p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    public final TextView getTitleTextView() {
        return this.f837b;
    }

    public k1 getWrapper() {
        Drawable drawable;
        if (this.J == null) {
            int i3 = R$string.abc_action_bar_up_description;
            x3 x3Var = new x3();
            x3Var.f1121n = 0;
            x3Var.f1109a = this;
            x3Var.f1115h = getTitle();
            x3Var.f1116i = getSubtitle();
            x3Var.f1114g = x3Var.f1115h != null;
            x3Var.f1113f = getNavigationIcon();
            de.o I = de.o.I(getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle);
            x3Var.f1122o = I.w(R$styleable.ActionBar_homeAsUpIndicator);
            int i10 = R$styleable.ActionBar_title;
            TypedArray typedArray = (TypedArray) I.f12378c;
            CharSequence text = typedArray.getText(i10);
            if (!TextUtils.isEmpty(text)) {
                x3Var.f1114g = true;
                x3Var.f1115h = text;
                if ((x3Var.f1110b & 8) != 0) {
                    Toolbar toolbar = x3Var.f1109a;
                    toolbar.setTitle(text);
                    if (x3Var.f1114g) {
                        l1.z0.o(toolbar.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                x3Var.f1116i = text2;
                if ((x3Var.f1110b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable w8 = I.w(R$styleable.ActionBar_logo);
            if (w8 != null) {
                x3Var.e = w8;
                x3Var.c();
            }
            Drawable w9 = I.w(R$styleable.ActionBar_icon);
            if (w9 != null) {
                x3Var.f1112d = w9;
                x3Var.c();
            }
            if (x3Var.f1113f == null && (drawable = x3Var.f1122o) != null) {
                x3Var.f1113f = drawable;
                int i11 = x3Var.f1110b & 4;
                Toolbar toolbar2 = x3Var.f1109a;
                if (i11 != 0) {
                    toolbar2.setNavigationIcon(drawable);
                } else {
                    toolbar2.setNavigationIcon((Drawable) null);
                }
            }
            x3Var.a(typedArray.getInt(R$styleable.ActionBar_displayOptions, 0));
            int resourceId = typedArray.getResourceId(R$styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = x3Var.f1111c;
                if (view != null && (x3Var.f1110b & 16) != 0) {
                    removeView(view);
                }
                x3Var.f1111c = inflate;
                if (inflate != null && (x3Var.f1110b & 16) != 0) {
                    addView(inflate);
                }
                x3Var.a(x3Var.f1110b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(R$styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(R$styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(R$styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                d();
                this.f853t.a(max, max2);
            }
            int resourceId2 = typedArray.getResourceId(R$styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.f846l = resourceId2;
                AppCompatTextView appCompatTextView = this.f837b;
                if (appCompatTextView != null) {
                    appCompatTextView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.f847m = resourceId3;
                AppCompatTextView appCompatTextView2 = this.f838c;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(R$styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            I.K();
            if (i3 != x3Var.f1121n) {
                x3Var.f1121n = i3;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i12 = x3Var.f1121n;
                    x3Var.f1117j = i12 != 0 ? getContext().getString(i12) : null;
                    x3Var.b();
                }
            }
            x3Var.f1117j = getNavigationContentDescription();
            setNavigationOnClickListener(new v3(x3Var));
            this.J = x3Var;
        }
        return this.J;
    }

    public final int j(int i3, View view) {
        s3 s3Var = (s3) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i10 = i3 > 0 ? (measuredHeight - i3) / 2 : 0;
        int i11 = s3Var.f1048a & 112;
        if (i11 != 16 && i11 != 48 && i11 != 80) {
            i11 = this.f856w & 112;
        }
        if (i11 == 48) {
            return getPaddingTop() - i10;
        }
        if (i11 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) s3Var).bottomMargin) - i10;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i12 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = ((ViewGroup.MarginLayoutParams) s3Var).topMargin;
        if (i12 < i13) {
            i12 = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - i12) - paddingTop;
            int i15 = ((ViewGroup.MarginLayoutParams) s3Var).bottomMargin;
            if (i14 < i15) {
                i12 = Math.max(0, i12 - (i15 - i14));
            }
        }
        return paddingTop + i12;
    }

    public final void m() {
        ArrayList arrayList = this.H;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.G.f12630c).iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.H = currentMenuItems2;
    }

    public final boolean n(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    public final int o(View view, int i3, int i10, int[] iArr) {
        s3 s3Var = (s3) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) s3Var).leftMargin - iArr[0];
        int max = Math.max(0, i11) + i3;
        iArr[0] = Math.max(0, -i11);
        int j4 = j(i10, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, j4, max + measuredWidth, view.getMeasuredHeight() + j4);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) s3Var).rightMargin + max;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Q);
        t();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.C = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0295 A[LOOP:0: B:40:0x0293->B:41:0x0295, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02ad A[LOOP:1: B:44:0x02ab->B:45:0x02ad, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02cd A[LOOP:2: B:48:0x02cb->B:49:0x02cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0321 A[LOOP:3: B:57:0x031f->B:58:0x0321, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021c  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean a3 = b4.a(this);
        int i18 = !a3 ? 1 : 0;
        int i19 = 0;
        if (s(this.f839d)) {
            r(this.f839d, i3, 0, i10, this.f849o);
            i11 = k(this.f839d) + this.f839d.getMeasuredWidth();
            i12 = Math.max(0, l(this.f839d) + this.f839d.getMeasuredHeight());
            i13 = View.combineMeasuredStates(0, this.f839d.getMeasuredState());
        } else {
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        if (s(this.f842h)) {
            r(this.f842h, i3, 0, i10, this.f849o);
            i11 = k(this.f842h) + this.f842h.getMeasuredWidth();
            i12 = Math.max(i12, l(this.f842h) + this.f842h.getMeasuredHeight());
            i13 = View.combineMeasuredStates(i13, this.f842h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i11);
        int max2 = Math.max(0, currentContentInsetStart - i11);
        int[] iArr = this.F;
        iArr[a3 ? 1 : 0] = max2;
        if (s(this.f836a)) {
            r(this.f836a, i3, max, i10, this.f849o);
            i14 = k(this.f836a) + this.f836a.getMeasuredWidth();
            i12 = Math.max(i12, l(this.f836a) + this.f836a.getMeasuredHeight());
            i13 = View.combineMeasuredStates(i13, this.f836a.getMeasuredState());
        } else {
            i14 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i14);
        iArr[i18] = Math.max(0, currentContentInsetEnd - i14);
        if (s(this.f843i)) {
            max3 += q(this.f843i, i3, max3, i10, 0, iArr);
            i12 = Math.max(i12, l(this.f843i) + this.f843i.getMeasuredHeight());
            i13 = View.combineMeasuredStates(i13, this.f843i.getMeasuredState());
        }
        if (s(this.e)) {
            max3 += q(this.e, i3, max3, i10, 0, iArr);
            i12 = Math.max(i12, l(this.e) + this.e.getMeasuredHeight());
            i13 = View.combineMeasuredStates(i13, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (((s3) childAt.getLayoutParams()).f1049b == 0 && s(childAt)) {
                max3 += q(childAt, i3, max3, i10, 0, iArr);
                int max4 = Math.max(i12, l(childAt) + childAt.getMeasuredHeight());
                i13 = View.combineMeasuredStates(i13, childAt.getMeasuredState());
                i12 = max4;
            } else {
                max3 = max3;
            }
        }
        int i21 = max3;
        int i22 = this.r + this.f852s;
        int i23 = this.f850p + this.f851q;
        if (s(this.f837b)) {
            q(this.f837b, i3, i21 + i23, i10, i22, iArr);
            int k10 = k(this.f837b) + this.f837b.getMeasuredWidth();
            i15 = l(this.f837b) + this.f837b.getMeasuredHeight();
            i16 = View.combineMeasuredStates(i13, this.f837b.getMeasuredState());
            i17 = k10;
        } else {
            i15 = 0;
            i16 = i13;
            i17 = 0;
        }
        if (s(this.f838c)) {
            i17 = Math.max(i17, q(this.f838c, i3, i21 + i23, i10, i22 + i15, iArr));
            i15 += l(this.f838c) + this.f838c.getMeasuredHeight();
            i16 = View.combineMeasuredStates(i16, this.f838c.getMeasuredState());
        }
        int max5 = Math.max(i12, i15);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i21 + i17;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max5;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i3, (-16777216) & i16);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i10, i16 << 16);
        if (this.M) {
            int childCount2 = getChildCount();
            for (int i24 = 0; i24 < childCount2; i24++) {
                View childAt2 = getChildAt(i24);
                if (!s(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i19);
        }
        i19 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i19);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f836a;
        h.k kVar = actionMenuView != null ? actionMenuView.f657p : null;
        int i3 = savedState.f860a;
        if (i3 != 0 && this.L != null && kVar != null && (findItem = kVar.findItem(i3)) != null) {
            findItem.expandActionView();
        }
        if (savedState.f861b) {
            androidx.activity.e eVar = this.Q;
            removeCallbacks(eVar);
            post(eVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        d();
        o2 o2Var = this.f853t;
        boolean z5 = i3 == 1;
        if (z5 == o2Var.f1018g) {
            return;
        }
        o2Var.f1018g = z5;
        if (!o2Var.f1019h) {
            o2Var.f1013a = o2Var.e;
            o2Var.f1014b = o2Var.f1017f;
            return;
        }
        if (z5) {
            int i10 = o2Var.f1016d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = o2Var.e;
            }
            o2Var.f1013a = i10;
            int i11 = o2Var.f1015c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = o2Var.f1017f;
            }
            o2Var.f1014b = i11;
            return;
        }
        int i12 = o2Var.f1015c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = o2Var.e;
        }
        o2Var.f1013a = i12;
        int i13 = o2Var.f1016d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = o2Var.f1017f;
        }
        o2Var.f1014b = i13;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        l lVar;
        h.m mVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        r3 r3Var = this.L;
        if (r3Var != null && (mVar = r3Var.f1037b) != null) {
            savedState.f860a = mVar.f14169a;
        }
        ActionMenuView actionMenuView = this.f836a;
        savedState.f861b = (actionMenuView == null || (lVar = actionMenuView.f660t) == null || !lVar.f()) ? false : true;
        return savedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.B = false;
        return true;
    }

    public final int p(View view, int i3, int i10, int[] iArr) {
        s3 s3Var = (s3) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) s3Var).rightMargin - iArr[1];
        int max = i3 - Math.max(0, i11);
        iArr[1] = Math.max(0, -i11);
        int j4 = j(i10, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, j4, max, view.getMeasuredHeight() + j4);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) s3Var).leftMargin);
    }

    public final int q(View view, int i3, int i10, int i11, int i12, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i13 = marginLayoutParams.leftMargin - iArr[0];
        int i14 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i14) + Math.max(0, i13);
        iArr[0] = Math.max(0, -i13);
        iArr[1] = Math.max(0, -i14);
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft() + max + i10, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i12, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void r(View view, int i3, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i12 >= 0) {
            if (mode != 0) {
                i12 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i12);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean s(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setBackInvokedCallbackEnabled(boolean z5) {
        if (this.P != z5) {
            this.P = z5;
            t();
        }
    }

    public void setCollapseContentDescription(int i3) {
        setCollapseContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setCollapseIcon(int i3) {
        setCollapseIcon(pb.b(getContext(), i3));
    }

    public void setCollapsible(boolean z5) {
        this.M = z5;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f855v) {
            this.f855v = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f854u) {
            this.f854u = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i3) {
        setLogo(pb.b(getContext(), i3));
    }

    public void setLogoDescription(int i3) {
        setLogoDescription(getContext().getText(i3));
    }

    public void setNavigationContentDescription(int i3) {
        setNavigationContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setNavigationIcon(int i3) {
        setNavigationIcon(pb.b(getContext(), i3));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f839d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(t3 t3Var) {
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f836a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i3) {
        if (this.f845k != i3) {
            this.f845k = i3;
            if (i3 == 0) {
                this.f844j = getContext();
            } else {
                this.f844j = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setSubtitle(int i3) {
        setSubtitle(getContext().getText(i3));
    }

    public void setSubtitleTextColor(int i3) {
        setSubtitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setTitle(int i3) {
        setTitle(getContext().getText(i3));
    }

    public void setTitleMarginBottom(int i3) {
        this.f852s = i3;
        requestLayout();
    }

    public void setTitleMarginEnd(int i3) {
        this.f851q = i3;
        requestLayout();
    }

    public void setTitleMarginStart(int i3) {
        this.f850p = i3;
        requestLayout();
    }

    public void setTitleMarginTop(int i3) {
        this.r = i3;
        requestLayout();
    }

    public void setTitleTextColor(int i3) {
        setTitleTextColor(ColorStateList.valueOf(i3));
    }

    public final void t() {
        boolean z5;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a3 = q3.a(this);
            r3 r3Var = this.L;
            if (r3Var != null && r3Var.f1037b != null && a3 != null) {
                WeakHashMap weakHashMap = l1.z0.f15748a;
                if (l1.k0.b(this) && this.P) {
                    z5 = true;
                    if (!z5 && this.O == null) {
                        if (this.N == null) {
                            this.N = q3.b(new p3(this, i3));
                        }
                        q3.c(a3, this.N);
                        this.O = a3;
                        return;
                    }
                    if (!z5 || (onBackInvokedDispatcher = this.O) == null) {
                    }
                    q3.d(onBackInvokedDispatcher, this.N);
                    this.O = null;
                    return;
                }
            }
            z5 = false;
            if (!z5) {
            }
            if (z5) {
            }
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        s3 s3Var = new s3(context, attributeSet);
        s3Var.f1048a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
        s3Var.f1048a = obtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
        obtainStyledAttributes.recycle();
        s3Var.f1049b = 0;
        return s3Var;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        AppCompatImageButton appCompatImageButton = this.f842h;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f842h.setImageDrawable(drawable);
        } else {
            AppCompatImageButton appCompatImageButton = this.f842h;
            if (appCompatImageButton != null) {
                appCompatImageButton.setImageDrawable(this.f840f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.e == null) {
                this.e = new AppCompatImageView(getContext());
            }
            if (!n(this.e)) {
                b(this.e, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.e;
            if (appCompatImageView != null && n(appCompatImageView)) {
                removeView(this.e);
                this.E.remove(this.e);
            }
        }
        AppCompatImageView appCompatImageView2 = this.e;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.e == null) {
            this.e = new AppCompatImageView(getContext());
        }
        AppCompatImageView appCompatImageView = this.e;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        AppCompatImageButton appCompatImageButton = this.f839d;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
            y3.a(this.f839d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!n(this.f839d)) {
                b(this.f839d, true);
            }
        } else {
            AppCompatImageButton appCompatImageButton = this.f839d;
            if (appCompatImageButton != null && n(appCompatImageButton)) {
                removeView(this.f839d);
                this.E.remove(this.f839d);
            }
        }
        AppCompatImageButton appCompatImageButton2 = this.f839d;
        if (appCompatImageButton2 != null) {
            appCompatImageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f838c;
            if (appCompatTextView != null && n(appCompatTextView)) {
                removeView(this.f838c);
                this.E.remove(this.f838c);
            }
        } else {
            if (this.f838c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.f838c = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f838c.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f847m;
                if (i3 != 0) {
                    this.f838c.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f838c.setTextColor(colorStateList);
                }
            }
            if (!n(this.f838c)) {
                b(this.f838c, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f838c;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f858y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        AppCompatTextView appCompatTextView = this.f838c;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f837b;
            if (appCompatTextView != null && n(appCompatTextView)) {
                removeView(this.f837b);
                this.E.remove(this.f837b);
            }
        } else {
            if (this.f837b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.f837b = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f837b.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f846l;
                if (i3 != 0) {
                    this.f837b.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.f859z;
                if (colorStateList != null) {
                    this.f837b.setTextColor(colorStateList);
                }
            }
            if (!n(this.f837b)) {
                b(this.f837b, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f837b;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f857x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f859z = colorStateList;
        AppCompatTextView appCompatTextView = this.f837b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f856w = 8388627;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.G = new ef.i(new p3(this, 1));
        this.H = new ArrayList();
        int i10 = 2;
        this.I = new androidx.appcompat.app.t(this, i10);
        this.Q = new androidx.activity.e(this, i10);
        de.o I = de.o.I(getContext(), attributeSet, R$styleable.Toolbar, i3);
        l1.z0.m(this, context, R$styleable.Toolbar, attributeSet, (TypedArray) I.f12378c, i3);
        int i11 = R$styleable.Toolbar_titleTextAppearance;
        TypedArray typedArray = (TypedArray) I.f12378c;
        this.f846l = typedArray.getResourceId(i11, 0);
        this.f847m = typedArray.getResourceId(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.f856w = typedArray.getInteger(R$styleable.Toolbar_android_gravity, 8388627);
        this.f848n = typedArray.getInteger(R$styleable.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(R$styleable.Toolbar_titleMargin, 0);
        dimensionPixelOffset = typedArray.hasValue(R$styleable.Toolbar_titleMargins) ? typedArray.getDimensionPixelOffset(R$styleable.Toolbar_titleMargins, dimensionPixelOffset) : dimensionPixelOffset;
        this.f852s = dimensionPixelOffset;
        this.r = dimensionPixelOffset;
        this.f851q = dimensionPixelOffset;
        this.f850p = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f850p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f851q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f852s = dimensionPixelOffset5;
        }
        this.f849o = typedArray.getDimensionPixelSize(R$styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R$styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R$styleable.Toolbar_contentInsetRight, 0);
        d();
        o2 o2Var = this.f853t;
        o2Var.f1019h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            o2Var.e = dimensionPixelSize;
            o2Var.f1013a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            o2Var.f1017f = dimensionPixelSize2;
            o2Var.f1014b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            o2Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f854u = typedArray.getDimensionPixelOffset(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f855v = typedArray.getDimensionPixelOffset(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f840f = I.w(R$styleable.Toolbar_collapseIcon);
        this.f841g = typedArray.getText(R$styleable.Toolbar_collapseContentDescription);
        CharSequence text = typedArray.getText(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f844j = getContext();
        setPopupTheme(typedArray.getResourceId(R$styleable.Toolbar_popupTheme, 0));
        Drawable w8 = I.w(R$styleable.Toolbar_navigationIcon);
        if (w8 != null) {
            setNavigationIcon(w8);
        }
        CharSequence text3 = typedArray.getText(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable w9 = I.w(R$styleable.Toolbar_logo);
        if (w9 != null) {
            setLogo(w9);
        }
        CharSequence text4 = typedArray.getText(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(R$styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(I.v(R$styleable.Toolbar_titleTextColor));
        }
        if (typedArray.hasValue(R$styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(I.v(R$styleable.Toolbar_subtitleTextColor));
        }
        if (typedArray.hasValue(R$styleable.Toolbar_menu)) {
            getMenuInflater().inflate(typedArray.getResourceId(R$styleable.Toolbar_menu, 0), getMenu());
        }
        I.K();
    }
}
