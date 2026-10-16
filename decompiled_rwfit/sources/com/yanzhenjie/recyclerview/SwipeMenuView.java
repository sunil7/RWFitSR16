package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.core.impl.i1;
import androidx.recyclerview.widget.z1;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;
import og.f;
import og.k;
import og.m;
import og.o;

/* loaded from: classes2.dex */
public class SwipeMenuView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public z1 f12158a;

    /* renamed from: b, reason: collision with root package name */
    public k f12159b;

    public SwipeMenuView(Context context) {
        this(context, null);
    }

    public final void a(z1 z1Var, i1 i1Var, f fVar, k kVar) {
        removeAllViews();
        this.f12158a = z1Var;
        this.f12159b = kVar;
        ArrayList arrayList = i1Var.f1421a;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            o oVar = (o) arrayList.get(i3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(oVar.f16948c, oVar.f16949d);
            layoutParams.weight = 0;
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(i3);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            Drawable drawable = oVar.f16946a;
            WeakHashMap weakHashMap = z0.f15748a;
            h0.q(linearLayout, drawable);
            linearLayout.setOnClickListener(this);
            addView(linearLayout);
            linearLayout.setTag(new m(fVar));
            if (oVar.f16947b != null) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageDrawable(oVar.f16947b);
                linearLayout.addView(imageView);
            }
            if (!TextUtils.isEmpty(null)) {
                TextView textView = new TextView(getContext());
                textView.setText((CharSequence) null);
                textView.setGravity(17);
                linearLayout.addView(textView);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k kVar = this.f12159b;
        if (kVar != null) {
            kVar.d((m) view.getTag(), this.f12158a.getAdapterPosition());
        }
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setGravity(16);
    }
}
