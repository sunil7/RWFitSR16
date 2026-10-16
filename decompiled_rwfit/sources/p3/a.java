package p3;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.contrarywind.view.WheelView;
import com.example.baselibrary.R$anim;
import com.example.baselibrary.R$id;
import com.example.baselibrary.R$string;
import s3.d;
import s3.f;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final q3.a f17450a;

    public a(Context context, r3.a aVar) {
        q3.a aVar2 = new q3.a(1);
        this.f17450a = aVar2;
        aVar2.f17765s = context;
        aVar2.f17750b = aVar;
    }

    public final d a() {
        String str;
        String str2;
        q3.a aVar = this.f17450a;
        d dVar = new d(aVar.f17765s);
        dVar.e = aVar;
        Context context = aVar.f17765s;
        Dialog dialog = dVar.f18173j;
        if (dialog != null) {
            dialog.setCancelable(true);
        }
        dVar.b();
        int i3 = R$anim.pickerview_slide_in_bottom;
        Context context2 = dVar.f18165a;
        dVar.f18171h = AnimationUtils.loadAnimation(context2, i3);
        dVar.f18170g = AnimationUtils.loadAnimation(context2, R$anim.pickerview_slide_out_bottom);
        b9.a aVar2 = dVar.e.f17751c;
        if (aVar2 == null) {
            LayoutInflater.from(context).inflate(dVar.e.f17764q, dVar.f18166b);
            TextView textView = (TextView) dVar.f18166b.findViewById(R$id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) dVar.f18166b.findViewById(R$id.rv_topbar);
            Button button = (Button) dVar.f18166b.findViewById(R$id.btnSubmit);
            Button button2 = (Button) dVar.f18166b.findViewById(R$id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(dVar);
            button2.setOnClickListener(dVar);
            dVar.e.getClass();
            String str3 = null;
            if (TextUtils.isEmpty(null)) {
                str = context.getResources().getString(R$string.pickerview_submit);
            } else {
                dVar.e.getClass();
                str = null;
            }
            button.setText(str);
            dVar.e.getClass();
            if (TextUtils.isEmpty(null)) {
                str2 = context.getResources().getString(R$string.pickerview_cancel);
            } else {
                dVar.e.getClass();
                str2 = null;
            }
            button2.setText(str2);
            dVar.e.getClass();
            if (TextUtils.isEmpty(null)) {
                str3 = "";
            } else {
                dVar.e.getClass();
            }
            textView.setText(str3);
            dVar.e.getClass();
            button.setTextColor(-16417281);
            dVar.e.getClass();
            button2.setTextColor(-16417281);
            dVar.e.getClass();
            textView.setTextColor(-16777216);
            dVar.e.getClass();
            relativeLayout.setBackgroundColor(-657931);
            dVar.e.getClass();
            float f2 = 17;
            button.setTextSize(f2);
            dVar.e.getClass();
            button2.setTextSize(f2);
            dVar.e.getClass();
            textView.setTextSize(18);
        } else {
            LayoutInflater.from(context).inflate(dVar.e.f17764q, dVar.f18166b);
            aVar2.a();
        }
        LinearLayout linearLayout = (LinearLayout) dVar.f18166b.findViewById(R$id.optionspicker);
        linearLayout.setBackgroundColor(dVar.e.f17766t);
        dVar.e.getClass();
        f fVar = new f();
        fVar.f18178a = (WheelView) linearLayout.findViewById(R$id.options1);
        fVar.f18179b = (WheelView) linearLayout.findViewById(R$id.options2);
        fVar.f18180c = (WheelView) linearLayout.findViewById(R$id.options3);
        dVar.f18176m = fVar;
        r3.a aVar3 = dVar.e.f17750b;
        if (aVar3 != null) {
            fVar.setOptionsSelectChangeListener(aVar3);
        }
        f fVar2 = dVar.f18176m;
        dVar.e.getClass();
        float f10 = 18;
        fVar2.f18178a.setTextSize(f10);
        fVar2.f18179b.setTextSize(f10);
        fVar2.f18180c.setTextSize(f10);
        f fVar3 = dVar.f18176m;
        int i10 = dVar.e.A;
        fVar3.f18178a.setItemsVisibleCount(i10);
        fVar3.f18179b.setItemsVisibleCount(i10);
        fVar3.f18180c.setItemsVisibleCount(i10);
        f fVar4 = dVar.f18176m;
        dVar.e.getClass();
        fVar4.f18178a.setAlphaGradient(false);
        fVar4.f18179b.setAlphaGradient(false);
        fVar4.f18180c.setAlphaGradient(false);
        f fVar5 = dVar.f18176m;
        dVar.e.getClass();
        dVar.e.getClass();
        dVar.e.getClass();
        fVar5.getClass();
        f fVar6 = dVar.f18176m;
        dVar.e.getClass();
        dVar.e.getClass();
        dVar.e.getClass();
        fVar6.f18178a.setTextXOffset(0);
        fVar6.f18179b.setTextXOffset(0);
        fVar6.f18180c.setTextXOffset(0);
        f fVar7 = dVar.f18176m;
        dVar.e.getClass();
        fVar7.f18178a.setCyclic(false);
        fVar7.f18179b.setCyclic(false);
        fVar7.f18180c.setCyclic(false);
        f fVar8 = dVar.f18176m;
        Typeface typeface = dVar.e.f17771y;
        fVar8.f18178a.setTypeface(typeface);
        fVar8.f18179b.setTypeface(typeface);
        fVar8.f18180c.setTypeface(typeface);
        dVar.e.getClass();
        ViewGroup viewGroup = dVar.f18167c;
        if (viewGroup != null) {
            viewGroup.findViewById(R$id.outmost_container).setOnTouchListener(dVar.f18175l);
        }
        f fVar9 = dVar.f18176m;
        int i11 = dVar.e.f17769w;
        fVar9.f18178a.setDividerColor(i11);
        fVar9.f18179b.setDividerColor(i11);
        fVar9.f18180c.setDividerColor(i11);
        f fVar10 = dVar.f18176m;
        WheelView.DividerType dividerType = dVar.e.f17772z;
        fVar10.f18178a.setDividerType(dividerType);
        fVar10.f18179b.setDividerType(dividerType);
        fVar10.f18180c.setDividerType(dividerType);
        f fVar11 = dVar.f18176m;
        float f11 = dVar.e.f17770x;
        fVar11.f18178a.setLineSpacingMultiplier(f11);
        fVar11.f18179b.setLineSpacingMultiplier(f11);
        fVar11.f18180c.setLineSpacingMultiplier(f11);
        f fVar12 = dVar.f18176m;
        int i12 = dVar.e.f17767u;
        fVar12.f18178a.setTextColorOut(i12);
        fVar12.f18179b.setTextColorOut(i12);
        fVar12.f18180c.setTextColorOut(i12);
        f fVar13 = dVar.f18176m;
        int i13 = dVar.e.f17768v;
        fVar13.f18178a.setTextColorCenter(i13);
        fVar13.f18179b.setTextColorCenter(i13);
        fVar13.f18180c.setTextColorCenter(i13);
        f fVar14 = dVar.f18176m;
        dVar.e.getClass();
        fVar14.f18178a.f7062g = false;
        fVar14.f18179b.f7062g = false;
        fVar14.f18180c.f7062g = false;
        return dVar;
    }

    public final void b(int i3, b9.a aVar) {
        q3.a aVar2 = this.f17450a;
        aVar2.f17764q = i3;
        aVar2.f17751c = aVar;
    }
}
