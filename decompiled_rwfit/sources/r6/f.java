package r6;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.u0;
import androidx.fragment.app.x0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.DialMarketActivity;
import com.example.test.ui.device.fragment.DialRecommendFragment;
import com.example.test.ui.main.activity.BODetailActivity;
import com.example.test.ui.main.activity.BPDetailActivity;
import com.example.test.ui.main.activity.BSDetailActivity;
import com.example.test.ui.main.activity.BTDetailActivity;
import com.example.test.ui.main.activity.BreatheDetailActivity;
import com.example.test.ui.main.activity.HRDetailActivity;
import com.example.test.ui.main.activity.SleepDetailActivity;
import com.example.test.ui.main.activity.StepDetailActivity;
import com.example.test.ui.main.activity.SugarDetailActivity;
import com.example.test.ui.main.fragment.BOStatisticsFragment;
import com.example.test.ui.main.fragment.BPStatisticsFragment;
import com.example.test.ui.main.fragment.BSStatisticsFragment;
import com.example.test.ui.main.fragment.BTStatisticsFragment;
import com.example.test.ui.main.fragment.BreatheDayFragment;
import com.example.test.ui.main.fragment.BreatheStatisticsFragment;
import com.example.test.ui.main.fragment.HRStatisticsFragment;
import com.example.test.ui.main.fragment.SleepStatisticsFragment;
import com.example.test.ui.main.fragment.StepStatisticsFragment;
import com.example.test.ui.main.fragment.SugarStatisticsFragment;
import u6.o;
import u6.r;
import u6.v;
import u6.w;

/* loaded from: classes.dex */
public final class f extends x0 {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f18099g;

    /* renamed from: h, reason: collision with root package name */
    public final XXBaseActivity f18100h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(XXBaseActivity xXBaseActivity, u0 u0Var, int i3) {
        super(u0Var);
        this.f18099g = i3;
        this.f18100h = xXBaseActivity;
    }

    @Override // n2.a
    public final int c() {
        switch (this.f18099g) {
        }
        return 4;
    }

    @Override // n2.a
    public final CharSequence e(int i3) {
        switch (this.f18099g) {
            case 0:
                return ((DialMarketActivity) this.f18100h).getResources().getString(g.f18101a[i3].intValue());
            case 1:
                return ((BODetailActivity) this.f18100h).getResources().getString(u6.a.f18888a[i3].intValue());
            case 2:
                return ((BPDetailActivity) this.f18100h).getResources().getString(u6.b.f18889a[i3].intValue());
            case 3:
                return ((BSDetailActivity) this.f18100h).getResources().getString(u6.c.f18890a[i3].intValue());
            case 4:
                return ((BTDetailActivity) this.f18100h).getResources().getString(u6.d.f18891a[i3].intValue());
            case 5:
                return ((BreatheDetailActivity) this.f18100h).getResources().getString(u6.e.f18892a[i3].intValue());
            case 6:
                return ((HRDetailActivity) this.f18100h).getResources().getString(o.f18913a[i3].intValue());
            case 7:
                return ((SleepDetailActivity) this.f18100h).getResources().getString(r.f18922a[i3].intValue());
            case 8:
                return ((StepDetailActivity) this.f18100h).getResources().getString(v.f18928a[i3].intValue());
            default:
                return ((SugarDetailActivity) this.f18100h).getResources().getString(w.f18929a[i3].intValue());
        }
    }

    @Override // androidx.fragment.app.x0
    public final Fragment k(int i3) {
        switch (this.f18099g) {
            case 0:
                if (i3 != 0 && i3 == 1) {
                    return new com.example.test.ui.device.fragment.a();
                }
                return new DialRecommendFragment();
            case 1:
                BOStatisticsFragment bOStatisticsFragment = new BOStatisticsFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("statistics_type", i3);
                bOStatisticsFragment.setArguments(bundle);
                return bOStatisticsFragment;
            case 2:
                BPStatisticsFragment bPStatisticsFragment = new BPStatisticsFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("statistics_type", i3);
                bPStatisticsFragment.setArguments(bundle2);
                return bPStatisticsFragment;
            case 3:
                BSStatisticsFragment bSStatisticsFragment = new BSStatisticsFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("statistics_type", i3);
                bSStatisticsFragment.setArguments(bundle3);
                return bSStatisticsFragment;
            case 4:
                BTStatisticsFragment bTStatisticsFragment = new BTStatisticsFragment();
                Bundle bundle4 = new Bundle();
                bundle4.putInt("statistics_type", i3);
                bTStatisticsFragment.setArguments(bundle4);
                return bTStatisticsFragment;
            case 5:
                if (i3 == 0) {
                    return new BreatheDayFragment();
                }
                BreatheStatisticsFragment breatheStatisticsFragment = new BreatheStatisticsFragment();
                Bundle bundle5 = new Bundle();
                bundle5.putInt("statistics_type", i3);
                breatheStatisticsFragment.setArguments(bundle5);
                return breatheStatisticsFragment;
            case 6:
                HRStatisticsFragment hRStatisticsFragment = new HRStatisticsFragment();
                Bundle bundle6 = new Bundle();
                bundle6.putInt("statistics_type", i3);
                hRStatisticsFragment.setArguments(bundle6);
                return hRStatisticsFragment;
            case 7:
                SleepStatisticsFragment sleepStatisticsFragment = new SleepStatisticsFragment();
                Bundle bundle7 = new Bundle();
                bundle7.putInt("statistics_type", i3);
                sleepStatisticsFragment.setArguments(bundle7);
                return sleepStatisticsFragment;
            case 8:
                StepStatisticsFragment stepStatisticsFragment = new StepStatisticsFragment();
                Bundle bundle8 = new Bundle();
                bundle8.putInt("statistics_type", i3);
                stepStatisticsFragment.setArguments(bundle8);
                return stepStatisticsFragment;
            default:
                SugarStatisticsFragment sugarStatisticsFragment = new SugarStatisticsFragment();
                Bundle bundle9 = new Bundle();
                bundle9.putInt("statistics_type", i3);
                sugarStatisticsFragment.setArguments(bundle9);
                return sugarStatisticsFragment;
        }
    }
}
