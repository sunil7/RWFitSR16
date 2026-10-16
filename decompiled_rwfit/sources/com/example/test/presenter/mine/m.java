package com.example.test.presenter.mine;

import android.util.Log;
import com.example.database.table.User;
import com.example.network.bean.SwitchBean;
import com.example.test.presenter.main.d0;
import com.example.test.utils.w0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class m extends com.example.baselibrary.preseneter.b implements w5.b {

    /* renamed from: b, reason: collision with root package name */
    public User f7596b;

    /* renamed from: c, reason: collision with root package name */
    public List f7597c;

    @Override // w5.b
    public final void d(int i3, int i10) {
        Log.d("tong", "保存用户信息到设备失败 errorCode " + i10);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PersonalPresenter", "保存用户信息到设备失败 errorCode " + i10);
    }

    @Override // w5.b
    public final void h(int i3) {
        Log.d("tong", "---onSuccess-----");
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == this) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    public final void k() {
        com.example.baselibrary.utils.b.y(new oh.l() { // from class: com.example.test.presenter.mine.PersonalJLPresenter$initPrivacy$1
            @Override // oh.l
            public final List<SwitchBean> invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.w();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.mine.PersonalJLPresenter$initPrivacy$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends SwitchBean>) obj);
                return eh.g.f12633a;
            }

            public final void invoke(List<? extends SwitchBean> list) {
                if (list != null) {
                    m.this.f7597c = list;
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        Log.d("tong", "---uploadUser-----");
        User user = this.f7596b;
        if (user != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            SwitchBean switchBean = null;
            User d5 = kVar != null ? kVar.d() : null;
            if ((d5 != null ? d5.getPlatform() : 0) == 2) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 != null) {
                    kVar2.G(user);
                }
                Log.d("tong", "onUserInfoSuccess---1");
                ((h7.h) this.f7255a).k();
                return;
            }
            List list = this.f7597c;
            if (list != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (kotlin.jvm.internal.e.a(((SwitchBean) next).getParaName(), "isPerson")) {
                        switchBean = next;
                        break;
                    }
                }
                switchBean = switchBean;
            }
            if (switchBean != null && kotlin.jvm.internal.e.a(switchBean.getParaValue(), "0")) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                if (kVar3 != null) {
                    kVar3.G(user);
                }
                Log.d("tong", "onUserInfoSuccess---2");
                ((h7.h) this.f7255a).k();
                return;
            }
            c6.d dVar = c6.d.f3392c;
            String name = user.getName();
            kotlin.jvm.internal.e.e(name, "getName(...)");
            String birthday = user.getBirthday();
            kotlin.jvm.internal.e.e(birthday, "getBirthday(...)");
            String valueOf = String.valueOf(user.getSex());
            String valueOf2 = String.valueOf(user.getHeight());
            String valueOf3 = String.valueOf(user.getWeight());
            String avatar = user.getAvatar();
            kotlin.jvm.internal.e.e(avatar, "getAvatar(...)");
            dVar.e(name, birthday, valueOf, valueOf2, valueOf3, avatar, String.valueOf(user.getStepsTarget())).subscribe(new d0(user, this, ((h7.h) this.f7255a).f0(), w0.d(), 4));
        }
    }
}
