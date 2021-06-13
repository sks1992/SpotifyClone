package sandeep.kumar.spoitfyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import sandeep.kumar.spoitfyclone.data.entities.Song
import sandeep.kumar.spoitfyclone.util.Constants.SONG_COLLECTION

class MusicDataBase {

    private val firestore = FirebaseFirestore.getInstance()

    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}