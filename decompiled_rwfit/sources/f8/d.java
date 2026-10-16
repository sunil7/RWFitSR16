package f8;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.gms.internal.mlkit_vision_barcode.nb;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13508a;

    /* renamed from: b, reason: collision with root package name */
    public final g8.c f13509b;

    /* renamed from: c, reason: collision with root package name */
    public final b f13510c;

    public d(Context context, g8.c cVar, b bVar) {
        this.f13508a = context;
        this.f13509b = cVar;
        this.f13510c = bVar;
    }

    public final void a(a8.b bVar, int i3, boolean z5) {
        Context context = this.f13508a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(bVar.f120a.getBytes(Charset.forName("UTF-8")));
        ByteBuffer allocate = ByteBuffer.allocate(4);
        Priority priority = bVar.f122c;
        adler32.update(allocate.putInt(j8.a.a(priority)).array());
        byte[] bArr = bVar.f121b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z5) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i10 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i10 >= i3) {
                        nb.a("JobInfoScheduler", bVar, "Upload for context %s is already scheduled. Returning...");
                        return;
                    }
                }
            }
        }
        SQLiteDatabase b3 = ((g8.g) this.f13509b).b();
        String valueOf = String.valueOf(j8.a.a(priority));
        String str = bVar.f120a;
        Cursor rawQuery = b3.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, valueOf});
        try {
            Cursor cursor = rawQuery;
            Long valueOf2 = cursor.moveToNext() ? Long.valueOf(cursor.getLong(0)) : 0L;
            rawQuery.close();
            long longValue = valueOf2.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            b bVar2 = this.f13510c;
            builder.setMinimumLatency(bVar2.a(priority, longValue, i3));
            Set set = ((c) bVar2.f13504b.get(priority)).f13507c;
            if (set.contains(SchedulerConfig$Flag.NETWORK_UNMETERED)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_CHARGING)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_IDLE)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i3);
            persistableBundle.putString("backendName", str);
            persistableBundle.putInt("priority", j8.a.a(priority));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Log.d("TransportRuntime.".concat("JobInfoScheduler"), String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", bVar, Integer.valueOf(value), Long.valueOf(bVar2.a(priority, longValue, i3)), valueOf2, Integer.valueOf(i3)));
            jobScheduler.schedule(builder.build());
        } catch (Throwable th2) {
            rawQuery.close();
            throw th2;
        }
    }
}
