package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class t1 extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f1050a;

    /* renamed from: b, reason: collision with root package name */
    public int f1051b;

    /* renamed from: c, reason: collision with root package name */
    public int f1052c;

    /* renamed from: d, reason: collision with root package name */
    public int f1053d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f1054f;

    /* renamed from: g, reason: collision with root package name */
    public r1 f1055g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1056h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f1057i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1058j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.core.widget.h f1059k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.activity.e f1060l;

    public t1(Context context, boolean z5) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f1050a = new Rect();
        this.f1051b = 0;
        this.f1052c = 0;
        this.f1053d = 0;
        this.e = 0;
        this.f1057i = z5;
        setCacheColorHint(0);
    }

    public final int a(int i3, int i10) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i11 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i12 = 0;
        View view = null;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = adapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            view = adapter.getView(i13, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i14 = layoutParams.height;
            view.measure(i3, i14 > 0 ? View.MeasureSpec.makeMeasureSpec(i14, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i13 > 0) {
                i11 += dividerHeight;
            }
            i11 += view.getMeasuredHeight();
            if (i11 >= i10) {
                return i10;
            }
        }
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x014a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r18, int r19) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t1.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f1050a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f1060l != null) {
            return;
        }
        super.drawableStateChanged();
        r1 r1Var = this.f1055g;
        if (r1Var != null) {
            r1Var.f1032b = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f1058j && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f1057i || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f1057i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f1057i || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f1057i && this.f1056h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f1060l = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i3 = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1060l == null) {
            androidx.activity.e eVar = new androidx.activity.e(this, 1);
            this.f1060l = eVar;
            post(eVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return onHoverEvent;
        }
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (i3 < 30 || !p1.f1023d) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                } else {
                    try {
                        p1.f1020a.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                        p1.f1021b.invoke(this, Integer.valueOf(pointToPosition));
                        p1.f1022c.invoke(this, Integer.valueOf(pointToPosition));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.f1058j && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1054f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        androidx.activity.e eVar = this.f1060l;
        if (eVar != null) {
            t1 t1Var = (t1) eVar.f360b;
            t1Var.f1060l = null;
            t1Var.removeCallbacks(eVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z5) {
        this.f1056h = z5;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        r1 r1Var = null;
        if (drawable != null) {
            r1 r1Var2 = new r1();
            Drawable drawable2 = r1Var2.f1031a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            r1Var2.f1031a = drawable;
            drawable.setCallback(r1Var2);
            r1Var2.f1032b = true;
            r1Var = r1Var2;
        }
        this.f1055g = r1Var;
        super.setSelector(r1Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1051b = rect.left;
        this.f1052c = rect.top;
        this.f1053d = rect.right;
        this.e = rect.bottom;
    }
}
