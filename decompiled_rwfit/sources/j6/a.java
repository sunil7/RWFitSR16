package j6;

import android.content.SharedPreferences;
import com.example.test.XXApplication;
import n9.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final e f15325b = new e(13);

    /* renamed from: c, reason: collision with root package name */
    public static volatile a f15326c;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f15327a;

    public a(XXApplication xXApplication) {
        this.f15327a = xXApplication.getSharedPreferences("ota_config_data", 0);
    }

    public final boolean a() {
        return this.f15327a.getInt("communication_way", 0) == 0;
    }
}
