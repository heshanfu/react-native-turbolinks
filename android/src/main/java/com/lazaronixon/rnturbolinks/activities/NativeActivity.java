package com.lazaronixon.rnturbolinks.activities;

import android.os.Bundle;

import com.basecamp.turbolinks.TurbolinksSession;
import com.facebook.react.ReactRootView;
import com.lazaronixon.rnturbolinks.R;

import static com.lazaronixon.rnturbolinks.RNTurbolinksModule.INTENT_NAVIGATION_BAR_HIDDEN;
import static com.lazaronixon.rnturbolinks.RNTurbolinksModule.INTENT_ROUTE;

public class NativeActivity extends GenericActivity {

    private ReactRootView rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);

        toolBar = findViewById(R.id.toolbar);
        route = getIntent().getParcelableExtra(INTENT_ROUTE);
        navigationBarHidden = getIntent().getBooleanExtra(INTENT_NAVIGATION_BAR_HIDDEN, false);

        rootView = findViewById(R.id.react_root_view);

        renderToolBar();
        handleTitlePress(route.getComponent(), null, null);

        rootView.startReactApplication(getReactInstanceManager(), route.getComponent(), route.getPassProps());
    }

    @Override
    public void reloadSession() {
        TurbolinksSession.getDefault(this).resetToColdBoot();
    }

}
