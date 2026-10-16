package com.example.test.presenter.mine;

import com.example.database.table.User;
import com.example.network.bean.SwitchBean;
import com.example.test.presenter.main.d0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class n extends com.example.baselibrary.preseneter.b implements w5.c {

    /* renamed from: b, reason: collision with root package name */
    public User f7598b;

    /* renamed from: c, reason: collision with root package name */
    public List f7599c;

    @Override // w5.c
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "PersonalPresenter", l0.j(i3, "保存用户信息到设备失败 errorCode "));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            if (d5.getPlatform() != 2) {
                l();
                return;
            }
            User user = this.f7598b;
            if (user != null) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 != null) {
                    kVar2.G(user);
                }
                ((XXBaseActivity) ((h7.h) this.f7255a)).b0();
                ((h7.h) this.f7255a).k();
            }
        }
    }

    @Override // w5.c
    public final void c() {
        User user = this.f7598b;
        if (user != null) {
            if (user.getPlatform() != 2) {
                l();
                return;
            }
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.G(user);
            }
            ((XXBaseActivity) ((h7.h) this.f7255a)).b0();
            ((h7.h) this.f7255a).k();
        }
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
        com.example.baselibrary.utils.b.y(new oh.l() { // from class: com.example.test.presenter.mine.PersonalPresenter$initPrivacy$1
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
        }, new oh.l() { // from class: com.example.test.presenter.mine.PersonalPresenter$initPrivacy$2
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
                    n.this.f7599c = list;
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        String avatar;
        String avatar2;
        User user = this.f7598b;
        if (user != null && (avatar2 = user.getAvatar()) != null && kotlin.text.m.x(avatar2, "http", false)) {
            m();
            return;
        }
        User user2 = this.f7598b;
        SwitchBean switchBean = null;
        String avatar3 = user2 != null ? user2.getAvatar() : null;
        if (avatar3 == null || avatar3.length() == 0) {
            m();
            return;
        }
        User user3 = this.f7598b;
        if (user3 == null || (avatar = user3.getAvatar()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(avatar);
        List list = this.f7599c;
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
        if (switchBean == null || !kotlin.jvm.internal.e.a(switchBean.getParaValue(), "0")) {
            c6.c.f3391c.d(arrayList).subscribe(new g(this, ((h7.h) this.f7255a).f0(), w0.d(), 2));
        } else {
            m();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m() {
        User user = this.f7598b;
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
                ((h7.h) this.f7255a).k();
                return;
            }
            List list = this.f7599c;
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
            dVar.e(name, birthday, valueOf, valueOf2, valueOf3, avatar, String.valueOf(user.getStepsTarget())).subscribe(new d0(user, this, ((h7.h) this.f7255a).f0(), w0.d(), 5));
        }
    }
}
