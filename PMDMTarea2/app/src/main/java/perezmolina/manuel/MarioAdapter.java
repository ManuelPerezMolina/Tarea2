package perezmolina.manuel;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MarioAdapter extends RecyclerView.Adapter<ListElement.ViewHolder> {

    private List<MarioAdapter> marioData;
    private LayoutInflater marioInflater;
    private Context context;

    public MarioAdapter(List<MarioAdapter> itemList,Context context){
        this.marioInflater = LayoutInflater.from(context);
        this.context = context;
        this.marioData = itemList;
    }

    @Override
    public int getItemCount() {return marioData.size();}

    @Override
    public ListElement.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = marioInflater.inflate(root,R.layout.mario_cardview);
        return new marioData.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListElement.ViewHolder holder, final int position) {
        holder.bindData(marioData.get(position));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nombre = itemView.findViewById(R.id.nombre);
        }

        void bindData(final ListElement item){
            imageView.setText(item.getImage());
            nombre.setText(item.getName());
        }
    }


}
