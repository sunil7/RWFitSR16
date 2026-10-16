package n1;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.appcompat.widget.AppCompatEditText;
import com.example.test.ui.device.activity.e0;
import com.example.test.ui.device.activity.i0;
import l1.e;
import l1.f;
import l1.z0;
import n.m0;

/* loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ af.a f16359a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InputConnection inputConnection, af.a aVar) {
        super(inputConnection, false);
        this.f16359a = aVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
        Bundle bundle2;
        e eVar;
        m0 m0Var = inputContentInfo == null ? null : new m0(new e0(inputContentInfo, 29), 1);
        af.a aVar = this.f16359a;
        if ((i3 & 1) != 0) {
            try {
                ((InputContentInfo) ((e0) m0Var.f16254b).f7855b).requestPermission();
                InputContentInfo inputContentInfo2 = (InputContentInfo) ((e0) m0Var.f16254b).f7855b;
                bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo2);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
            }
        } else {
            bundle2 = bundle;
        }
        ClipDescription description = ((InputContentInfo) ((e0) m0Var.f16254b).f7855b).getDescription();
        e0 e0Var = (e0) m0Var.f16254b;
        ClipData clipData = new ClipData(description, new ClipData.Item(((InputContentInfo) e0Var.f7855b).getContentUri()));
        if (Build.VERSION.SDK_INT >= 31) {
            eVar = new i0(clipData, 2);
        } else {
            f fVar = new f();
            fVar.f15690b = clipData;
            fVar.f15691c = 2;
            eVar = fVar;
        }
        eVar.h(((InputContentInfo) e0Var.f7855b).getLinkUri());
        eVar.setExtras(bundle2);
        if (z0.i((AppCompatEditText) aVar.f277b, eVar.b()) == null) {
            return true;
        }
        return super.commitContent(inputContentInfo, i3, bundle);
    }
}
