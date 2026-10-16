package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Pair;

/* loaded from: classes.dex */
public final class o0 extends d.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2233a;

    public /* synthetic */ o0(int i3) {
        this.f2233a = i3;
    }

    @Override // d.a
    public final Intent a(Context context, Object obj) {
        Bundle bundleExtra;
        switch (this.f2233a) {
            case 0:
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent a3 = intentSenderRequest.a();
                if (a3 != null && (bundleExtra = a3.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    a3.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (a3.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        intentSenderRequest = new IntentSenderRequest(intentSenderRequest.h(), null, intentSenderRequest.b(), intentSenderRequest.d());
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
                if (t0.B(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                String[] input = (String[]) obj;
                kotlin.jvm.internal.e.f(input, "input");
                Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
                kotlin.jvm.internal.e.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return putExtra;
            default:
                Intent input2 = (Intent) obj;
                kotlin.jvm.internal.e.f(input2, "input");
                return input2;
        }
    }

    @Override // d.a
    public yh.i b(Context context, Object obj) {
        switch (this.f2233a) {
            case 1:
                String[] input = (String[]) obj;
                kotlin.jvm.internal.e.f(input, "input");
                if (input.length == 0) {
                    return new yh.i(kotlin.collections.p.a());
                }
                for (String str : input) {
                    if (a1.g.a(context, str) != 0) {
                        return null;
                    }
                }
                int b3 = kotlin.collections.p.b(input.length);
                if (b3 < 16) {
                    b3 = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(b3);
                for (String str2 : input) {
                    Pair pair = new Pair(str2, Boolean.TRUE);
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                return new yh.i(linkedHashMap);
            default:
                return super.b(context, obj);
        }
    }

    @Override // d.a
    public final Object c(int i3, Intent intent) {
        switch (this.f2233a) {
            case 0:
                return new ActivityResult(i3, intent);
            case 1:
                if (i3 == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra == null || stringArrayExtra == null) {
                        return kotlin.collections.p.a();
                    }
                    ArrayList arrayList = new ArrayList(intArrayExtra.length);
                    for (int i10 : intArrayExtra) {
                        arrayList.add(Boolean.valueOf(i10 == 0));
                    }
                    ArrayList e = kotlin.collections.g.e(stringArrayExtra);
                    Iterator it = e.iterator();
                    Iterator it2 = arrayList.iterator();
                    ArrayList arrayList2 = new ArrayList(Math.min(kotlin.collections.j.g(e), kotlin.collections.j.g(arrayList)));
                    while (it.hasNext() && it2.hasNext()) {
                        arrayList2.add(new Pair(it.next(), it2.next()));
                    }
                    return kotlin.collections.p.c(arrayList2);
                }
                return kotlin.collections.p.a();
            default:
                return new ActivityResult(i3, intent);
        }
    }
}
