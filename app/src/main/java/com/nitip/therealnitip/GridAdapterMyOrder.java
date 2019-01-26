package com.nitip.therealnitip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jabal Logian on 13/01/2018.
 */

public class GridAdapterMyOrder extends BaseAdapter {

    private String jenisNitipMyOrders[];
    private String tanggalNitipMyOrders[];
    private String namaBarangMyOrders[];
    private String asalKotaMyOrders[];

    private LayoutInflater inflater;
    private Context context;

    public GridAdapterMyOrder(Context context, String jenisNitipMyOrders[], String tanggalNitipMyOrders[], String namaBarangMyOrders[],
                              String asalKotaMyOrders[]){

        this.context=context;
        this.jenisNitipMyOrders=jenisNitipMyOrders;
        this.tanggalNitipMyOrders=tanggalNitipMyOrders;
        this.namaBarangMyOrders=namaBarangMyOrders;
        this.asalKotaMyOrders=asalKotaMyOrders;

    }

    @Override
    public int getCount() {
        return asalKotaMyOrders.length;
    }

    @Override
    public Object getItem(int position) {
        return asalKotaMyOrders[position];
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
            gridView = inflater.inflate(R.layout.custom_grid_my_order, null);
        }

        TextView jenisNitipMyOrder = (TextView) gridView.findViewById(R.id.jenisNitipMyOrders);
        TextView tanggalBarangMyOrder = (TextView) gridView.findViewById(R.id.tanggalBarangMyOrders);
        TextView namaBarangMyOrder = (TextView) gridView.findViewById(R.id.namaBarangMyOrders);
        TextView asalKotaMyOrder = (TextView) gridView.findViewById(R.id.asalKotaMyOrders);

        jenisNitipMyOrder.setText(jenisNitipMyOrders[position]);
        tanggalBarangMyOrder.setText(tanggalNitipMyOrders[position]);
        namaBarangMyOrder.setText(namaBarangMyOrders[position]);
        asalKotaMyOrder.setText(asalKotaMyOrders[position]);

        return gridView;
    }
}
