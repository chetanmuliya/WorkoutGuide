package wg.cm.workoutguide.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStorePreference(val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("set1RepsSets")
        val SET1_REPS_SET_KEY = stringPreferencesKey("set1RepsSets_key")
        val SET2_REPS_SET_KEY = stringPreferencesKey("set2RepsSets_key")
        val SET3_REPS_SET_KEY = stringPreferencesKey("set3RepsSets_key")
        val SET4_REPS_SET_KEY = stringPreferencesKey("set4RepsSets_key")
        val SET_REPS_INDEX = intPreferencesKey("setRepsIndex_key")
    }

    val getRepsWeightIndex: Flow<Int?> = context.dataStore.data
        .map {
            it[SET_REPS_INDEX] ?: 0
        }

    suspend fun saveRepsWeightIndex(value: Int){
        context.dataStore.edit {
            it[SET_REPS_INDEX] = value
        }
    }

    val getRepsWeight: Flow<String?> = context.dataStore.data
        .map {
            it[SET1_REPS_SET_KEY] ?: ""
        }

    suspend fun saveRepsWeight(value: String){
        context.dataStore.edit {
            it[SET1_REPS_SET_KEY] = value
        }
    }

    val getSet2RepsWeight: Flow<String?> = context.dataStore.data
        .map {
            it[SET2_REPS_SET_KEY] ?: ""
        }

    suspend fun saveSet2RepsWeight(value: String){
        context.dataStore.edit {
            it[SET2_REPS_SET_KEY] = value
        }
    }

    val getSet3RepsWeight: Flow<String?> = context.dataStore.data
        .map {
            it[SET3_REPS_SET_KEY] ?: ""
        }

    suspend fun saveSet3RepsWeight(value: String){
        context.dataStore.edit {
            it[SET3_REPS_SET_KEY] = value
        }
    }

    val getSet4RepsWeight: Flow<String?> = context.dataStore.data
        .map {
            it[SET4_REPS_SET_KEY] ?: ""
        }

    suspend fun saveSet4RepsWeight(value: String){
        context.dataStore.edit {
            it[SET4_REPS_SET_KEY] = value
        }
    }
}