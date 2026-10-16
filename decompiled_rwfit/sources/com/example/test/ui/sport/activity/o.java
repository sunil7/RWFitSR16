package com.example.test.ui.sport.activity;

import android.content.Intent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.example.test.ui.sport.model.SportRecordModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements OnItemClickListener, OnItemLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SportRecordActivity f8182a;

    public /* synthetic */ o(SportRecordActivity sportRecordActivity) {
        this.f8182a = sportRecordActivity;
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        int i10 = SportRecordActivity.J;
        SportRecordActivity this$0 = this.f8182a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        SportRecordModel sportRecordModel = (SportRecordModel) this$0.R0().get(i3);
        if (sportRecordModel.getType() != 0) {
            long j4 = sportRecordModel.getDetailBean().f14266a;
            Intent intent = new Intent(this$0, (Class<?>) SportRecordDetailActivity.class);
            intent.putExtra("sport_id", j4);
            this$0.startActivity(intent);
            return;
        }
        ((SportRecordModel) this$0.R0().get(i3)).setExpand(!((SportRecordModel) this$0.R0().get(i3)).isExpand());
        boolean isExpand = ((SportRecordModel) this$0.R0().get(i3)).isExpand();
        eh.b bVar = this$0.E;
        if (isExpand) {
            List list = (List) ((HashMap) bVar.getValue()).get(((SportRecordModel) this$0.R0().get(i3)).getDate());
            if (list != null) {
                this$0.R0().addAll(i3 + 1, list);
                this$0.S0().notifyDataSetChanged();
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this$0.R0().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            SportRecordModel sportRecordModel2 = (SportRecordModel) it.next();
            if (i11 > i3 && sportRecordModel2.getType() != 0) {
                arrayList.add(sportRecordModel2);
                it.remove();
            }
            if (i11 > i3 && sportRecordModel2.getType() == 0) {
                break;
            } else {
                i11++;
            }
        }
        HashMap hashMap = (HashMap) bVar.getValue();
        String date = sportRecordModel.getDate();
        kotlin.jvm.internal.e.e(date, "getDate(...)");
        hashMap.put(date, arrayList);
        this$0.S0().notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.listener.OnItemLongClickListener
    public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        int i10 = SportRecordActivity.J;
        SportRecordActivity this$0 = this.f8182a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        this$0.H = i3;
        ((com.example.test.ui.dialog.r) this$0.I.getValue()).show();
        return true;
    }
}
