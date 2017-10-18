package com.stmikbumigora.apps.adapterDataDosenStaff;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stmikbumigora.apps.R;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CustomAdapterStaff extends RecyclerView.Adapter<CustomAdapterStaff.ViewHolder> {
    private static final String TAG = "CustomAdapterStaff";

    private String[] mNamaStaff, mNik, mBagian;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mNamaStaff, mNik, mBagian;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            mNamaStaff = (TextView) v.findViewById(R.id.text_namaStaff);
            mNik = (TextView) v.findViewById(R.id.text_nikStaff);
            mBagian = (TextView) v.findViewById(R.id.text_BagianStaff);
        }

        public TextView getmNamaStaff() {
            return mNamaStaff;
        }

        public TextView getmNik() {
            return mNik;
        }

        public TextView getmBagian() {
            return mBagian;
        }

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapterStaff(String[] dataSet, String[] dataSet2, String[] dataSet3) {
        this.mNamaStaff = dataSet;
        this.mNik = dataSet2;
        this.mBagian = dataSet3;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_view_staff, viewGroup, false);

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
        viewHolder.getmNamaStaff().setText(mNamaStaff[position]);
        viewHolder.getmNik().setText(mNik[position]);
        viewHolder.getmBagian().setText(mBagian[position]);
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mNamaStaff.length;
    }
}
