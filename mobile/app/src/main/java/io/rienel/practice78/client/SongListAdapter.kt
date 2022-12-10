package io.rienel.practice78.client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongListAdapter(private val songs: MutableList<Song>) :
	RecyclerView.Adapter<SongListAdapter.ViewHolder>() {
	class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val idValueTextView: TextView
		val nameValueTextView: TextView
		val lengthValueTextView: TextView
		val authorValueTextView: TextView

		init {
			idValueTextView = view.findViewById(R.id.songListItemIdValue)
			nameValueTextView = view.findViewById(R.id.songListItemNameValue)
			lengthValueTextView = view.findViewById(R.id.songListItemLengthValue)
			authorValueTextView = view.findViewById(R.id.songListItemAuthorValue)
		}

		fun onBind(song: Song) {
			idValueTextView.text = song.id.toString()
			nameValueTextView.text = song.name
			if (song.length != null) {
				val minutes = song.length / 60
				val seconds = song.length % 60
				lengthValueTextView.text = String.format(
					"%d:%d",
					minutes,
					seconds
				)
			}
			authorValueTextView.text = song.authorName
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.song_list_item, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(songs[position])
	}

	override fun getItemCount(): Int = songs.size

	fun updateSongsList(songs: List<Song>) {
		this.songs.clear()
		this.songs.addAll(songs)
		notifyDataSetChanged()
	}
}