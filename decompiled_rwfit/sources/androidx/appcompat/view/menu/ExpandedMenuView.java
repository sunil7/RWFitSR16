package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import de.o;
import h.j;
import h.k;
import h.m;
import h.z;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements j, z, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f588b = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public k f589a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // h.z
    public final void a(k kVar) {
        this.f589a = kVar;
    }

    @Override // h.j
    public final boolean b(m mVar) {
        return this.f589a.q(mVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j4) {
        b((m) getAdapter().getItem(i3));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        o I = o.I(context, attributeSet, f588b, i3);
        TypedArray typedArray = (TypedArray) I.f12378c;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(I.w(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(I.w(1));
        }
        I.K();
    }
}
