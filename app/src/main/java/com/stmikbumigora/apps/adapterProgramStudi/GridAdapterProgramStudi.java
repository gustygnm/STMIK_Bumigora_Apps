package com.stmikbumigora.apps.adapterProgramStudi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.stmikbumigora.apps.R;
import com.stmikbumigora.apps.adapterDataDosenStaff.EndangeredItem;
import com.stmikbumigora.apps.subMenu.subProgramStudi;
import com.stmikbumigora.apps.adapterProgramStudi.PagerAdapterProgramStudi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class GridAdapterProgramStudi extends RecyclerView.Adapter<GridAdapterProgramStudi.ViewHolder> {

    List<EndangeredItemProgramStudi> mItems;
    private Context context;

    public GridAdapterProgramStudi() {
        super();
        mItems = new ArrayList<EndangeredItemProgramStudi>();
        EndangeredItemProgramStudi nama = new EndangeredItemProgramStudi();
        nama.setProgramStudi("S1 TI");
        nama.setNameProgramStudi("Strata 1 Teknik Informatika");
        nama.setKetProgramStudi("Akreditasi B");
        nama.setmThumbnailProgramStudi(R.mipmap.ic_s1ti);
        mItems.add(nama);

        nama = new EndangeredItemProgramStudi();
        nama.setProgramStudi("D3 TI");
        nama.setNameProgramStudi("Diploma 3 Teknik Informatika");
        nama.setKetProgramStudi("Akreditasi B");
        nama.setmThumbnailProgramStudi(R.mipmap.ic_d3ti);
        mItems.add(nama);

        nama = new EndangeredItemProgramStudi();
        nama.setProgramStudi("D3 MI");
        nama.setNameProgramStudi("Diploma 3 Manajemen Informatika");
        nama.setKetProgramStudi("Akreditasi B");
        nama.setmThumbnailProgramStudi(R.mipmap.ic_d3mi);
        mItems.add(nama);

        nama = new EndangeredItemProgramStudi();
        nama.setProgramStudi("S1 DKV");
        nama.setNameProgramStudi("Strata 1 Desain Komunikasi Visual");
        nama.setKetProgramStudi("Akreditasi C");
        nama.setmThumbnailProgramStudi(R.mipmap.ic_s1dkv);
        mItems.add(nama);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view_program_studi, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        EndangeredItemProgramStudi nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getNameProgramStudi());
        viewHolder.jabatan.setText(nature.getProgramStudi());
        viewHolder.txtKet.setText(nature.getKetProgramStudi());
        viewHolder.imgThumbnail.setImageResource(nature.getmThumbnailProgramStudi());
        viewHolder.Rklik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah;
                if (i == 0) {
                    pindah = new Intent(view.getContext(), S1TI.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 1) {
                    pindah = new Intent(view.getContext(), D3TI.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 2) {
                    pindah = new Intent(view.getContext(), D3MI.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 3) {
                    pindah = new Intent(view.getContext(), S1DKV.class);
                    view.getContext().startActivity(pindah);
                }
            }
        });
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
        protected RelativeLayout Rklik;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnailProgramStudi);
            tvspecies = (TextView) itemView.findViewById(R.id.statusProgramStudi);
            jabatan = (TextView) itemView.findViewById(R.id.textJudulProgramStudi);
            txtKet = (TextView) itemView.findViewById(R.id.keteranganProgramStudi);
            Rklik = (RelativeLayout) itemView.findViewById(R.id.top_layout);
        }
    }
}
