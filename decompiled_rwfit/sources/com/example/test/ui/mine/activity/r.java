package com.example.test.ui.mine.activity;

import android.os.Build;
import android.widget.ImageView;
import com.dh.imagepick.ImagePickClient;
import com.example.database.table.User;
import com.example.test.R$mipmap;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class r implements t6.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8144a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.example.test.ui.dialog.j f8145b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f8146c;

    public /* synthetic */ r(com.example.test.ui.dialog.j jVar, XXBaseActivity xXBaseActivity, int i3) {
        this.f8144a = i3;
        this.f8145b = jVar;
        this.f8146c = xXBaseActivity;
    }

    @Override // t6.c
    public final void a(int i3) {
        switch (this.f8144a) {
            case 0:
                com.example.test.ui.dialog.j jVar = this.f8145b;
                final PersonalActivity context = (PersonalActivity) this.f8146c;
                if (i3 == 0) {
                    if (Build.VERSION.SDK_INT < 30 && !v2.h.k(context, new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        context.F = 1;
                        ((com.example.test.ui.dialog.i) context.G.getValue()).show();
                        break;
                    } else if (!v2.h.k(context, new String[]{"android.permission.CAMERA"})) {
                        context.F = 1;
                        ((com.example.test.ui.dialog.i) context.G.getValue()).show();
                        break;
                    } else {
                        jVar.dismiss();
                        com.example.test.utils.q.a(context, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$selectDialog$2$1$onSelected$1
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
                                PersonalActivity personalActivity = PersonalActivity.this;
                                personalActivity.getClass();
                                PersonalActivity personalActivity2 = PersonalActivity.this;
                                ImageView imageView = PersonalActivity.R0(personalActivity2).f12780b;
                                int i10 = R$mipmap.ic_avatar;
                                ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity).n(path).o(true)).d(z3.h.f20239b)).i(i10), i10)).x(imageView);
                                User S0 = personalActivity2.S0();
                                if (S0 != null) {
                                    S0.setAvatar(path);
                                }
                            }
                        }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$selectDialog$2$1$onSelected$2
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
                } else if (i3 == 1) {
                    if (Build.VERSION.SDK_INT < 30 && !v2.h.k(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        context.F = 2;
                        ((com.example.test.ui.dialog.i) context.G.getValue()).show();
                        break;
                    } else {
                        jVar.dismiss();
                        oh.l lVar = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$selectDialog$2$1$onSelected$3
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
                                PersonalActivity personalActivity = PersonalActivity.this;
                                personalActivity.getClass();
                                PersonalActivity personalActivity2 = PersonalActivity.this;
                                ImageView imageView = PersonalActivity.R0(personalActivity2).f12780b;
                                int i10 = R$mipmap.ic_avatar;
                                ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalActivity).n(path).o(true)).d(z3.h.f20239b)).i(i10), i10)).x(imageView);
                                User S0 = personalActivity2.S0();
                                if (S0 != null) {
                                    S0.setAvatar(path);
                                }
                            }
                        };
                        PersonalActivity$selectDialog$2$1$onSelected$4 errorBack = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalActivity$selectDialog$2$1$onSelected$4
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
                        kotlin.jvm.internal.e.f(context, "context");
                        kotlin.jvm.internal.e.f(errorBack, "errorBack");
                        com.dh.imagepick.work.c with = ImagePickClient.with(context);
                        with.getClass();
                        com.dh.imagepick.work.c.a(new f5.b(with).i()).h(new com.example.test.utils.p(errorBack, lVar, 0));
                        break;
                    }
                } else if (i3 == 2) {
                    jVar.dismiss();
                    break;
                }
                break;
            default:
                com.example.test.ui.dialog.j jVar2 = this.f8145b;
                final PersonalJLActivity context2 = (PersonalJLActivity) this.f8146c;
                if (i3 == 0) {
                    if (Build.VERSION.SDK_INT < 30 && !v2.h.k(context2, new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        context2.F = 1;
                        ((com.example.test.ui.dialog.i) context2.G.getValue()).show();
                        break;
                    } else if (!v2.h.k(context2, new String[]{"android.permission.CAMERA"})) {
                        context2.F = 1;
                        ((com.example.test.ui.dialog.i) context2.G.getValue()).show();
                        break;
                    } else {
                        jVar2.dismiss();
                        com.example.test.utils.q.a(context2, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$selectDialog$2$1$onSelected$1
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
                                PersonalJLActivity personalJLActivity = PersonalJLActivity.this;
                                personalJLActivity.getClass();
                                PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                ImageView imageView = PersonalJLActivity.R0(personalJLActivity2).f12780b;
                                int i10 = R$mipmap.ic_avatar;
                                ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity).n(path).o(true)).d(z3.h.f20239b)).i(i10), i10)).x(imageView);
                                User S0 = personalJLActivity2.S0();
                                if (S0 != null) {
                                    S0.setAvatar(path);
                                }
                            }
                        }, new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$selectDialog$2$1$onSelected$2
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
                } else if (i3 == 1) {
                    if (Build.VERSION.SDK_INT < 30 && !v2.h.k(context2, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        context2.F = 2;
                        ((com.example.test.ui.dialog.i) context2.G.getValue()).show();
                        break;
                    } else {
                        jVar2.dismiss();
                        oh.l lVar2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$selectDialog$2$1$onSelected$3
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
                                PersonalJLActivity personalJLActivity = PersonalJLActivity.this;
                                personalJLActivity.getClass();
                                PersonalJLActivity personalJLActivity2 = PersonalJLActivity.this;
                                ImageView imageView = PersonalJLActivity.R0(personalJLActivity2).f12780b;
                                int i10 = R$mipmap.ic_avatar;
                                ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(personalJLActivity).n(path).o(true)).d(z3.h.f20239b)).i(i10), i10)).x(imageView);
                                User S0 = personalJLActivity2.S0();
                                if (S0 != null) {
                                    S0.setAvatar(path);
                                }
                            }
                        };
                        PersonalJLActivity$selectDialog$2$1$onSelected$4 errorBack2 = new oh.l() { // from class: com.example.test.ui.mine.activity.PersonalJLActivity$selectDialog$2$1$onSelected$4
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
                        kotlin.jvm.internal.e.f(context2, "context");
                        kotlin.jvm.internal.e.f(errorBack2, "errorBack");
                        com.dh.imagepick.work.c with2 = ImagePickClient.with(context2);
                        with2.getClass();
                        com.dh.imagepick.work.c.a(new f5.b(with2).i()).h(new com.example.test.utils.p(errorBack2, lVar2, 0));
                        break;
                    }
                } else if (i3 == 2) {
                    jVar2.dismiss();
                    break;
                }
                break;
        }
    }
}
