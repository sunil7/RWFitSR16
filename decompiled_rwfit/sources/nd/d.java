package nd;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Random;

/* loaded from: classes.dex */
public final class d extends Fragment implements Runnable {

    /* renamed from: g, reason: collision with root package name */
    public static final ArrayList f16464g = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public boolean f16465a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16466b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16467c;

    /* renamed from: d, reason: collision with root package name */
    public b f16468d;
    public a e;

    /* renamed from: f, reason: collision with root package name */
    public int f16469f;

    public static void a(Activity activity, ArrayList arrayList, a aVar, b bVar) {
        int nextInt;
        ArrayList arrayList2;
        d dVar = new d();
        Bundle bundle = new Bundle();
        do {
            nextInt = new Random().nextInt((int) Math.pow(2.0d, 8.0d));
            arrayList2 = f16464g;
        } while (arrayList2.contains(Integer.valueOf(nextInt)));
        arrayList2.add(Integer.valueOf(nextInt));
        bundle.putInt("request_code", nextInt);
        bundle.putStringArrayList("request_permissions", arrayList);
        dVar.setArguments(bundle);
        dVar.setRetainInstance(true);
        dVar.f16467c = true;
        dVar.f16468d = bVar;
        dVar.e = aVar;
        activity.getFragmentManager().beginTransaction().add(dVar, dVar.toString()).commitAllowingStateLoss();
    }

    public final void b() {
        ArrayList arrayList;
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null) {
            return;
        }
        int i3 = arguments.getInt("request_code");
        ArrayList<String> stringArrayList = arguments.getStringArrayList("request_permissions");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            return;
        }
        if (c.h() && stringArrayList.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            arrayList = new ArrayList();
            if (stringArrayList.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            if (stringArrayList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
        } else {
            arrayList = null;
        }
        if (!c.h() || arrayList == null || arrayList.isEmpty()) {
            requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), getArguments().getInt("request_code"));
        } else {
            a(activity, arrayList, new ec.a(16), new fd.c(this, activity, stringArrayList, i3));
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i3, int i10, Intent intent) {
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || this.f16466b || i3 != arguments.getInt("request_code")) {
            return;
        }
        this.f16466b = true;
        activity.getWindow().getDecorView().postDelayed(this, 300L);
    }

    @Override // android.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.f16469f = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        try {
            if (activity.getResources().getConfiguration().orientation != 2) {
                activity.setRequestedOrientation(c.g(activity) ? 9 : 1);
            } else {
                activity.setRequestedOrientation(c.g(activity) ? 8 : 0);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f16468d = null;
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        Activity activity = getActivity();
        if (activity == null || this.f16469f != -1) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0159, code lost:
    
        if ("android.permission.BLUETOOTH_ADVERTISE".equals(r2) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x019a, code lost:
    
        if (r4.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x019c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01b5, code lost:
    
        if (r4.shouldShowRequestPermissionRationale("android.permission.BODY_SENSORS") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01bc, code lost:
    
        if ("android.permission.ACCESS_MEDIA_LOCATION".equals(r2) != false) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e1 A[LOOP:3: B:81:0x010f->B:88:0x01e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e5 A[EDGE_INSN: B:89:0x01e5->B:90:0x01e5 BREAK  A[LOOP:3: B:81:0x010f->B:88:0x01e1], SYNTHETIC] */
    @Override // android.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onRequestPermissionsResult(int r20, java.lang.String[] r21, int[] r22) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nd.d.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    @Override // android.app.Fragment
    public final void onResume() {
        Intent d5;
        super.onResume();
        if (!this.f16467c) {
            getActivity().getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            return;
        }
        if (this.f16465a) {
            return;
        }
        this.f16465a = true;
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments == null || activity == null) {
            return;
        }
        ArrayList<String> stringArrayList = arguments.getStringArrayList("request_permissions");
        int size = stringArrayList.size();
        boolean z5 = false;
        int i3 = 0;
        while (i3 < size) {
            String str = stringArrayList.get(i3);
            i3++;
            String str2 = str;
            if (c.k(str2) && !c.i(activity, str2) && (!"android.permission.MANAGE_EXTERNAL_STORAGE".equals(str2) || Build.VERSION.SDK_INT >= 30)) {
                ArrayList b3 = c.b(str2);
                if (!b3.isEmpty() && !b3.isEmpty()) {
                    int size2 = b3.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        Object obj = b3.get(i10);
                        i10++;
                        if (c.k((String) obj)) {
                            if (Build.VERSION.SDK_INT >= 30 && b3.size() == 3 && b3.contains("android.permission.MANAGE_EXTERNAL_STORAGE") && b3.contains("android.permission.READ_EXTERNAL_STORAGE") && b3.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                                d5 = c.f(activity);
                            } else {
                                if (b3.size() == 1) {
                                    String str3 = (String) b3.get(0);
                                    if ("android.permission.MANAGE_EXTERNAL_STORAGE".equals(str3)) {
                                        d5 = c.f(activity);
                                    } else if ("android.permission.REQUEST_INSTALL_PACKAGES".equals(str3)) {
                                        d5 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                                        d5.setData(c.e(activity));
                                        if (!c.a(activity, d5)) {
                                            d5 = c.d(activity);
                                        }
                                    } else if ("android.permission.SYSTEM_ALERT_WINDOW".equals(str3)) {
                                        d5 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                                        d5.setData(c.e(activity));
                                        if (!c.a(activity, d5)) {
                                            d5 = c.d(activity);
                                        }
                                    } else if ("android.permission.WRITE_SETTINGS".equals(str3)) {
                                        d5 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                                        d5.setData(c.e(activity));
                                        if (!c.a(activity, d5)) {
                                            d5 = c.d(activity);
                                        }
                                    } else if ("android.permission.NOTIFICATION_SERVICE".equals(str3)) {
                                        d5 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                                        d5.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
                                        if (!c.a(activity, d5)) {
                                            d5 = c.d(activity);
                                        }
                                    } else if ("android.permission.PACKAGE_USAGE_STATS".equals(str3)) {
                                        d5 = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
                                        if (c.h()) {
                                            d5.setData(c.e(activity));
                                        }
                                        if (!c.a(activity, d5)) {
                                            d5 = c.d(activity);
                                        }
                                    }
                                }
                                d5 = c.d(activity);
                            }
                            startActivityForResult(d5, getArguments().getInt("request_code"));
                            z5 = true;
                        }
                    }
                }
                d5 = c.d(activity);
                startActivityForResult(d5, getArguments().getInt("request_code"));
                z5 = true;
            }
        }
        if (z5) {
            return;
        }
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (isAdded()) {
            b();
        }
    }
}
