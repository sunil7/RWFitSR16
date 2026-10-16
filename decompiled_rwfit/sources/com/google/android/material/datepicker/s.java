package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.t0;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import l1.k0;
import l1.n0;
import l1.z0;

/* loaded from: classes.dex */
public final class s<S> extends androidx.fragment.app.p {
    public CharSequence A;
    public boolean B;
    public int C;
    public TextView D;
    public CheckableImageButton E;
    public eb.h F;
    public Button G;

    /* renamed from: q, reason: collision with root package name */
    public final LinkedHashSet f10458q = new LinkedHashSet();
    public final LinkedHashSet r = new LinkedHashSet();

    /* renamed from: s, reason: collision with root package name */
    public final LinkedHashSet f10459s = new LinkedHashSet();

    /* renamed from: t, reason: collision with root package name */
    public final LinkedHashSet f10460t = new LinkedHashSet();

    /* renamed from: u, reason: collision with root package name */
    public int f10461u;

    /* renamed from: v, reason: collision with root package name */
    public DateSelector f10462v;

    /* renamed from: w, reason: collision with root package name */
    public z f10463w;

    /* renamed from: x, reason: collision with root package name */
    public CalendarConstraints f10464x;

    /* renamed from: y, reason: collision with root package name */
    public MaterialCalendar f10465y;

    /* renamed from: z, reason: collision with root package name */
    public int f10466z;

    public static int X(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        Month month = new Month(e0.e());
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding);
        int i3 = month.f10407c;
        return ((i3 - 1) * dimensionPixelOffset2) + (dimensionPixelSize * i3) + (dimensionPixelOffset * 2);
    }

    public static boolean Z(Context context, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(s0.b(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i3});
        boolean z5 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z5;
    }

    @Override // androidx.fragment.app.p
    public final Dialog W() {
        Context requireContext = requireContext();
        Context requireContext2 = requireContext();
        int i3 = this.f10461u;
        if (i3 == 0) {
            i3 = this.f10462v.f(requireContext2);
        }
        Dialog dialog = new Dialog(requireContext, i3);
        Context context = dialog.getContext();
        this.B = Z(context, R.attr.windowFullscreen);
        int b3 = s0.b(context, R$attr.colorSurface, s.class.getCanonicalName());
        eb.h hVar = new eb.h(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        this.F = hVar;
        hVar.j(context);
        this.F.l(ColorStateList.valueOf(b3));
        eb.h hVar2 = this.F;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = z0.f15748a;
        hVar2.k(n0.i(decorView));
        return dialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.fragment.app.Fragment, com.google.android.material.datepicker.t] */
    public final void e0() {
        Context requireContext = requireContext();
        int i3 = this.f10461u;
        if (i3 == 0) {
            i3 = this.f10462v.f(requireContext);
        }
        DateSelector dateSelector = this.f10462v;
        CalendarConstraints calendarConstraints = this.f10464x;
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.m());
        materialCalendar.setArguments(bundle);
        this.f10465y = materialCalendar;
        if (this.E.f10532d) {
            DateSelector dateSelector2 = this.f10462v;
            CalendarConstraints calendarConstraints2 = this.f10464x;
            ?? tVar = new t();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i3);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelector2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            tVar.setArguments(bundle2);
            materialCalendar = tVar;
        }
        this.f10463w = materialCalendar;
        h0();
        t0 childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(childFragmentManager);
        int i10 = R$id.mtrl_calendar_frame;
        z zVar = this.f10463w;
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        aVar.e(i10, zVar, null, 2);
        if (aVar.f2131g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        aVar.f2140p.t(aVar, false);
        this.f10463w.I(new r(this, 0));
    }

    public final void h0() {
        String e = this.f10462v.e(getContext());
        this.D.setContentDescription(String.format(getString(R$string.mtrl_picker_announce_current_selection), e));
        this.D.setText(e);
    }

    public final void m0(CheckableImageButton checkableImageButton) {
        this.E.setContentDescription(this.E.f10532d ? checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.p, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f10459s.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.p, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10461u = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f10462v = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f10464x = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f10466z = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.A = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.C = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3 = 0;
        int i10 = 1;
        View inflate = layoutInflater.inflate(this.B ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.B) {
            inflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(X(context), -2));
        } else {
            View findViewById = inflate.findViewById(R$id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R$id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(X(context), -1));
            Resources resources = requireContext().getResources();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height);
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
            int i11 = v.f10471f;
            findViewById2.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding) * (i11 - 1)) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i11) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding));
        }
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.D = textView;
        WeakHashMap weakHashMap = z0.f15748a;
        k0.f(textView, 1);
        this.E = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.A;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f10466z);
        }
        this.E.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.E;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, pb.b(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], pb.b(context, R$drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.E.setChecked(this.C != 0);
        z0.n(this.E, null);
        m0(this.E);
        this.E.setOnClickListener(new q(this, 2));
        this.G = (Button) inflate.findViewById(R$id.confirm_button);
        if (this.f10462v.A()) {
            this.G.setEnabled(true);
        } else {
            this.G.setEnabled(false);
        }
        this.G.setTag("CONFIRM_BUTTON_TAG");
        this.G.setOnClickListener(new q(this, i3));
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        button.setOnClickListener(new q(this, i10));
        return inflate;
    }

    @Override // androidx.fragment.app.p, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f10460t.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.p, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Month month;
        Month month2;
        Month month3;
        CalendarConstraints.DateValidator dateValidator;
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f10461u);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f10462v);
        CalendarConstraints calendarConstraints = this.f10464x;
        b bVar = new b();
        int i3 = b.f10414c;
        int i10 = b.f10414c;
        bVar.f10416b = new DateValidatorPointForward(Long.MIN_VALUE);
        month = calendarConstraints.start;
        long j4 = month.e;
        month2 = calendarConstraints.end;
        long j10 = month2.e;
        month3 = calendarConstraints.openAt;
        bVar.f10415a = Long.valueOf(month3.e);
        dateValidator = calendarConstraints.validator;
        bVar.f10416b = dateValidator;
        Month month4 = this.f10465y.e;
        if (month4 != null) {
            bVar.f10415a = Long.valueOf(month4.e);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dateValidator);
        Month d5 = Month.d(j4);
        Month d8 = Month.d(j10);
        CalendarConstraints.DateValidator dateValidator2 = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l3 = bVar.f10415a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(d5, d8, dateValidator2, l3 == null ? null : Month.d(l3.longValue())));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f10466z);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.A);
    }

    @Override // androidx.fragment.app.p, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = this.f2246l;
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        Window window = dialog.getWindow();
        if (this.B) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.F);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.F, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            View decorView = window.getDecorView();
            Dialog dialog2 = this.f2246l;
            if (dialog2 == null) {
                throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
            }
            decorView.setOnTouchListener(new ta.a(dialog2, rect));
        }
        e0();
    }

    @Override // androidx.fragment.app.p, androidx.fragment.app.Fragment
    public final void onStop() {
        this.f10463w.f10484a.clear();
        super.onStop();
    }
}
