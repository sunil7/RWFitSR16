package com.example.test.ui.mine.activity;

import android.os.Build;
import android.widget.ImageView;
import com.dh.imagepick.ImagePickClient;
import com.example.blesdk.bean.function.PersonBean;
import com.example.database.table.User;
import com.example.test.R$mipmap;
import com.example.test.ui.XXBaseActivity;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class q implements t6.b, a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PersonalActivity f8143a;

    public /* synthetic */ q(PersonalActivity personalActivity) {
        this.f8143a = personalActivity;
    }

    @Override // a7.e
    public void B() {
        int i3 = PersonalActivity.I;
        PersonalActivity personalActivity = this.f8143a;
        User S0 = personalActivity.S0();
        if (S0 != null) {
            com.example.test.presenter.mine.n nVar = (com.example.test.presenter.mine.n) personalActivity.I0();
            nVar.getClass();
            com.google.android.gms.internal.mlkit_vision_common.p.T(46, nVar);
            nVar.f7598b = S0;
            ((XXBaseActivity) ((h7.h) nVar.f7255a)).V();
            PersonBean personBean = new PersonBean();
            personBean.setNickName(S0.getName());
            personBean.setStepTarget(S0.getStepsTarget());
            personBean.setHeight((float) S0.getHeight());
            personBean.setWeight((float) S0.getWeight());
            personBean.setGender(S0.getSex());
            Calendar calendar = Calendar.getInstance();
            String birthday = S0.getBirthday();
            kotlin.jvm.internal.e.e(birthday, "getBirthday(...)");
            calendar.setTimeInMillis(Long.parseLong(birthday) * 1000);
            personBean.setBirthdayYear(calendar.get(1));
            personBean.setBirthdayMonth(calendar.get(2) + 1);
            personBean.setBirthdayDay(calendar.get(5));
            com.google.android.gms.internal.mlkit_vision_common.p.x(personBean);
        }
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        final PersonalActivity personalActivity = this.f8143a;
        int i3 = personalActivity.F;
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            if (Build.VERSION.SDK_INT < 30) {
                v2.h hVar = new v2.h(personalActivity);
                hVar.o("android.permission.WRITE_EXTERNAL_STORAGE");
                hVar.o("android.permission.READ_EXTERNAL_STORAGE");
                final int i10 = 3;
                hVar.p(new nd.b() { // from class: com.example.test.ui.mine.activity.p
                    @Override // nd.b
                    public final void h(boolean z5) {
                        final PersonalActivity this$0 = personalActivity;
                        switch (i10) {
                            case 0:
                                int i11 = PersonalActivity.I;
                                kotlin.jvm.internal.e.f(this$0, "this$0");
                                if (z5) {
                                    this$0.T0().dismiss();
                                    com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$1$1
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
                                            PersonalActivity personalActivity2 = PersonalActivity.this;
                                            personalActivity2.getClass();
                                            PersonalActivity personalActivity3 = PersonalActivity.this;
                                            ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                            int i12 = R$mipmap.ic_avatar;
                                            ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i12), i12)).x(imageView);
                                            User S0 = personalActivity3.S0();
                                            if (S0 != null) {
                                                S0.setAvatar(path);
                                            }
                                        }
                                    }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$1$2
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
                                int i12 = PersonalActivity.I;
                                kotlin.jvm.internal.e.f(this$0, "this$0");
                                if (z5) {
                                    this$0.T0().dismiss();
                                    com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$2$1
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
                                            PersonalActivity personalActivity2 = PersonalActivity.this;
                                            personalActivity2.getClass();
                                            PersonalActivity personalActivity3 = PersonalActivity.this;
                                            ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                            int i13 = R$mipmap.ic_avatar;
                                            ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i13), i13)).x(imageView);
                                            User S0 = personalActivity3.S0();
                                            if (S0 != null) {
                                                S0.setAvatar(path);
                                            }
                                        }
                                    }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$2$2
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
                                int i13 = PersonalActivity.I;
                                kotlin.jvm.internal.e.f(this$0, "this$0");
                                if (z5) {
                                    this$0.T0().dismiss();
                                    com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$3$1
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
                                            PersonalActivity personalActivity2 = PersonalActivity.this;
                                            personalActivity2.getClass();
                                            PersonalActivity personalActivity3 = PersonalActivity.this;
                                            ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                            int i14 = R$mipmap.ic_avatar;
                                            ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i14), i14)).x(imageView);
                                            User S0 = personalActivity3.S0();
                                            if (S0 != null) {
                                                S0.setAvatar(path);
                                            }
                                        }
                                    }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$3$2
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
                                int i14 = PersonalActivity.I;
                                kotlin.jvm.internal.e.f(this$0, "this$0");
                                if (z5) {
                                    this$0.T0().dismiss();
                                    oh.l lVar = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$6$1
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
                                            PersonalActivity personalActivity2 = PersonalActivity.this;
                                            personalActivity2.getClass();
                                            PersonalActivity personalActivity3 = PersonalActivity.this;
                                            ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                            int i15 = R$mipmap.ic_avatar;
                                            ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i15), i15)).x(imageView);
                                            User S0 = personalActivity3.S0();
                                            if (S0 != null) {
                                                S0.setAvatar(path);
                                            }
                                        }
                                    };
                                    PersonalActivity$openPermissionWithType$6$2 errorBack = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$6$2
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
            personalActivity.T0().dismiss();
            oh.l lVar = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$4
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
                    PersonalActivity personalActivity2 = PersonalActivity.this;
                    personalActivity2.getClass();
                    PersonalActivity personalActivity3 = PersonalActivity.this;
                    ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                    int i11 = R$mipmap.ic_avatar;
                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i11), i11)).x(imageView);
                    User S0 = personalActivity3.S0();
                    if (S0 != null) {
                        S0.setAvatar(path);
                    }
                }
            };
            PersonalActivity$openPermissionWithType$5 errorBack = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$5
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
            com.dh.imagepick.work.c with = ImagePickClient.with(personalActivity);
            with.getClass();
            com.dh.imagepick.work.c.a(new f5.b(with).i()).h(new com.example.test.utils.p(errorBack, lVar, 0));
            return;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            v2.h hVar2 = new v2.h(personalActivity);
            hVar2.o("android.permission.CAMERA");
            final int i12 = 0;
            hVar2.p(new nd.b() { // from class: com.example.test.ui.mine.activity.p
                @Override // nd.b
                public final void h(boolean z5) {
                    final PersonalActivity this$0 = personalActivity;
                    switch (i12) {
                        case 0:
                            int i112 = PersonalActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$1$1
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
                                        PersonalActivity personalActivity2 = PersonalActivity.this;
                                        personalActivity2.getClass();
                                        PersonalActivity personalActivity3 = PersonalActivity.this;
                                        ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                        int i122 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i122), i122)).x(imageView);
                                        User S0 = personalActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$1$2
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
                            int i122 = PersonalActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$2$1
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
                                        PersonalActivity personalActivity2 = PersonalActivity.this;
                                        personalActivity2.getClass();
                                        PersonalActivity personalActivity3 = PersonalActivity.this;
                                        ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                        int i13 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i13), i13)).x(imageView);
                                        User S0 = personalActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$2$2
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
                            int i13 = PersonalActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$3$1
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
                                        PersonalActivity personalActivity2 = PersonalActivity.this;
                                        personalActivity2.getClass();
                                        PersonalActivity personalActivity3 = PersonalActivity.this;
                                        ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                        int i14 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i14), i14)).x(imageView);
                                        User S0 = personalActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$3$2
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
                            int i14 = PersonalActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                oh.l lVar2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$6$1
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
                                        PersonalActivity personalActivity2 = PersonalActivity.this;
                                        personalActivity2.getClass();
                                        PersonalActivity personalActivity3 = PersonalActivity.this;
                                        ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                        int i15 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i15), i15)).x(imageView);
                                        User S0 = personalActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                };
                                PersonalActivity$openPermissionWithType$6$2 errorBack2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$6$2
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
            v2.h hVar3 = new v2.h(personalActivity);
            hVar3.o("android.permission.CAMERA");
            final int i13 = 1;
            hVar3.p(new nd.b() { // from class: com.example.test.ui.mine.activity.p
                @Override // nd.b
                public final void h(boolean z5) {
                    final PersonalActivity this$0 = personalActivity;
                    switch (i13) {
                        case 0:
                            int i112 = PersonalActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$1$1
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
                                        PersonalActivity personalActivity2 = PersonalActivity.this;
                                        personalActivity2.getClass();
                                        PersonalActivity personalActivity3 = PersonalActivity.this;
                                        ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                        int i122 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i122), i122)).x(imageView);
                                        User S0 = personalActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$1$2
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
                            int i122 = PersonalActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$2$1
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
                                        PersonalActivity personalActivity2 = PersonalActivity.this;
                                        personalActivity2.getClass();
                                        PersonalActivity personalActivity3 = PersonalActivity.this;
                                        ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                        int i132 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i132), i132)).x(imageView);
                                        User S0 = personalActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$2$2
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
                            int i132 = PersonalActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$3$1
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
                                        PersonalActivity personalActivity2 = PersonalActivity.this;
                                        personalActivity2.getClass();
                                        PersonalActivity personalActivity3 = PersonalActivity.this;
                                        ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                        int i14 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i14), i14)).x(imageView);
                                        User S0 = personalActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$3$2
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
                            int i14 = PersonalActivity.I;
                            kotlin.jvm.internal.e.f(this$0, "this$0");
                            if (z5) {
                                this$0.T0().dismiss();
                                oh.l lVar2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$6$1
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
                                        PersonalActivity personalActivity2 = PersonalActivity.this;
                                        personalActivity2.getClass();
                                        PersonalActivity personalActivity3 = PersonalActivity.this;
                                        ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                        int i15 = R$mipmap.ic_avatar;
                                        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i15), i15)).x(imageView);
                                        User S0 = personalActivity3.S0();
                                        if (S0 != null) {
                                            S0.setAvatar(path);
                                        }
                                    }
                                };
                                PersonalActivity$openPermissionWithType$6$2 errorBack2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$6$2
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
        v2.h hVar4 = new v2.h(personalActivity);
        hVar4.o("android.permission.CAMERA");
        hVar4.o("android.permission.READ_EXTERNAL_STORAGE");
        hVar4.o("android.permission.WRITE_EXTERNAL_STORAGE");
        final int i14 = 2;
        hVar4.p(new nd.b() { // from class: com.example.test.ui.mine.activity.p
            @Override // nd.b
            public final void h(boolean z5) {
                final PersonalActivity this$0 = personalActivity;
                switch (i14) {
                    case 0:
                        int i112 = PersonalActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        if (z5) {
                            this$0.T0().dismiss();
                            com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$1$1
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
                                    PersonalActivity personalActivity2 = PersonalActivity.this;
                                    personalActivity2.getClass();
                                    PersonalActivity personalActivity3 = PersonalActivity.this;
                                    ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                    int i122 = R$mipmap.ic_avatar;
                                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i122), i122)).x(imageView);
                                    User S0 = personalActivity3.S0();
                                    if (S0 != null) {
                                        S0.setAvatar(path);
                                    }
                                }
                            }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$1$2
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
                        int i122 = PersonalActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        if (z5) {
                            this$0.T0().dismiss();
                            com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$2$1
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
                                    PersonalActivity personalActivity2 = PersonalActivity.this;
                                    personalActivity2.getClass();
                                    PersonalActivity personalActivity3 = PersonalActivity.this;
                                    ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                    int i132 = R$mipmap.ic_avatar;
                                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i132), i132)).x(imageView);
                                    User S0 = personalActivity3.S0();
                                    if (S0 != null) {
                                        S0.setAvatar(path);
                                    }
                                }
                            }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$2$2
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
                        int i132 = PersonalActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        if (z5) {
                            this$0.T0().dismiss();
                            com.example.test.utils.q.a(this$0, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$3$1
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
                                    PersonalActivity personalActivity2 = PersonalActivity.this;
                                    personalActivity2.getClass();
                                    PersonalActivity personalActivity3 = PersonalActivity.this;
                                    ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                    int i142 = R$mipmap.ic_avatar;
                                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i142), i142)).x(imageView);
                                    User S0 = personalActivity3.S0();
                                    if (S0 != null) {
                                        S0.setAvatar(path);
                                    }
                                }
                            }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$3$2
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
                        int i142 = PersonalActivity.I;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        if (z5) {
                            this$0.T0().dismiss();
                            oh.l lVar2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$6$1
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
                                    PersonalActivity personalActivity2 = PersonalActivity.this;
                                    personalActivity2.getClass();
                                    PersonalActivity personalActivity3 = PersonalActivity.this;
                                    ImageView imageView = PersonalActivity.R0(personalActivity3).f12780b;
                                    int i15 = R$mipmap.ic_avatar;
                                    ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity2).n(path).o(true)).d(z3.h.f20239b)).i(i15), i15)).x(imageView);
                                    User S0 = personalActivity3.S0();
                                    if (S0 != null) {
                                        S0.setAvatar(path);
                                    }
                                }
                            };
                            PersonalActivity$openPermissionWithType$6$2 errorBack2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$openPermissionWithType$6$2
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
        this.f8143a.onBackPressed();
    }
}
