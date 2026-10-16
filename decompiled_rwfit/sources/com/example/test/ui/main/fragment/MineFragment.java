package com.example.test.ui.main.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.database.table.User;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.AppVersionBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.presenter.device.y;
import com.example.test.presenter.main.a1;
import com.example.test.ui.mine.activity.AboutActivity;
import com.example.test.ui.mine.activity.FeedBackActivity;
import com.example.test.ui.mine.activity.MyQrCodeActivity;
import com.example.test.ui.mine.activity.PersonalActivity;
import com.example.test.ui.mine.activity.PersonalJLActivity;
import com.example.test.ui.mine.activity.SettingActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.u1;
import com.google.android.gms.internal.mlkit_vision_barcode.x1;
import f6.n3;
import g7.r;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class MineFragment extends BaseFragment<a1, n3> implements r, View.OnClickListener {
    public MineFragment() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.MineFragment$tipsDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m58invoke();
                return eh.g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m58invoke() {
                new com.example.test.ui.dialog.r(MineFragment.this.f0());
            }
        });
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new a1(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        n3 n3Var = (n3) this.f7251b;
        if (n3Var != null) {
            return n3Var.f13145a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_mine, viewGroup, false);
        int i3 = R$id.aboutAv;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.avatarIv;
            ImageView imageView = (ImageView) he.a(i3, inflate);
            if (imageView != null) {
                i3 = R$id.checkVersionAv;
                ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView2 != null) {
                    i3 = R$id.personalAv;
                    ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView3 != null) {
                        i3 = R$id.qrCodeAv;
                        ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                        if (actionItemView4 != null) {
                            i3 = R$id.settingAv;
                            ActionItemView actionItemView5 = (ActionItemView) he.a(i3, inflate);
                            if (actionItemView5 != null) {
                                i3 = R$id.suggestAv;
                                ActionItemView actionItemView6 = (ActionItemView) he.a(i3, inflate);
                                if (actionItemView6 != null) {
                                    i3 = R$id.userNameTv;
                                    TextView textView = (TextView) he.a(i3, inflate);
                                    if (textView != null) {
                                        return new n3((NestedScrollView) inflate, actionItemView, imageView, actionItemView2, actionItemView3, actionItemView4, actionItemView5, actionItemView6, textView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        q0(kVar != null ? kVar.d() : null);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        b2.a(this);
        n3 n3Var = (n3) this.f7251b;
        if (n3Var != null) {
            n3Var.f13149f.setOnClickListener(this);
        }
        n3 n3Var2 = (n3) this.f7251b;
        if (n3Var2 != null) {
            n3Var2.e.setOnClickListener(this);
        }
        n3 n3Var3 = (n3) this.f7251b;
        if (n3Var3 != null) {
            n3Var3.f13146b.setOnClickListener(this);
        }
        n3 n3Var4 = (n3) this.f7251b;
        if (n3Var4 != null) {
            n3Var4.f13150g.setOnClickListener(this);
        }
        n3 n3Var5 = (n3) this.f7251b;
        if (n3Var5 != null) {
            n3Var5.f13151h.setOnClickListener(this);
        }
        n3 n3Var6 = (n3) this.f7251b;
        if (n3Var6 != null) {
            n3Var6.f13148d.setOnClickListener(this);
        }
        n3 n3Var7 = (n3) this.f7251b;
        if (n3Var7 != null) {
            n3Var7.f13147c.setOnClickListener(this);
        }
        a1 a1Var = (a1) X();
        MineFragment mineFragment = (MineFragment) ((r) a1Var.f7255a);
        com.example.test.utils.a a3 = u1.a(mineFragment.f0());
        c6.d dVar = c6.d.f3392c;
        String str = a3.f8718a;
        kotlin.jvm.internal.e.e(str, "getVersionName(...)");
        dVar.getClass();
        rg.l<HttpModel<AppVersionBean>> appVersion = ((UserApi) dVar.f113a).getAppVersion("0", str);
        kotlin.jvm.internal.e.e(appVersion, "getAppVersion(...)");
        com.example.baselibrary.utils.b.w(appVersion).subscribe(new y(a1Var, (FragmentActivity) mineFragment.f0(), w0.d(), 5));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
            x1.f9659a = System.currentTimeMillis();
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            int i3 = R$id.personalAv;
            if (valueOf != null && valueOf.intValue() == i3) {
                if (y5.d.f20005b) {
                    startActivity(new Intent(f0(), (Class<?>) PersonalJLActivity.class));
                    return;
                } else {
                    startActivity(new Intent(f0(), (Class<?>) PersonalActivity.class));
                    return;
                }
            }
            int i10 = R$id.aboutAv;
            if (valueOf != null && valueOf.intValue() == i10) {
                startActivity(new Intent(f0(), (Class<?>) AboutActivity.class));
                return;
            }
            int i11 = R$id.settingAv;
            if (valueOf != null && valueOf.intValue() == i11) {
                startActivity(new Intent(f0(), (Class<?>) SettingActivity.class));
                return;
            }
            int i12 = R$id.suggestAv;
            if (valueOf != null && valueOf.intValue() == i12) {
                startActivity(new Intent(f0(), (Class<?>) FeedBackActivity.class));
                return;
            }
            int i13 = R$id.checkVersionAv;
            if (valueOf != null && valueOf.intValue() == i13) {
                return;
            }
            int i14 = R$id.avatarIv;
            if (valueOf != null && valueOf.intValue() == i14) {
                if (y5.d.f20005b) {
                    startActivity(new Intent(f0(), (Class<?>) PersonalJLActivity.class));
                    return;
                } else {
                    startActivity(new Intent(f0(), (Class<?>) PersonalActivity.class));
                    return;
                }
            }
            int i15 = R$id.qrCodeAv;
            if (valueOf != null && valueOf.intValue() == i15) {
                startActivity(new Intent(f0(), (Class<?>) MyQrCodeActivity.class));
            }
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    public final void q0(User user) {
        Context f02 = f0();
        Object obj = this.f7251b;
        kotlin.jvm.internal.e.c(obj);
        ImageView imageView = ((n3) obj).f13147c;
        int i3 = R$mipmap.ic_avatar;
        String str = null;
        String avatar = user != null ? user.getAvatar() : null;
        if (avatar == null) {
            avatar = "";
        }
        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(f02).n(avatar).o(true)).d(z3.h.f20239b)).i(i3), i3)).x(imageView);
        Object obj2 = this.f7251b;
        kotlin.jvm.internal.e.c(obj2);
        n3 n3Var = (n3) obj2;
        String name = user != null ? user.getName() : null;
        if (name == null || name.length() == 0) {
            String account = user != null ? user.getAccount() : null;
            if (account == null || account.length() == 0) {
                str = getString(R$string.str_unset);
            } else if (user != null) {
                str = user.getAccount();
            }
        } else if (user != null) {
            str = user.getName();
        }
        n3Var.f13152i.setText(str);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void userInfoEvent(User user) {
        kotlin.jvm.internal.e.f(user, "user");
        q0(user);
    }
}
