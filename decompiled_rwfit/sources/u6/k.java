package u6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.MemberFriendApplyBean;
import com.example.network.bean.MemberFriendBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.presenter.main.j0;
import com.example.test.presenter.main.l0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.TRingFamilyActivity;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.w1;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public TRingFamilyActivity f18905a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f18906b;

    /* renamed from: c, reason: collision with root package name */
    public i f18907c;

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        ArrayList arrayList = this.f18906b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemViewType(int i3) {
        Object obj = this.f18906b.get(i3);
        if (obj instanceof Integer) {
            System.out.println((Integer) obj);
            return 2;
        }
        if (obj instanceof MemberFriendApplyBean) {
            System.out.println("MemberFriendApplyBean:" + ((MemberFriendApplyBean) obj).toString());
            return 1;
        }
        if (obj instanceof MemberFriendBean) {
            System.out.println("MemberFriendBean:" + ((MemberFriendBean) obj).toString());
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, final int i3) {
        int itemViewType = z1Var.getItemViewType();
        z3.h hVar = z3.h.f20239b;
        TRingFamilyActivity context = this.f18905a;
        ArrayList arrayList = this.f18906b;
        if (itemViewType == 0) {
            h hVar2 = (h) z1Var;
            MemberFriendBean memberFriendBean = (MemberFriendBean) arrayList.get(i3);
            String friendName = memberFriendBean.getFriendName();
            TextView textView = hVar2.f18900a;
            textView.setText(friendName);
            if (memberFriendBean.getFriendName() == null || memberFriendBean.getFriendName().length() <= 17) {
                textView.setTextSize(15.0f);
            } else {
                textView.setTextSize(11.0f);
            }
            if (memberFriendBean.getFriendPortraitUrl() != null && !Objects.equals(memberFriendBean.getFriendPortraitUrl(), "")) {
                int i10 = R$mipmap.ic_avatar;
                String url = memberFriendBean.getFriendPortraitUrl();
                kotlin.jvm.internal.e.f(context, "context");
                ImageView imageView = hVar2.f18901b;
                kotlin.jvm.internal.e.f(imageView, "imageView");
                kotlin.jvm.internal.e.f(url, "url");
                ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(context).n(url).o(false)).d(hVar)).i(i10), i10)).x(imageView);
            }
            Button button = hVar2.f18902c;
            button.setVisibility(0);
            hVar2.f18903d.setText(R$string.str_error_family_delete_button);
            final int i11 = 0;
            button.setOnClickListener(new View.OnClickListener(this) { // from class: u6.f

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k f18894b;

                {
                    this.f18894b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i12 = i3;
                    k kVar = this.f18894b;
                    switch (i11) {
                        case 0:
                            final TRingFamilyActivity tRingFamilyActivity = ((com.example.test.ui.testui.w) kVar.f18907c).f8322a;
                            Object obj = tRingFamilyActivity.E.get(i12);
                            if (obj instanceof MemberFriendBean) {
                                int i13 = R$string.str_family_friend_edit_name;
                                MemberFriendBean memberFriendBean2 = (MemberFriendBean) obj;
                                Integer friendId = memberFriendBean2.getFriendId();
                                kotlin.jvm.internal.e.e(friendId, "getFriendId(...)");
                                final int intValue = friendId.intValue();
                                String friendName2 = memberFriendBean2.getFriendName();
                                kotlin.jvm.internal.e.e(friendName2, "getFriendName(...)");
                                final EditText editText = new EditText(tRingFamilyActivity);
                                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
                                editText.setFocusable(true);
                                editText.setText(friendName2);
                                AlertDialog.Builder builder = new AlertDialog.Builder(tRingFamilyActivity);
                                builder.setTitle(i13).setView(editText).setNegativeButton(R$string.str_cancel, (DialogInterface.OnClickListener) null);
                                builder.setPositiveButton(R$string.str_sure, new DialogInterface.OnClickListener() { // from class: com.example.test.ui.testui.v
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i14) {
                                        int i15 = TRingFamilyActivity.J;
                                        EditText editText2 = editText;
                                        TRingFamilyActivity this$0 = tRingFamilyActivity;
                                        kotlin.jvm.internal.e.f(this$0, "this$0");
                                        if (editText2.getText().toString().length() == 0) {
                                            Toast.makeText(this$0.getApplicationContext(), R$string.str_family_friend_nickname_cannot_empty, 1).show();
                                            return;
                                        }
                                        com.example.test.presenter.main.l0 l0Var = (com.example.test.presenter.main.l0) this$0.I0();
                                        String friendName3 = editText2.getText().toString();
                                        l0Var.getClass();
                                        kotlin.jvm.internal.e.f(friendName3, "friendName");
                                        Object obj2 = (g7.n) l0Var.f7255a;
                                        ((XXBaseActivity) obj2).V();
                                        c6.d dVar = c6.d.f3392c;
                                        dVar.getClass();
                                        rg.l<HttpModel<String>> memberFriendUpdate = ((UserApi) dVar.f113a).memberFriendUpdate(Integer.valueOf(intValue), friendName3);
                                        kotlin.jvm.internal.e.e(memberFriendUpdate, "memberFriendUpdate(...)");
                                        rg.l u10 = com.example.baselibrary.utils.b.u(memberFriendUpdate);
                                        TRingFamilyActivity tRingFamilyActivity2 = (TRingFamilyActivity) obj2;
                                        tRingFamilyActivity2.getClass();
                                        u10.blockingSubscribe(new com.example.test.presenter.main.j0(l0Var, tRingFamilyActivity2, com.example.test.utils.w0.d(), 3));
                                    }
                                });
                                builder.show();
                                break;
                            }
                            break;
                        case 1:
                            kVar.getClass();
                            if (!w1.a()) {
                                TRingFamilyActivity tRingFamilyActivity2 = ((com.example.test.ui.testui.w) kVar.f18907c).f8322a;
                                Object obj2 = tRingFamilyActivity2.E.get(i12);
                                if (obj2 instanceof MemberFriendApplyBean) {
                                    MemberFriendApplyBean memberFriendApplyBean = (MemberFriendApplyBean) obj2;
                                    if (memberFriendApplyBean.getId() != null) {
                                        l0 l0Var = (l0) tRingFamilyActivity2.I0();
                                        Integer id2 = memberFriendApplyBean.getId();
                                        kotlin.jvm.internal.e.e(id2, "getId(...)");
                                        int intValue2 = id2.intValue();
                                        Object obj3 = (g7.n) l0Var.f7255a;
                                        ((XXBaseActivity) obj3).V();
                                        rg.l<HttpModel<String>> memberFriendAgree = ((UserApi) c6.d.f3392c.f113a).memberFriendAgree(Integer.valueOf(intValue2));
                                        kotlin.jvm.internal.e.e(memberFriendAgree, "memberFriendAgree(...)");
                                        rg.l u10 = com.example.baselibrary.utils.b.u(memberFriendAgree);
                                        TRingFamilyActivity tRingFamilyActivity3 = (TRingFamilyActivity) obj3;
                                        tRingFamilyActivity3.getClass();
                                        u10.blockingSubscribe(new j0(l0Var, tRingFamilyActivity3, w0.d(), 0));
                                        break;
                                    }
                                }
                            }
                            break;
                        default:
                            kVar.getClass();
                            if (!w1.a()) {
                                TRingFamilyActivity tRingFamilyActivity4 = ((com.example.test.ui.testui.w) kVar.f18907c).f8322a;
                                Object obj4 = tRingFamilyActivity4.E.get(i12);
                                if (obj4 instanceof MemberFriendApplyBean) {
                                    MemberFriendApplyBean memberFriendApplyBean2 = (MemberFriendApplyBean) obj4;
                                    if (memberFriendApplyBean2.getId() != null) {
                                        l0 l0Var2 = (l0) tRingFamilyActivity4.I0();
                                        Integer id3 = memberFriendApplyBean2.getId();
                                        kotlin.jvm.internal.e.e(id3, "getId(...)");
                                        int intValue3 = id3.intValue();
                                        Object obj5 = (g7.n) l0Var2.f7255a;
                                        ((XXBaseActivity) obj5).V();
                                        rg.l<HttpModel<String>> memberFriendReject = ((UserApi) c6.d.f3392c.f113a).memberFriendReject(Integer.valueOf(intValue3));
                                        kotlin.jvm.internal.e.e(memberFriendReject, "memberFriendReject(...)");
                                        rg.l u11 = com.example.baselibrary.utils.b.u(memberFriendReject);
                                        TRingFamilyActivity tRingFamilyActivity5 = (TRingFamilyActivity) obj5;
                                        tRingFamilyActivity5.getClass();
                                        u11.blockingSubscribe(new j0(l0Var2, tRingFamilyActivity5, w0.d(), 1));
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                }
            });
            return;
        }
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                return;
            }
            Integer num = (Integer) arrayList.get(i3);
            int intValue = num.intValue();
            TextView textView2 = ((j) z1Var).f18904a;
            if (intValue == 1) {
                textView2.setText(R$string.str_error_family_new_friend);
            }
            if (num.intValue() == 2) {
                textView2.setText(R$string.str_error_family_friend_list);
                return;
            }
            return;
        }
        g gVar = (g) z1Var;
        MemberFriendApplyBean memberFriendApplyBean = (MemberFriendApplyBean) arrayList.get(i3);
        String account = memberFriendApplyBean.getAccount();
        TextView textView3 = gVar.f18896a;
        textView3.setText(account);
        if (memberFriendApplyBean.getAccount() == null || memberFriendApplyBean.getAccount().length() <= 17) {
            textView3.setTextSize(15.0f);
        } else {
            textView3.setTextSize(11.0f);
        }
        if (memberFriendApplyBean.getFriendPortraitUrl() != null && !Objects.equals(memberFriendApplyBean.getFriendPortraitUrl(), "")) {
            int i12 = R$mipmap.ic_avatar;
            String url2 = memberFriendApplyBean.getFriendPortraitUrl();
            kotlin.jvm.internal.e.f(context, "context");
            ImageView imageView2 = gVar.f18897b;
            kotlin.jvm.internal.e.f(imageView2, "imageView");
            kotlin.jvm.internal.e.f(url2, "url");
            ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(context).n(url2).o(false)).d(hVar)).i(i12), i12)).x(imageView2);
        }
        Button button2 = gVar.f18899d;
        button2.setVisibility(0);
        button2.setText(R$string.str_error_family_agree_button);
        final int i13 = 1;
        button2.setOnClickListener(new View.OnClickListener(this) { // from class: u6.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f18894b;

            {
                this.f18894b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i122 = i3;
                k kVar = this.f18894b;
                switch (i13) {
                    case 0:
                        final TRingFamilyActivity tRingFamilyActivity = ((com.example.test.ui.testui.w) kVar.f18907c).f8322a;
                        Object obj = tRingFamilyActivity.E.get(i122);
                        if (obj instanceof MemberFriendBean) {
                            int i132 = R$string.str_family_friend_edit_name;
                            MemberFriendBean memberFriendBean2 = (MemberFriendBean) obj;
                            Integer friendId = memberFriendBean2.getFriendId();
                            kotlin.jvm.internal.e.e(friendId, "getFriendId(...)");
                            final int intValue2 = friendId.intValue();
                            String friendName2 = memberFriendBean2.getFriendName();
                            kotlin.jvm.internal.e.e(friendName2, "getFriendName(...)");
                            final EditText editText = new EditText(tRingFamilyActivity);
                            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
                            editText.setFocusable(true);
                            editText.setText(friendName2);
                            AlertDialog.Builder builder = new AlertDialog.Builder(tRingFamilyActivity);
                            builder.setTitle(i132).setView(editText).setNegativeButton(R$string.str_cancel, (DialogInterface.OnClickListener) null);
                            builder.setPositiveButton(R$string.str_sure, new DialogInterface.OnClickListener() { // from class: com.example.test.ui.testui.v
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i14) {
                                    int i15 = TRingFamilyActivity.J;
                                    EditText editText2 = editText;
                                    TRingFamilyActivity this$0 = tRingFamilyActivity;
                                    kotlin.jvm.internal.e.f(this$0, "this$0");
                                    if (editText2.getText().toString().length() == 0) {
                                        Toast.makeText(this$0.getApplicationContext(), R$string.str_family_friend_nickname_cannot_empty, 1).show();
                                        return;
                                    }
                                    com.example.test.presenter.main.l0 l0Var = (com.example.test.presenter.main.l0) this$0.I0();
                                    String friendName3 = editText2.getText().toString();
                                    l0Var.getClass();
                                    kotlin.jvm.internal.e.f(friendName3, "friendName");
                                    Object obj2 = (g7.n) l0Var.f7255a;
                                    ((XXBaseActivity) obj2).V();
                                    c6.d dVar = c6.d.f3392c;
                                    dVar.getClass();
                                    rg.l<HttpModel<String>> memberFriendUpdate = ((UserApi) dVar.f113a).memberFriendUpdate(Integer.valueOf(intValue2), friendName3);
                                    kotlin.jvm.internal.e.e(memberFriendUpdate, "memberFriendUpdate(...)");
                                    rg.l u10 = com.example.baselibrary.utils.b.u(memberFriendUpdate);
                                    TRingFamilyActivity tRingFamilyActivity2 = (TRingFamilyActivity) obj2;
                                    tRingFamilyActivity2.getClass();
                                    u10.blockingSubscribe(new com.example.test.presenter.main.j0(l0Var, tRingFamilyActivity2, com.example.test.utils.w0.d(), 3));
                                }
                            });
                            builder.show();
                            break;
                        }
                        break;
                    case 1:
                        kVar.getClass();
                        if (!w1.a()) {
                            TRingFamilyActivity tRingFamilyActivity2 = ((com.example.test.ui.testui.w) kVar.f18907c).f8322a;
                            Object obj2 = tRingFamilyActivity2.E.get(i122);
                            if (obj2 instanceof MemberFriendApplyBean) {
                                MemberFriendApplyBean memberFriendApplyBean2 = (MemberFriendApplyBean) obj2;
                                if (memberFriendApplyBean2.getId() != null) {
                                    l0 l0Var = (l0) tRingFamilyActivity2.I0();
                                    Integer id2 = memberFriendApplyBean2.getId();
                                    kotlin.jvm.internal.e.e(id2, "getId(...)");
                                    int intValue22 = id2.intValue();
                                    Object obj3 = (g7.n) l0Var.f7255a;
                                    ((XXBaseActivity) obj3).V();
                                    rg.l<HttpModel<String>> memberFriendAgree = ((UserApi) c6.d.f3392c.f113a).memberFriendAgree(Integer.valueOf(intValue22));
                                    kotlin.jvm.internal.e.e(memberFriendAgree, "memberFriendAgree(...)");
                                    rg.l u10 = com.example.baselibrary.utils.b.u(memberFriendAgree);
                                    TRingFamilyActivity tRingFamilyActivity3 = (TRingFamilyActivity) obj3;
                                    tRingFamilyActivity3.getClass();
                                    u10.blockingSubscribe(new j0(l0Var, tRingFamilyActivity3, w0.d(), 0));
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        kVar.getClass();
                        if (!w1.a()) {
                            TRingFamilyActivity tRingFamilyActivity4 = ((com.example.test.ui.testui.w) kVar.f18907c).f8322a;
                            Object obj4 = tRingFamilyActivity4.E.get(i122);
                            if (obj4 instanceof MemberFriendApplyBean) {
                                MemberFriendApplyBean memberFriendApplyBean22 = (MemberFriendApplyBean) obj4;
                                if (memberFriendApplyBean22.getId() != null) {
                                    l0 l0Var2 = (l0) tRingFamilyActivity4.I0();
                                    Integer id3 = memberFriendApplyBean22.getId();
                                    kotlin.jvm.internal.e.e(id3, "getId(...)");
                                    int intValue3 = id3.intValue();
                                    Object obj5 = (g7.n) l0Var2.f7255a;
                                    ((XXBaseActivity) obj5).V();
                                    rg.l<HttpModel<String>> memberFriendReject = ((UserApi) c6.d.f3392c.f113a).memberFriendReject(Integer.valueOf(intValue3));
                                    kotlin.jvm.internal.e.e(memberFriendReject, "memberFriendReject(...)");
                                    rg.l u11 = com.example.baselibrary.utils.b.u(memberFriendReject);
                                    TRingFamilyActivity tRingFamilyActivity5 = (TRingFamilyActivity) obj5;
                                    tRingFamilyActivity5.getClass();
                                    u11.blockingSubscribe(new j0(l0Var2, tRingFamilyActivity5, w0.d(), 1));
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
        Button button3 = gVar.f18898c;
        button3.setVisibility(0);
        button3.setText(R$string.str_error_family_refuse_button);
        final int i14 = 2;
        button3.setOnClickListener(new View.OnClickListener(this) { // from class: u6.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f18894b;

            {
                this.f18894b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i122 = i3;
                k kVar = this.f18894b;
                switch (i14) {
                    case 0:
                        final TRingFamilyActivity tRingFamilyActivity = ((com.example.test.ui.testui.w) kVar.f18907c).f8322a;
                        Object obj = tRingFamilyActivity.E.get(i122);
                        if (obj instanceof MemberFriendBean) {
                            int i132 = R$string.str_family_friend_edit_name;
                            MemberFriendBean memberFriendBean2 = (MemberFriendBean) obj;
                            Integer friendId = memberFriendBean2.getFriendId();
                            kotlin.jvm.internal.e.e(friendId, "getFriendId(...)");
                            final int intValue2 = friendId.intValue();
                            String friendName2 = memberFriendBean2.getFriendName();
                            kotlin.jvm.internal.e.e(friendName2, "getFriendName(...)");
                            final EditText editText = new EditText(tRingFamilyActivity);
                            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
                            editText.setFocusable(true);
                            editText.setText(friendName2);
                            AlertDialog.Builder builder = new AlertDialog.Builder(tRingFamilyActivity);
                            builder.setTitle(i132).setView(editText).setNegativeButton(R$string.str_cancel, (DialogInterface.OnClickListener) null);
                            builder.setPositiveButton(R$string.str_sure, new DialogInterface.OnClickListener() { // from class: com.example.test.ui.testui.v
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i142) {
                                    int i15 = TRingFamilyActivity.J;
                                    EditText editText2 = editText;
                                    TRingFamilyActivity this$0 = tRingFamilyActivity;
                                    kotlin.jvm.internal.e.f(this$0, "this$0");
                                    if (editText2.getText().toString().length() == 0) {
                                        Toast.makeText(this$0.getApplicationContext(), R$string.str_family_friend_nickname_cannot_empty, 1).show();
                                        return;
                                    }
                                    com.example.test.presenter.main.l0 l0Var = (com.example.test.presenter.main.l0) this$0.I0();
                                    String friendName3 = editText2.getText().toString();
                                    l0Var.getClass();
                                    kotlin.jvm.internal.e.f(friendName3, "friendName");
                                    Object obj2 = (g7.n) l0Var.f7255a;
                                    ((XXBaseActivity) obj2).V();
                                    c6.d dVar = c6.d.f3392c;
                                    dVar.getClass();
                                    rg.l<HttpModel<String>> memberFriendUpdate = ((UserApi) dVar.f113a).memberFriendUpdate(Integer.valueOf(intValue2), friendName3);
                                    kotlin.jvm.internal.e.e(memberFriendUpdate, "memberFriendUpdate(...)");
                                    rg.l u10 = com.example.baselibrary.utils.b.u(memberFriendUpdate);
                                    TRingFamilyActivity tRingFamilyActivity2 = (TRingFamilyActivity) obj2;
                                    tRingFamilyActivity2.getClass();
                                    u10.blockingSubscribe(new com.example.test.presenter.main.j0(l0Var, tRingFamilyActivity2, com.example.test.utils.w0.d(), 3));
                                }
                            });
                            builder.show();
                            break;
                        }
                        break;
                    case 1:
                        kVar.getClass();
                        if (!w1.a()) {
                            TRingFamilyActivity tRingFamilyActivity2 = ((com.example.test.ui.testui.w) kVar.f18907c).f8322a;
                            Object obj2 = tRingFamilyActivity2.E.get(i122);
                            if (obj2 instanceof MemberFriendApplyBean) {
                                MemberFriendApplyBean memberFriendApplyBean2 = (MemberFriendApplyBean) obj2;
                                if (memberFriendApplyBean2.getId() != null) {
                                    l0 l0Var = (l0) tRingFamilyActivity2.I0();
                                    Integer id2 = memberFriendApplyBean2.getId();
                                    kotlin.jvm.internal.e.e(id2, "getId(...)");
                                    int intValue22 = id2.intValue();
                                    Object obj3 = (g7.n) l0Var.f7255a;
                                    ((XXBaseActivity) obj3).V();
                                    rg.l<HttpModel<String>> memberFriendAgree = ((UserApi) c6.d.f3392c.f113a).memberFriendAgree(Integer.valueOf(intValue22));
                                    kotlin.jvm.internal.e.e(memberFriendAgree, "memberFriendAgree(...)");
                                    rg.l u10 = com.example.baselibrary.utils.b.u(memberFriendAgree);
                                    TRingFamilyActivity tRingFamilyActivity3 = (TRingFamilyActivity) obj3;
                                    tRingFamilyActivity3.getClass();
                                    u10.blockingSubscribe(new j0(l0Var, tRingFamilyActivity3, w0.d(), 0));
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        kVar.getClass();
                        if (!w1.a()) {
                            TRingFamilyActivity tRingFamilyActivity4 = ((com.example.test.ui.testui.w) kVar.f18907c).f8322a;
                            Object obj4 = tRingFamilyActivity4.E.get(i122);
                            if (obj4 instanceof MemberFriendApplyBean) {
                                MemberFriendApplyBean memberFriendApplyBean22 = (MemberFriendApplyBean) obj4;
                                if (memberFriendApplyBean22.getId() != null) {
                                    l0 l0Var2 = (l0) tRingFamilyActivity4.I0();
                                    Integer id3 = memberFriendApplyBean22.getId();
                                    kotlin.jvm.internal.e.e(id3, "getId(...)");
                                    int intValue3 = id3.intValue();
                                    Object obj5 = (g7.n) l0Var2.f7255a;
                                    ((XXBaseActivity) obj5).V();
                                    rg.l<HttpModel<String>> memberFriendReject = ((UserApi) c6.d.f3392c.f113a).memberFriendReject(Integer.valueOf(intValue3));
                                    kotlin.jvm.internal.e.e(memberFriendReject, "memberFriendReject(...)");
                                    rg.l u11 = com.example.baselibrary.utils.b.u(memberFriendReject);
                                    TRingFamilyActivity tRingFamilyActivity5 = (TRingFamilyActivity) obj5;
                                    tRingFamilyActivity5.getClass();
                                    u11.blockingSubscribe(new j0(l0Var2, tRingFamilyActivity5, w0.d(), 1));
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        LayoutInflater from = LayoutInflater.from(this.f18905a);
        if (i3 == 0) {
            ViewGroup viewGroup2 = (ViewGroup) from.inflate(R$layout.family_list_item, viewGroup, false);
            h hVar = new h(viewGroup2);
            hVar.f18900a = (TextView) viewGroup2.findViewById(R$id.item_content);
            hVar.f18901b = (ImageView) viewGroup2.findViewById(R$id.itemIcon);
            hVar.f18902c = (Button) viewGroup2.findViewById(R$id.modifyButton);
            hVar.f18903d = (Button) viewGroup2.findViewById(R$id.item_delete);
            hVar.e = (LinearLayout) viewGroup2.findViewById(R$id.item_layout);
            return hVar;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            ViewGroup viewGroup3 = (ViewGroup) from.inflate(R$layout.family_list_title, viewGroup, false);
            j jVar = new j(viewGroup3);
            jVar.f18904a = (TextView) viewGroup3.findViewById(R$id.friendTitle);
            return jVar;
        }
        ViewGroup viewGroup4 = (ViewGroup) from.inflate(R$layout.family_list_item, viewGroup, false);
        g gVar = new g(viewGroup4);
        gVar.f18896a = (TextView) viewGroup4.findViewById(R$id.item_content);
        gVar.f18897b = (ImageView) viewGroup4.findViewById(R$id.itemIcon);
        gVar.f18898c = (Button) viewGroup4.findViewById(R$id.addRefuseButton);
        gVar.f18899d = (Button) viewGroup4.findViewById(R$id.addAgreeButton);
        return gVar;
    }

    public void setOnItemClickListener(i iVar) {
        this.f18907c = iVar;
    }
}
