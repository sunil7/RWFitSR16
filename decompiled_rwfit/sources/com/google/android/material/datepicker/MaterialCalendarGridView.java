package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import java.util.ArrayList;
import java.util.Calendar;
import l1.z0;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f10403a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10404b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final v a() {
        return (v) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (v) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((v) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int h4;
        int width;
        int h10;
        int width2;
        int i3;
        int i10;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        v vVar = (v) super.getAdapter();
        DateSelector dateSelector = vVar.f10473b;
        c cVar = vVar.f10475d;
        Month month = vVar.f10472a;
        Long item = vVar.getItem(month.h());
        Long item2 = vVar.getItem(vVar.b());
        ArrayList y4 = dateSelector.y();
        int size = y4.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = y4.get(i11);
            i11++;
            k1.c cVar2 = (k1.c) obj;
            Object obj2 = cVar2.f15450a;
            if (obj2 != null) {
                Object obj3 = cVar2.f15451b;
                if (obj3 != null) {
                    Long l3 = (Long) obj2;
                    long longValue = l3.longValue();
                    Long l5 = (Long) obj3;
                    long longValue2 = l5.longValue();
                    if (item == null || item2 == null || l3.longValue() > item2.longValue() || l5.longValue() < item.longValue()) {
                        materialCalendarGridView = this;
                        y4 = y4;
                        vVar = vVar;
                        month = month;
                    } else {
                        boolean d5 = gb.d(materialCalendarGridView);
                        long longValue3 = item.longValue();
                        int i12 = month.f10407c;
                        ArrayList arrayList = y4;
                        Calendar calendar = materialCalendarGridView.f10403a;
                        if (longValue < longValue3) {
                            h4 = month.h();
                            width = h4 % i12 == 0 ? 0 : !d5 ? materialCalendarGridView.getChildAt(h4 - 1).getRight() : materialCalendarGridView.getChildAt(h4 - 1).getLeft();
                        } else {
                            calendar.setTimeInMillis(longValue);
                            h4 = month.h() + (calendar.get(5) - 1);
                            View childAt = materialCalendarGridView.getChildAt(h4);
                            width = (childAt.getWidth() / 2) + childAt.getLeft();
                        }
                        if (longValue2 > item2.longValue()) {
                            h10 = Math.min(vVar.b(), materialCalendarGridView.getChildCount() - 1);
                            width2 = (h10 + 1) % i12 == 0 ? materialCalendarGridView.getWidth() : !d5 ? materialCalendarGridView.getChildAt(h10).getRight() : materialCalendarGridView.getChildAt(h10).getLeft();
                        } else {
                            calendar.setTimeInMillis(longValue2);
                            h10 = (calendar.get(5) - 1) + month.h();
                            View childAt2 = materialCalendarGridView.getChildAt(h10);
                            width2 = (childAt2.getWidth() / 2) + childAt2.getLeft();
                        }
                        int itemId = (int) vVar.getItemId(h4);
                        int itemId2 = (int) vVar.getItemId(h10);
                        while (itemId <= itemId2) {
                            int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                            v vVar2 = vVar;
                            int numColumns2 = (materialCalendarGridView.getNumColumns() + numColumns) - 1;
                            View childAt3 = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt3.getTop() + ((Rect) ((androidx.appcompat.widget.w) cVar.f10419a).f1072b).top;
                            Month month2 = month;
                            int bottom = childAt3.getBottom() - ((Rect) ((androidx.appcompat.widget.w) cVar.f10419a).f1072b).bottom;
                            if (d5) {
                                int i13 = h10 > numColumns2 ? 0 : width2;
                                int width3 = numColumns > h4 ? getWidth() : width;
                                i3 = i13;
                                i10 = width3;
                            } else {
                                i3 = numColumns > h4 ? 0 : width;
                                i10 = h10 > numColumns2 ? getWidth() : width2;
                            }
                            canvas.drawRect(i3, top, i10, bottom, (Paint) cVar.f10425h);
                            itemId++;
                            materialCalendarGridView = this;
                            vVar = vVar2;
                            month = month2;
                        }
                        materialCalendarGridView = this;
                        y4 = arrayList;
                    }
                }
            } else {
                materialCalendarGridView = this;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z5, int i3, Rect rect) {
        if (!z5) {
            super.onFocusChanged(false, i3, rect);
            return;
        }
        if (i3 == 33) {
            setSelection(((v) super.getAdapter()).b());
        } else if (i3 == 130) {
            setSelection(((v) super.getAdapter()).f10472a.h());
        } else {
            super.onFocusChanged(true, i3, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (!super.onKeyDown(i3, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((v) super.getAdapter()).f10472a.h()) {
            return true;
        }
        if (19 != i3) {
            return false;
        }
        setSelection(((v) super.getAdapter()).f10472a.h());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i3, int i10) {
        if (!this.f10404b) {
            super.onMeasure(i3, i10);
            return;
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i3) {
        if (i3 < ((v) super.getAdapter()).f10472a.h()) {
            super.setSelection(((v) super.getAdapter()).f10472a.h());
        } else {
            super.setSelection(i3);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f10403a = e0.f(null);
        if (s.Z(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.f10404b = s.Z(getContext(), R$attr.nestedScrollable);
        z0.n(this, new androidx.core.widget.j(2));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter, reason: avoid collision after fix types in other method */
    public final ListAdapter getAdapter2() {
        return (v) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof v)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), v.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
