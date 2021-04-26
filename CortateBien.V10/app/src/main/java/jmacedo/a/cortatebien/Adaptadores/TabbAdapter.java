package jmacedo.a.cortatebien.Adaptadores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import jmacedo.a.cortatebien.Fragments.Barberia;
import jmacedo.a.cortatebien.Fragments.Peluqueria;

public class TabbAdapter extends FragmentPagerAdapter {

    private String[] tabsarray = new String[] {"Barberías", "Peluquerías"};
    private Integer numerotabs = 2;

    public TabbAdapter
            (@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabsarray[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                Barberia barberia = new Barberia();
                return barberia;
            case 1:
                Peluqueria peluqueria = new Peluqueria();
                return peluqueria;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numerotabs;
    }
}
