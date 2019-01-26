package com.nitip.therealnitip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jabal Logian on 14/01/2018.
 */

public class GridAdapterWishlist extends BaseAdapter {

    private int fotoBarangWishlists[], logoJenisNitipWhislists[], logoLanjutanWhislists[];

    private String namaBarangWishlists[], hargaBarangWishlists[], jenisNitipWishlists[], asalKotaWishlists[], tanggalWishlists[];

    private LayoutInflater inflater;
    private Context context;

    public GridAdapterWishlist(Context context, int fotoBarangWishlists[], int logoJenisNitipWhislists[], int logoLanjutanWhislists[],
                               String namaBarangWishlists[], String hargaBarangWishlists[], String jenisNitipWishlists[], String asalKotaWishlists[],
                               String tanggalWishlists[]){

        this.context=context;
        this.fotoBarangWishlists=fotoBarangWishlists;
        this.logoJenisNitipWhislists=logoJenisNitipWhislists;
        this.logoLanjutanWhislists=logoLanjutanWhislists;
        this.namaBarangWishlists=namaBarangWishlists;
        this.hargaBarangWishlists=hargaBarangWishlists;
        this.jenisNitipWishlists=jenisNitipWishlists;
        this.asalKotaWishlists=asalKotaWishlists;
        this.tanggalWishlists=tanggalWishlists;
    }

    @Override
    public int getCount() {
        return tanggalWishlists.length;
    }

    @Override
    public Object getItem(int position) {
        return tanggalWishlists[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if(convertView == null){

            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.custom_grid_wishlist, null);
        }

        ImageView fotoBarangWishlist = (ImageView) gridView.findViewById(R.id.fotoBarangWishlists);
        ImageView logoJenisNitipWhislist = (ImageView) gridView.findViewById(R.id.logoJenisNitipWishlists);
        ImageView logoLanjutanWhislist = (ImageView) gridView.findViewById(R.id.logoLanjutanWishlists);
        TextView namaBarangWishlist = (TextView) gridView.findViewById(R.id.namaBarangWishlists);
        TextView hargaBarangWishlist = (TextView) gridView.findViewById(R.id.hargaBarangWishlists);
        TextView jenisNitipWishlist = (TextView) gridView.findViewById(R.id.jenisNitipWishlists);
        TextView asalKotaWishlist = (TextView) gridView.findViewById(R.id.asalKotaWishlists);
        TextView tanggalWishlist = (TextView) gridView.findViewById(R.id.tanggalWishlists);

        fotoBarangWishlist.setImageResource(fotoBarangWishlists[position]);
        logoJenisNitipWhislist.setImageResource(logoJenisNitipWhislists[position]);
        logoLanjutanWhislist.setImageResource(logoLanjutanWhislists[position]);
        namaBarangWishlist.setText(namaBarangWishlists[position]);
        hargaBarangWishlist.setText(hargaBarangWishlists[position]);
        jenisNitipWishlist.setText(jenisNitipWishlists[position]);
        asalKotaWishlist.setText(asalKotaWishlists[position]);
        tanggalWishlist.setText(tanggalWishlists[position]);

        return gridView;
    }
}
