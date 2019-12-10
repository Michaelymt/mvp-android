package com.ymt.mvpapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ymt.mvpapp.R;
import com.ymt.mvpapp.entity.Categoria;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaAdapterViewHolder> {

    Context context;
    List<Categoria> lis_result;

    public CategoriaAdapter(Context context, List<Categoria> lis_result) {
        this.context = context;
        this.lis_result = lis_result;
    }

    @NonNull
    @Override
    public CategoriaAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        return new CategoriaAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaAdapterViewHolder holder, int position) {

        Categoria categoria = lis_result.get(position);

        holder.tv_nombre.setText(categoria.getNombre());
        holder.tv_descripcion.setText(categoria.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return lis_result.size();
    }

    public class CategoriaAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_nombre)
        TextView tv_nombre;
        @BindView(R.id.tv_descripcion)
        TextView tv_descripcion;

        public CategoriaAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
