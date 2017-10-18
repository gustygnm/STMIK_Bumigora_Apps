package com.stmikbumigora.apps.adapterDataDosenStaff;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.stmikbumigora.apps.R;
import com.stmikbumigora.apps.subMenu.subProgramStudi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<EndangeredItem> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem nama = new EndangeredItem();
        nama.setJabatan("Ketua");
        nama.setName("Komariyuli Anwariyah, S.T., M.Kom.");
        nama.setmKet("13.6.171");
        nama.setThumbnail(R.drawable.komariyuliaanwariyah);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setJabatan("Pembantu Ketua I");
        nama.setName("Heroe Santoso, M.Kom.\n");
        nama.setmKet("96.6.64");
        nama.setThumbnail(R.drawable.heroesantoso);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setJabatan("Pembantu Ketua II");
        nama.setName("Restu Fahdiansyah, S.E., \nM.S.A.");
        nama.setmKet("16.6.237");
        nama.setThumbnail(R.drawable.restufahdiansyah);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setJabatan("Pembantu Ketua III");
        nama.setName("M. Yunus, M.Kom\n");
        nama.setmKet("10.6.135");
        nama.setThumbnail(R.drawable.myunus);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setJabatan("Ka. Prodi S1 TI");
        nama.setName("Ni Gusti Ayu Dasriani, S.Kom, M.Kom.");
        nama.setmKet("10.5.133");
        nama.setThumbnail(R.drawable.nigustiayudasriani);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setJabatan("Ka. Prodi D3 TI");
        nama.setName("Apriani, S.Kom., M.Kom.\n");
        nama.setmKet("12.5.166");
        nama.setThumbnail(R.drawable.apriani);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setJabatan("Ka. Prodi D3 MI");
        nama.setName("Ismarmiaty, S.T., MMSI\n");
        nama.setmKet("15.6.215");
        nama.setThumbnail(R.drawable.ismarmiaty);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setJabatan("Ka. Prodi S1 DKV");
        nama.setName("Raden Fanny Printi Ardi, S.Sn., M.Sn");
        nama.setmKet("15.6.229");
        nama.setThumbnail(R.drawable.radenfannyprintiardi);
        mItems.add(nama);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        EndangeredItem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.jabatan.setText(nature.getJabatan());
        viewHolder.txtKet.setText(nature.getmKet());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
        viewHolder.btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah;
                if (i == 0) {
                    pindah = new Intent(view.getContext(), AboutKetua.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 1) {
                    pindah = new Intent(view.getContext(), AboutPembantuKetua1.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 2) {
                    pindah = new Intent(view.getContext(), AboutPembantuKetua2.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 3) {
                    pindah = new Intent(view.getContext(), AboutPembantuKetua3.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 4) {
                    pindah = new Intent(view.getContext(), AboutKaProdiS1TI.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 5) {
                    pindah = new Intent(view.getContext(), AboutKaProdiD3TI.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 6) {
                    pindah = new Intent(view.getContext(), AboutKaProdiD3MI.class);
                    view.getContext().startActivity(pindah);
                } else if (i == 7) {
                    pindah = new Intent(view.getContext(), AboutKaProdiS1DKV.class);
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


        public ImageView imgThumbnail;
        public TextView tvspecies;
        public TextView jabatan;
        public TextView txtKet;
        public Button btnLihat;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            tvspecies = (TextView) itemView.findViewById(R.id.status);
            jabatan = (TextView) itemView.findViewById(R.id.jabatann);
            txtKet = (TextView) itemView.findViewById(R.id.keterangan);
            btnLihat = (Button) itemView.findViewById(R.id.btnLihatDosen);
        }
    }
}
