package androidx.core.content;

import a1.b;
import a1.h;
import a1.i;
import a1.j;
import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private int mResourceId = 0;
    private i mStrategy;
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File("/");
    private static final HashMap<String, i> sCache = new HashMap<>();

    public static i a(Context context, int i3, String str) {
        i iVar;
        HashMap<String, i> hashMap = sCache;
        synchronized (hashMap) {
            try {
                iVar = hashMap.get(str);
                if (iVar == null) {
                    try {
                        try {
                            iVar = b(context, i3, str);
                            hashMap.put(str, iVar);
                        } catch (IOException e) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                        }
                    } catch (XmlPullParserException e10) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iVar;
    }

    public static j b(Context context, int i3, String str) {
        j jVar = new j(str);
        XmlResourceParser fileProviderPathsMetaData = getFileProviderPathsMetaData(context, str, context.getPackageManager().resolveContentProvider(str, 128), i3);
        while (true) {
            int next = fileProviderPathsMetaData.next();
            if (next == 1) {
                return jVar;
            }
            if (next == 2) {
                String name = fileProviderPathsMetaData.getName();
                File file = null;
                String attributeValue = fileProviderPathsMetaData.getAttributeValue(null, ATTR_NAME);
                String attributeValue2 = fileProviderPathsMetaData.getAttributeValue(null, "path");
                if (TAG_ROOT_PATH.equals(name)) {
                    file = DEVICE_ROOT;
                } else if (TAG_FILES_PATH.equals(name)) {
                    file = context.getFilesDir();
                } else if (TAG_CACHE_PATH.equals(name)) {
                    file = context.getCacheDir();
                } else if (TAG_EXTERNAL.equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if (TAG_EXTERNAL_FILES.equals(name)) {
                    File[] b3 = b.b(context, null);
                    if (b3.length > 0) {
                        file = b3[0];
                    }
                } else if (TAG_EXTERNAL_CACHE.equals(name)) {
                    File[] a3 = b.a(context);
                    if (a3.length > 0) {
                        file = a3[0];
                    }
                } else if (TAG_EXTERNAL_MEDIA.equals(name)) {
                    File[] a10 = h.a(context);
                    if (a10.length > 0) {
                        file = a10[0];
                    }
                }
                if (file == null) {
                    continue;
                } else {
                    String str2 = new String[]{attributeValue2}[0];
                    if (str2 != null) {
                        file = new File(file, str2);
                    }
                    if (TextUtils.isEmpty(attributeValue)) {
                        throw new IllegalArgumentException("Name must not be empty");
                    }
                    try {
                        jVar.f5b.put(attributeValue, file.getCanonicalFile());
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
                    }
                }
            }
        }
    }

    public static XmlResourceParser getFileProviderPathsMetaData(Context context, String str, ProviderInfo providerInfo, int i3) {
        if (providerInfo == null) {
            throw new IllegalArgumentException(l0.n("Couldn't find meta-data for provider with authority ", str));
        }
        if (providerInfo.metaData == null && i3 != 0) {
            Bundle bundle = new Bundle(1);
            providerInfo.metaData = bundle;
            bundle.putInt(META_DATA_FILE_PROVIDER_PATHS, i3);
        }
        XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (loadXmlMetaData != null) {
            return loadXmlMetaData;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        j jVar = (j) a(context, 0, str);
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : jVar.f5b.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                throw new IllegalArgumentException(l0.n("Failed to find configured root that contains ", canonicalPath));
            }
            String path2 = ((File) entry.getValue()).getPath();
            return new Uri.Builder().scheme("content").authority(jVar.f4a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(Const.STR_MART_SEMICOLON)[0];
        HashMap<String, i> hashMap = sCache;
        synchronized (hashMap) {
            hashMap.remove(str);
        }
        this.mStrategy = a(context, this.mResourceId, str);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return ((j) this.mStrategy).a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File a3 = ((j) this.mStrategy).a(uri);
        int lastIndexOf = a3.getName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a3.getName().substring(lastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int i3;
        File a3 = ((j) this.mStrategy).a(uri);
        if ("r".equals(str)) {
            i3 = AMapEngineUtils.MAX_P20_WIDTH;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i3 = 738197504;
        } else if ("wa".equals(str)) {
            i3 = 704643072;
        } else if ("rw".equals(str)) {
            i3 = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                throw new IllegalArgumentException(l0.n("Invalid mode: ", str));
            }
            i3 = 1006632960;
        }
        return ParcelFileDescriptor.open(a3, i3);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i3;
        File a3 = ((j) this.mStrategy).a(uri);
        String queryParameter = uri.getQueryParameter(DISPLAYNAME_FIELD);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i10 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i10] = "_display_name";
                i3 = i10 + 1;
                objArr[i10] = queryParameter == null ? a3.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i10] = "_size";
                i3 = i10 + 1;
                objArr[i10] = Long.valueOf(a3.length());
            }
            i10 = i3;
        }
        String[] strArr4 = new String[i10];
        System.arraycopy(strArr3, 0, strArr4, 0, i10);
        Object[] objArr2 = new Object[i10];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @SuppressLint({"StreamFiles"})
    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, str2).build();
    }
}
