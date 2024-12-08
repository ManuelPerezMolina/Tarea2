package perezmolina.manuel;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListElement {

    public String image;
    public String name;
    public String descripcion;

    public ListElement(String image,String name, String descripcion) {
        this.image = image;
        this.name = name;
        this.descripcion = descripcion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nombre;

        public ViewHolder(View itemView){
            super();
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
        }
    }
}
