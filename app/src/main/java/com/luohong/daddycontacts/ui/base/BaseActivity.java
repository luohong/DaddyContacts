package com.luohong.daddycontacts.ui.base;

import android.app.Activity;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by luohong on 15/12/2.
 */
public class BaseActivity extends Activity {

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}
