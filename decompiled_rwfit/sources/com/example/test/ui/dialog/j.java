package com.example.test.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$style;
import com.example.test.ui.adapter.SelectListAdapter;
import java.util.ArrayList;
import n.g0;

/* loaded from: classes.dex */
public final class j extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public t6.c f7968a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, ArrayList arrayList) {
        super(context, R$style.bottom_dialog);
        kotlin.jvm.internal.e.f(context, "context");
        setContentView(R$layout.dialog_list_select);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 0;
            attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.selectList);
        SelectListAdapter selectListAdapter = new SelectListAdapter(R$layout.item_select, arrayList);
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        recyclerView.setAdapter(selectListAdapter);
        g0 g0Var = new g0(getContext());
        g0Var.e(getContext().getResources().getColor(R$color.color_3cfff));
        g0Var.f16177d = new o2.m((byte) 0, 1, 15);
        recyclerView.g(g0Var.d());
        selectListAdapter.setOnItemClickListener(new af.a(this, 6));
    }

    public final void setOnDialogSelectListener(t6.c onDialogSelectListener) {
        kotlin.jvm.internal.e.f(onDialogSelectListener, "onDialogSelectListener");
        this.f7968a = onDialogSelectListener;
    }
}
