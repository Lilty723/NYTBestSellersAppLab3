import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nytbestsellersapp.Book

class BookAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageCover: ImageView = itemView.findViewById(R.id.imageCover)
        private val textRank: TextView = itemView.findViewById(R.id.textRank)
        private val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        private val textAuthor: TextView = itemView.findViewById(R.id.textAuthor)
        private val textDescription: TextView = itemView.findViewById(R.id.textDescription)

        fun bind(book: Book) {
            textRank.text = book.rank.toString()
            textTitle.text = book.title
            textAuthor.text = book.author
            textDescription.text = book.description
            Glide.with(itemView.context)
                .load(book.coverUrl)
                .placeholder(R.drawable.placeholder_cover)
                .into(imageCover)
        }

        inner class Glide {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }
}
