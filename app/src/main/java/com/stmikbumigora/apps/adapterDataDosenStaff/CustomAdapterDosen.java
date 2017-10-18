package com.stmikbumigora.apps.adapterDataDosenStaff;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stmikbumigora.apps.R;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CustomAdapterDosen extends RecyclerView.Adapter<CustomAdapterDosen.ViewHolder> {
    private static final String TAG = "CustomAdapterProgramStudi";

    private String[] mNamaDosen, mNikNip, mPendidikan, mPerguruanTinggi;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mNamaDosen, mNikNip, mPendidikan, mPerguruanTinggi;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            mNamaDosen = (TextView) v.findViewById(R.id.text_namaDosen);
            mNikNip = (TextView) v.findViewById(R.id.text_nikNipDosen);
            mPendidikan = (TextView) v.findViewById(R.id.text_pendidikanDosen);
            mPerguruanTinggi = (TextView) v.findViewById(R.id.text_PerguruanTinggiDosen);
        }

        public TextView getmNamaDosen() {
            return mNamaDosen;
        }

        public TextView getmNikNip() {
            return mNikNip;
        }

        public TextView getmPendidikan() {
            return mPendidikan;
        }

        public TextView getmPerguruanTinggi() {
            return mPerguruanTinggi;
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapterDosen(String[] dataSet, String[] dataSet2,String[] dataSet3,String[] dataSet4) {
        this.mNamaDosen = dataSet;
        this.mNikNip = dataSet2;
        this.mPendidikan = dataSet3;
        this.mPerguruanTinggi = dataSet4;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_view_dosen, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getmNamaDosen().setText(mNamaDosen[position]);
        viewHolder.getmNikNip().setText(mNikNip[position]);
        viewHolder.getmPendidikan().setText(mPendidikan[position]);
        viewHolder.getmPerguruanTinggi().setText(mPerguruanTinggi[position]);
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mNamaDosen.length;
    }
}
