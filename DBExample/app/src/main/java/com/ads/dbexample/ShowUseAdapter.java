package com.ads.dbexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 27489 on 1/24/2018.
 *
 */

public class ShowUseAdapter extends RecyclerView.Adapter {
    private Context c;
    private ArrayList<UsersDataModel> mList;
    ShowUseAdapter(Context c, ArrayList<UsersDataModel> mList ) {
        this.c = c;
        this.mList = mList;
    }

    private class UserVH extends RecyclerView.ViewHolder {
        TextView user;
         UserVH(View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user_text);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.inc_layout_user,parent,false);

        return new UserVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UserVH u = (UserVH) holder;
        //showing user information in text view
        u.user.setText(mList.get(position).getId()+"\t"+mList.get(position).getUserName()+"\n"+mList.get(position).getAge()+"\t"+mList.get(position).getProfession());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
