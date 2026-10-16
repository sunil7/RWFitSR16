package com.example.test.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import f6.d1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class PersonalJLActivity extends XXBaseActivity<com.example.test.presenter.mine.m, d1> implements h7.h, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public int F;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$currentLoggedUser$2
        @Override // oh.a
        public final User invoke() {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                return kVar.d();
            }
            return null;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$permissionTipDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.i invoke() {
            com.example.test.ui.dialog.i iVar = new com.example.test.ui.dialog.i(PersonalJLActivity.this, 1);
            iVar.setOnDialogListener(new t(PersonalJLActivity.this));
            iVar.setCancelable(false);
            return iVar;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$selectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.j invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(PersonalJLActivity.this.getString(R$string.str_take_photo));
            arrayList.add(PersonalJLActivity.this.getString(R$string.str_album));
            arrayList.add(PersonalJLActivity.this.getString(R$string.str_cancel));
            com.example.test.ui.dialog.j jVar = new com.example.test.ui.dialog.j(PersonalJLActivity.this, arrayList);
            jVar.setOnDialogSelectListener(new r(jVar, PersonalJLActivity.this, 1));
            return jVar;
        }
    });

    public static final d1 R0(PersonalJLActivity personalJLActivity) {
        return (d1) personalJLActivity.f7247z.getValue();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.m(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((d1) this.f7247z.getValue()).f12779a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return d1.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.mine.m) I0()).k();
        eh.b bVar = this.f7247z;
        ImageView imageView = ((d1) bVar.getValue()).f12780b;
        int i3 = R$mipmap.ic_avatar;
        User S0 = S0();
        String str = null;
        String avatar = S0 != null ? S0.getAvatar() : null;
        if (avatar == null) {
            avatar = "";
        }
        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).n(avatar).o(true)).d(z3.h.f20239b)).i(i3), i3)).x(imageView);
        ActionItemView actionItemView = ((d1) bVar.getValue()).f12783f;
        User S02 = S0();
        String name = S02 != null ? S02.getName() : null;
        if (name == null) {
            name = getString(R$string.str_unset);
            kotlin.jvm.internal.e.e(name, "getString(...)");
        }
        actionItemView.setHintStr(name);
        if (S0() == null) {
            ActionItemView actionItemView2 = ((d1) bVar.getValue()).f12784g;
            String string = getString(R$string.str_man);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            actionItemView2.setHintStr(string);
            ActionItemView actionItemView3 = ((d1) bVar.getValue()).f12782d;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                str = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(currentTimeMillis));
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(currentTimeMillis, " date translate error ", e.getMessage()));
            }
            actionItemView3.setHintStr(str != null ? str : "");
            ActionItemView actionItemView4 = ((d1) bVar.getValue()).e;
            Locale locale = Locale.ENGLISH;
            android.support.v4.media.session.e.B(new Object[]{170, getString(R$string.str_metric_unit_height)}, 2, locale, "%d%s", actionItemView4);
            android.support.v4.media.session.e.B(new Object[]{Double.valueOf(60.0d), getString(R$string.str_metric_unit_weight)}, 2, locale, "%d%s", ((d1) bVar.getValue()).f12787j);
            android.support.v4.media.session.e.B(new Object[]{5000, getString(R$string.str_unit_step)}, 2, locale, "%d%s", ((d1) bVar.getValue()).f12785h);
            return;
        }
        User S03 = S0();
        if (S03 != null) {
            ActionItemView actionItemView5 = ((d1) bVar.getValue()).f12784g;
            String string2 = getString(S03.getSex() == 1 ? R$string.str_man : R$string.str_woman);
            kotlin.jvm.internal.e.c(string2);
            actionItemView5.setHintStr(string2);
            ActionItemView actionItemView6 = ((d1) bVar.getValue()).f12782d;
            String birthday = S03.getBirthday();
            kotlin.jvm.internal.e.e(birthday, "getBirthday(...)");
            long parseLong = Long.parseLong(birthday) * 1000;
            try {
                str = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(parseLong));
            } catch (Exception e10) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(parseLong, " date translate error ", e10.getMessage()));
            }
            actionItemView6.setHintStr(str != null ? str : "");
            if (S03.getStepsTarget() == 0) {
                S03.setStepsTarget(Const.I_GEO_MAX_TIME);
            }
            ActionItemView actionItemView7 = ((d1) bVar.getValue()).f12785h;
            Locale locale2 = Locale.ENGLISH;
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S03.getStepsTarget()), getString(R$string.str_unit_step)}, 2, locale2, "%d%s", actionItemView7);
            if (S03.getMeterUnit() == 0) {
                android.support.v4.media.session.e.B(new Object[]{Integer.valueOf((int) S03.getHeight()), getString(R$string.str_metric_unit_height)}, 2, locale2, "%d%s", ((d1) bVar.getValue()).e);
                android.support.v4.media.session.e.B(new Object[]{Float.valueOf((float) S03.getWeight()), getString(R$string.str_metric_unit_weight)}, 2, locale2, "%.1f%s", ((d1) bVar.getValue()).f12787j);
            } else {
                android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(com.google.android.gms.internal.mlkit_vision_common.r.a(((float) S03.getHeight()) * 0.393701f)), getString(R$string.str_imperial_unit_height)}, 2, locale2, "%d%s", ((d1) bVar.getValue()).e);
                android.support.v4.media.session.e.B(new Object[]{Float.valueOf(((float) S03.getWeight()) * 2.205f), getString(R$string.str_imperial_unit_weight)}, 2, locale2, "%.1f%s", ((d1) bVar.getValue()).f12787j);
            }
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.x()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            ((d1) this.f7247z.getValue()).f12785h.setVisibility(4);
        }
        ((d1) this.f7247z.getValue()).f12786i.setOnTitleListener(new t(this));
        ((d1) this.f7247z.getValue()).f12783f.setOnClickListener(this);
        ((d1) this.f7247z.getValue()).f12782d.setOnClickListener(this);
        ((d1) this.f7247z.getValue()).f12784g.setOnClickListener(this);
        ((d1) this.f7247z.getValue()).e.setOnClickListener(this);
        ((d1) this.f7247z.getValue()).f12787j.setOnClickListener(this);
        ((d1) this.f7247z.getValue()).f12785h.setOnClickListener(this);
        ((d1) this.f7247z.getValue()).f12781c.setOnClickListener(this);
    }

    public final User S0() {
        return (User) this.E.getValue();
    }

    public final com.example.test.ui.dialog.j T0() {
        return (com.example.test.ui.dialog.j) this.H.getValue();
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // h7.h
    public final void k() {
        Log.d("tong", "----onUserInfoSuccess----");
        b0();
        yh.d.b().e(S0());
        User S0 = S0();
        if (S0 != null) {
            User S02 = S0();
            Log.d("tong", "new name = " + (S02 != null ? S02.getName() : null));
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.G(S0);
            }
            yh.d.b().e(new EventBusBeans.UnitEvent(99));
        }
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        int a3;
        int sex;
        long parseLong;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i10 = R$id.nickNameAv;
        int i11 = 0;
        if (valueOf != null && valueOf.intValue() == i10) {
            User S0 = S0();
            String name = S0 != null ? S0.getName() : null;
            if (name == null) {
                name = "";
            }
            Intent intent = new Intent(this, (Class<?>) InputActivity.class);
            intent.putExtra(AeUtil.ROOT_DATA_PATH_OLD_NAME, name);
            intent.putExtra("data_type", 0);
            startActivity(intent);
            return;
        }
        int i12 = R$id.birthdayAv;
        if (valueOf != null && valueOf.intValue() == i12) {
            if (S0() == null) {
                parseLong = System.currentTimeMillis();
            } else {
                User S02 = S0();
                kotlin.jvm.internal.e.c(S02);
                String birthday = S02.getBirthday();
                kotlin.jvm.internal.e.e(birthday, "getBirthday(...)");
                parseLong = 1000 * Long.parseLong(birthday);
            }
            Intent intent2 = new Intent(this, (Class<?>) SelectActivity.class);
            intent2.putExtra("select_type", 1);
            intent2.putExtra("option_date", parseLong);
            startActivity(intent2);
            return;
        }
        int i13 = R$id.sexAv;
        if (valueOf != null && valueOf.intValue() == i13) {
            if (S0() == null) {
                sex = 0;
            } else {
                User S03 = S0();
                kotlin.jvm.internal.e.c(S03);
                sex = S03.getSex() - 1;
            }
            Intent intent3 = new Intent(this, (Class<?>) SelectActivity.class);
            intent3.putExtra("select_type", 0);
            intent3.putExtra("option_position", sex);
            startActivity(intent3);
            return;
        }
        int i14 = R$id.heightAv;
        int i15 = 60;
        if (valueOf != null && valueOf.intValue() == i14) {
            if (S0() == null) {
                a3 = 110;
            } else {
                User S04 = S0();
                kotlin.jvm.internal.e.c(S04);
                if (S04.getMeterUnit() == 0) {
                    User S05 = S0();
                    kotlin.jvm.internal.e.c(S05);
                    a3 = ((int) S05.getHeight()) - 60;
                } else {
                    int a10 = com.google.android.gms.internal.mlkit_vision_common.r.a(23.622059f);
                    User S06 = S0();
                    kotlin.jvm.internal.e.c(S06);
                    a3 = com.google.android.gms.internal.mlkit_vision_common.r.a(((float) S06.getHeight()) * 0.393701f) - a10;
                }
            }
            Intent intent4 = new Intent(this, (Class<?>) SelectActivity.class);
            intent4.putExtra("select_type", 2);
            intent4.putExtra("option_position", a3);
            startActivity(intent4);
            return;
        }
        int i16 = R$id.weightAv;
        if (valueOf != null && valueOf.intValue() == i16) {
            User S07 = S0();
            if (S07 != null) {
                List u10 = kotlin.text.m.u(String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(S07.getMeterUnit() == 0 ? (float) S07.getWeight() : ((float) S07.getWeight()) * 2.205f)}, 1)), new String[]{"."});
                i15 = Integer.parseInt((String) u10.get(0)) - (S07.getMeterUnit() == 0 ? 20 : com.google.android.gms.internal.mlkit_vision_common.r.a(44.1f));
                i11 = Integer.parseInt((String) u10.get(1));
            }
            Intent intent5 = new Intent(this, (Class<?>) SelectActivity.class);
            intent5.putExtra("select_type", 3);
            intent5.putExtra("option_position", i15);
            intent5.putExtra("option_position2", i11);
            startActivity(intent5);
            return;
        }
        int i17 = R$id.targetAv;
        if (valueOf == null || valueOf.intValue() != i17) {
            int i18 = R$id.avatarLl;
            if (valueOf != null && valueOf.intValue() == i18) {
                T0().show();
                return;
            }
            return;
        }
        if (S0() == null) {
            i3 = 4999;
        } else {
            User S08 = S0();
            kotlin.jvm.internal.e.c(S08);
            if (S08.getStepsTarget() > 0) {
                User S09 = S0();
                kotlin.jvm.internal.e.c(S09);
                i3 = (S09.getStepsTarget() / 1000) - 1;
            } else {
                i3 = 4;
            }
        }
        Intent intent6 = new Intent(this, (Class<?>) SelectActivity.class);
        intent6.putExtra("select_type", 4);
        intent6.putExtra("option_position", i3);
        startActivity(intent6);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDateEvent(EventBusBeans.DateValueEvent dateValueEvent) {
        String str;
        kotlin.jvm.internal.e.f(dateValueEvent, "dateValueEvent");
        User S0 = S0();
        if (S0 != null) {
            long j4 = 1000;
            S0.setBirthday(String.valueOf(dateValueEvent.getDate().getTime() / j4));
            ActionItemView actionItemView = ((d1) this.f7247z.getValue()).f12782d;
            String birthday = S0.getBirthday();
            kotlin.jvm.internal.e.e(birthday, "getBirthday(...)");
            long parseLong = Long.parseLong(birthday) * j4;
            try {
                str = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(parseLong));
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(parseLong, " date translate error ", e.getMessage()));
                str = null;
            }
            if (str == null) {
                str = "";
            }
            actionItemView.setHintStr(str);
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onIntegerEvent(EventBusBeans.IntegerValueEvent integerValueEvent) {
        int i3;
        int i10;
        kotlin.jvm.internal.e.f(integerValueEvent, "integerValueEvent");
        User S0 = S0();
        if (S0 != null) {
            int i11 = integerValueEvent.valueType;
            eh.b bVar = this.f7247z;
            if (i11 == 0) {
                S0.setSex(integerValueEvent.value + 1);
                ActionItemView actionItemView = ((d1) bVar.getValue()).f12784g;
                String string = getString(S0.getSex() == 1 ? R$string.str_man : R$string.str_woman);
                kotlin.jvm.internal.e.c(string);
                actionItemView.setHintStr(string);
                return;
            }
            if (i11 == 2) {
                String string2 = getString(R$string.str_metric_unit_height);
                kotlin.jvm.internal.e.e(string2, "getString(...)");
                if (S0.getMeterUnit() == 1) {
                    string2 = getString(R$string.str_imperial_unit_height);
                    kotlin.jvm.internal.e.e(string2, "getString(...)");
                    i3 = com.google.android.gms.internal.mlkit_vision_common.r.a(23.622059f);
                } else {
                    i3 = 60;
                }
                int i12 = integerValueEvent.value + i3;
                S0.setHeight(S0.getMeterUnit() == 1 ? i12 * 2.54f : i12);
                android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(i12), string2}, 2, Locale.ENGLISH, "%d%s", ((d1) bVar.getValue()).e);
                return;
            }
            if (i11 != 3) {
                if (i11 != 4) {
                    return;
                }
                S0.setStepsTarget((integerValueEvent.value + 1) * 1000);
                android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(S0.getStepsTarget()), getString(R$string.str_unit_step)}, 2, Locale.ENGLISH, "%d%s", ((d1) bVar.getValue()).f12785h);
                return;
            }
            String string3 = getString(R$string.str_metric_unit_weight);
            kotlin.jvm.internal.e.e(string3, "getString(...)");
            if (S0.getMeterUnit() == 1) {
                string3 = getString(R$string.str_imperial_unit_weight);
                kotlin.jvm.internal.e.e(string3, "getString(...)");
                i10 = com.google.android.gms.internal.mlkit_vision_common.r.a(44.1f);
            } else {
                i10 = 20;
            }
            double d5 = (integerValueEvent.value2 * 0.1f) + integerValueEvent.value + i10;
            S0.setWeight(S0.getMeterUnit() == 0 ? d5 : ((float) d5) * 0.453592f);
            android.support.v4.media.session.e.B(new Object[]{Float.valueOf((float) d5), string3}, 2, Locale.ENGLISH, "%.1f%s", ((d1) bVar.getValue()).f12787j);
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onTextEvent(EventBusBeans.TextEditEvent textEditEvent) {
        kotlin.jvm.internal.e.f(textEditEvent, "textEditEvent");
        User S0 = S0();
        if (S0 != null) {
            S0.setName(textEditEvent.text);
        }
        ActionItemView actionItemView = ((d1) this.f7247z.getValue()).f12783f;
        String str = textEditEvent.text;
        if (str == null) {
            str = getString(R$string.str_unset);
            kotlin.jvm.internal.e.e(str, "getString(...)");
        }
        actionItemView.setHintStr(str);
    }

    @Override // h7.h
    public final void p() {
        Log.d("tong", "----onUserInfoFail----");
        b0();
        com.example.baselibrary.utils.d.a(R$string.str_update_user_info_fail);
    }
}
