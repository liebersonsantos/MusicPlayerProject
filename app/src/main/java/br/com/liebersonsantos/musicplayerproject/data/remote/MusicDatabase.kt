package br.com.liebersonsantos.musicplayerproject.data.remote

import br.com.liebersonsantos.musicplayerproject.data.entities.Song
import br.com.liebersonsantos.musicplayerproject.other.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java )
        } catch (e: Exception){
            emptyList()
        }
    }
}