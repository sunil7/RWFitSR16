package com.example.test.ui.device.activity;

import android.R;
import android.content.Context;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.device.d1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.MessageAdapter;
import com.example.test.ui.device.model.MessageModel;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import f6.m1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class RingMessagePushActivity extends XXBaseActivity<d1, m1> implements f7.q, o5.a {
    public static final /* synthetic */ int H = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.RingMessagePushActivity$data$2
        @Override // oh.a
        public final List<MessageModel> invoke() {
            long j4;
            char c9;
            ArrayList arrayList = new ArrayList();
            Object obj = com.example.test.utils.m.f8734b;
            SupportMenuBean supportMenuBean = d2.a().f8735a;
            if (supportMenuBean != null ? supportMenuBean.isPushMsgEnableSwitch() : true) {
                SupportMenuBean supportMenuBean2 = d2.a().f8735a;
                j4 = supportMenuBean2 != null ? supportMenuBean2.getPushMsgSwitchValue() : 0L;
            } else {
                j4 = 4294967295L;
            }
            if (((j4 >> 1) & 1) == 1) {
                arrayList.add(new MessageModel(0, R$mipmap.ic_incoming_call, R$string.str_call));
            }
            if (((j4 >> 2) & 1) == 1) {
                arrayList.add(new MessageModel(1, R$mipmap.ic_message, R$string.str_sms));
            }
            if (((j4 >> 3) & 1) == 1) {
                arrayList.add(new MessageModel(13, R$mipmap.ic_email, R$string.str_email));
            }
            if (((j4 >> 4) & 1) == 1) {
                arrayList.add(new MessageModel(16, R$mipmap.ic_skype, R$string.str_skype));
            }
            if (((j4 >> 5) & 1) == 1) {
                arrayList.add(new MessageModel(9, R$mipmap.ic_facebook, R$string.str_facebook));
            }
            if (((j4 >> 6) & 1) == 1) {
                arrayList.add(new MessageModel(4, R$mipmap.ic_whatsapp, R$string.str_whatsapp));
            }
            if (((j4 >> 7) & 1) == 1) {
                arrayList.add(new MessageModel(10, R$mipmap.ic_line, R$string.str_line));
            }
            if (((j4 >> 8) & 1) == 1) {
                c9 = '\r';
                arrayList.add(new MessageModel(8, R$mipmap.ic_instagram, R$string.str_instagram));
            } else {
                c9 = '\r';
            }
            if (((j4 >> 9) & 1) == 1) {
                arrayList.add(new MessageModel(17, R$mipmap.ic_kakaktalk, R$string.str_kakaotalk));
            }
            if (((j4 >> 10) & 1) == 1) {
                arrayList.add(new MessageModel(23, R$mipmap.ic_gmail, R$string.str_gmail));
            }
            if (((j4 >> 11) & 1) == 1) {
                arrayList.add(new MessageModel(6, R$mipmap.ic_twitter, R$string.str_twitter));
            }
            if (((j4 >> 12) & 1) == 1) {
                arrayList.add(new MessageModel(7, R$mipmap.ic_linkedin, R$string.str_linkedin));
            }
            if (((j4 >> c9) & 1) == 1) {
                arrayList.add(new MessageModel(27, R$mipmap.ic_weibo, R$string.str_weibo));
            }
            if (((j4 >> 14) & 1) == 1) {
                arrayList.add(new MessageModel(2, R$mipmap.ic_qq, R$string.str_qq));
            }
            if (((j4 >> 15) & 1) == 1) {
                arrayList.add(new MessageModel(3, R$mipmap.ic_wechat, R$string.str_wechat));
            }
            if (((j4 >> 16) & 1) == 1) {
                arrayList.add(new MessageModel(28, R$mipmap.ic_band, R$string.str_band));
            }
            if (((j4 >> 17) & 1) == 1) {
                arrayList.add(new MessageModel(29, R$mipmap.ic_telegram, R$string.str_telegram));
            }
            if (((j4 >> 18) & 1) == 1) {
                arrayList.add(new MessageModel(30, R$mipmap.ic_between, R$string.str_between));
            }
            if (((j4 >> 19) & 1) == 1) {
                arrayList.add(new MessageModel(31, R$mipmap.ic_naver_cafe, R$string.str_navercafe));
            }
            if (((j4 >> 20) & 1) == 1) {
                arrayList.add(new MessageModel(20, R$mipmap.ic_youtube, R$string.str_youtube));
            }
            if (((j4 >> 21) & 1) == 1) {
                arrayList.add(new MessageModel(32, R$mipmap.ic_net_flix, R$string.str_netflix));
            }
            if (((j4 >> 22) & 1) == 1) {
                arrayList.add(new MessageModel(34, R$mipmap.ic_net_max, R$string.str_max));
            }
            if (((j4 >> 23) & 1) == 1) {
                arrayList.add(new MessageModel(35, R$mipmap.ic_net_vk, R$string.str_vk));
            }
            if (((j4 >> 24) & 1) == 1) {
                arrayList.add(new MessageModel(36, R$mipmap.device_ancs_ru_mail, R$string.str_ru_mail));
            }
            if (((j4 >> 25) & 1) == 1) {
                arrayList.add(new MessageModel(37, R$mipmap.device_ancs_yandexmail, R$string.str_yandex_mail));
            }
            if (((j4 >> 26) & 1) == 1) {
                arrayList.add(new MessageModel(38, R$mipmap.device_ancs_yandextaxi, R$string.str_yandex_taxi));
            }
            if (((j4 >> 27) & 1) == 1) {
                arrayList.add(new MessageModel(39, R$mipmap.device_ancs_vkontakte, R$string.str_vkontakte));
            }
            if (((j4 >> 28) & 1) == 1) {
                arrayList.add(new MessageModel(40, R$mipmap.ic_wildberries, R$string.str_wildberries));
            }
            if (((j4 >> 29) & 1) == 1) {
                arrayList.add(new MessageModel(41, R$mipmap.ic_ozon, R$string.str_ozon));
            }
            if (((j4 >> 30) & 1) == 1) {
                arrayList.add(new MessageModel(42, R$mipmap.ic_makc, R$string.str_makc));
            }
            if ((j4 & 1) == 1) {
                arrayList.add(new MessageModel(24, R$mipmap.ic_others, R$string.str_other));
            }
            return arrayList;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.RingMessagePushActivity$warnNotifyDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(RingMessagePushActivity.this);
            rVar.b(R$string.str_msg_tips);
            rVar.setOnDialogListener(new a2.d(RingMessagePushActivity.this, 26));
            return rVar;
        }
    });
    public final eh.b G;

    public RingMessagePushActivity() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.RingMessagePushActivity$warnPhoneDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.r invoke() {
                com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(RingMessagePushActivity.this);
                rVar.b(R$string.str_phone_tips);
                rVar.setOnDialogListener(new y2.f(RingMessagePushActivity.this, 26));
                return rVar;
            }
        });
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.RingMessagePushActivity$weakHandler$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.baselibrary.utils.e invoke() {
                return new com.example.baselibrary.utils.e(RingMessagePushActivity.this);
            }
        });
        this.G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.RingMessagePushActivity$messageAdapter$2
            {
                super(0);
            }

            @Override // oh.a
            public final MessageAdapter invoke() {
                RingMessagePushActivity ringMessagePushActivity = RingMessagePushActivity.this;
                int i3 = RingMessagePushActivity.H;
                MessageAdapter messageAdapter = new MessageAdapter(ringMessagePushActivity.R0());
                messageAdapter.setOnSwitchItemStatusListener(new a0(RingMessagePushActivity.this));
                return messageAdapter;
            }
        });
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new d1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((m1) this.f7247z.getValue()).f13118a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View a3;
        View a10;
        View inflate = getLayoutInflater().inflate(R$layout.activity_ring_message_push, (ViewGroup) null, false);
        int i3 = R$id.messageList;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.notify_all;
            ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
            if (actionItemView != null) {
                i3 = R$id.notify_iv;
                ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView2 != null && (a3 = he.a((i3 = R$id.notify_per_enable_view), inflate)) != null && (a10 = he.a((i3 = R$id.notify_per_enable_view_1), inflate)) != null) {
                    i3 = R$id.titleView;
                    TitleView titleView = (TitleView) he.a(i3, inflate);
                    if (titleView != null) {
                        return new m1((LinearLayout) inflate, recyclerView, actionItemView, actionItemView2, a3, a10, titleView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((d1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((m1) bVar.getValue()).f13123g.setOnTitleListener(new androidx.appcompat.app.t(this, 25));
        ((m1) bVar.getValue()).f13119b.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView = ((m1) bVar.getValue()).f13119b;
        n.g0 g0Var = new n.g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        recyclerView.g(g0Var.d());
        ((m1) bVar.getValue()).f13119b.setItemAnimator(null);
        ((m1) bVar.getValue()).f13119b.setItemViewCacheSize(R0().size());
        ((m1) bVar.getValue()).f13119b.setAdapter(S0());
        S0().addChildClickViewIds(R$id.notify_enable_view);
        S0().setOnItemChildClickListener(new a0(this));
        final int i3 = 0;
        ((m1) bVar.getValue()).e.setOnClickListener(new View.OnClickListener(this) { // from class: com.example.test.ui.device.activity.b0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RingMessagePushActivity f7848b;

            {
                this.f7848b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z5;
                boolean z6 = false;
                RingMessagePushActivity this$0 = this.f7848b;
                switch (i3) {
                    case 0:
                        int i10 = RingMessagePushActivity.H;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        XXApplication xXApplication = XXApplication.f7400h;
                        j1.a();
                        String packageName = j1.a().getApplicationContext().getPackageName();
                        String string = Settings.Secure.getString(j1.a().getApplicationContext().getContentResolver(), "enabled_notification_listeners");
                        if (string != null) {
                            kotlin.jvm.internal.e.c(packageName);
                            z6 = kotlin.text.m.c(string, packageName, false);
                        }
                        if (!z6) {
                            this$0.T0().b(R$string.str_msg_tips);
                            this$0.T0().show();
                            break;
                        } else {
                            this$0.T0().b(R$string.str_notify_tips);
                            this$0.T0().show();
                            break;
                        }
                    default:
                        int i11 = RingMessagePushActivity.H;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        XXApplication xXApplication2 = XXApplication.f7400h;
                        j1.a();
                        String packageName2 = j1.a().getApplicationContext().getPackageName();
                        String string2 = Settings.Secure.getString(j1.a().getApplicationContext().getContentResolver(), "enabled_notification_listeners");
                        if (string2 != null) {
                            kotlin.jvm.internal.e.c(packageName2);
                            z5 = kotlin.text.m.c(string2, packageName2, false);
                        } else {
                            z5 = false;
                        }
                        if (!z5) {
                            this$0.T0().b(R$string.str_msg_tips);
                            this$0.T0().show();
                            break;
                        } else {
                            eh.b bVar2 = this$0.f7247z;
                            ((m1) bVar2.getValue()).f13120c.setItemOpen(!((m1) bVar2.getValue()).f13120c.getItemOpen());
                            Iterator it = this$0.R0().iterator();
                            while (it.hasNext()) {
                                ((MessageModel) it.next()).setSelected(((m1) bVar2.getValue()).f13120c.getItemOpen());
                            }
                            this$0.S0().notifyItemRangeChanged(0, this$0.R0().size());
                            break;
                        }
                }
            }
        });
        final int i10 = 1;
        ((m1) bVar.getValue()).f13122f.setOnClickListener(new View.OnClickListener(this) { // from class: com.example.test.ui.device.activity.b0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RingMessagePushActivity f7848b;

            {
                this.f7848b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z5;
                boolean z6 = false;
                RingMessagePushActivity this$0 = this.f7848b;
                switch (i10) {
                    case 0:
                        int i102 = RingMessagePushActivity.H;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        XXApplication xXApplication = XXApplication.f7400h;
                        j1.a();
                        String packageName = j1.a().getApplicationContext().getPackageName();
                        String string = Settings.Secure.getString(j1.a().getApplicationContext().getContentResolver(), "enabled_notification_listeners");
                        if (string != null) {
                            kotlin.jvm.internal.e.c(packageName);
                            z6 = kotlin.text.m.c(string, packageName, false);
                        }
                        if (!z6) {
                            this$0.T0().b(R$string.str_msg_tips);
                            this$0.T0().show();
                            break;
                        } else {
                            this$0.T0().b(R$string.str_notify_tips);
                            this$0.T0().show();
                            break;
                        }
                    default:
                        int i11 = RingMessagePushActivity.H;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        XXApplication xXApplication2 = XXApplication.f7400h;
                        j1.a();
                        String packageName2 = j1.a().getApplicationContext().getPackageName();
                        String string2 = Settings.Secure.getString(j1.a().getApplicationContext().getContentResolver(), "enabled_notification_listeners");
                        if (string2 != null) {
                            kotlin.jvm.internal.e.c(packageName2);
                            z5 = kotlin.text.m.c(string2, packageName2, false);
                        } else {
                            z5 = false;
                        }
                        if (!z5) {
                            this$0.T0().b(R$string.str_msg_tips);
                            this$0.T0().show();
                            break;
                        } else {
                            eh.b bVar2 = this$0.f7247z;
                            ((m1) bVar2.getValue()).f13120c.setItemOpen(!((m1) bVar2.getValue()).f13120c.getItemOpen());
                            Iterator it = this$0.R0().iterator();
                            while (it.hasNext()) {
                                ((MessageModel) it.next()).setSelected(((m1) bVar2.getValue()).f13120c.getItemOpen());
                            }
                            this$0.S0().notifyItemRangeChanged(0, this$0.R0().size());
                            break;
                        }
                }
            }
        });
    }

    public final List R0() {
        return (List) this.E.getValue();
    }

    public final MessageAdapter S0() {
        return (MessageAdapter) this.G.getValue();
    }

    public final com.example.test.ui.dialog.r T0() {
        return (com.example.test.ui.dialog.r) this.F.getValue();
    }

    public final boolean U0() {
        Object obj;
        ArrayList arrayList = new ArrayList();
        kotlin.collections.n.i(arrayList, R0());
        if (((MessageModel) R0().get(0)).getId() == -1) {
            arrayList.remove(0);
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i3);
            i3++;
            if (!((MessageModel) obj).isSelected()) {
                break;
            }
        }
        return ((MessageModel) obj) == null;
    }

    @Override // f7.q
    public final void a() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.q
    public final void b() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    @Override // f7.q
    public final void d(List list) {
        if (((MessageModel) R0().get(0)).getId() == -1) {
            MessageModel messageModel = new MessageModel();
            messageModel.setId(-1);
            ((ArrayList) list).add(0, messageModel);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MessageModel messageModel2 = (MessageModel) it.next();
            int size = R0().size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (((MessageModel) R0().get(i3)).getId() == messageModel2.getId()) {
                    ((MessageModel) R0().get(i3)).setSelected(messageModel2.isSelected());
                    break;
                }
                i3++;
            }
        }
        S0().notifyItemRangeChanged(0, R0().size());
        ((m1) this.f7247z.getValue()).f13120c.setItemOpen(U0());
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        boolean z5;
        boolean z6;
        super.onResume();
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a();
        String packageName = j1.a().getApplicationContext().getPackageName();
        String string = Settings.Secure.getString(j1.a().getApplicationContext().getContentResolver(), "enabled_notification_listeners");
        boolean z8 = false;
        if (string != null) {
            kotlin.jvm.internal.e.c(packageName);
            z5 = kotlin.text.m.c(string, packageName, false);
        } else {
            z5 = false;
        }
        if (!z5) {
            j1.a().g();
        }
        int i3 = 0;
        for (Object obj : R0()) {
            int i10 = i3 + 1;
            if (i3 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            MessageModel messageModel = (MessageModel) obj;
            XXApplication xXApplication2 = XXApplication.f7400h;
            j1.a();
            String packageName2 = j1.a().getApplicationContext().getPackageName();
            String string2 = Settings.Secure.getString(j1.a().getApplicationContext().getContentResolver(), "enabled_notification_listeners");
            if (string2 != null) {
                kotlin.jvm.internal.e.c(packageName2);
                z6 = kotlin.text.m.c(string2, packageName2, false);
            } else {
                z6 = false;
            }
            messageModel.setEnableSwitch(z6);
            i3 = i10;
        }
        S0().notifyItemRangeChanged(0, R0().size());
        eh.b bVar = this.f7247z;
        ((m1) bVar.getValue()).f13120c.setItemOpen(U0());
        ActionItemView actionItemView = ((m1) bVar.getValue()).f13121d;
        XXApplication xXApplication3 = XXApplication.f7400h;
        j1.a();
        String packageName3 = j1.a().getApplicationContext().getPackageName();
        String string3 = Settings.Secure.getString(j1.a().getApplicationContext().getContentResolver(), "enabled_notification_listeners");
        if (string3 != null) {
            kotlin.jvm.internal.e.c(packageName3);
            z8 = kotlin.text.m.c(string3, packageName3, false);
        }
        actionItemView.setItemOpen(z8);
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
    }
}
