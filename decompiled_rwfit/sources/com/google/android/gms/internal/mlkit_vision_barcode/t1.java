package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Bundle;
import com.example.test.ui.sport.fragment.SportTypeFragment;

/* loaded from: classes.dex */
public abstract class t1 {
    public static SportTypeFragment a(int i3) {
        SportTypeFragment sportTypeFragment = new SportTypeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("sport_type", i3);
        sportTypeFragment.setArguments(bundle);
        return sportTypeFragment;
    }
}
