package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.appcompat.app.c;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import g9.k0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final CheckedTextView f9048a;

    /* renamed from: b, reason: collision with root package name */
    public final CheckedTextView f9049b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f9050c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9051d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9052f;

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public final void a() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount < 3) {
                this.f9048a.setEnabled(false);
                this.f9049b.setEnabled(false);
                return;
            }
            removeViewAt(childCount);
        }
    }

    public boolean getIsDisabled() {
        return this.f9052f;
    }

    public List<DefaultTrackSelector$SelectionOverride> getOverrides() {
        SparseArray sparseArray = this.f9050c;
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            arrayList.add((DefaultTrackSelector$SelectionOverride) sparseArray.valueAt(i3));
        }
        return arrayList;
    }

    public void setAllowAdaptiveSelections(boolean z5) {
        if (this.f9051d != z5) {
            this.f9051d = z5;
            a();
        }
    }

    public void setAllowMultipleOverrides(boolean z5) {
        if (this.e != z5) {
            this.e = z5;
            if (!z5) {
                SparseArray sparseArray = this.f9050c;
                if (sparseArray.size() > 1) {
                    for (int size = sparseArray.size() - 1; size > 0; size--) {
                        sparseArray.remove(size);
                    }
                }
            }
            a();
        }
    }

    public void setShowDisableOption(boolean z5) {
        this.f9048a.setVisibility(z5 ? 0 : 8);
    }

    public void setTrackNameProvider(k0 k0Var) {
        k0Var.getClass();
        a();
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setOrientation(1);
        this.f9050c = new SparseArray();
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        c cVar = new c(this, 9);
        getResources().getClass();
        TrackGroupArray trackGroupArray = TrackGroupArray.EMPTY;
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f9048a = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(cVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f9049b = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R$string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(cVar);
        addView(checkedTextView2);
    }
}
