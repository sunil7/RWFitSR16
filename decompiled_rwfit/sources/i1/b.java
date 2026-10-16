package i1;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import androidx.camera.core.impl.c1;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final c1 f14333a = new c1(3);

    public static d6.a a(Context context, androidx.camera.core.impl.e eVar) {
        Cursor cursor;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = (String) eVar.f1378c;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(l0.n("No package found for authority: ", str));
        }
        String str2 = resolveContentProvider.packageName;
        String str3 = (String) eVar.e;
        if (!str2.equals(str3)) {
            throw new PackageManager.NameNotFoundException(l0.p("Found content provider ", str, ", but package was not ", str3));
        }
        Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        c1 c1Var = f14333a;
        Collections.sort(arrayList, c1Var);
        List list = (List) eVar.f1379d;
        if (list == null) {
            list = b1.b.g(resources, 0);
        }
        int i3 = 0;
        loop1: while (true) {
            cursor = null;
            if (i3 >= list.size()) {
                resolveContentProvider = null;
                break;
            }
            ArrayList arrayList2 = new ArrayList((Collection) list.get(i3));
            Collections.sort(arrayList2, c1Var);
            if (arrayList.size() == arrayList2.size()) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    if (!Arrays.equals((byte[]) arrayList.get(i10), (byte[]) arrayList2.get(i10))) {
                        break;
                    }
                }
                break loop1;
            }
            i3++;
        }
        if (resolveContentProvider == null) {
            return new d6.a(1, (Object) null);
        }
        String str4 = resolveContentProvider.authority;
        ArrayList arrayList3 = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str4).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str4).appendPath(Const.STR_FILE).build();
        try {
            cursor = a.a(context.getContentResolver(), build, new String[]{FileDownloadModel.ID, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{(String) eVar.f1380f}, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                arrayList3 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex(FileDownloadModel.ID);
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    arrayList3.add(new f(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, columnIndex != -1 ? cursor.getInt(columnIndex) : 0));
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return new d6.a(0, (f[]) arrayList3.toArray(new f[0]));
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }
}
