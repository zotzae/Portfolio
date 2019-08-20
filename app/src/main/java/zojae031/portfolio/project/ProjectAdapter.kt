package zojae031.portfolio.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.project_list.view.*
import zojae031.portfolio.R
import zojae031.portfolio.data.dao.CompetitionEntity

class ProjectAdapter : RecyclerView.Adapter<ProjectAdapter.Holder>(), ProjectAdapterContract.View,
    ProjectAdapterContract.Model {
    private val lists: MutableList<CompetitionEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.project_list, parent, false))


    override fun getItemCount(): Int = lists.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    override fun clearList() {
        lists.clear()
    }

    override fun updateList(lists: Array<CompetitionEntity>) {
        this.lists.addAll(lists)
    }

    override fun notifyAdapter() {
        this.notifyDataSetChanged()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.image
        private val name = itemView.name
        private val prize = itemView.prize
        private val text = itemView.text
        private val competition = itemView.competition
        fun bind(position: Int) {
            Glide
                .with(itemView.context)
                .load(lists[position].image)
                .into(image)
            name.text = lists[position].name
            prize.text = lists[position].prize
            text.text = lists[position].text
            competition.text = lists[position].competition
        }
    }
}