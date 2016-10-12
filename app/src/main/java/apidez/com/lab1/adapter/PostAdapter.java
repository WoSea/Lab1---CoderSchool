package apidez.com.lab1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import apidez.com.lab1.R;
import apidez.com.lab1.model.Post;

/**
 * Created by nongdenchet on 10/9/16.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    private List<Post> mPosts;

    public PostAdapter(Context context, List<Post> posts) {
        super(context, -1);
        mPosts = posts;
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Nullable
    @Override
    public Post getItem(int position) {
        return mPosts.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO: Insert your code
        ViewHolder viewHolder;
        // bindViewHolder(position, viewHolder)
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_post, parent, false);
            viewHolder.tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
            viewHolder.ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        bindViewHolder(position, viewHolder);

        return convertView;
    }

    private void bindViewHolder(int position, ViewHolder viewHolder) {
        Post post = mPosts.get(position);
        // TODO: Insert your code
        viewHolder.tvUsername.setText(post.getUsername());
        viewHolder.tvDescription.setText(post.getDescription());
        viewHolder.tvDate.setText(post.getDate());
        loadImage(viewHolder.ivImage, post.getImage());
        loadImage(viewHolder.ivAvatar, post.getAvatar());
    }

    private void loadImage(ImageView imageView, String path) {
        // TODO: Insert your code
        Picasso.with(getContext())
                .load(path)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
    }

    public class ViewHolder {
        public TextView tvUsername;
        public TextView tvDescription;
        public TextView tvDate;
        public ImageView ivAvatar;
        public ImageView ivImage;
    }
}
