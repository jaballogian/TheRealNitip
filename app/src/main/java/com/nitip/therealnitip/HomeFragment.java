package com.nitip.therealnitip;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    GridView gridViewHome;

    int fotoBarangHomeList[] = {R.color.colorPrimary, R.color.harga};
    int logoJenisNitipHomeList[] = {R.color.textColorPrimary, R.color.tabSelected};

    String namaBarangHomeList[] = {"Barang Pertama", "Barang Kedua"};
    String hargaBarangHomeList[] = {"Rp. 50000", "Rp. 10000"};
    String pemilikBarangHomeList[] = {"Jabal", "Logian"};
    String jenisNitipHomeList[] = {"Nitip Kirim", "Nitip Bawa"};
    String tanggalBarangHomeList[] = {"3 Jan 2017", "4 Feb 2018"};
    String asalKotaHomeList[] = {"Bandung", "Jakarta"};

    /**
    DatabaseReference dataBase;
    FirebaseHelper helper;
     **/


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.toolbarInHomeFragment);
        /**
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        TabLayout mTabAtas = (TabLayout) view.findViewById(R.id.tabAtas);
        TabLayout mTabBawah = (TabLayout) view.findViewById(R.id.tabBawah);
         **/
        ((MainActivity)getActivity()).setSupportActionBar(mToolbar);

        //setupViewPager(mViewPager);
        //mTabLayout.setupWithViewPager(mViewPager);

        /**
        dataBase = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(dataBase);
         **/

        gridViewHome = (GridView) view.findViewById(R.id.gridViewHome);

        //gridViewHome.setAdapter(new GridAdapterHome(getActivity(), helper.retrieve(), fotoBarangHomeList, logoJenisNitipHomeList));

        gridViewHome.setAdapter(new GridAdapterHome(getActivity(), fotoBarangHomeList, namaBarangHomeList, hargaBarangHomeList, logoJenisNitipHomeList,
                pemilikBarangHomeList, jenisNitipHomeList, tanggalBarangHomeList, asalKotaHomeList));


        /** saat item diklik
        gridViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
         **/

        return view;
    }

    /**
    private void setupViewPager(ViewPager viewPager){

        Adapter adapter = new Adapter(getSupportFragmentManager());
    }

    static class Adapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
        **/

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
        /**
        else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
         **/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
