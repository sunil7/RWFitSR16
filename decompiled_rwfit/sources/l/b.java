package l;

import android.content.Context;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import ef.i;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final /* synthetic */ class b {
    public static i a(Context context, Object obj, LinkedHashSet linkedHashSet) {
        try {
            return new i(context, obj, linkedHashSet);
        } catch (CameraUnavailableException e) {
            throw new InitializationException(e);
        }
    }
}
