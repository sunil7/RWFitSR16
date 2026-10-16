package com.example.test.presenter.main;

import android.widget.TextView;
import com.example.blesdk.bean.sync.BreatheItemBean;
import com.example.database.db.BreatheImpl;
import com.example.database.table.DataBreathe;
import com.example.database.table.User;
import com.example.test.ui.device.adapter.BreatheItemAdapter;
import com.example.test.ui.main.fragment.BreatheDayFragment;
import com.example.test.ui.main.model.BreatheDayDataModel;
import com.example.test.ui.view.CircleProgressView;
import f6.c3;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class s extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.BreatheDayPresenter$getBreatheData$1

            public static final class a extends bc.a<ArrayList<BreatheItemBean>> {
            }

            @Override // oh.l
            public final BreatheDayDataModel invoke(String it) {
                User d5;
                String str;
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar == null || (d5 = kVar.d()) == null) {
                    return null;
                }
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                try {
                    str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                } catch (Exception e) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                    str = null;
                }
                if (str == null) {
                    return null;
                }
                BreatheImpl breatheImpl = BreatheImpl.INSTANCE;
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                String g10 = kVar2 != null ? kVar2.g() : null;
                String userId = d5.getUserId();
                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                DataBreathe dataByDate = breatheImpl.getDataByDate(g10, userId, str);
                if (dataByDate == null) {
                    return null;
                }
                BreatheDayDataModel breatheDayDataModel = new BreatheDayDataModel();
                Integer totalTime = dataByDate.getTotalTime();
                kotlin.jvm.internal.e.e(totalTime, "getTotalTime(...)");
                breatheDayDataModel.setTotalMin(totalTime.intValue());
                breatheDayDataModel.setItems(com.example.baselibrary.utils.b.h(dataByDate.getItems(), new a().f3204b));
                return breatheDayDataModel;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.BreatheDayPresenter$getBreatheData$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BreatheDayDataModel) obj);
                return eh.g.f12633a;
            }

            public final void invoke(BreatheDayDataModel breatheDayDataModel) {
                TextView textView;
                if (breatheDayDataModel != null) {
                    BreatheDayFragment breatheDayFragment = (BreatheDayFragment) ((g7.i) s.this.f7255a);
                    breatheDayFragment.getClass();
                    c3 c3Var = (c3) breatheDayFragment.f7251b;
                    if (c3Var != null) {
                        CircleProgressView circleProgressView = c3Var.f12770d;
                        int totalMin = breatheDayDataModel.getTotalMin();
                        Object obj = com.example.test.utils.m.f8734b;
                        float totalMin2 = totalMin >= 10 ? 1.0f : breatheDayDataModel.getTotalMin() / 10;
                        String valueOf = String.valueOf(breatheDayDataModel.getTotalMin());
                        circleProgressView.f8367n = totalMin2;
                        circleProgressView.f8368o = valueOf;
                        circleProgressView.f8369p = circleProgressView.f8361h.measureText(valueOf);
                        circleProgressView.invalidate();
                    }
                    List<BreatheItemBean> items = breatheDayDataModel.getItems();
                    if (items != null) {
                        eh.b bVar = breatheDayFragment.f8040d;
                        ((List) bVar.getValue()).clear();
                        ((List) bVar.getValue()).addAll(items);
                        ((BreatheItemAdapter) breatheDayFragment.e.getValue()).notifyDataSetChanged();
                        if (items.isEmpty()) {
                            c3 c3Var2 = (c3) breatheDayFragment.f7251b;
                            textView = c3Var2 != null ? c3Var2.f12769c : null;
                            if (textView == null) {
                                return;
                            }
                            textView.setVisibility(0);
                            return;
                        }
                        c3 c3Var3 = (c3) breatheDayFragment.f7251b;
                        textView = c3Var3 != null ? c3Var3.f12769c : null;
                        if (textView == null) {
                            return;
                        }
                        textView.setVisibility(8);
                    }
                }
            }
        });
    }
}
