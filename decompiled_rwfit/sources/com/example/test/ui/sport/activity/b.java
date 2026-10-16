package com.example.test.ui.sport.activity;

import android.content.Intent;
import com.example.test.R$string;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8160a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SportCountDownNewActivity f8161b;

    public /* synthetic */ b(SportCountDownNewActivity sportCountDownNewActivity, int i3) {
        this.f8160a = i3;
        this.f8161b = sportCountDownNewActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SportCountDownNewActivity this$0 = this.f8161b;
        switch (this.f8160a) {
            case 0:
                int i3 = SportCountDownNewActivity.I;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (y5.d.f20005b) {
                    int S0 = this$0.S0();
                    Intent intent = new Intent(this$0, (Class<?>) SportNewDetailJLActivity.class);
                    intent.putExtra("sport_type", S0);
                    this$0.startActivity(intent);
                } else {
                    int S02 = this$0.S0();
                    Intent intent2 = new Intent(this$0, (Class<?>) SportNewDetailJLActivity.class);
                    intent2.putExtra("sport_type", S02);
                    this$0.startActivity(intent2);
                }
                this$0.finish();
                break;
            default:
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!r5.b.k().f18054c) {
                    com.example.baselibrary.utils.d.a(R$string.str_device_disconnected);
                    this$0.finish();
                    break;
                } else {
                    if (y5.d.f20005b) {
                        int i10 = SportNewDetailJLActivity.Q;
                        int i11 = SportCountDownNewActivity.I;
                        int S03 = this$0.S0();
                        Intent intent3 = new Intent(this$0, (Class<?>) SportNewDetailJLActivity.class);
                        intent3.putExtra("sport_type", S03);
                        this$0.startActivity(intent3);
                    } else {
                        int i12 = SportNewDetailJLActivity.Q;
                        int i13 = SportCountDownNewActivity.I;
                        int S04 = this$0.S0();
                        Intent intent4 = new Intent(this$0, (Class<?>) SportNewDetailJLActivity.class);
                        intent4.putExtra("sport_type", S04);
                        this$0.startActivity(intent4);
                    }
                    this$0.finish();
                    break;
                }
        }
    }
}
