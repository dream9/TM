package zucc.tm.jg.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import android.widget.TextView;
import zucc.tm.jg.R;
import zucc.tm.jg.Util.Msglist;
import zucc.tm.jg.Util.my;

import zucc.tm.jg.bean.msgbean;


public class messageAdapter extends ArrayAdapter<msgbean> {

    private int resourceId;
    public messageAdapter(Context context, int resource,String id) {
        super(context, resource, Msglist.map.get(id));
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        msgbean msg = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();

            viewHolder.leftLayout = (CardView) view.findViewById(R.id.left_layout1);
            viewHolder.rightLayout = (CardView) view.findViewById(R.id.right_layout1);
            viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg1);
            viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg1);
            viewHolder.dateMsgLeft = (TextView) view.findViewById(R.id.date_msg_left);
            viewHolder.dateMsgRight = (TextView) view.findViewById(R.id.date_msg_right);
            viewHolder.leftHead = (ImageView) view.findViewById(R.id.left_head1);
            viewHolder.rightHead = (ImageView) view.findViewById(R.id.right_head1);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if (!msg.getName().equals(my.my.getName())) {
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftHead.setVisibility(View.VISIBLE);
            viewHolder.rightHead.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getMsg());
            viewHolder.dateMsgRight.setVisibility(View.GONE);
            viewHolder.dateMsgLeft.setVisibility(View.VISIBLE);
            viewHolder.dateMsgLeft.setText(msg.getName()+" "+msg.getTime().substring(11));
        } else {
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.leftHead.setVisibility(View.GONE);
            viewHolder.rightHead.setVisibility(View.VISIBLE);
            viewHolder.rightMsg.setText(msg.getMsg());
            viewHolder.dateMsgLeft.setVisibility(View.GONE);
            viewHolder.dateMsgRight.setVisibility(View.VISIBLE);
            viewHolder.dateMsgRight.setText(msg.getTime().substring(11));
        }

        return view;
    }

    class ViewHolder {
        CardView leftLayout;
        CardView rightLayout;
        TextView leftMsg;
        TextView rightMsg;
//        TextView dateMsg;
        TextView dateMsgLeft;
        TextView dateMsgRight;
        ImageView leftHead;
        ImageView rightHead;
    }
}
