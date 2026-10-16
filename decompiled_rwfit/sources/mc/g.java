package mc;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.camera2.internal.m;
import androidx.camera.core.impl.i1;
import androidx.sqlite.db.SupportSQLiteDatabase;
import b2.j;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.service.q0;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.nb;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.qd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyb;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.firebase.encoders.EncodingException;
import com.tencent.connect.common.Constants;
import ff.q;
import io.reactivex.internal.util.NotificationLite;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import l1.x1;
import md.w;
import n.l;
import o6.p;
import vg.o;

/* loaded from: classes.dex */
public final class g implements lc.a, w, x.c, ia.b, l1.w, w4.a, t3.a, o9.i, n0.g, o, vg.g, vg.b, u4.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16021a;

    /* renamed from: b, reason: collision with root package name */
    public Object f16022b;

    public /* synthetic */ g(int i3) {
        this.f16021a = i3;
    }

    public static void c(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
    }

    private final void d(Throwable th2) {
    }

    public static j h(SupportSQLiteDatabase supportSQLiteDatabase) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("work_spec_id", new d2.a("work_spec_id", "TEXT", true, 1, null, 1));
        hashMap.put("prerequisite_id", new d2.a("prerequisite_id", "TEXT", true, 2, null, 1));
        HashSet hashSet = new HashSet(2);
        hashSet.add(new d2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        hashSet.add(new d2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(new d2.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
        hashSet2.add(new d2.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
        d2.e eVar = new d2.e("Dependency", hashMap, hashSet, hashSet2);
        d2.e a3 = d2.e.a(supportSQLiteDatabase, "Dependency");
        if (!eVar.equals(a3)) {
            return new j(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + eVar + "\n Found:\n" + a3);
        }
        HashMap hashMap2 = new HashMap(25);
        hashMap2.put("id", new d2.a("id", "TEXT", true, 1, null, 1));
        hashMap2.put("state", new d2.a("state", "INTEGER", true, 0, null, 1));
        hashMap2.put("worker_class_name", new d2.a("worker_class_name", "TEXT", true, 0, null, 1));
        hashMap2.put("input_merger_class_name", new d2.a("input_merger_class_name", "TEXT", false, 0, null, 1));
        hashMap2.put("input", new d2.a("input", "BLOB", true, 0, null, 1));
        hashMap2.put("output", new d2.a("output", "BLOB", true, 0, null, 1));
        hashMap2.put("initial_delay", new d2.a("initial_delay", "INTEGER", true, 0, null, 1));
        hashMap2.put("interval_duration", new d2.a("interval_duration", "INTEGER", true, 0, null, 1));
        hashMap2.put("flex_duration", new d2.a("flex_duration", "INTEGER", true, 0, null, 1));
        hashMap2.put("run_attempt_count", new d2.a("run_attempt_count", "INTEGER", true, 0, null, 1));
        hashMap2.put("backoff_policy", new d2.a("backoff_policy", "INTEGER", true, 0, null, 1));
        hashMap2.put("backoff_delay_duration", new d2.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
        hashMap2.put("period_start_time", new d2.a("period_start_time", "INTEGER", true, 0, null, 1));
        hashMap2.put("minimum_retention_duration", new d2.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
        hashMap2.put("schedule_requested_at", new d2.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
        hashMap2.put("run_in_foreground", new d2.a("run_in_foreground", "INTEGER", true, 0, null, 1));
        hashMap2.put("out_of_quota_policy", new d2.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
        hashMap2.put("required_network_type", new d2.a("required_network_type", "INTEGER", false, 0, null, 1));
        hashMap2.put("requires_charging", new d2.a("requires_charging", "INTEGER", true, 0, null, 1));
        hashMap2.put("requires_device_idle", new d2.a("requires_device_idle", "INTEGER", true, 0, null, 1));
        hashMap2.put("requires_battery_not_low", new d2.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
        hashMap2.put("requires_storage_not_low", new d2.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
        hashMap2.put("trigger_content_update_delay", new d2.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
        hashMap2.put("trigger_max_content_delay", new d2.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
        hashMap2.put("content_uri_triggers", new d2.a("content_uri_triggers", "BLOB", false, 0, null, 1));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(2);
        hashSet4.add(new d2.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
        hashSet4.add(new d2.d("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
        d2.e eVar2 = new d2.e("WorkSpec", hashMap2, hashSet3, hashSet4);
        d2.e a10 = d2.e.a(supportSQLiteDatabase, "WorkSpec");
        if (!eVar2.equals(a10)) {
            return new j(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + eVar2 + "\n Found:\n" + a10);
        }
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put("tag", new d2.a("tag", "TEXT", true, 1, null, 1));
        hashMap3.put("work_spec_id", new d2.a("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new d2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new d2.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
        d2.e eVar3 = new d2.e("WorkTag", hashMap3, hashSet5, hashSet6);
        d2.e a11 = d2.e.a(supportSQLiteDatabase, "WorkTag");
        if (!eVar3.equals(a11)) {
            return new j(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + eVar3 + "\n Found:\n" + a11);
        }
        HashMap hashMap4 = new HashMap(2);
        hashMap4.put("work_spec_id", new d2.a("work_spec_id", "TEXT", true, 1, null, 1));
        hashMap4.put("system_id", new d2.a("system_id", "INTEGER", true, 0, null, 1));
        HashSet hashSet7 = new HashSet(1);
        hashSet7.add(new d2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        d2.e eVar4 = new d2.e("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
        d2.e a12 = d2.e.a(supportSQLiteDatabase, "SystemIdInfo");
        if (!eVar4.equals(a12)) {
            return new j(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + eVar4 + "\n Found:\n" + a12);
        }
        HashMap hashMap5 = new HashMap(2);
        hashMap5.put("name", new d2.a("name", "TEXT", true, 1, null, 1));
        hashMap5.put("work_spec_id", new d2.a("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet8 = new HashSet(1);
        hashSet8.add(new d2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet9 = new HashSet(1);
        hashSet9.add(new d2.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
        d2.e eVar5 = new d2.e("WorkName", hashMap5, hashSet8, hashSet9);
        d2.e a13 = d2.e.a(supportSQLiteDatabase, "WorkName");
        if (!eVar5.equals(a13)) {
            return new j(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + eVar5 + "\n Found:\n" + a13);
        }
        HashMap hashMap6 = new HashMap(2);
        hashMap6.put("work_spec_id", new d2.a("work_spec_id", "TEXT", true, 1, null, 1));
        hashMap6.put("progress", new d2.a("progress", "BLOB", true, 0, null, 1));
        HashSet hashSet10 = new HashSet(1);
        hashSet10.add(new d2.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        d2.e eVar6 = new d2.e("WorkProgress", hashMap6, hashSet10, new HashSet(0));
        d2.e a14 = d2.e.a(supportSQLiteDatabase, "WorkProgress");
        if (!eVar6.equals(a14)) {
            return new j(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + eVar6 + "\n Found:\n" + a14);
        }
        HashMap hashMap7 = new HashMap(2);
        hashMap7.put("key", new d2.a("key", "TEXT", true, 1, null, 1));
        hashMap7.put("long_value", new d2.a("long_value", "INTEGER", false, 0, null, 1));
        d2.e eVar7 = new d2.e("Preference", hashMap7, new HashSet(0), new HashSet(0));
        d2.e a15 = d2.e.a(supportSQLiteDatabase, "Preference");
        if (eVar7.equals(a15)) {
            return new j(true, (String) null);
        }
        return new j(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + eVar7 + "\n Found:\n" + a15);
    }

    @Override // x.c
    public void C(Throwable th2) {
        switch (this.f16021a) {
            case 2:
                synchronized (((m) this.f16022b).f1267a) {
                    try {
                        ((m) this.f16022b).f1270d.q();
                        int ordinal = ((m) this.f16022b).f1274i.ordinal();
                        if ((ordinal == 3 || ordinal == 5 || ordinal == 6) && !(th2 instanceof CancellationException)) {
                            a0.f("CaptureSession", "Opening session with fail " + ((m) this.f16022b).f1274i, th2);
                            ((m) this.f16022b).d();
                        }
                    } finally {
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // w4.a
    public void E(int i3) {
        switch (this.f16021a) {
            case 14:
                s3.f fVar = (s3.f) this.f16022b;
                if (fVar.e != null) {
                    int currentItem = fVar.f18179b.getCurrentItem();
                    if (currentItem >= ((List) fVar.e.get(i3)).size() - 1) {
                        currentItem = ((List) fVar.e.get(i3)).size() - 1;
                    }
                    fVar.f18179b.setAdapter(new n6.a((List) fVar.e.get(i3), 2));
                    fVar.f18179b.setCurrentItem(currentItem);
                    if (fVar.f18182f == null) {
                        r3.a aVar = fVar.f18184h;
                        if (aVar != null) {
                            aVar.e(i3, currentItem, 0);
                            break;
                        }
                    } else {
                        fVar.f18183g.E(currentItem);
                        break;
                    }
                } else {
                    r3.a aVar2 = fVar.f18184h;
                    if (aVar2 != null) {
                        aVar2.e(fVar.f18178a.getCurrentItem(), 0, 0);
                        break;
                    }
                }
                break;
            default:
                ((s3.h) this.f16022b).f18204p.D();
                break;
        }
    }

    @Override // l1.w
    public x1 P(View view, x1 x1Var) {
        com.example.test.ui.dialog.c cVar = (com.example.test.ui.dialog.c) this.f16022b;
        oa.d dVar = cVar.f7935l;
        if (dVar != null) {
            cVar.e.P.remove(dVar);
        }
        oa.d dVar2 = new oa.d(cVar.f7931h, x1Var);
        cVar.f7935l = dVar2;
        ArrayList arrayList = cVar.e.P;
        if (!arrayList.contains(dVar2)) {
            arrayList.add(dVar2);
        }
        return x1Var;
    }

    public q0 a(l lVar) {
        y7.b bVar = (y7.b) this.f16022b;
        URL url = (URL) lVar.f16245b;
        nb.a("CctTransportBackend", url, "Making request to: %s");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(Const.I_LOC_JUMP_DELAY);
        httpURLConnection.setReadTimeout(bVar.f20030g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(Constants.HTTP_POST);
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/2.3.3 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) lVar.f16247d;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    n6.a aVar = bVar.f20025a;
                    z7.i iVar = (z7.i) lVar.f16246c;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    tb.d dVar = (tb.d) aVar.f16381b;
                    tb.e eVar = new tb.e(bufferedWriter, dVar.f18600a, dVar.f18601b, dVar.f18602c, dVar.f18603d);
                    eVar.e(iVar);
                    eVar.g();
                    eVar.f18605b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), l0.j(responseCode, "Status Code: "));
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new q0(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new q0(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            q0 q0Var = new q0(responseCode, null, z7.m.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f20381a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return q0Var;
                        } catch (Throwable th2) {
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th4) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th4;
                }
            } catch (Throwable th5) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th5;
            }
        } catch (EncodingException e) {
            e = e;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new q0(400, null, 0L);
        } catch (ConnectException e10) {
            e = e10;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new q0(500, null, 0L);
        } catch (UnknownHostException e11) {
            e = e11;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new q0(500, null, 0L);
        } catch (IOException e12) {
            e = e12;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new q0(400, null, 0L);
        }
    }

    @Override // vg.o
    public Object apply(Object obj) {
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 2) {
            return ((vg.c) this.f16022b).a(objArr[0], objArr[1]);
        }
        throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
    }

    @Override // n0.g
    public Object b(androidx.concurrent.futures.b bVar) {
        switch (this.f16021a) {
            case 22:
                x.d dVar = (x.d) this.f16022b;
                pd.f("The result can only set once!", dVar.f19695b == null);
                dVar.f19695b = bVar;
                return "FutureChain[" + dVar + "]";
            default:
                x.l lVar = (x.l) this.f16022b;
                pd.f("The result can only set once!", lVar.f19714f == null);
                lVar.f19714f = bVar;
                return "ListFuture[" + this + "]";
        }
    }

    @Override // u4.a
    public Object e() {
        de.i iVar = (de.i) this.f16022b;
        return new z3.l((c4.c) iVar.f12357b, (c4.c) iVar.f12358c, (c4.c) iVar.f12359d, (c4.c) iVar.e, (com.bumptech.glide.load.engine.c) iVar.f12360f, (com.bumptech.glide.load.engine.c) iVar.f12361g, (l) iVar.f12362h);
    }

    @Override // vg.g
    public void f(Object obj) {
        Throwable th2 = (Throwable) obj;
        xg.c.b(th2, "error is null");
        ((vg.g) this.f16022b).f(new rg.j(NotificationLite.error(th2)));
    }

    public void g(BluetoothDevice bluetoothDevice, UUID uuid, byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("-onRecvSppData- device = ");
        p pVar = (p) this.f16022b;
        sb2.append(ee.a.e(pVar.f16786a, bluetoothDevice));
        sb2.append(", sppUUID = ");
        sb2.append(uuid);
        sb2.append(", \n raw data = ");
        sb2.append(ee.b.c(bArr));
        ee.c.b(2, "SppManager", sb2.toString());
        o4.c cVar = pVar.f16788c;
        cVar.getClass();
        cVar.b(new o6.l(bluetoothDevice, uuid, bArr));
        if (ee.a.b(bluetoothDevice, pVar.f16791g)) {
            return;
        }
        pVar.f16790f.handleAuthData(bluetoothDevice, bArr);
    }

    @Override // o9.i, vg.b
    public void i(Object obj, Object obj2) {
        switch (this.f16021a) {
            case 18:
                u9.e eVar = new u9.e((ia.g) obj2, 0);
                u9.d dVar = (u9.d) ((u9.g) obj).q();
                Parcel g10 = dVar.g();
                da.a.d(g10, eVar);
                da.a.c(g10, (ApiFeatureRequest) this.f16022b);
                dVar.k(g10, 1);
                break;
            default:
                ((Map) obj).put(((o) this.f16022b).apply(obj2), obj2);
                break;
        }
    }

    @Override // ia.b
    public void j(ia.f fVar) {
        Exception c9 = fVar.c();
        if (c9 != null) {
            nf.e.f16609h.b(2, ((nf.b) ((e8.a) this.f16022b).f12474b).f16596a.toUpperCase(), "- Finished with ERROR.", c9);
            e8.a aVar = (e8.a) this.f16022b;
            if (((nf.b) aVar.f12474b).f16599d) {
                q.b(((nf.e) aVar.f12476d).f16610a.f13671a, c9, false);
            }
            ((nf.b) ((e8.a) this.f16022b).f12474b).f16597b.b(c9);
        } else if (((ia.m) fVar).f14401d) {
            nf.e.f16609h.b(1, ((nf.b) ((e8.a) this.f16022b).f12474b).f16596a.toUpperCase(), "- Finished because ABORTED.");
            ((nf.b) ((e8.a) this.f16022b).f12474b).f16597b.b(new CancellationException());
        } else {
            nf.e.f16609h.b(1, ((nf.b) ((e8.a) this.f16022b).f12474b).f16596a.toUpperCase(), "- Finished.");
            ia.g gVar = ((nf.b) ((e8.a) this.f16022b).f12474b).f16597b;
            gVar.f14382a.j(fVar.d());
        }
        synchronized (((nf.e) ((e8.a) this.f16022b).f12476d).f16613d) {
            e8.a aVar2 = (e8.a) this.f16022b;
            nf.e.a((nf.e) aVar2.f12476d, (nf.b) aVar2.f12474b);
        }
    }

    public boolean k(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2, byte[] bArr) {
        n6.b bVar = (n6.b) this.f16022b;
        boolean z5 = false;
        if (uuid == null || uuid2 == null || bArr == null || bArr.length == 0 || !qd.a(bVar.f16382a)) {
            ee.c.b(2, "BleManager", "writeDataByBle : param is invalid.");
            return false;
        }
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service == null) {
            ee.c.b(2, "BleManager", "writeDataByBle : service is null.");
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        if (characteristic == null) {
            ee.c.b(2, "BleManager", "writeDataByBle : characteristic is null");
            return false;
        }
        try {
            characteristic.setValue(bArr);
            z5 = bluetoothGatt.writeCharacteristic(characteristic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ee.c.b(2, "BleManager", "writeDataByBle : send ret : " + z5);
        return z5;
    }

    @Override // lc.a
    public int n() {
        return ((zzyb) this.f16022b).b();
    }

    @Override // lc.a
    public String o() {
        return ((zzyb) this.f16022b).i();
    }

    @Override // x.c
    public void onSuccess(Object obj) {
        switch (this.f16021a) {
            case 2:
                break;
            default:
                ((c0.i) this.f16022b).run();
                break;
        }
    }

    @Override // lc.a
    public Rect p() {
        Point[] j4 = ((zzyb) this.f16022b).j();
        if (j4 == null) {
            return null;
        }
        int i3 = Integer.MIN_VALUE;
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MIN_VALUE;
        for (Point point : j4) {
            i10 = Math.min(i10, point.x);
            i3 = Math.max(i3, point.x);
            i11 = Math.min(i11, point.y);
            i12 = Math.max(i12, point.y);
        }
        return new Rect(i10, i11, i3, i12);
    }

    @Override // lc.a
    public int q() {
        return ((zzyb) this.f16022b).h();
    }

    @Override // lc.a
    public Point[] r() {
        return ((zzyb) this.f16022b).j();
    }

    public /* synthetic */ g(Object obj, int i3) {
        this.f16021a = i3;
        this.f16022b = obj;
    }

    public /* synthetic */ g(u9.f fVar, ApiFeatureRequest apiFeatureRequest) {
        this.f16021a = 18;
        this.f16022b = apiFeatureRequest;
    }

    public g(androidx.camera.core.impl.utils.executor.b bVar) {
        this.f16021a = 3;
        this.f16022b = new AtomicInteger(0);
    }

    public g() {
        this.f16021a = 11;
        this.f16022b = (ExtraSupportedSurfaceCombinationsQuirk) p.a.f17285a.f(ExtraSupportedSurfaceCombinationsQuirk.class);
    }

    public g(i1 i1Var) {
        this.f16021a = 10;
        AeFpsRangeLegacyQuirk aeFpsRangeLegacyQuirk = (AeFpsRangeLegacyQuirk) i1Var.f(AeFpsRangeLegacyQuirk.class);
        if (aeFpsRangeLegacyQuirk == null) {
            this.f16022b = null;
        } else {
            this.f16022b = aeFpsRangeLegacyQuirk.f1187a;
        }
    }
}
