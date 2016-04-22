package com.vanbios.autoaddapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vanbios.autoaddapp.fragments.CommonFragment;
import com.vanbios.autoaddapp.fragments.FrgAutoChoose;
import com.vanbios.autoaddapp.fragments.FrgBackground;
import com.vanbios.autoaddapp.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    private static long backPressExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(new FrgBackground());
        addFragment(new FrgAutoChoose());
    }

    public void addFragment(Fragment f) {
        treatFragment(f, true, false);
    }

    public Fragment getTopFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    private void treatFragment(Fragment f, boolean addToBackStack, boolean replace) {
        String tag = f.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (replace) {
            ft.replace(R.id.fragment_container, f, tag);
        } else {
            Fragment currentTop = getTopFragment();
            if (currentTop != null) ft.hide(currentTop);
            ft.add(R.id.fragment_container, f, tag);
        }
        if (addToBackStack) ft.addToBackStack(tag);
        ft.commitAllowingStateLoss();
    }

    private void popFragment() {
        getSupportFragmentManager().popBackStack();
    }

    private void popAllFragments() {
        getSupportFragmentManager().popBackStack(0, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getTopFragment();
        if (fragment instanceof CommonFragment) {
            if (backPressExitTime + 2000 > System.currentTimeMillis()) {
                popAllFragments();
                this.finish();
            } else {
                ToastUtils.showClosableToast(this, getString(R.string.press_again_to_exit), 1);
                backPressExitTime = System.currentTimeMillis();
            }
        } else {
            popFragment();
        }
    }

}
