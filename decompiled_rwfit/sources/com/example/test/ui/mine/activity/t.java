package com.example.test.ui.mine.activity;

import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import com.dh.imagepick.ImagePickClient;
import com.example.blesdk.bean.function.PersonBean;
import com.example.database.table.User;
import com.example.network.bean.SwitchBean;
import com.example.test.R$mipmap;
import com.example.test.ui.XXBaseActivity;
import com.example.test.utils.w0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class t implements t6.b, a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PersonalJLActivity f8149a;

    public /* synthetic */ t(PersonalJLActivity personalJLActivity) {
        this.f8149a = personalJLActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.e
    public void B() {
        String avatar;
        String avatar2;
        Log.d("tong", "presenter.updateUserInfo");
        PersonalJLActivity personalJLActivity = this.f8149a;
        int i3 = PersonalJLActivity.I;
        User S0 = personalJLActivity.S0();
        if (S0 != null) {
            com.example.test.presenter.mine.m mVar = (com.example.test.presenter.mine.m) this.f8149a.I0();
            mVar.getClass();
            com.google.android.gms.internal.mlkit_vision_common.p.V(mVar);
            mVar.f7596b = S0;
            ((XXBaseActivity) ((h7.h) mVar.f7255a)).V();
            Log.d("tong", "---saveData2Device-----");
            PersonBean personBean = new PersonBean();
            personBean.setNickName(S0.getName());
            personBean.setStepTarget(S0.getStepsTarget());
            personBean.setHeight((float) S0.getHeight());
            personBean.setWeight((float) S0.getWeight());
            personBean.setGender(S0.getSex());
            personBean.setMeasureUnit(S0.getMeterUnit());
            Calendar calendar = Calendar.getInstance();
            String birthday = S0.getBirthday();
            kotlin.jvm.internal.e.e(birthday, "getBirthday(...)");
            calendar.setTimeInMillis(Long.parseLong(birthday) * 1000);
            personBean.setBirthdayYear(calendar.get(1));
            personBean.setBirthdayMonth(calendar.get(2) + 1);
            personBean.setBirthdayDay(calendar.get(5));
            com.google.android.gms.internal.mlkit_vision_common.p.Q(personBean);
            com.google.android.gms.internal.mlkit_vision_common.p.F(S0.getStepsTarget());
            User user = mVar.f7596b;
            if (user != null) {
                if (user.getPlatform() == 2) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    if (kVar != null) {
                        kVar.G(user);
                    }
                    ((XXBaseActivity) ((h7.h) mVar.f7255a)).b0();
                    Log.d("tong", "onUserInfoSuccess---4");
                    ((h7.h) mVar.f7255a).k();
                    return;
                }
                User user2 = mVar.f7596b;
                if (user2 != null && (avatar2 = user2.getAvatar()) != null && kotlin.text.m.x(avatar2, "http", false)) {
                    mVar.l();
                    return;
                }
                User user3 = mVar.f7596b;
                SwitchBean switchBean = null;
                String avatar3 = user3 != null ? user3.getAvatar() : null;
                if (avatar3 == null || avatar3.length() == 0) {
                    mVar.l();
                    return;
                }
                User user4 = mVar.f7596b;
                if (user4 == null || (avatar = user4.getAvatar()) == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(avatar);
                List list = mVar.f7597c;
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
                    c6.c.f3391c.d(arrayList).subscribe(new com.example.test.presenter.mine.g(mVar, ((h7.h) mVar.f7255a).f0(), w0.d(), 1));
                } else {
                    mVar.l();
                }
            }
        }
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        final PersonalJLActivity personalJLActivity = this.f8149a;
        int i3 = personalJLActivity.F;
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            if (Build.VERSION.SDK_INT < 30) {
                v2.h hVar = new v2.h(personalJLActivity);
                hVar.o("android.permission.WRITE_EXTERNAL_STORAGE");
                hVar.o("android.permission.READ_EXTERNAL_STORAGE");
                final int i10 = 3;
                hVar.p(new nd.b() { // from class: com.example.test.ui.mine.activity.s
                    @Override // nd.b
                    public final void h(boolean z5) {
                        final PersonalJLActivity this$0 = personalJLActivity;
                        switch (i10) {
                            case 0:
                                int i11 = PersonalJLActivity.I;
                                kotlin.jvm.internal.e.f(this$0, "this$0");
                                if (z5) {
                                    this$0.T0().dismiss();
                                    com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // oh.l
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return eh.g.f12633a;
                                        }

                                        public final void invoke(String path) {
                                            kotlin.jvm.internal.e.f(path, "path");
                                            PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                            personalJLActivity2.getClass();
                                            PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                            ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                            int i12 = R$mipmap.ic_avatar;
                                            ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i12), i12)).x(imageView);
                                            User S0 = personalJLActivity3.S0();
                                            if (S0 != null) {
                                                S0.setAvatar(path);
                                            }
                                        }
                                    }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$1$2
                                        @Override // oh.l
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return eh.g.f12633a;
                                        }

                                        public final void invoke(String error) {
                                            kotlin.jvm.internal.e.f(error, "error");
                                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                        }
                                    });
                                    break;
                                }
                                break;
                            case 1:
                                int i12 = PersonalJLActivity.I;
                                kotlin.jvm.internal.e.f(this$0, "this$0");
                                if (z5) {
                                    this$0.T0().dismiss();
                                    com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // oh.l
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return eh.g.f12633a;
                                        }

                                        public final void invoke(String path) {
                                            kotlin.jvm.internal.e.f(path, "path");
                                            PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                            personalJLActivity2.getClass();
                                            PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                            ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                            int i13 = R$mipmap.ic_avatar;
                                            ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i13), i13)).x(imageView);
                                            User S0 = personalJLActivity3.S0();
                                            if (S0 != null) {
                                                S0.setAvatar(path);
                                            }
                                        }
                                    }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$2$2
                                        @Override // oh.l
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return eh.g.f12633a;
                                        }

                                        public final void invoke(String error) {
                                            kotlin.jvm.internal.e.f(error, "error");
                                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                        }
                                    });
                                    break;
                                }
                                break;
                            case 2:
                                int i13 = PersonalJLActivity.I;
                                kotlin.jvm.internal.e.f(this$0, "this$0");
                                if (z5) {
                                    this$0.T0().dismiss();
                                    com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$3$1
                                        {
                                            super(1);
                                        }

                                        @Override // oh.l
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return eh.g.f12633a;
                                        }

                                        public final void invoke(String path) {
                                            kotlin.jvm.internal.e.f(path, "path");
                                            PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                            personalJLActivity2.getClass();
                                            PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                            ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                            int i14 = R$mipmap.ic_avatar;
                                            ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i14), i14)).x(imageView);
                                            User S0 = personalJLActivity3.S0();
                                            if (S0 != null) {
                                                S0.setAvatar(path);
                                            }
                                        }
                                    }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$3$2
                                        @Override // oh.l
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return eh.g.f12633a;
                                        }

                                        public final void invoke(String error) {
                                            kotlin.jvm.internal.e.f(error, "error");
                                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                        }
                                    });
                                    break;
                                }
                                break;
                            default:
                                int i14 = PersonalJLActivity.I;
                                kotlin.jvm.internal.e.f(this$0, "this$0");
                                if (z5) {
                                    this$0.T0().dismiss();
                                    oh.l lVar = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$6$1
                                        {
                                            super(1);
                                        }

                                        @Override // oh.l
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return eh.g.f12633a;
                                        }

                                        public final void invoke(String path) {
                                            kotlin.jvm.internal.e.f(path, "path");
                                            PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                            personalJLActivity2.getClass();
                                            PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                            ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                            int i15 = R$mipmap.ic_avatar;
                                            ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i15), i15)).x(imageView);
                                            User S0 = personalJLActivity3.S0();
                                            if (S0 != null) {
                                                S0.setAvatar(path);
                                            }
                                        }
                                    };
                                    PersonalJLActivity$openPermissionWithType$6$2 errorBack = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$6$2
                                        @Override // oh.l
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return eh.g.f12633a;
                                        }

                                        public final void invoke(String error) {
                                            kotlin.jvm.internal.e.f(error, "error");
                                            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error pick ".concat(error));
                                        }
                                    };
                                    kotlin.jvm.internal.e.f(errorBack, "errorBack");
                                    com.dh.imagepick.work.c with = ImagePickClient.with(this$0);
                                    with.getClass();
                                    com.dh.imagepick.work.c.a(new f5.b(with).i()).h(new com.example.test.utils.p(errorBack, lVar, 0));
                                    break;
                                }
                                break;
                        }
                    }
                });
                return;
            }
            personalJLActivity.T0().dismiss();
            oh.l lVar = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$4
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String path) {
                    kotlin.jvm.internal.e.f(path, "path");
                    PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                    personalJLActivity2.getClass();
                    PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                    ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                    int i11 = R$mipmap.ic_avatar;
                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i11), i11)).x(imageView);
                    User S0 = personalJLActivity3.S0();
                    if (S0 != null) {
                        S0.setAvatar(path);
                    }
                }
            };
            PersonalJLActivity$openPermissionWithType$5 errorBack = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$5
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String error) {
                    kotlin.jvm.internal.e.f(error, "error");
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error pick ".concat(error));
                }
            };
            kotlin.jvm.internal.e.f(errorBack, "errorBack");
            com.dh.imagepick.work.c with = ImagePickClient.with(personalJLActivity);
            with.getClass();
            com.dh.imagepick.work.c.a(new f5.b(with).i()).h(new com.example.test.utils.p(errorBack, lVar, 0));
            return;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            v2.h hVar2 = new v2.h(personalJLActivity);
            hVar2.o("android.permission.CAMERA");
            final int i12 = 0;
            hVar2.p(new nd.b() { // from class: com.example.test.ui.mine.activity.s
                @Override // nd.b
                public final void h(boolean z5) {
                    final PersonalJLActivity this$0 = personalJLActivity;
                    switch (i12) {
                        case 0:
                            int i112 = PersonalJLActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String path) {
                                        kotlin.jvm.internal.e.f(path, "path");
                                        PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                        personalJLActivity2.getClass();
                                        PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                        ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                        int i122 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i122), i122)).x(imageView);
                                        User S0 = personalJLActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$1$2
                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String error) {
                                        kotlin.jvm.internal.e.f(error, "error");
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                    }
                                });
                                break;
                            }
                            break;
                        case 1:
                            int i122 = PersonalJLActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$2$1
                                    {
                                        super(1);
                                    }

                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String path) {
                                        kotlin.jvm.internal.e.f(path, "path");
                                        PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                        personalJLActivity2.getClass();
                                        PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                        ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                        int i13 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i13), i13)).x(imageView);
                                        User S0 = personalJLActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$2$2
                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String error) {
                                        kotlin.jvm.internal.e.f(error, "error");
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                    }
                                });
                                break;
                            }
                            break;
                        case 2:
                            int i13 = PersonalJLActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$3$1
                                    {
                                        super(1);
                                    }

                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String path) {
                                        kotlin.jvm.internal.e.f(path, "path");
                                        PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                        personalJLActivity2.getClass();
                                        PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                        ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                        int i14 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i14), i14)).x(imageView);
                                        User S0 = personalJLActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$3$2
                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String error) {
                                        kotlin.jvm.internal.e.f(error, "error");
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                    }
                                });
                                break;
                            }
                            break;
                        default:
                            int i14 = PersonalJLActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                oh.l lVar2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$6$1
                                    {
                                        super(1);
                                    }

                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String path) {
                                        kotlin.jvm.internal.e.f(path, "path");
                                        PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                        personalJLActivity2.getClass();
                                        PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                        ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                        int i15 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i15), i15)).x(imageView);
                                        User S0 = personalJLActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                };
                                PersonalJLActivity$openPermissionWithType$6$2 errorBack2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$6$2
                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String error) {
                                        kotlin.jvm.internal.e.f(error, "error");
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error pick ".concat(error));
                                    }
                                };
                                kotlin.jvm.internal.e.f(errorBack2, "errorBack");
                                com.dh.imagepick.work.c with2 = ImagePickClient.with(this$0);
                                with2.getClass();
                                com.dh.imagepick.work.c.a(new f5.b(with2).i()).h(new com.example.test.utils.p(errorBack2, lVar2, 0));
                                break;
                            }
                            break;
                    }
                }
            });
            return;
        }
        if (i11 >= 30) {
            v2.h hVar3 = new v2.h(personalJLActivity);
            hVar3.o("android.permission.CAMERA");
            final int i13 = 1;
            hVar3.p(new nd.b() { // from class: com.example.test.ui.mine.activity.s
                @Override // nd.b
                public final void h(boolean z5) {
                    final PersonalJLActivity this$0 = personalJLActivity;
                    switch (i13) {
                        case 0:
                            int i112 = PersonalJLActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String path) {
                                        kotlin.jvm.internal.e.f(path, "path");
                                        PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                        personalJLActivity2.getClass();
                                        PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                        ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                        int i122 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i122), i122)).x(imageView);
                                        User S0 = personalJLActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$1$2
                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String error) {
                                        kotlin.jvm.internal.e.f(error, "error");
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                    }
                                });
                                break;
                            }
                            break;
                        case 1:
                            int i122 = PersonalJLActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$2$1
                                    {
                                        super(1);
                                    }

                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String path) {
                                        kotlin.jvm.internal.e.f(path, "path");
                                        PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                        personalJLActivity2.getClass();
                                        PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                        ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                        int i132 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i132), i132)).x(imageView);
                                        User S0 = personalJLActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$2$2
                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String error) {
                                        kotlin.jvm.internal.e.f(error, "error");
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                    }
                                });
                                break;
                            }
                            break;
                        case 2:
                            int i132 = PersonalJLActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$3$1
                                    {
                                        super(1);
                                    }

                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String path) {
                                        kotlin.jvm.internal.e.f(path, "path");
                                        PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                        personalJLActivity2.getClass();
                                        PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                        ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                        int i14 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i14), i14)).x(imageView);
                                        User S0 = personalJLActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$3$2
                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String error) {
                                        kotlin.jvm.internal.e.f(error, "error");
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                    }
                                });
                                break;
                            }
                            break;
                        default:
                            int i14 = PersonalJLActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                oh.l lVar2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$6$1
                                    {
                                        super(1);
                                    }

                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String path) {
                                        kotlin.jvm.internal.e.f(path, "path");
                                        PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                        personalJLActivity2.getClass();
                                        PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                        ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                        int i15 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i15), i15)).x(imageView);
                                        User S0 = personalJLActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                };
                                PersonalJLActivity$openPermissionWithType$6$2 errorBack2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$6$2
                                    @Override // oh.l
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return eh.g.f12633a;
                                    }

                                    public final void invoke(String error) {
                                        kotlin.jvm.internal.e.f(error, "error");
                                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error pick ".concat(error));
                                    }
                                };
                                kotlin.jvm.internal.e.f(errorBack2, "errorBack");
                                com.dh.imagepick.work.c with2 = ImagePickClient.with(this$0);
                                with2.getClass();
                                com.dh.imagepick.work.c.a(new f5.b(with2).i()).h(new com.example.test.utils.p(errorBack2, lVar2, 0));
                                break;
                            }
                            break;
                    }
                }
            });
            return;
        }
        v2.h hVar4 = new v2.h(personalJLActivity);
        hVar4.o("android.permission.CAMERA");
        hVar4.o("android.permission.READ_EXTERNAL_STORAGE");
        hVar4.o("android.permission.WRITE_EXTERNAL_STORAGE");
        final int i14 = 2;
        hVar4.p(new nd.b() { // from class: com.example.test.ui.mine.activity.s
            @Override // nd.b
            public final void h(boolean z5) {
                final PersonalJLActivity this$0 = personalJLActivity;
                switch (i14) {
                    case 0:
                        int i112 = PersonalJLActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        if (z5) {
                            this$0.T0().dismiss();
                            com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$1$1
                                {
                                    super(1);
                                }

                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String path) {
                                    kotlin.jvm.internal.e.f(path, "path");
                                    PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                    personalJLActivity2.getClass();
                                    PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                    ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                    int i122 = R$mipmap.ic_avatar;
                                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i122), i122)).x(imageView);
                                    User S0 = personalJLActivity3.S0();
                                    if (S0 != null) {
                                        S0.setAvatar(path);
                                    }
                                }
                            }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$1$2
                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String error) {
                                    kotlin.jvm.internal.e.f(error, "error");
                                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                }
                            });
                            break;
                        }
                        break;
                    case 1:
                        int i122 = PersonalJLActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        if (z5) {
                            this$0.T0().dismiss();
                            com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$2$1
                                {
                                    super(1);
                                }

                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String path) {
                                    kotlin.jvm.internal.e.f(path, "path");
                                    PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                    personalJLActivity2.getClass();
                                    PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                    ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                    int i132 = R$mipmap.ic_avatar;
                                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i132), i132)).x(imageView);
                                    User S0 = personalJLActivity3.S0();
                                    if (S0 != null) {
                                        S0.setAvatar(path);
                                    }
                                }
                            }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$2$2
                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String error) {
                                    kotlin.jvm.internal.e.f(error, "error");
                                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                }
                            });
                            break;
                        }
                        break;
                    case 2:
                        int i132 = PersonalJLActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        if (z5) {
                            this$0.T0().dismiss();
                            com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$3$1
                                {
                                    super(1);
                                }

                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String path) {
                                    kotlin.jvm.internal.e.f(path, "path");
                                    PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                    personalJLActivity2.getClass();
                                    PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                    ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                    int i142 = R$mipmap.ic_avatar;
                                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i142), i142)).x(imageView);
                                    User S0 = personalJLActivity3.S0();
                                    if (S0 != null) {
                                        S0.setAvatar(path);
                                    }
                                }
                            }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$3$2
                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String error) {
                                    kotlin.jvm.internal.e.f(error, "error");
                                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error take photo ".concat(error));
                                }
                            });
                            break;
                        }
                        break;
                    default:
                        int i142 = PersonalJLActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        if (z5) {
                            this$0.T0().dismiss();
                            oh.l lVar2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$6$1
                                {
                                    super(1);
                                }

                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String path) {
                                    kotlin.jvm.internal.e.f(path, "path");
                                    PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                    personalJLActivity2.getClass();
                                    PersonalJLActivity personalJLActivity3 = PersonalJLActivity.this;
                                    ImageView imageView = PersonalJLActivity.R0(personalJLActivity3).f12780b;
                                    int i15 = R$mipmap.ic_avatar;
                                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i15), i15)).x(imageView);
                                    User S0 = personalJLActivity3.S0();
                                    if (S0 != null) {
                                        S0.setAvatar(path);
                                    }
                                }
                            };
                            PersonalJLActivity$openPermissionWithType$6$2 errorBack2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$openPermissionWithType$6$2
                                @Override // oh.l
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return eh.g.f12633a;
                                }

                                public final void invoke(String error) {
                                    kotlin.jvm.internal.e.f(error, "error");
                                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error pick ".concat(error));
                                }
                            };
                            kotlin.jvm.internal.e.f(errorBack2, "errorBack");
                            com.dh.imagepick.work.c with2 = ImagePickClient.with(this$0);
                            with2.getClass();
                            com.dh.imagepick.work.c.a(new f5.b(with2).i()).h(new com.example.test.utils.p(errorBack2, lVar2, 0));
                            break;
                        }
                        break;
                }
            }
        });
    }

    @Override // a7.e
    public void u0() {
        this.f8149a.onBackPressed();
    }
}
