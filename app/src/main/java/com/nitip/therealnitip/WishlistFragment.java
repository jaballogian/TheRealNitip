package com.nitip.therealnitip;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WishlistFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WishlistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WishlistFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WishlistFragment() {
        // Required empty public constructor
    }

    GridView gridViewWishlist;

    int fotoBarangWishlistList[] = {R.color.colorPrimary, R.color.textColorPrimary};
    int logoJenisNitipWhislistList[] = {R.color.textColorPrimary, R.color.colorPrimary};
    int logoLanjutanWhislistList[] = {R.color.harga, R.color.black_overlay};

    String namaBarangWishlistList[] = {"Barang 1", "Barang 2"};
    String hargaBarangWishlistList[] = {"50000", "10000"};
    String jenisNitipWishlistList[] = {"Nitip Kirim", "Nitip Bawa"};
    String asalKotaWishlistList[] = {"Bandung", "Jakarta"};
    String tanggalWishlist[] = {"3 Jan 2018", "5 Jan 2018"};

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WishlistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WishlistFragment newInstance(String param1, String param2) {
        WishlistFragment fragment = new WishlistFragment();
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
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);

        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.toolbarInWishlistFragment);
        ((MainActivity)getActivity()).setSupportActionBar(mToolbar);

        gridViewWishlist = (GridView) view.findViewById(R.id.gridViewWishlist);

        //gridViewHome.setAdapter(new GridAdapterHome(getActivity(), helper.retrieve(), fotoBarangHomeList, logoJenisNitipHomeList));

        gridViewWishlist.setAdapter(new GridAdapterWishlist(getActivity(), fotoBarangWishlistList, logoJenisNitipWhislistList, logoLanjutanWhislistList, namaBarangWishlistList,
                hargaBarangWishlistList, jenisNitipWishlistList, asalKotaWishlistList, tanggalWishlist));

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
}
