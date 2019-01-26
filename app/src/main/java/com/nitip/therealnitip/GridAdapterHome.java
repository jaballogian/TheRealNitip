package com.nitip.therealnitip;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jabal Logian on 10/01/2018.
 */

public class GridAdapterHome extends BaseAdapter {

    /**
    private int fotoBarangHomes[];
    private int logoJenisNitipHomes[];
     **/

    private int fotoBarangHomes[];
    private String namaBarangHomes[];
    private String hargaBarangHomes[];
    private int logoJenisNitipHomes[];
    private String pemilikBarangHomes[];
    private String jenisNitipHomes[];
    private String tanggalBarangHomes[];
    private String asalKotaHomes[];

    //private ArrayList<BarangInHome> barangInHomes;

    private LayoutInflater inflater;
    private Context context;

    /**
    public GridAdapterHome(Context context, ArrayList<BarangInHome> barangInHomes, int fotoBarangHomes[], int logoJenisNitipHomes[]){

        this.context=context;
        this.barangInHomes=barangInHomes;
        this.fotoBarangHomes=fotoBarangHomes;
        this.logoJenisNitipHomes=logoJenisNitipHomes;
    }
     **/


    public GridAdapterHome(Context context, int fotoBarangHomes[], String namaBarangHomes[], String hargaBarangHomes[], int logoJenisNitipHomes[],
                           String pemilikBarangHomes[], String jenisNitipHomes[], String tanggalBarangHomes[], String asalKotaHomes[]){

        this.context=context;
        this.fotoBarangHomes=fotoBarangHomes;
        this.namaBarangHomes=namaBarangHomes;
        this.logoJenisNitipHomes=logoJenisNitipHomes;
        this.hargaBarangHomes=hargaBarangHomes;
        this.pemilikBarangHomes=pemilikBarangHomes;
        this.jenisNitipHomes=jenisNitipHomes;
        this.tanggalBarangHomes=tanggalBarangHomes;
        this.asalKotaHomes=asalKotaHomes;
    }

    /**
    @Override
    public int getCount() {
        return barangInHomes.size();
    }

    @Override
    public Object getItem(int position) {
        return barangInHomes.get(position);
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
            gridView = inflater.inflate(R.layout.custom_grid_home, null);
        }

        ImageView fotoBarangHome = (ImageView) gridView.findViewById(R.id.fotoBarangHomes);
        TextView namaBarangHome = (TextView) gridView.findViewById(R.id.namaBarangHomes);
        ImageView logoJenisNitipHome = (ImageView) gridView.findViewById(R.id.logoJenisNitipHomes);
        TextView hargaBarangHome = (TextView) gridView.findViewById(R.id.hargaBarangHomes);
        TextView pemilikBarangHome = (TextView) gridView.findViewById(R.id.pemilikBarangHomes);
        TextView jenisNitipHome = (TextView) gridView.findViewById(R.id.jenisNitipHomes);
        TextView tanggalBarangHome = (TextView) gridView.findViewById(R.id.tanggalBarangHomes);
        TextView asalKotaHome = (TextView) gridView.findViewById(R.id.asalKotaHomes);


        final BarangInHome b = (BarangInHome) this.getItem(position);

        //fotoBarangHome.setImageResource(b.getFotoBarang());
        namaBarangHome.setText(b.getNamaBarang());
        //logoJenisNitipHome.setImageResource(b.getLogoJenisNitip());
        hargaBarangHome.setText(b.getHargaBarang());
        pemilikBarangHome.setText(b.getNamaPemilik());
        jenisNitipHome.setText(b.getJenisNitip());
        tanggalBarangHome.setText(b.getTanggal());
        asalKotaHome.setText(b.getAsalKota());


        return gridView;
    }
    **/

    @Override
    public int getCount() {
        return asalKotaHomes.length;
    }

    @Override
    public Object getItem(int position) {
        return asalKotaHomes[position];
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
            gridView = inflater.inflate(R.layout.custom_grid_home, null);
        }

        ImageView fotoBarangHome = (ImageView) gridView.findViewById(R.id.fotoBarangHomes);
        TextView namaBarangHome = (TextView) gridView.findViewById(R.id.namaBarangHomes);
        ImageView logoJenisNitipHome = (ImageView) gridView.findViewById(R.id.logoJenisNitipHomes);
        TextView hargaBarangHome = (TextView) gridView.findViewById(R.id.hargaBarangHomes);
        TextView pemilikBarangHome = (TextView) gridView.findViewById(R.id.pemilikBarangHomes);
        TextView jenisNitipHome = (TextView) gridView.findViewById(R.id.jenisNitipHomes);
        TextView tanggalBarangHome = (TextView) gridView.findViewById(R.id.tanggalBarangHomes);
        TextView asalKotaHome = (TextView) gridView.findViewById(R.id.asalKotaHomes);

        fotoBarangHome.setImageResource(fotoBarangHomes[position]);
        namaBarangHome.setText(namaBarangHomes[position]);
        logoJenisNitipHome.setImageResource(logoJenisNitipHomes[position]);
        hargaBarangHome.setText(hargaBarangHomes[position]);
        pemilikBarangHome.setText(pemilikBarangHomes[position]);
        jenisNitipHome.setText(jenisNitipHomes[position]);
        tanggalBarangHome.setText(tanggalBarangHomes[position]);
        asalKotaHome.setText(asalKotaHomes[position]);

        return gridView;
    }

}
