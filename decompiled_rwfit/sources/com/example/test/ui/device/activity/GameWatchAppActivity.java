package com.example.test.ui.device.activity;

import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.blesdk.bean.function.GameChildAppBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class GameWatchAppActivity extends XXBaseActivity<com.example.test.presenter.device.e0, f6.g0> implements f7.l, o5.a {
    public static final /* synthetic */ int M = 0;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public final eh.b L = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.GameWatchAppActivity$gameChildAppBean$2
        @Override // oh.a
        public final GameChildAppBean invoke() {
            return new GameChildAppBean();
        }
    });

    public GameWatchAppActivity() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.GameWatchAppActivity$weakHandler$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.baselibrary.utils.e invoke() {
                return new com.example.baselibrary.utils.e(GameWatchAppActivity.this);
            }
        });
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.e0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.g0) this.f7247z.getValue()).f12897a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View a3;
        View a10;
        View a11;
        View a12;
        View a13;
        View a14;
        View inflate = getLayoutInflater().inflate(R$layout.activity_game_watch_app, (ViewGroup) null, false);
        int i3 = R$id.childapp_all;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.childapp_audiobook;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.childapp_bedtimestory;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.childapp_game;
                    ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView4 != null) {
                        i3 = R$id.childapp_learningcards;
                        ActionItemView actionItemView5 = (ActionItemView) he.a(i3, inflate);
                        if (actionItemView5 != null) {
                            i3 = R$id.childapp_music;
                            ActionItemView actionItemView6 = (ActionItemView) he.a(i3, inflate);
                            if (actionItemView6 != null) {
                                i3 = R$id.cl_item_audiobook;
                                ConstraintLayout constraintLayout = (ConstraintLayout) he.a(i3, inflate);
                                if (constraintLayout != null) {
                                    i3 = R$id.cl_item_bedtimestory;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) he.a(i3, inflate);
                                    if (constraintLayout2 != null) {
                                        i3 = R$id.cl_item_game;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) he.a(i3, inflate);
                                        if (constraintLayout3 != null) {
                                            i3 = R$id.cl_item_learningcards;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) he.a(i3, inflate);
                                            if (constraintLayout4 != null) {
                                                i3 = R$id.cl_item_music;
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) he.a(i3, inflate);
                                                if (constraintLayout5 != null && (a3 = he.a((i3 = R$id.notify_per_enable_view_1), inflate)) != null && (a10 = he.a((i3 = R$id.notify_per_enable_view_2), inflate)) != null && (a11 = he.a((i3 = R$id.notify_per_enable_view_3), inflate)) != null && (a12 = he.a((i3 = R$id.notify_per_enable_view_4), inflate)) != null && (a13 = he.a((i3 = R$id.notify_per_enable_view_5), inflate)) != null && (a14 = he.a((i3 = R$id.notify_per_enable_view_6), inflate)) != null) {
                                                    i3 = R$id.titleView;
                                                    TitleView titleView = (TitleView) he.a(i3, inflate);
                                                    if (titleView != null) {
                                                        return new f6.g0((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, actionItemView5, actionItemView6, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, a3, a10, a11, a12, a13, a14, titleView);
                                                    }
                                                }
                                            }
                                        }
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

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.e0) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.g0) bVar.getValue()).f12913s.setOnTitleListener(new androidx.appcompat.app.t(this, 19));
        final int i3 = 0;
        ((f6.g0) bVar.getValue()).f12898b.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.device.activity.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GameWatchAppActivity f7882b;

            {
                this.f7882b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                GameWatchAppActivity this$0 = this.f7882b;
                switch (i3) {
                    case 0:
                        int i10 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAll onStatusChange " + z5 + " isCheckAll " + this$0.K);
                        if (!this$0.K) {
                            this$0.R0().setIsAll(z5 ? 1 : 0);
                            if (this$0.R0().getIsChildGame() != 255) {
                                this$0.R0().setIsChildGame(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsBedtimeStories() != 255) {
                                this$0.R0().setIsBedtimeStories(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsMusic() != 255) {
                                this$0.R0().setIsMusic(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsLearningCards() != 255) {
                                this$0.R0().setIsLearningCards(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsAudioStory() != 255) {
                                this$0.R0().setIsAudioStory(this$0.R0().getIsAll());
                            }
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 1:
                        int i11 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappGame onStatusChange " + z5 + " isCheckGame " + this$0.F);
                        if (!this$0.F) {
                            this$0.R0().setIsChildGame(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 2:
                        int i12 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappBedtimestory onStatusChange " + z5 + " isCheckBedTimeStory " + this$0.G);
                        if (!this$0.G) {
                            this$0.R0().setIsBedtimeStories(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 3:
                        int i13 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappMusic onStatusChange " + z5 + " isCheckMusic " + this$0.H);
                        if (!this$0.H) {
                            this$0.R0().setIsMusic(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 4:
                        int i14 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappLearningcards onStatusChange " + z5 + " isCheckLearningCards " + this$0.I);
                        if (!this$0.I) {
                            this$0.R0().setIsLearningCards(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    default:
                        int i15 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAudiobook onStatusChange " + z5 + " isCheckAudioBook " + this$0.J);
                        if (!this$0.J) {
                            this$0.R0().setIsAudioStory(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                }
            }
        });
        final int i10 = 1;
        ((f6.g0) bVar.getValue()).e.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.device.activity.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GameWatchAppActivity f7882b;

            {
                this.f7882b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                GameWatchAppActivity this$0 = this.f7882b;
                switch (i10) {
                    case 0:
                        int i102 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAll onStatusChange " + z5 + " isCheckAll " + this$0.K);
                        if (!this$0.K) {
                            this$0.R0().setIsAll(z5 ? 1 : 0);
                            if (this$0.R0().getIsChildGame() != 255) {
                                this$0.R0().setIsChildGame(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsBedtimeStories() != 255) {
                                this$0.R0().setIsBedtimeStories(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsMusic() != 255) {
                                this$0.R0().setIsMusic(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsLearningCards() != 255) {
                                this$0.R0().setIsLearningCards(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsAudioStory() != 255) {
                                this$0.R0().setIsAudioStory(this$0.R0().getIsAll());
                            }
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 1:
                        int i11 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappGame onStatusChange " + z5 + " isCheckGame " + this$0.F);
                        if (!this$0.F) {
                            this$0.R0().setIsChildGame(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 2:
                        int i12 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappBedtimestory onStatusChange " + z5 + " isCheckBedTimeStory " + this$0.G);
                        if (!this$0.G) {
                            this$0.R0().setIsBedtimeStories(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 3:
                        int i13 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappMusic onStatusChange " + z5 + " isCheckMusic " + this$0.H);
                        if (!this$0.H) {
                            this$0.R0().setIsMusic(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 4:
                        int i14 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappLearningcards onStatusChange " + z5 + " isCheckLearningCards " + this$0.I);
                        if (!this$0.I) {
                            this$0.R0().setIsLearningCards(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    default:
                        int i15 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAudiobook onStatusChange " + z5 + " isCheckAudioBook " + this$0.J);
                        if (!this$0.J) {
                            this$0.R0().setIsAudioStory(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 2;
        ((f6.g0) bVar.getValue()).f12900d.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.device.activity.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GameWatchAppActivity f7882b;

            {
                this.f7882b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                GameWatchAppActivity this$0 = this.f7882b;
                switch (i11) {
                    case 0:
                        int i102 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAll onStatusChange " + z5 + " isCheckAll " + this$0.K);
                        if (!this$0.K) {
                            this$0.R0().setIsAll(z5 ? 1 : 0);
                            if (this$0.R0().getIsChildGame() != 255) {
                                this$0.R0().setIsChildGame(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsBedtimeStories() != 255) {
                                this$0.R0().setIsBedtimeStories(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsMusic() != 255) {
                                this$0.R0().setIsMusic(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsLearningCards() != 255) {
                                this$0.R0().setIsLearningCards(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsAudioStory() != 255) {
                                this$0.R0().setIsAudioStory(this$0.R0().getIsAll());
                            }
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 1:
                        int i112 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappGame onStatusChange " + z5 + " isCheckGame " + this$0.F);
                        if (!this$0.F) {
                            this$0.R0().setIsChildGame(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 2:
                        int i12 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappBedtimestory onStatusChange " + z5 + " isCheckBedTimeStory " + this$0.G);
                        if (!this$0.G) {
                            this$0.R0().setIsBedtimeStories(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 3:
                        int i13 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappMusic onStatusChange " + z5 + " isCheckMusic " + this$0.H);
                        if (!this$0.H) {
                            this$0.R0().setIsMusic(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 4:
                        int i14 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappLearningcards onStatusChange " + z5 + " isCheckLearningCards " + this$0.I);
                        if (!this$0.I) {
                            this$0.R0().setIsLearningCards(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    default:
                        int i15 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAudiobook onStatusChange " + z5 + " isCheckAudioBook " + this$0.J);
                        if (!this$0.J) {
                            this$0.R0().setIsAudioStory(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 3;
        ((f6.g0) bVar.getValue()).f12902g.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.device.activity.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GameWatchAppActivity f7882b;

            {
                this.f7882b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                GameWatchAppActivity this$0 = this.f7882b;
                switch (i12) {
                    case 0:
                        int i102 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAll onStatusChange " + z5 + " isCheckAll " + this$0.K);
                        if (!this$0.K) {
                            this$0.R0().setIsAll(z5 ? 1 : 0);
                            if (this$0.R0().getIsChildGame() != 255) {
                                this$0.R0().setIsChildGame(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsBedtimeStories() != 255) {
                                this$0.R0().setIsBedtimeStories(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsMusic() != 255) {
                                this$0.R0().setIsMusic(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsLearningCards() != 255) {
                                this$0.R0().setIsLearningCards(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsAudioStory() != 255) {
                                this$0.R0().setIsAudioStory(this$0.R0().getIsAll());
                            }
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 1:
                        int i112 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappGame onStatusChange " + z5 + " isCheckGame " + this$0.F);
                        if (!this$0.F) {
                            this$0.R0().setIsChildGame(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 2:
                        int i122 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappBedtimestory onStatusChange " + z5 + " isCheckBedTimeStory " + this$0.G);
                        if (!this$0.G) {
                            this$0.R0().setIsBedtimeStories(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 3:
                        int i13 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappMusic onStatusChange " + z5 + " isCheckMusic " + this$0.H);
                        if (!this$0.H) {
                            this$0.R0().setIsMusic(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 4:
                        int i14 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappLearningcards onStatusChange " + z5 + " isCheckLearningCards " + this$0.I);
                        if (!this$0.I) {
                            this$0.R0().setIsLearningCards(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    default:
                        int i15 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAudiobook onStatusChange " + z5 + " isCheckAudioBook " + this$0.J);
                        if (!this$0.J) {
                            this$0.R0().setIsAudioStory(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                }
            }
        });
        final int i13 = 4;
        ((f6.g0) bVar.getValue()).f12901f.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.device.activity.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GameWatchAppActivity f7882b;

            {
                this.f7882b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                GameWatchAppActivity this$0 = this.f7882b;
                switch (i13) {
                    case 0:
                        int i102 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAll onStatusChange " + z5 + " isCheckAll " + this$0.K);
                        if (!this$0.K) {
                            this$0.R0().setIsAll(z5 ? 1 : 0);
                            if (this$0.R0().getIsChildGame() != 255) {
                                this$0.R0().setIsChildGame(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsBedtimeStories() != 255) {
                                this$0.R0().setIsBedtimeStories(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsMusic() != 255) {
                                this$0.R0().setIsMusic(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsLearningCards() != 255) {
                                this$0.R0().setIsLearningCards(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsAudioStory() != 255) {
                                this$0.R0().setIsAudioStory(this$0.R0().getIsAll());
                            }
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 1:
                        int i112 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappGame onStatusChange " + z5 + " isCheckGame " + this$0.F);
                        if (!this$0.F) {
                            this$0.R0().setIsChildGame(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 2:
                        int i122 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappBedtimestory onStatusChange " + z5 + " isCheckBedTimeStory " + this$0.G);
                        if (!this$0.G) {
                            this$0.R0().setIsBedtimeStories(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 3:
                        int i132 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappMusic onStatusChange " + z5 + " isCheckMusic " + this$0.H);
                        if (!this$0.H) {
                            this$0.R0().setIsMusic(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 4:
                        int i14 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappLearningcards onStatusChange " + z5 + " isCheckLearningCards " + this$0.I);
                        if (!this$0.I) {
                            this$0.R0().setIsLearningCards(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    default:
                        int i15 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAudiobook onStatusChange " + z5 + " isCheckAudioBook " + this$0.J);
                        if (!this$0.J) {
                            this$0.R0().setIsAudioStory(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                }
            }
        });
        final int i14 = 5;
        ((f6.g0) bVar.getValue()).f12899c.setOnSwitchStatusChangListener(new a7.d(this) { // from class: com.example.test.ui.device.activity.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GameWatchAppActivity f7882b;

            {
                this.f7882b = this;
            }

            @Override // a7.d
            public final void j(boolean z5) {
                GameWatchAppActivity this$0 = this.f7882b;
                switch (i14) {
                    case 0:
                        int i102 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAll onStatusChange " + z5 + " isCheckAll " + this$0.K);
                        if (!this$0.K) {
                            this$0.R0().setIsAll(z5 ? 1 : 0);
                            if (this$0.R0().getIsChildGame() != 255) {
                                this$0.R0().setIsChildGame(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsBedtimeStories() != 255) {
                                this$0.R0().setIsBedtimeStories(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsMusic() != 255) {
                                this$0.R0().setIsMusic(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsLearningCards() != 255) {
                                this$0.R0().setIsLearningCards(this$0.R0().getIsAll());
                            }
                            if (this$0.R0().getIsAudioStory() != 255) {
                                this$0.R0().setIsAudioStory(this$0.R0().getIsAll());
                            }
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 1:
                        int i112 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappGame onStatusChange " + z5 + " isCheckGame " + this$0.F);
                        if (!this$0.F) {
                            this$0.R0().setIsChildGame(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 2:
                        int i122 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappBedtimestory onStatusChange " + z5 + " isCheckBedTimeStory " + this$0.G);
                        if (!this$0.G) {
                            this$0.R0().setIsBedtimeStories(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 3:
                        int i132 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappMusic onStatusChange " + z5 + " isCheckMusic " + this$0.H);
                        if (!this$0.H) {
                            this$0.R0().setIsMusic(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    case 4:
                        int i142 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappLearningcards onStatusChange " + z5 + " isCheckLearningCards " + this$0.I);
                        if (!this$0.I) {
                            this$0.R0().setIsLearningCards(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                    default:
                        int i15 = GameWatchAppActivity.M;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        Log.e("qob", "childappAudiobook onStatusChange " + z5 + " isCheckAudioBook " + this$0.J);
                        if (!this$0.J) {
                            this$0.R0().setIsAudioStory(z5 ? 1 : 0);
                            this$0.T0(this$0.R0());
                            break;
                        }
                        break;
                }
            }
        });
    }

    public final GameChildAppBean R0() {
        return (GameChildAppBean) this.L.getValue();
    }

    public final void S0(GameChildAppBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        R0().setIsAll(data.getIsAll());
        R0().setIsChildGame(data.getIsChildGame());
        R0().setIsBedtimeStories(data.getIsBedtimeStories());
        R0().setIsMusic(data.getIsMusic());
        R0().setIsLearningCards(data.getIsLearningCards());
        R0().setIsAudioStory(data.getIsAudioStory());
        this.K = true;
        eh.b bVar = this.f7247z;
        ((f6.g0) bVar.getValue()).f12898b.setItemOpen(data.getIsAll() > 0);
        this.K = false;
        this.E = 0;
        if (data.getIsChildGame() == 255) {
            ((f6.g0) bVar.getValue()).f12905j.setVisibility(8);
        } else {
            ((f6.g0) bVar.getValue()).f12905j.setVisibility(0);
            this.F = true;
            ((f6.g0) bVar.getValue()).e.setItemOpen(data.getIsChildGame() > 0);
            this.F = false;
            this.E++;
        }
        if (data.getIsBedtimeStories() == 255) {
            ((f6.g0) bVar.getValue()).f12904i.setVisibility(8);
        } else {
            ((f6.g0) bVar.getValue()).f12904i.setVisibility(0);
            this.G = true;
            ((f6.g0) bVar.getValue()).f12900d.setItemOpen(data.getIsBedtimeStories() > 0);
            this.G = false;
            this.E++;
        }
        if (data.getIsMusic() == 255) {
            ((f6.g0) bVar.getValue()).f12907l.setVisibility(8);
        } else {
            ((f6.g0) bVar.getValue()).f12907l.setVisibility(0);
            this.H = true;
            ((f6.g0) bVar.getValue()).f12902g.setItemOpen(data.getIsMusic() > 0);
            this.H = false;
            this.E++;
        }
        if (data.getIsLearningCards() == 255) {
            ((f6.g0) bVar.getValue()).f12906k.setVisibility(8);
        } else {
            ((f6.g0) bVar.getValue()).f12906k.setVisibility(0);
            this.I = true;
            ((f6.g0) bVar.getValue()).f12901f.setItemOpen(data.getIsLearningCards() > 0);
            this.I = false;
            this.E++;
        }
        if (data.getIsAudioStory() == 255) {
            ((f6.g0) bVar.getValue()).f12903h.setVisibility(8);
            return;
        }
        ((f6.g0) bVar.getValue()).f12903h.setVisibility(0);
        this.J = true;
        ((f6.g0) bVar.getValue()).f12899c.setItemOpen(data.getIsAudioStory() > 0);
        this.J = false;
        this.E++;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T0(com.example.blesdk.bean.function.GameChildAppBean r8) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.GameWatchAppActivity.T0(com.example.blesdk.bean.function.GameChildAppBean):void");
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
    }
}
