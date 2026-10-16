package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.blesdk.bean.function.ReminderModeBean;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.TRingOptionAdapter;
import com.example.test.ui.device.model.OptionModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingOptionActivity extends XXBaseActivity<com.example.test.presenter.device.w0, n1> implements f7.t {
    public static final /* synthetic */ int K = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingOptionActivity$optionType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = TRingOptionActivity.this.getIntent();
            if (intent != null) {
                return Integer.valueOf(intent.getIntExtra("option_type", 0));
            }
            return null;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingOptionActivity$isSingle$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = TRingOptionActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("is_single", false) : true);
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingOptionActivity$selectArray$2
        {
            super(0);
        }

        @Override // oh.a
        public final int[] invoke() {
            int[] intArrayExtra;
            Intent intent = TRingOptionActivity.this.getIntent();
            if (intent != null && (intArrayExtra = intent.getIntArrayExtra("select_array")) != null) {
                return intArrayExtra;
            }
            Integer S0 = TRingOptionActivity.this.S0();
            return new int[(S0 != null && S0.intValue() == 0) ? 3 : 7];
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingOptionActivity$options$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<OptionModel> invoke() {
            ArrayList arrayList = new ArrayList();
            TRingOptionActivity tRingOptionActivity = TRingOptionActivity.this;
            int i3 = TRingOptionActivity.K;
            Integer S0 = tRingOptionActivity.S0();
            if (S0 != null && S0.intValue() == 0) {
                ((n1) TRingOptionActivity.this.f7247z.getValue()).f13140c.setTitle(R$string.str_warn_model);
                OptionModel optionModel = new OptionModel();
                optionModel.setOptionStr(TRingOptionActivity.this.getString(R$string.str_vibration));
                optionModel.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[0] == 1);
                arrayList.add(optionModel);
                OptionModel optionModel2 = new OptionModel();
                optionModel2.setOptionStr(TRingOptionActivity.this.getString(R$string.str_bright));
                optionModel2.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[1] == 1);
                arrayList.add(optionModel2);
                OptionModel optionModel3 = new OptionModel();
                optionModel3.setOptionStr(String.format(Locale.ENGLISH, "%s+%s", Arrays.copyOf(new Object[]{TRingOptionActivity.this.getString(R$string.str_vibration), TRingOptionActivity.this.getString(R$string.str_bright)}, 2)));
                optionModel3.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[2] == 1);
                arrayList.add(optionModel3);
                return arrayList;
            }
            if (S0 != null && S0.intValue() == 3) {
                ((n1) TRingOptionActivity.this.f7247z.getValue()).f13140c.setTitle(R$string.str_repeat);
                OptionModel optionModel4 = new OptionModel();
                optionModel4.setOptionStr(TRingOptionActivity.this.getString(R$string.str_sunday));
                optionModel4.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[0] == 1);
                arrayList.add(optionModel4);
                OptionModel optionModel5 = new OptionModel();
                optionModel5.setOptionStr(TRingOptionActivity.this.getString(R$string.str_monday));
                optionModel5.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[1] == 1);
                arrayList.add(optionModel5);
                OptionModel optionModel6 = new OptionModel();
                optionModel6.setOptionStr(TRingOptionActivity.this.getString(R$string.str_tuesday));
                optionModel6.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[2] == 1);
                arrayList.add(optionModel6);
                OptionModel optionModel7 = new OptionModel();
                optionModel7.setOptionStr(TRingOptionActivity.this.getString(R$string.str_wednesday));
                optionModel7.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[3] == 1);
                arrayList.add(optionModel7);
                OptionModel optionModel8 = new OptionModel();
                optionModel8.setOptionStr(TRingOptionActivity.this.getString(R$string.str_thursday));
                optionModel8.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[4] == 1);
                arrayList.add(optionModel8);
                OptionModel optionModel9 = new OptionModel();
                optionModel9.setOptionStr(TRingOptionActivity.this.getString(R$string.str_friday));
                optionModel9.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[5] == 1);
                arrayList.add(optionModel9);
                OptionModel optionModel10 = new OptionModel();
                optionModel10.setOptionStr(TRingOptionActivity.this.getString(R$string.str_saturday));
                optionModel10.setCheck(TRingOptionActivity.R0(TRingOptionActivity.this)[6] == 1);
                arrayList.add(optionModel10);
            }
            return arrayList;
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingOptionActivity$optionAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final TRingOptionAdapter invoke() {
            TRingOptionActivity tRingOptionActivity = TRingOptionActivity.this;
            int i3 = TRingOptionActivity.K;
            return new TRingOptionAdapter(R$layout.ring_item_option, tRingOptionActivity.T0());
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingOptionActivity$reminderModeBean$2
        @Override // oh.a
        public final ReminderModeBean invoke() {
            return new ReminderModeBean();
        }
    });

    public static final int[] R0(TRingOptionActivity tRingOptionActivity) {
        return (int[]) tRingOptionActivity.G.getValue();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.w0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((n1) this.f7247z.getValue()).f13138a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_ring_option, (ViewGroup) null, false);
        int i3 = R$id.optionList;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.titleView;
            TitleView titleView = (TitleView) he.a(i3, inflate);
            if (titleView != null) {
                return new n1((LinearLayout) inflate, recyclerView, titleView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // f7.t
    public final void K(ReminderModeBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        ((ReminderModeBean) this.J.getValue()).setReminderMode(data.getReminderMode());
        ((OptionModel) T0().get(data.getReminderMode())).setCheck(true);
        int i3 = 0;
        for (Object obj : T0()) {
            int i10 = i3 + 1;
            if (i3 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            if (data.getReminderMode() != i3) {
                ((OptionModel) T0().get(i3)).setCheck(false);
            }
            i3 = i10;
        }
        ((TRingOptionAdapter) this.I.getValue()).notifyItemRangeChanged(0, T0().size());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        Integer S0 = S0();
        if (S0 != null && S0.intValue() == 0) {
            ((com.example.test.presenter.device.w0) I0()).l();
        }
        eh.b bVar = this.f7247z;
        ((n1) bVar.getValue()).f13139b.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView = ((n1) bVar.getValue()).f13139b;
        n.g0 g0Var = new n.g0(this);
        g0Var.e(getResources().getColor(R$color.color_3cfff));
        g0Var.f16177d = new o2.m((byte) 0, 1, 15);
        recyclerView.g(g0Var.d());
        ((n1) bVar.getValue()).f13139b.setItemAnimator(null);
        RecyclerView recyclerView2 = ((n1) bVar.getValue()).f13139b;
        eh.b bVar2 = this.I;
        recyclerView2.setAdapter((TRingOptionAdapter) bVar2.getValue());
        ((TRingOptionAdapter) bVar2.getValue()).setOnItemClickListener(new af.a(this, 11));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        ((n1) this.f7247z.getValue()).f13140c.setOnTitleListener(new k0(this));
    }

    public final Integer S0() {
        return (Integer) this.E.getValue();
    }

    public final List T0() {
        return (List) this.H.getValue();
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // f7.t
    public final void g() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.t
    public final void h() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onRemindModelEvent(EventBusBeans.DeviceReminderModelEvent reminderModelEvent) {
        ReminderModeBean reminderModeBean;
        kotlin.jvm.internal.e.f(reminderModelEvent, "reminderModelEvent");
        Integer S0 = S0();
        if (S0 == null || S0.intValue() != 0 || (reminderModeBean = reminderModelEvent.getReminderModeBean()) == null) {
            return;
        }
        K(reminderModeBean);
    }
}
