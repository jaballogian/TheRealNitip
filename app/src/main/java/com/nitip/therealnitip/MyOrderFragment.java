package com.nitip.therealnitip;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyOrderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyOrderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MyOrderFragment() {
        // Required empty public constructor
    }

    private Toolbar toolbarInMyOrder;
    private TabLayout tabLayoutInMyOrder;
    private ViewPager viewPagerInMyOrder;

    /**
    GridView gridViewMyOrder;

    String jenisNitipMyOrdersList[] = {"Nitip Kirim", "Nitip Bawa"};
    String tanggalNitipMyOrdersList[] = {"3 Jan 2018", "5 Jan 2018"};
    String namaBarangMyOrdersList[] = {"Mochi", "Kue"};
    String asalKotaMyOrdersList[] = {"Bandung", "Jakarta"};
     **/

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyOrderFragment newInstance(String param1, String param2) {
        MyOrderFragment fragment = new MyOrderFragment();
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
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);

        toolbarInMyOrder = (Toolbar) view.findViewById(R.id.toolbarInMyOrderFragment);
        ((MainActivity)getActivity()).setSupportActionBar(toolbarInMyOrder);

        //((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPagerInMyOrder = (ViewPager) view.findViewById(R.id.viewPagerInMyOrderFragment);
        setupViewPager(viewPagerInMyOrder);

        tabLayoutInMyOrder = (TabLayout) view.findViewById(R.id.tabsInMyOrderFragment);
        tabLayoutInMyOrder.setupWithViewPager(viewPagerInMyOrder);

        /**
        gridViewMyOrder = (GridView) view.findViewById(R.id.gridViewMyOrder);

        gridViewMyOrder.setAdapter(new GridAdapterMyOrder(getActivity(), jenisNitipMyOrdersList, tanggalNitipMyOrdersList, namaBarangMyOrdersList, asalKotaMyOrdersList));
        **/

        return view;
    }

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

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(((MainActivity)getActivity()).getSupportFragmentManager());
        adapter.addFragment(new MyOrderDalamProsesFragment(), "Dalam Proses");
        adapter.addFragment(new MyOrderSelesaiFragment(), "Selesai");
        viewPager.setAdapter(adapter);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
