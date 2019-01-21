package com.example.franklinsierra.labtabstoolbar.Activities;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.example.franklinsierra.labtabstoolbar.Adapters.PagerAdapter;
import com.example.franklinsierra.labtabstoolbar.Fragments.FormFragment;
import com.example.franklinsierra.labtabstoolbar.Fragments.ListFragment;
import com.example.franklinsierra.labtabstoolbar.Models.Person;
import com.example.franklinsierra.labtabstoolbar.R;

public class MainActivity extends AppCompatActivity implements FormFragment.onPersonCreated {

    //atributos
    private TabLayout tabLayout;
    private PagerAdapter adapter;
    private ViewPager viewPager;

    //le doy los valores numericos a los fragments
    public static final int formFragment=0;
    public static final int listFragment=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //metodos que instancian el Toolbar, el viewPager
        setToolBar();
        setTabLayout();
        setViewPager();

        //  ++++    defino que hace el tabLayout    ++++    //
        setListenerTabLayout(viewPager);
    }

    private void setToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    private void setTabLayout(){
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        //tabLayout.addTab(tabLayout.newTab().setText("Form"));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.nombre_1erTab)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.nombre_2doTab)));
        //tabLayout.addTab(tabLayout.newTab().setText("List"));
    }

    private void setViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new PagerAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setListenerTabLayout(final ViewPager viewPager){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position=tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //  ++++    Me comunico con el otro Fragment    ++++    //

    @Override
    public void createPerson(Person person) {
        // Obtenemos el fragment deseado, ListFragment, a través de
        // getSupportFragmentManager(), y posteriormente pasamos el índice de posición
        // de dicho fragment
        ListFragment fragment=(ListFragment)getSupportFragmentManager().getFragments().get(listFragment);
        //llamo al metodo del fragment
        fragment.addPerson(person);
        //paso al fragmentList con el viewPager
        viewPager.setCurrentItem(listFragment);
    }
}
