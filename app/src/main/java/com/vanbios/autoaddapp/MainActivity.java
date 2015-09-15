package com.vanbios.autoaddapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vanbios.autoaddapp.fragments.CommonFragment;
import com.vanbios.autoaddapp.fragments.FrgAutoChoose;
import com.vanbios.autoaddapp.fragments.FrgAutoItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(new FrgAutoChoose());
    }

    public void addFragment(Fragment f) {
        treatFragment(f, true, false);
    }

    public void replaceFragment(CommonFragment f){
        treatFragment(f,true,true);
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
}
