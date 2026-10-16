package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import java.util.HashMap;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;
import w0.o;

/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f10975u = 0;

    /* renamed from: s, reason: collision with root package name */
    public final ClockHandView f10976s;

    /* renamed from: t, reason: collision with root package name */
    public final MaterialButtonToggleGroup f10977t;

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addOnRotateListener(e eVar) {
        this.f10976s.addOnRotateListener(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (view == this && i3 == 0) {
            p();
        }
    }

    public final void p() {
        w0.j jVar;
        if (this.f10977t.getVisibility() == 0) {
            o oVar = new o();
            oVar.e(this);
            WeakHashMap weakHashMap = z0.f15748a;
            char c9 = i0.d(this) == 0 ? (char) 2 : (char) 1;
            int i3 = R$id.material_clock_display;
            HashMap hashMap = oVar.f19444f;
            if (hashMap.containsKey(Integer.valueOf(i3)) && (jVar = (w0.j) hashMap.get(Integer.valueOf(i3))) != null) {
                w0.k kVar = jVar.e;
                switch (c9) {
                    case 1:
                        kVar.f19383i = -1;
                        kVar.f19381h = -1;
                        kVar.F = -1;
                        kVar.M = Integer.MIN_VALUE;
                        break;
                    case 2:
                        kVar.f19386k = -1;
                        kVar.f19384j = -1;
                        kVar.G = -1;
                        kVar.O = Integer.MIN_VALUE;
                        break;
                    case 3:
                        kVar.f19390m = -1;
                        kVar.f19388l = -1;
                        kVar.H = 0;
                        kVar.N = Integer.MIN_VALUE;
                        break;
                    case 4:
                        kVar.f19392n = -1;
                        kVar.f19394o = -1;
                        kVar.I = 0;
                        kVar.P = Integer.MIN_VALUE;
                        break;
                    case 5:
                        kVar.f19396p = -1;
                        kVar.f19397q = -1;
                        kVar.r = -1;
                        kVar.L = 0;
                        kVar.S = Integer.MIN_VALUE;
                        break;
                    case 6:
                        kVar.f19398s = -1;
                        kVar.f19399t = -1;
                        kVar.K = 0;
                        kVar.R = Integer.MIN_VALUE;
                        break;
                    case 7:
                        kVar.f19400u = -1;
                        kVar.f19401v = -1;
                        kVar.J = 0;
                        kVar.Q = Integer.MIN_VALUE;
                        break;
                    case '\b':
                        kVar.B = -1.0f;
                        kVar.A = -1;
                        kVar.f19405z = -1;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown constraint");
                }
            }
            oVar.b(this);
        }
    }

    public void setOnActionUpListener(d dVar) {
        this.f10976s.setOnActionUpListener(dVar);
    }

    public void setOnDoubleTapListener(m mVar) {
    }

    public void setOnPeriodChangeListener(n nVar) {
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        i iVar = new i(this);
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.f10977t = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new j());
        Chip chip = (Chip) findViewById(R$id.material_minute_tv);
        Chip chip2 = (Chip) findViewById(R$id.material_hour_tv);
        this.f10976s = (ClockHandView) findViewById(R$id.material_clock_hand);
        l lVar = new l(new GestureDetector(getContext(), new k(this)));
        chip.setOnTouchListener(lVar);
        chip2.setOnTouchListener(lVar);
        chip.setTag(R$id.selection_type, 12);
        chip2.setTag(R$id.selection_type, 10);
        chip.setOnClickListener(iVar);
        chip2.setOnClickListener(iVar);
    }
}
