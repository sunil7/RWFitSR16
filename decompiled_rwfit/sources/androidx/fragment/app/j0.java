package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResult;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class j0 implements androidx.activity.result.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2205a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0 f2206b;

    public /* synthetic */ j0(t0 t0Var, int i3) {
        this.f2205a = i3;
        this.f2206b = t0Var;
    }

    @Override // androidx.activity.result.a
    public final void b(Object obj) {
        switch (this.f2205a) {
            case 0:
                ActivityResult activityResult = (ActivityResult) obj;
                t0 t0Var = this.f2206b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) t0Var.f2291x.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    break;
                } else {
                    b1 b1Var = t0Var.f2272c;
                    String str = fragmentManager$LaunchedFragmentInfo.f2099a;
                    Fragment c9 = b1Var.c(str);
                    if (c9 == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                        break;
                    } else {
                        c9.onActivityResult(fragmentManager$LaunchedFragmentInfo.f2100b, activityResult.b(), activityResult.a());
                        break;
                    }
                }
            case 1:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    iArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue() ? 0 : -1;
                }
                t0 t0Var2 = this.f2206b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo2 = (FragmentManager$LaunchedFragmentInfo) t0Var2.f2291x.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo2 == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    break;
                } else {
                    b1 b1Var2 = t0Var2.f2272c;
                    String str2 = fragmentManager$LaunchedFragmentInfo2.f2099a;
                    Fragment c10 = b1Var2.c(str2);
                    if (c10 == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                        break;
                    } else {
                        c10.onRequestPermissionsResult(fragmentManager$LaunchedFragmentInfo2.f2100b, strArr, iArr);
                        break;
                    }
                }
            default:
                ActivityResult activityResult2 = (ActivityResult) obj;
                t0 t0Var3 = this.f2206b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo3 = (FragmentManager$LaunchedFragmentInfo) t0Var3.f2291x.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo3 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                    break;
                } else {
                    b1 b1Var3 = t0Var3.f2272c;
                    String str3 = fragmentManager$LaunchedFragmentInfo3.f2099a;
                    Fragment c11 = b1Var3.c(str3);
                    if (c11 == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                        break;
                    } else {
                        c11.onActivityResult(fragmentManager$LaunchedFragmentInfo3.f2100b, activityResult2.b(), activityResult2.a());
                        break;
                    }
                }
        }
    }
}
