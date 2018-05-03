package info.hernanramirez.miscontactos;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import info.hernanramirez.miscontactos.adapters.ContactoAdaptador;
import info.hernanramirez.miscontactos.adapters.PageAdapter;
import info.hernanramirez.miscontactos.fragments.PerfilFragment;
import info.hernanramirez.miscontactos.fragments.RecyclerViewFragment;
import info.hernanramirez.miscontactos.models.Contacto;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toobar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar == null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){

         viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
         tabLayout.setupWithViewPager(viewPager);

         tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts_groups);
         tabLayout.getTabAt(1).setIcon(R.drawable.ic_contacts);

    }

}
