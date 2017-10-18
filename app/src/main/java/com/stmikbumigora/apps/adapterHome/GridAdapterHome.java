package com.stmikbumigora.apps.adapterHome;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stmikbumigora.apps.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class GridAdapterHome extends RecyclerView.Adapter<GridAdapterHome.ViewHolder> {

    List<EndangeredItemHome> mItems;

    public GridAdapterHome() {
        super();
        mItems = new ArrayList<EndangeredItemHome>();
        EndangeredItemHome nama = new EndangeredItemHome();
        nama.setJudulHome("STMIK Bumigora Mataram");
        nama.setNameHome("Be Informatic One");
        nama.setKetHome("Jl. Ismail Marzuki No. 22, Cilinaya, Cakranegara, Kota Mataram, Nusa Tenggara Barat. 83127, Indonesia");
        nama.setmThumbnailHome(R.drawable.ic_launcher);
        mItems.add(nama);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view_home, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItemHome nature = mItems.get(i);
        viewHolder.jabatan.setText(nature.getJudulHome());
        viewHolder.tvspecies.setText(nature.getNameHome());
        viewHolder.txtKet.setText(nature.getKetHome());
        viewHolder.imgThumbnail.setImageResource(nature.getmThumbnailHome());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        protected ImageView imgThumbnail;
        protected TextView tvspecies;
        protected TextView jabatan;
        protected TextView txtKet;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnailHome);
            tvspecies = (TextView) itemView.findViewById(R.id.statusHome);
            jabatan = (TextView) itemView.findViewById(R.id.textJudulHome);
            txtKet = (TextView) itemView.findViewById(R.id.keteranganHome);

        }
    }
}
